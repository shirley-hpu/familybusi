package com.sitech.family.custqryservice.daoimpl.user;

import com.sitech.family.custqryservice.dto.mapperdto.ResSellTerm;

import java.util.Date;

public interface IResSellTerm {

    /**
     * 查询终端资源销售记录
     *
     * @param opTime,resourceNo,sellSerialNo
     * @return ResSellTerm
     */
    ResSellTerm query(Date opTime, String resourceNo, Long sellSerialNo);

}
