package com.sitech.family.configservice.dll.dao;

import com.sitech.family.configservice.dll.dto.CsMenuConfigDto;

import java.util.List;

/**
 * @author Zhangc
 * @version 1.0
 * @date 2018/12/12 15:44
 */
public interface CsMenuConfigDao {
    public List<CsMenuConfigDto> findMenuByBottom(String ownerBottom);
}
