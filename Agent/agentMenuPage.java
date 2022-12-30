package Agent;
import L_And_F.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.sql.*;

public class agentMenuPage extends JFrame {
    //static String fname, lname, mobile, email, dob, gender, nationality, password;
    String fname, lname, mobile, email, dob, gender, nationality, password;

    public JPanel ribbon1, ribbon2, ribbon3;
    public JButton button1, button2, button3, button4;
    public JButton userProfile, langB, supB, LogoutB;
    Icon homeIcon, menuIcon, sendIcon, cashIcon;
    JLabel proLabel, langLabel, supLabel, LogoutLabel;
    PreparedStatement ps;
    ResultSet rs;

    public agentMenuPage (String mobile) {

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

        //home button
        button1 = new RoundJButton(237);
        button1.setBounds(10, 75, 237, 50);
        button1.setBackground(new Color(0, 59, 79));
        button1.setBorder(BorderFactory.createEmptyBorder());
        button1.setFocusPainted(false);
        homeIcon = new ImageIcon("home.png");
        button1.setIcon(homeIcon);
        button1.setText("Home");
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
        button2.setText("Transactions");
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
        button3.setBackground(new Color(0, 87, 117));
        button3.setBorder(BorderFactory.createEmptyBorder());
        menuIcon = new ImageIcon("menu.png");
        button3.setIcon(menuIcon);
        button3.setText("Menu");
        button3.setFont(new Font("Potro Sans Bangla", Font.PLAIN, 25));
        button3.setForeground(Color.WHITE);
        button3.setIconTextGap(20);
        button3.setFocusPainted(false);
        add(button3);
        button3.addMouseListener(new MouseListener() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button3.setBackground(new Color(0, 59, 79));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                button3.setBackground(new Color(0, 87, 117));
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


        //Menu Profile Button
        userProfile = new RoundJButton(130);
        userProfile.setLocation(42, 295);
        userProfile.setSize(130, 130);
        userProfile.setBackground(new Color(0, 59, 79));
        userProfile.setLayout(null);
        proLabel = new JLabel(new ImageIcon("user.png"));
        proLabel.setText("Edit User");
        proLabel.setBounds(13, 14, 100, 100);
        proLabel.setFont(new Font("Potro Sans Bangla", Font.PLAIN, 17));
        proLabel.setForeground(Color.white);
        proLabel.setHorizontalTextPosition(JButton.CENTER);
        proLabel.setVerticalTextPosition(JButton.BOTTOM);
        proLabel.setIconTextGap(2);
        userProfile.add(proLabel);
        add(userProfile);
        userProfile.addMouseListener(new MouseListener() {
            @Override
            public void mouseEntered(MouseEvent e) {
                userProfile.setBackground(new Color(0, 87, 117));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                userProfile.setBackground(new Color(0, 59, 79));
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

        //Menu Language Button
        langB = new RoundJButton(130);
        langB.setLocation(214, 295);
        langB.setSize(130, 130);
        langB.setLayout(null);
        langB.setBackground(new Color(0, 59, 79));
        langLabel = new JLabel(new ImageIcon("language.png"));
        langLabel.setText("Language");
        langLabel.setBounds(13, 14, 100, 100);
        langLabel.setFont(new Font("Potro Sans Bangla", Font.PLAIN, 17));
        langLabel.setForeground(Color.white);
        langLabel.setHorizontalTextPosition(JButton.CENTER);
        langLabel.setVerticalTextPosition(JButton.BOTTOM);
        langLabel.setIconTextGap(2);
        langB.add(langLabel);
        add(langB);
        langB.addMouseListener(new MouseListener() {
            @Override
            public void mouseEntered(MouseEvent e) {
                langB.setBackground(new Color(0, 87, 117));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                langB.setBackground(new Color(0, 59, 79));
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

        //Menu About Us Button
        supB = new RoundJButton(130);
        supB.setLocation(388, 295);
        supB.setSize(130, 130);
        supB.setLayout(null);
        supB.setBackground(new Color(0, 59, 79));
        supLabel = new JLabel(new ImageIcon("about.png"));
        supLabel.setText("About Us");
        supLabel.setBounds(13, 14, 100, 100);
        supLabel.setFont(new Font("Potro Sans Bangla", Font.PLAIN, 17));
        supLabel.setForeground(Color.white);
        supLabel.setHorizontalTextPosition(JButton.CENTER);
        supLabel.setVerticalTextPosition(JButton.BOTTOM);
        supLabel.setIconTextGap(2);
        supB.add(supLabel);
        add(supB);
        supB.addMouseListener(new MouseListener() {
            @Override
            public void mouseEntered(MouseEvent e) {
                supB.setBackground(new Color(0, 87, 117));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                supB.setBackground(new Color(0, 59, 79));
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

        //Menu LogOut Button
        LogoutB = new RoundJButton(130);
        LogoutB.setLocation(562, 295);
        LogoutB.setSize(130, 130);
        LogoutB.setLayout(null);
        LogoutB.setBackground(new Color(0, 59, 79));
        LogoutLabel = new JLabel(new ImageIcon("logOut.png"));
        LogoutLabel.setText("Log Out");
        LogoutLabel.setBounds(13, 14, 100, 100);
        LogoutLabel.setFont(new Font("Potro Sans Bangla", Font.PLAIN, 17));
        LogoutLabel.setForeground(Color.white);
        LogoutLabel.setHorizontalTextPosition(JButton.CENTER);
        LogoutLabel.setVerticalTextPosition(JButton.BOTTOM);
        LogoutLabel.setIconTextGap(2);
        LogoutB.add(LogoutLabel);
        add(LogoutB);
        LogoutB.addMouseListener(new MouseListener() {
            @Override
            public void mouseEntered(MouseEvent e) {
                LogoutB.setBackground(new Color(0, 87, 117));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                LogoutB.setBackground(new Color(0, 59, 79));
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





        //home button action
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                agentHomePage home = new agentHomePage(mobile);

                dispose();
//                setVisible(false);
                home.setVisible(true);
            }
        });

        //history button action
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                agentHistoryPage history = new agentHistoryPage(mobile);

                dispose();
//                setVisible(false);
                history.setVisible(true);
            }
        });

        //profile button action
        button4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                agentProfilePage profile1 = new agentProfilePage(mobile);

                dispose();
//                setVisible(false);
                profile1.setVisible(true);
            }
        });

        //userProfile button action
        userProfile.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                agentProfileEdit profile = new agentProfileEdit(mobile);

                dispose();
//                setVisible(false);
                profile.setVisible(true);
            }
        });

        //Language button action
        langB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                //Language Page
                agentMenuLanguage language =  new agentMenuLanguage(mobile);

                dispose();
                language.setVisible(true);
//                setVisible(false);
            }
        });

        //AboutUS button action
        supB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                //About Us Page
                agentAboutUs about=new agentAboutUs(mobile);
                dispose();
               about.setVisible(true);
            }
        });

        //LogOut button action
        LogoutB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //Logout confirmation
                int i= JOptionPane.showConfirmDialog(null,"Confirm Logout?","Confirm",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
                if (i==0){
                    //Login Page
                    agentLogin login = new agentLogin();

                    dispose();
                    login.setVisible(true);
                }
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


        setTitle("Menu Page"); //title
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

    /*public static void main(String [] args) {
        new MenuPage(mobile);
    }*/
}
