package com.vince.service.impl;

import com.vince.bean.Order;
import com.vince.service.OrderService;
import com.vince.utils.BusinessException;
import com.vince.utils.OrderIO;

import java.util.List;

public class OrderServiceImpl implements OrderService{
    private OrderIO orderIO=new OrderIO();
    @Override
    public void buyProducts(Order o) throws BusinessException {
    orderIO.add(o);
    }

    @Override
    public List<Order> list(String uid) throws BusinessException {
        return orderIO.list(uid);
    }
    public List<Order> list2() throws BusinessException {
        return orderIO.list2();
    }




    @Override
    public Order findById(int orderid) throws BusinessException {
        return orderIO.findOrderById(orderid);
    }
}
