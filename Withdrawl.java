import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import java.sql.Statement;
public class Withdrawl extends JFrame implements ActionListener{
    
    JTextField t1,t2;
    JButton b1,b2,b3;
    JLabel l1,l2,l3,l4;
    String pin;
    Connection c11;
    Withdrawl(String pin){
        this.pin = pin;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800, 800, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0, 0, 800, 800);
        add(l3);
        
        l1 = new JLabel("MAXIMUM WITHDRAWAL IS RS.10,000");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("Cambria", Font.BOLD, 16));
        
        l2 = new JLabel("PLEASE ENTER YOUR AMOUNT");
        l2.setForeground(Color.WHITE);
        l2.setFont(new Font("Cambria", Font.BOLD, 16));
        
        t1 = new JTextField();
        t1.setFont(new Font("Cambria", Font.BOLD, 25));
        
        b1 = new JButton("WITHDRAW");
        b2 = new JButton("BACK");
        
        setLayout(null);
        
        l1.setBounds(250,100,300,20);
        l3.add(l1);
        
        l2.setBounds(270,130,400,20);
        l3.add(l2);
        
        t1.setBounds(230,160,330,30);
        l3.add(t1);
        
        b1.setBounds(320,230,150,35);
        l3.add(b1);
        
        b2.setBounds(320,270,150,35);
        l3.add(b2);
        
        b1.addActionListener(this);
        b2.addActionListener(this);

         // connection building here
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            c11=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1501:xe","system","1821");
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
            
            if(ae.getSource()==b1){
                if(t1.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter the Amount to you want to Withdraw");
                }else{
                    
                    Statement st = c11.createStatement();
                    ResultSet rs = st.executeQuery("select * from Deposit where pin = '"+pin+"'");
                    int balance = 0;
                    while(rs.next()){
                       if(rs.getString("mode").equals("Deposit")){
                           balance += Integer.parseInt(rs.getString("amount"));
                       }else{
                           balance -= Integer.parseInt(rs.getString("amount"));
                       }
                    }
                    if(balance < Integer.parseInt(amount)){
                        JOptionPane.showMessageDialog(null, "Insuffient Balance");
                        return;
                    }
                    Date date = new Date(balance);
                    // st.executeUpdate("insert into withdrawl values('"+amount+"')");
                    JOptionPane.showMessageDialog(null, "Rs. "+amount+" Debited Successfully");
                    
                    setVisible(false);
                    new Transactions(pin).setVisible(true);
                }
            }else if(ae.getSource()==b2){
                setVisible(false);
                new Transactions(pin).setVisible(true);
            }
        }catch(Exception e){
                e.printStackTrace();
                System.out.println("error: "+e);
        }
    }
    public static void main(String[] args){
        new Withdrawl("").setVisible(true);
    }
}