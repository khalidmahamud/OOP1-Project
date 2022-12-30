package Agent;
import L_And_F.*;
import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.table.*;
import java.sql.*;
import java.util.Vector;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class agentHistoryPageBN extends JFrame {
    //static String fname, lname, mobile, email, dob, gender, nationality, password;
    String fname, lname, mobile, email, dob, gender, nationality, password;

    public JPanel ribbon1, ribbon2, ribbon3;
    public JButton button1, button2, button3, button4;
    public JButton sendButton, cashOutButton, rechargeButton, addButton;
    Icon homeIcon, menuIcon, sendIcon, cashIcon;
    JLabel sendLabel, cashLabel, rechargeLabel, addLabel;
    PreparedStatement ps, ps1, ps2, ps3;
    ResultSet rs, rs1, rs2, rs3;
    ResultSetMetaData rsmd, rsmt;
    Statement st, st1;
    JTable table;
    Vector column, data, row;

    agentHistoryPageBN (String mobile) {

        this.mobile = mobile;

        JLabel label = new JLabel();
        label.setSize(750, 463);

        ImageIcon bg = new ImageIcon("Pictures\\bg.png");
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
        homeIcon = new ImageIcon("Pictures\\home.png");
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
        button2.setBackground(new Color(0, 87, 117));
        button2.setBorder(BorderFactory.createEmptyBorder());
        ImageIcon historyIcon = new ImageIcon("Pictures\\history.png");
        button2.setIcon(historyIcon);
        button2.setText("লেনদেন");
        button2.setFont(new Font("Potro Sans Bangla", Font.PLAIN, 25));
        button2.setIconTextGap(10);
        button2.setForeground(Color.white);
        add(button2);
        button2.addMouseListener(new MouseListener() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button2.setBackground(new Color(0, 59, 79));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                button2.setBackground(new Color(0, 87, 117));
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
        menuIcon = new ImageIcon("Pictures\\menu.png");
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
        button4 = new JButton(new ImageIcon("Pictures\\profile.png"));
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


        String query1 = "SELECT * FROM "+ mobile + "trans ORDER BY DATE DESC ";
        try {
            ps1 = database().prepareStatement(query1);
            rs1 = ps1.executeQuery();
            rsmt = rs1.getMetaData();
            int c = rsmt.getColumnCount();
            column = new Vector<>(c);
            for (int i = 1; i <= c; i++) {
                column.add(rsmt.getColumnName(i));
            }
            data = new Vector<>();
            row = new Vector<>();
            while (rs1.next()) {
                row = new Vector<>(c);
                for (int i = 1; i <= c; i++) {
                    row.add(rs1.getString(i));
                }
                data.add(row);
            }
        }  catch (Exception e1) {
            e1.printStackTrace();
        }
        JPanel tablePanel = new JPanel();
        tablePanel.setBounds(10, 150, 715, 300);
        tablePanel.setBackground(Color.black);
        tablePanel.setLayout(new BorderLayout());
        add(tablePanel);
        JTable transTable = new JTable(data, column);
        transTable.getTableHeader().setOpaque(false);
        transTable.getTableHeader().setBackground(new Color(0, 59, 79));
        transTable.getTableHeader().setForeground(Color.white);
        transTable.getTableHeader().setPreferredSize(new Dimension(100, 30));
        transTable.getTableHeader().setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(0, 59, 79)));
        transTable.getColumnModel().getColumn(0).setPreferredWidth(20);
        transTable.getColumnModel().getColumn(1).setPreferredWidth(20);
        transTable.getColumnModel().getColumn(3).setPreferredWidth(30);
        transTable.setFocusable(false);
        transTable.setForeground(Color.white);
        transTable.setBackground(new Color(0, 87, 117));
        transTable.setFont(new Font("Potro Sans Bangla", Font.PLAIN, 17));
        transTable.setRowHeight(40);
        transTable.setRowSelectionAllowed(false);
        transTable.setDefaultEditor(Object.class, null);
        transTable.setCellSelectionEnabled(false);
        setCellsAlignment(transTable, SwingConstants.CENTER);
        transTable.setBounds(10, 150, 715, 300);
        transTable.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(0, 59, 79)));
        JScrollPane jsp = new JScrollPane(transTable);
        jsp.setBackground(new Color(0, 59, 79));
        jsp.getVerticalScrollBar().setUI(new BasicScrollBarUI());
        tablePanel.add(jsp, BorderLayout.CENTER);




        //home button action
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

               agentHomePageBN home = new agentHomePageBN (mobile);

                //setVisible(false);
                dispose();
                home.setVisible(true);
            }
        });

        //menu button action
        button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

               agentMenuPageBN menu = new agentMenuPageBN (mobile);

                dispose();
                //setVisible(false);
                menu.setVisible(true);
            }
        });

        //profile button action
        button4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                agentProfilePageBN profile = new agentProfilePageBN (mobile);

                dispose();
//                setVisible(false);
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


        setTitle("Transactions"); //title
        setBackground(Color.white);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setSize(750,500); //sets the dimension
        setVisible(true); //makes frame visible
        setResizable(true); //diasables resizing
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
    public static void setCellsAlignment(JTable table, int alignment)
    {
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(alignment);

        TableModel tableModel = table.getModel();

        for (int columnIndex = 0; columnIndex < tableModel.getColumnCount(); columnIndex++)
        {
            table.getColumnModel().getColumn(columnIndex).setCellRenderer(rightRenderer);
        }
    }

    /*public static void main(String [] args) {
        new HistoryPage(mobile);
    }*/
}
