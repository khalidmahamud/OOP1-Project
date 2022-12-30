package Customer;
import L_And_F.*;
import javax.swing.*;
import javax.swing.plaf.basic.BasicComboBoxUI;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.sql.*;

public class signUpDemoBN extends JFrame { 
    public JPanel panel;
    public JLabel label;
    public JTextField label1Text, label2Text, label3Text, label6Text, label8Text;
    public JPasswordField label7Pass;
    public JRadioButton maleButton, femaleButton, othersButton;
    public JComboBox <String> date, month, year;
    public JButton signUpButton, backLogIn;
    PreparedStatement ps, ps1, ps2, ps3;
    ResultSet rs, rs1;

    public String dates[]
        = { "দিন", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "10",
            "11", "12", "13", "14", "15",
            "16", "17", "18", "19", "20",
            "21", "22", "23", "24", "25",
            "26", "27", "28", "29", "30",
            "31" };
    public String months[]
        = { "মাস", "Jan", "Feb", "Mar", "Apr",
            "May", "Jun", "July", "Aug",
            "Sup", "Oct", "Nov", "Dec" };
    public String years[]
        = { "বছর", "1995", "1996", "1997", "1998",
            "1999", "2000", "2001", "2002",
            "2003", "2004", "2005", "2006",
            "2007", "2008", "2009", "2010",
            "2011", "2012", "2013", "2014",
            "2015", "2016", "2017", "2018",
            "2019", "2020", "2021", "2022" };

    
    public signUpDemoBN() {

        JLabel label = new JLabel();
        label.setSize(750, 463);

        ImageIcon bg = new ImageIcon("Pictures\\bg.png");
        Image bgIMG = bg.getImage();
        Image bgIMGScale = bgIMG.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon bgScaled = new ImageIcon(bgIMGScale);
        label.setIcon(bgScaled);
        setContentPane(label);

        panel = new JPanel();
        panel.setBounds(250, 0, 350, 500);
        panel.setLayout(null);
        panel.setOpaque(false);
        panel.setBackground(new Color(238, 238, 238));

        label = new JLabel("নতুন অ্যাকাউন্ট তৈরি করুন");
        label.setFont(new Font("Potro Sans Bangla", Font.BOLD, 25));
        label.setBounds(10, 20, 280, 50);
        label.setForeground(new Color(0, 59, 79));
        label.setFocusable(true);
        panel.add(label);

        //নাম
        label1Text = new RoundJTextField(20);
        label1Text.setBounds(0, 85, 130, 30);
        label1Text.setFont(new Font("Potro Sans Bangla", Font. PLAIN, 17));
        label1Text.setForeground(new Color(0, 59, 79));
        label1Text.setCaretColor(new Color(0, 59, 79));
        label1Text.setText("নাম");
        label1Text.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent event){
                if (label1Text.getText().equals("নাম")) {
                    label1Text.setText("");
                }
            }

            @Override
            public void focusLost (FocusEvent event) {
                if (label1Text.getText().equals("")){
                    label1Text.setText("নাম");
                }
            }
        });
        panel.add(label1Text);


        //পদবী
        label2Text = new RoundJTextField(20);
        label2Text.setBounds(145, 85, 135, 30);
        label2Text.setFont(new Font("Potro Sans Bangla", Font. PLAIN, 17));
        label2Text.setForeground(new Color(0, 59, 79));
        label2Text.setCaretColor(new Color(0, 59, 79));
        label2Text.setText("পদবী");
        label2Text.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent event){
                if (label2Text.getText().equals("পদবী")) {
                    label2Text.setText("");
                }
            }

            @Override
            public void focusLost (FocusEvent event) {
                if (label2Text.getText().equals("")){
                    label2Text.setText("পদবী");
                }
            }
        });
        panel.add(label2Text);

        //email
        label3Text = new RoundJTextField(20);
        label3Text.setBounds(0, 125, 280, 30);
        label3Text.setFont(new Font("Potro Sans Bangla", Font. PLAIN, 17));
        label3Text.setForeground(new Color(0, 59, 79));
        label3Text.setCaretColor(new Color(0, 59, 79));
        panel.add(label3Text);
        label3Text.setText("ইমেইল");
        label3Text.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent event){
                if (label3Text.getText().equals("ইমেইল")) {
                    label3Text.setText("");
                }
            }

            @Override
            public void focusLost (FocusEvent event) {
                if (label3Text.getText().equals("")){
                    label3Text.setText("ইমেইল");
                }
            }
        });
        panel.add(label3Text);

        //gender
        maleButton = new JRadioButton("পুরুষ");
        maleButton.setBounds(0, 205, 80, 20);
        maleButton.setFont(new Font("Potro Sans Bangla", Font. PLAIN, 17));
        maleButton.setSelected(true);
        maleButton.setFocusable(false);
        maleButton.setForeground(new Color(0, 59, 79));
        maleButton.setOpaque(false);
        panel.add(maleButton);

        femaleButton = new JRadioButton("মহিলা");
        femaleButton.setBounds(90, 205, 80, 20);
        femaleButton.setFont(new Font("Potro Sans Bangla", Font. PLAIN, 17));
        femaleButton.setSelected(false);
        femaleButton.setFocusable(false);
        femaleButton.setForeground(new Color(0, 59, 79));
        femaleButton.setOpaque(false);
        panel.add(femaleButton);

        othersButton = new JRadioButton("অন্যান্য");
        othersButton.setBounds(200, 205, 80, 20);
        othersButton.setFont(new Font("Potro Sans Bangla", Font. PLAIN, 17));
        othersButton.setSelected(false);
        othersButton.setFocusable(false);
        othersButton.setForeground(new Color(0, 59, 79));
        othersButton.setOpaque(false);
        panel.add(othersButton);
        ButtonGroup gender = new ButtonGroup();
        gender.add(maleButton); gender.add(femaleButton); gender.add(othersButton);


        //date of birth
        date = new JComboBox <String> (dates);
        date.setFont(new Font("Potro Sans Bangla", Font.PLAIN, 15));
        date.setSize(85, 30);
        date.setBackground(Color.white);
        date.setForeground(new Color(0, 59, 79));
        date.setLocation(0, 235);
        date.setEditable(false);
        date.setFocusable(false);
        date.setUI(new BasicComboBoxUI());
        panel.add(date);
 
        month = new JComboBox <String> (months);
        month.setFont(new Font("Potro Sans Bangla", Font.PLAIN, 15));
        month.setSize(85, 30);
        month.setBackground(Color.white);
        month.setForeground(new Color(0, 59, 79));
        month.setLocation(98, 235);
        month.setEditable(false);
        month.setFocusable(false);
        month.setUI(new BasicComboBoxUI());
        panel.add(month);
 
        year = new JComboBox <String> (years);
        year.setFont(new Font("Potro Sans Bangla", Font.PLAIN, 15));
        year.setBackground(Color.white);
        year.setForeground(new Color(0, 59, 79));
        year.setSize(85, 30);   
        year.setEditable(false); 
        year.setFocusable(false);
        year.setLocation(195, 235);
        year.setUI(new BasicComboBoxUI());
        panel.add(year);


        //Nationality
        label6Text = new RoundJTextField(20);
        label6Text.setBounds(0, 275, 280, 30);
        label6Text.setFont(new Font("Potro Sans Bangla", Font. PLAIN, 17));
        label6Text.setBackground(Color.white);
        label6Text.setForeground(new Color(0, 59, 79));
        label6Text.setCaretColor(new Color(0, 59, 79));
        panel.add(label6Text);
        label6Text.setText("Bangladeshi");
        label6Text.setEditable(false);
        panel.add(label6Text);

        //password
        label7Pass = new RoundJPassField(20);
        label7Pass.setBounds(0, 315, 280, 30);
        label7Pass.setFont(new Font("Potro Sans Bangla", Font. PLAIN, 17));
        label7Pass.setForeground(new Color(0, 59, 79));
        label7Pass.setCaretColor(new Color(0, 59, 79));
        label7Pass.setText("পাসওয়ার্ড");
        label7Pass.setEchoChar((char) 0);
        label7Pass.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent event){
                if (new String(label7Pass.getPassword()).equals("পাসওয়ার্ড")) {
                    label7Pass.setEchoChar((char)'*');
                    label7Pass.setText("");
                }
            }

            @Override
            public void focusLost (FocusEvent event) {
                if (new String(label7Pass.getPassword()).equals("")){
                    label7Pass.setText("পাসওয়ার্ড");
                    label7Pass.setEchoChar((char) 0);
                }
            }
        });
        panel.add(label7Pass);

        //mobile
        label8Text = new RoundJTextField(20);
        label8Text.setBounds(0, 165, 280, 30);
        label8Text.setFont(new Font("Potro Sans Bangla", Font. PLAIN, 17));
        label8Text.setForeground(new Color(0, 59, 79));
        label8Text.setCaretColor(new Color(0, 59, 79));
        panel.add(label3Text);
        label8Text.setText("মোবাইল");
        label8Text.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent event){
                if (label8Text.getText().equals("মোবাইল")) {
                    label8Text.setText("");
                }
            }

            @Override
            public void focusLost (FocusEvent event) {
                if (label8Text.getText().equals("")){
                    label8Text.setText("মোবাইল");
                }
            }
        });
        panel.add(label8Text);


        //signup button
        signUpButton = new RoundJButton(50);
        signUpButton.setText("সাইন আপ");
        signUpButton.setBounds(0, 355, 280, 35);
        signUpButton.setFocusPainted(false);
        signUpButton.setFont(new Font("Potro Sans Bangla", Font.PLAIN, 22));
        signUpButton.setContentAreaFilled(true);
        signUpButton.setBackground(new Color(0, 59, 79));
        signUpButton.setForeground(Color.white);
        panel.add(signUpButton);     
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

        //back to logIn
        backLogIn = new JButton("আগে থেকেই অ্যাকাউন্ট আছে? লগ ইন");
        backLogIn.setBackground(new Color(239, 250, 254));
        backLogIn.setBounds(0, 405, 280, 20);
        backLogIn.setFocusable(false);
        backLogIn.setFont(new Font("Potro Sans Bangla", Font.PLAIN, 17));
        backLogIn.setForeground(new Color(0, 59, 79));
        backLogIn.setBorder(BorderFactory.createEmptyBorder());
        panel.add(backLogIn);
        backLogIn.addMouseListener(new MouseListener() {
            @Override
            public void mouseEntered(MouseEvent e) {
              backLogIn.setForeground(new Color(0, 87, 117));
            }
            @Override
            public void mouseExited(MouseEvent e) {
              backLogIn.setForeground(new Color(0, 59, 79));
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
        
        //backLogIn action
        backLogIn.addActionListener(new ActionListener () {
            public void actionPerformed (ActionEvent e) {
                dispose();
//                setVisible(false);
                new loginDemoBN().setVisible(true);
            }
        });

        //signUpButton action
        signUpButton.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {   

            String gender = null;
            if (femaleButton.isSelected()) {
                gender = "Female";
            }
            else if (maleButton.isSelected()) {
                gender = "Male";
            }
            else if (othersButton.isSelected()) {
                gender = "Others";
            }
            String Date = String.valueOf(date.getSelectedItem());
            String Month = String.valueOf(month.getSelectedItem());
            String Year  = String.valueOf(year.getSelectedItem());
            String dob = Date + "/" + Month + "/" + Year;

            //executing restrictions
            User user = new User(label1Text.getText(), label2Text.getText(), label3Text.getText(), gender, Date, Month, Year, label6Text.getText(), new String(label7Pass.getPassword()), label8Text.getText());
            Validation v = new Validation();
            String error = v.errorMsg(user);
            if (error != null) {
                JOptionPane.showMessageDialog(null, error, "Warning", 2);
            }

            else {
                //database connection
                try {
                    String query = "INSERT INTO user_info values('" + label1Text.getText() + "','" + label2Text.getText() + "','" + label3Text.getText() + "','" +
                    gender + "','" + dob + "','" + label6Text.getText() + "','" + new String(label7Pass.getPassword()) + "','" + label8Text.getText() + "')";

                    String query2 = "INSERT INTO account values('" + label8Text.getText() + "', '" + 0 + "')";
                    String query3 = "create table " + label8Text.getText() + "trans (INCOMING VARCHAR(20), OUTGOING VARCHAR(20), MOBILE VARCHAR(15), DATE VARCHAR(50), AMOUNT DOUBLE)";
                    ps2 = database().prepareStatement(query3);
                    ps2.executeUpdate(); 


                    Statement sta = database().createStatement();

                    String query1 = "SELECT * FROM user_info WHERE MOBILE = '" + label8Text.getText() + "'";
                    ps = database().prepareStatement(query1);
                    rs = ps.executeQuery();
                    if (rs.next()) {
                        JOptionPane.showMessageDialog(null, "This account already exists!", "Error", JOptionPane.WARNING_MESSAGE);
                    }
                    else {
                        sta.executeUpdate(query);
                        sta.executeUpdate(query2);
                        dispose();
                        //setVisible(false);
                        new loginDemo().setVisible(true);
                        String msg = "Sign Up successful! \n" + "Now Log In with Mobile and Password.";
                        JOptionPane.showMessageDialog(null, msg, "Success", 2);
           
                    }
                    database().close();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
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



        setTitle("User Sign Up"); //title
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setSize(750,500); //sets the dimension
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

    /*public static void main(String [] args) {
        new signUpDemo();
    }*/
}
