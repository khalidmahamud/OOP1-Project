package Agent;
import L_And_F.*;
import javax.swing.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.*;


public class agentAddMoneyBN extends JFrame {
    //static String fname, lname, mobile, email, dob, gender, nationality, password;
    public String fname, lname, mobile, dob, gender, nationality, password;
    public static String email;
    public static double balance, newBalance;
    public static String table, row;

    //public JPanel ribbon1, ribbon2, ribbon3;
    public JButton button1, button2, button3, button4;
    public JButton sendButton, cashOutButton, rechargeButton, addButton;
    public Icon homeIcon, menuIcon, sendIcon, cashIcon;
    public PreparedStatement ps, ps1, ps2, ps3, ps4;
    public ResultSet rs, rs1, rs2, rs3, rs4;

    public JTextField addText, amountText;
    public JPasswordField addMonPass;
    public JLabel amountMSG, amountNewMSG, addLabel, addMSG, amountLabel, passLabel;
    public JButton nextButton, nextButton1, nextButton2, showButton, hideButton;
    public JPanel rechargePanel, passPanel;
    JLabel passIcon, amountIcon, rechargeIcon;

    public agentAddMoneyBN (String mobile) {

        this.mobile = mobile;

        JLabel label = new JLabel();
        label.setSize(750, 463);

        ImageIcon bg = new ImageIcon("bg.png");
        Image bgIMG = bg.getImage();
        Image bgIMGScale = bgIMG.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon bgScaled = new ImageIcon(bgIMGScale);
        label.setIcon(bgScaled);
        setContentPane(label);


        //database connection
        String query = "SELECT * FROM agent_info WHERE MOBILE = '" + mobile + "'" ;
        //String query = "SELECT * FROM agent_info WHERE MOBILE = '01537346540'" ;
        try {
            ps = database().prepareStatement(query);
            rs = ps.executeQuery();
            if (rs.next()) {
                fname = rs.getString(1);
                lname = rs.getString(2);
                email = rs.getString(3);
                gender = rs.getString(4);
                dob = rs.getString(5);
                nationality = rs.getString(6);
                password = rs.getString(7);
                //mobile = rs.getString(8);
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }

        String query1 = "SELECT * FROM agentAccount WHERE MOBILE = '" + mobile + "'" ;
        //String query1 = "SELECT * FROM account WHERE MOBILE = '01537346540'" ;
        try {
            ps1 = database().prepareStatement(query1);
            rs1 = ps1.executeQuery();
            if (rs1.next()) {
                balance = rs1.getDouble(2);
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }

        //home button
        button1 = new RoundJButton(237);
        button1.setBounds(10, 75, 237, 50);
        button1.setBackground(new Color(0, 59, 79));
        button1.setBorder(BorderFactory.createEmptyBorder());
        button1.setFocusPainted(false);
        homeIcon = new ImageIcon("home.png");
        button1.setIcon(homeIcon);
        button1.setText("হোম");
        button1.setFont(new Font("Potro Sans Bangla", Font.PLAIN, 25));
        button1.setIconTextGap(20);
        button1.setForeground(Color.white);
        add(button1);
        button1.addMouseListener(new MouseListener() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button1.setBackground(new Color(0, 87, 117));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                button1.setBackground(new Color(0, 59, 79));
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


        //history button
        button2 = new RoundJButton(242);
        button2.setBounds(250, 75, 242, 50);
        button2.setBackground(new Color(0, 59, 79));
        button2.setBorder(BorderFactory.createEmptyBorder());
        ImageIcon historyIcon = new ImageIcon("history.png");
        button2.setIcon(historyIcon);
        button2.setText("লেনদেন");
        button2.setFont(new Font("Potro Sans Bangla", Font.PLAIN, 25));
        button2.setIconTextGap(10);
        button2.setForeground(Color.white);
        add(button2);
        button2.addMouseListener(new MouseListener() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button2.setBackground(new Color(0, 87, 117));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                button2.setBackground(new Color(0, 59, 79));
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

        //menu button
        button3 = new RoundJButton(232);
        button3.setBounds(495, 75, 232, 50);
        button3.setBackground(new Color(0, 59, 79));
        button3.setBorder(BorderFactory.createEmptyBorder());
        menuIcon = new ImageIcon("menu.png");
        button3.setIcon(menuIcon);
        button3.setText("মেনু");
        button3.setFont(new Font("Potro Sans Bangla", Font.PLAIN, 25));
        button3.setForeground(Color.WHITE);
        button3.setIconTextGap(20);
        button3.setFocusPainted(false);
        add(button3);
        button3.addMouseListener(new MouseListener() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button3.setBackground(new Color(0, 87, 117));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                button3.setBackground(new Color(0, 59, 79));
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

        //profile button
        button4 = new JButton(new ImageIcon("profile.png"));
        button4.setBounds(675, 15, 40, 40);
        button4.setBackground(new Color(238, 238, 238));
        button4.setBorder(BorderFactory.createEmptyBorder());
        add(button4);

        JLabel uMobile = new JLabel();
        uMobile.setText(mobile);
        uMobile.setBounds(390, 19, 280, 15);
        uMobile.setHorizontalAlignment(JLabel.RIGHT);
        uMobile.setFont(new Font("Potro Sans Bangla", Font.PLAIN, 15));
        uMobile.setForeground(new Color(0, 59, 79));
        add(uMobile);
        JLabel uName = new JLabel();
        uName.setText(fname+" "+lname);
        uName.setBounds(390, 39, 280, 18);
        uName.setHorizontalAlignment(JLabel.RIGHT);
        uName.setFont(new Font("Potro Sans Bangla", Font.PLAIN, 16));
        uName.setForeground(new Color(0, 59, 79));
        add(uName);

        amountMSG = new JLabel();
        amountMSG.setText("বর্তমান ব্যালেন্স: " + balance + " টাকা");
        amountMSG.setBounds(250,140,300,20);
        amountMSG.setFont(new Font("Potro Sans Bangla", Font.PLAIN, 20));
        amountMSG.setForeground(new Color(0, 87, 117));
        add(amountMSG);
        amountNewMSG = new JLabel();
        amountNewMSG.setBounds(250,140,300,20);
        amountNewMSG.setFont(new Font("Potro Sans Bangla", Font.PLAIN, 20));
        amountNewMSG.setForeground(new Color(0, 87, 117));
        amountNewMSG.setVisible(false);
        add(amountNewMSG);


        rechargePanel = new JPanel();
        rechargePanel.setBounds(0, 124, 375, 400);
        //rechargePanel.setBackground(new Color(217, 243, 244, 05));
        rechargePanel.setOpaque(false);
        rechargePanel.setLayout(null);
        add(rechargePanel);

        rechargeIcon = new JLabel(new ImageIcon("voucher.png"));
        rechargeIcon.setBounds(35,105,30,30);
        rechargePanel.add(rechargeIcon);

        addLabel = new JLabel("রিচার্জ");
        addLabel.setBounds(70,75,240,30);
        addLabel.setForeground(new Color(0, 87, 117));
        addLabel.setFont(new Font("Potro Sans Bangla", Font.PLAIN, 16));
        rechargePanel.add(addLabel);

        addText = new JTextField(20);
        addText.setBounds(70,105,240,30);
        addText.setFont(new Font("Potro Sans Bangla", Font.PLAIN, 20));
        addText.setForeground(new Color(0, 59, 79));
        addText.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0,new Color(0, 59, 79)));
        addText.setBackground(Color.white);
        rechargePanel.add(addText);

        addMSG = new JLabel("সঠিক রিচার্জ কোড প্রবেশ করান");
        addMSG.setFont(new Font("Potro Sans Bangla", Font.PLAIN, 12));
        addMSG.setForeground(new Color(0, 87, 117));
        addMSG.setBounds(70, 145, 240, 15);
        rechargePanel.add(addMSG);

        amountLabel = new JLabel("রিচার্জের পরিমাণ");
        amountLabel.setBounds(70,165,240,30);
        amountLabel.setForeground(new Color(0, 87, 117));
        amountLabel.setFont(new Font("Potro Sans Bangla", Font.PLAIN, 16));
        amountLabel.setVisible(false);
        rechargePanel.add(amountLabel);

        amountIcon = new JLabel(new ImageIcon("taka.png"));
        amountIcon.setBounds(35,195,30,30);
        amountIcon.setVisible(false);
        rechargePanel.add(amountIcon);

        amountText = new JTextField(20);
        amountText.setBounds(70,195,240,30);
        amountText.setFont(new Font("Potro Sans Bangla", Font.PLAIN, 20));
        amountText.setForeground(new Color(0, 59, 79));
        amountText.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0,new Color(0, 59, 79)));
        amountText.setBackground(Color.white);
        amountText.setVisible(false);
        amountText.setEditable(false);
        rechargePanel.add(amountText);

        nextButton = new RoundJButton(120);
        nextButton.setBackground(new Color(0, 59, 79));
        nextButton.setForeground(Color.white);
        nextButton.setText("পরবর্তী");
        nextButton.setFont(new Font("Potro Sans Bangla", Font.PLAIN, 22));
        nextButton.setFocusPainted(false);
        nextButton.setBounds(120,170,120,35);
        rechargePanel.add(nextButton);
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

        nextButton.addActionListener(new ActionListener () {
            public void actionPerformed(ActionEvent e) {
                if (addText.getText().isBlank()) {
                    JOptionPane.showMessageDialog(null, "Invalid Recharge Code", "Recharge", 2);
                }
                else if (addText.getText().charAt(0) == 'C') {
                    table = "hundred";
                    row = "HUN";
                    String query = "SELECT * FROM hundred WHERE HUN = '" + addText.getText() + "'" ;
                    //String query1 = "UPDATE account SET BALANCE = '" + newBalance + "' WHERE MOBILE = '" + mobile + "'" ;
                    try {
                        ps2 = database().prepareStatement(query);
                        rs2 = ps2.executeQuery();
                        if (rs2.next()) {
                            amountText.setText("100");
                            nextButton.setVisible(false);
                            amountLabel.setVisible(true);
                            amountIcon.setVisible(true);
                            amountText.setVisible(true);
                            nextButton1.setVisible(true);

                        }
                        else {
                            JOptionPane.showMessageDialog(null, "Invalid Recharge Code", "Recharge", 2);
                        }
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                }
                else if (addText.getText().charAt(0) == 'D') {
                    table = "5hundred";
                    row = "5HUN";
                    String query = "SELECT * FROM 5hundred WHERE 5HUN = '" + addText.getText() + "'" ;
                    //String query1 = "UPDATE account SET BALANCE = '" + newBalance + "' WHERE MOBILE = '" + mobile + "'" ;
                    try {
                        ps2 = database().prepareStatement(query);
                        rs2 = ps2.executeQuery();
                        if (rs2.next()) {
                            amountText.setText("500");
                            nextButton.setVisible(false);
                            amountLabel.setVisible(true);
                            amountIcon.setVisible(true);
                            amountText.setVisible(true);
                            nextButton1.setVisible(true);

                        }
                        else {
                            JOptionPane.showMessageDialog(null, "Invalid Recharge Code", "Recharge", 2);
                        }
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                }
                else if (addText.getText().charAt(0) == 'M') {
                    table = "thousand";
                    row = "THOUS";
                    String query = "SELECT * FROM thousand WHERE THOUS = '" + addText.getText() + "'" ;
                    //String query1 = "UPDATE account SET BALANCE = '" + newBalance + "' WHERE MOBILE = '" + mobile + "'" ;
                    try {
                        ps2 = database().prepareStatement(query);
                        rs2 = ps2.executeQuery();
                        if (rs2.next()) {
                            amountText.setText("1000");
                            nextButton.setVisible(false);
                            amountLabel.setVisible(true);
                            amountIcon.setVisible(true);
                            amountText.setVisible(true);
                            nextButton1.setVisible(true);

                        }
                        else {
                            JOptionPane.showMessageDialog(null, "Invalid Recharge Code", "Recharge", 2);
                        }
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                }
                else {
                    JOptionPane.showMessageDialog(null, "Invalid Recharge Code", "Recharge", 2);
                }
            }
        });

        passPanel = new JPanel();
        passPanel.setBounds(375, 124, 375, 350);
        passPanel.setLayout(null);
        passPanel.setOpaque(false);
        passPanel.setVisible(false);
        add(passPanel);

        passLabel = new JLabel("পাসওয়ার্ড");
        passLabel.setBounds(70,110,240,20);
        passLabel.setFont(new Font("Potro Sans Bangla", Font.PLAIN, 16));
        passLabel.setForeground(new Color(0, 87, 117));
        passPanel.add(passLabel);

        passIcon = new JLabel(new ImageIcon("password.png"));
        passIcon.setBounds(35,140,30,30);
        passPanel.add(passIcon);

        addMonPass = new JPasswordField(20);
        addMonPass.setBounds(70,140,240,30);
        //addMonPass.setText("khalid000");
        addMonPass.setFont(new Font("Potro Sans Bangla", Font.PLAIN, 20));
        addMonPass.setBackground(Color.white);
        addMonPass.setForeground(new Color(0, 59, 79));
        addMonPass.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(0, 59, 79)));
        addMonPass.setEchoChar((char) '*');
        passPanel.add(addMonPass);

        //show password button
        showButton = new JButton();
        showButton.setBounds(315, 142, 28, 25);
        showButton.setBackground(new Color(238, 238, 238));
        showButton.setFocusPainted(false);
        showButton.setBorder(BorderFactory.createEmptyBorder());
        ImageIcon showIcon = new ImageIcon("hide.png");
        showButton.setIcon(showIcon);
        passPanel.add(showButton);
        showButton.setVisible(true);

        //hide button
        hideButton = new JButton();
        hideButton.setBounds(315, 142, 28, 25);
        hideButton.setBackground(new Color(238, 238, 238));
        hideButton.setFocusPainted(false);
        hideButton.setBorder(BorderFactory.createEmptyBorder());
        ImageIcon hideIcon = new ImageIcon("show.png");
        hideButton.setIcon(hideIcon);
        passPanel.add(hideButton);
        hideButton.setVisible(false);


        //show button action
        showButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addMonPass.setEchoChar((char) 0);
                showButton.setVisible(false);
                hideButton.setVisible(true);
            }
        });

        //hide button action
        hideButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addMonPass.setEchoChar((char) '*');
                hideButton.setVisible(false);
                showButton.setVisible(true);
            }
        });



        nextButton1 = new RoundJButton(120);
        nextButton1.setBackground(new Color(0, 59, 79));
        nextButton1.setForeground(Color.white);
        nextButton1.setText("পরবর্তী");
        nextButton1.setFont(new Font("Potro Sans Bangla", Font.PLAIN, 22));
        nextButton1.setFocusPainted(false);
        nextButton1.setBounds(120,250,120,35);
        nextButton1.setVisible(false);
        rechargePanel.add(nextButton1);
        nextButton1.addMouseListener(new MouseListener() {
            @Override
            public void mouseEntered(MouseEvent e) {
                nextButton1.setBackground(new Color(0, 87, 117));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                nextButton1.setBackground(new Color(0, 59, 79));
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

        nextButton1.addActionListener(new ActionListener () {
            public void actionPerformed (ActionEvent e) {
                passPanel.setVisible(true);
            }
        });


        nextButton2 = new RoundJButton(120);
        nextButton2.setBackground(new Color(0, 59, 79));
        nextButton2.setForeground(Color.white);
        nextButton2.setText("পরবর্তী");
        nextButton2.setFont(new Font("Potro Sans Bangla", Font.PLAIN, 22));
        nextButton2.setFocusPainted(false);
        nextButton2.setBounds(120,250,120,35);
        nextButton2.setVisible(true);
        passPanel.add(nextButton2);
        nextButton2.addMouseListener(new MouseListener() {
            @Override
            public void mouseEntered(MouseEvent e) {
                nextButton2.setBackground(new Color(0, 87, 117));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                nextButton2.setBackground(new Color(0, 59, 79));
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



        nextButton2.addActionListener(new ActionListener () {
            public void actionPerformed (ActionEvent e) {
                if (password.equals(new String(addMonPass.getPassword()))) {
                    newBalance = balance + Double.parseDouble(amountText.getText());
                    String query3 = "INSERT INTO " + mobile + "trans(INCOMING, DATE, AMOUNT) VALUES ('IN', '" + getDateTime() + "','"+ Double.parseDouble(amountText.getText()) + "')";

                    try {
                        ps2 = database().prepareStatement(query);
                        rs2 = ps2.executeQuery();

                        String query1 = "DELETE from " + table + " WHERE " + row + " = '" + addText.getText() + "'" ;
                        ps3 = database().prepareStatement(query1);
                        ps3.executeUpdate();

                        //String query2 = "UPDATE account SET BALANCE = '" + newBalance + "' WHERE MOBILE = '01537346540'";
                        String query2 = "UPDATE agentAccount SET BALANCE = '" + newBalance + "' WHERE MOBILE = '" + mobile + "'" ;
                        ps4 = database().prepareStatement(query2);
                        ps4.executeUpdate();

                        ps3 = database().prepareStatement(query3);
                        ps3.executeUpdate();


                        String msg = "Recharge Successfull.\n" + Double.toString(newBalance);
                        JOptionPane.showMessageDialog(null, msg, "Recharge", 2);

                        amountMSG.setVisible(false);
                        amountNewMSG.setText("Current Balance: " + newBalance + " Tk.");
                        amountNewMSG.setVisible(true);
                        passPanel.setVisible(false);
                        nextButton.setVisible(true);
                        amountLabel.setVisible(false);
                        amountIcon.setVisible(false);
                        amountText.setVisible(false);
                        nextButton1.setVisible(false);

                        String email1 = "Tk " + amountText.getText() + " added to " + mobile + ", Your A/C Balance: Tk " + Double.toString(newBalance) + ", TxnId: " + addText.getText() + ", Date: " + getDateTime();
                        sendEmail(email1, "Add Money");


                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                }
                else {
                    JOptionPane.showMessageDialog(null, "Incorrect Password!", "Error", 2);
                }
            }
        });




        //home button action
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                agentHomePageBN home = new agentHomePageBN(mobile);

                //setVisible(false);
                dispose();
                home.setVisible(true);
            }
        });

        //history button action
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                agentHistoryPageBN history = new agentHistoryPageBN(mobile);

                dispose();
                //setVisible(false);
                history.setVisible(true);
            }
        });

        //menu button action
        button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                 agentMenuPage menu = new agentMenuPage(mobile);

                dispose();
                //setVisible(false);
                 menu.setVisible(true);
            }
        });

        //profile button action
        button4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                agentProfilePageBN profile = new agentProfilePageBN(mobile);

                dispose();
//                setVisible(false);
                profile.setVisible(true);
            }
        });
		
		JButton backButton = new JButton();
        backButton.setBounds(10,130, 30, 30);
        backButton.setBackground(new Color(223, 245, 247));
        backButton.setBorder(BorderFactory.createEmptyBorder());
        backButton.setFocusPainted(false);
        ImageIcon backIcon = new ImageIcon("back.png");
        Image backImg = backIcon.getImage();
        Image backImgScale = backImg.getScaledInstance(backButton.getWidth(), backButton.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon backScaled = new ImageIcon(backImgScale);
        backButton.setIcon(backScaled);
        add(backButton);

        backButton.addActionListener(new ActionListener () {
            public void actionPerformed(ActionEvent e) {
                agentHomePageBN home = new agentHomePageBN(mobile);
                home.setVisible(true);
                dispose();
            }
        });

        this.addWindowListener(new WindowAdapter() {
            public void windowClosing (WindowEvent e) {
                int result = JOptionPane.showConfirmDialog(null, "Do you want to exit?", "Exit Confirmation", JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.NO_OPTION) {
                    setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                }
                else if (result == JOptionPane.YES_OPTION){
                    File folder = new File("D:\\Java Projects\\GUI Project\\OneCash");
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


        setTitle("Agent Add Money"); //title
        getContentPane().setBackground(new Color(217, 243, 244));
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setSize(750,500); //sets the dimension
        setVisible(true); //makes frame visible
        setResizable(false); //diasables resizing
        setLocationRelativeTo(null);
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
    public static String getDateTime() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Date date = new Date();
        String date_time = formatter.format(date);
        return  date_time;
    }

    public static void sendEmail(String msg, String sub){
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
           message.setSubject(sub);
           message.setText(msg);
  
           // Send message
           Transport.send(message);
           //JOptionPane.showMessageDialog(null, "OTP is Sent", "OTP", 2);

  
        }catch (MessagingException mex) {mex.printStackTrace();}
     }

    /*public static void main(String [] args) {
        new addMoney(mobile);
    }*/
}

