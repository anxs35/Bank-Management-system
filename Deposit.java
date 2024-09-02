import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.*;
import java.util.*;

public class Deposit extends JFrame implements ActionListener{
    
    JTextField t1,t2;
    JButton b1,b2,b3;
    JLabel l1,l2,l3;
    String pin;
    Connection c11;
    Deposit(String pin){
        this.pin = pin;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800, 800, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0, 0, 800, 800);
        add(l3);
        
        l1 = new JLabel("ENTER AMOUNT YOU WANT TO DEPOSIT");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("Cambria", Font.BOLD, 16));
        
        t1 = new JTextField();
        t1.setFont(new Font("Cambria", Font.BOLD, 22));
        
        b1 = new JButton("DEPOSIT");
        b2 = new JButton("BACK");
        
        setLayout(null);
        
        l1.setBounds(250,100,400,35);
        l3.add(l1);
        
        t1.setBounds(240,150,320,25);
        l3.add(t1);
        
        b1.setBounds(330,200,150,35);
        l3.add(b1);
        
        b2.setBounds(330,260,150,35);
        l3.add(b2);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
         // connection building here
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            c11=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1821");
             }
                 catch(Exception e)
             {
               System.out.println(e);
             }
        
        setSize(800,720);
        setLocation(200,0);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent ae)
    {
        try{        
            String amount = t1.getText();
            Date date = new Date();
            if(ae.getSource()==b1){
                if(t1.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter the Amount to you want to Deposit");
                }else{
                    Statement st = c11.createStatement();
                    st.executeUpdate("insert into Deposit values('"+amount+"')");
                    JOptionPane.showMessageDialog(null, "Rs. "+amount+" Deposited Successfully");
                    setVisible(false);
                    new Transactions(pin).setVisible(true);
                }
            }else if(ae.getSource()==b2){
                setVisible(false);
                new Transactions(pin).setVisible(true);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        new Deposit("").setVisible(true);
    }
}