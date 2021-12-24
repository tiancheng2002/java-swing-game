package com.zhu.game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GamePanel extends JPanel {
    int length;                          //表示蛇的长度
    String direction;                    //表示蛇头的方向
    boolean isStart = false;             //表示游戏的开始和暂停
    boolean died = false;                //表示蛇是否死亡
    Timer timer;                         //加入一个计时器
    int x,y;                             //表示食物的横坐标和纵坐标
    int[] snakeX = new int[200];         //新建一个数组，用来存储蛇的横坐标
    int[] snakeY = new int[200];         //新建另一个数组，用来存储蛇的纵坐标
    public void init(){
        //初始化长度
        length=3;
        //初始化蛇头的方向
        direction="R";                   //共有U,D,L,R四个属性
        //初始化蛇头
        snakeX[0]=175;
        snakeY[0]=275;
        //初始化第一节身子
        snakeX[1]=150;
        snakeY[1]=275;
        //初始化第二节身子
        snakeX[2]=125;
        snakeY[2]=275;
    }
    public GamePanel(){
        init();
        //将焦点定位在当前面板上
        this.setFocusable(true);
        //加入监听，表示键盘是否按下的是空格键
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                int keycode = e.getKeyCode();
                System.out.println(keycode);
                if(keycode == 32){
                        isStart = !isStart;
                        repaint();
                }
                //判断键盘按的方向键，对蛇头的朝向进行调整
                switch (keycode){
                    case 37:direction="L";break;
                    case 38:direction="U";break;
                    case 39:direction="R";break;
                    case 40:direction="D";break;
                }
            }
        });
        //对定时器进行初始化操作
        timer = new Timer(50, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(isStart&&died==false){
                    for(int i=length-1;i>0;i--){
                        snakeX[i]=snakeX[i-1];
                        snakeY[i]=snakeY[i-1];
                    }
                    if(direction.equals("R")){
                    snakeX[0]+=25;
                    if(snakeX[0]>750)
                        snakeX[0]=25;}
                    if(direction.equals("L")){
                        snakeX[0]-=25;
                        if(snakeX[0]<25)
                            snakeX[0]=750;}
                    if(direction.equals("U")){
                        snakeY[0]-=25;
                        if(snakeY[0]<25)
                            snakeY[0]=750;}
                    if(direction.equals("D")){
                        snakeY[0]+=25;
                        if(snakeY[0]>725)
                            snakeY[0]=25;}
                    for(int i=length-1;i>0;i--){
                        if(snakeX[0]==snakeX[i]&&snakeY[0]==snakeY[i]){
                            died=true;
                        }
                    }
                    if(snakeX[0]==x&&snakeY[0]==y){
                        length++;
                        snakeX[length-1]=snakeX[length-2];
                        snakeY[length-1]=snakeY[length-2];
                        do{
                            x = (int)(700*Math.random()+25);
                            y = (int)(700*Math.random()+25);
                        }while(x%25!=0||y%25!=0);
                    }
                    repaint();
                }
            }
        });
        do{
        x = (int)(700*Math.random()+25);
        y = (int)(700*Math.random()+25);
        }while(x%25!=0||y%25!=0);
        System.out.println(x+" "+y);
        //启动定时器
        timer.start();
    }
    //调用图形版的main方法
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //填充背景颜色
        this.setBackground(new Color(81, 204, 255));
        //调整画笔的颜色
        g.setColor(new Color(114, 178, 117));
        //添加一个矩形方阵
        g.fillRect(10,10,760,740);
        //显示蛇头
        if(direction.equals("R"))
            Image.rightImg.paintIcon(this,g,snakeX[0],snakeY[0]);
        if(direction.equals("L"))
            Image.leftImg.paintIcon(this,g,snakeX[0],snakeY[0]);
        if(direction.equals("U"))
            Image.upImg.paintIcon(this,g,snakeX[0],snakeY[0]);
        if(direction.equals("D"))
            Image.downImg.paintIcon(this,g,snakeX[0],snakeY[0]);
        for(int i=1;i<length;i++){
            Image.bodyImg.paintIcon(this,g,snakeX[i],snakeY[i]);
        }
        //根据键盘的输入，来判断游戏是否开始或者暂停
        if(isStart==false&&died==false){
            //调整文字颜色
            g.setColor(new Color(150, 83, 106));
            //添加文字的三个参数：字体、字体加粗、字体大小
            g.setFont(new Font("微软雅黑",Font.BOLD,40));
            //添加文字到面板
            g.drawString("点击空格开始游戏",250,350);
        }
        if(died){
            //调整文字颜色
            g.setColor(new Color(150, 83, 106));
            //添加文字的三个参数：字体、字体加粗、字体大小
            g.setFont(new Font("微软雅黑",Font.BOLD,40));
            //添加文字到面板
            g.drawString("您已死亡，游戏结束！",250,350);
        }
        Image.foodImg.paintIcon(this,g,x,y);
        g.setColor(new Color(188, 20, 30));
        g.setFont(new Font("微软雅黑",Font.BOLD,15));
        g.drawString("当前积分："+(length-3),10,10);
    }
}
