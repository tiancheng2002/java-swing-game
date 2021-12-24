package com.zhu.game;

import javax.swing.*;

public class PuzzleGame {
    public static void main(String args[]){
        //创建一个JFrame的对象GameImage
        JFrame jf = new JFrame();
        //创建窗体标题
        jf.setTitle("拼图！");
        //创建窗体大小
        jf.setSize(600,600);
        //设置窗体不可改变大小
        jf.setResizable(false);
        //将窗体位于居中对齐
        jf.setLocationRelativeTo(null);
        //按下关闭按钮是结束程序
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //创建面板对象
        PuzzlePanel pz = new PuzzlePanel();
        //将面板添加到窗体中
        jf.add(pz);
        //显示窗体
        jf.setVisible(true);
    }
}
