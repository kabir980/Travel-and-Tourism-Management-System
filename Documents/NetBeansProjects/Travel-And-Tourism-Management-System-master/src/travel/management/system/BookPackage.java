package travel.management.system;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import com.toedter.calendar.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class BookPackage extends JFrame implements ActionListener {

    JPanel headerpanel;
    JTextField t1, t2, t3, t4, t5, t6, t7;
    JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9;
    JButton b1, b2;
    JDateChooser dateChooser;
    String place, user;

    public BookPackage(String place, String user) {

        this.place = place;
        this.user = user;
        setSize(750, 545);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        headerpanel = new JPanel();
        headerpanel.setBackground(new Color(32, 178, 170));
        headerpanel.setBounds(0, 0, 750, 50);
        add(headerpanel);
        headerpanel.setLayout(null);

        l1 = new JLabel("Book Package");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("Segoe UI Emoji", Font.BOLD, 30));
        l1.setHorizontalAlignment(SwingConstants.CENTER);
        l1.setBounds(0, 2, 750, 50);
        headerpanel.add(l1);

        l2 = new JLabel("Place Name: ");
        l2.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 18));
        l2.setBounds(60, 80, 200, 40);
        add(l2);

        l3 = new JLabel("Customer Name: ");
        l3.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 18));
        l3.setBounds(60, 130, 200, 40);
        add(l3);

        l4 = new JLabel("ID NO: ");
        l4.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 18));
        l4.setBounds(60, 180, 200, 40);
        add(l4);

        l5 = new JLabel("Package Price: ");
        l5.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 18));
        l5.setBounds(60, 230, 200, 40);
        add(l5);

        l6 = new JLabel("Total Persons: ");
        l6.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 18));
        l6.setBounds(60, 280, 200, 40);
        add(l6);

        l7 = new JLabel("Date: ");
        l7.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 18));
        l7.setBounds(60, 330, 200, 40);
        add(l7);

        l8 = new JLabel("Total Price: ");
        l8.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 18));
        l8.setBounds(60, 380, 200, 40);
        add(l8);

        t1 = new JTextField();
        t1.setForeground(Color.DARK_GRAY);
        t1.setEditable(false);
        t1.setBackground(Color.WHITE);
        t1.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 18));
        t1.setBounds(270, 80, 380, 40);
        add(t1);

        t2 = new JTextField();
        t2.setForeground(Color.DARK_GRAY);
        t2.setEditable(true);
        t2.setBackground(Color.WHITE);
        t2.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 18));
        t2.setBounds(270, 130, 380, 40);
        add(t2);

        t3 = new JTextField();
        t3.setForeground(Color.DARK_GRAY);
        t3.setEditable(true);
        t3.setBackground(Color.WHITE);
        t3.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 18));
        t3.setBounds(270, 180, 380, 40);
        add(t3);

        t4 = new JTextField();
        t4.setForeground(Color.DARK_GRAY);
        t4.setEditable(false);
        t4.setBackground(Color.WHITE);
        t4.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 18));
        t4.setBounds(270, 230, 380, 40);
        add(t4);

        t5 = new JTextField();
        t5.setForeground(Color.DARK_GRAY);
        t5.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 18));
        t5.setBounds(270, 280, 380, 40);
        add(t5);

        dateChooser = new JDateChooser();
        dateChooser.setBounds(270, 330, 380, 40);
        add(dateChooser);

        l9 = new JLabel();
        l9.setFont(new Font("Segoe UI Emoji", Font.BOLD, 18));
        l9.setBounds(270, 380, 380, 40);
        l9.setForeground(Color.BLUE);
        l9.setBackground(Color.WHITE);
        add(l9);

        try {
            Conn conn = new Conn();
            PreparedStatement ps = conn.c.prepareStatement("select * from packages where place='" + place + "'");
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                t1.setText(rs.getString("place"));
                t4.setText(rs.getString("price"));
            }
//                    PreparedStatement ps1 = conn.c.prepareStatement("select * from customers where username='"+user+"'");
//                    ResultSet rs1 = ps1.executeQuery();
//                    if(rs1.next()){
//                        t2.setText(rs1.getString("name"));
//                        t3.setText(rs1.getString("username"));
//                    }
        } catch (Exception e) {
        }

        b1 = new JButton("Book");
        b1.setBorder(new EmptyBorder(0, 0, 0, 0));
        b1.setForeground(new Color(255, 255, 255));
        b1.setBackground(new Color(32, 178, 170));
        b1.setFont(new Font("Segoe UI", Font.BOLD, 15));
        b1.addActionListener(this);
        b1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        b1.setBounds(578, 455, 140, 38);
        b1.setFocusable(false);
        add(b1);

        b2 = new JButton("Check Price");
        b2.setBorder(new EmptyBorder(0, 0, 0, 0));
        b2.setForeground(new Color(255, 255, 255));
        b2.setBackground(new Color(32, 178, 170));
        b2.setFont(new Font("Segoe UI", Font.BOLD, 15));
        b2.addActionListener(this);
        b2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        b2.setBounds(427, 455, 140, 38);
        b2.setFocusable(false);
        add(b2);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {

            if (validateFields()) {

                try {
                    Conn conn = new Conn();

                    // Generate the booking ID
                    String bookingID = generatePackageBookingID();

                    String sql = "insert into bookpackages values(?, ?, ?, ?, ?, ?, ?)";
                    PreparedStatement ps = conn.c.prepareStatement(sql);
                    ps.setString(1, bookingID);
                    ps.setString(2, t1.getText());
                    ps.setString(3, t2.getText());
                    ps.setString(4, t3.getText());
                    ps.setString(5, t5.getText());
                    ps.setString(6, ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText());
                    ps.setString(7, l9.getText());
                    ps.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Package Booked Successfully");
                    this.dispose();
                } catch (Exception e1) {
                }
            }
        }

        if (ae.getSource() == b2) {

            if (validateFields()) {

                int person = Integer.parseInt(t4.getText());
                int cost = Integer.parseInt(t5.getText());
                int totalcost = cost * person;
                if (totalcost > 0) {
                    l9.setText("" + totalcost);
                } else {
                    l9.setText("Please enter a valid number!!!");
                }
            }
        }
    }

    private String generatePackageBookingID() {
        // Retrieve the current timestamp
        long timestamp = System.currentTimeMillis();

        // Generate a random number between 1000 and 9999
        int randomNumber = (int) (Math.random() * (9999 - 1000 + 1) + 1000);

        // Concatenate the timestamp and random number to form the booking ID
        return "BID-" + timestamp + "-" + randomNumber;
    }

    private boolean validateFields() {
        if (t1.getText().isEmpty() || t2.getText().isEmpty() || t3.getText().isEmpty()
                || t5.getText().isEmpty() || ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill in all the fields.");
            return false;
        }

        if (isNumeric(t2.getText())) {
            JOptionPane.showMessageDialog(null, "Customer name cannot be a number.");
            return false;

        }
        if (!isNonDecimalNumber(t3.getText())) {
            JOptionPane.showMessageDialog(null, "ID Nnumber must be a non-decimal number.");
            return false;
        }

        if (isIDExists(t3.getText())) {
            JOptionPane.showMessageDialog(null, "ID No is already used. Please enter a unique ID.");
            return false;
        }

        if (!isValidTotalPersons(t5.getText())) {
            JOptionPane.showMessageDialog(null, "Please enter a valid total persons count (1-50).");
            return false;
        }
        
          if (!isValidDate(dateChooser.getDate())) {
            JOptionPane.showMessageDialog(null, "Please select a valid date (not in the past).");
            return false;
        }
        
        

        return true;
    }
    
    

    //Check for customer name field
    private boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // Check for customer Id field
    private boolean isNonDecimalNumber(String str) {
        return str.matches("\\d+");
    }

    //check for id number repeation
    private boolean isIDExists(String customerID_Number) {
        try {
            Conn conn = new Conn();
            PreparedStatement ps = conn.c.prepareStatement("SELECT * FROM bookpackages WHERE id = ?");
            ps.setString(1, customerID_Number);
            ResultSet rs = ps.executeQuery();
            return rs.next(); // If the result set has a next row, it means the ID is already used
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    //check for total persons field
    private boolean isValidTotalPersons(String totalPersons) {
    try {
        int count = Integer.parseInt(totalPersons);
        return count > 0 && count <= 50;
    } catch (NumberFormatException e) {
        return false;
    }
}
    
    // Check if the selected date is valid (not in the past)
    private boolean isValidDate(Date selectedDate) {
        
        Date currentDate = new Date(); // Get the current date

        return selectedDate.after(currentDate); // Check if selected date is after the current date
    }

}
