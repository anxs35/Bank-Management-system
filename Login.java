import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.*;
import javax.swing.*;

public class Login implements ActionListener 
{
    JLabel l1,l2,l3;
    JTextField tf1;
    JTextField pf2;
    JButton b1,b2,b3;
    JFrame frm;
    Connection c11 = null;

Login(){
        frm = new JFrame("SAPPHIRE BANK LOGIN");
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("logo.png"));
        Image i2 = i1.getImage().getScaledInstance(100, 70, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l11 = new JLabel(i3);
        l11.setBounds(170, 10, 100, 100);
        frm.add(l11);
        
        l1 = new JLabel("SAPPHIRE BANK");
        l1.setFont(new Font("Cambria", Font.BOLD, 38));
        l1.setBounds(300,40,450,40);
        frm.add(l1);
        
        l2 = new JLabel("CARD NO :");
        l2.setFont(new Font("Cambria", Font.BOLD, 28));
        l2.setBounds(185,150,375,30);
        frm.add(l2);
        
        tf1 = new JTextField(15);
        tf1.setBounds(380,150,230,30);
        tf1.setFont(new Font("Cambria", Font.BOLD, 14));
        frm.add(tf1);
        
        l3 = new JLabel("PIN :");
        l3.setFont(new Font("Cambria", Font.BOLD, 28));
        l3.setBounds(185,220,375,30);
        frm.add(l3);
        
        pf2 = new JTextField(15);
        pf2.setFont(new Font("Cambria", Font.BOLD, 14));
        pf2.setBounds(380,220,230,30);
        frm.add(pf2);
                
        b1 = new JButton("SIGN IN");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        
        b2 = new JButton("CLEAR");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        
        b3 = new JButton("SIGN UP");
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        
        frm.setLayout(null);
        
        b1.setFont(new Font("Cambria", Font.BOLD, 14));
        b1.setBounds(380,300,100,30);
        frm.add(b1);
        
        b2.setFont(new Font("Cambria", Font.BOLD, 14));
        b2.setBounds(510,300,100,30);
        frm.add(b2);
        
        b3.setFont(new Font("Cambria", Font.BOLD, 14));
        b3.setBounds(380,350,230,30);
        frm.add(b3);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);

        // connection building here
        try{
        Class.forName("oracle.jdbc.driver.OracleDriver");
        c11=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1821");
         }
             catch(Exception e)
         {
           System.out.println(e);
         }
        
        frm.getContentPane().setBackground(Color.WHITE);
        
        frm.setSize(800, 480);
        frm.setLocation(300, 100);
        frm.setVisible(true);
        frm.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
    }

    public void actionPerformed(ActionEvent ae)
    {
      try{        
            if(ae.getSource()==b1){
                String cardno  = tf1.getText();
                String pin  = pf2.getText();
                String q  = "select * from login1 where cardno = '"+cardno+"' and pin = '"+pin+"'";
                Statement st = c11.createStatement();
                ResultSet rs = st.executeQuery(q);
                if(rs.next()){
                    setVisible(false);
                    new Transactions(pin).setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or PIN");
                }
            }else if(ae.getSource()==b2){
                tf1.setText("");
                pf2.setText("");
            }else if(ae.getSource()==b3){
                frm.setVisible(false);
                new Signup().setVisible(true);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    private void setVisible(boolean b) {

    }

    public static void main(String[] args){
        new Login().setVisible(false);
    }
}