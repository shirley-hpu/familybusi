package com.sitech.family.custservice.base.util;

import com.sitech.crmcui.common.sequence.client.SequenceClient;
import com.sitech.ijcf.boot.core.error.exception.BusiException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 序列获取-公共类
 *
 * @author Zhangc
 * @version 1.0
 * @date 2018/12/18 15:01
 */
@Component
public class BaseLoginAccept {

    private static final Logger logger = LoggerFactory.getLogger(BaseLoginAccept.class);

    private static Map<String, Map<String, String>> seqProperties;
    @Resource
    private SequenceClient sequenceClient;

    /**
     * @param sLabelIn  序列名
     * @param sRegionId 地市名
     * @return
     */
    private String getAccept(String sLabelIn, String sRegionId) {
        String sSeqNumber = "";

        if (seqProperties == null)
            return "";

        String sSeqName = seqProperties.get(sLabelIn).get("SEQ_NAME");
        int nType = 0;
        if (seqProperties.get(sLabelIn).containsKey("SEQ_NAME_EXT")) {
            if (seqProperties.get(sLabelIn).get("SEQ_NAME_EXT").equals("1")) {
                nType = 1;
            }
        }

        if (nType == 1) {
            // 序列以地市为后缀
            sSeqName = sSeqName + sRegionId;
        }

        try {
            sSeqNumber = sequenceClient.getNextVal(sSeqName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (seqProperties.get(sLabelIn).containsKey("SEQ_LEN")) {
            int seq_len = Integer.parseInt(seqProperties.get(sLabelIn).get("SEQ_LEN"));
            if (sSeqNumber.length() < seq_len)//返回的长度比配置的小,左补零
            {
                // 左补0
                // sSeqNumber = String.format("%"+seq_len+"s", sSeqNumber).replaceAll(" ", "0");
                // 右补0
                sSeqNumber = String.format("%-" + seq_len + "s", sSeqNumber).replaceAll(" ", "0");

            } else if (sSeqNumber.length() > seq_len) {//返回长度比配置长度大，置空
                return "";
            }
        }
        return sSeqNumber;
    }

    /**
     * 加载配置文件
     */
    static {
        try {
            String sPath = Thread.currentThread().getContextClassLoader().getResource("seq.config").getPath();
            BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(java.net.URLDecoder.decode(sPath, "UTF-8"))));
            String sConfData = null;
            String sValueData = null;
            seqProperties = new HashMap<String, Map<String, String>>();
            while ((sConfData = in.readLine()) != null) {
                if (!sConfData.equals("")) {
                    int nIdxB = sConfData.indexOf("[");
                    int nIdxE = sConfData.indexOf("]");
                    if (nIdxB != -1 && nIdxE != -1 && nIdxE > nIdxB) {
                        String sKey = sConfData.substring(nIdxB + 1, nIdxE);
                        Map<String, String> mapVal = new LinkedHashMap<String, String>();
                        while ((sValueData = in.readLine()) != null && sValueData.contains("=")) {
                            int nIdx = sValueData.indexOf("=");
                            if (nIdx != -1 && nIdx != sValueData.length() - 1) {
                                mapVal.put(sValueData.split("=")[0], sValueData.split("=")[1]);
                            }
                        }
                        seqProperties.put(sKey, mapVal);
                    }
                }
            }
            in.close();
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    final protected void clean() {
        if (seqProperties != null && seqProperties.size() > 0) {
            seqProperties.clear();
            seqProperties = null;
        }
    }

    // 获取公共流水
    public String getPubLoginAccept(Map<String, String> mapIn) {
        String sLoginAccept = "";
        String sRegionId = "";

        if (!mapIn.containsKey("ACCEPT_LABEL")) {
            throw new BusiException("221313", "缺少ACCEPT_LABEL参数");
        }
        String sLabelIn = (String) mapIn.get("ACCEPT_LABEL");
        if (mapIn.containsKey("REGION_ID")) {
            sRegionId = (String) mapIn.get("REGION_ID");
        }
        if (seqProperties != null) {
            if (seqProperties.containsKey(sLabelIn)) {
                // 获取序列值
                String sSeqNum = getAccept(sLabelIn, sRegionId);
                //logger.debug("sequence value ==> " + sSeqNum);

                if (sSeqNum == null || sSeqNum.equals("")) {
                    throw new BusiException("22313", "请检查SEQ_NAME参数或SEQ_NAME_EXT参数或SEQ_LEN参数是否配置无误");
                }
                for (Map.Entry<String, String> enty : seqProperties.get(sLabelIn).entrySet()) {
                    String sKey = enty.getKey();
                    if (sKey.equals("FIX_PREFIX")) {
                        sLoginAccept = sLoginAccept + enty.getValue();
                    } else if (sKey.equals("HAS_REGION") && Integer.parseInt(enty.getValue()) == 1) {
                        if (sRegionId == null || sRegionId.equals("")) {
                            throw new BusiException("22222", "缺少REGION_ID参数");
                        }
                        sLoginAccept = sLoginAccept + sRegionId;
                    } else if (sKey.equals("HAS_DATE")) {
                        Date nowDate = new Date();
                        SimpleDateFormat sdformat = null;
                        switch (Integer.parseInt(enty.getValue())) {
                            case 0:
                                break;
                            case 1:
                                sdformat = new SimpleDateFormat(DateConst.DATE_MODEL_100);
                                break;
                            case 2:
                                sdformat = new SimpleDateFormat(DateConst.DATE_MODEL_11);
                                break;
                            case 3:
                                sdformat = new SimpleDateFormat(DateConst.DATE_MODEL_99);
                                break;
                            case 4:
                                sdformat = new SimpleDateFormat(DateConst.DATE_MODEL_101);
                                break;
                            case 5:
                                sdformat = new SimpleDateFormat(DateConst.DATE_MODEL_102);
                                break;
                            case 6:
                                sdformat = new SimpleDateFormat(DateConst.DATE_MODEL_103);
                                break;
                            case 7:
                                sdformat = new SimpleDateFormat(DateConst.DATE_MODEL_8);
                                break;
                            case 8:
                                sdformat = new SimpleDateFormat(DateConst.DATE_MODEL_9);
                                break;
                            case 9:
                                sdformat = new SimpleDateFormat(DateConst.DATE_MODEL_10);
                                break;
                        }
                        if (sdformat != null) {
                            String sDate = sdformat.format(nowDate);
                            sLoginAccept = sLoginAccept + sDate;
                        }
                    } else if (sKey.equals("HAS_RAND")) {
                        String sRand[] = enty.getValue().split("\\|");
                        for (int m = 0; m < sRand.length; m++) {
                            if (sRand[m] != null && !sRand[m].equals("")) {
                                if (Integer.parseInt(sRand[m]) > sSeqNum.length()) {
                                    throw new BusiException("12356", "请检查HAS_RAND参数配置是否无误，数值超过序列值长度");
                                }

                                sLoginAccept = sLoginAccept + sSeqNum.charAt(Integer.parseInt(sRand[m]) - 1);
                            }
                        }
                    } else if (sKey.equals("SEQ_NAME")) {
                        sLoginAccept = sLoginAccept + sSeqNum;
                    } else if (sKey.equals("FIX_SUFFIX")) {
                        sLoginAccept = sLoginAccept + enty.getValue();
                    }
                }
            } else {
                throw new BusiException("12346", "请检查seq.properties文件中accept_label对应的序列信息");
            }
        }
        return sLoginAccept;
    }
}
