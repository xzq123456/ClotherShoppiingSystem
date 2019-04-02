package com.vince.ui;

import com.vince.bean.User;
import java.util.ResourceBundle;
import java.util.Scanner;
//界面的基类  定义一些方法
public abstract class BaseClass {
    protected  static Scanner input=new Scanner(System.in);
    protected  static User currentUser;//当前用户对象 很有用 就像网站的session一样 记录用户 方便获取各种信息
    //国际化 res 文件中，可以将定义的表示转化为各国语言  只需要修改run.bat就可以
    private static ResourceBundle r=ResourceBundle.getBundle("com.vince.res.r");
    public static String getString(String key){
        return r.getString(key);
    }
    public static void printIn(String s){
        System.out.println(s);
    }
    public static void print(String s){
        System.out.print(s);
    }


}
