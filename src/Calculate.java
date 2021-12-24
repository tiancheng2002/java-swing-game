import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.String;
import java.util.Objects;
import java.util.jar.JarEntry;

public class Calculate {
    private static String s1="";
    private static String s2="";
    private static int s3;
    private static String js;
    public static void main(String ars[]){
        //用来表示数值
        //新建一个数组，表示面板上各个按钮的名称
        String a[] = {"7","8","9","/","4","5","6","*","1","2","3","-","0",".","=","+"};
        JFrame jsq = new JFrame();
        //设置窗体名称
        jsq.setTitle("计算器");
        //设置窗体大小
        jsq.setSize(400,400);
        //设置窗体不可改变大小
        jsq.setResizable(false);
        //设置窗体位于居中对齐
        jsq.setLocationRelativeTo(null);
        //设置窗体按下关闭时结束程序
        jsq.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //新建一个jp1的面板
        JPanel jp1 = new JPanel();
        //新建一个当行文本框
        JTextField t1 = new JTextField(35);
        //设置文本框的初始值
        t1.setText("0");
        //设置文本框的字体颜色为黑色
        t1.setForeground(new Color(255, 167, 185));
        //设置文本框内容为右对齐
        t1.setHorizontalAlignment(JTextField.RIGHT);
        //将文本框放入jp1面板中
        jp1.add(t1);
        //新建一个按钮数组
        JButton keys[] = new JButton[16];
        //对各个按钮的文本进行编辑
        for(int i=0;i<=9;i++){
            keys[i]=new JButton(String.valueOf(i));
        }
        keys[10]=new JButton("/");
        keys[11]=new JButton("*");
        keys[12]=new JButton("-");
        keys[13]=new JButton("+");
        keys[14]=new JButton("=");
        keys[15]=new JButton(".");
        //添加数字按钮单击响应事件
        for(int i=0;i<=15;i++){
            keys[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    switch (e.getActionCommand()){
                        case "0":
                        case "1":
                        case "2":
                        case "3":
                        case "4":
                        case "5":
                        case "6":
                        case "7":
                        case "8":
                        case "9":
                        case ".":
                            s1+=e.getActionCommand();
                            t1.setText(s1);
                            break;
                        case "+":
                        case "-":
                        case "*":
                        case "/":
                            if(s2.equals("")){
                                s2=s1;
                            }
                            t1.setText("");
                            s1="";
                            js=e.getActionCommand();
                            System.out.println(js);
                            break;
                        case "=":
                            if(js.equals("+")){
                                s3 = Integer.parseInt(s2)+Integer.parseInt(s1);
                            }else if(js.equals("-")){
                                s3 = Integer.parseInt(s2)-Integer.parseInt(s1);
                            }else if(js.equals("*")){
                                s3 = Integer.parseInt(s2)*Integer.parseInt(s1);
                            }else if(js.equals("/")){
                                s3 = Integer.parseInt(s2)/Integer.parseInt(s1);
                            }
                            s2=String.valueOf(s3);
                            t1.setText(String.valueOf(s3));
                            System.out.println(s3);
                            break;
                    }
                }
            });
        }
        //新建一个网格布局
        jp1.setLayout(new GridLayout(4,4));
        //将各个按钮添加至面板
        for(int i=7;i<=10;i++){
            jp1.add(keys[i]);
        }
        for(int i=4;i<=6;i++){
            jp1.add(keys[i]);
        }
        jp1.add(keys[11]);
        for(int i=1;i<=3;i++){
            jp1.add(keys[i]);
        }
        jp1.add(keys[12]);
        for(int i=15;i>=13;i--){
            jp1.add(keys[i]);
        }
        jp1.add(keys[0]);
        //将jp1面板放入窗体中
        jsq.getContentPane().add(t1,BorderLayout.NORTH);
        //将jp2面板放入窗体中
        jsq.getContentPane().add(jp1,BorderLayout.CENTER);
        //显示窗体
        jsq.setVisible(true);
    }
}
