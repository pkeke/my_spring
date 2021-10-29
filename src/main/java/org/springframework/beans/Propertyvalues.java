package org.springframework.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pke
 * @data 2021/10/28 16:57
 */
public class Propertyvalues {

    private final List<PropertyValue> propertyValueList = new ArrayList<>();

    public PropertyValue[] getPropertyVaules(){
        return this.propertyValueList.toArray(new PropertyValue[0]);
    }

    public void addPropertyValue(PropertyValue pv){
        for (int i = 0; i < this.propertyValueList.size(); i++){
            PropertyValue currentPv = this.propertyValueList.get(i);
            if (currentPv.getName().equals(pv.getName())){
                // 覆盖原有的属性值
                this.propertyValueList.set(i,pv);
                return;
            }
        }
        this.propertyValueList.add(pv);
    }

    public PropertyValue getPropertyVaule(String propertyName){
        for (int i = 0; i < propertyValueList.size(); i++){
            PropertyValue pv = propertyValueList.get(i);
            if (pv.getName().equals(propertyName)){
                return pv;
            }
        }
        return null;
    }

}
