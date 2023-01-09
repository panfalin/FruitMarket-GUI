package cn.ndkj.fruit.controller;

import cn.ndkj.fruit.bean.FruitItem;
import cn.ndkj.fruit.services.AdminService;
import cn.ndkj.fruit.view.AbstractAdminDialog;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.util.ArrayList;

//管理员操作类
public class AdminDialogController extends AbstractAdminDialog {
    //定义服务类，提供完整功能服务
    private AdminService adminService=new AdminService();
    //构造方法
    public AdminDialogController()
    {
        super();
    }
    //有参构造方法
    public AdminDialogController(Frame owrer,boolean modal)
    {
        super(owrer,modal);
        //创建对象时展示数据
        queryFruitItem();
    }
    //查询方法
    public void queryFruitItem()
    {
        String[] thead={"水果编号","水果名称","水果单价（/元）","计价单位"};
        //调用adminService的查询服务
        ArrayList<FruitItem>dataList=adminService.queryFruitItem();
        //list2Array方法，将查询的的集合转为数组，更方便给Jtable赋值
        String [][]tbody=list2Array(dataList);
        TableModel tableModel=new DefaultTableModel(tbody,thead);
        table.setModel(tableModel);
    }
    //集合数据转换为二维数组方法
    public String[][]list2Array(ArrayList<FruitItem> List)
    {
        String [][] tbody=new String[List.size()][4];
        for (int i=0;i<List.size();i++)
        {
            FruitItem fruitItem=List.get(i);
            tbody[i][0]=fruitItem.getNumber();
            tbody[i][1]=fruitItem.getName();
            tbody[i][2]=fruitItem.getPrice()+"";
            tbody[i][3]=fruitItem.getUnit();
        }
        return tbody;
    }
    //添加方法
    public void addFruitItem()
    {
        //获取数据
        String addNumber=addNumberText.getText();
        String addName=addNameText.getText();
        String addPrice=addPriceText.getText();
        String addUnit=addUnitText.getText();
        //调用adminServic添加服务
        boolean addSuccess=adminService.addFruitItem(addNumber,addName,addPrice,addUnit);
        //如果添加成功
        if (addSuccess)
        {
            //添加到表格，相当于刷新表格数据
            queryFruitItem();
        }
        else
            {
                JOptionPane.showMessageDialog(this,"水果编号不能重复，请检查数据");
            }
    }
    //修改方法
    public void updateFruitItem()
    {
        //获取数据
        String updateNumber=updateNumberText.getText();
        String updateName=updateNameText.getText();
        String updatePrice=updatePriceText.getText();
        String updateUnit=updateUnitText.getText();
        //调用adminServic修改服务
        boolean updateSuccess=adminService.updateFruitItem(updateNumber,updateName,updatePrice,updateUnit);
        //如果修改成功
        if (updateSuccess)
        {
            //刷新表格数据
            queryFruitItem();
        }
        else
            //没有修改成功，弹出错误提示信息
        {
            JOptionPane.showMessageDialog(this,"没有这个编号水果，请检查数据");
        }
    }
    //删除方法
    public void deleteFruitItem()
    {
        //获取数据
        String deleteNumber=deleteNumberText.getText();
        //调用adminServic删除服务
        boolean deleteSuccess=adminService.deleteFruitItem(deleteNumber);
        if (deleteSuccess)
        {
            queryFruitItem();
        }
        else{
            JOptionPane.showMessageDialog(this,"没有这个编号水果，请检查数据");
        }
    }
    //条件查询
    public void queryFruitItemForCon()
    {
        //获取数据
        String number=queryNumberText.getText().trim();
        String name=queryNameText.getText().trim();
        String price=queryPriceText.getText().trim();
        String unit=queryUnitText.getText().trim();
        try{
            FruitItem fruitItem=new FruitItem();
            fruitItem.setNumber(number);
            fruitItem.setName(name);
            if (price==null || price.length()==0)
            {
                fruitItem.setPrice(0);
            }
            else
            {fruitItem.setPrice(Double.parseDouble(price));}
            fruitItem.setUnit(unit);
            ArrayList<FruitItem> fruitItems=adminService.queryFruitByCon(fruitItem);
            String []thead=new String[]{"水果编号","水果名称","水果单价（/元）","计价单位"};
            String[][]tbody=list2Array(fruitItems);
            TableModel data=new DefaultTableModel(tbody,thead);
            table.setModel(data);
        }catch (NumberFormatException e)
        {JOptionPane.showMessageDialog(this,"单价数据格式有误，请检查数据");}
        finally {
            queryNumberText.setText("");
            queryNameText.setText("");
            queryPriceText.setText("");
            queryUnitText.setText("");
        }
    }
}
