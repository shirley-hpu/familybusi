package com.sitech.family.custqryservice.daoimpl.user.impl;

import com.sitech.family.constants.ReturnCode;
import com.sitech.family.custqryservice.daoimpl.user.IMbrPrcMid;
import com.sitech.family.custqryservice.dto.mapperdto.MbrPrcMid;
import com.sitech.family.custqryservice.mapper.IMbrPrcMidMapper;
import com.sitech.ijcf.boot.core.error.exception.BusiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.sitech.family.common.errorcode.AppErrorCode.getErrorCode;

/**
 * @author wusm
 * @description
 * @date 2019/4/17 16:51
 */
@Component
public class MbrPrcMidImpl implements IMbrPrcMid {

    @Autowired
    private IMbrPrcMidMapper mapper;


    /**
     * 查询成员订购实例
     *
     * @param map
     * @return List<MbrPrcMid>
     */
    @Override
    public List<MbrPrcMid> qryMbrPrcMidList(Map map) {
        List<MbrPrcMid> list;

        try {
            list = mapper.qryMbrPrcMidList(map);
        } catch (Exception e) {
            throw new BusiException(ReturnCode.RETURN_CODE_FAIL.getCode(), "查询成员订购实例失败" + e.getMessage());
        }

        return list;
    }

}
