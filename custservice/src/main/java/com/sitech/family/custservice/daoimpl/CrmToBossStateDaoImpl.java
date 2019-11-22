package com.sitech.family.custservice.daoimpl;

import com.sitech.family.custservice.daoimpl.user.ICrmToBossState;
import com.sitech.family.custservice.dto.mapperdto.CrmToBossState;
import com.sitech.family.dao.user.ICrmToBossStateDao;
import com.sitech.family.dto.ReturnDto;
import com.sitech.family.dto.user.CrmToBossStateInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Zhangc
 * @version 1.0
 * @date 2019/3/13 13:46
 */
@Component
public class CrmToBossStateDaoImpl implements ICrmToBossStateDao {
    @Autowired
    private ICrmToBossState crmToBossStateAo;

    @Override
    public ReturnDto create(CrmToBossStateInfo crmToBossStateInfo) {
        ReturnDto returnDto = new ReturnDto();
        CrmToBossState crmToBossStateTmp = new CrmToBossState();
        BeanUtils.copyProperties(crmToBossStateInfo,crmToBossStateTmp);
        crmToBossStateAo.create(crmToBossStateTmp);
        return returnDto;
    }

    @Override
    public ReturnDto modify(CrmToBossStateInfo crmToBossStateInfo) {
        ReturnDto returnDto = new ReturnDto();
        CrmToBossState crmToBossStateTmp = new CrmToBossState();
        BeanUtils.copyProperties(crmToBossStateInfo,crmToBossStateTmp);
        crmToBossStateAo.modify(crmToBossStateTmp);
        return returnDto;
    }

    @Override
    public CrmToBossStateInfo query(CrmToBossStateInfo crmToBossStateInfo) {
    //    CrmToBossState crmToBossStateTmp = new CrmToBossState();
    //    BeanUtils.copyProperties(crmToBossStateInfo,crmToBossStateTmp);
    //    CrmToBossState entityPhysical = crmToBossStateAo.query(crmToBossStateTmp);
        CrmToBossStateInfo entityLogical = new CrmToBossStateInfo();
    //    BeanUtils.copyProperties(entityPhysical,entityLogical);
        return entityLogical;
    }
}
