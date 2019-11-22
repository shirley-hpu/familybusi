package com.sitech.family.custservice.mapper;

import com.sitech.family.custservice.dto.mapperdto.GoodsSale;
import com.sitech.family.dto.ReturnDto;
import org.springframework.stereotype.Repository;

@Repository
public interface GoodsSaleMapper {

    /**
     * @param loginAccept
     * @return
     */
    void drop(Long loginAccept);

    /**
     * @param goodsSale
     * @return
     */
    void create(GoodsSale goodsSale);

    /**
     * @param loginAccept
     * @return
     */
    GoodsSale query(Long loginAccept);

    /**
     * @param goodsSale
     * @return
     */
    void modify(GoodsSale goodsSale);
}