package com.zhu.game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BlackPanel extends JPanel {
    boolean start=false;                                 //表示游戏是否开始
    boolean died=false;                                  //表示游戏是否结束
    Timer timer;                                         //新建一个计时器
    int quantity;                                        //表示行的数量
    int point;                                           //表示当前积分
    int x,y;                                             //表示鼠标点击位置的横坐标和纵坐标
    int[] black = new int[1000];                         //表示白方格出现的位置
    int[][] squareX = new int[1000][4];                  //表示每一行方格的横坐标
    int[][] squareY = new int[1000][4];                  //表示每一行方格的纵坐标
    public void ready(){                                 //对第一行的方格的横坐标以及纵坐标进行初始化
        //对行的数量进行初始化
        quantity=1;
        //对积分进行初始化操作
        point=0;
        //生成一个随机数，表示第一行白方格出现的位置
        black[0]=(int)(4*Math.random());
        //对第一行第一个的方格的横坐标和纵坐标进行初始化
        squareX[0][0]=275;
        squareY[0][0]=-100;
        //对第一行第二个的方格的横坐标和纵坐标进行初始化
        squareX[0][1]=350;
        squareY[0][1]=-100;
        //对第一行第三个的方格的横坐标和纵坐标进行初始化
        squareX[0][2]=425;
        squareY[0][2]=-100;
        //对第一行第三个的方格的横坐标和纵坐标进行初始化
        squareX[0][3]=500;
        squareY[0][3]=-100;
    }
    public BlackPanel(){
        ready();
        //将焦点放在面板上
        this.setFocusable(true);
        //建立键盘监听事件,表示游戏是否开始
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                int keycode=e.getKeyCode();
                if(keycode==32){
                    start=!start;
                    repaint();
                }
            }
        });
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                x=e.getX();
                y=e.getY();
                System.out.println(x+" "+y);
                if(x>=squareX[point][black[point]]&&x<=squareX[point][black[point]]+75&&y>=squareY[point][black[point]]&&y<=squareY[point][black[point]]+125){
                    point++;
                }else{
                    died=true;
                }
                repaint();
            }
        });
        //新建一个计时器事件，来表示程序的运行
        timer = new Timer(30, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //根据积分来对速度进行加快
                if(point>=75){
                    timer.setDelay(5);
                }else if(point>=50){
                    timer.setDelay(10);
                }else if(point>=30)
                    timer.setDelay(20);
                else
                    timer.setDelay(30);
                //游戏进行的时候才能判断
                if(start&&died==false){
                    for(int i=0;i<quantity;i++){
                        for(int j=0;j<4;j++){
                            squareY[i][j]+=5;
                        }
                    }
                    if(squareY[quantity-1][0]==0){
                        for(int j=0;j<4;j++){
                            squareX[quantity][j]=squareX[quantity-1][j];
                            squareY[quantity][j]=-125;
                        }
                        black[quantity]=(int)(4*Math.random());
                        quantity++;
                    }
                    if(squareY[point][black[point]]>=750){
                        died=true;
                    }
                    repaint();
                }
            }
        });
        //启动定时器
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //对面板进行上色
        this.setBackground(new Color(255, 167, 185));
        //添加第一行的所有方格图片
        for(int i=0;i<quantity;i++){
            for(int j=0;j<4;j++){
                if(j==black[i]){
                    Image.blackImg.paintIcon(this,g,squareX[i][j],squareY[i][j]);
                }else{
                    Image.whiteImg.paintIcon(this,g,squareX[i][j],squareY[i][j]);
                }
            }
        }
        if(start==false&&died==false){
            //调整文字颜色
            g.setColor(new Color(232, 228, 6));
            //添加文字样式
            g.setFont(new Font("微软雅黑",Font.BOLD,20));
            //将文字添加到面板上
            g.drawString("按空格开始游戏！",30,400);
        }
        if(died){
            //调整文字颜色
            g.setColor(new Color(20, 123, 232));
            //添加文字样式
            g.setFont(new Font("微软雅黑",Font.BOLD,20));
            //将文字添加到面板上
            g.drawString("您已死亡，游戏结束！",30,400);
        }
        for(int i=0;i<point;i++){
            for(int j=0;j<4;j++){
                Image.greyImg.paintIcon(this,g,squareX[i][black[i]],squareY[i][black[i]]);
            }
        }
        //调整画笔颜色
        g.setColor(new Color(188, 20, 30));
        //调整文字样式
        g.setFont(new Font("微软雅黑",Font.BOLD,10));
        //将文字显示到面板上
        g.drawString("当前积分："+point,10,10);
    }
}
