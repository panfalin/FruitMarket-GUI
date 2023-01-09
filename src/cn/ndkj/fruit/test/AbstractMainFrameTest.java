package cn.ndkj.fruit.test;

import cn.ndkj.fruit.view.AbstractMainFrame;

public class AbstractMainFrameTest extends AbstractMainFrame {
    @Override
    public void showAdminDialog() {
        new AbstractAdminDialogTest().setVisible(true);
    }
}
