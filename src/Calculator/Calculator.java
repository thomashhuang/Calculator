package Calculator;
import javax.swing.*;
import javax.swing.text.JTextComponent;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.*;

public class Calculator implements ActionListener {

    private JFrame calculatorWindow;
    private JPanel buttonPanel;
    private JTextField text;

    private enum Operation {
        ADD, SUBTRACT, MULTIPLY, DIVIDE, POWER, MODULUS;
    }

    private Operation operation;
    
    private double arg1;
    private double arg2;

    private JButton one = new JButton("1");
    private JButton two = new JButton("2");
    private JButton three = new JButton("3");
    private JButton four = new JButton("4");
    private JButton five = new JButton("5");
    private JButton six = new JButton("6");
    private JButton seven = new JButton("7");
    private JButton eight = new JButton("8");
    private JButton nine = new JButton("9");
    private JButton zero = new JButton("0");
    private JButton decimal = new JButton(".");
    private JButton plus = new JButton("+");
    private JButton minus = new JButton("-");
    private JButton times = new JButton("*");
    private JButton divide = new JButton("/");
    private JButton equals = new JButton("=");
    private JButton power = new JButton("^");
    private JButton mod = new JButton("%");
    private JButton clear = new JButton("C");
    private JButton delete = new JButton("D");
    

    public Calculator() {
        buttonPanel = new JPanel();
        calculatorWindow = new JFrame("Calculator");
        calculatorWindow.setLayout(new GridBagLayout());

        text = new JTextField("");
        one.addActionListener(this);
        two.addActionListener(this);
        three.addActionListener(this);
        four.addActionListener(this);
        five.addActionListener(this);
        six.addActionListener(this);
        seven.addActionListener(this);
        eight.addActionListener(this);
        nine.addActionListener(this);
        zero.addActionListener(this);
        decimal.addActionListener(this);
        plus.addActionListener(this);
        minus.addActionListener(this);
        times.addActionListener(this);
        divide.addActionListener(this);
        equals.addActionListener(this);
        power.addActionListener(this);
        mod.addActionListener(this);
        clear.addActionListener(this);
        delete.addActionListener(this);

        buttonPanel.setLayout(new GridLayout(4, 5));
        buttonPanel.add(seven);
        buttonPanel.add(eight);
        buttonPanel.add(nine);
        buttonPanel.add(divide);
        buttonPanel.add(mod);
        buttonPanel.add(four);
        buttonPanel.add(five);
        buttonPanel.add(six);
        buttonPanel.add(times);
        buttonPanel.add(power);
        buttonPanel.add(one);
        buttonPanel.add(two);
        buttonPanel.add(three);
        buttonPanel.add(minus);
        buttonPanel.add(delete);
        buttonPanel.add(zero);
        buttonPanel.add(decimal);
        buttonPanel.add(equals);
        buttonPanel.add(plus);
        buttonPanel.add(clear);
        
        calculatorWindow.add(text);
        calculatorWindow.add(buttonPanel);
        
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weighty = .2;
        calculatorWindow.add(text, constraints);
        
        constraints.gridy = 1;
        constraints.weighty = 1;
        calculatorWindow.add(buttonPanel, constraints);
        
        calculatorWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        calculatorWindow.pack();
        calculatorWindow.setVisible(true);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String input = ((JButton) e.getSource()).getText();
        if (input.matches("[1-9]")) {
            text.setText(text.getText() + input);
        } else if (input.equals(".")) {
            if (!input.contains(".")) {
                text.setText(text.getText() + '.');
            }
        } else if (input.equals("0")) {
            if (!text.getText().equals("0")) {
                text.setText(text.getText() + input);
            }
        } else if (input.matches("[+/*%]") || input.equals("^") || input.equals("-")) {
            if (operation == null) {
                if (input.equals("+")) {
                    operation = Operation.ADD;
                } else if (input.equals("-")) {
                    operation = Operation.SUBTRACT;
                } else if (input.equals("*")) {
                    operation = Operation.MULTIPLY;
                } else if (input.equals("/")) {
                    operation = Operation.DIVIDE;
                } else if (input.equals("^")) {
                    operation = Operation.POWER;
                } else {
                    operation = Operation.MODULUS;
                }
                arg1 = Double.parseDouble(text.getText());
                text.setText("");
            }
        } else if (input.equals("C")) {
            arg1 = 0;
            arg2 = 0;
            text.setText("");
            operation = null;
        } else if (input.equals("D") && text.getText().length() > 0) {
            text.setText(text.getText().substring(0, text.getText().length() - 1));
        }
        else {
            if (operation != null) {
                arg2 = Double.parseDouble(text.getText());
                String result = this.performOperation();
                text.setText(result);
                operation = null;
                arg1 = Double.parseDouble(result);
            }
        }

    }
    
    /**
     * Performs the current operation with the current input.
     * @return
     */
    public String performOperation() {
        double solution = 0.0;
        if (operation == null) {
            throw new IllegalArgumentException();
        }
        switch (operation) {
        case ADD:
            solution = addition(arg1, arg2);
            break;
        case SUBTRACT:
            solution = subtraction(arg1, arg2);
            break;
        case MULTIPLY:
            solution = multiplication(arg1, arg2);
            break;
        case DIVIDE:
            solution = division(arg1, arg2);
            break;
        case POWER:
            solution = power(arg1, arg2);
            break;
        default:
            break;
        }
        return String.valueOf(solution);
    }
    
    /**
     * Addition.
     * @param x
     * @param y 
     * @return x + y
     */
    public static double addition(double x, double y) {
        return (x+y);
    }

    /**
     * Multiplication.
     * @param x
     * @param y
     * @return x * y
     */
    public static double multiplication(double x, double y) {
        return (x*y);
    }

    /**
     * Division.
     * @param num
     * @param deno
     * @return num / deno
     */
    public static double division(double num, double deno) {
        if (num == 0) {
            throw new IllegalArgumentException();
        }
        return (num/deno);
    }

    /**
     * Subtraction.
     * @param x
     * @param y
     * @return x - y
     */
    public static double subtraction(double x, double y) {
        return (x-y);
    }

    /**
     * Raise number to a power.
     * @param base
     * @param power
     * @return base^power
     */
    public static double power(double base, double power) {
        return Math.pow(base, power);
    }
    
    /**
     * Modulus.
     * @param num
     * @param base
     * @return num % base
     */
    public static double modulus(double num, double base) {
        if (base == 0) {
            throw new IllegalArgumentException();
        }
        return num % base;
    }
    
    /**
     * Main method.
     */
    public static void main(String[] args) {
        Calculator cal = new Calculator();
    }

}
