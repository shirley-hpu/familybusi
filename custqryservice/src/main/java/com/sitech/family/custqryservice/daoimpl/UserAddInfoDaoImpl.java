package com.sitech.family.custqryservice.daoimpl;

import com.sitech.family.custqryservice.daoimpl.user.IUserAdd;
import com.sitech.family.custqryservice.dto.mapperdto.UserAdd;
import com.sitech.family.dao.user.IUserAddInfoQryDao;
import com.sitech.family.dto.user.UserAddInfo;
import com.sitech.ijcf.boot.core.error.exception.BusiException;
import com.sitech.ijcf.boot.core.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

import static com.sitech.family.common.errorcode.AppErrorCode.getErrorCode;

/**
 * @author wusm
 * @description
 * @date 2018/12/14 17:56
 */
@Component
public class UserAddInfoDaoImpl implements IUserAddInfoQryDao {

    @Autowired
    private IUserAdd userAdd;

    /**
     * 查询家庭用户附加信息
     *
     * @return userAddInfo
     */
    @Override
    public UserAddInfo query(Long idNo, String fieldCode) {
        if (StringUtil.isEmptyOrNull(idNo)) {
            throw new BusiException(getErrorCode("1000", "15000"), "处理失败,参数对象不存在或为空!");
        }
        if (StringUtil.isEmptyOrNull(fieldCode)) {
            throw new BusiException(getErrorCode("1000", "15000"), "处理失败,参数对象不存在或为空!");
        }

        try {

            UserAdd userAddOne = userAdd.query(idNo, fieldCode);

            UserAddInfo userAddInfo = new UserAddInfo();
            userAddInfo.setIdNo(userAddOne.getIdNo());
            userAddInfo.setOpTime(userAddOne.getOpTime());
            userAddInfo.setOtherValue(userAddOne.getOtherValue());
            userAddInfo.setOpNote(userAddOne.getOpNote());
            userAddInfo.setOpCode(userAddOne.getOpCode());
            userAddInfo.setLoginNo(userAddOne.getLoginNo());
            userAddInfo.setSystemNote(userAddOne.getSystemNote());
            userAddInfo.setFieldValue(userAddOne.getFieldValue());
            userAddInfo.setFieldCode(userAddOne.getFieldCode());
            userAddInfo.setBusiType(userAddOne.getBusiType());
            userAddInfo.setFieldOrder(userAddOne.getFieldOrder());
            userAddInfo.setLoginAccept(userAddOne.getLoginAccept());
            return userAddInfo;

        } catch (Exception e) {
            throw new BusiException(getErrorCode("1000", "15000"), "查询家庭用户附加信息失败");
        }
    }

    @Override
    public List<UserAddInfo> qryUserAddInfoList(Map map) {
        if (StringUtil.isEmptyOrNull(map)) {
            throw new BusiException(getErrorCode("1000", "15000"), "处理失败,参数对象不存在或为空!");
        }

        try {
            //TODO 待物理层方法修改好后


            return null;
        } catch (Exception e) {
            throw new BusiException("逻辑模型层异常:" + e.getMessage());
        }
    }
}
