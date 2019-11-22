package com.sitech.family.custqryservice.daoimpl;

import com.sitech.family.custqryservice.daoimpl.user.ICrmToBossState;
import com.sitech.family.custqryservice.daoimpl.user.IUserState;
import com.sitech.family.dao.user.IUserStateInfoQryDao;
import com.sitech.family.dto.user.UserStateInfo;
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
 * @date 2018/12/14 14:28
 */
@Component
public class UserStateInfoDaoImpl implements IUserStateInfoQryDao {

    @Autowired
    private IUserState userStateImpl;

    @Autowired
    private ICrmToBossState crmToBossStateImpl;

    /**
     * 查询家庭用户状态变化
     *
     * @param stateChangeNo
     * @return userStateInfo
     */
    @Override
    public UserStateInfo query(Long stateChangeNo) {
        if (StringUtil.isEmptyOrNull(stateChangeNo)) {
            throw new BusiException(getErrorCode("1000", "15000"), "处理失败,参数对象不存在或为空!");
        }


        return null;
    }

    @Override
    public List<UserStateInfo> qryUserStateInfoList(Map map) {
        return null;
    }
}
