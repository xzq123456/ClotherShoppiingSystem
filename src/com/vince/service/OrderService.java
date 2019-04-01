package com.vince.service;

import com.vince.bean.Order;
import com.vince.utils.BusinessException;
import java.util.List;

public interface OrderService {
    public void buyProducts(Order o) throws BusinessException;
    public List<Order> list(String uid) throws BusinessException;
    public Order findById(int orderid) throws BusinessException;
    public List<Order> list2() throws BusinessException;
}
