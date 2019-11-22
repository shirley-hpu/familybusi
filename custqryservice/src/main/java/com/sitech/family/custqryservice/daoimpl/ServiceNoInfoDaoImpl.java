package com.sitech.family.custqryservice.daoimpl;

import com.sitech.family.custqryservice.daoimpl.user.IServiceNo;
import com.sitech.family.custqryservice.dto.mapperdto.ServiceNo;
import com.sitech.family.dao.user.IServiceNoInfoQryDao;
import com.sitech.family.dto.user.UserServiceNoInfo;
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
 * @date 2018/12/14 17:22
 */
@Component
public class ServiceNoInfoDaoImpl implements IServiceNoInfoQryDao {

    @Autowired
    private IServiceNo serviceNoImpl;

    /**
     * 查询家庭用户状态
     *
     * @return userServiceNoInfo
     */
    @Override
    public UserServiceNoInfo query(String serviceNo, Long idNo, String serviceType) {

        if (StringUtil.isEmptyOrNull(serviceNo)) {
            throw new BusiException(getErrorCode("1000", "15000"), "处理失败,参数对象不存在或为空!");
        }
        if (StringUtil.isEmptyOrNull(idNo)) {
            throw new BusiException(getErrorCode("1000", "15000"), "处理失败,参数对象不存在或为空!");
        }
        if (StringUtil.isEmptyOrNull(serviceType)) {
            throw new BusiException(getErrorCode("1000", "15000"), "处理失败,参数对象不存在或为空!");
        }

        try {

            ServiceNo serviceNoQry = serviceNoImpl.query(idNo, serviceNo, serviceType);

            UserServiceNoInfo userServiceNoInfo = new UserServiceNoInfo();
            userServiceNoInfo.setServiceNo(serviceNoQry.getServiceNo());
            userServiceNoInfo.setServiceType(serviceNoQry.getServiceType());
            userServiceNoInfo.setOpCode(serviceNoQry.getOpCode());
            userServiceNoInfo.setLoginNo(serviceNoQry.getLoginNo());
            userServiceNoInfo.setIdNo(serviceNoQry.getIdNo());
            userServiceNoInfo.setLoginAccept(serviceNoQry.getLoginAccept());
            userServiceNoInfo.setOpTime(serviceNoQry.getOpTime());
            return userServiceNoInfo;

        } catch (Exception e) {
            throw new BusiException(getErrorCode("1000", "15000"), "查询家庭用户状态失败");
        }
    }

    @Override
    public List<UserServiceNoInfo> qryUserServiceNoInfoList(Map map) {
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
