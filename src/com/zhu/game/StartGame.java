package com.zhu.game;

import javax.swing.*;

public class StartGame {
    public static void main(String args[]){
        //创建窗体
        JFrame jf = new JFrame();
        //设置窗体标题
        jf.setTitle("贪吃蛇");
        //设置窗体大小
        jf.setSize(800,800);
        //设置窗体不可拖动大小
        jf.setResizable(false);
        //设置窗体为居中显示
        jf.setLocationRelativeTo(null);
        //关闭窗体的同时，关闭程序
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //显示背景颜色
        GamePanel gp = new GamePanel();
        jf.add(gp);
        //显示窗体
        jf.setVisible(true);
    }
}
