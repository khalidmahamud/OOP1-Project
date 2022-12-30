package Customer;
import L_And_F.*;
import javax.swing.*;
import javax.swing.plaf.basic.BasicComboBoxUI;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.sql.*;

public class Language extends JFrame {
	String fname, lname, mobile, email, dob, gender, nationality, password;
   public String[] language= {"English","Bengali"};
    public JLabel label;
    public JButton nextButton, backButton;
    public JComboBox <String> languageBox;
    public Language (String mobile){

        this.mobile = mobile;

        //back to logIn
        backButton = new JButton("Back to Menu");
        backButton.setBackground(new Color(238, 238, 238));
        backButton.setBounds(50, 20, 100, 25);
        backButton.setFocusPainted(false);
        backButton.setFont(new Font("Potro Sans Bangla", Font.PLAIN, 15));
        backButton.setForeground(new Color(0, 59, 79));
        backButton.setBackground(new Color(239, 250, 254));
        backButton.setBorder(BorderFactory.createEmptyBorder());
        add(backButton);
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


        languageBox= new JComboBox <String> (language);
        languageBox.setFont(new Font("Potro Sans Bangla", Font.PLAIN, 15));
        languageBox.setSize(100,30);
        languageBox.setBackground(Color.WHITE);
        languageBox.setForeground(new Color(0, 59, 79));
        languageBox.setLocation(220,70);
        languageBox.setEditable(false);
        languageBox.setUI(new BasicComboBoxUI());
        languageBox.setFocusable(false);

        label = new JLabel("Select Language: ");
        label.setFont(new Font("Potro Sans Bangla", Font.PLAIN, 18));
        label.setBounds(60, 60, 150, 50);
        label.setForeground(new Color(0, 59, 79));
        label.setFocusable(true);
        this.add(label);

        //signup button
        nextButton = new RoundJButton(25);
        nextButton.setText("Next");
        nextButton.setBounds(145, 135, 100, 35);
        nextButton.setFocusPainted(false);
        nextButton.setFont(new Font("Potro Sans Bangla", Font.PLAIN, 22));
        nextButton.setContentAreaFilled(true);
        nextButton.setBackground(new Color(0, 59, 79));
        nextButton.setForeground(Color.white);
        this.add(nextButton);
        //String language=String.valueOf(languageBox.getSelectedItem());
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


        //backButton action
        backButton.addActionListener(new ActionListener () {
            public void actionPerformed (ActionEvent e) {
                dispose();
                //setVisible(false);
                MenuPage menu =  new MenuPage(mobile);
                menu.setVisible(true);
            }
        });

        //nextButton action
        nextButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String language=String.valueOf(languageBox.getSelectedItem());
                if (language.equals("Bengali")){
                    //Bengali Homepage
                    MenuPageBN menuBN = new MenuPageBN(mobile);
                    dispose();
                    menuBN.setVisible(true);
                }
                else {
                    dispose();
                    MenuPage menuEN = new MenuPage(mobile);
					menuEN.setVisible(true);
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

        setTitle("Select Language");
        setSize(400,250);
        getContentPane().setBackground(new Color(239, 250, 254));
        this.setLayout(null);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        this.add(languageBox);

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
   // public static void main(String [] args) {
    //    Language language1= new Language();
    //}
}