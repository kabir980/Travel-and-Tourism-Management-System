package travel.management.system;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;

public class Signup extends JPanel implements ActionListener {

    JPanel p1, p2;
    JTextField t1, t2, t3, t4;
    JButton b1, b2;
    JComboBox c1;
    JLabel l5;

    Signup() {

        setSize(1518, 800);
        setBackground(Color.WHITE);
        setLayout(null);

        p1 = new JPanel();
        p1.setBounds(440, 230, 370, 273);
        p1.setBackground(new Color(100, 250, 150));
        p1.setLayout(null);
        add(p1);

        p2 = new JPanel();
        p2.setBounds(810, 200, 300, 330);
        p2.setBackground(Color.WHITE);
        p2.setLayout(null);
        add(p2);

        JLabel l = new JLabel("Username :");
        l.setForeground(Color.DARK_GRAY);
        l.setFont(new Font("Tahoma", Font.BOLD, 14));
        l.setBounds(30, 20, 140, 30);
        p1.add(l);

        JLabel ll = new JLabel("Name :");
        ll.setForeground(Color.DARK_GRAY);
        ll.setFont(new Font("Tahoma", Font.BOLD, 14));
        ll.setBounds(30, 60, 140, 30);
        p1.add(ll);

        JLabel l2 = new JLabel("Password :");
        l2.setForeground(Color.DARK_GRAY);
        l2.setFont(new Font("Tahoma", Font.BOLD, 14));
        l2.setBounds(30, 100, 140, 30);
        p1.add(l2);

        JLabel l3 = new JLabel("Security Question :");
        l3.setForeground(Color.DARK_GRAY);
        l3.setFont(new Font("Tahoma", Font.BOLD, 14));
        l3.setBounds(30, 140, 140, 30);
        p1.add(l3);

        JLabel l4 = new JLabel("Answer :");
        l4.setForeground(Color.DARK_GRAY);
        l4.setFont(new Font("Tahoma", Font.BOLD, 14));
        l4.setBounds(30, 180, 140, 30);
        p1.add(l4);

        l5 = new JLabel("CREATE ACCOUNT");
        l5.setBounds(580, 160, 400, 50);
        l5.setFont(new Font("TIMES NEW ROMAN", Font.PLAIN, 40));
        l5.setForeground(new Color(205, 92, 92));
        l5.setBackground(Color.WHITE);
        add(l5);

        c1 = new JComboBox(new String[]{"Your NickName?", "Your Lucky Number?", "Your Favourite Anime?", "Your Childhood Name?"});
        c1.setBounds(180, 148, 155, 20);
        c1.setBackground(Color.WHITE);
        p1.add(c1);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Travel/Management/System/icons/signup.png"));
        Image i2 = i1.getImage().getScaledInstance(295, 280, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l6 = new JLabel(i3);
        l6.setBounds(0, 24, 295, 280);
        p2.add(l6);

        t1 = new JTextField();
        t1.setBounds(180, 27, 155, 20);
        t1.setBorder(BorderFactory.createEmptyBorder());
        p1.add(t1);

        t2 = new JTextField();
        t2.setBounds(180, 68, 155, 20);
        t2.setBorder(BorderFactory.createEmptyBorder());
        p1.add(t2);

        t3 = new JTextField();
        t3.setBounds(180, 107, 155, 20);
        t3.setBorder(BorderFactory.createEmptyBorder());
        p1.add(t3);

        t4 = new JTextField();
        t4.setBounds(180, 187, 155, 20);
        t4.setBorder(BorderFactory.createEmptyBorder());
        p1.add(t4);

        b1 = new JButton("Create");
        b1.addActionListener(this);
        b1.setFont(new Font("Tahoma", Font.BOLD, 13));
        b1.setBounds(50, 225, 120, 25);
        b1.setBackground(new Color(176, 224, 230));
        b1.setForeground(new Color(139, 69, 19));
        p1.add(b1);

        b2 = new JButton("Back");
        b2.setFont(new Font("Tahoma", Font.BOLD, 13));
        b2.setBounds(190, 225, 120, 25);
        b2.setBackground(new Color(255, 235, 205));
        b2.setForeground(new Color(46, 139, 87));
        b2.addActionListener(this);
        p1.add(b2);
    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == b1) {

            String Username = t1.getText();
            String Name = t2.getText();
            String Password = t3.getText();
            String question = (String) c1.getSelectedItem();
            String Answer = t4.getText();

            if (Username.isEmpty() || Name.isEmpty() || Password.isEmpty() || question.isEmpty() || Answer.isEmpty()) {

                JOptionPane.showMessageDialog(null, "Please fill in all fields.");
            } else if (Username.matches("^\\d.*")) {
                JOptionPane.showMessageDialog(Signup.this, "Username cannot start with a number.");
            } else if (Name.matches(".*\\d.*")) {
                JOptionPane.showMessageDialog(Signup.this, "Name cannot contains number.");

            } else if (Password.length() <= 6) {
                JOptionPane.showMessageDialog(Signup.this, "Password must be more than 6 characters.");
            } else if (!Password.matches(".*[!@#$%^&*()-+=].*")) {
                JOptionPane.showMessageDialog(Signup.this, "Password must contain at least one special character.");
            } else {
                String query = "insert into accounts values('" + Username + "', '" + Name + "', '" + Password + "', '" + question + "', '" + Answer + "')";

                try {

                    Conn c = new Conn();
                    c.s.executeUpdate(query);

                    JOptionPane.showMessageDialog(null, "Account Created Successfully");

                    setVisible(false);
                    new Login().setVisible(true);

                } catch (Exception e) {

                    e.printStackTrace();
                }
            }
        } else if (ae.getSource()
                == b2) {
            Login n = new Login();
            l5.setVisible(false);
            p1.setVisible(false);
            p2.setVisible(false);
            n.setFocusable(true);
            this.add(n);
            n.setVisible(true);

        }

    }
    

}
