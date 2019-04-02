package com.vince.service;

import com.vince.bean.Order;
import com.vince.utils.BusinessException;
import java.util.List;

public interface OrderService {
    //购买商品
    public void buyProducts(Order o) throws BusinessException;
    //显示用户自己的订单
    public List<Order> list(String uid) throws BusinessException;
    //根据订单Id查找订单
    public Order findById(int orderid) throws BusinessException;
    //显示所有的订单列表
    public List<Order> list2() throws BusinessException;
}
