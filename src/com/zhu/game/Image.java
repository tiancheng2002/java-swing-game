package com.zhu.game;

import javax.swing.*;
import java.net.URL;

public class Image {
    //将图片的路径封装成一个对象
    public static URL bodyURL = Image.class.getResource("/image/body.PNG");
    //将图片封装为程序的一个对象
    public static ImageIcon bodyImg = new ImageIcon(bodyURL);
    //将图片的路径封装成一个对象
    public static URL upURL = Image.class.getResource("/image/up.PNG");
    //将图片封装为程序的一个对象
    public static ImageIcon upImg = new ImageIcon(upURL);
    //将图片的路径封装成一个对象
    public static URL downURL = Image.class.getResource("/image/down.png");
    //将图片封装为程序的一个对象
    public static ImageIcon downImg = new ImageIcon(downURL);
    //将图片的路径封装成一个对象
    public static URL leftURL = Image.class.getResource("/image/left.png");
    //将图片封装为程序的一个对象
    public static ImageIcon leftImg = new ImageIcon(leftURL);
    //将图片的路径封装成一个对象
    public static URL rightURL = Image.class.getResource("/image/right.png");
    //将图片封装为程序的一个对象
    public static ImageIcon rightImg = new ImageIcon(rightURL);
    //将图片的路径封装成一个对象
    public static URL foodURL = Image.class.getResource("/image/food.PNG");
    //将图片封装为程序的一个对象
    public static ImageIcon foodImg = new ImageIcon(foodURL);
    //将图片封装为程序的一个对象
    public static URL whiteURL = Image.class.getResource("/image/white.png");
    //将图片封装为程序的一个对象
    public static ImageIcon whiteImg = new ImageIcon(whiteURL);
    //将图片封装为程序的一个对象
    public static URL blackURL = Image.class.getResource("/image/black.png");
    //将图片封装为程序的一个对象
    public static ImageIcon blackImg = new ImageIcon(blackURL);
    //将图片封装为程序的一个对象
    public static URL greyURL = Image.class.getResource("/image/grey.png");
    //将图片封装为程序的一个对象
    public static ImageIcon greyImg = new ImageIcon(greyURL);
    //将图片封装为程序的一个对象
    public static URL flowerURL = Image.class.getResource("/image/flower.png");
    //将图片封装为程序的一个对象
    public static ImageIcon flowerImg = new ImageIcon(flowerURL);
}
