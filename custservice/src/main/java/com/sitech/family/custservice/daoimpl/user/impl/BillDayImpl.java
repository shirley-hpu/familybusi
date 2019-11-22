package com.sitech.family.custservice.daoimpl.user.impl;

import com.sitech.family.common.constants.UpdateTypeEnum;
import com.sitech.family.constants.ReturnCode;
import com.sitech.family.custservice.daoimpl.user.IBillDay;
import com.sitech.family.custservice.dto.mapperdto.BillDay;
import com.sitech.family.custservice.mapper.IBillDayMapper;
import com.sitech.family.dto.ReturnDto;
import com.sitech.ijcf.boot.core.error.exception.BusiException;
import com.sitech.ijcf.boot.core.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

import static com.sitech.family.common.errorcode.AppErrorCode.getErrorCode;

/**
 * @author wusm
 * @description 结账日信息
 * @date 2018/12/20 18:01
 */
@Component
@Transactional(rollbackFor = Exception.class)
public class BillDayImpl implements IBillDay {

    @Autowired
    private IBillDayMapper mapper;

    /**
     * 创建结账日信息
     *
     * @param billDay
     * @return returnDto
     */
    @Override
    public ReturnDto create(BillDay billDay) {
        ReturnDto returnDto = new ReturnDto();

        try {
            //数据入正表
            mapper.create(billDay);

            //数据入历史表
            mapper.insert(billDay);
        } catch (Exception e) {
            throw new BusiException(getErrorCode("1000", "15000"), "增加结账日信息失败" + e.getMessage());
        }

        returnDto.setCode(ReturnCode.RETURN_CODE_SUCCESS.getCode());
        returnDto.setMessage("创建结账日信息成功");
        return returnDto;
    }

    /**
     * 更新结账日信息
     *
     * @param billDay
     * @return returnDto
     */
    @Override
    public ReturnDto modify(BillDay billDay) {
        ReturnDto returnDto = new ReturnDto();

        try {
            Long idNo = billDay.getIdNo();
            Date effDate = billDay.getEffDate();
            Long contractNo = billDay.getContractNo();
            String billDay1 = billDay.getBillDay();

            BillDay billDay2 = mapper.query(idNo, effDate, contractNo, billDay1);

            if (StringUtil.isEmptyOrNull(billDay2)) {
                returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
                returnDto.setMessage("根据传入参数查询无此数据,修改结账日信息失败");
                return returnDto;
            }

            billDay2.setUpdateAccept(billDay.getUpdateAccept());
            billDay2.setUpdateType(billDay.getUpdateType());
            billDay2.setUpdateTime(billDay.getUpdateTime());
            billDay2.setUpdateDate(billDay.getUpdateDate());
            billDay2.setUpdateLogin(billDay.getUpdateLogin());
            billDay2.setUpdateCode(billDay.getUpdateCode());

            mapper.insert(billDay2);

            mapper.modify(billDay);

            billDay.setUpdateType(UpdateTypeEnum.VAL_X.getValue());

            mapper.insert(billDay);
        } catch (Exception e) {
            throw new BusiException(getErrorCode("1000", "15000"), "修改结账日信息失败" + e.getMessage());
        }

        returnDto.setCode(ReturnCode.RETURN_CODE_SUCCESS.getCode());
        returnDto.setMessage("修改结账日信息成功");
        return returnDto;
    }

    /**
     * 删除结账日信息
     *
     * @param billDay
     * @return returnDto
     */
    @Override
    public ReturnDto drop(BillDay billDay) {
        ReturnDto returnDto = new ReturnDto();

        try {
            Long idNo = billDay.getIdNo();
            Date effDate = billDay.getEffDate();
            Long contractNo = billDay.getContractNo();
            String billDay1 = billDay.getBillDay();

            BillDay billDay2 = mapper.query(idNo, effDate, contractNo, billDay1);

            if (StringUtil.isEmptyOrNull(billDay2)) {
                returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
                returnDto.setMessage("根据传入参数查询无此数据,删除结账日信息失败");
                return returnDto;
            }

            billDay2.setUpdateAccept(billDay.getUpdateAccept());
            billDay2.setUpdateType(billDay.getUpdateType());
            billDay2.setUpdateTime(billDay.getUpdateTime());
            billDay2.setUpdateDate(billDay.getUpdateDate());
            billDay2.setUpdateLogin(billDay.getUpdateLogin());
            billDay2.setUpdateCode(billDay.getUpdateCode());

            mapper.insert(billDay2);

            mapper.drop(billDay);
        } catch (Exception e) {
            throw new BusiException(getErrorCode("1000", "15000"), "删除结账日信息失败" + e.getMessage());
        }

        returnDto.setCode(ReturnCode.RETURN_CODE_SUCCESS.getCode());
        returnDto.setMessage("删除结账日信息成功");
        return returnDto;
    }

    /**
     * 查询结账日信息
     *
     * @param idNo,effDate,contractNo,billDay
     * @return BillDay
     */
    @Override
    public BillDay query(Long idNo, Date effDate, Long contractNo, String billDay) {
        BillDay billDay1 = new BillDay();

        try {
            billDay1 = mapper.query(idNo, effDate, contractNo, billDay);
        } catch (Exception e) {
            throw new BusiException(getErrorCode("1000", "15000"), "查询结账日信息失败" + e.getMessage());
        }

        return billDay1;
    }

    /**
     * 查询结账日信息
     *
     * @param map
     * @return List<BillDay>
     */
    @Override
    public List<BillDay> qryBillDayList(Map map) {
        List<BillDay> list = new ArrayList<BillDay>();

        try {
            list = mapper.qryBillDayList(map);
        } catch (Exception e) {
            throw new BusiException(getErrorCode("1000", "15000"), "查询结账日信息失败" + e.getMessage());
        }

        return list;
    }

    /**
     * 查询历史表结账日信息
     *
     * @param map
     * @return List<BillDay>
     */
    @Override
    public List<BillDay> qryBillDayHisList(Map map) {
        List<BillDay> list = new ArrayList<BillDay>();

        try {
            list = mapper.qryBillDayHisList(map);
        } catch (Exception e) {
            throw new BusiException(getErrorCode("1000", "15000"), "查询结账日信息失败" + e.getMessage());
        }

        return list;
    }
}
