package com.vince.ui;

import com.vince.bean.User;
import com.vince.service.UserService;
import com.vince.service.impl.UserServiceImpl;
import com.vince.utils.BusinessException;

//注册类
public class RegisterClass extends BaseClass {
 public void register() throws BusinessException {
     printIn("input.username");
     String username = input.nextLine();
     printIn("input.password");
     String password=input.nextLine();
     User user=new User(username,password);
     UserService userService=new UserServiceImpl();
     userService.register(user);
 }
}
