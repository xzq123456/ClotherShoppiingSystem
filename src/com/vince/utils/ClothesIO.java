package com.vince.utils;

import com.vince.bean.Clothes;

import java.util.ArrayList;
import java.util.List;

public class ClothesIO {
    private static List<Clothes>  list=new ArrayList<>();
    public Clothes findById(String  cid) throws BusinessException{
         for(Clothes c:list){
             if(c.getId().equals(cid))
                 return c;
         }
         return null;
    }
    public List<Clothes> list() throws BusinessException{
        if(list.size()==0){
            list=ProducesXmlUtils.parseProduceFromXml();
        }
            return list;
    }

    public void update() throws BusinessException{
        ProducesXmlUtils.writeProduceToXml(list);
    }

}
