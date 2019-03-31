package com.vince.ui;
import com.vince.bean.Clothes;
import com.vince.bean.Order;
import com.vince.bean.OrderItem;
import com.vince.service.ClothesService;
import com.vince.service.OrderService;
import com.vince.service.impl.ClothesServiceImpl;
import com.vince.service.impl.OrderServiceImpl;
import com.vince.utils.BusinessException;
import com.vince.utils.ConsoleTable;
import com.vince.utils.DateUtils;
import  java.util.Date;

import java.util.List;

public class HomeClass extends BaseClass {
    private OrderService orderService =new OrderServiceImpl();
    private ClothesService  clothesService=new ClothesServiceImpl();

    public void show(){
         showProducts();
         printIn("welcome   "+currentUser.getUsername());
         boolean flag=true;
         while(flag){
             printIn(getString("home.function"));
             printIn(getString("info.select"));
             String select = input.nextLine();
             switch (select){
                 case "1"://查询全部订单
                     findList();
                     flag=false;
                     break;
                 case "2"://查找订单
                     findOrderById();
                     flag=false;
                     break;
                 case "3"://购买
                     try {
                         buyProducts();
                         flag = false;

                     }catch (BusinessException e){
                         getString(e.getMessage());
                     }
                     break;
                 case "0":
                     flag=false;
                     System.exit(0);
                     break;
                     default:
                         printIn("input.error");
                         break;
             }

         }
    }

    private void showProducts() {
        List<Clothes> clothes=clothesService.list();
        ConsoleTable t = new ConsoleTable(8, true);
        t.appendRow();
        t.appendColum("id")
                .appendColum("brand")
                .appendColum("style")
                .appendColum("color")
                .appendColum("size")
                .appendColum("num")
                .appendColum("price")
                .appendColum("description");
        for (Clothes c:clothes){
            t.appendRow();
            t.appendColum(c.getId())
                    .appendColum(c.getBrand())
                    .appendColum(c.getStyle())
                    .appendColum(c.getColor())
                    .appendColum(c.getSize())
                    .appendColum(c.getNum())
                    .appendColum(c.getPrice())
                    .appendColum(c.getDescription());
        }
        printIn(t.toString());

    }
    private  void findList(){

    }
    private void  findOrderById(){

    }
    private  void buyProducts() throws BusinessException {
        //生成订单
        boolean flag=true;
        int count=1;//计数器
        Order order=new Order();//生成的订单
        float sum=0.0f;//总金额
        while(flag){
            printIn(getString("product.input.id"));
            String id = input.nextLine();
            printIn(getString("product.input.shoppingNum"));
            String shoppingNum=input.nextLine();
            OrderItem orderItem=new OrderItem();
            Clothes clothes=clothesService.findById(id);
            int num=Integer.parseInt(shoppingNum);
            if(num>clothes.getNum()){
                   throw  new BusinessException("product.num.error");
            }
           //减库存
            clothes.setNum(clothes.getNum()-num);
        //一条订单明细
            orderItem.setShoppingNum(num);
            orderItem.setNum(clothes.getPrice()*num);
            sum+=orderItem.getNum();
            orderItem.setItemId(count++);
            order.getOrderItemList().add(orderItem);

            printIn(getString("product.buy.continue"));
            String  isBuy=input.nextLine();
            switch(isBuy) {
                case "1":
                    flag = true;
                    break;
                case "2":
                    flag = false;
                    break;
                    default:
                        break;
            }
        }
        order.setCreatDate(DateUtils.toDate(new Date()));
        order.setUserId(currentUser.getId());
        order.setNum(sum);
        order.setOrderId(orderService.list().size()+1);
        orderService.buyProducts(order);
        clothesService.update();
        showProducts();
    }

}
