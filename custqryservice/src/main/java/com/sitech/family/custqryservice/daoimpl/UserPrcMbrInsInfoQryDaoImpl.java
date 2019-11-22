package com.sitech.family.custqryservice.daoimpl;

import com.sitech.family.custqryservice.daoimpl.user.IUserPrcMbrIns;
import com.sitech.family.custqryservice.dto.mapperdto.UserPrcMbrIns;
import com.sitech.family.dao.usergroup.IUserPrcMbrInsInfoQryDao;
import com.sitech.family.dto.usergroup.UserPrcMbrInsInfo;
import com.sitech.ijcf.boot.core.error.exception.BusiException;
import com.sitech.ijcf.boot.core.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import static com.sitech.family.common.errorcode.AppErrorCode.getErrorCode;

/**
 * 家庭订购实例与成员实例关系
 *
 * @author shirley
 * @date created in 2018/12/17
 */
@Service("userPrcMbrInsInfoQryDaoImpl")
public class UserPrcMbrInsInfoQryDaoImpl implements IUserPrcMbrInsInfoQryDao {

    /**
     * UserPrcMbrIns
     */
    @Autowired
    private IUserPrcMbrIns userPrcMbrInsImpl;

    @Override
    public UserPrcMbrInsInfo query(BigDecimal memberId, BigDecimal prodPrcInsId) {

        if (StringUtil.isEmptyOrNull(memberId) || StringUtil.isEmptyOrNull(prodPrcInsId)) {
            throw new BusiException(getErrorCode("1000", "15000"), "处理失败,参数对象不存在或为空!");
        }

        try {
            UserPrcMbrIns userPrcMbrIns = userPrcMbrInsImpl.query(memberId,prodPrcInsId);

            UserPrcMbrInsInfo userPrcMbrInsInfo = new UserPrcMbrInsInfo();
            userPrcMbrInsInfo.setExpDate(userPrcMbrIns.getExpDate());
            userPrcMbrInsInfo.setIdNo(userPrcMbrIns.getIdNo());
            userPrcMbrInsInfo.setLoginAccept(userPrcMbrIns.getLoginAccept());
            userPrcMbrInsInfo.setLoginNo(userPrcMbrIns.getLoginNo());
            userPrcMbrInsInfo.setMemberId(userPrcMbrIns.getMemberId());
            userPrcMbrInsInfo.setOpCode(userPrcMbrIns.getOpCode());
            userPrcMbrInsInfo.setOpTime(userPrcMbrIns.getOpTime());
            userPrcMbrInsInfo.setProdPrcInsId(userPrcMbrIns.getProdPrcInsId());
            //    userPrcMbrInsInfo.setOpNote("");
            //    userPrcMbrInsInfo.setOupAccept("");
            //    userPrcMbrInsInfo.setSystemNote("");

            return userPrcMbrInsInfo;
        } catch (Exception e) {
            throw new BusiException(getErrorCode("1000", "15000"), "查询家庭用户失败");
        }
    }

    @Override
    public List<UserPrcMbrInsInfo> qryUserPrcMbrInsInfoList(Map map) {
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
