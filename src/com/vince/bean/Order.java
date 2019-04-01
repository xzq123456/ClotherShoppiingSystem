package com.vince.bean;

import com.vince.utils.OrderStatusType;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/*
* 订单表  由明细表构成
* */
public class Order implements Serializable{
    private int orderId;
    private List<OrderItem> orderItemList=new ArrayList<>();
    private String creatDate;
    private float num;//总金额
    private OrderStatusType status= OrderStatusType.UNPAID;//枚举类型
    private int userId;
    public OrderStatusType getStatus() {
        return status;
    }
    public void setStatus(OrderStatusType status){
        this.status=status;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getCreatDate() {
        return creatDate;
    }

    public void setCreatDate(String creatDate) {
        this.creatDate = creatDate;
    }

    public float getNum() {
        return num;
    }

    public void setNum(float num) {
        this.num = num;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public List<OrderItem> getOrderItemList() {
        return orderItemList;
    }

    public void setOrderItemList(List<OrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }
}
