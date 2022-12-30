package Customer;
import L_And_F.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.sql.*;

public class ProfilePageBN extends JFrame {
    //static String fname, lname, mobile, email, dob, gender, nationality, password;
    String fname, lname, mobile, email, dob, gender, nationality, password;

    public JPanel ribbon1, ribbon2, ribbon3;
    public JPanel proPanel, infoPanel;
    public JButton button1, button2, button3, button4;
    public JButton sendButton, cashOutButton, rechargeButton, addButton;
    Icon homeIcon, menuIcon, sendIcon, cashIcon;
    JLabel sendLabel, cashLabel, rechargeLabel, addLabel, proLabel;
    JLabel fnameLabel, lnameLabel, mobileLabel, emailLabel, dobLabel, genderLabel, natLabel, passLabel;
    JTextField fnameText, lnameText, mobileText, emailText, dobText, genderText, natText, passText;
    JButton fnameChange, lnameChange, emailChange, mobileChange, genderChange, dobChange;
    JLabel fnameChangeLabel, lnameChangeLabel, emailChangeLabel, mobileChangeLabel, genderChangeLabel, dobChangeLabel;
    PreparedStatement ps;
    ResultSet rs;

    public ProfilePageBN (String mobile) {

        this.mobile = mobile;

        JLabel label = new JLabel();
        label.setSize(750, 463);

        ImageIcon bg = new ImageIcon("bg.png");
        Image bgIMG = bg.getImage();
        Image bgIMGScale = bgIMG.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon bgScaled = new ImageIcon(bgIMGScale);
        label.setIcon(bgScaled);
        setContentPane(label);


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

        

        proPanel = new JPanel();
        proPanel.setOpaque(false);
        proPanel.setBounds(0,125,200,350);
        proPanel.setLayout(null);
        proLabel = new JLabel(new ImageIcon("profilePage.png"));
        proLabel.setBounds(10,50, 200, 200);
        proPanel.add(proLabel);

        //profile info
        infoPanel = new JPanel();
        infoPanel.setLayout(null);
        infoPanel.setOpaque(false);
        infoPanel.setBounds(215,140,525,350);
        //String query = "SELECT * FROM user_info WHERE MOBILE = '" + mobile + "'" ;
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


        fnameLabel = new JLabel("নাম");
        fnameLabel.setFont(new Font("Potro Sans Bangla", Font.PLAIN, 20));
        fnameLabel.setBounds(0, 10, 100, 30);
        fnameLabel.setForeground(new Color(0, 59, 79));
        infoPanel.add(fnameLabel);
        fnameText = new JTextField(fname);
        fnameText.setBounds(130, 10, 280, 30);
        fnameText.setFont(new Font("Potro Sans Bangla", Font. PLAIN, 17));
        fnameText.setBackground(Color.white);
        fnameText.setForeground(new Color(0, 59, 79));
        fnameText.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(0, 59, 79)));
        fnameText.setEditable(false);
        infoPanel.add(fnameText);
        //change first name
        /*fnameChange = new JButton();
        fnameChange.setLayout(null);
        fnameChange.setBounds(410, 10, 30, 30);
        fnameChange.setBackground(Color.white);
        fnameChange.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(0, 59, 79)));
        fnameChange.setToolTipText("Change First Name");
        fnameChangeLabel = new JLabel(new ImageIcon("Change.png"));
        fnameChangeLabel.setBounds(0, 0, 30, 30);
        fnameChange.add(fnameChangeLabel);
        infoPanel.add(fnameChange);
        fnameChange.addMouseListener(new MouseListener() {
            @Override
            public void mouseEntered(MouseEvent e) {
             fnameChange.setBackground(new Color(0, 87, 117));
            }
            @Override
            public void mouseExited(MouseEvent e) {
             fnameChange.setBackground(Color.white);
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
        });*/

        lnameLabel = new JLabel("পদবী");
        lnameLabel.setFont(new Font("Potro Sans Bangla", Font.PLAIN, 20));
        lnameLabel.setBounds(0, 50, 100, 30);
        lnameLabel.setForeground(new Color(0, 59, 79));
        infoPanel.add(lnameLabel);
        lnameText = new JTextField(lname);
        lnameText.setBounds(130, 50, 280, 30);
        lnameText.setFont(new Font("Potro Sans Bangla", Font. PLAIN, 17));
        lnameText.setBackground(Color.white);
        lnameText.setForeground(new Color(0, 59, 79));
        lnameText.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(0, 59, 79)));
        lnameText.setEditable(false);
        infoPanel.add(lnameText);
        //change last name
        /*lnameChange = new JButton();
        lnameChange.setLayout(null);
        lnameChange.setBounds(410, 50, 30, 30);
        lnameChange.setBackground(Color.white);
        lnameChange.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(0, 59, 79)));
        //lnameChange.setBorder(BorderFactory.createEmptyBorder());
        lnameChange.setToolTipText("Change Last Name");
        lnameChangeLabel = new JLabel(new ImageIcon("Change.png"));
        lnameChangeLabel.setBounds(0, 0, 30, 30);
        lnameChange.add(lnameChangeLabel);
        infoPanel.add(lnameChange);
        lnameChange.addMouseListener(new MouseListener() {
            @Override
            public void mouseEntered(MouseEvent e) {
             lnameChange.setBackground(new Color(0, 87, 117));
            }
            @Override
            public void mouseExited(MouseEvent e) {
             lnameChange.setBackground(Color.white);
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
        });*/

        emailLabel = new JLabel("ইমেইল");
        emailLabel.setFont(new Font("Potro Sans Bangla", Font.PLAIN, 20));
        emailLabel.setBounds(0, 90, 100, 30);
        emailLabel.setForeground(new Color(0, 59, 79));
        infoPanel.add(emailLabel);
        emailText = new JTextField(email);
        emailText.setBounds(130, 90, 280, 30);
        emailText.setFont(new Font("Potro Sans Bangla", Font. PLAIN, 17));
        emailText.setBackground(Color.white);
        emailText.setForeground(new Color(0, 59, 79));
        emailText.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(0, 59, 79)));
        emailText.setEditable(false);
        infoPanel.add(emailText);
        //change email
        /*emailChange = new JButton();
        emailChange.setLayout(null);
        emailChange.setBounds(410, 90, 30, 30);
        emailChange.setBackground(Color.white);
        emailChange.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(0, 59, 79)));
        //emailChange.setBorder(BorderFactory.createEmptyBorder());
        emailChange.setToolTipText("Change Email");
        emailChangeLabel = new JLabel(new ImageIcon("Change.png"));
        emailChangeLabel.setBounds(0, 0, 30, 30);
        emailChange.add(emailChangeLabel);
        infoPanel.add(emailChange);
        emailChange.addMouseListener(new MouseListener() {
            @Override
            public void mouseEntered(MouseEvent e) {
             emailChange.setBackground(new Color(0, 87, 117));
            }
            @Override
            public void mouseExited(MouseEvent e) {
             emailChange.setBackground(Color.white);
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
        });*/

        mobileLabel = new JLabel("মোবাইল");
        mobileLabel.setFont(new Font("Potro Sans Bangla", Font.PLAIN, 20));
        mobileLabel.setBounds(0, 130, 100, 30);
        mobileLabel.setForeground(new Color(0, 59, 79));
        infoPanel.add(mobileLabel);
        mobileText = new JTextField(mobile);
        mobileText.setBounds(130, 130, 280, 30);
        mobileText.setFont(new Font("Potro Sans Bangla", Font. PLAIN, 17));
        mobileText.setBackground(Color.white);
        mobileText.setForeground(new Color(0, 59, 79));
        mobileText.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(0, 59, 79)));
        mobileText.setEditable(false);
        infoPanel.add(mobileText);
        //change mobile
        /*mobileChange = new JButton();
        mobileChange.setLayout(null);
        mobileChange.setBounds(410, 130, 30, 30);
        mobileChange.setBackground(Color.white);
        mobileChange.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(0, 59, 79)));
        //mobileChange.setBorder(BorderFactory.createEmptyBorder());
        mobileChange.setToolTipText("Change Mobile");
        mobileChangeLabel = new JLabel(new ImageIcon("Change.png"));
        mobileChangeLabel.setBounds(0, 0, 30, 30);
        mobileChange.add(mobileChangeLabel);
        infoPanel.add(mobileChange);
        mobileChange.addMouseListener(new MouseListener() {
            @Override
            public void mouseEntered(MouseEvent e) {
             mobileChange.setBackground(new Color(0, 87, 117));
            }
            @Override
            public void mouseExited(MouseEvent e) {
             mobileChange.setBackground(Color.white);
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
        });*/

        genderLabel = new JLabel("লিঙ্গ");
        genderLabel.setFont(new Font("Potro Sans Bangla", Font.PLAIN, 20));
        genderLabel.setBounds(0, 170, 100, 30);
        genderLabel.setForeground(new Color(0, 59, 79));
        infoPanel.add(genderLabel);
        genderText = new JTextField(gender);
        genderText.setBounds(130, 170, 280, 30);
        genderText.setFont(new Font("Potro Sans Bangla", Font. PLAIN, 17));
        genderText.setBackground(Color.white);
        genderText.setForeground(new Color(0, 59, 79));
        genderText.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(0, 59, 79)));
        genderText.setEditable(false);
        infoPanel.add(genderText);
        
        //chnage gender
        /*genderChange = new JButton();
        genderChange.setLayout(null);
        genderChange.setBounds(410, 170, 30, 30);
        genderChange.setBackground(Color.white);
        genderChange.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(0, 59, 79)));
        genderChange.setToolTipText("Change Name");
        genderChangeLabel = new JLabel(new ImageIcon("Change.png"));
        genderChangeLabel.setBounds(0, 0, 30, 30);
        genderChange.add(genderChangeLabel);
        infoPanel.add(genderChange);
        genderChange.addMouseListener(new MouseListener() {
            @Override
            public void mouseEntered(MouseEvent e) {
             genderChange.setBackground(new Color(0, 87, 117));
            }
            @Override
            public void mouseExited(MouseEvent e) {
             genderChange.setBackground(Color.white);
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
        });*/

        dobLabel = new JLabel("জন্ম দিবস");
        dobLabel.setFont(new Font("Potro Sans Bangla", Font.PLAIN, 20));
        dobLabel.setBounds(0, 210, 130, 30);
        dobLabel.setForeground(new Color(0, 59, 79));
        infoPanel.add(dobLabel);
        dobText = new JTextField(dob);
        dobText.setBounds(130, 210, 280, 30);
        dobText.setFont(new Font("Potro Sans Bangla", Font. PLAIN, 17));
        dobText.setBackground(Color.white);
        dobText.setForeground(new Color(0, 59, 79));
        dobText.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(0, 59, 79)));
        dobText.setEditable(false);
        infoPanel.add(dobText);
        //dob change
        /*dobChange = new JButton();
        dobChange.setLayout(null);
        dobChange.setBounds(410, 210, 30, 30);
        dobChange.setBackground(Color.white);
        dobChange.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(0, 59, 79)));
        dobChange.setToolTipText("Change Date of Birth");
        dobChangeLabel = new JLabel(new ImageIcon("Change.png"));
        dobChangeLabel.setBounds(0, 0, 30, 30);
        dobChange.add(dobChangeLabel);
        infoPanel.add(dobChange);
        dobChange.addMouseListener(new MouseListener() {
            @Override
            public void mouseEntered(MouseEvent e) {
             dobChange.setBackground(new Color(0, 87, 117));
            }
            @Override
            public void mouseExited(MouseEvent e) {
             dobChange.setBackground(Color.white);
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
        });*/

        natLabel = new JLabel("জাতীয়তা");
        natLabel.setFont(new Font("Potro Sans Bangla", Font.PLAIN, 20));
        natLabel.setBounds(0, 250, 100, 30);
        natLabel.setForeground(new Color(0, 59, 79));
        infoPanel.add(natLabel);
        natText = new JTextField(nationality);
        natText.setBounds(130, 250, 280, 30);
        natText.setFont(new Font("Potro Sans Bangla", Font. PLAIN, 17));
        natText.setBackground(Color.white);
        natText.setForeground(new Color(0, 59, 79));
        natText.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(0, 59, 79)));
        natText.setEditable(false);
        infoPanel.add(natText);


        /*//first name chnage button
        fnameChange.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            
                dispose();
                changeFName change =  new changeFName(mobile);
                change.setVisible(true);
             } 
        });

        //last name chnage button
        lnameChange.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            
                dispose();
                changeLName change =  new changeLName(mobile);
                change.setVisible(true);
             } 
        });

        //first name chnage button
        emailChange.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            
                dispose();
                changeEmail change =  new changeEmail(mobile);
                change.setVisible(true);
             } 
        });

        //mobile chnage button
        mobileChange.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            
                dispose();
                changeMobile change =  new changeMobile(mobile);
                change.setVisible(true);
             } 
        });

        //gender chnage button
        genderChange.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            
                dispose();
                changeGender change =  new changeGender(mobile);
                change.setVisible(true);
             } 
        });

        //DOB chnage button
        dobChange.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            
                dispose();
                changeDOB change =  new changeDOB(mobile);
                change.setVisible(true);
             } 
        });*/

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
                HomePageBN home = new HomePageBN(mobile);
                home.setVisible(true);
                dispose();
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
 
                //setVisible(false);
                dispose();
                history.setVisible(true);
             }
        });

        //menu button action
        button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {       
               
                MenuPageBN menu = new MenuPageBN(mobile);
 
                //setVisible(false);
                dispose();
                menu.setVisible(true);
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



        setTitle("User Profile"); //title
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setSize(750,500); //sets the dimension
        setVisible(true); //makes frame visible
        setResizable(false); //diasables resizing
        setLocationRelativeTo(null);
        add(proPanel);
        add(infoPanel);
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

    /*public static void main(String [] args) {
        new ProfilePage(mobile);
    }*/
}
