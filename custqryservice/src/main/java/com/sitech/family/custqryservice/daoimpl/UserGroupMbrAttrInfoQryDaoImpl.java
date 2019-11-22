package com.sitech.family.custqryservice.daoimpl;

import com.sitech.family.custqryservice.daoimpl.user.IUserGroupMbrAttr;
import com.sitech.family.custqryservice.dto.mapperdto.UserGroupMbrAttr;
import com.sitech.family.dao.usergroup.IUserGroupMbrAttrInfoQryDao;
import com.sitech.family.dto.usergroup.UserGroupMbrAttrInfo;
import com.sitech.ijcf.boot.core.error.exception.BusiException;
import com.sitech.ijcf.boot.core.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static com.sitech.family.common.errorcode.AppErrorCode.getErrorCode;

/**
 * 家庭群成员属性
 *
 * @author shirley
 * @date created in 2018/12/17
 */
@Service("userGroupMbrAttrInfoQryDaoImpl")
public class UserGroupMbrAttrInfoQryDaoImpl implements IUserGroupMbrAttrInfoQryDao {

    /**
     * UserGroupMbrAttr
     */
    @Autowired
    private IUserGroupMbrAttr userGroupMbrAttrImpl;


    @Override
    public UserGroupMbrAttrInfo query(BigDecimal memberId, String attrId, String attrNo, Date effDate) {

        if (StringUtil.isEmptyOrNull(memberId)) {
            throw new BusiException(getErrorCode("1000", "15000"), "处理失败,参数对象不存在或为空!");
        }
        if (StringUtil.isEmptyOrNull(attrId)) {
            throw new BusiException(getErrorCode("1000", "15000"), "处理失败,参数对象不存在或为空!");
        }
        if (StringUtil.isEmptyOrNull(attrNo)) {
            throw new BusiException(getErrorCode("1000", "15000"), "处理失败,参数对象不存在或为空!");
        }
        if (StringUtil.isEmptyOrNull(effDate)) {
            throw new BusiException(getErrorCode("1000", "15000"), "处理失败,参数对象不存在或为空!");
        }

        try {
            UserGroupMbrAttr userGroupMbrAttrTemp = new UserGroupMbrAttr();
            userGroupMbrAttrTemp.setMemberId(memberId);
            userGroupMbrAttrTemp.setAttrId(attrId);
            userGroupMbrAttrTemp.setAttrNo(attrNo);
            userGroupMbrAttrTemp.setEffDate(effDate);
            UserGroupMbrAttr userGroupMbrAttr = userGroupMbrAttrImpl.query(memberId, attrId, effDate, attrNo);

            UserGroupMbrAttrInfo userGroupMbrAttrInfo = new UserGroupMbrAttrInfo();
            userGroupMbrAttrInfo.setAttrId(userGroupMbrAttr.getAttrId());
            userGroupMbrAttrInfo.setAttrNo(userGroupMbrAttr.getAttrNo());
            userGroupMbrAttrInfo.setAttrValue(userGroupMbrAttr.getAttrValue());
            userGroupMbrAttrInfo.setEffDate(userGroupMbrAttr.getEffDate());
            userGroupMbrAttrInfo.setExpDate(userGroupMbrAttr.getExpDate());
            userGroupMbrAttrInfo.setGrpNo(userGroupMbrAttr.getGrpNo());
            userGroupMbrAttrInfo.setLoginAccept(userGroupMbrAttr.getLoginAccept());
            userGroupMbrAttrInfo.setLoginNo(userGroupMbrAttr.getLoginNo());
            userGroupMbrAttrInfo.setMemberId(userGroupMbrAttr.getMemberId());
            userGroupMbrAttrInfo.setOpCode(userGroupMbrAttr.getOpCode());
            userGroupMbrAttrInfo.setOpTime(userGroupMbrAttr.getOpTime());
            //    userGroupMbrAttrInfo.setOpNote("");
            //    userGroupMbrAttrInfo.setOupAccept("");
            //    userGroupMbrAttrInfo.setSystemNote("");

            return userGroupMbrAttrInfo;
        } catch (Exception e) {
            throw new BusiException(getErrorCode("1000", "15000"), "查询家庭用户群用户失败");
        }
    }

    @Override
    public List<UserGroupMbrAttrInfo> qryUserGroupMbrAttrInfoList(Map map) {
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
