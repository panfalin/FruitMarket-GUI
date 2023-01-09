package cn.ndkj.fruit.services;

import cn.ndkj.fruit.bean.FruitItem;
import cn.ndkj.fruit.dao.AdminDao;

import java.util.ArrayList;

//管理员服务类，窗口界面中进行查询，添加，删除和修改等操作
public class AdminService {
    private AdminDao adminDao=new AdminDao();
    //查询服务
    public ArrayList<FruitItem> queryFruitItem()
    {
        //调用Dao层获取所有的数据方法获取所有数据
        ArrayList<FruitItem>data=adminDao.queryAllData();
        return  data;
    }
    //添加服务
    public boolean addFruitItem(String number,String name,String price,String unit)
    {
        //调用Dao层获取所有的数据方法获取所有数据
        ArrayList<FruitItem> data=queryFruitItem();
        //使用输入的编号与所有数据对比
        for (int i=0;i<data.size();i++)
        {
            FruitItem fruitItem=data.get(i);
            //如果存在重复编号水果信息，则添加失败
            if (number.equals(fruitItem.getNumber()))
            {
                return false;
            }
        }
        //如果没有重复编号，将数据封装为FruitItem对象
        FruitItem thisFruitItem=new FruitItem(number,name,Double.parseDouble(price),unit);
        //调用Dao层的添加数据方法
        adminDao.addFruitItem(thisFruitItem);
        return true;
    }
    //修改
    public boolean updateFruitItem(String number,String name,String price,String unit)
    {
        //调用Dao层获取所有的数据方法获取所有数据
        ArrayList<FruitItem>data=queryFruitItem();
        //使用输入的编号与所有数据对比
        for (int i=0;i<data.size();i++)
        {
            //如果存在相同的编号，可以修改
            FruitItem fruitItem=data.get(i);
            if (number.equals(fruitItem.getNumber()))
            {
                //调用Dao层删除指令编号数据方法
                adminDao.delFruitItem(number);
                //如果没有重复编号的数据，将数据封装为FruitItem对象
                FruitItem thisFruitItem=new FruitItem(number,name,Double.parseDouble(price),unit);
                //调用Dao层添加数据方法
                adminDao.addFruitItem(thisFruitItem);
                return true;
            }
        }
        return false;
    }
    //删除服务
    public boolean deleteFruitItem(String delNumber)
    {
        //调用Dao层获取所有的数据方法获取所有数据
        ArrayList<FruitItem>data=queryFruitItem();
        //使用输入的编号与所有数据对比
        for (int i=0;i<data.size();i++)
        {
            //如果存在相同的编号，可以删除
            FruitItem fruitItem=data.get(i);
            if (delNumber.equals(fruitItem.getNumber()))
            {
                //调用Dao层删除指定编号数据方法
                adminDao.delFruitItem(delNumber);
                return true;
            }
        }
        return false;
    }
    //条件查询
    public ArrayList<FruitItem> queryFruitByCon(FruitItem fruitItem)
    {
        ArrayList<FruitItem> fruitItems=adminDao.queryFruitByCon(fruitItem);
        return fruitItems;
    }
}
