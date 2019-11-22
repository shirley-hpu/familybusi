package com.sitech.family.custqryservice.daoimpl;

import com.sitech.family.custqryservice.daoimpl.user.IUserGroup;
import com.sitech.family.custqryservice.dto.mapperdto.UserGroup;
import com.sitech.family.dao.usergroup.IUserGroupInfoQryDao;
import com.sitech.family.dto.usergroup.UserGroupInfo;
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
 * @date 2018/12/14 16:01
 */
@Component
public class UserGroupInfoDaoImpl implements IUserGroupInfoQryDao {

    private static final Logger logger = LoggerFactory.getLogger(UserGroupInfoDaoImpl.class);

    @Autowired
    private IUserGroup userGroupImpl;

    /**
     * 查询家庭用户群用户
     *
     * @param groupId
     * @return userGroup
     */
    @Override
    public UserGroupInfo query(BigDecimal groupId) {
        if (StringUtil.isEmptyOrNull(groupId)) {
            throw new BusiException(getErrorCode("1000", "15000"), "处理失败,参数对象不存在或为空!");
        }

        try {
            UserGroup userGroup = userGroupImpl.query(groupId);

            UserGroupInfo userGroupInfo = new UserGroupInfo();

            userGroupInfo.setGroupId(userGroup.getGroupId());
            userGroupInfo.setIdNo(userGroup.getIdNo());
            userGroupInfo.setGroupCode(userGroup.getGroupCode());
            userGroupInfo.setGroupType(userGroup.getGroupType());
            userGroupInfo.setGroupName(userGroup.getGroupName());
            userGroupInfo.setGroupDesc(userGroup.getGroupDesc());
            userGroupInfo.setOpTime(userGroup.getOpTime());
            userGroupInfo.setOpCode(userGroup.getOpCode());
            userGroupInfo.setLoginNo(userGroup.getLoginNo());
            userGroupInfo.setLoginAccept(userGroup.getLoginAccept());
            //userGroupInfo.setUseAddress();
            //userGroupInfo.setOupAccept();
            //userGroupInfo.setOpNote();
            //userGroupInfo.setSystemNote();

            return userGroupInfo;
        } catch (Exception e) {
            throw new BusiException(getErrorCode("1000", "15000"), "查询家庭用户群用户失败");
        }
    }

    @Override
    public List<UserGroupInfo> qryUserGroupInfoList(Map map) {
        if (StringUtil.isEmptyOrNull(map)) {
            throw new BusiException(getErrorCode("1000", "15000"), "处理失败,参数对象不存在或为空!");
        }

        try {
            List<UserGroupInfo> list = new ArrayList<>();

            List<UserGroup> userGroupList = userGroupImpl.qryUserGroupList(map);
            if(userGroupList.size() == 0){
                list.add(new UserGroupInfo());
                return list;
            }
            for (UserGroup group : userGroupList) {
                UserGroupInfo userGroupInfo = new UserGroupInfo();
                userGroupInfo.setGroupId(group.getGroupId());
                userGroupInfo.setIdNo(group.getIdNo());
                userGroupInfo.setGroupCode(group.getGroupCode());
                userGroupInfo.setGroupType(group.getGroupType());
                userGroupInfo.setGroupName(group.getGroupName());
                userGroupInfo.setGroupDesc(group.getGroupDesc());
                userGroupInfo.setOpTime(group.getOpTime());
                userGroupInfo.setOpCode(group.getOpCode());
                userGroupInfo.setLoginNo(group.getLoginNo());
                userGroupInfo.setLoginAccept(group.getLoginAccept());
                list.add(userGroupInfo);
            }
            logger.debug("==============="+list);
            return list;

        } catch (Exception e) {
            throw new BusiException(getErrorCode("1000", "15000"), e.getMessage());
        }
    }
}
