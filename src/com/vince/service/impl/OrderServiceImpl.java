package com.vince.service.impl;

import com.vince.bean.Order;
import com.vince.service.OrderService;
import com.vince.utils.BusinessException;

import java.util.List;

public class OrderServiceImpl implements OrderService{
    @Override
    public void buyProducts(Order o) throws BusinessException {
    }

    @Override
    public List<Order> list() throws BusinessException {
        return null;
    }

    @Override
    public Order findById(int orderid) throws BusinessException {
        return null;
    }
}