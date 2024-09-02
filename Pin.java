import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Pin extends JFrame implements ActionListener{
    
    JTextField t1,t2;
    JButton b1,b2;                               
    JLabel l1,l2,l3;
    String pin;
    Connection c11;
    Pin(String pin){
        this.pin = pin;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800, 800, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l4 = new JLabel(i3);
        l4.setBounds(0, 0, 800, 800);
        add(l4);
        
        l1 = new JLabel("CHANGE YOUR PIN");
        l1.setFont(new Font("Cambria", Font.BOLD, 20));
        l1.setForeground(Color.WHITE);
        
        l2 = new JLabel("New PIN:");
        l2.setFont(new Font("Cambria", Font.BOLD, 16));
        l2.setForeground(Color.WHITE);
        
        l3 = new JLabel("Re-Type PIN:");
        l3.setFont(new Font("Cambria", Font.BOLD, 16));
        l3.setForeground(Color.WHITE);
        
        t1 = new JTextField();
        t1.setFont(new Font("Cambria", Font.BOLD, 25));
        
        t2 = new JTextField();
        t2.setFont(new Font("Cambria", Font.BOLD, 25));
        
        b1 = new JButton("CHANGE");
        b2 = new JButton("BACK");
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        
        setLayout(null);
        
        l1.setBounds(320,95,800,35);
        l4.add(l1);
        
        l2.setBounds(230,175,150,35);
        l4.add(l2);
        
        l3.setBounds(230,210,200,35);
        l4.add(l3);
        
        t1.setBounds(350,170,180,25);
        l4.add(t1);
        
        t2.setBounds(350,215,180,25);
        l4.add(t2);
        
        b1.setBounds(360,250,150,35);
        l4.add(b1);
        
        b2.setBounds(360,300,150,35);
        l4.add(b2);
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
    
    public void actionPerformed(ActionEvent ae){
        try{        
            String npin = t1.getText();
            String rpin = t2.getText();
            
            if(!npin.equals(rpin)){
                JOptionPane.showMessageDialog(null, "Entered PIN does not match");
                return;
            }
            
            if(ae.getSource()==b1){
                if (t1.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Enter New PIN");
                }
                if (t2.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Re-Enter new PIN");
                }
                
                String q1 = "update bank set pin = '"+rpin+"' where pin = '"+pin+"' ";
                String q2 = "update login set pin = '"+rpin+"' where pin = '"+pin+"' ";
                String q3 = "update signup3 set pin = '"+rpin+"' where pin = '"+pin+"' ";
                Statement st = c11.createStatement();

                st.executeUpdate(q1);
                st.executeUpdate(q2);
                st.executeUpdate(q3);

                JOptionPane.showMessageDialog(null, "PIN changed successfully");
                setVisible(false);
                new Transactions(rpin).setVisible(true);
            
            }else if(ae.getSource()==b2){
                new Transactions(pin).setVisible(true);
                setVisible(false);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }

    public static void main(String[] args){
        new Pin("").setVisible(true);
    }
}
