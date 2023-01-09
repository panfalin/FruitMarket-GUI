package cn.ndkj.fruit.controller;

import cn.ndkj.fruit.view.AbstractMainFrame;

public class MainFrameController extends AbstractMainFrame {
    public void showAdminDialog(){
        new AdminDialogController(this,true).setVisible(true);
    }
}
