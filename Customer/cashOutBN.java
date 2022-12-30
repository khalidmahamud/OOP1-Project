package Customer;
import L_And_F.*;
import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.regex.*;



public class cashOutBN extends JFrame {
    //public static String fname, lname, mobile, email, dob, gender, nationality, password;
    public static double balance,newBalance, recBalance;
    public String fname, lname, mobile, email, dob, gender, nationality, password;

    public JPanel ribbon1, ribbon2, ribbon3, recipientPanel, recipientPanel1;
    public JButton button1, button2, button3, button4;
    public JButton sendButton, cashOutButton, rechargeButton, addButton;
    public Icon homeIcon, menuIcon, sendIcon, cashIcon;
    public JLabel sendLabel, cashLabel, rechargeLabel, addLabel; 
    public JLabel recipientLabel, recipientIcon, recipientMSG, amountLabel, amountIcon, amountMSG, recipientPassLabel, recipientPassIcon;
    JButton nextButton1, nextButton2, showButton, hideButton;
    public JTextField recipientText, amountText;
    public JPasswordField recipientPass;
    public PreparedStatement ps, ps1, ps2, ps3,ps4;
    public ResultSet rs, rs1, rs2,rs3, rs4;

    cashOutBN(String mobile) {

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
        String query = "SELECT * FROM user_info WHERE MOBILE = '" + mobile + "'" ;
        //String query = "SELECT * FROM user_info WHERE MOBILE = '01537346540'" ;
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

        String query1 = "SELECT * FROM account WHERE MOBILE = '" + mobile + "'" ;
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
        button2.setFocusPainted(false);
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


        recipientPanel = new JPanel();
        recipientPanel.setBounds(0, 150, 375, 400);
        recipientPanel.setOpaque(false);
        recipientPanel.setLayout(null);
        add(recipientPanel);

        recipientLabel = new JLabel("এজেন্ট");
        recipientLabel.setBounds(70,30,220,20);
        recipientLabel.setForeground(new Color(0, 87, 117));
        recipientLabel.setFont(new Font("Potro Sans Bangla", Font.PLAIN, 16));
        recipientPanel.add(recipientLabel);

        recipientIcon = new JLabel(new ImageIcon("recipient.png"));
        recipientIcon.setBounds(35,60,30,30);
        recipientPanel.add(recipientIcon);
        
        recipientText = new JTextField(11);
        recipientText.setBounds(70,60,240,30);
        //recipientText.setText("01903735901");
        recipientText.setFont(new Font("Potro Sans Bangla", Font.PLAIN, 20));
        recipientText.setBackground(Color.white);
        recipientText.setForeground(new Color(0, 59, 79));
        recipientText.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(0, 59, 79)));
        recipientPanel.add(recipientText);

        recipientMSG = new JLabel();
        recipientMSG.setText("১১ সংখ্যার মোবাইল নম্বর প্রবেশ করান");
        recipientMSG.setBounds(70,95,240,15);
        recipientMSG.setFont(new Font("Potro Sans Bangla", Font.PLAIN, 15));
        recipientMSG.setForeground(new Color(0, 87, 117));
        recipientPanel.add(recipientMSG);

        amountLabel = new JLabel("পরিমাণ");
        amountLabel.setBounds(70,125,240,20);
        amountLabel.setForeground(new Color(0, 87, 117));
        amountLabel.setFont(new Font("Potro Sans Bangla", Font.PLAIN, 16));
        recipientPanel.add(amountLabel);

        amountIcon = new JLabel(new ImageIcon("taka.png"));
        amountIcon.setBounds(35,155,30,30);
        recipientPanel.add(amountIcon);
        
        amountText = new JTextField(11);
        amountText.setBounds(70,155,240,30);
        //amountText.setText("10");
        amountText.setFont(new Font("Potro Sans Bangla", Font.PLAIN, 20));
        amountText.setBackground(Color.white);
        amountText.setForeground(new Color(0, 59, 79));
        amountText.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(0, 59, 79)));
        recipientPanel.add(amountText);

        amountMSG = new JLabel();
        amountMSG.setText("বর্তমান ব্যালেন্স: " + balance + " টাকা");
        amountMSG.setBounds(70,190,240,15);
        amountMSG.setFont(new Font("Potro Sans Bangla", Font.PLAIN, 15));
        amountMSG.setForeground(new Color(0, 87, 117));
        recipientPanel.add(amountMSG);

        nextButton1 = new RoundJButton(80);
        nextButton1.setBackground(new Color(0, 59, 79));
        nextButton1.setForeground(Color.white);
        nextButton1.setText("পরবর্তী");
        nextButton1.setFont(new Font("Potro Sans Bangla", Font.PLAIN, 22));
        nextButton1.setFocusPainted(false);
        nextButton1.setBounds(115, 225, 120, 35);
        recipientPanel.add(nextButton1);
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


        recipientPanel1 = new JPanel();
        recipientPanel1.setBounds(375, 150, 375, 350);
        recipientPanel1.setLayout(null);
        recipientPanel1.setOpaque(false);
        recipientPanel1.setVisible(false);
        add(recipientPanel1);

        recipientPassLabel = new JLabel("পাসওয়ার্ড");
        recipientPassLabel.setBounds(70,80,240,20);
        recipientPassLabel.setFont(new Font("Potro Sans Bangla", Font.PLAIN, 16));
        recipientPassLabel.setForeground(new Color(0, 87, 117));
        recipientPanel1.add(recipientPassLabel);

        recipientPassIcon = new JLabel(new ImageIcon("password.png"));
        recipientPassIcon.setBounds(35,108,30,30);
        recipientPanel1.add(recipientPassIcon);

        recipientPass = new JPasswordField(20);
        recipientPass.setBounds(70,110,240,30);
        //recipientPass.setText("khalid000");
        recipientPass.setFont(new Font("Potro Sans Bangla", Font.PLAIN, 20));
        recipientPass.setBackground(Color.white);
        recipientPass.setForeground(new Color(0, 59, 79));
        recipientPass.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(0, 59, 79)));
        recipientPass.setEchoChar((char) '*');
        recipientPanel1.add(recipientPass);

        nextButton2 = new RoundJButton(80);
        nextButton2.setBackground(new Color(0, 59, 79));
        nextButton2.setForeground(Color.white);
        nextButton2.setText("পরবর্তী");
        nextButton2.setFont(new Font("Potro Sans Bangla", Font.PLAIN, 22));
        nextButton2.setFocusPainted(false);
        nextButton2.setBounds(115, 225, 120, 35);
        recipientPanel1.add(nextButton2);
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

        //show password button
        showButton = new JButton();
        showButton.setBounds(315, 112, 28, 25);
        //showButton.setLayout(null);
        showButton.setBackground(new Color(238, 238, 238));
        showButton.setFocusPainted(false);
        showButton.setBorder(BorderFactory.createEmptyBorder());
        ImageIcon showIcon = new ImageIcon("hide.png");
        showButton.setIcon(showIcon);
        recipientPanel1.add(showButton);
        showButton.setVisible(true);

        //hide button
        hideButton = new JButton();
        hideButton.setBounds(315, 112, 28, 25);
        //hideButton.setLayout(null);
        hideButton.setBackground(new Color(238, 238, 238));
        hideButton.setFocusPainted(false);
        hideButton.setBorder(BorderFactory.createEmptyBorder());
        ImageIcon hideIcon = new ImageIcon("show.png");
        hideButton.setIcon(hideIcon);
        recipientPanel1.add(hideButton);
        hideButton.setVisible(false);


        //show button action
        showButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                recipientPass.setEchoChar((char) 0);
                showButton.setVisible(false); 
                hideButton.setVisible(true);  
             }
        });

        //hide button action
        hideButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                recipientPass.setEchoChar((char) '*');
                hideButton.setVisible(false);
                showButton.setVisible(true);   
             }
        });


        
        //next button 1 action
        nextButton1.addActionListener(new ActionListener () {
            public void actionPerformed(ActionEvent e) {
                String error = errorMsg(recipientText.getText());
                if (error != null) {
                    JOptionPane.showOptionDialog(null, error, "Warning", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, new Object[]{}, null);
                }
                else if (!isDigit(amountText.getText())) {
                    JOptionPane.showOptionDialog(null, "Invalid Amount Input!", "Warning", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, new Object[]{}, null);
                }
                else if (Integer.parseInt(amountText.getText()) > balance) {
                    JOptionPane.showOptionDialog(null, "Insufficient Balance!", "Warning", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, new Object[]{}, null);
                }
                else if (Integer.parseInt(amountText.getText()) < 1) {
                    JOptionPane.showOptionDialog(null, "Invalid Amount!", "Warning", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, new Object[]{}, null);
                }
                else if (recipientText.getText().equals(mobile)) {
                    JOptionPane.showOptionDialog(null, "Invalid Mobile Number!", "Warning", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, new Object[]{}, null);
                }
                else {
                    recipientPanel1.setVisible(true);
                }
            }
        });



        nextButton2.addActionListener(new ActionListener () {
            public void actionPerformed(ActionEvent e) {
                    if(password.equals(new String(recipientPass.getPassword())))
                    {
                        newBalance = balance - Double.parseDouble(amountText.getText());

                        confirmCashOutBN confirm = new confirmCashOutBN(mobile, newBalance, recipientText.getText(), Double.parseDouble(amountText.getText()));
                        setVisible(false);
                        confirm.setVisible(true);
                    }
                    else{
                            JOptionPane.showMessageDialog(null, "Incorrect Password", "Error", 2);
                        }
            }
        });

         //home button action
         button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {       
               
                HomePageBN home = new HomePageBN(mobile);
 
                //setVisible(false);
                dispose();
                home.setVisible(true);
             } 
        });

        //history button action
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {       
               
                HistoryPageBN history = new HistoryPageBN(mobile);
 
                dispose();
                //setVisible(false);
                history.setVisible(true);
             }
        });

        //menu button action
        button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {       
               
                MenuPageBN menu = new MenuPageBN(mobile);
 
                dispose();
                //setVisible(false);
                menu.setVisible(true);
             }
        });

        //profile button action
        button4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {       
               
                ProfilePageBN profile = new ProfilePageBN(mobile);
 
                dispose();
//              setVisible(false);
                profile.setVisible(true);
             }
        });

        backButton.addActionListener(new ActionListener () {
            public void actionPerformed(ActionEvent e) {
                HomePageBN send = new HomePageBN(mobile);
                send.setVisible(true);
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


        setTitle("User Cash Out"); //title
        setBackground(Color.white);
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

    public static boolean isDigit(String digit) {
        boolean digits = digit.chars().allMatch(Character::isDigit);
        return digits;
    }

    public static boolean isValidMobile(String recMobile) {
        Pattern ptrn = Pattern.compile("(^([+]{1}[8]{2}|0088)?(01){1}[3-9]{1}\\d{8})$");   
        java.util.regex.Matcher match = ptrn.matcher(recMobile);  
        return (match.find() && match.group().equals(recMobile)); 
    }

    public static String errorMsg(String recMobile) {
        String query2 = "SELECT * FROM agent_info WHERE MOBILE = '" + recMobile + "'";
        try {
            PreparedStatement ps = database().prepareStatement(query2);
            ResultSet rs = ps.executeQuery();

            if (!rs.next()) {
                return "Invalid Agent Number!";
            }
            else {
                return null;
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }

        return null;
    }

  

    

    /*public static void main(String [] args) {
        new sendMoney(mobile);
    }*/
}
