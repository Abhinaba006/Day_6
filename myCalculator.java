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
    JTextField t;
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
        t.setFont(fo);
        t.setBackground(Color.gray);
        t.setForeground(Color.WHITE);
        t.setBounds(35, 40, 210, 50);

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

        f.repaint();
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
    public static Boolean isOperator(char check) {
        if (check == '+' || check == '-' || check == '*' || check == '/') {
            return true;
        }
        return false;
    }
    public static String calC(String s) {
        Stack<Double> nums = new Stack<Double>();
            char lastOperator = '+';
            String num = "";
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c >= '0' && c <= '9' || c == '.') {
                    num += c;
                }
                if (isOperator(c) || i == s.length() - 1) {
                    if (lastOperator == '+') {
                        nums.push(Double.parseDouble(num));
                    }
                    else if (lastOperator == '-') {
                        nums.push((double) -1 * Double.parseDouble(num));
                    }
                    else if (lastOperator == '*') {
                        nums.push(nums.pop()*Double.parseDouble(num));
                    } else if (lastOperator == '/') {
                        nums.push(nums.pop() / Double.parseDouble(num));
                    }
                    num = "";
                    lastOperator = c;
                }
            }
            Double res= 0.0;
            while (!nums.isEmpty()) {
                res = res + nums.pop();
            }
            return res.toString();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == b[i])
                t.setText(t.getText() + i);
        }
        if (e.getSource() == add) {
            t.setText(t.getText() + "+");
        } else if (e.getSource() == sub) {
            t.setText(t.getText() + "-");
        } else if (e.getSource() == mul) {
            t.setText(t.getText() + "*");

        } else if (e.getSource() == div) {
            t.setText(t.getText() + "/");

        } else if (e.getSource() == clr) {
            t.setText("");
            flag = 0;
        } else if (e.getSource() == dec) {
            if (flag == 0) {
                t.setText(t.getText() + ".");
                flag = 1;
            }
        } else if (e.getSource() == equ) {
            String temp = t.getText();
            t.setText(t.getText()+" = "+calC(temp));
        } else if (e.getSource() == del) {
            String str = t.getText();
            str = str.substring(0, str.length() - 1);
            t.setText(str);
        } else if (e.getSource() == clr) {
            t.setText("");
        }
    }
}
