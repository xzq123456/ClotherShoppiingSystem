package com.vince.ui;

import com.vince.utils.BusinessException;
import com.vince.utils.UserIO;

public class WelcomeClass extends BaseClass {
  public void start(){
      printIn(getString("info.welcome"));
      //将存放对象的user.obj读入，用来做登陆验证
      UserIO userIO=new UserIO();
      userIO.readUsers();
      boolean flag=true;
      while(flag){
          printIn(getString("info.login.reg"));
          printIn(getString("info.select"));
          String select = input.nextLine();
          switch (select){
              case "1":
                 try {
                     //printIn("登陆");
                     new LoginClass().login();
                     flag=false;
                     printIn("login.success");
                 }catch (BusinessException e){
                     printIn(getString("login.error"));
                 }
                  break;
              case "2":

//                  printIn("注册");
                   try{
                       new RegisterClass().register();
                       printIn("reg.success");
                       flag=true;
                   }catch(BusinessException e){
                       printIn(getString("reg.error"));
                   }
                  break;
              default:
                  printIn(getString("input.error"));
                  break;
          }
      }
      HomeClass homeClass =new HomeClass();
      homeClass.show();
  }
}
