package cn.ndkj.fruit.bean;

public class FruitItem {
    //属性
    private String number;
    private String name;
    private double price;
    private String unit;
    //有参构造方法
    public FruitItem(String number, String name, double price, String unit) {
        this.number = number;
        this.name = name;
        this.price = price;
        this.unit = unit;
    }
    //无参构造方法
    public FruitItem(){}

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
