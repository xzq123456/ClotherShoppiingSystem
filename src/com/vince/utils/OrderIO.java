package com.vince.utils;
import com.vince.bean.Order;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class OrderIO {
  private static List<Order> orders=new ArrayList<>();
  private static final String ORDER_FILE="order.obj";
 // 添加
  public void add(Order order) throws BusinessException{
        orders.add(order);
  }
  //查询订单
  public List<Order> list() throws  BusinessException{
    return  orders;
  }
   //
    public Order findOrderById(int orderId) throws BusinessException{
      Order order=null;
      int oid;
      for(Order o:orders){
          oid=o.getOrderId();
          if(oid==orderId){
              order=o;
              break;
          }
      }
      return  order;
    }
    public boolean writeorders(){
     try{
         ObjectOutputStream outputStream=new ObjectOutputStream(new FileOutputStream(ORDER_FILE));
         outputStream.writeObject(orders);
         outputStream.close();
         return true;
     }catch(IOException e){
         e.printStackTrace();
     }
     return false;
    }
    public  boolean readorders(){
        try{
            ObjectInputStream objectInputStream =new ObjectInputStream(new FileInputStream(ORDER_FILE));
            orders=(List<Order>)objectInputStream.readObject();
            objectInputStream.close();
            return true;
        }catch(IOException | ClassNotFoundException |ClassCastException  e){
            e.printStackTrace();
        }
        return false;
    }

}
