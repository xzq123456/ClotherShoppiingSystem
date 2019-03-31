package com.vince.ui;

import com.vince.bean.User;
import com.vince.service.UserService;
import com.vince.service.impl.UserServiceImpl;
import com.vince.utils.BusinessException;

public class LoginClass extends BaseClass {
  public void login() throws BusinessException{
      printIn("input.username");
      String username = input.nextLine();
      printIn("input.password");
      String password=input.nextLine();
      UserService userService=new UserServiceImpl();
     User user= userService.login(username,password);
     if(user!=null){
         currentUser=user;
     }else{
         throw  new BusinessException("login.error");
     }




  }
}
