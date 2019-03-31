package com.vince.bean;

import java.io.Serializable;
//明细表
public class OrderItem  implements Serializable {
    private int itemId;
    private Clothes clothes;//商品
    private  int shoppingNum;//购买数量
    private float num;//购买金额

    public OrderItem(int itemId, Clothes clothes, int shoppingNum, float num) {
        this.itemId = itemId;
        this.clothes = clothes;
        this.shoppingNum = shoppingNum;
        this.num = num;
    }

    public OrderItem() {
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public Clothes getClothes() {
        return clothes;
    }

    public void setClothes(Clothes clothes) {
        this.clothes = clothes;
    }

    public int getShoppingNum() {
        return shoppingNum;
    }

    public void setShoppingNum(int shoppingNum) {
        this.shoppingNum = shoppingNum;
    }

    public float getNum() {
        return num;
    }

    public void setNum(float num) {
        this.num = num;
    }
}
