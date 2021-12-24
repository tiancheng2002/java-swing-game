package com.zhu.game;

import javax.swing.*;

public class WhiteGame {
    public static void main(String args[]){
        JFrame wf = new JFrame();
        //设置标题
        wf.setTitle("别踩白块儿！");
        //设置窗体大小
        wf.setSize(800,800);
        //设置窗体不可改变大小
        wf.setResizable(false);
        //设置窗体为居中显示
        wf.setLocationRelativeTo(null);
        //设置窗体关闭时结束程序
        wf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //显示窗体的背景颜色
        BlackPanel bp = new BlackPanel();
        //将面板添加到窗体当中
        wf.add(bp);
        //显示窗体
        wf.setVisible(true);
    }
}
