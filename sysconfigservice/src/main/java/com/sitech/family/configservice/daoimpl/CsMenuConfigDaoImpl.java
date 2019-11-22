package com.sitech.family.configservice.daoimpl;

import com.sitech.family.configservice.dll.dao.CsMenuConfigDao;
import com.sitech.family.configservice.dll.dto.CsMenuConfigDto;
import com.sitech.family.configservice.mapper.ReqInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Zhangc
 * @version 1.0
 * @date 2018/12/12 15:46
 */
@Service("CsMenuConfigDaoimpl")
public class CsMenuConfigDaoImpl implements CsMenuConfigDao {

    @Autowired
    ReqInfoMapper reqInfoMapper;
    @Override
    public List<CsMenuConfigDto> findMenuByBottom(String ownerBottom) {
        List<CsMenuConfigDto> menuConfig = reqInfoMapper.qryMenuList(ownerBottom);
        return menuConfig;
    }
}
