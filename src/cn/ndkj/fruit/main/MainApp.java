package cn.ndkj.fruit.main;

import cn.ndkj.fruit.controller.AdminDialogController;
import cn.ndkj.fruit.controller.MainFrameController;
import cn.ndkj.fruit.test.AbstractMainFrameTest;

public class MainApp {
    public static void main(String[] args) {
        new MainFrameController().setVisible(true);
    }
}

