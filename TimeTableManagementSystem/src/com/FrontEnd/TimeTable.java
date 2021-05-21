package com.FrontEnd;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Rectangle;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import com.dao.SessionDao;
import com.models.JTableModel;
import com.models.Session;
import com.util.DBUtill;

import net.proteanit.sql.DbUtils;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TimeTable extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private SessionDao ses;
	private DBUtill db;
	private Integer[][] sessionListId;
	private DefaultTableModel tableModel;
	private static ResultSet rs  = null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TimeTable frame = new TimeTable();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TimeTable() {
		
		ses = new SessionDao();
		db = new DBUtill();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1366, 768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1315, 729);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(64, 141, 1204, 469);
		panel.add(scrollPane);
		
		table = new JTable();
		String[] columnx = {"Time Slot", "Monday", "Tuesday", "wednesday", "Thurstday", "Friday"};		
	    tableModel = new DefaultTableModel(columnx, 0);
		this.table.setModel(tableModel);	
		scrollPane.setViewportView(table);
		
		refreshTableInsert("Dr. Ruwan Jayathilaka");
	}
	
	
	/*public void refreshTableInsert(String type) {				
		ArrayList<Session> ses = ses.deleteSession(type);myController.showMenu(type);
		this.menuListId = new Integer[(myMenu.size()/4) + 1][4];	
		
		int x = 0,y = 0;	
		String[] column = {"","","",""};
		Object[][] row = new Object[(myMenu.size()/4) + 1][4];
		
		for( Menu menu : myMenu) {
			String filepath = new String(menu.getImage());
			ImageIcon icon = new ImageIcon(filepath);
			Image img = icon.getImage();
			Image imgScale = img.getScaledInstance(150, 120, Image.SCALE_SMOOTH);
			ImageIcon scaledImgIcn = new ImageIcon(imgScale);
						
			row[x][y] = scaledImgIcn;
			menuListId[x][y] = menu.getItemID();
			y++;
			
			if(y == 4) {
				y = 0;
				x++;
			}
		}		
		
		JTableModel model = new JTableModel(column,row);
		this.tableInsert.setModel(model);
		this.tableInsert.setRowHeight(121);
	}	*/
	
	
	public void refreshTableInsert(String type) {				
		ArrayList<Session> session = showTable(type);
		//this.sessionListId = new Integer[(session.size()/4) + 1][5];	
		
		int x = 0,y = 0;	
		String[] column = {"","","","","",""};
		Object[][] row = new Object[(session.size()/4) + 1][6];
		
		for( Session Ses : session) {
			//String filepath = new String(Ses.getImage());
												
			row[x][0] = Ses.getTimeslot();
			
			y++;
			
			if(y == 4) {
				y = 0;
				x++;
			}
		}		
		
	
		JTableModel model = new JTableModel(column,row);
		this.table.setModel(model);
		this.table.setRowHeight(180);
		//this.table.setModel(model);
		//this.table.setRowHeight(121);
	}	
	
	
	/*public void refreshTableInsert() {	
		
		rs = db.refreshTableInsert();
		//this.table.setModel(DbUtils.resultSetToTableModel(rs));
		
		/*String[] columnx = {"id", "Monday"};	
		String[][] Data = {
				{"1\n  rr ddw   \n dddddd","tom"},	
		};
		
		table.setRowHeight(180);
		TableColumnModel col = table.getColumnModel();
		col.getColumn(0).setPreferredWidth(10);
		col.getColumn(1).setPreferredWidth(180);
		//table.setBounds(0, 0, 500, 180);
		try {
			while(rs.next()) {
				
				int id = rs.getInt(1);
				String lecture1 = rs.getString(2);
				String lecture2 = rs.getString(3);
				String tag = rs.getString(4);
				String room= rs.getString(5);
				//String maingroup = rs.getString(6);
				String subgroup = rs.getString(7);
				String subject = rs.getString(8);
				String subjectCode = rs.getString(9);
				//int noOfStudent = rs.getInt(10);
				String day = rs.getString(11);
				String timeslot = rs.getString(12);
				tableModel.addRow(new Object[] {lecture1+" "+ lecture2 });
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		 // tableModel = new DefaultTableModel(Data, columnx);
		    //tableModel.addRow(o);
			this.table.setModel(tableModel);	
		DefaultTableCellRenderer rRender = new DefaultTableCellRenderer();
		rRender.setHorizontalAlignment(JLabel.CENTER);
		
		for (int i =0 ; i<2 ; i++) {
			table.getColumnModel().getColumn(i).setCellRenderer(rRender);
		}
		*/
		
	  
			//int eid = 10;
			//String Name = "tharinda";
			//String x = eid + " \n" + "\n\n"+Name;
			//System.out.println(x);
			//tableModel.addRow(new Object[] {x});
		
		
		
	
	
	public ArrayList<Session> showTable( String Type ){
		
		String type = null;	
					
			try {
				return this.ses.getSessionList(Type );
			} catch (SQLException e) {				
				e.printStackTrace();
			}			 
		
		return null;
	}

	
}
