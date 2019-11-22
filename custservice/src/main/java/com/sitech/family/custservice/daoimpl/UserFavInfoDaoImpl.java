package com.sitech.family.custservice.daoimpl;

import com.sitech.family.constants.ReturnCode;
import com.sitech.family.custservice.daoimpl.user.IUserFav;
import com.sitech.family.custservice.dto.mapperdto.*;
import com.sitech.family.dao.usergoods.IUserFavInfoDao;
import com.sitech.family.dto.ReturnDto;
import com.sitech.family.dto.usergoods.UserFavInfo;
import com.sitech.ijcf.boot.core.error.exception.BusiException;
import com.sitech.ijcf.boot.core.util.StringUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static com.sitech.family.common.errorcode.AppErrorCode.getErrorCode;

/**
 * 用户优惠参数实例信息
 */
@Component
public class UserFavInfoDaoImpl implements IUserFavInfoDao {

    @Autowired
    private IUserFav userFav;

    @Override
    public ReturnDto drop(BigDecimal favinsId) {
        ReturnDto returnDto = new ReturnDto();

        try {
            UserFav userFavTemp = new UserFav();
            userFavTemp.setFavinsId(favinsId);

            returnDto = userFav.drop(userFavTemp);

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
    public ReturnDto create(UserFavInfo record) {
        ReturnDto returnDto = new ReturnDto();

        try {
            UserFav userFavTemp = new UserFav();
            BeanUtils.copyProperties(record, userFavTemp);

            returnDto = userFav.create(userFavTemp);

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
    public List<UserFavInfo> query(BigDecimal favinsId) {
        if (StringUtil.isEmptyOrNull(favinsId)) {
            throw new BusiException(getErrorCode("1000", "15000"), "处理失败,参数对象不存在或为空!");
        }

        List<UserFavInfo> data = new ArrayList<>();
        try {
            List<UserFav> list = userFav.query(favinsId);
            for (UserFav source : list) {
                UserFavInfo target = new UserFavInfo();
                BeanUtils.copyProperties(source, target);
                data.add(target);
            }
        } catch (Exception e) {
            throw new BusiException(getErrorCode("1000", "15000"), "查询用户优惠参数实例信息失败");
        }
        return data;
    }

    @Override
    public ReturnDto modify(UserFavInfo record) {
        ReturnDto returnDto = new ReturnDto();

        try {
            UserFav target = new UserFav();
            BeanUtils.copyProperties(record, target);
            returnDto = userFav.modify(target);

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
