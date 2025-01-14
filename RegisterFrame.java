import java.awt.Container;
import java.awt.Font;
import javax.swing.*;
public class RegisterFrame extends JFrame {
    JLabel message;
    JLabel nameLabel, dobLabel, genderLabel, dobFormat;
    JTextField nameField, dobField;
    JRadioButton genderMale, genderFemale;
    ButtonGroup genderGroup;
    JLabel mailIdLabel, mobileNoLabel;
    JTextField mailIdField, mobileNoField;
    JLabel passwordLabel, rePasswordLabel;
    JPasswordField passwordField, rePasswordField;
    JLabel programLabel;
    JComboBox<String> programList;
    JLabel branchLabel, semesterLabel;
    JComboBox<String> branchList;
    JComboBox<Integer> semesterList;
    JButton registerButton;
    Container container;
    public RegisterFrame() {
        message = new JLabel("Register a new Student");
        message.setFont(new Font("Times New Roman", Font.BOLD, 20));
        nameLabel = new JLabel("Name :");
        nameLabel.setFont(new Font("Times New Roman", Font.BOLD,14));
        nameField = new JTextField();
        dobLabel = new JLabel("DOB :");
        dobLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
        dobField = new JTextField();
        genderLabel = new JLabel("Gender :");
        genderLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
        genderMale = new JRadioButton("Male");
        genderMale.setFont(new Font("Times New Roman", Font.BOLD, 14));
        genderFemale = new JRadioButton("Female");
        genderFemale.setFont(new Font("Times New Roman", Font.BOLD, 14));
        genderGroup = new ButtonGroup();
        genderGroup.add(genderMale);
        genderGroup.add(genderFemale);
        mailIdLabel = new JLabel("Mail Id :");
        mailIdLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
        mailIdField = new JTextField();
        mobileNoLabel = new JLabel("Mobile No :");
        mobileNoLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
        mobileNoField = new JTextField();
        passwordLabel = new JLabel("Password :");
        passwordLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
        passwordField = new JPasswordField();
        rePasswordLabel = new JLabel("Re Password :");
        rePasswordLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
        rePasswordField = new JPasswordField();
        programLabel = new JLabel("Courses :");
        programLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
        programList = new JComboBox<String>();
        programList.setFont(new Font("Times New Roman", Font.BOLD, 14));
        programList.addItem("ME/M Tech");
        programList.addItem("BE/B Tech");
        programList.addItem("Diploma");
        branchLabel = new JLabel("Branch :");
        branchLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
        branchList = new JComboBox<String>();
        branchList.setFont(new Font("Times New Roman", Font.BOLD, 14));
        branchList.addItem("Computer Science and Engineering");
        branchList.addItem("Electronics and Telecommunications");
        branchList.addItem("Information Technology");
        branchList.addItem("Electrical Engineering");
        branchList.addItem("Electrical and Electronics Engineering");
        branchList.addItem("Civil Engineering");
        semesterLabel = new JLabel("Semester");
        semesterLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
        semesterList = new JComboBox<>();
        semesterList.setFont(new Font("Times New Roman", Font.BOLD, 14));
        semesterList.addItem(1);
        semesterList.addItem(2);
        semesterList.addItem(3);
        semesterList.addItem(4);
        semesterList.addItem(5);
        semesterList.addItem(6);
        semesterList.addItem(7);
        semesterList.addItem(8);
        registerButton = new JButton("Register");
        registerButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
        container = getContentPane();
        container.setLayout(null);
        setBounds();
        addComponents();
    }
    public void setBounds() {
        message.setBounds(140, 10, 600, 30);
        nameLabel.setBounds(80, 60, 100, 30);
        nameField.setBounds(180, 60, 200, 30);
        dobLabel.setBounds(80, 110, 100, 30);
        dobField.setBounds(180, 110,200 , 30);
        genderLabel.setBounds(80, 160, 100, 30);
        genderMale.setBounds(180, 160, 100, 30);
        genderFemale.setBounds(290, 160, 100, 30);
        mailIdLabel.setBounds(80, 210, 100, 30);
        mailIdField.setBounds(180, 210, 200, 30);
        mobileNoLabel.setBounds(80, 260, 100, 30);
        mobileNoField.setBounds(180, 260, 200, 30);
        passwordLabel.setBounds(80, 310, 100, 30);
        passwordField.setBounds(180, 310, 200, 30);
        rePasswordLabel.setBounds(80, 360, 100, 30);
        rePasswordField.setBounds(180, 360, 200, 30);
        programLabel.setBounds(80, 410, 100, 30);
        programList.setBounds(180, 410, 200, 30);
        branchLabel.setBounds(80, 460, 100, 30);
        branchList.setBounds(180, 460, 200, 30);
        semesterLabel.setBounds(80, 510, 100, 30);
        semesterList.setBounds(180, 510, 200, 30);
        registerButton.setBounds(180, 550, 200, 30);
    }
    public void addComponents() {
        container.add(message);
        container.add(nameLabel);
        container.add(nameField);
        container.add(dobLabel);
        container.add(dobField);
        container.add(genderLabel);
        container.add(genderMale);
        container.add(genderFemale);
        container.add(mailIdLabel);
        container.add(mailIdField);
        container.add(mobileNoLabel);
        container.add(mobileNoField);
        container.add(passwordLabel);
        container.add(passwordField);
        container.add(rePasswordLabel);
        container.add(rePasswordField);
        container.add(programLabel);
        container.add(programList);
        container.add(branchLabel);
        container.add(branchList);
        container.add(semesterLabel);
        container.add(semesterList);
        container.add(registerButton);
    }
    public static void main(String[] args) {
        RegisterFrame frame = new RegisterFrame();
        frame.setTitle("Student Register Form");
        frame.setVisible(true);
        frame.setBounds(300, 20, 500, 650);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(true);
    }
}