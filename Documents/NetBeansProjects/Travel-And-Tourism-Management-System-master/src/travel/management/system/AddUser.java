package travel.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.sql.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddUser extends JFrame implements ActionListener {

    JPanel headerpanel;
    JLabel l1, l2, l3, l4, l5;
    JTextField t1, t2, t3, t4;
    JButton b1, b2, b3;
    JPasswordField p1;
    UserPanel up;
    UserDetails ud;
    String username;

    AddUser() {

        setSize(750, 650);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        headerpanel = new JPanel();
        headerpanel.setBackground(new Color(32, 178, 170));
        headerpanel.setBounds(0, 0, 750, 50);
        add(headerpanel);
        headerpanel.setLayout(null);

        l1 = new JLabel("Add User");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("Segoe UI Emoji", Font.BOLD, 30));
        l1.setHorizontalAlignment(SwingConstants.CENTER);
        l1.setBounds(0, 2, 750, 50);
        headerpanel.add(l1);

        l2 = new JLabel("Username:");
        l2.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 18));
        l2.setBounds(60, 150, 200, 40);
        add(l2);

        t1 = new JTextField();
        t1.setForeground(Color.DARK_GRAY);
        t1.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 18));
        t1.setBounds(270, 150, 380, 40);
        add(t1);

        l3 = new JLabel("Name:");
        l3.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 18));
        l3.setBounds(60, 200, 200, 40);
        add(l3);

        t2 = new JTextField();
        t2.setForeground(Color.DARK_GRAY);
        t2.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 18));
        t2.setBounds(270, 200, 380, 40);
        add(t2);

        l4 = new JLabel("E-mail:");
        l4.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 18));
        l4.setBounds(60, 250, 200, 40);
        add(l4);

        t3 = new JTextField();
        t3.setForeground(Color.DARK_GRAY);
        t3.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 18));
        t3.setBounds(270, 250, 380, 40);
        add(t3);

        l5 = new JLabel("Number:");
        l5.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 18));
        l5.setBounds(60, 300, 200, 40);
        add(l5);

        t4 = new JTextField();
        t4.setForeground(Color.DARK_GRAY);
        t4.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 18));
        t4.setBounds(270, 300, 380, 40);
        add(t4);

        l5 = new JLabel("Password:");
        l5.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 18));
        l5.setBounds(60, 350, 200, 40);
        add(l5);

        p1 = new JPasswordField();
        p1.setForeground(Color.DARK_GRAY);
        p1.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 18));
        p1.setBounds(270, 350, 380, 40);
        add(p1);

        b2 = new JButton("Add");
        b2.setBorder(new EmptyBorder(0, 0, 0, 0));
        b2.setForeground(new Color(255, 255, 255));
        b2.setBackground(new Color(32, 178, 170));
        b2.setFont(new Font("Segoe UI", Font.BOLD, 15));
        b2.addActionListener(this);
        b2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        b2.setBounds(340, 450, 140, 38);
        b2.setFocusable(false);
        add(b2);

        b3 = new JButton("Update");
        b3.setBorder(new EmptyBorder(0, 0, 0, 0));
        b3.setForeground(new Color(255, 255, 255));
        b3.setBackground(new Color(32, 178, 170));
        b3.setFont(new Font("Segoe UI", Font.BOLD, 15));
        b3.addActionListener(this);
        b3.setCursor(new Cursor(Cursor.HAND_CURSOR));
        b3.setBounds(578, 560, 140, 38);
        b3.setFocusable(false);
        b3.setVisible(false);
        add(b3);

        setVisible(true);
    }

    public AddUser(UserPanel up) {
        this();
        this.up = up;
    }

    public AddUser(UserDetails ud, String username) {
        this();
        this.ud = ud;
        this.username = username;
        l1.setText("Edit User");
        b2.setVisible(false);
        b3.setVisible(true);

        try {
            Conn conn = new Conn();
            String sql = "select *from  users where username='" + username + "'";
            PreparedStatement ps = conn.c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                //t1.setEditable(false);
                t1.setBackground(Color.WHITE);
                t1.setText(rs.getString(1));
                t2.setText(rs.getString(2));
                t3.setText(rs.getString(3));
                t4.setText(rs.getString(4));
                p1.setText(rs.getString(5));

            }
        } catch (Exception e) {
        }
    }

//    AddUser(UserDetails aThis, String username) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == b2) {

            String Username = t1.getText();
            String Name = t2.getText();
            String email = t3.getText();
            String Number = t4.getText();
            String password = new String(p1.getPassword());

            if (Username.isEmpty() || Name.isEmpty() || email.isEmpty() || Number.isEmpty() || password.isEmpty()) {

                JOptionPane.showMessageDialog(null, "Please fill in all fields.");
            } else if (Username.matches("^\\d.*")) {
                JOptionPane.showMessageDialog(AddUser.this, "Username cannot start with a number.");
            }else if (isUsernameExists(Username)) {
                JOptionPane.showMessageDialog(AddUser.this, "Username already exists. Please choose a different username.");
            }else if (Name.matches(".*\\d.*")) {
                JOptionPane.showMessageDialog(AddUser.this, "Name cannot contains number.");
            } else if (!isValidEmail(email)) {
                JOptionPane.showMessageDialog(AddUser.this, "Invalid email address.");
            } else if (!isValidContactNumber(Number)) {
                JOptionPane.showMessageDialog(AddUser.this, "Invalid contact number. Please enter a 11-digit number.");
            } else if (isNumberExists(Number)) {
            JOptionPane.showMessageDialog(AddUser.this, "Contact Number is already exists. Please use a different number.");
            }else if (password.length() <= 6) {
                JOptionPane.showMessageDialog(AddUser.this, "Password must be more than 6 characters.");
            } else if (!password.matches(".*[!@#$%^&*()-+=].*")) {
                JOptionPane.showMessageDialog(AddUser.this, "Password must contain at least one special character.");
            }  else if (isEmailExists(email)) {
                JOptionPane.showMessageDialog(AddUser.this, "Email already exists. Please use a different email address.");
            } else {
                String query = "insert into users values('" + Username + "', '" + Name + "', '" + email + "', '" + Number + "', '" + password + "')";

                try {
                    Conn c = new Conn();

                    c.s.executeUpdate(query);

                    JOptionPane.showMessageDialog(null, "User Account Created Successfully");
                    setVisible(false);

                } catch (Exception ae) {
                    ae.printStackTrace();
                }

            }

        } else if (e.getSource() == b3) {
            String Username = t1.getText();
            String Name = t2.getText();
            String email = t3.getText();
            String Number = t4.getText();
            String password = new String(p1.getPassword());

            if (Username.isEmpty() || Name.isEmpty() || email.isEmpty() || Number.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill in all fields.");
            } else if (Name.matches(".*\\d.*")) {
                JOptionPane.showMessageDialog(AddUser.this, "Name cannot contain numbers.");
            } else if (!isValidEmail(email)) {
                JOptionPane.showMessageDialog(AddUser.this, "Invalid email address.");
            } else if (!isValidContactNumber(Number)) {
                JOptionPane.showMessageDialog(AddUser.this, "Invalid contact number. Please enter an 11-digit number.");
            } else if (password.length() <= 6) {
                JOptionPane.showMessageDialog(AddUser.this, "Password must be more than 6 characters.");
            } else if (!password.matches(".*[!@#$%^&*()-+=].*")) {
                JOptionPane.showMessageDialog(AddUser.this, "Password must contain at least one special character.");
            } else {
                try {
                    Conn conn = new Conn();
                    String sql = "update users set username='" + Username + "', name='" + Name + "', email='" + email + "', number='" + Number + "', password='" + password + "' where username='" + username + "'";
                    conn.s.executeUpdate(sql);
                    JOptionPane.showMessageDialog(null, "User updated successfully");
                    setVisible(false);
                    ud.display();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }

    }

    private boolean isValidContactNumber(String contactNumber) {
        String strippedNumber = contactNumber.replaceAll("[^\\d]", "");
        return strippedNumber.length() == 11;
    }

    private boolean isValidEmail(String email) {
        // Regular expression pattern for email validation
        String emailPattern = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";

        Pattern pattern = Pattern.compile(emailPattern);
        Matcher matcher = pattern.matcher(email);

        return matcher.matches();
    }

    private boolean isEmailExists(String email) {
        String query = "SELECT * FROM users WHERE email = '" + email + "'";

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery(query);
            return rs.next(); // Returns true if a row is found, indicating that the email already exists
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private boolean isUsernameExists(String username) {
        String query = "SELECT * FROM users WHERE username = '" + username + "'";

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery(query);
            return rs.next(); // Returns true if a row is found, indicating that the username already exists
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    private boolean isNumberExists(String number) {
    String query = "SELECT * FROM users WHERE number = '" + number + "'";

    try {
        Conn c = new Conn();
        ResultSet rs = c.s.executeQuery(query);
        return rs.next(); // Returns true if a row is found, indicating that the number already exists
    } catch (Exception e) {
        e.printStackTrace();
        return false;
    }
}

    public static void main(String[] args) {
        new AddUser();
    }
}
