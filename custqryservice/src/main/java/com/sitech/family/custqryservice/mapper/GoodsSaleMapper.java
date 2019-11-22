package com.sitech.family.custqryservice.mapper;

import com.sitech.family.custqryservice.dto.mapperdto.GoodsSale;
import org.springframework.stereotype.Repository;

@Repository
public interface GoodsSaleMapper {

    /**
     * @param loginAccept
     * @return
     */
    GoodsSale query(Long loginAccept);

}