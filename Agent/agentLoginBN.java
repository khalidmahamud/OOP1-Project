package Agent;
import L_And_F.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.io.File;
//import java.io.File;
import java.sql.*;

public class agentLoginBN extends JFrame {

    public JPanel panel, loginPanel;
    public JLabel label, label2, label3, showLabel, hideLabel;
    public JTextField userText;
    public JPasswordField pass;
    public JButton logInButton, signUpButton, changePassButton;
    public JButton showButton, hideButton;
    String fname, lname, mobile, password;
    PreparedStatement ps;
    ResultSet rs;


    public agentLoginBN () {

        JLabel label = new JLabel();
        label.setSize(350, 470);

        ImageIcon bg = new ImageIcon("Pictures\\pic2.jpeg");
        Image bgIMG = bg.getImage();
        Image bgIMGScale = bgIMG.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon bgScaled = new ImageIcon(bgIMGScale);
        label.setIcon(bgScaled);

        //left panel
        panel = new JPanel();
        panel.setBounds(0, 0, 350, 500);
        panel.setBackground(new Color(238, 238, 238));
        panel.setLayout(null);
        panel.add(label);

        //right panel
        loginPanel = new JPanel();
        loginPanel.setBounds(350, 0, 400, 500);
        loginPanel.setBackground(new Color(217, 243, 244));
        loginPanel.setLayout(null);
        loginPanel.setFocusable(true);

        label3 = new JLabel("এজেন্ট লগ ইন");
        label3.setFont(new Font("Potro Sans Bangla", Font.BOLD, 30));
        label3.setBounds(50, 50, 200, 50);
        label3.setForeground(new Color(0, 59, 79));
        loginPanel.add(label3);


        //textfield
        userText = new JTextField(20);
        userText.setBounds(50, 170, 280, 25);
        userText.setFont(new Font("Potro Sans Bangla", Font. PLAIN, 20));
        userText.setBackground(Color.white);
        userText.setForeground(new Color(0, 59, 79));
        userText.setText("মোবাইল");
        userText.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent event){
                if (userText.getText().equals("মোবাইল")) {
                    userText.setText("");
                }
            }

            @Override
            public void focusLost (FocusEvent event) {
                if (userText.getText().equals("")){
                    userText.setText("মোবাইল");
                }
            }
        });
        userText.setCaretColor(new Color(0, 59, 79));
        loginPanel.add(userText);
        Border border = BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(0, 59, 79));
        userText.setBorder(border);



        //passwordfield
        pass = new JPasswordField();
        pass.setBounds(50, 226, 250, 25);
        pass.setFont(new Font("Potro Sans Bangla", Font. PLAIN, 20));
        pass.setCaretColor(new Color(0, 59, 79));
        pass.setBackground(Color.white);
        pass.setForeground(new Color(0, 59, 79));
        pass.setText("পাসওয়ার্ড");
        pass.setEchoChar((char) 0);
        pass.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent event){
                if (new String(pass.getPassword()).equals("পাসওয়ার্ড")) {
                    pass.setEchoChar((char)'*');
                    pass.setText("");
                }
            }

            @Override
            public void focusLost (FocusEvent event) {
                if (new String(pass.getPassword()).equals("")){
                    pass.setText("পাসওয়ার্ড");
                    pass.setEchoChar((char) 0);
                }
            }
        });

        loginPanel.add(pass);
        Border border1 = BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(0, 59, 79));
        pass.setBorder(border1);

        //login button
        logInButton = new RoundJButton(50);
        logInButton.setText("লগ ইন");
        logInButton.setBounds(50, 275, 280, 30);
        logInButton.setFocusPainted(false);
        logInButton.setFont(new Font("Potro Sans Bangla", Font.PLAIN, 20));
        logInButton.setContentAreaFilled(true);
        logInButton.setBackground(new Color(0, 59, 79));
        logInButton.setForeground(Color.white);
        loginPanel.add(logInButton);
        logInButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseEntered(MouseEvent e) {
                logInButton.setBackground(new Color(0, 87, 117));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                logInButton.setBackground(new Color(0, 59, 79));
            }
            @Override
            public void mouseClicked(MouseEvent e) {

            }
            @Override
            public void mousePressed(MouseEvent e) {

            }
            @Override
            public void mouseReleased(MouseEvent e) {

            }
        });

        //signup button
        signUpButton = new RoundJButton(50);
        signUpButton.setText("নতুন অ্যাকাউন্ট তৈরি করুন");
        signUpButton.setBounds(50, 343, 280, 35);
        signUpButton.setFocusPainted(false);
        signUpButton.setFont(new Font("Potro Sans Bangla", Font.PLAIN, 20));
        signUpButton.setContentAreaFilled(true);
        signUpButton.setBackground(new Color(0, 59, 79));
        signUpButton.setForeground(Color.white);
        loginPanel.add(signUpButton);
        signUpButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseEntered(MouseEvent e) {
                signUpButton.setBackground(new Color(0, 87, 117));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                signUpButton.setBackground(new Color(0, 59, 79));
            }
            @Override
            public void mouseClicked(MouseEvent e) {

            }
            @Override
            public void mousePressed(MouseEvent e) {

            }
            @Override
            public void mouseReleased(MouseEvent e) {

            }
        });

        //password change button
        changePassButton = new JButton("পাসওয়ার্ড ভুলে গেছেন?");
        changePassButton.setBackground(new Color(217, 243, 244));
        changePassButton.setBounds(50, 315, 280, 20);
        changePassButton.setFocusPainted(false);
        changePassButton.setFont(new Font("Potro Sans Bangla", Font.PLAIN, 17));
        changePassButton.setForeground(Color.red);
        changePassButton.setBorder(BorderFactory.createEmptyBorder());
        loginPanel.add(changePassButton);

        //show password button
        showButton = new JButton();
        showButton.setBounds(300, 226, 28, 25);
        //showButton.setLayout(null);
        showButton.setBackground(Color.white);
        showButton.setFocusPainted(false);
        showButton.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(0, 59, 79)));
        ImageIcon showIcon = new ImageIcon("Pictures\\hide.png");
        showButton.setIcon(showIcon);
        loginPanel.add(showButton);
        showButton.setVisible(true);

        //hide button
        hideButton = new JButton();
        hideButton.setBounds(300, 226, 28, 25);
        //hideButton.setLayout(null);
        hideButton.setBackground(Color.white);
        hideButton.setFocusPainted(false);
        hideButton.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(0, 59, 79)));
        ImageIcon hideIcon = new ImageIcon("Pictures\\show.png");
        hideButton.setIcon(hideIcon);
        loginPanel.add(hideButton);
        hideButton.setVisible(false);


        //show button action
        showButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (new String(pass.getPassword()) != "Password") {
                    showButton.setEnabled(true);
                    pass.setEchoChar((char) 0);
                    showButton.setVisible(false);
                    hideButton.setVisible(true);
                }
            }

        });

        //hide button action
        hideButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (new String(pass.getPassword()) != "Password") {
                    pass.setEchoChar((char) '*');
                    hideButton.setVisible(false);
                    showButton.setVisible(true);
                }
            }
        });






        //logInButton action
        logInButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mobile = userText.getText();
                password = new String(pass.getPassword());

                String query = "SELECT * FROM `agent_info` WHERE `MOBILE` =? AND `PASSWORD` =?";

                //database connection
                try {
                    //Class.forName("com.mysql.jdbc.Driver");
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/userdb", "root", "root");
                    ps = connection.prepareStatement(query);
                    ps.setString(1, mobile);
                    ps.setString(2, password);

                    rs = ps.executeQuery();

                    if(rs.next())
                    {
                        agentHomePageBN home = new agentHomePageBN (mobile);
                        setVisible(false);
                        home.setVisible(true);
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Incorrect Mobile Or Password", "Login Failed", 2);
                    }

                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });

        //signUpButton action
        signUpButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                agentSignUpBN signUp = new agentSignUpBN();

                //setVisible(false);
                dispose();
                signUp.setVisible(true);
            }
        });

        //change password button action
        changePassButton.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent e) {
                agentChangePassBN change = new agentChangePassBN ();
                dispose();
                change.setVisible(true);
            }
        });

        this.addWindowListener(new WindowAdapter() {
            public void windowClosing (WindowEvent e) {
                int result = JOptionPane.showConfirmDialog(null, "Do you want to exit?", "Exit Confirmation", JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.NO_OPTION) {
                    setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                }
                else if (result == JOptionPane.YES_OPTION){
                    File folder = new File(System.getProperty("user.dir") + "\\Agent");
                    File fList[] = folder.listFiles();

                    for (File f : fList) {
                        if (f.getName().endsWith(".class")) {
                            f.delete();
                        }
                    }
                    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                }
            }
        });


        this.setTitle("Agent Login"); //title
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(750,500); //sets the dimension
        this.setVisible(true); //makes frame visible
        this.setResizable(false); //diasables resizing
        this.setLocationRelativeTo(null);

        this.add(panel);
        this.add(loginPanel);
    }

}
