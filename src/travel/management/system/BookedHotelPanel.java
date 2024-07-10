package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;
import javax.swing.border.*;
import net.proteanit.sql.DbUtils;

public class BookedHotelPanel extends JPanel {

    JPanel panel;
    JLabel l1;
    JTable table;
    String user;
    JScrollPane tableviewscroll;
    public BookedHotelDetails bhd;
    public AdminHome a;
    long id;
    
       public BookedHotelPanel(AdminHome a) {
        this();
        this.a = a;
    }

    BookedHotelPanel(long id) {

        this();
        this.id = id;

    }

    BookedHotelPanel() {

        setBorder(new EmptyBorder(0, 0, 0, 0));
        setBackground(Color.WHITE);
        this.setSize(1278, 900);
        setLayout(null);

        panel = new JPanel();
        panel.setBackground(new Color(32, 178, 170));
        panel.setBounds(1, 7, 1027, 160);
        add(panel);
        panel.setLayout(null);

        l1 = new JLabel("All Booked Hotels");
        l1.setIcon(null);
        l1.setBounds(5, 55, 400, 45);
        panel.add(l1);
        l1.setBackground(new Color(32, 178, 170));
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("Segoe UI", Font.BOLD, 30));

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
//                    id = Integer.parseInt(table.getValueAt(row, 0).toString());

                    try {
                        String originalString = table.getValueAt(row, 0).toString();
                        id = Long.parseLong(originalString.replaceAll("\\D", ""));
                    } catch (NumberFormatException ae) {
                        // Handle the exception if necessary
                        ae.printStackTrace();
                    }

                    panel.setVisible(false);
                    tableviewscroll.setVisible(false);
//                    if (a != null) {
                    bhd = new BookedHotelDetails(a, id);
                    add(bhd);
                    bhd.setVisible(true);
//                    }
//                    if (c != null) {
//                        bpd = new BookedPackageDetails(c, place, user);
//                        add(bpd);
//                        bpd.setVisible(true);
//                    }
                }
            }
        });

        try {
            Conn conn = new Conn();
            String sql = "select booking_id as 'Booking Id', hotelname as 'Hotel Name',name as 'Customer Name',customerID_Number as 'ID No.',persons as 'Total Persons',totalprice as 'Total Price' from bookhotels";
            PreparedStatement ps = conn.c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }
            table.getColumnModel().getColumn(0).setMaxWidth(200);
            table.getColumnModel().getColumn(1).setMaxWidth(230);
            table.getColumnModel().getColumn(2).setMaxWidth(240);
            table.getColumnModel().getColumn(3).setMaxWidth(170);
            table.getColumnModel().getColumn(4).setMaxWidth(200);
            table.getColumnModel().getColumn(5).setMaxWidth(200);
//            table.getColumnModel().getColumn(6).setMaxWidth(150);
//            table.getColumnModel().getColumn(7).setMaxWidth(161);
            table.getColumnModel().getColumn(6).setMaxWidth(180);
        } catch (Exception ae) {
        }
    }

    public BookedHotelPanel(String user) {
        this();
        this.user = user;
        try {
            Conn conn = new Conn();
            String sql = "select booking_id as 'Booking Id', hotelname as 'Hotel Name',name as 'Customer Name',customerID_Number as 'ID No.',persons as 'Total Persons',days as 'Days',totalprice as 'Total Price' from bookhotels "; //where username='" + user + "'
            PreparedStatement ps = conn.c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
//            JTable table = new JTable();
            
            if (rs != null) {
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }
            table.getColumnModel().getColumn(0).setMaxWidth(200);
            table.getColumnModel().getColumn(1).setMaxWidth(230);
            table.getColumnModel().getColumn(2).setMaxWidth(240);
            table.getColumnModel().getColumn(3).setMaxWidth(170);
            table.getColumnModel().getColumn(4).setMaxWidth(200);
            table.getColumnModel().getColumn(5).setMaxWidth(200);
//            table.getColumnModel().getColumn(6).setMaxWidth(150);
//            table.getColumnModel().getColumn(7).setMaxWidth(161);
            table.getColumnModel().getColumn(6).setMaxWidth(180);
            
//             JScrollPane scrollPane = new JScrollPane(table);
//             add(scrollPane);
        } catch (Exception ae) {
        }
    }
}
