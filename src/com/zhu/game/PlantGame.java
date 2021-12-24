package com.zhu.game;

import javax.swing.*;

public class PlantGame {
    public static void main(String args[]){
        //创建窗体对象
        JFrame jf = new JFrame();
        //设置窗体标题
        jf.setTitle("丑物大战妖怪！");
        //设置窗体大小
        jf.setSize(700,700);
        //设置窗体不可改变大小
        jf.setResizable(false);
        //设置窗体为居中对齐
        jf.setLocationRelativeTo(null);
        //设置当窗体关闭时退出程序
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //窗体面板对象
        PlantPanel pp = new PlantPanel();
        //将面板加入窗体中
        jf.add(pp);
        //显示窗体
        jf.setVisible(true);
    }
}
