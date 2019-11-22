package com.sitech.family.custqryservice.daoimpl;

import com.sitech.family.common.constants.InsTypeEnum;
import com.sitech.family.common.constants.RelationTypeEnum;
import com.sitech.family.common.constants.RelopTypeEnum;
import com.sitech.family.custqryservice.daoimpl.user.IUserGoods;
import com.sitech.family.custqryservice.daoimpl.user.IUserGoodsRel;
import com.sitech.family.custqryservice.daoimpl.user.IUserPrc;
import com.sitech.family.custqryservice.daoimpl.user.IUserSvcTrace;
import com.sitech.family.custqryservice.dto.mapperdto.UserGoods;
import com.sitech.family.custqryservice.dto.mapperdto.UserGoodsRel;
import com.sitech.family.custqryservice.dto.mapperdto.UserPrc;
import com.sitech.family.custqryservice.dto.mapperdto.UserSvcTrace;
import com.sitech.family.dao.usergoods.IUserGoodsInfoQryDao;
import com.sitech.family.dto.usergoods.UserGoodsInfo;
import com.sitech.ijcf.boot.core.error.exception.BusiException;
import com.sitech.ijcf.boot.core.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.sitech.family.common.errorcode.AppErrorCode.getErrorCode;

/**
 * @author wusm
 * @description
 * @date 2018/12/17 11:46
 */
@Component
public class UserGoodsInfoDaoImpl implements IUserGoodsInfoQryDao {

    private static final Logger logger = LoggerFactory.getLogger(UserGoodsInfoDaoImpl.class);

    @Autowired
    private IUserGoods userGoodsImpl;

    @Autowired
    private IUserGoodsRel userGoodsRelImpl;

    @Autowired
    private IUserSvcTrace userSvcTraceImpl;

    @Autowired
    private IUserPrc userPrcImpl;

    /**
     * 查询家庭商品订购信息
     *
     * @return userGoodsInfo
     */
    @Override
    public UserGoodsInfo query(BigDecimal goodsinsId, BigDecimal relgoodsinsId, BigDecimal svcinsId, BigDecimal prodprcinsId, Long loginAccept) {

        try {
            /**
             * 用户商品订购实例信息查询
             */
            UserGoods userGoods  = userGoodsImpl.query(goodsinsId);

            UserGoodsInfo userGoodsInfo = new UserGoodsInfo();
            userGoodsInfo.setIdNo(userGoods.getIdNo());
            //userGoodsInfo.setInsType();
            //userGoodsInfo.setInsValue();
            //userGoodsInfo.setParInsId();
            //userGoodsInfo.setOtherInsId();
            //userGoodsInfo.setRelInsId();
            userGoodsInfo.setMainFlag(userGoods.getGoodsMainFlag());
            userGoodsInfo.setGoodsId(userGoods.getGoodsId());
            userGoodsInfo.setPrcId(userGoods.getPrcId());
            userGoodsInfo.setEffDate(userGoods.getEffDate());
            userGoodsInfo.setExpDate(userGoods.getExpDate());
            userGoodsInfo.setOrderDate(userGoods.getOrderDate());
            userGoodsInfo.setOpTime(userGoods.getOpTime());
            userGoodsInfo.setOpCode(userGoods.getOpCode());
            userGoodsInfo.setLoginNo(userGoods.getLoginNo());
            //userGoodsInfo.setOupAccept();
            userGoodsInfo.setLoginAccept(userGoods.getLoginAccept());
            //userGoodsInfo.setOpNote();
            userGoodsInfo.setSystemNote(userGoods.getRemark());

            /**
             *查询用户商品实例关系
             */
            UserGoodsRel userGoodsRel  = userGoodsRelImpl.query(goodsinsId,relgoodsinsId,loginAccept);

            userGoodsInfo.setRelopType(userGoodsRel.getRelopType());
            userGoodsInfo.setRelationType(userGoodsRel.getRelationType());

            /**
             * 查询服务实例轨迹信息
             */
            UserSvcTrace userSvcTrace  = userSvcTraceImpl.query(svcinsId);

            userGoodsInfo.setSvcId(userSvcTrace.getSvcId());

            /**
             * 查询用户订购产品资费实例信息
             */
            UserPrc userPrc  = userPrcImpl.query(prodprcinsId);

            userGoodsInfo.setProdId(userPrc.getProdId());

            return userGoodsInfo;

        } catch (Exception e) {
            throw new BusiException(getErrorCode("1000", "15000"), "查询家庭商品订购信息失败");
        }
    }

    @Override
    public List<UserGoodsInfo> qryUserGoodsInfoList(Map map) {
        if (StringUtil.isEmptyOrNull(map)) {
            throw new BusiException(getErrorCode("1000", "15000"), "处理失败,参数对象不存在或为空!");
        }

        try {
                List<UserGoodsInfo> list = new ArrayList<>();

                if(map.size() == 1 && !StringUtil.isEmptyOrNull(map.get("idNo"))){
                    UserGoodsInfo userGoodsInfo = new UserGoodsInfo();

                    UserGoods userGoods = userGoodsImpl.qryFamilyUserBasicInfo(map);
                    logger.debug(">>>>>>>>>>>>>>>"+userGoods);
                    if(!StringUtil.isEmptyOrNull(userGoods)){
                        BeanUtils.copyProperties(userGoods,userGoodsInfo);
                        userGoodsInfo.setInsValue(userGoods.getGoodsinsId());
                    }

                    list.add(userGoodsInfo);
                    return  list;
                }
            //TODO 待物理层方法修改好后


            return null;
        } catch (Exception e) {
            throw new BusiException("逻辑模型层异常:" + e.getMessage());
        }
    }

    @Override
    public List<UserGoodsInfo> qryUserGoodsList(Map map){

        if (StringUtil.isEmptyOrNull(map)) {
            throw new BusiException("-9999", "处理失败,参数对象不存在或为空!");
        }

        List<UserGoodsInfo> userGoodsInfoList = new ArrayList<UserGoodsInfo>();
        try {
            List<UserGoods> userGoodsList = userGoodsImpl.qryUserGoodsList(map);

            if (StringUtil.isNotEmptyOrNull(userGoodsList)) {
                for (UserGoods userGoods : userGoodsList) {
                    UserGoodsInfo userGoodsInfo = new UserGoodsInfo();
                    userGoodsInfo.setOpNote("1");
                    userGoodsInfo.setOupAccept("1");
                    userGoodsInfo.setRelInsId(1L);
                    userGoodsInfo.setOtherInsId(null);
                    userGoodsInfo.setParInsId(null);
                    userGoodsInfo.setInsValue(userGoods.getGoodsinsId());
                    userGoodsInfo.setInsType(InsTypeEnum.VAL_1.getValue());
                    userGoodsInfo.setIdNo(userGoods.getIdNo());
                    userGoodsInfo.setProdId("1");
                    userGoodsInfo.setRelationType(RelationTypeEnum.VAL_7.getValue());
                    userGoodsInfo.setRelopType(RelopTypeEnum.VAL_A.getValue());
                    userGoodsInfo.setLoginAccept(userGoods.getLoginAccept());
                    userGoodsInfo.setOpCode(userGoods.getOpCode());
                    userGoodsInfo.setOpTime(userGoods.getOpTime());
                    userGoodsInfo.setLoginNo(userGoods.getLoginNo());
                    userGoodsInfo.setSystemNote("1");
                    userGoodsInfo.setGoodsId(userGoods.getGoodsId());
                    userGoodsInfo.setPrcId(userGoods.getPrcId());
                    userGoodsInfo.setOrderDate(userGoods.getOrderDate());
                    userGoodsInfo.setMainFlag(userGoods.getGoodsMainFlag());
                    userGoodsInfo.setStateDate(userGoods.getStateDate());
                    userGoodsInfo.setExpDate(userGoods.getExpDate());
                    userGoodsInfo.setEffDate(userGoods.getEffDate());

                    userGoodsInfoList.add(userGoodsInfo);
                }
            }

            return userGoodsInfoList;
        } catch (Exception e) {
            return new ArrayList<UserGoodsInfo>();
        }
    }
}
