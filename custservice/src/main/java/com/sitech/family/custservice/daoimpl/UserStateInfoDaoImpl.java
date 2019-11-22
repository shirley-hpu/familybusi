package com.sitech.family.custservice.daoimpl;

import com.sitech.family.custservice.base.util.BaseLoginAccept;
import com.sitech.family.custservice.base.util.SequenceConst;
import com.sitech.family.custservice.base.util.StringUtils;
import com.sitech.family.custservice.daoimpl.user.IUserState;
import com.sitech.family.custservice.dto.mapperdto.UserState;
import com.sitech.family.dao.user.IUserStateInfoDao;
import com.sitech.family.dto.ReturnDto;
import com.sitech.family.dto.user.UserStateInfo;
import com.sitech.ijcf.boot.core.error.exception.BusiException;
import com.sitech.ijcf.boot.core.util.StringUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.sitech.family.common.errorcode.AppErrorCode.getErrorCode;

/**
 * @author wusm
 * @description
 * @date 2018/12/14 14:28
 */
@Component
public class UserStateInfoDaoImpl implements IUserStateInfoDao {

    @Autowired
    private IUserState iUserState;
    @Resource
    private BaseLoginAccept baseLoginAccept;

    /**
     * 新增家庭用户状态变化
     *
     * @param userStateInfo
     */
    @Override
    public ReturnDto create(UserStateInfo userStateInfo) {
        ReturnDto returnDto = new ReturnDto();
        //正表中插入新数据
        // 获取序列号
        Map<String, String> accept = new HashMap<String, String>();
        accept.put("ACCEPT_LABEL", SequenceConst.SEQ_NAME1);
        String stateChangeNo = baseLoginAccept.getPubLoginAccept(accept);
        userStateInfo.setStateChangeNo(StringUtils.castToLong(stateChangeNo));
        UserState userState = new UserState();
        BeanUtils.copyProperties(userStateInfo, userState);
        iUserState.create(userState);
        return returnDto;
    }

    /**
     * 修改家庭用户状态变化
     *
     * @param userStateInfo
     */
    @Override
    public ReturnDto modify(UserStateInfo userStateInfo) {
        ReturnDto returnDto = new ReturnDto();
        UserState userState = new UserState();
        BeanUtils.copyProperties(userStateInfo, userState);
        iUserState.modify(userState);
        create(userStateInfo);
        return returnDto;
    }

    /**
     * 删除家庭用户状态变化
     *
     * @param userStateInfo
     */
    @Override
    public ReturnDto drop(UserStateInfo userStateInfo) {
        ReturnDto returnDto = new ReturnDto();

        return returnDto;
    }

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
