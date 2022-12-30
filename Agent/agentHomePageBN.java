package Agent;
import L_And_F.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.sql.*;

public class agentHomePageBN extends JFrame {

    //static String fname, lname, mobile, email, dob, gender1, nationality, password;
    public double balance;
    public String fname, lname, mobile, email, dob, gender1, nationality, password;
    int counter;

    public JPanel ribbon1, ribbon2, ribbon3;
    public JButton button1, button2, button3, button4;
    public JButton balButton;
    public JButton sendButton, cashOutButton, rechargeButton, addButton;
    public Icon homeIcon, menuIcon, sendIcon, cashIcon;
    public JLabel sendLabel, cashLabel, rechargeLabel, addLabel;
    public PreparedStatement ps, ps1;
    public ResultSet rs, rs1;
    Timer timer;


    agentHomePageBN (String mobile) {

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
                gender1 = rs.getString(4);
                dob = rs.getString(5);
                nationality = rs.getString(6);
                password = rs.getString(7);
                //mobile = rs.getString(8);
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }

        String query1 = "SELECT * FROM agentAccount WHERE MOBILE = '" + mobile + "'" ;
        //String query1 = "SELECT * FROM agentAccount WHERE MOBILE = '01537346540'" ;
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
        button1.setBackground(new Color(0, 87, 117));
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
                button1.setBackground(new Color(0, 59, 79));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                button1.setBackground(new Color(0, 87, 117));
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

        JLabel greet = new JLabel();
        greet.setText("Hello, " + fname);
        greet.setBounds(46, 163, 250, 35);
        greet.setFont(new Font("Potro Sans Bangla", Font.PLAIN, 30));
        greet.setForeground(new Color(0, 59, 79));
        add(greet);
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

        /*JLabel balLabel = new JLabel();
        balLabel.setText("Balance");
        balLabel.setBounds(450, 150, 100, 30);
        balLabel.setFont(new Font("Potro Sans Bangla", Font.PLAIN, 20));
        balLabel.setForeground(new Color(0, 59, 79));
        add(balLabel);*/

        //balance button
        balButton = new RoundJButton(200);
        balButton.setText("ব্যালেন্স জানতে ক্লিক করুন");
        balButton.setBounds(440, 155, 250, 35);
        balButton.setFont(new Font("Potro Sans Bangla", Font.PLAIN, 22));
        balButton.setForeground(Color.white);
        balButton.setBackground(new Color(0, 59, 79));
        balButton.setFocusPainted(false);
        add(balButton);
        balButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseEntered(MouseEvent e) {
                balButton.setBackground(new Color(0, 87, 117));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                balButton.setBackground(new Color(0, 59, 79));
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

        //balance field
        JTextField balField = new RoundJTextField(5);
        balField.setText(Double.toString(balance) + " টাকা");
        balField.setBounds(440, 155, 250, 35);
        balField.setFont(new Font("Potro Sans Bangla", Font.PLAIN, 25));
        balField.setBackground(new Color(0, 87, 117));
        balField.setForeground(Color.white);
        balField.setHorizontalAlignment(JTextField.CENTER);
        balField.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, getForeground()));
        balField.setEditable(false);
        add(balField);

        timer = new Timer(500, new ActionListener() {
            public void actionPerformed(ActionEvent e) {



                if (++counter > 10) {
                    timer.stop();
                    balButton.setVisible(true);
                }
            }
        });

        //balButton action
        balButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                balButton.setVisible(false);
                balField.setVisible(true);
                timer.start(); //timer started
                counter = 0;
            }
        });





        //services
        //send money
        sendButton = new RoundJButton(130);
        sendButton.setLocation(82, 295);
        sendButton.setSize(130, 130);
        sendButton.setBackground(new Color(0, 59, 79));
        sendButton.setLayout(null);
        sendButton.setFocusPainted(false);
        sendIcon = new ImageIcon("sendMoney.png");
        sendButton.setHorizontalAlignment(JButton.CENTER);
        sendButton.setVerticalAlignment(JButton.TOP);
        sendButton.setIcon(sendIcon);
        add(sendButton);
        sendLabel = new JLabel("সেন্ড মানি");
        sendLabel.setBounds(37, 95, 100, 18);
        sendLabel.setFont(new Font("Potro Sans Bangla", Font.PLAIN, 17));
        sendLabel.setFocusable(false);
        sendLabel.setForeground(Color.white);
        sendButton.add(sendLabel);
        sendButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseEntered(MouseEvent e) {
                sendButton.setBackground(new Color(0, 87, 117));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                sendButton.setBackground(new Color(0, 59, 79));
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


        //mobile recharge
        rechargeButton = new RoundJButton(130);
        rechargeButton.setLocation(310, 295);
        rechargeButton.setSize(130, 130);
        rechargeButton.setLayout(null);
        rechargeButton.setBackground(new Color(0, 59, 79));
        rechargeLabel = new JLabel(new ImageIcon("recharge.png"));
        rechargeLabel.setText("রিচার্জ");
        rechargeLabel.setBounds(13, 14, 100, 100);
        rechargeLabel.setFont(new Font("Potro Sans Bangla", Font.PLAIN, 17));
        rechargeLabel.setForeground(Color.white);
        rechargeLabel.setHorizontalTextPosition(JButton.CENTER);
        rechargeLabel.setVerticalTextPosition(JButton.BOTTOM);
        rechargeLabel.setIconTextGap(2);
        rechargeButton.add(rechargeLabel);
        add(rechargeButton);
        rechargeButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseEntered(MouseEvent e) {
                rechargeButton.setBackground(new Color(0, 87, 117));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                rechargeButton.setBackground(new Color(0, 59, 79));
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

        //add money
        addButton = new RoundJButton(130);
        addButton.setLocation(532, 295);
        addButton.setSize(130, 130);
        addButton.setLayout(null);
        addButton.setBackground(new Color(0, 59, 79));
        addLabel = new JLabel(new ImageIcon("add.png"));
        addLabel.setText("অ্যাড মানি");
        addLabel.setBounds(13, 14, 100, 100);
        addLabel.setFont(new Font("Potro Sans Bangla", Font.PLAIN, 17));
        addLabel.setForeground(Color.white);
        addLabel.setHorizontalTextPosition(JButton.CENTER);
        addLabel.setVerticalTextPosition(JButton.BOTTOM);
        addLabel.setIconTextGap(2);
        addButton.add(addLabel);
        add(addButton);
        addButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseEntered(MouseEvent e) {
                addButton.setBackground(new Color(0, 87, 117));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                addButton.setBackground(new Color(0, 59, 79));
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



        //history button action
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                agentHistoryPageBN history = new agentHistoryPageBN (mobile);

                //setVisible(false);
                dispose();
                history.setVisible(true);
            }
        });

        //menu button action
        button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                agentMenuPageBN menu = new agentMenuPageBN (mobile);

                //setVisible(false);
                dispose();
                menu.setVisible(true);
            }
        });

        //profile button action
        button4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                agentProfilePageBN profile = new agentProfilePageBN(mobile);

                //setVisible(false);
                dispose();
                profile.setVisible(true);
            }
        });

        //send money button action
        sendButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                agentSendMoneyBN send = new agentSendMoneyBN(mobile);

                //setVisible(false);
                dispose();
               send.setVisible(true);
            }
        });

        //add money button action
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                agentAddMoneyBN add = new agentAddMoneyBN (mobile);

                //setVisible(false);
                dispose();
                add.setVisible(true);
            }
        });

        //recharge button action
        rechargeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

              agentRechargeBN recharge = new agentRechargeBN (mobile);

                //setVisible(false);
                dispose();
                 recharge.setVisible(true);
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



        setTitle("Agent Home Page"); //title
        //getContentPane().setBackground(new Color(217, 243, 244));
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
        HomePage home = new HomePage(mobile);
    }*/
}

