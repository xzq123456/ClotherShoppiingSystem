package com.vince.service;

import com.vince.bean.Clothes;
import com.vince.utils.BusinessException;
import  java.util.List;
public interface ClothesService {
    //显示商品列表
    public  List<Clothes> list() throws BusinessException;
    //按照商品Id查找商品
    public Clothes findById(String cid) throws BusinessException;
    //更新商品信息
    public void update() throws  BusinessException;
}
