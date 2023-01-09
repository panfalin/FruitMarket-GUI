package cn.ndkj.fruit.view;

import cn.ndkj.fruit.tools.GUITools;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class AbstractMainFrame extends JFrame {
    private JLabel titleLable=new JLabel(new ImageIcon("images/FruitStore.jpg"));
    private JButton btn=new JButton("进入系统");

    public AbstractMainFrame()
    {   this.init();//初始化
        this.addComponent();//我添加控件
        this.addListener();//我添加监听事件
    }

    private void init()
    {  this.setTitle("水果超市欢迎您");
       this.setSize(600,400);
        GUITools.center(this);
        GUITools.setTitleImage(this,"images/title.png");
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void addComponent()
    {  this.add(this.titleLable, BorderLayout.NORTH);
       JPanel btnPanel=new JPanel();
       btnPanel.setLayout(null);
       btn.setBounds(240,20,120,50);
       btnPanel.add(btn);
       this.add(btnPanel);
    }

    private void addListener()
    {
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showAdminDialog();
            }
        });
    }
    public abstract void showAdminDialog();

}
