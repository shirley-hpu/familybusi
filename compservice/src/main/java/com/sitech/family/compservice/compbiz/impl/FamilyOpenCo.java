package com.sitech.family.compservice.compbiz.impl;

import com.alibaba.fastjson.JSON;
import com.sitech.family.common.dto.OprInfo;
import com.sitech.family.compservice.atombiz.IFamilyOpenAo;
import com.sitech.family.compservice.atombiz.IFamilyOpenAoTest;
import com.sitech.family.compservice.compbiz.IFamilyOpenCo;
import com.sitech.family.compservice.dto.indto.*;
import com.sitech.family.compservice.dto.indto.UniOrderInfoDto.FamilyOrderItemInfoDto;
import com.sitech.ijcf.message6.dt.out.OutDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xuwei on 2019/4/22.
 * 拼接全网订单实现类
 */

@Component("FamilyOpenCoImpl")
public class FamilyOpenCo implements IFamilyOpenCo {

    @Resource
    private IFamilyOpenAo familyOpenAo;

    @Autowired
    private IFamilyOpenAoTest iFamilyOpenAoTest;

    @Override
    public OutDTO<Object> create(FamilyOpenCfmInDto familyOpenCfmInDto, OprInfo oprInfo) {

        //定义需要创送给全网订单的变量
        UniOrderInfoDto.FamilyOrderBodyInfoDto familyOrderBodyInfoDto = new UniOrderInfoDto.FamilyOrderBodyInfoDto();
        UniOrderInfoDto.FamilyOrderOprInfoDto familyOrderOprInfoDto = new UniOrderInfoDto.FamilyOrderOprInfoDto();
        UniOrderInfoDto.FamilyOrderPayInfoDto familyOrderPayInfoDto = new UniOrderInfoDto.FamilyOrderPayInfoDto();
        List<FamilyOrderItemInfoDto> orderItemList = new ArrayList<>();

        //定义需要接收入参的变量
        FamilyOpenCfmInDto familyOpenCfmInDtoOut = new FamilyOpenCfmInDto();
        //FamilyUserInfoDto familyUserInfoDto = new FamilyUserInfoDto();
        //List<FamilyMbrUserInfoInDto> familyMbrUserList = new ArrayList<>();

        //入参拆解
        //获取群和群用户信息
        FamilyUserInfoDto familyUserInfoDto = familyOpenCfmInDto.getUserInfo();

        //物流配送信息
        FamilyDeliverInfoDto familyDeliverInfo = familyUserInfoDto.getDeliverInfo();


        //设置oprinfo节点
        familyOrderOprInfoDto.setChannelType(oprInfo.getChannelType());
        familyOrderOprInfoDto.setContactId(oprInfo.getContactId());
        familyOrderOprInfoDto.setCustIdType("1"); //待确认值类型
        familyOrderOprInfoDto.setCustIdValue("13434343");//待确认值类型
        familyOrderOprInfoDto.setGroupId(oprInfo.getGroupId());
        familyOrderOprInfoDto.setLoginNo(oprInfo.getLoginNo());
        familyOrderOprInfoDto.setOutOrderId("");
        familyOrderOprInfoDto.setRegionId(oprInfo.getRegionId());
        familyOrderOprInfoDto.setRemark(oprInfo.getOpNote());
        familyOrderOprInfoDto.setServcieNO("13812121212");// 待确认值类型。

        //设置paynfo节点信息 此节点信息需要和订单人员确认最后的值。
        familyOrderPayInfoDto.setFavourableRuleId("");
        familyOrderPayInfoDto.setFavourableShareMode("");
        familyOrderPayInfoDto.setOptCode("");
        familyOrderPayInfoDto.setPayChannel("");
        familyOrderPayInfoDto.setVipId("");

        /*设置ORDERITEM_LIST 节点，此节点为List点，存放分解后的订单项
        此处需要两层循环，一层循环需要把订单项拆出来，二层循环需要把家庭成员资费拆出来。*/

        //带成员资费的整体成员信息
        List<FamilyMbrUserInfoInDto> familyMbrUserInfoInDtoList = new ArrayList<>();

        //按照添加的成员个数开始循环处理
        for (int i = 0; i < familyOpenCfmInDto.getUserGroupMbrInfoList().size(); i++) {
            UniOrderInfoDto.FamilyOrderItemInfoDto familyMbrOrderItemInfoDto = new UniOrderInfoDto.FamilyOrderItemInfoDto<FamilyMbrUserInfoInDto>();
            FamilyMbrUserInfoInDto familyMbrUserInfoInDto = familyOpenCfmInDto.getUserGroupMbrInfoList().get(i);

            //对成员信息进行复制，带成员资费的成员
            FamilyMbrUserInfoInDto familyMbrUserInfoInDtoOut = new FamilyMbrUserInfoInDto();
            BeanUtils.copyProperties(familyMbrUserInfoInDto, familyMbrUserInfoInDtoOut);

            //对成员信息进行复制，不带成员资费的成员
            FamilyMbrUserInfoInDto commonUserInfoInDtoOut = new FamilyMbrUserInfoInDto();
            BeanUtils.copyProperties(familyMbrUserInfoInDto, commonUserInfoInDtoOut);


            // 成员商品
            List<FamilyMbrGoodsInfoInDto> familyMbrGoodsInfoList = new ArrayList<>();
            // 非成员商品
            List<FamilyMbrGoodsInfoInDto> commonGoodsInfoList = new ArrayList<>();

            String openFlag = familyMbrUserInfoInDto.getOpenFlag();

            //按照商品列表开始循环处理成员资费，把每个成员涉及到家庭成员的资费和非家庭成员资费进行区分并存储在不同的节点。
            for (int j = 0; j < familyMbrUserInfoInDto.getUserGroupMbrGoodsInfoList().size(); j++) {
                String memberFlag = familyMbrUserInfoInDto.getUserGroupMbrGoodsInfoList().get(j).getMemberFlag();
                if (!memberFlag.isEmpty() && memberFlag.equals("T")) {
                    // 成员商品
                    familyMbrGoodsInfoList.add(familyMbrUserInfoInDto.getUserGroupMbrGoodsInfoList().get(j));
                } else {
                    // 非成员商品
                    commonGoodsInfoList.add(familyMbrUserInfoInDto.getUserGroupMbrGoodsInfoList().get(j));
                }
            }

            //分出每个成员的家庭资费和普通资费
            //带家庭资费的成员
            //familyMbrUserInfoInDtoOut.setUserGroupMbrGoodsInfoList(null);
            familyMbrUserInfoInDtoOut.setUserGroupMbrGoodsInfoList(familyMbrGoodsInfoList);

            //不带家庭资费的成员
            //commonUserInfoInDtoOut.setUserGroupMbrGoodsInfoList(null);
            commonUserInfoInDtoOut.setUserGroupMbrGoodsInfoList(commonGoodsInfoList);

            //把带家庭资费的成员统一加入到一个对象中
            familyMbrUserInfoInDtoList.add(familyMbrUserInfoInDtoOut);

            //判断是否是新开户的成员，新开户的成员需要单独拼一个订单项、已有成员添加时订购的资费全部带有家庭资费标识
            if (!openFlag.isEmpty() && openFlag.equals("Y")) {

                String busiType = null;
                String channelType = null;
                switch (familyOpenCfmInDto.getUserGroupMbrInfoList().get(i).getRoleId()) {
                    case "0001": //G网  实际值根据数据库配置数据取值
                        busiType = "0001"; //待确认，需要和具体的业务和对应流程确认
                        channelType = oprInfo.getChannelType(); //
                        break;
                    case "0002"://宽带  实际值根据数据库配置数据取值
                        busiType = "0002"; //待确认，需要和具体的业务和对应流程确认
                        channelType = oprInfo.getChannelType(); //
                        break;
                    case "0003": //IMS  实际值根据数据库配置数据取值
                        busiType = "0003"; //待确认，需要和具体的业务和对应流程确认
                        channelType = oprInfo.getChannelType(); //
                        break;
                    default:
                        busiType = "1000"; //待确认，需要和具体的业务和对应流程确认
                        channelType = oprInfo.getChannelType(); //
                }

                /*新开的用户全部开在家长的客户下边，所以需要把家长的ID_NO或者PHONE_NO 传给每个成员，后边获取家长的客户信息？？？*/

                familyMbrOrderItemInfoDto.setGoodsInfo(commonUserInfoInDtoOut);
                familyMbrOrderItemInfoDto.setBusiType(busiType);
                familyMbrOrderItemInfoDto.setChannelType(channelType);
                familyMbrOrderItemInfoDto.setCustIdValue("");//待确认
                UniOrderInfoDto.FamilyMbrPayItemInfoDto mbrPayItemInfoDto = new UniOrderInfoDto.FamilyMbrPayItemInfoDto();
                mbrPayItemInfoDto.setActualPayCharge(familyMbrUserInfoInDto.getPayItemInfo().getActualPayCharge());
                mbrPayItemInfoDto.setActualPayChargeType(familyMbrUserInfoInDto.getPayItemInfo().getPayType());
                mbrPayItemInfoDto.setFavourableCharge(familyMbrUserInfoInDto.getPayItemInfo().getFavourableCharge());
                mbrPayItemInfoDto.setFavourableChargeType(familyMbrUserInfoInDto.getPayItemInfo().getPayType());
                mbrPayItemInfoDto.setServiceCharge(familyMbrUserInfoInDto.getPayItemInfo().getServiceCharge());
                mbrPayItemInfoDto.setServiceChargeType(familyMbrUserInfoInDto.getPayItemInfo().getPayType());
                mbrPayItemInfoDto.setShouldPayCharge(familyMbrUserInfoInDto.getPayItemInfo().getShouldPayCharge());
                mbrPayItemInfoDto.setShouldPayChargeType(familyMbrUserInfoInDto.getPayItemInfo().getPayType());
                mbrPayItemInfoDto.setPayType(familyMbrUserInfoInDto.getPayItemInfo().getPayType());
                mbrPayItemInfoDto.setPayWay(familyMbrUserInfoInDto.getPayItemInfo().getPayWay());
                familyMbrOrderItemInfoDto.setFamilyMbrPayItemInfoDto(mbrPayItemInfoDto);
                familyMbrOrderItemInfoDto.setFamilyDeliverInfoDto(familyDeliverInfo);
                orderItemList.add(familyMbrOrderItemInfoDto); //新开户的成员单独一个订单项
            }
        }

        //把带有家庭资费成员加入到家庭订单项目的
        familyOpenCfmInDtoOut.setUserInfo(familyUserInfoDto);
        familyOpenCfmInDtoOut.setUserGroupMbrInfoList(familyMbrUserInfoInDtoList);

        //添加家庭虚拟用户和带家庭成员资费的成员订单项(家庭订单项拼接)
        UniOrderInfoDto.FamilyOrderItemInfoDto familyOpenCfmIOrderItemInfoDto = new UniOrderInfoDto.FamilyOrderItemInfoDto<FamilyOpenCfmInDto>();
        familyOpenCfmIOrderItemInfoDto.setGoodsInfo(familyOpenCfmInDtoOut);
        familyOpenCfmIOrderItemInfoDto.setBusiType("2000");//待确认家客订单行流程，需要和具体的业务和对应流程确认
        familyOpenCfmIOrderItemInfoDto.setChannelType(oprInfo.getChannelType());
        familyOpenCfmIOrderItemInfoDto.setCustIdValue("");//待确认
        familyOpenCfmIOrderItemInfoDto.setFamilyMbrPayItemInfoDto(null);// 需要确认，如果虚拟用户有支付，那么虚拟用户需要增加支付信息节点虚拟用户没有支付信息
        familyOpenCfmIOrderItemInfoDto.setFamilyDeliverInfoDto(familyDeliverInfo);
        orderItemList.add(familyOpenCfmIOrderItemInfoDto);//家庭订单项

        //拼接全网订单
        familyOrderBodyInfoDto.setFamilyOrderOprInfoDto(familyOrderOprInfoDto);
        familyOrderBodyInfoDto.setFamilyOrderPayInfoDto(familyOrderPayInfoDto);
        familyOrderBodyInfoDto.setFamilyOrderItemInfoDtoList(orderItemList);
        familyOrderBodyInfoDto.toString();

        //模拟测试全网订单服务
        OutDTO<Object> outDTO = iFamilyOpenAoTest.createUniOrderTest(familyOrderBodyInfoDto);
        //调用创建全网订单服务
        //OutDTO<Object>  outDTO= familyOpenAo.createUniOrder(familyOrderBodyInfoDto);
        return outDTO;
    }
}
