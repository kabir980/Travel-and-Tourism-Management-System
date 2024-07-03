package travel.management.system;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;

public class BookedHotelDetails extends JPanel implements ActionListener {

    JLabel l1, l2, l3, l4, l5, l6, l7, l8, l10, l11, l12, l13, l14, l15, l16, l17, l18, l19, l20, l21, l22, l23, l24;
    JButton b1, b2;
    JPanel panel, panel1;
    public AdminHome a;
    public CustomerHome c;
    String place, user;
    long id;

    BookedHotelDetails(AdminHome a, String place) {
        this();
        this.a = a;
        this.place = place;
        display();
    }

    BookedHotelDetails(AdminHome a, long id) {
        this();
        this.a = a;
        this.id = id;
        display();
    }

    BookedHotelDetails(CustomerHome c, String place, String user) {
        this();
        this.c = c;
        this.place = place;
        this.user = user;
        b1.setText("Booked Package");
        display();
    }

    BookedHotelDetails() {

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

        l11 = new JLabel("Booked Hotel Details ");
        l11.setIcon(null);
        l11.setBounds(5, 55, 360, 45);
        panel.add(l11);
        l11.setBackground(new Color(32, 178, 170));
        l11.setForeground(Color.WHITE);
        l11.setFont(new Font("Segoe UI", Font.BOLD, 30));

        l1 = new JLabel("Booking Id  ");
        l1.setBorder(new LineBorder(new Color(192, 192, 192)));
        l1.setBackground(new Color(255, 255, 255));
        l1.setFont(new Font("Segoe UI Historic", Font.PLAIN, 20));
        l1.setBounds(2, 60, 250, 45);
        panel1.add(l1);

        l3 = new JLabel();
        l3.setBorder(new LineBorder(new Color(192, 192, 192)));
        l3.setBackground(new Color(255, 255, 255));
        l3.setFont(new Font("Segoe UI Historic", Font.BOLD, 20));
        l3.setBounds(252, 60, 330, 45);
        panel1.add(l3);

        l2 = new JLabel("Hotel Name  ");
        l2.setFont(new Font("Segoe UI Historic", Font.PLAIN, 20));
        l2.setBorder(new LineBorder(new Color(192, 192, 192)));
        l2.setBackground(Color.WHITE);
        l2.setBounds(2, 104, 250, 45);
        panel1.add(l2);

        l4 = new JLabel();
        l4.setFont(new Font("Segoe UI Historic", Font.BOLD, 20));
        l4.setBorder(new LineBorder(new Color(192, 192, 192)));
        l4.setBackground(Color.WHITE);
        l4.setBounds(252, 104, 330, 45);
        panel1.add(l4);

        l12 = new JLabel("Customer name  ");
        l12.setFont(new Font("Segoe UI Historic", Font.PLAIN, 20));
        l12.setBorder(new LineBorder(new Color(192, 192, 192)));
        l12.setBackground(Color.WHITE);
        l12.setBounds(2, 148, 250, 45);
        panel1.add(l12);

        l13 = new JLabel();
        l13.setFont(new Font("Segoe UI Historic", Font.BOLD, 20));
        l13.setBorder(new LineBorder(new Color(192, 192, 192)));
        l13.setBackground(Color.WHITE);
        l13.setBounds(252, 148, 330, 45);
        panel1.add(l13);

        l16 = new JLabel("Total Price  ");
        l16.setFont(new Font("Segoe UI Historic", Font.PLAIN, 20));
        l16.setBorder(new LineBorder(new Color(192, 192, 192)));
        l16.setBackground(Color.WHITE);
        l16.setBounds(2, 192, 250, 45);
        panel1.add(l16);

        l22 = new JLabel();
        l22.setFont(new Font("Segoe UI Historic", Font.BOLD, 20));
        l22.setBorder(new LineBorder(new Color(192, 192, 192)));
        l22.setBackground(Color.WHITE);
        l22.setBounds(252, 192, 330, 45);
        panel1.add(l22);

        l20 = new JLabel("Booked at  ");
        l20.setFont(new Font("Segoe UI Historic", Font.PLAIN, 20));
        l20.setBorder(new LineBorder(new Color(192, 192, 192)));
        l20.setBackground(Color.WHITE);
        l20.setBounds(2, 236, 250, 45);
        panel1.add(l20);

        l21 = new JLabel();
        l21.setFont(new Font("Segoe UI Historic", Font.BOLD, 20));
        l21.setBorder(new LineBorder(new Color(192, 192, 192)));
        l21.setBackground(Color.WHITE);
        l21.setBounds(252, 236, 330, 45);
        panel1.add(l21);

        l5 = new JLabel("Customer ID No.  ");
        l5.setBorder(new LineBorder(new Color(192, 192, 192)));
        l5.setBackground(new Color(255, 255, 255));
        l5.setFont(new Font("Segoe UI Historic", Font.PLAIN, 20));
        l5.setBounds(582, 60, 180, 45);
        panel1.add(l5);

        l7 = new JLabel();
        l7.setBorder(new LineBorder(new Color(192, 192, 192)));
        l7.setBackground(new Color(255, 255, 255));
        l7.setFont(new Font("Segoe UI Historic", Font.BOLD, 20));
        l7.setBounds(762, 60, 259, 45);
        panel1.add(l7);

        l6 = new JLabel("Tolat Persons  ");
        l6.setFont(new Font("Segoe UI Historic", Font.PLAIN, 20));
        l6.setBorder(new LineBorder(new Color(192, 192, 192)));
        l6.setBackground(Color.WHITE);
        l6.setBounds(582, 104, 180, 45);
        panel1.add(l6);

        l17 = new JLabel();
        l17.setFont(new Font("Segoe UI Historic", Font.BOLD, 20));
        l17.setBorder(new LineBorder(new Color(192, 192, 192)));
        l17.setBackground(Color.WHITE);
        l17.setBounds(762, 104, 259, 45);
        panel1.add(l17);

        l14 = new JLabel("No. of Days  ");
        l14.setFont(new Font("Segoe UI Historic", Font.PLAIN, 20));
        l14.setBorder(new LineBorder(new Color(192, 192, 192)));
        l14.setBackground(Color.WHITE);
        l14.setBounds(582, 148, 180, 45);
        panel1.add(l14);

        l15 = new JLabel();
        l15.setFont(new Font("Segoe UI Historic", Font.BOLD, 20));
        l15.setBorder(new LineBorder(new Color(192, 192, 192)));
        l15.setBackground(Color.WHITE);
        l15.setBounds(762, 148, 259, 45);
        panel1.add(l15);

        l18 = new JLabel("Ac or Not ");
        l18.setFont(new Font("Segoe UI Historic", Font.PLAIN, 20));
        l18.setBorder(new LineBorder(new Color(192, 192, 192)));
        l18.setBackground(Color.WHITE);
        l18.setBounds(582, 192, 180, 45);
        panel1.add(l18);

        l19 = new JLabel();
        l19.setFont(new Font("Segoe UI Historic", Font.BOLD, 20));
        l19.setBorder(new LineBorder(new Color(192, 192, 192)));
        l19.setBackground(Color.WHITE);
        l19.setBounds(762, 192, 259, 45);
        panel1.add(l19);
        
        l23 = new JLabel("Food Included ? ");
        l23.setFont(new Font("Segoe UI Historic", Font.PLAIN, 20));
        l23.setBorder(new LineBorder(new Color(192, 192, 192)));
        l23.setBackground(Color.WHITE);
        l23.setBounds(582, 236, 180, 45);
        panel1.add(l23);
        
        l24 = new JLabel();
        l24.setFont(new Font("Segoe UI Historic", Font.BOLD, 20));
        l24.setBorder(new LineBorder(new Color(192, 192, 192)));
        l24.setBackground(Color.WHITE);
        l24.setBounds(762, 236, 259, 45);
        panel1.add(l24);

//        l10 = new JLabel();
//        l10.setBounds(300, 15, 400, 200);
//        l10.setBorder(new LineBorder(new Color(192, 192, 192)));
//        panel1.add(l10);
//        b1 = new JButton("Edit Package");
//        b1.setBorder(new EmptyBorder(0, 0, 0, 0));
//        b1.setBounds(800, 120, 140, 30);
//        panel.add(b1);
//        b1.addActionListener(this);
//        b1.setCursor(new Cursor(Cursor.HAND_CURSOR));
//        b1.setFocusable(false);
//        b1.setForeground(new Color(0, 128, 128));
//        b1.setFont(new Font("Segoe UI", Font.BOLD, 15));
//        b1.setBackground(Color.WHITE);

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

    }

     public void display() {
        try {
            Conn conn = new Conn();
            PreparedStatement ps = conn.c.prepareStatement("select * from bookhotels where booking_id=?");

            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
            l3.setText(rs.getString("booking_id"));
            l4.setText(rs.getString("hotelname"));
            l13.setText(rs.getString("name"));
            l7.setText(rs.getString("customerID_Number"));
            l17.setText(rs.getString("persons"));
            l15.setText(rs.getString("days"));
            l22.setText(rs.getString("totalprice"));
            l19.setText(rs.getString("ac_nonac"));
            l24.setText(rs.getString("food"));
            l21.setText(rs.getString("booked_at"));
        }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
            if (a != null) {
//                new AddPackage(this, place).setVisible(true);
            }
            if (c != null) {
                new BookPackage(place, user).setVisible(true);
            }
        } else if (ae.getSource() == b2) {
           panel.setVisible(false);
        panel1.setVisible(false);

        // Assuming a is always set for this case
        BookedHotelPanel bhd = new BookedHotelPanel(a);
        add(bhd);
        bhd.setVisible(true);
        }
    }
}
