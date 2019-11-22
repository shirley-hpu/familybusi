package com.sitech.family.custqryservice.daoimpl.user.impl;

import com.sitech.family.custqryservice.daoimpl.user.IUserAdd;
import com.sitech.family.custqryservice.dto.mapperdto.UserAdd;
import com.sitech.family.custqryservice.mapper.IUserAddMapper;
import com.sitech.ijcf.boot.core.error.exception.BusiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import static com.sitech.family.common.errorcode.AppErrorCode.getErrorCode;

/**
 * @author wusm
 * @description
 * @date 2018/12/20 11:13
 */
@Component
@Transactional(rollbackFor = Exception.class)
public class UserAddImpl implements IUserAdd {

    @Autowired
    private IUserAddMapper mapper;

    /**
     * 查询用户扩展属性信息
     *
     * @param idNo,fieldCode
     * @return UserAdd
     */
    @Override
    public UserAdd query(Long idNo, String fieldCode) {
        UserAdd userAdd = new UserAdd();
        try {
            userAdd = mapper.query(idNo, fieldCode);
        } catch (Exception e) {
            throw new BusiException(getErrorCode("1000", "15000"), "查询用户扩展属性信息失败" + e.getMessage());
        }
        return userAdd;
    }

}
