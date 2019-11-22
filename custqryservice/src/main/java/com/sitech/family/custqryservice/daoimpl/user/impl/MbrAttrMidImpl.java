package com.sitech.family.custqryservice.daoimpl.user.impl;

import com.sitech.family.constants.ReturnCode;
import com.sitech.family.custqryservice.daoimpl.user.IMbrAttrMid;
import com.sitech.family.custqryservice.dto.mapperdto.MbrAttrMid;
import com.sitech.family.custqryservice.mapper.IMbrAttrMidMapper;
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
 * @date 2019/4/17 16:52
 */
@Component
public class MbrAttrMidImpl implements IMbrAttrMid {

    @Autowired
    private IMbrAttrMidMapper mapper;


    /**
     * 查询成员订购属性实例
     *
     * @param map
     * @return List<MbrAttrMid>
     */
    @Override
    public List<MbrAttrMid> qryMbrAttrMidList(Map map) {
        List<MbrAttrMid> list;

        try {
            list = mapper.qryMbrAttrMidList(map);
        } catch (Exception e) {
            throw new BusiException(ReturnCode.RETURN_CODE_FAIL.getCode(), "查询成员订购属性实例失败" + e.getMessage());
        }

        return list;
    }


}
