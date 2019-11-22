package com.sitech.family.custqryservice.daoimpl;

import com.sitech.family.custqryservice.daoimpl.user.IUser;
import com.sitech.family.custqryservice.daoimpl.user.IUserDetail;
import com.sitech.family.custqryservice.dto.mapperdto.User;
import com.sitech.family.custqryservice.dto.mapperdto.UserDetail;
import com.sitech.family.dao.user.IUserInfoQryDao;
import com.sitech.family.dto.user.UserInfo;
import com.sitech.ijcf.boot.core.error.exception.BusiException;
import com.sitech.ijcf.boot.core.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.sitech.family.common.errorcode.AppErrorCode.getErrorCode;

/**
 * @author wusm
 * @description
 * @date 2018/12/14 16:59
 */
@Component
public class UserInfoDaoImpl implements IUserInfoQryDao {
    private static final Logger logger = LoggerFactory.getLogger(UserInfoDaoImpl.class);
    @Autowired
    private IUser userImpl;

    @Autowired
    private IUserDetail iUserDetail;

    /**
     * 查询家庭用户
     *
     * @param idNo
     * @return userInfo
     */
    @Override
    public UserInfo query(Long idNo) {
        if (StringUtil.isEmptyOrNull(idNo)) {
            throw new BusiException(getErrorCode("1000", "15000"), "处理失败,参数对象不存在或为空!");
        }

        try {

            User user = userImpl.query(idNo);

            logger.debug("************"+user);

            UserInfo userInfo = new UserInfo();

            if (StringUtil.isEmptyOrNull(user)){
                return userInfo;
            }
           /* userInfo.setAccessType(user.getAccessType());
            userInfo.setAssureFlag(user.getAssureFlag());
            userInfo.setBakField(user.getBakField());
            userInfo.setBakField1(user.getBakField1());
            userInfo.setBillEndTime(user.getBillEndTime());
            userInfo.setBillingCycleTypeId(user.getBillingCycleTypeId());
            userInfo.setBillStartTime(user.getBillStartTime());
            userInfo.setBilType(user.getBillType());
            userInfo.setBrandCreateType(user.getBrandCreateType());
            userInfo.setCmdRight(user.getCmdRight());
            userInfo.setCompletedDate(user.getCompletedDate());*/
//            userInfo.setContractNo(user.getContractNo());
//            userInfo.setCreateDate(user.getCreateDate());
            userInfo.setCreateLogin(user.getCreateLogin());
            userInfo.setCustId(user.getCustId());
            userInfo.setEmpGroup(user.getEmpGroup());
            userInfo.setEmpId(user.getEmpId());
            userInfo.setFinishFlag(user.getFinishFlag());
            //userInfo.setFirstUsedate(user.getFirstUsedate());
            //userInfo.setGroupFlag(user.getGroupFlag());
            userInfo.setGroupId(user.getGroupId());
            userInfo.setIdNo(user.getIdNo());
            userInfo.setLoginAccept(user.getLoginAccept());
            userInfo.setLoginNo(user.getLoginNo());
//            userInfo.setMasterServId(user.getMasterServId());
            userInfo.setOpCode(user.getOpCode());
            userInfo.setOpenTime(user.getOpenTime());
            //userInfo.setOwnedChnlId(user.getOwnedChnlId());
            userInfo.setOpTime(user.getOpTime());
//            userInfo.setOwnerType(user.getOwnerType());
            userInfo.setPhoneNo(user.getPhoneNo());
            /*userInfo.setPhotoFlag(user.getPhotoFlag());
            userInfo.setRentDate(user.getRentDate());
            userInfo.setServiceGroup(user.getServiceGroup());
            userInfo.setStopRentDate(user.getStopRentDate());*/

            UserDetail userDetail = iUserDetail.query(idNo);

            //userInfo.setCardType(userDetail.getCardType());
            //userInfo.setLmtAdjustType(userDetail.getLmtAdjustType());
            userInfo.setOldRun(userDetail.getOldRun());
            userInfo.setOpNote(userDetail.getOpNote());
            /*userInfo.setOwedFlag(userDetail.getOwedFlag());
            userInfo.setPasswdType(userDetail.getPasswdType());
            userInfo.setQueryCdrflag(userDetail.getQueryCdrflag());*/
            userInfo.setRunCode(userDetail.getRunCode());
            userInfo.setRunTime(userDetail.getRunTime());
            //userInfo.setStopFlag(userDetail.getStopFlag());
            userInfo.setSystemNote(userDetail.getSystemNote());
            //userInfo.setUserGradeCode(userDetail.getUserGradeCode());
            userInfo.setUserPasswd(userDetail.getUserPasswd());
            //userInfo.setVipCardNo(userDetail.getVipCardNo());
            //userInfo.setVipCreateType(userDetail.getVipCreateType());

            return userInfo;

        } catch (Exception e) {
            throw new BusiException(getErrorCode("1000", "15000"), "查询家庭用户失败"+e.getMessage());
        }
    }

    @Override
    public List<UserInfo> qryUserInfoList(Map map) {

        if (StringUtil.isEmptyOrNull(map)) {
            throw new BusiException(getErrorCode("1000", "15000"), "处理失败,参数对象不存在或为空!");
        }
        List<UserInfo> list = new ArrayList<>();
        try {
            List<User> userList = userImpl.qryUserList(map);

            if (userList.size() == 0 || StringUtil.isEmptyOrNull(userList)) {
                list.add(new UserInfo());
                return list;
            }
            
            for (User user : userList) {
                UserInfo userInfo = new UserInfo();

                BeanUtils.copyProperties(user,userInfo);

                list.add(userInfo);
            }

            return list;
        } catch (Exception e) {
            throw new BusiException(getErrorCode("1000", "15000"), e.getMessage());
        }
    }

    /**
     * 手机号码查询已订购附加信息
     *
     * @param map
     * @return list
     */
    @Override
    public List qryOrderFeeByPhoneNo(Map map) {
        List list = new ArrayList();

        try {
            list = userImpl.qryOrderFeeByPhoneNo(map);
        } catch (Exception e) {
            throw new BusiException("-9999", e.getMessage());
        }

        return list;
    }
}
