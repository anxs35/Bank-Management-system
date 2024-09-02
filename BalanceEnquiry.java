import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.*;
import java.util.*;

class BalanceEnquiry extends JFrame implements ActionListener {

    JTextField t1, t2;
    JButton b1, b2, b3;
    JLabel l1, l2, l3;
    String pin;
    Connection c11;

    BalanceEnquiry(String pin) {
        this.pin = pin;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800, 800, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0, 0, 800, 800);
        add(l3);

        l1 = new JLabel();
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("Cambria", Font.BOLD, 20));

        b1 = new JButton("BACK");

        setLayout(null);

        l1.setBounds(250, 160, 400, 35);
        l3.add(l1);

        b1.setBounds(310, 250, 150, 35);
        l3.add(b1);
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            c11=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1821");
             }
                 catch(Exception e)
             {
               System.out.println(e);
             }
        int balance = 0;
        try{
            Statement st = c11.createStatement();
            ResultSet rs = st.executeQuery("select amount from Deposit where pin = '"+pin+"'");
            rs.next(); {
                if (rs.getString("mode").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
        }catch(Exception e){}
        
        l1.setText("Your Current Account Balance is Rs "+balance);

        b1.addActionListener(this);

        setSize(800, 720);
        setLocation(200, 0);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Transactions(pin).setVisible(true);
    }

    public static void main(String[] args) {
        new BalanceEnquiry("").setVisible(true);
    }
}