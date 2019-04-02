package com.vince.utils;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.Xpp3Driver;
import com.vince.bean.Clothes;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

//xml转换工具类 （需要用Maven导入相关的依赖包 放在lib目录下 要保证网速不错）
public class ProducesXmlUtils {
    //将product.xml文件解析成为Clothes 集合返回
    public static List<Clothes> parseProduceFromXml(){
        List<Clothes> products=new ArrayList<>();
        XStream xStream =new XStream(new Xpp3Driver());
        xStream.alias("list",products.getClass());
        xStream.alias("clothes",Clothes.class);
        xStream.useAttributeFor(Clothes.class,"id");
        try{
            //读取xml文件
            BufferedInputStream inputStream =new BufferedInputStream(new FileInputStream("products2.xml"));
            products=(List<Clothes>)xStream.fromXML(inputStream);
            inputStream.close();

        }catch(IOException e){
            e.printStackTrace();
        }
        return  products;
    }
    //修改xml文件
    public static void writeProduceToXml(List<Clothes> products){
        XStream xStream =new XStream(new Xpp3Driver());
        xStream.alias("list",products.getClass());
        xStream.alias("clothes",Clothes.class);
        xStream.useAttributeFor(Clothes.class,"id");
        try{
            BufferedOutputStream outputStream =
                    new BufferedOutputStream(new FileOutputStream("products2.xml"));
            //先把第一行写进去（其实就是覆盖）
        outputStream.write("<?xml version=\"1.0\" encoding=\"utf-8\" ?>".getBytes());
        xStream.toXML(products,outputStream);
        outputStream.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
