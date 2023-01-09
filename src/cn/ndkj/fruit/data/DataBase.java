package cn.ndkj.fruit.data;

import cn.ndkj.fruit.bean.FruitItem;

import java.util.ArrayList;

public class DataBase {
    public static ArrayList<FruitItem> data=new ArrayList<FruitItem>();
    //初始数据
    static {
        data.add(new FruitItem("1","苹果",10.0,"斤"));
    }
}
