package Customer;
import L_And_F.*;
import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.sql.*;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;


public class changePassword extends JFrame { 
    String fname, lname, mobile, dob, gender, nationality, password;
    static String email;
    int random;
    public JPanel panel;
    public JLabel label;
    public JTextField label1Text, label2Text, otpText, label6Text, label8Text, userText;
    public JPasswordField label7Pass, labelConPass;
    public JRadioButton maleButton, femaleButton, othersButton;
    public JComboBox <String> date, month, year;
    public JButton submitButton, backButton;
    public JButton showButton, showButton1, hideButton, hideButton1, nextButton, backButton1;
    PreparedStatement ps, ps1;
    ResultSet rs, rs1;

    
    public changePassword() {



        panel = new JPanel();
        panel.setBounds(55, 0, 400, 300);
        panel.setLayout(null);
        panel.setOpaque(false);
        panel.setFocusable(true);
        panel.setBackground(new Color(238, 238, 238));



        userText = new RoundJTextField(20);
        userText.setBounds(0, 45, 280, 30);
        userText.setFont(new Font("Potro Sans Bangla", Font. PLAIN, 17));
        userText.setForeground(new Color(0, 59, 79));
        userText.setCaretColor(new Color(0, 59, 79));
        userText.setText("Enter Your Mobile");
        userText.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent event){
                if (userText.getText().equals("Enter Your Mobile")) {
                    userText.setText("");
                }
            }

            @Override
            public void focusLost (FocusEvent event) {
                if (userText.getText().equals("")){
                    userText.setText("Enter Your Mobile");
                }
            }
        });
        userText.setCaretColor(new Color(0, 59, 79));
        Border border = BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(0, 59, 79));
        userText.setBorder(border);
        panel.add(userText);

        //password
        label7Pass = new RoundJPassField(20);
        label7Pass.setBounds(0, 85, 280, 30);
        label7Pass.setFont(new Font("Potro Sans Bangla", Font. PLAIN, 17));
        label7Pass.setForeground(new Color(0, 59, 79));
        label7Pass.setCaretColor(new Color(0, 59, 79));
        label7Pass.setText("New Password");
        label7Pass.setEchoChar((char) 0);
        label7Pass.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent event){
                if (new String(label7Pass.getPassword()).equals("New Password")) {
                    label7Pass.setEchoChar((char)'*');
                    label7Pass.setText("");
                }
            }

            @Override
            public void focusLost (FocusEvent event) {
                if (new String(label7Pass.getPassword()).equals("")){
                    label7Pass.setText("New Password");
                    label7Pass.setEchoChar((char) 0);
                }
            }
        });
        panel.add(label7Pass);

        //show password button
        showButton = new JButton();
        showButton.setBounds(283, 85, 28, 30);
        //showButton.setLayout(null);
        showButton.setBackground(new Color(239, 250, 254));
        showButton.setFocusPainted(false);
        showButton.setBorder(BorderFactory.createEmptyBorder());
        ImageIcon showIcon = new ImageIcon("Pictures\\hide.png");
        showButton.setIcon(showIcon);
        panel.add(showButton);
        showButton.setVisible(true);

        //hide button
        hideButton = new JButton();
        hideButton.setBounds(283, 85, 28, 30);
        //hideButton.setLayout(null);
        hideButton.setBackground(new Color(239, 250, 254));
        hideButton.setFocusPainted(false);
        hideButton.setBorder(BorderFactory.createEmptyBorder());
        ImageIcon hideIcon = new ImageIcon("Pictures\\show.png");
        hideButton.setIcon(hideIcon);
        panel.add(hideButton);
        hideButton.setVisible(false);

        //confirm password
        labelConPass = new RoundJPassField(30);
        labelConPass.setBounds(0, 125, 280, 30);
        labelConPass.setFont(new Font("Potro Sans Bangla", Font. PLAIN, 17));
        labelConPass.setForeground(new Color(0, 59, 79));
        labelConPass.setCaretColor(new Color(0, 59, 79));
        labelConPass.setText("Confirm New Password");
        labelConPass.setEchoChar((char) 0);
        labelConPass.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent event){
                if (new String(labelConPass.getPassword()).equals("Confirm New Password")) {
                    labelConPass.setEchoChar((char)'*');
                    labelConPass.setText("");
                }
            }

            @Override
            public void focusLost (FocusEvent event) {
                if (new String(labelConPass.getPassword()).equals("")){
                    labelConPass.setText("Confirm New Password");
                    labelConPass.setEchoChar((char) 0);
                }
            }
        });
        panel.add(labelConPass);

        //show password button
        showButton1 = new JButton();
        showButton1.setBounds(283, 125, 28, 30);
        //showButton1.setLayout(null);
        showButton1.setBackground(new Color(239, 250, 254));
        showButton1.setFocusPainted(false);
        showButton1.setBorder(BorderFactory.createEmptyBorder());
        ImageIcon showIcon1 = new ImageIcon("Pictures\\hide.png");
        showButton1.setIcon(showIcon1);
        panel.add(showButton1);
        showButton1.setVisible(true);

        //hide button
        hideButton1 = new JButton();
        hideButton1.setBounds(283, 125, 28, 30);
        //hideButton1.setLayout(null);
        hideButton1.setBackground(new Color(239, 250, 254));
        hideButton1.setFocusPainted(false);
        hideButton1.setBorder(BorderFactory.createEmptyBorder());
        ImageIcon hideIcon1 = new ImageIcon("Pictures\\show.png");
        hideButton1.setIcon(hideIcon1);
        panel.add(hideButton1);
        hideButton1.setVisible(false);

        //show button action
        showButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (new String(label7Pass.getPassword()) != "New Password") {
                label7Pass.setEchoChar((char) 0);
                showButton.setVisible(false); 
                hideButton.setVisible(true);  
                }
             }
        });

        //hide button action
        hideButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (new String(label7Pass.getPassword()) != "New Password") {
                label7Pass.setEchoChar((char) '*');
                hideButton.setVisible(false);
                showButton.setVisible(true);
                }   
             }
        });

        showButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (new String(labelConPass.getPassword()) != "Confirm New Password") {
                labelConPass.setEchoChar((char) 0);
                showButton1.setVisible(false); 
                hideButton1.setVisible(true);  
                }
             }
        });

        //hide button action
        hideButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (new String(labelConPass.getPassword()) != "Confirm New Password") {
                labelConPass.setEchoChar((char) '*');
                hideButton1.setVisible(false);
                showButton1.setVisible(true);
                }   
             }
        });


        //signup button
        nextButton = new RoundJButton(50);
        nextButton.setText("Next");
        nextButton.setBounds(0, 170, 280, 35);
        nextButton.setFocusPainted(false);
        nextButton.setFont(new Font("Potro Sans Bangla", Font.PLAIN, 22));
        nextButton.setContentAreaFilled(true);
        nextButton.setBackground(new Color(0, 59, 79));
        nextButton.setForeground(Color.white);
        panel.add(nextButton);   
        nextButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseEntered(MouseEvent e) {
             nextButton.setBackground(new Color(0, 87, 117));
            }
            @Override
            public void mouseExited(MouseEvent e) {
             nextButton.setBackground(new Color(0, 59, 79));
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

        //back to logIn
        backButton = new JButton("Back to Profile");
        backButton.setBackground(new Color(238, 238, 238));
        backButton.setHorizontalAlignment(SwingConstants.LEFT);
        backButton.setBounds(0, 10, 100, 25);
        backButton.setFocusPainted(false);
        backButton.setFont(new Font("Potro Sans Bangla", Font.PLAIN, 15));
        backButton.setForeground(new Color(0, 59, 79));
        backButton.setBackground(new Color(239, 250, 254));
        backButton.setBorder(BorderFactory.createEmptyBorder());
        panel.add(backButton);
        backButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseEntered(MouseEvent e) {
             backButton.setForeground(new Color(0, 87, 117));
            }
            @Override
            public void mouseExited(MouseEvent e) {
             backButton.setForeground(new Color(0, 59, 79));
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



        JPanel OTPPanel = new JPanel();
        OTPPanel.setBounds(55, 0, 400, 250);
        OTPPanel.setLayout(null);
        OTPPanel.setOpaque(false);
        OTPPanel.setFocusable(true);
        OTPPanel.setVisible(false);
        OTPPanel.setBackground(new Color(238, 238, 238));

        JLabel otpLabel = new JLabel("OTP");
        otpLabel.setBounds(0, 50, 100, 25);
        otpLabel.setForeground(new Color(0, 87, 117));
        otpLabel.setFont(new Font("Potro Sans Bangla", Font. PLAIN, 17));
        OTPPanel.add(otpLabel);

        //OTP
        otpText = new RoundJTextField(20);
        otpText.setFont(new Font("Potro Sans Bangla", Font. PLAIN, 17));
        otpText.setForeground(new Color(0, 59, 79));
        otpText.setCaretColor(new Color(0, 59, 79));
        otpText.setBounds(0, 80, 280, 30);
        //otpText.setText(email);
        OTPPanel.add(otpText);

        //back
        backButton1 = new JButton("Back");
        backButton1.setBackground(new Color(238, 238, 238));
        backButton1.setHorizontalAlignment(SwingConstants.LEFT);
        backButton1.setBounds(0, 10, 100, 25);
        backButton1.setFocusPainted(false);
        backButton1.setFont(new Font("Potro Sans Bangla", Font.PLAIN, 15));
        backButton1.setForeground(new Color(0, 59, 79));
        backButton1.setBackground(new Color(239, 250, 254));
        backButton1.setBorder(BorderFactory.createEmptyBorder());
        OTPPanel.add(backButton1);
        backButton1.addMouseListener(new MouseListener() {
            @Override
            public void mouseEntered(MouseEvent e) {
             backButton1.setForeground(new Color(0, 87, 117));
            }
            @Override
            public void mouseExited(MouseEvent e) {
             backButton1.setForeground(new Color(0, 59, 79));
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

        submitButton = new RoundJButton(50);
        submitButton.setText("Submit");
        submitButton.setBounds(0, 130, 280, 35);
        submitButton.setFocusPainted(false);
        submitButton.setFont(new Font("Potro Sans Bangla", Font.PLAIN, 22));
        submitButton.setContentAreaFilled(true);
        submitButton.setBackground(new Color(0, 59, 79));
        submitButton.setForeground(Color.white);
        OTPPanel.add(submitButton);   
        submitButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseEntered(MouseEvent e) {
             submitButton.setBackground(new Color(0, 87, 117));
            }
            @Override
            public void mouseExited(MouseEvent e) {
             submitButton.setBackground(new Color(0, 59, 79));
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
        

        //nextButton action
        nextButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String error = errorMsg(userText.getText());
                if (error != null) {
                    JOptionPane.showMessageDialog(null, error, "Warning", 2);
                }
                else {
                    //database connection
                String query = "SELECT * FROM user_info WHERE MOBILE = '" + userText.getText() + "'" ;
                //String query = "SELECT * FROM user_info WHERE MOBILE = '01537346540'" ;
                try {
                    ps = database().prepareStatement(query);
                    rs = ps.executeQuery();
                    if (rs.next()) {
                        email = rs.getString(3);
                        password = rs.getString(7);
                        //mobile = rs.getString(8);
                    }
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }


                if (new String(label7Pass.getPassword()).equals("Password") && new String(labelConPass.getPassword()).equals("Password") ) {
                    JOptionPane.showMessageDialog(null, "Invalid Password", "Warning", 2);
                }
                else {
                    if (new String(label7Pass.getPassword()).equals(new String(labelConPass.getPassword()))) {
                        panel.setVisible(false);
                        OTPPanel.setVisible(true);

                        random = (int)Math.floor(Math.random()*(9999-1000+1)+1000);
                        sendEmail(Integer.toString(random));
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "Passwords are not same!", "Warning", 2);
                    }
                }
                }
            }
        });

        //submitButton action
        submitButton.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) { 
                if (otpText.getText().equals(Integer.toString(random))) {
                    String query1 = "UPDATE user_info SET PASSWORD = '" + new String(label7Pass.getPassword()) + "' WHERE MOBILE = '" + userText.getText() + "'" ;
                    try {
                        ps1 = database().prepareStatement(query1);
                        ps1.executeUpdate();
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                    JOptionPane.showMessageDialog(null, "Pasword Reset Successful.", "Success", 2);
                    loginDemo login = new loginDemo();
                    dispose();
                    login.setVisible(true);
                }
                else {
                    JOptionPane.showMessageDialog(null, "Invalid OTP!", "Warning", 2);

                }
        }  
        });

        //backButton action
        backButton.addActionListener(new ActionListener () {
            public void actionPerformed (ActionEvent e) {
                dispose();
                //setVisible(false);
                loginDemo login =  new loginDemo();
                login.setVisible(true);
            }
        });

        //backButton action
        backButton1.addActionListener(new ActionListener () {
            public void actionPerformed (ActionEvent e) {
                OTPPanel.setVisible(false);
                panel.setVisible(true);
            }
        });

        this.addWindowListener(new WindowAdapter() {
            public void windowClosing (WindowEvent e) {
                int result = JOptionPane.showConfirmDialog(null, "Do you want to exit?", "Exit Confirmation", JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.NO_OPTION) {
                    setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                }
                else if (result == JOptionPane.YES_OPTION){
                    File folder = new File(System.getProperty("user.dir") + "\\Customer");
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



        setTitle("Change Password"); //title
        getContentPane().setBackground(new Color(239, 250, 254));
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setSize(400,300); //sets the dimension
        setVisible(true); //makes frame visible
        setResizable(false); //diasables resizing
        setLocationRelativeTo(null);
        add(panel);
        add(OTPPanel);
    }

    public static Connection database() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/userdb", "root", "root");
            return connection;            
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        return null;
    }

    public static void sendEmail(String msg){
        String to = email;//change accordingly
        String from = "OneCash@onecash.com";//change accordingly
        String host = "localhost";//or IP address
  
       //Get the session object
        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", host);
        Session session = Session.getDefaultInstance(properties);
  
       //compose the message
        try{
           MimeMessage message = new MimeMessage(session);
           message.setFrom(new InternetAddress(from));
           message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
           message.setSubject("Reset Password");
           message.setText(msg);
  
           // Send message
           Transport.send(message);
           JOptionPane.showMessageDialog(null, "OTP is Sent", "OTP", 2);

  
        }catch (MessagingException mex) {mex.printStackTrace();}
     }

     public static String errorMsg(String recMobile) {
        String query2 = "SELECT * FROM user_info WHERE MOBILE = '" + recMobile + "'";
        try {
            PreparedStatement ps = database().prepareStatement(query2);
            ResultSet rs = ps.executeQuery();

            if (!rs.next()) {
                return "Invalid Mobile Number!";
            }
            else {
                return null;
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }

        return null;
    }
}
