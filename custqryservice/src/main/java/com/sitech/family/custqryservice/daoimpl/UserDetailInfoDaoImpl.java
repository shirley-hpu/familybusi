package com.sitech.family.custqryservice.daoimpl;

import com.sitech.family.custqryservice.daoimpl.user.IUserDetail;
import com.sitech.family.custqryservice.dto.mapperdto.UserDetail;
import com.sitech.family.dao.user.IUserInfoQryDao;
import com.sitech.family.dto.user.UserInfo;
import com.sitech.hsf.common.logger.Logger;
import com.sitech.hsf.common.logger.LoggerFactory;
import com.sitech.ijcf.boot.core.error.exception.BusiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

import static com.sitech.family.common.errorcode.AppErrorCode.getErrorCode;

/**
 * @author Zhangc
 * @version 1.0
 * @date 2019/9/16 19:04
 */
@Component
public class UserDetailInfoDaoImpl implements IUserInfoQryDao {

    private static final Logger logger = LoggerFactory.getLogger(UserDetailInfoDaoImpl.class);
    @Autowired
    private IUserDetail iUserDetail;
    @Override
    public UserInfo query(Long idNo) {
        try {
            UserDetail userDetail = iUserDetail.query(idNo);
            UserInfo userInfo = new UserInfo();
            userInfo.setIdNo(userDetail.getIdNo());
            userInfo.setRunCode(userDetail.getRunCode());
            return userInfo;
        } catch (Exception e) {
            throw new BusiException(getErrorCode("1000", "15000"), "查询家庭用户详细信息失败"+e.getMessage());
        }
    }

    @Override
    public List<UserInfo> qryUserInfoList(Map map) {
        return null;
    }

    @Override
    public List qryOrderFeeByPhoneNo(Map map) {
        return null;
    }
}
