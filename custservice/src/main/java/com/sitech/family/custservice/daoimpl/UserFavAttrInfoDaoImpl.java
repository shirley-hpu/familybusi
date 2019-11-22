package com.sitech.family.custservice.daoimpl;

import com.sitech.family.constants.ReturnCode;
import com.sitech.family.custservice.daoimpl.user.IUserFavAttr;
import com.sitech.family.custservice.dto.mapperdto.UserFav;
import com.sitech.family.custservice.dto.mapperdto.UserFavAttr;
import com.sitech.family.dao.usergoods.IUserFavAttrInfoDao;
import com.sitech.family.dto.ReturnDto;
import com.sitech.family.dto.usergoods.UserFavAttrInfo;
import com.sitech.family.dto.usergoods.UserFavInfo;
import com.sitech.ijcf.boot.core.error.exception.BusiException;
import com.sitech.ijcf.boot.core.util.StringUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.sitech.family.common.errorcode.AppErrorCode.getErrorCode;

/**
 * 用户优惠参数实例
 */
@Component
public class UserFavAttrInfoDaoImpl implements IUserFavAttrInfoDao {

    @Autowired
    private IUserFavAttr userFavAttr;

    @Override
    public ReturnDto drop(BigDecimal favinsId, String attrId, Date effDate) {
        ReturnDto returnDto = new ReturnDto();

        try {
            UserFavAttr userFavAttrTemp = new UserFavAttr();
            userFavAttrTemp.setFavinsId(favinsId);

            returnDto = userFavAttr.drop(userFavAttrTemp);

            if (ReturnCode.RETURN_CODE_FAIL.getCode().equals(returnDto.getCode())) {
                returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
                returnDto.setMessage(returnDto.getMessage());
                return returnDto;
            }

        } catch (Exception e) {
            returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
            returnDto.setMessage(e.toString());
            return returnDto;
        }
        return returnDto;
    }

    @Override
    public ReturnDto create(UserFavAttrInfo userFavAttrInfo) {
        ReturnDto returnDto = new ReturnDto();

        try {
            UserFavAttr userFavAttrTemp = new UserFavAttr();
            BeanUtils.copyProperties(userFavAttrInfo, userFavAttrTemp);

            returnDto = userFavAttr.create(userFavAttrTemp);

            if (ReturnCode.RETURN_CODE_FAIL.getCode().equals(returnDto.getCode())) {
                returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
                returnDto.setMessage(returnDto.getMessage());
                return returnDto;
            }

        } catch (Exception e) {
            returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
            returnDto.setMessage(e.toString());
            return returnDto;
        }
        return returnDto;
    }

    @Override
    public List<UserFavAttrInfo> query(BigDecimal favinsId, String attrId, Date effDate) {
        if (StringUtil.isEmptyOrNull(favinsId)) {
            throw new BusiException(getErrorCode("1000", "15000"), "处理失败,参数对象不存在或为空!");
        }
        if (StringUtil.isEmptyOrNull(attrId)) {
            throw new BusiException(getErrorCode("1000", "15000"), "处理失败,参数对象不存在或为空!");
        }
        if (StringUtil.isEmptyOrNull(effDate)) {
            throw new BusiException(getErrorCode("1000", "15000"), "处理失败,参数对象不存在或为空!");
        }

        List<UserFavAttrInfo> data = new ArrayList<>();
        try {
            List<UserFavAttr> list = userFavAttr.query(favinsId, attrId, effDate);
            for (UserFavAttr source : list) {
                UserFavAttrInfo target = new UserFavAttrInfo();
                BeanUtils.copyProperties(source, target);
                data.add(target);
            }
        } catch (Exception e) {
            throw new BusiException(getErrorCode("1000", "15000"), "查询用户优惠参数实例信息失败");
        }
        return data;
    }

    @Override
    public ReturnDto modify(UserFavAttrInfo userFavAttrInfo) {
        ReturnDto returnDto = new ReturnDto();

        try {
            UserFavAttr target = new UserFavAttr();
            BeanUtils.copyProperties(userFavAttrInfo, target);
            returnDto = userFavAttr.modify(target);

            if (ReturnCode.RETURN_CODE_FAIL.getCode().equals(returnDto.getCode())) {
                returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
                returnDto.setMessage(returnDto.getMessage());
                return returnDto;
            }
        } catch (Exception e) {
            returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
            returnDto.setMessage(e.toString());
            return returnDto;
        }
        return returnDto;
    }
}
