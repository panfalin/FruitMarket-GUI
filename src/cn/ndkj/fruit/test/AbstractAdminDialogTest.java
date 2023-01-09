package cn.ndkj.fruit.test;

import cn.ndkj.fruit.view.AbstractAdminDialog;

import java.awt.*;

public class AbstractAdminDialogTest extends AbstractAdminDialog {
    public AbstractAdminDialogTest() {
        super();
        queryFruitItem();//测试数据

    }

    public AbstractAdminDialogTest(Frame owner, boolean modal) {
        super(owner, modal);
    }

    @Override
    public void queryFruitItem() {

    }

    @Override
    public void deleteFruitItem() {

    }

    @Override
    public void updateFruitItem() {

    }

    @Override
    public void addFruitItem() {

    }

    @Override
    public void queryFruitItemForCon() {

    }
}
