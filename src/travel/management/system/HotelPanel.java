package travel.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.border.*;
import net.proteanit.sql.DbUtils;

public class HotelPanel extends JPanel implements ActionListener {

    JPanel panel;
    JLabel l1;
    JButton b1, b2, b3;
    JTable table;
    String name, user;
    JScrollPane tableviewscroll;
    public AdminHome a;
    public CustomerHome c;
    public HotelDetails hd;

    private String adminUsername;

    public HotelPanel(AdminHome a) {
        this();
        this.a = a;
    }

    public HotelPanel(CustomerHome c, String user) {
        this();
        this.c = c;
        this.user = user;
        b1.setVisible(false);
    }

    HotelPanel(String adminUsername) {
        this();
        this.adminUsername = adminUsername;
    }

    public HotelPanel(AdminHome a, String adminUsername) {
        this();
        this.a = a;
        this.adminUsername = adminUsername;
    }

    HotelPanel() {

        setBorder(new EmptyBorder(0, 0, 0, 0));
        setBackground(Color.WHITE);
        this.setSize(1278, 900);
        setLayout(null);

        panel = new JPanel();
        panel.setBackground(new Color(32, 178, 170));
        panel.setBounds(1, 7, 1027, 160);
        add(panel);
        panel.setLayout(null);

        l1 = new JLabel("All Hotels");
        l1.setIcon(null);
        l1.setBounds(5, 55, 224, 45);
        panel.add(l1);
        l1.setBackground(new Color(32, 178, 170));
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("Segoe UI", Font.BOLD, 30));

        b1 = new JButton("Add Hotel");
        b1.setBorder(new EmptyBorder(0, 0, 0, 0));
        b1.setBounds(800, 120, 140, 30);
        panel.add(b1);
        b1.addActionListener(this);
        b1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        b1.setFocusable(false);
        b1.setForeground(new Color(0, 128, 128));
        b1.setFont(new Font("Segoe UI", Font.BOLD, 15));
        b1.setBackground(Color.WHITE);

        tableviewscroll = new JScrollPane();
        tableviewscroll.setBorder(new EmptyBorder(0, 0, 0, 0));
        tableviewscroll.setBounds(1, 172, 1027, 617);
        for (Component c : tableviewscroll.getComponents()) {
            c.setBackground(Color.white);
        }
        add(tableviewscroll);

        table = new JTable();
        table.setBorder(new LineBorder(Color.LIGHT_GRAY));
        table.getTableHeader().setBackground(new Color(32, 178, 170));
        table.getTableHeader().setForeground(Color.white);
        table.setSelectionBackground(new Color(240, 255, 255));
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 20));
        table.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        table.getTableHeader().setPreferredSize(new Dimension(50, 40));
        table.setFocusable(false);
        table.setDragEnabled(false);
        table.setRowHeight(40);
        createtablemodel();
        table.setDefaultEditor(Object.class, null);
        table.setCursor(new Cursor(Cursor.HAND_CURSOR));
        table.setGridColor(Color.LIGHT_GRAY);
        table.getTableHeader().setReorderingAllowed(false);
        tableviewscroll.setViewportView(table);
        table.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                if (e.getClickCount() > 1 && e.getButton() == MouseEvent.BUTTON1) {
                    JTable t = (JTable) e.getSource();
                    int row = t.getSelectedRow();
                    name = table.getValueAt(row, 0) + "";
                    panel.setVisible(false);
                    tableviewscroll.setVisible(false);
                    if (a != null) {
                        hd = new HotelDetails(a, name);
                        add(hd);
                        hd.setVisible(true);
                    }
                    if (c != null) {
                        hd = new HotelDetails(c, name, user);
                        add(hd);
                        hd.setVisible(true);

                    }
                }
            }
        });
    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == b1) {
            new AddHotel(this.adminUsername).setVisible(true);
        }
    }

    public void createtablemodel() {
        try {
            Conn conn = new Conn();
            String sql = "select H.name as 'Hotel Name', H.state as 'City/State Name', H.ac as 'AC Cost Per Day', H.food as 'Food Cost Per Day', H.hotelcost as 'Hotel Cost Per Day', A.name as 'Created by' from hotels H INNER JOIN adminlogins A ON H.created_by = A.id";
            PreparedStatement ps = conn.c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }
            table.getColumnModel().getColumn(0).setMaxWidth(250);
            table.getColumnModel().getColumn(1).setMaxWidth(270);
            table.getColumnModel().getColumn(2).setMaxWidth(250);
            table.getColumnModel().getColumn(3).setMaxWidth(250);
            table.getColumnModel().getColumn(4).setMaxWidth(251);
            table.getColumnModel().getColumn(5).setMaxWidth(251);
        } catch (Exception ae) {
        }

    }
}
