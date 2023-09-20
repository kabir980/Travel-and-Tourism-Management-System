package travel.management.system;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.ImageIO;
import java.sql.*;

public class AddHotel extends JFrame implements ActionListener {

    JPanel headerpanel;
    JTextField t1, t2, t3, t4, t5;
    JLabel l1, l2, l3, l4, l5, l6, l7, filename;
    JButton b1, b2, b3;
    File file;
    HotelPanel hp;
    HotelDetails hd;
    String name;
    byte[] photo = null;

    AddHotel() {

        setSize(750, 612);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        headerpanel = new JPanel();
        headerpanel.setBackground(new Color(32, 178, 170));
        headerpanel.setBounds(0, 0, 750, 50);
        add(headerpanel);
        headerpanel.setLayout(null);

        l1 = new JLabel("Add Hotel");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("Segoe UI Emoji", Font.BOLD, 30));
        l1.setHorizontalAlignment(SwingConstants.CENTER);
        l1.setBounds(0, 5, 750, 50);
        headerpanel.add(l1);

        l2 = new JLabel("Hotel Name: ");
        l2.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 18));
        l2.setBounds(60, 80, 200, 40);
        add(l2);

        l3 = new JLabel();
        l3.setBorder(new LineBorder(Color.GRAY));
        l3.setBounds(60, 335, 220, 220);
        Image i1 = new ImageIcon(ClassLoader.getSystemResource("Travel/Management/System/icons/hotelicon.jpeg")).getImage().getScaledInstance(220, 220, Image.SCALE_SMOOTH);
        l3.setIcon(new ImageIcon(i1));
        add(l3);

        l4 = new JLabel("City/State Name: ");
        l4.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 18));
        l4.setBounds(60, 130, 200, 40);
        add(l4);

        l5 = new JLabel("AC Cost Per Day: ");
        l5.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 18));
        l5.setBounds(60, 180, 200, 40);
        add(l5);

        l6 = new JLabel("Food Cost Per Day: ");
        l6.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 18));
        l6.setBounds(60, 230, 200, 40);
        add(l6);

        l7 = new JLabel("Hotel Cost Per Day: ");
        l7.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 18));
        l7.setBounds(60, 280, 200, 40);
        add(l7);

        t1 = new JTextField();
        t1.setForeground(Color.DARK_GRAY);
        t1.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 18));
        t1.setBounds(270, 80, 380, 40);
        add(t1);

        t2 = new JTextField();
        t2.setForeground(Color.DARK_GRAY);
        t2.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 18));
        t2.setBounds(270, 130, 380, 40);
        add(t2);

        t3 = new JTextField();
        t3.setForeground(Color.DARK_GRAY);
        t3.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 18));
        t3.setBounds(270, 180, 380, 40);
        add(t3);

        t4 = new JTextField();
        t4.setForeground(Color.DARK_GRAY);
        t4.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 18));
        t4.setBounds(270, 230, 380, 40);
        add(t4);

        t5 = new JTextField();
        t5.setForeground(Color.DARK_GRAY);
        t5.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 18));
        t5.setBounds(270, 280, 380, 40);
        add(t5);

        b1 = new JButton("Choose File");
        b1.addActionListener(this);
        b1.setFocusable(false);
        b1.setBackground(new Color(245, 245, 245));
        b1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        b1.setBounds(290, 425, 110, 30);
        b1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        add(b1);

        b2 = new JButton("Add");
        b2.setBorder(new EmptyBorder(0, 0, 0, 0));
        b2.setForeground(new Color(255, 255, 255));
        b2.setBackground(new Color(32, 178, 170));
        b2.setFont(new Font("Segoe UI", Font.BOLD, 15));
        b2.addActionListener(this);
        b2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        b2.setBounds(578, 525, 140, 38);
        b2.setFocusable(false);
        add(b2);

        b3 = new JButton("Update");
        b3.setBorder(new EmptyBorder(0, 0, 0, 0));
        b3.setForeground(new Color(255, 255, 255));
        b3.setBackground(new Color(32, 178, 170));
        b3.setFont(new Font("Segoe UI", Font.BOLD, 15));
        b3.addActionListener(this);
        b3.setCursor(new Cursor(Cursor.HAND_CURSOR));
        b3.setBounds(578, 525, 140, 38);
        b3.setFocusable(false);
        b3.setVisible(false);
        add(b3);

        filename = new JLabel("No file choosen");
        filename.setFont(new Font("Tahoma", Font.PLAIN, 14));
        filename.setBounds(410, 425, 550, 32);
        add(filename);
    }

    public AddHotel(HotelPanel hp) {
        this();
        this.hp = hp;
    }

    public AddHotel(HotelDetails hd, String name) {
        this();
        this.hd = hd;
        this.name = name;
        l1.setText("Edit Hotel");
        b2.setVisible(false);
        b3.setVisible(true);
        try {
            Conn conn = new Conn();
            String sql = "select *from  hotels where name='" + name + "'";
            PreparedStatement ps = conn.c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                t1.setEditable(false);
                t1.setBackground(Color.WHITE);
                t1.setText(rs.getString(1));
                t2.setText(rs.getString(2));
                t3.setText(rs.getString(3));
                t4.setText(rs.getString(4));
                t5.setText(rs.getString(5));
                byte[] photo = rs.getBytes(6);
                Image i1 = new ImageIcon(photo).getImage().getScaledInstance(220, 220, Image.SCALE_SMOOTH);
                l3.setIcon(new ImageIcon(i1));
            }
        } catch (Exception e) {
        }

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {

            FileDialog fd = new FileDialog(this, "Choose a Profile pic", FileDialog.LOAD);
            fd.setDirectory("C:\\Program Files\\Java\\Travel Management System\\src\\travel\\management\\system\\icons");
            fd.setFile("*.jpeg;*.jpg;*.png;*.tiff;*.tif;*.gif;");
            fd.setLocationRelativeTo(null);
            fd.setVisible(true);
            String strfilename = fd.getFile();
            String imagepath = fd.getDirectory() + strfilename;
            if (fd.getFile() != null) {
                file = new File(imagepath);

                try {
                    Image image = ImageIO.read(file).getScaledInstance(220, 220, Image.SCALE_SMOOTH);
                    l3.setIcon(new ImageIcon(image));
                    filename.setText(file.getName());

                    FileInputStream fis = new FileInputStream(file);
                    ByteArrayOutputStream bos = new ByteArrayOutputStream();
                    byte[] buf = new byte[1024];
                    for (int readNum; (readNum = fis.read(buf)) != -1;) {
                        bos.write(buf, 0, readNum);
                    }
                    photo = bos.toByteArray();
                } catch (Exception ae) {
                }

            }
        } else if (e.getSource() == b2) {
            if (validateFields()) {
                try {
                    Conn conn = new Conn();
                    String sql = "insert into hotels values(?, ?, ?, ?, ?, ?)";
                    PreparedStatement ps = conn.c.prepareStatement(sql);
                    ps.setString(1, t1.getText());
                    ps.setString(2, t2.getText());
                    ps.setString(3, t3.getText());
                    ps.setString(4, t4.getText());
                    ps.setString(5, t5.getText());
                    ps.setBytes(6, photo);
                    ps.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Hotel Created Successfully");
                    hp.createtablemodel();
                    this.dispose();
                } catch (Exception ae) {
                }
            }
        } else if (e.getSource() == b3) {
            if (validateFields()) {
                try {
                    Conn conn = new Conn();
                    String sql1 = "update hotels set name=?, state=?, ac=?, food=?, hotelcost=?, image=? where name='" + name + "'";
                    PreparedStatement ps1 = conn.c.prepareStatement(sql1);
                    ps1.setString(1, t1.getText());
                    ps1.setString(2, t2.getText());
                    ps1.setString(3, t3.getText());
                    ps1.setString(4, t4.getText());
                    ps1.setString(5, t5.getText());
                    ps1.setBytes(6, photo);
                    ps1.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Update Hotel Data Successfully");
                    hd.display();
                    this.dispose();

                } catch (Exception ae) {
                }
            }
        }
    }

    private boolean validateFields() {
        String hotelName = t1.getText().trim();
        String cityStateName = t2.getText().trim();
        String acCost = t3.getText().trim();
        String foodCost = t4.getText().trim();
        String hotelCost = t5.getText().trim();

        if (hotelName.isEmpty() || cityStateName.isEmpty() || acCost.isEmpty() || foodCost.isEmpty() || hotelCost.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all the fields.", "Incomplete Fields", JOptionPane.WARNING_MESSAGE);
            return false;
        }

        // Check if the hotel name contains numeric values
        if (hotelName.matches(".*\\d.*")) {
            JOptionPane.showMessageDialog(this, "The hotel name cannot contain numeric values.", "Invalid Hotel Name", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        
        // Check if AC Cost Per Day is a valid numeric value
    if (!isValidNumericValue(acCost)) {
        JOptionPane.showMessageDialog(this, "AC Cost Per Day must be a valid numeric value.", "Invalid Value", JOptionPane.WARNING_MESSAGE);
        return false;
    }

    // Check if Food Cost Per Day is a valid numeric value
    if (!isValidNumericValue(foodCost)) {
        JOptionPane.showMessageDialog(this, "Food Cost Per Day must be a valid numeric value.", "Invalid Value", JOptionPane.WARNING_MESSAGE);
        return false;
    }

    // Check if Hotel Cost Per Day is a valid numeric value
    if (!isValidNumericValue(hotelCost)) {
        JOptionPane.showMessageDialog(this, "Hotel Cost Per Day must be a valid numeric value.", "Invalid Value", JOptionPane.WARNING_MESSAGE);
        return false;
    }

        // Positive Value Check
        double acCostValue = Double.parseDouble(acCost);
        double foodCostValue = Double.parseDouble(foodCost);
        double hotelCostValue = Double.parseDouble(hotelCost);

        if (acCostValue < 0 || foodCostValue < 0 || hotelCostValue < 0) {
            JOptionPane.showMessageDialog(this, "Please enter positive values for the cost fields.", "Invalid Values", JOptionPane.WARNING_MESSAGE);
            return false;
        }

        // Check if the photo field is empty
        if (photo == null) {
            JOptionPane.showMessageDialog(this, "Please choose a photo.", "Photo Not Selected", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        if (photo.length > 300 * 1024) { // Check if photo size exceeds 300KB
            JOptionPane.showMessageDialog(this, "Please choose a photo of size up to 300kb.", "Photo Size Exceeded", JOptionPane.WARNING_MESSAGE);
            return false; // Stop further execution
        }

        return true;
    }

    private boolean isValidNumericValue(String value) {
        try {
            Double.parseDouble(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
