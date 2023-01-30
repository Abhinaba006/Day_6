package Day_6;

import java.awt.*;
import javax.swing.*;
import javax.xml.transform.stax.StAXResult;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.awt.event.ActionListener;

public class myCalculator implements ActionListener {
    JFrame f;
    JTextField t, t1;
    JButton b[] = new JButton[10];
    JButton add, sub, mul, div, clr, dec, equ, del;
    Stack<String> s = new Stack<String>();

    static double op1, op2, result;
    static String op = "";
    int count, flag;

    public myCalculator() {
        f = new JFrame("My calculator");
        f.setVisible(true);
        f.setLayout(null);
        f.setBounds(20, 20, 300, 400);
        f.setResizable(false);

        Font fo = new Font("Arial", Font.BOLD, 20);
        t = new JTextField();
        t1 = new JTextField();
        t.setFont(fo);
        t.setBackground(Color.gray);
        t.setForeground(Color.WHITE);
        t.setBounds(35, 40, 210, 50);
        t1.setBounds(35, 10, 210, 20);

        // buttons
        for (int i = 0; i < 10; i++) {
            b[i] = new JButton(String.valueOf(i));
            b[i].addActionListener(this);
            f.add(b[i]);
        }

        add = new JButton("+");
        add.addActionListener(this);
        sub = new JButton("-");
        sub.addActionListener(this);
        mul = new JButton("*");
        mul.addActionListener(this);
        div = new JButton("/");
        div.addActionListener(this);
        clr = new JButton("clr");
        clr.addActionListener(this);
        dec = new JButton(".");
        dec.addActionListener(this);
        equ = new JButton("=");
        equ.addActionListener(this);
        del = new JButton("del");
        del.addActionListener(this);

        f.add(t);
        f.add(t1);

        // add button to frame
        b[7].setBounds(40, 100, 50, 40);
        b[8].setBounds(90, 100, 50, 40);
        b[9].setBounds(140, 100, 50, 40);
        div.setBounds(190, 100, 50, 40);

        b[4].setBounds(40, 140, 50, 40);
        b[5].setBounds(90, 140, 50, 40);
        b[6].setBounds(140, 140, 50, 40);
        mul.setBounds(190, 140, 50, 40);

        b[1].setBounds(40, 180, 50, 40);
        b[2].setBounds(90, 180, 50, 40);
        b[3].setBounds(140, 180, 50, 40);
        sub.setBounds(190, 180, 50, 40);

        b[0].setBounds(40, 220, 50, 40);
        dec.setBounds(90, 220, 50, 40);
        add.setBounds(140, 220, 50, 40);
        equ.setBounds(190, 220, 50, 40);
        clr.setBounds(40, 260, 100, 40);
        del.setBounds(130, 260, 110, 40);

        for (int i = 0; i < 10; i++)
            f.add(b[i]);
        f.add(add);
        f.add(sub);
        f.add(mul);

        f.add(div);
        f.add(clr);

        f.add(dec);
        f.add(equ);

        f.add(del);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {
        new myCalculator();
    }

    static boolean isDigit(char check) {
        if (Character.isDigit(check)) {
            return true;
        }
        return false;
    }
    public static String calC(String s) {
        int total = 0;
    for (String t : s.split("(?=[+-])")) {
        int term = 1;
        for (String u : ('*' + t).split("(?=[*/])")) {
            int n = Integer.parseInt(u.substring(1));
            term = u.startsWith("*") ? term * n : term / n;
        }
        total += term;
    }
        System.out.println(total);
        return String.valueOf(total);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        for(int i=0; i<10; i++){
            if(e.getSource() == b[i])
                t.setText(t.getText() + i);
        }

        if(e.getSource() == add){
            // op1 = Double.parseDouble(t.getText());
            // t.setText("");
            // op = "+";
            // flag=0;
            // t1.setText(op1 + op);
            t.setText(t.getText()+"+");
        }
        else if(e.getSource() == sub){
            // op1 = Double.parseDouble(t.getText());
            // t.setText("");
            // op = "-";
            // flag=0;
            // t1.setText(op1 + op);
            t.setText(t.getText()+"-");
        }
        else if(e.getSource() == mul){
            // op1 = Double.parseDouble(t.getText());
            // t.setText("");
            // op="*";
            // flag=0;
            // t1.setText(op1 + op);
            t.setText(t.getText() + "*");

        }
        else if(e.getSource() == div){
            // op1 = Double.parseDouble(t.getText());
            // t.setText("");
            // op="/";
            // flag=0;
            // t1.setText(op1 + op);
            t.setText(t.getText()+"/");

        }
        else if(e.getSource() == clr){
            t.setText("");
            // t1.setText("");
            flag=0;
        }
        else if(e.getSource() == dec){
            if(flag==0) {
                t.setText(t.getText() + ".");
                flag=1;
            }
        }else if(e.getSource() == equ){
            String temp = t.getText();
            System.out.println(temp);
            t.setText(C);;
        }else if(e.getSource() == del){
            String str = t.getText();
            str = str.substring(0, str.length()-1);
            t.setText(str);
        }else if(e.getSource() == clr){
            t.setText("");
            t1.setText("");
        }
    }
}
