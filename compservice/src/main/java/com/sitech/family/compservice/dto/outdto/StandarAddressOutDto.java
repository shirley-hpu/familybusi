package com.sitech.family.compservice.dto.outdto;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.List;

public class StandarAddressOutDto implements Serializable {

    @JSONField(name = "AddressLIST")
    private List<AddressListOut> addressList;

    public List<AddressListOut> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<AddressListOut> addressList) {
        this.addressList = addressList;
    }
}
