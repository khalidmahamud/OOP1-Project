package Agent;
import L_And_F.*;
import javax.swing.*;
import javax.swing.plaf.basic.BasicComboBoxUI;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.sql.*;
//import java.io.File;


public class agentChangeDOB extends JFrame {
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

    public String dates[]
            = { "Date", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "10",
            "11", "12", "13", "14", "15",
            "16", "17", "18", "19", "20",
            "21", "22", "23", "24", "25",
            "26", "27", "28", "29", "30",
            "31" };
    public String months[]
            = { "Month", "Jan", "Feb", "Mar", "Apr",
            "May", "Jun", "July", "Aug",
            "Sup", "Oct", "Nov", "Dec" };
    public String years[]
            = { "Year", "1995", "1996", "1997", "1998",
            "1999", "2000", "2001", "2002",
            "2003", "2004", "2005", "2006",
            "2007", "2008", "2009", "2010",
            "2011", "2012", "2013", "2014",
            "2015", "2016", "2017", "2018",
            "2019", "2020", "2021", "2022" };


    public agentChangeDOB(String mobile) {

        this.mobile = mobile;

        panel = new JPanel();
        panel.setBounds(55, 0, 400, 250);
        panel.setLayout(null);
        panel.setOpaque(false);


        //date of birth
        date = new JComboBox <String> (dates);
        date.setFont(new Font("Potro Sans Bangla", Font.PLAIN, 15));
        date.setSize(85, 30);
        date.setBackground(Color.white);
        date.setForeground(new Color(0, 59, 79));
        date.setLocation(0, 70);
        date.setEditable(false);
        date.setFocusable(false);
        date.setUI(new BasicComboBoxUI());
        panel.add(date);

        month = new JComboBox <String> (months);
        month.setFont(new Font("Potro Sans Bangla", Font.PLAIN, 15));
        month.setSize(85, 30);
        month.setBackground(Color.white);
        month.setForeground(new Color(0, 59, 79));
        month.setLocation(98, 70);
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
        year.setLocation(195, 70);
        year.setUI(new BasicComboBoxUI());
        panel.add(year);


        //signup button
        submitButton = new RoundJButton(50);
        submitButton.setText("Submit");
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
        backButton = new JButton("Back to Profile");
        backButton.setBackground(new Color(238, 238, 238));
        backButton.setBounds(0, 20, 100, 25);
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

                String Date = String.valueOf(date.getSelectedItem());
                String Month = String.valueOf(month.getSelectedItem());
                String Year  = String.valueOf(year.getSelectedItem());
                String dob = Date + "/" + Month + "/" + Year;

                String error = errorMsg(Date, Month, Year);
                if (error != null) {
                    JOptionPane.showOptionDialog(null, error, "Warning", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, new Object[]{}, null);
                }
                else {
                    String query1 = "UPDATE agent_info SET DOB = '" + dob + "' WHERE MOBILE = '" + mobile + "'" ;
                    try {
                        ps1 = database().prepareStatement(query1);
                        ps1.executeUpdate();
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });

        //backButton action
        backButton.addActionListener(new ActionListener () {
            public void actionPerformed (ActionEvent e) {
                dispose();
                //setVisible(false);
                agentProfileEdit profile =  new agentProfileEdit(mobile);
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

    public static String errorMsg(String date, String month, String year) {
        if (date.equals("Date")) {
            return "Date cannot be empty!";
        }
        else if (month.equals("Month")) {
            return "Month cannot be empty!";
        }
        else if (year.equals("Year")) {
            return "Year cannot be empty!";
        }
        return null;
    }
}
