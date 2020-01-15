package com.wucstone.utils;

import com.alibaba.fastjson.JSONObject;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Xml2JsonUtil {


    public static void main(String[] args) {
        String str = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><SalesDetail><serviceType>01</serviceType><transactionID>01000011160509160101</transactionID><oriTransactionID>01000011160509160100</oriTransactionID><pointTransactionID>01000011160501249911</pointTransactionID><storeID>000017</storeID><posID>01</posID><amountTotal>120.05</amountTotal><payTypeList type=\"array\"><payType><type>10101</type><amountRequest>100.05</amountRequest><amountProcessed>90.05</amountProcessed><userAccount>oAgIDtzhoD7ECdgXXXXXXXX--7rw</userAccount></payType><payType><type>00000</type><amountRequest>20</amountRequest><amountProcessed>20</amountProcessed><userAccount></userAccount></payType></payTypeList><accountCode>123451111111111</accountCode><itemDetailList type=\"array\"><itemDetail><itemID>700760</itemID><itemBarcode>1301111456543</itemBarcode><quantity>12</quantity><originalPrice>10.00</originalPrice><promotionDetailList type=\"array\"><promotionDetail><promotionType>01</promotionType><promotionNO>0001</promotionNO><promotionNumber>2</promotionNumber><promotionAmount>5</promotionAmount></promotionDetail><promotionDetail><promotionType>02</promotionType><promotionNO></promotionNO><promotionNumber>3</promotionNumber><promotionAmount>10.00</promotionAmount></promotionDetail></promotionDetailList></itemDetail><itemDetail><itemID>100170</itemID><itemBarcode>1301111451245</itemBarcode><quantity>1</quantity><originalPrice>0.50</originalPrice><promotionDetailList type=\"array\"><promotionDetail><promotionType>01</promotionType><promotionNO>000</promotionNO><promotionNumber>1</promotionNumber><promotionAmount>2.00</promotionAmount></promotionDetail></promotionDetailList></itemDetail></itemDetailList><transactionDate>20180724</transactionDate><transactionTime>173912233</transactionTime><tokenID>BCD45XXXXXXXXXX</tokenID></SalesDetail>";
        System.out.println(xml2JSON(str));


    }

    /**
     * 转换一个xml格式的字符串到json格式
     * @param xml
     * @return 成功反回json 格式的字符串;失败反回null
     */
    public static String xml2JSON(String xml) {
        JSONObject obj = new JSONObject();
        try {
            InputStream is = new ByteArrayInputStream(xml.getBytes("utf-8"));
            SAXBuilder sb = new SAXBuilder();
            Document doc = sb.build(is);
            Element root = doc.getRootElement();
            obj.put(root.getName(), iterateElement(root));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj.toString();
    }
    /**
     * 转换一个xml格式的字符串到map
     * @param xml
     * @return 成功反回map 格式的字符串;失败反回null
     */
    public static Map xml2Map(String xml) {
        HashMap map = new HashMap();
        try {
            InputStream is = new ByteArrayInputStream(xml.getBytes());
            SAXBuilder sb = new SAXBuilder();
            Document doc = sb.build(is);
            Element root = doc.getRootElement();
            map.put(root.getName(), iterateElement(root));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    /**
     * 一个迭代方法
     * @param element
     *  org.jdom.Element
     * @return java.util.Map 实例
     */
    @SuppressWarnings("unchecked")
    private static Map iterateElement(Element element) {
        List node = element.getChildren();
        Element et = null;
        Map obj = new HashMap();
        for (int i = 0; i < node.size(); i++) {
            et = (Element) node.get(i);
            //有子节点
            if (et.getTextTrim().equals("")) {
                if (obj.containsKey(et.getName())) {
                    List list = new LinkedList();
                    if(HashMap.class.equals(obj.get(et.getName()).getClass())){
                        list.add(obj.get(et.getName()));
                    }else{
                        list = (List) obj.get(et.getName());
                    }
                    list.add(iterateElement(et));
                    obj.put(et.getName(), list);
                }else{
                    obj.put(et.getName(), iterateElement(et));
                }
                //叶子节点
            } else {
                if (obj.containsKey(et.getName())) {
                    List list = (List) obj.get(et.getName());
                    list.add(et.getTextTrim());
                    obj.put(et.getName(), list);

                }else{
                    obj.put(et.getName(), et.getTextTrim());
                }
            }
        }
        return obj;
    }
}
