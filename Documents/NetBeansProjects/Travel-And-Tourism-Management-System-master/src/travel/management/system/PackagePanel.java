package travel.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.border.*;
import net.proteanit.sql.DbUtils;

public class PackagePanel extends JPanel implements ActionListener{
    
    JPanel panel;
    JLabel l1;
    JButton b1, b2, b3;
    JTable table;
    String place, user;
    JScrollPane tableviewscroll;
    public PackageDetails pd;
    public CustomerHome c;
    public AdminHome a;
    
   private String adminUsername;
    
    public PackagePanel(AdminHome a){
        this();
        this.a = a;
    }
    public PackagePanel(CustomerHome c, String user){
        this();
        this.c = c;
        this.user = user;
        b1.setVisible(false);
    }
    
    PackagePanel(String adminUsername) {
        this();
        this.adminUsername = adminUsername;
    }
    
    public PackagePanel(AdminHome a, String adminUsername) {
        this();
        this.a = a;
        this.adminUsername = adminUsername;
    }

    
    PackagePanel(){
    
                setBorder(new EmptyBorder(0, 0, 0, 0));
		setBackground(Color.WHITE);
		this.setSize(1278, 900);
		setLayout(null); 
        
                panel = new JPanel();
		panel.setBackground(new Color(32, 178, 170));
		panel.setBounds(1, 7, 1027, 160);
		add(panel);
		panel.setLayout(null);
		
		l1 = new JLabel("All Packages");
		l1.setIcon(null);
		l1.setBounds(5, 55, 224, 45);
		panel.add(l1);
		l1.setBackground(new Color(32, 178, 170));
		l1.setForeground(Color.WHITE);
		l1.setFont(new Font("Segoe UI", Font.BOLD, 30));
                
                b1 = new JButton("Add Package");
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
		for(Component c : tableviewscroll.getComponents())
		{
			c.setBackground(Color.white);
		}
		add(tableviewscroll);
                  
                table = new JTable();
		table.setBorder(new LineBorder(Color.LIGHT_GRAY));
		table.getTableHeader().setBackground(new Color(32,178,170));
		table.getTableHeader().setForeground(Color.white);
		table.setSelectionBackground(new Color(240, 255, 255));
		table.getTableHeader().setFont(new Font("Arial",Font.BOLD,20));
		table.setFont(new Font("Segoe UI",Font.PLAIN,20));
		table.getTableHeader().setPreferredSize(new Dimension(50,40));
		table.setFocusable(false);
		table.setDragEnabled(false);
		table.setRowHeight(40);
		createtablemodel();
                table.setDefaultEditor(Object.class, null);
		table.setCursor(new Cursor(Cursor.HAND_CURSOR));
		table.setGridColor(Color.LIGHT_GRAY);
		table.getTableHeader().setReorderingAllowed(false);
                tableviewscroll.setViewportView(table);
		table.addMouseListener(new MouseAdapter()
		{
			public void mousePressed(MouseEvent e)
			{
			    if(e.getClickCount()>1 && e.getButton()==MouseEvent.BUTTON1){
				JTable t = (JTable) e.getSource();
				int row = t.getSelectedRow();
				place = table.getValueAt(row, 0)+"";
                                panel.setVisible(false);
                                tableviewscroll.setVisible(false);
                                if(a != null){
				pd = new PackageDetails(a, place);
                                add(pd);
                                pd.setVisible(true);
                                }
                                if(c != null){
				pd = new PackageDetails(c, place, user);
                                add(pd);
                                pd.setVisible(true);
                                }
                            }
                        }
                });
    }
    public void actionPerformed(ActionEvent ae){
            if(ae.getSource() == b1){
                new AddPackage(this.adminUsername).setVisible(true);
            }
    }
    
    public void createtablemodel()
	{
            try{
                 Conn conn = new Conn();
                 String sql = "select P.place as 'Place Name', P.state as 'City/State Name', P.price as 'Price', P.days_nights as 'Days And Nights', A.name as 'Created by' from packages P INNER JOIN adminlogins A ON P.created_by = A.id" ;
                 PreparedStatement ps = conn.c.prepareStatement(sql);
                 ResultSet rs = ps.executeQuery();
		 if(rs!=null){
			table.setModel(DbUtils.resultSetToTableModel(rs));
                 }
		 table.getColumnModel().getColumn(0).setMaxWidth(300);
		 table.getColumnModel().getColumn(1).setMaxWidth(300);
                 table.getColumnModel().getColumn(2).setMaxWidth(300);
                 table.getColumnModel().getColumn(3).setMaxWidth(371);
                 table.getColumnModel().getColumn(4).setMaxWidth(371);
            } catch(Exception ae){}
        
        }
}
