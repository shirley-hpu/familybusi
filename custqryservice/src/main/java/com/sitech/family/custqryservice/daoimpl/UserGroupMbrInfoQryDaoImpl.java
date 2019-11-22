package com.sitech.family.custqryservice.daoimpl;

import com.sitech.family.custqryservice.daoimpl.user.IUserGroupMbr;
import com.sitech.family.custqryservice.dto.mapperdto.UserGroupMbr;
import com.sitech.family.dao.usergroup.IUserGroupMbrInfoQryDao;
import com.sitech.family.dto.usergroup.UserGroupMbrInfo;
import com.sitech.ijcf.boot.core.error.exception.BusiException;
import com.sitech.ijcf.boot.core.util.StringUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.sitech.family.common.errorcode.AppErrorCode.getErrorCode;

/**
 * 家庭群成员关系实体
 *
 * @author shirley
 * @date created in 2018/12/17
 */
@Service("userGroupMbrInfoQryDaoImpl")
public class UserGroupMbrInfoQryDaoImpl implements IUserGroupMbrInfoQryDao {
    /**
     * UserGroupMbr
     */
    @Autowired
    private IUserGroupMbr userGroupMbrImpl;


    @Override
    public UserGroupMbrInfo query(BigDecimal memberId) {

        if (StringUtil.isEmptyOrNull(memberId)) {
            throw new BusiException(getErrorCode("1000", "15000"), "处理失败,参数对象不存在或为空!");
        }

        try {
            UserGroupMbr userGroupMbr = userGroupMbrImpl.query(memberId);

            UserGroupMbrInfo userGroupMbrInfo = new UserGroupMbrInfo();
            userGroupMbrInfo.setEffDate(userGroupMbr.getEffDate());
            userGroupMbrInfo.setExpDate(userGroupMbr.getExpDate());
            userGroupMbrInfo.setGroupId(userGroupMbr.getGroupId());
            userGroupMbrInfo.setLoginAccept(userGroupMbr.getLoginAccept());
            userGroupMbrInfo.setLoginNo(userGroupMbr.getLoginNo());
            userGroupMbrInfo.setMemberDesc(userGroupMbr.getMemberDesc());
            userGroupMbrInfo.setMemberId(userGroupMbr.getMemberId());
            userGroupMbrInfo.setMemberName(userGroupMbr.getMemberName());
            userGroupMbrInfo.setMbrRole(userGroupMbr.getMbrRole());
            userGroupMbrInfo.setMbrType(userGroupMbr.getMbrType());
            userGroupMbrInfo.setElementId(userGroupMbr.getElementId());
            userGroupMbrInfo.setObjectId(userGroupMbr.getObjectId());
            userGroupMbrInfo.setObjectType(userGroupMbr.getObjectType());
            userGroupMbrInfo.setOpCode(userGroupMbr.getOpCode());
            userGroupMbrInfo.setOpTime(userGroupMbr.getOpTime());
            userGroupMbrInfo.setPhoneNo(userGroupMbr.getPhoneNo());
            //    userGroupMbrInfo.setRelMemberId();
            //    userGroupMbrInfo.setOpNote("");
            //    userGroupMbrInfo.setOupAccept("");
            //    userGroupMbrInfo.setSystemNote("");
            return userGroupMbrInfo;
        } catch (Exception e) {
            throw new BusiException(getErrorCode("1000", "15000"), "查询家庭用户群用户失败");
        }
    }

    @Override
    public List<UserGroupMbrInfo> qryUserGroupMbrInfoList(Map map) {
        if (StringUtil.isEmptyOrNull(map)) {
            throw new BusiException(getErrorCode("1000", "15000"), "处理失败,参数对象不存在或为空!");
        }
        List<UserGroupMbrInfo> list = new ArrayList<UserGroupMbrInfo>();
        try {
            List<UserGroupMbr> mbrList = userGroupMbrImpl.queryFamilyGroupMbr(map);
            for(UserGroupMbr mbr:mbrList){
                UserGroupMbrInfo mbrInfo = new UserGroupMbrInfo();
                BeanUtils.copyProperties(mbr,mbrInfo);
                list.add(mbrInfo);
            }
            return list;
        } catch (Exception e) {
            throw new BusiException("逻辑模型层异常:" + e.getMessage());
        }
    }
}
