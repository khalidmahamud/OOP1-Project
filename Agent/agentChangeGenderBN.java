package Agent;
import L_And_F.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.sql.*;
//import java.io.File;


public class agentChangeGenderBN extends JFrame {
    String fname, lname, mobile, email, dob, gender, nationality, password;
    public JPanel panel;
    public JLabel label;
    public JTextField label1Text, label2Text, label3Text, label6Text, label8Text;
    public JPasswordField label7Pass;
    public JRadioButton maleButton, femaleButton, othersButton;
    public JComboBox <String> date, month, year;
    public JButton submitButton, backButton;
    PreparedStatement ps, ps1;
    ResultSet rs, rs1;


    public agentChangeGenderBN (String mobile) {

        this.mobile = mobile;

        panel = new JPanel();
        panel.setBounds(55, 0, 400, 250);
        panel.setLayout(null);
        panel.setOpaque(false);


        //gender
        maleButton = new JRadioButton("Male");
        maleButton.setBounds(0, 70, 80, 20);
        maleButton.setFont(new Font("Potro Sans Bangla", Font. PLAIN, 17));
        maleButton.setFocusable(false);
        maleButton.setForeground(new Color(0, 59, 79));
        panel.add(maleButton);

        femaleButton = new JRadioButton("Female");
        femaleButton.setBounds(90, 70, 80, 20);
        femaleButton.setFont(new Font("Potro Sans Bangla", Font. PLAIN, 17));
        femaleButton.setFocusable(false);
        femaleButton.setForeground(new Color(0, 59, 79));
        panel.add(femaleButton);

        othersButton = new JRadioButton("Others");
        othersButton.setBounds(200, 70, 80, 20);
        othersButton.setFont(new Font("Potro Sans Bangla", Font. PLAIN, 17));
        othersButton.setFocusable(false);
        othersButton.setForeground(new Color(0, 59, 79));
        panel.add(othersButton);
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleButton); genderGroup.add(femaleButton); genderGroup.add(othersButton);

        //String query = "SELECT * FROM agent_info WHERE MOBILE = '" + mobile + "'" ;
        String query = "SELECT * FROM agent_info WHERE MOBILE = '" + mobile + "'" ;
        try {
            ps = database().prepareStatement(query);
            rs = ps.executeQuery();
            if (rs.next()) {
                gender = rs.getString(4);
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }

        if (gender == "Male") {
            maleButton.setSelected(true);
            othersButton.setSelected(false);
            femaleButton.setSelected(false);
        }
        else if (gender == "Female") {
            femaleButton.setSelected(true);
            othersButton.setSelected(false);
            maleButton.setSelected(false);
        }
        else if (gender == "Others") {
            othersButton.setSelected(true);
            femaleButton.setSelected(false);
            maleButton.setSelected(false);
        }



        //signup button
        submitButton = new RoundJButton(50);
        submitButton.setText("দাখিল করুন");
        submitButton.setBounds(0, 120, 280, 35);
        submitButton.setFocusPainted(false);
        submitButton.setFont(new Font("Potro Sans Bangla", Font.PLAIN, 22));
        submitButton.setContentAreaFilled(true);
        submitButton.setBackground(new Color(0, 59, 79));
        submitButton.setForeground(Color.white);
        panel.add(submitButton);
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

        //back to logIn
        backButton = new JButton("প্রোফাইলে ফিরে যান");
        backButton.setHorizontalAlignment(SwingConstants.LEFT);
        backButton.setBackground(new Color(238, 238, 238));
        backButton.setBounds(0, 20, 200, 25);
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


        //submitButton action
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String newGender = null;
                if (femaleButton.isSelected()) {
                    newGender = "Female";
                }
                else if (maleButton.isSelected()) {
                    newGender = "Male";
                }
                else if (othersButton.isSelected()) {
                    newGender = "Others";
                }

                String query1 = "UPDATE agent_info SET GENDER = '" + newGender + "' WHERE MOBILE = '" + mobile + "'" ;
                try {
                    ps1 = database().prepareStatement(query1);
                    ps1.executeUpdate();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });

        //backButton action
        backButton.addActionListener(new ActionListener () {
            public void actionPerformed (ActionEvent e) {
                dispose();
                //setVisible(false);
                agentProfileEditBN profile =  new agentProfileEditBN(mobile);
                profile.setVisible(true);
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



        setTitle("Edit Profile"); //title
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(239, 250, 254));
        setLayout(null);
        setSize(400,250); //sets the dimension
        setVisible(true); //makes frame visible
        setResizable(false); //diasables resizing
        setLocationRelativeTo(null);
        add(panel);
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
}

