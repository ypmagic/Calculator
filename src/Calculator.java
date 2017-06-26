/**
 * Created by young on 5/25/17.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Calculator {

    // general calculator
    private JFrame calc;
    // specific parts
    private JPanel oneToNine;
    private JPanel bottom;
    private JPanel text;
    private JPanel operators;
    // all the buttons
    private JButton zero;
    private JButton one;
    private JButton two;
    private JButton three;
    private JButton four;
    private JButton five;
    private JButton six;
    private JButton seven;
    private JButton eight;
    private JButton nine;
    private JButton multiply;
    private JButton subtract;
    private JButton add;
    private JButton divide;
    private JButton equals;
    // text field to change
    private JTextField top;
    private String operator;

    public Calculator() {
        // creating the calculator frame
        this.calc = new JFrame();
        this.oneToNine = new JPanel(new GridLayout(3,3, 2, 2));
        this.bottom = new JPanel(new BorderLayout(2, 2));
        this.text = new JPanel(new BorderLayout(2, 2));
        this.operators = new JPanel (new GridLayout(5, 1, 2, 2));
        this.calc.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.calc.setLayout(new BorderLayout(2, 2));
        // all variable declarations
        this.operator = null;
        this.one = new JButton("1");
        this.one.setPreferredSize(new Dimension(150, 50));
        this.two = new JButton("2");
        this.two.setPreferredSize(new Dimension(150, 50));
        this.three = new JButton("3");
        this.three.setPreferredSize(new Dimension(150, 50));
        this.four = new JButton("4");
        this.four.setPreferredSize(new Dimension(150, 50));
        this.five= new JButton("5");
        this.five.setPreferredSize(new Dimension(150, 50));
        this.six = new JButton("6");
        this.six.setPreferredSize(new Dimension(150, 50));
        this.seven = new JButton("7");
        this.seven.setPreferredSize(new Dimension(150, 50));
        this.eight = new JButton("8");
        this.eight.setPreferredSize(new Dimension(150, 50));
        this.nine = new JButton("9");
        this.nine.setPreferredSize(new Dimension(150, 50));
        this.zero = new JButton("0");
        this.zero.setPreferredSize(new Dimension(450, 50));
        this.add = new JButton("+");
        this.add.setPreferredSize(new Dimension(100, 50));
        this.subtract = new JButton("-");
        this.subtract.setPreferredSize(new Dimension(100, 50));
        this.multiply = new JButton("*");
        this.multiply.setPreferredSize(new Dimension(100, 50));
        this.divide = new JButton("/");
        this.divide.setPreferredSize(new Dimension(100, 50));
        this.equals = new JButton("=");
        this.equals.setPreferredSize(new Dimension(100, 50));
        this.top = new JTextField("", (int) TextField.RIGHT_ALIGNMENT);
        this.operator = "";
        // one to nine buttons
        this.oneToNine.add(this.one);
        this.oneToNine.add(this.two);
        this.oneToNine.add(this.three);
        this.oneToNine.add(this.four);
        this.oneToNine.add(this.five);
        this.oneToNine.add(this.six);
        this.oneToNine.add(this.seven);
        this.oneToNine.add(this.eight);
        this.oneToNine.add(this.nine);
        this.bottom.add(this.zero);
        this.text.add(this.top);
        this.operators.add(this.add);
        this.operators.add(this.subtract);
        this.operators.add(this.multiply);
        this.operators.add(this.divide);
        this.operators.add(this.equals);
        addActionListeners();
        this.calc.add(this.oneToNine, BorderLayout.CENTER);
        this.calc.add(this.bottom, BorderLayout.PAGE_END);
        this.calc.add(this.text, BorderLayout.PAGE_START);
        this.calc.add(this.operators, BorderLayout.EAST);
        this.calc.pack();
        this.calc.setVisible(true);
    }

    private void addActionListeners() {
        this.zero.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                top.setText(top.getText() + "0");
            }
        });
        this.one.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                top.setText(top.getText() + "1");
            }
        });
        this.two.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                top.setText(top.getText() + "2");
            }
        });
        this.three.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                top.setText(top.getText() + "3");
            }
        });
        this.four.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                top.setText(top.getText() + "4");
            }
        });
        this.five.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                top.setText(top.getText() + "5");
            }
        });
        this.six.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                top.setText(top.getText() + "6");
            }
        });
        this.seven.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                top.setText(top.getText() + "7");
            }
        });
        this.eight.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                top.setText(top.getText() + "8");
            }
        });
        this.nine.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                top.setText(top.getText() + "9");
            }
        });
        this.add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                top.setText(top.getText() + "+");
                operator = "+";
            }
        });
        this.subtract.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                top.setText(top.getText() + "-");
                operator = "-";
            }
        });
        this.multiply.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                top.setText(top.getText() + "*");
                operator = "*";
            }
        });
        this.divide.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                top.setText(top.getText() + "/");
                operator = "/";
            }
        });
        this.equals.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int temp = calculate();
                top.setText("" + temp);
            }
        });
    }

    private int calculate() {
        int firstNum;
        int secondNum;
        String s = top.getText();
        System.out.println(s);
        for (int i = 0; i < s.length(); i++) {
            if (s.substring(i, i+1).equals(operator)) {
                firstNum = Integer.parseInt(s.substring(0, i));
                secondNum = Integer.parseInt(s.substring(i+1, s.length()));
                if (operator == "+") {
                    return firstNum + secondNum;
                }
                else if (operator == "-") {
                    return firstNum - secondNum;
                }
                else if (operator == "*") {
                    return firstNum * secondNum;
                }
                else if (operator == "/") {
                    return firstNum / secondNum;
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Calculator c = new Calculator();
    }
    // implement a reset function later

}
