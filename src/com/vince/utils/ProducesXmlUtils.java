package com.vince.utils;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.Xpp3Driver;
import com.vince.bean.Clothes;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProducesXmlUtils {
    public static List<Clothes> parseProduceFromXml(){
        List<Clothes> products=new ArrayList<>();
        XStream xStream =new XStream(new Xpp3Driver());
        xStream.alias("list",products.getClass());
        xStream.alias("clothes",Clothes.class);
        xStream.useAttributeFor(Clothes.class,"id");
        try{
            BufferedInputStream inputStream =new BufferedInputStream(new FileInputStream("products2.xml"));
            products=(List<Clothes>)xStream.fromXML(inputStream);
            inputStream.close();

        }catch(IOException e){
            e.printStackTrace();
        }
        return  products;
    }
    public static void writeProduceToXml(List<Clothes> products){
        XStream xStream =new XStream(new Xpp3Driver());
        xStream.alias("list",products.getClass());
        xStream.alias("clothes",Clothes.class);
        xStream.useAttributeFor(Clothes.class,"id");
        try{
            BufferedOutputStream outputStream =
                    new BufferedOutputStream(new FileOutputStream("products2.xml"));
        outputStream.write("<?xml version=\"1.0\" encoding=\"utf-8\" ?>".getBytes());
        xStream.toXML(products,outputStream);
        outputStream.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
