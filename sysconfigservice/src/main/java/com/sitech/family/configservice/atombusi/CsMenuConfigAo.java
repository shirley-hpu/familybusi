package com.sitech.family.configservice.atombusi;

import com.sitech.family.configservice.dll.dao.CsMenuConfigDao;
import com.sitech.family.configservice.dll.dto.CsMenuConfigDto;
import com.sitech.ijcf.boot.core.error.exception.BusiException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 *
 * @author Zhangc
 * @version 1.0
 * @date 2018/12/12 14:21
 */
@Component
public class CsMenuConfigAo {

    @Resource(name = "CsMenuConfigDaoimpl")
    CsMenuConfigDao csMenuConfigDao;

    public List<CsMenuConfigDto> qryMenuList(String ownerBottom){
        List<CsMenuConfigDto> menuConfig;
        menuConfig = csMenuConfigDao.findMenuByBottom(ownerBottom);
        if (menuConfig.size()==0){
            throw new BusiException( "15002", "未查询到底座信息！");
        }
        return menuConfig;
    }
}
