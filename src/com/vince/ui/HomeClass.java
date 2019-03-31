package com.vince.ui;
import com.vince.bean.Clothes;
import com.vince.service.ClothesService;
import com.vince.service.impl.ClothesServiceImpl;
import com.vince.utils.ConsoleTable;
import java.util.List;

public class HomeClass extends BaseClass {
    public void show(){
         showProducts();
         printIn("welcome"+currentUser.getUsername());
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
                     buyProducts();
                     flag=false;
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
        ClothesService clothesService=new ClothesServiceImpl();
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
    private  void buyProducts(){

    }

}
