package com.sitech.family.custservice.service;

import com.sitech.family.custservice.compbusi.IFamilyUserStateInfoCo;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Zhangc
 * @version 1.0
 * @date 2019/3/15 12:55
 */
@Service
public class UserStateChange {

    @Resource
    private IFamilyUserStateInfoCo familyUserStateInfoCo;

    @ResponseBody
    @GetMapping("/xxx")
    public String test(){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("ID_ NO","2019051500001");
        map.put("NEW_RUN_TIME","20190316105729");
        map.put("OP_TIME","20190316105729");
        map.put("OP_CODE","1111");
        map.put("LOGIN_NO","shanghai");
        map.put("LOGIN_ACCEPT","2");
        map.put("OP_NOTE","op");
        map.put("SYSTEM_NOTE","sys");
        map.put("CHANGE_TYPE","CTOB");
        map.put("NEW_RUN","G");
        familyUserStateInfoCo.modify(map);

        return "aaa";
    }
}
