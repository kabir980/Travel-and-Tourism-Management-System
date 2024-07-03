package travel.management.system;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;

public class UserDetails extends JPanel implements ActionListener {
    
    JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13, l14, l15;
    JButton b1, b2, b3;
    JPanel panel, panel1;
    JTextArea ta1;
    public AdminHome a;
    public CustomerHome c;
    String username, user;
    UserPanel up;
    
    UserDetails(AdminHome a, String username) {
        this();
        this.a = a;
        this.username = username;
        display();
    }

    UserDetails(CustomerHome c, String username, String user) {
        this();
        this.c = c;
        this.username = username;
        this.user = user;
        b1.setText("Book Package");
        display();
    }
    
    UserDetails() {
        
        setBorder(new EmptyBorder(0, 0, 0, 0));
        setBackground(Color.WHITE);
        this.setSize(1278, 900);
        setLayout(null);        
        
        panel = new JPanel();
        panel.setBackground(new Color(32, 178, 170));
        panel.setBounds(1, 7, 1027, 160);
        add(panel);
        panel.setLayout(null);
        
        panel1 = new JPanel();
        panel1.setBackground(Color.WHITE);
        panel1.setBounds(7, 167, 1278, 740);
        add(panel1);
        panel1.setLayout(null);
        
        l11 = new JLabel("User Details ");
        l11.setIcon(null);
        l11.setBounds(5, 55, 300, 45);
        panel.add(l11);
        l11.setBackground(new Color(32, 178, 170));
        l11.setForeground(Color.WHITE);
        l11.setFont(new Font("Segoe UI", Font.BOLD, 30));
        
        l1 = new JLabel("Username  ");
        l1.setBorder(new LineBorder(new Color(192, 192, 192)));
        l1.setBackground(new Color(255, 255, 255));
        l1.setFont(new Font("Segoe UI Historic", Font.PLAIN, 20));
        l1.setBounds(2, 300, 230, 45);
        panel1.add(l1);
        
        l2 = new JLabel("Full Name  ");
        l2.setFont(new Font("Segoe UI Historic", Font.PLAIN, 20));
        l2.setBorder(new LineBorder(new Color(192, 192, 192)));
        l2.setBackground(Color.WHITE);
        l2.setBounds(2, 344, 230, 45);
        panel1.add(l2);
        
        l12 = new JLabel("Created by  ");
        l12.setFont(new Font("Segoe UI Historic", Font.PLAIN, 20));
        l12.setBorder(new LineBorder(new Color(192, 192, 192)));
        l12.setBackground(Color.WHITE);
        l12.setBounds(2, 388, 230, 45);
        panel1.add(l12);
        
        l3 = new JLabel();
        l3.setBorder(new LineBorder(new Color(192, 192, 192)));
        l3.setBackground(new Color(255, 255, 255));
        l3.setFont(new Font("Segoe UI Historic", Font.BOLD, 20));
        l3.setBounds(230, 300, 320, 45);
        panel1.add(l3);
        
        l4 = new JLabel();
        l4.setFont(new Font("Segoe UI Historic", Font.BOLD, 20));
        l4.setBorder(new LineBorder(new Color(192, 192, 192)));
        l4.setBackground(Color.WHITE);
        l4.setBounds(230, 344, 320, 45);
        panel1.add(l4);
        
        l13 = new JLabel();
        l13.setFont(new Font("Segoe UI Historic", Font.BOLD, 20));
        l13.setBorder(new LineBorder(new Color(192, 192, 192)));
        l13.setBackground(Color.WHITE);
        l13.setBounds(230, 388, 320, 45);
        panel1.add(l13);
        
        l5 = new JLabel("Email  ");
        l5.setBorder(new LineBorder(new Color(192, 192, 192)));
        l5.setBackground(new Color(255, 255, 255));
        l5.setFont(new Font("Segoe UI Historic", Font.PLAIN, 20));
        l5.setBounds(550, 300, 150, 45);
        panel1.add(l5);
        
        l6 = new JLabel("Number  ");
        l6.setFont(new Font("Segoe UI Historic", Font.PLAIN, 20));
        l6.setBorder(new LineBorder(new Color(192, 192, 192)));
        l6.setBackground(Color.WHITE);
        l6.setBounds(550, 344, 150, 45);
        panel1.add(l6);
        
        l14 = new JLabel("Created at  ");
        l14.setFont(new Font("Segoe UI Historic", Font.PLAIN, 20));
        l14.setBorder(new LineBorder(new Color(192, 192, 192)));
        l14.setBackground(Color.WHITE);
        l14.setBounds(550, 388, 150, 45);
        panel1.add(l14);
        
        l7 = new JLabel();
        l7.setBorder(new LineBorder(new Color(192, 192, 192)));
        l7.setBackground(new Color(255, 255, 255));
        l7.setFont(new Font("Segoe UI Historic", Font.BOLD, 20));
        l7.setBounds(700, 300, 310, 45);
        panel1.add(l7);
        
        l8 = new JLabel();
        l8.setFont(new Font("Segoe UI Historic", Font.BOLD, 20));
        l8.setBorder(new LineBorder(new Color(192, 192, 192)));
        l8.setBackground(Color.WHITE);
        l8.setBounds(700, 344, 310, 45);
        panel1.add(l8);
        
        l15 = new JLabel();
        l15.setFont(new Font("Segoe UI Historic", Font.BOLD, 20));
        l15.setBorder(new LineBorder(new Color(192, 192, 192)));
        l15.setBackground(Color.WHITE);
        l15.setBounds(700, 388, 310, 45);
        panel1.add(l15);
        
        l10 = new JLabel();
        l10.setBounds(300, 20, 300, 200);
        l10.setBorder(new LineBorder(new Color(192, 192, 192)));
        panel1.add(l10);
        
        b1 = new JButton("Edit User");
        b1.setBorder(new EmptyBorder(0, 0, 0, 0));
        b1.setBounds(739, 120, 140, 30);
        panel.add(b1);
        b1.addActionListener(this);
        b1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        b1.setFocusable(false);
        b1.setForeground(new Color(0, 128, 128));
        b1.setFont(new Font("Segoe UI", Font.BOLD, 15));
        b1.setBackground(Color.WHITE);
        
        b3 = new JButton("Delete User");
        b3.setBorder(new EmptyBorder(0, 0, 0, 0));
        b3.setBounds(884, 120, 140, 30);
        panel.add(b3);
        b3.addActionListener(this);
        b3.setCursor(new Cursor(Cursor.HAND_CURSOR));
        b3.setFocusable(false);
        b3.setForeground(new Color(0, 128, 128));
        b3.setFont(new Font("Segoe UI", Font.BOLD, 15));
        b3.setBackground(Color.WHITE);
        
        b2 = new JButton("Back", new ImageIcon(ClassLoader.getSystemResource("Travel/Management/System/icons/back.png")));
        b2.setBorder(new EmptyBorder(0, 0, 0, 0));
        b2.setBounds(20, 120, 140, 30);
        panel.add(b2);
        b2.setHorizontalAlignment(SwingConstants.LEFT);
        b2.addActionListener(this);
        b2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        b2.setFocusable(false);
        b2.setForeground(Color.WHITE);
        b2.setFont(new Font("Segoe UI", Font.BOLD, 15));
        b2.setBackground(new Color(32, 178, 170));
        
        setVisible(true);
    }

    public void display() {
    try {
        Conn conn = new Conn();
        PreparedStatement ps = conn.c.prepareStatement(
                "SELECT U.*, A.name AS 'Created by' " +
                        "FROM users U " +
                        "LEFT JOIN adminlogins A ON U.created_by = A.id " +
                        "WHERE U.username = ?"
        );
        ps.setString(1, username);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            l3.setText(rs.getString("username"));
            l4.setText(rs.getString("full_name"));
            l7.setText(rs.getString("email"));
            l8.setText(rs.getString("number"));
            l13.setText(rs.getString("Created by"));
            l15.setText(rs.getString("created_at"));
            
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            // if(a != null){
            new AddUser(this, username).setVisible(true);
            //}
        } else if (e.getSource() == b2) {
            panel.setVisible(false);
            panel1.setVisible(false);
            // if(a != null){
            UserPanel up = new UserPanel(a);
            add(up);
            up.setVisible(true);
            // }
//                  if(c != null){
//                  UserPanel up = new UserPanel(c, user);
//                  add(up);
//                  up.setVisible(true);
//                  }
        }
        
        if (e.getSource() == b3) {
            try {
                
                Conn conn = new Conn();
                
                conn.s.executeUpdate("Delete from users where username = '" + username + "'  ");
                
                JOptionPane.showMessageDialog(null, "User Data Deleted Successfully");
                
                //setVisible(false);
                
                
                
            } catch (SQLException ae) {
            }
            
        }
        
    }
//    public static void main(String[] args){
//        new UserDetails();
//    }
}
