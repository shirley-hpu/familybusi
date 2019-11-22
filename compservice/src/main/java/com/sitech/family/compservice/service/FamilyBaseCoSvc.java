package com.sitech.family.compservice.service;

import com.sitech.family.compservice.inter.IFamilyBaseCoSvc;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 检测登录服务
 *
 * @author shirley
 * @date created in 2019/4/19
 */
@Service("FamilyBaseCoSvc")
@Api("检测登录服务")
public class FamilyBaseCoSvc implements IFamilyBaseCoSvc {

    private static final Logger logger = LoggerFactory.getLogger(FamilyBaseCoSvc.class);


    /**
     * 检测登录服务
     */
    @Override
    @ResponseBody
    @RequestMapping("/schkFamilyLogin")
    public void chkFamilyLogin() {

        logger.debug("==> success ");
    }
}
