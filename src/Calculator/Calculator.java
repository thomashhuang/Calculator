package Calculator;
import javax.swing.*;
import java.awt.event.*;

public class Calculator implements ActionListener {
    
    private JFrame calculatorWindow;
    private JTextField text;
    
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
    

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        
    }
    /**
     * 
     * @param x takes int 
     * @param y takes
     * @return- return double
     */
    public static double addition(int x, int y) {
    	return ((double)x+y);
    }
    /**
     * 
     * @param x
     * @param y
     * @return
     */
    public static double multiplication(int x, int y) {
    	return ((double)x*y);
    }
    /**
     * 
     * @param num
     * @param deno
     * @return
     */
    public static double division(int num, int deno) {
    	if (num == 0) {}
    		return ((double)num/deno);
    }
    /**
     * 
     * @param x
     * @param y
     * @return
     */
   public static double substruction(int x, int y) {
	   return ((double)x-y);
   }
    

}
