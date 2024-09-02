import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {

    JLabel l1, l2;
    JButton b1, b2, b3, b4, b5, b6, b7, b8;
    JTextField t1;
    String pin;
    Connection c11;

    FastCash(String pin) {
        this.pin = pin;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800, 800, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0, 0, 800, 800);
        add(l3);

        l1 = new JLabel("SELECT WITHDRAWL AMOUNT");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("Cambria", Font.BOLD, 20));

        b1 = new JButton("Rs 100");
        b2 = new JButton("Rs 500");
        b3 = new JButton("Rs 1000");
        b4 = new JButton("Rs 2000");
        b5 = new JButton("Rs 5000");
        b6 = new JButton("Rs 10000");
        b7 = new JButton("BACK");

        setLayout(null);

        l1.setBounds(275, 90, 700, 35);
        l3.add(l1);

        b1.setBounds(210, 155, 150, 35);
        l3.add(b1);

        b2.setBounds(440, 155, 150, 35);
        l3.add(b2);

        b3.setBounds(210, 200, 150, 35);
        l3.add(b3);

        b4.setBounds(440, 200, 150, 35);
        l3.add(b4);

        b5.setBounds(210, 250, 150, 35);
        l3.add(b5);

        b6.setBounds(440, 250, 150, 35);
        l3.add(b6);

        b7.setBounds(440, 300, 150, 35);
        l3.add(b7);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);

        // connection building here
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            c11=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1821");
             }
                 catch(Exception e)
             {
               System.out.println(e);
             }

        setSize(800, 720);
        setLocation(200, 0);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    public void actionPerformed(ActionEvent ae) {
        try {
            String amount = ((JButton)ae.getSource()).getText().substring(3); 
            Statement st = c11.createStatement();
            ResultSet rs = st.executeQuery("select * from bank where pin = '"+pin+"'");
            int balance = 0;
            while (rs.next()) {
                if (rs.getString("mode").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            } String num = "17";
            if (ae.getSource() != b7 && balance < Integer.parseInt(amount)) {
                JOptionPane.showMessageDialog(null, "Insuffient Balance");
                return;
            }

            if (ae.getSource() == b7) {
                this.setVisible(false);
                new Transactions(pin).setVisible(true);
            }else {
                Date date = new Date();
                st.executeUpdate("insert into bank values('"+pin+"', '"+date+"', 'Withdrawl', '"+amount+"')");
                JOptionPane.showMessageDialog(null, "Rs. "+amount+" Debited Successfully");
                    
                setVisible(false);
                new Transactions(pin).setVisible(true);
            }
            if(ae.getSource()==b7)
            {
                setVisible(false);
                new Transactions().setVisible(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new FastCash("").setVisible(true);
    }
}
