package com.zhu.game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PuzzlePanel extends JPanel {
    JButton picture[] = new JButton[16];                          //新建按钮数组
    boolean t,winner=false;                                       //新建逻辑型数值，判断生成数是否相同和是否拼完
    int ImageX[][] = new int[4][4];                               //用来表示按钮数组的横坐标
    int ImageY[][] = new int[4][4];                               //用来表示按钮数组的纵坐标
    int size[] = new int[16];                                     //用来表示按钮数组的顺序
    int sum,x,y,z,change,mate,time;
    int go[] = new int[16];                                       //用来表示生成的随机数
    Timer timer;
    public void Loading(){
        //对计时器进行初始化
        time=0;
        //对生成数的数组进行赋值，对按钮的顺序数组进行赋值
        for(int i=0;i<16;i++){
            go[i]=-1;
            size[i]=i;
        }
        //生成随机数，用来表示按钮的数值，不可重复
        for(int i=0;i<16;i++){
            t=true;
            go[i] = (int)(16*Math.random());
            for(int j=0;j<16;j++){                                 //用循环来判断生成的随机数是否与前面的相同，如果相同，就重新生成一个
                if(go[i]==go[j]&&i!=j){
                    i--;
                    t=false;
                    break;
                }
            }
            //对按钮进行赋值
            if(t){
                if(go[i]==0){
                    picture[i] = new JButton("");
                    picture[i].setBackground(new Color(255, 255, 255));
                    //对零的值进行记录，并设置背景色为白色
                    x=i/4;y=i%4;z=i;
                }else{
                    picture[i] = new JButton(String.valueOf(go[i]));
//                    picture[i].setBackground(new Color(255, 167, 185));
//                    picture[i].setFont(new Font("微软雅黑",Font.BOLD,10));
                }
//                picture[i].setEnabled(false);
                //添加按钮至面板上
                add(picture[i]);
            }
        }
        //对按钮数组的横坐标和纵坐标进行赋值
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                ImageX[i][j]=100*j+100;
                ImageY[i][j]=100*i+100;
            }
        }
    }
    public PuzzlePanel(){
        Loading();
        //将焦点定位在面板上
        this.setFocusable(true);
        //建立键盘监听事件
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                int keycode = e.getKeyCode();
                //当还没有拼完图的时候才能启动键盘监听事件
                if(winner!=true){
                    if(keycode==37){
                        if(y!=3){
                            change=size[z];size[z]=size[z+1];size[z+1]=change;
                            y++;z++;
                        }
                    }
                    if(keycode==38){
                        if(x!=3){
                            change=size[z];size[z]=size[z+4];size[z+4]=change;
                            x++;z+=4;
                        }
                    }
                    if(keycode==39){
                        if(y!=0){
                            change=size[z];size[z]=size[z-1];size[z-1]=change;
                            y--;z--;
                        }
                    }
                    if(keycode==40){
                        if(x!=0){
                            change=size[z];size[z]=size[z-4];size[z-4]=change;
                            x--;z-=4;
                        }
                    }
                    mate=0;
                    //判断数组拼图是否完整
                    for(int i=0;i<16;i++){
                        if(String.valueOf(picture[size[i]].getText()).equals(String.valueOf(i+1))){
                            mate++;
                        }
                    }
                    //如果拼图完整，就对判断的值进行赋值
                    if(mate==15){
                        winner=true;
                    }
                }
                //重绘面板
                repaint();
            }
        });
        //用来计时，表示拼图的时间
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                time++;
            }
        });
            timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //设置面板的背景颜色
        this.setBackground(new Color(94, 70, 100));
        //每次重绘面板都对计数项进行重置
        sum=0;
        //判断是否拼完
        if(winner){
            //设置字体的颜色
            g.setColor(new Color(255, 167, 185));
            //设置字体样式
            g.setFont(new Font("微软雅黑",Font.BOLD,20));
            //在面板上输出文字
            g.drawString("恭喜你，完成拼图！",100,75);
            //关闭计时器
            timer.stop();
            //在面板上输出所用的时间
            if(time<60){
                g.drawString("您的用时为："+time+"秒",20,20);
            }else
                g.drawString("您的用时为："+time/60+"分"+time%60+"秒",20,20);
        }
        //重绘按钮组的位置
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                picture[size[sum]].setBounds(ImageX[i][j],ImageY[i][j],100,100);
                sum++;
            }
        }
    }
}