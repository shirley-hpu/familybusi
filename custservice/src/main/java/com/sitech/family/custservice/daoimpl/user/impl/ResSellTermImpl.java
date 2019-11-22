package com.sitech.family.custservice.daoimpl.user.impl;

import com.sitech.family.common.constants.UpdateTypeEnum;
import com.sitech.family.constants.ReturnCode;
import com.sitech.family.custservice.daoimpl.user.IResSellTerm;
import com.sitech.family.custservice.dto.mapperdto.ResSellTerm;
import com.sitech.family.custservice.mapper.ResSellTermMapper;
import com.sitech.family.dto.ReturnDto;
import com.sitech.ijcf.boot.core.error.exception.BusiException;
import com.sitech.ijcf.boot.core.util.DateUtil;
import com.sitech.ijcf.boot.core.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @program: familybusi
 * @description: 终端资源销售记录信息实体实现
 * @author: yang xing
 * @create: 2018-12-20 17:28
 */
@Component
@Transactional(rollbackFor = Exception.class)
public class ResSellTermImpl implements IResSellTerm {

    @Autowired
    private ResSellTermMapper resSellTermMapper;

    /**
     * 创建终端资源销售记录
     *
     * @param resSellTerm
     * @return ReturnDto
     */
    @Override
    public ReturnDto create(ResSellTerm resSellTerm) {
        ReturnDto returnDto = new ReturnDto();

        try {
            resSellTermMapper.create(resSellTerm);
            resSellTermMapper.insert(resSellTerm);
        } catch (Exception e) {
            throw new BusiException("创建终端资源销售记录失败:" + e.getMessage());
        }

        returnDto.setCode(ReturnCode.RETURN_CODE_SUCCESS.getCode());
        return returnDto;
    }

    /**
     * 修改终端资源销售记录
     *
     * @param resSellTerm
     * @return ReturnDto
     */
    @Override
    public ReturnDto modify(ResSellTerm resSellTerm) {
        ReturnDto returnDto = new ReturnDto();

        try {
            Date opTime = resSellTerm.getOpTime();
            String resourceNo = resSellTerm.getResourceNo();
            Long sellSerialNo = resSellTerm.getSellSerialNo();

            ResSellTerm resSellTerm1 = resSellTermMapper.query(opTime,resourceNo,sellSerialNo);

            if (StringUtil.isEmptyOrNull(resSellTerm1)) {
                returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
                returnDto.setMessage("根据传入参数查询无此数据,修改终端资源销售记录失败");
                return returnDto;
            }

            resSellTerm1.setUpdateAccept(resSellTerm.getUpdateAccept());
            resSellTerm1.setUpdateType(resSellTerm.getUpdateType());
            resSellTerm1.setUpdateTime(resSellTerm.getUpdateTime());
            resSellTerm1.setUpdateDate(resSellTerm.getUpdateDate());
            resSellTerm1.setUpdateLogin(resSellTerm.getUpdateLogin());
            resSellTerm1.setUpdateCode(resSellTerm.getUpdateCode());

            resSellTermMapper.insert(resSellTerm1);

            resSellTermMapper.modify(resSellTerm);

            resSellTerm.setUpdateType(UpdateTypeEnum.VAL_X.getValue());

            resSellTermMapper.insert(resSellTerm);
        } catch (Exception e) {
            throw new BusiException("修改终端资源销售记录失败:" + e.getMessage());
        }

        returnDto.setCode(ReturnCode.RETURN_CODE_SUCCESS.getCode());
        return returnDto;
    }

    /**
     * 删除终端资源销售记录
     *
     * @param resSellTerm
     * @return ReturnDto
     */
    @Override
    public ReturnDto drop(ResSellTerm resSellTerm) {
        ReturnDto returnDto = new ReturnDto();

        try {
            Date opTime = resSellTerm.getOpTime();
            String resourceNo = resSellTerm.getResourceNo();
            Long sellSerialNo = resSellTerm.getSellSerialNo();

            ResSellTerm resSellTerm1 = resSellTermMapper.query(opTime,resourceNo,sellSerialNo);

            if (StringUtil.isEmptyOrNull(resSellTerm1)) {
                returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
                returnDto.setMessage("根据传入参数查询无此数据,删除终端资源销售记录失败");
                return returnDto;
            }

            resSellTerm1.setUpdateAccept(resSellTerm.getUpdateAccept());
            resSellTerm1.setUpdateType(resSellTerm.getUpdateType());
            resSellTerm1.setUpdateTime(resSellTerm.getUpdateTime());
            resSellTerm1.setUpdateDate(resSellTerm.getUpdateDate());
            resSellTerm1.setUpdateLogin(resSellTerm.getUpdateLogin());
            resSellTerm1.setUpdateCode(resSellTerm.getUpdateCode());

            resSellTermMapper.insert(resSellTerm1);

            resSellTermMapper.drop(resSellTerm);
        } catch (Exception e) {
            throw new BusiException("删除终端资源销售记录失败:" + e.getMessage());
        }

        returnDto.setCode(ReturnCode.RETURN_CODE_SUCCESS.getCode());
        return returnDto;
    }

    /**
     * 查询终端资源销售记录
     *
     * @param opTime,resourceNo,sellSerialNo
     * @return ReturnDto
     */
    @Override
    public ResSellTerm query(Date opTime, String resourceNo, Long sellSerialNo) {
        ResSellTerm resSellTerm = new ResSellTerm();

        try {
            resSellTerm = resSellTermMapper.query(opTime, resourceNo, sellSerialNo);
        } catch (Exception e) {
            throw new BusiException("查询终端资源销售记录失败:" + e.getMessage());
        }

        return resSellTerm;
    }

    /**
     * 查询终端资源销售记录
     *
     * @param map
     * @return List<ResSellTerm>
     */
    @Override
    public List<ResSellTerm> qryResSellTermList(Map map) {
        List<ResSellTerm> list = new ArrayList<>();

        try {
            list = resSellTermMapper.qryResSellTermList(map);
        } catch (Exception e) {
            throw new BusiException("查询终端资源销售记录失败:" + e.getMessage());
        }

        return list;
    }

    /**
     * 查询终端资源销售历史记录
     *
     * @param map
     * @return List<ResSellTerm>
     */
    @Override
    public List<ResSellTerm> qryResSellTermHisList(Map map) {
        List<ResSellTerm> list = new ArrayList<>();

        try {
            list = resSellTermMapper.qryResSellTermHisList(map);
        } catch (Exception e) {
            throw new BusiException("查询终端资源销售记录失败:" + e.getMessage());
        }

        return list;
    }
}
