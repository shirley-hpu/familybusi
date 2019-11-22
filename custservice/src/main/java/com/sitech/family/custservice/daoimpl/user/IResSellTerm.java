package com.sitech.family.custservice.daoimpl.user;

import com.sitech.family.custservice.dto.mapperdto.ResSellTerm;
import com.sitech.family.dto.ReturnDto;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface IResSellTerm {

    /**
     * 创建终端资源销售记录
     *
     * @param resSellTerm
     * @return ReturnDto
     */
    ReturnDto create(ResSellTerm resSellTerm);

    /**
     * 修改终端资源销售记录
     *
     * @param resSellTerm
     * @return ReturnDto
     */
    ReturnDto modify(ResSellTerm resSellTerm);

    /**
     * 删除终端资源销售记录
     *
     * @param resSellTerm
     * @return ReturnDto
     */
    ReturnDto drop(ResSellTerm resSellTerm);

    /**
     * 查询终端资源销售记录
     *
     * @param opTime,resourceNo,sellSerialNo
     * @return ReturnDto
     */
    ResSellTerm query(Date opTime, String resourceNo, Long sellSerialNo);

    /**
     * 查询终端资源销售记录
     *
     * @param map
     * @return List<ResSellTerm>
     */
    List<ResSellTerm> qryResSellTermList(Map map);

    /**
     * 查询终端资源销售历史记录
     *
     * @param map
     * @return List<ResSellTerm>
     */
    List<ResSellTerm> qryResSellTermHisList(Map map);

}
