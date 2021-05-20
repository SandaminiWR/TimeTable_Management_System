package com.FrontEnd;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.dao.NotAvailableDao;
import com.dao.editLocationDao;
import com.models.Lecture;
import com.models.NotAvailable;
import com.models.Session;
import com.models.editLocation;
import com.util.DBUtill;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;

public class AddEditLocation extends JFrame implements ActionListener, MouseListener {

	private JFrame frame;
	private editLocation editLocation;
	private editLocationDao editLoc;
	private Session session;
	private DBUtill db;
	private static ResultSet rs  = null;
	
	private JPanel contentPane;
	private JTable table;
	
	
	private JButton btnAddSe;
	private JButton btn_delete;
	private JButton btn_update;
	private JButton btnAddClear;
	
	private JComboBox comboBox_min_en;
	private JComboBox comboBoxRoom;
	private JComboBox comboBox_day;
	private JComboBox comboBox_hrs_St;
	private JComboBox comboBox_hrs_en;
	private JComboBox comboBox_min_st;
	
	private int lID;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btn____Home;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddEditLocation frame = new AddEditLocation();
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
	@SuppressWarnings("rawtypes")
	public AddEditLocation() {
		setTitle("Add Location");
		
		this.editLoc = new editLocationDao();
		this.editLocation = new editLocation();
		this.session = new Session();
		this.db = new DBUtill();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1366, 768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 11, 1350, 729);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Room ID");
		lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 17));
		lblNewLabel.setBounds(68, 146, 110, 30);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Start Time");
		lblNewLabel_1.setFont(new Font("Dialog", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(651, 146, 110, 30);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Minutes");
		lblNewLabel_2.setFont(new Font("Dialog", Font.PLAIN, 17));
		lblNewLabel_2.setBounds(977, 155, 60, 13);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Hours");
		lblNewLabel_3.setFont(new Font("Dialog", Font.PLAIN, 17));
		lblNewLabel_3.setBounds(853, 155, 46, 13);
		panel.add(lblNewLabel_3);
		
		JLabel lblEndTime = new JLabel("End Time");
		lblEndTime.setFont(new Font("Dialog", Font.PLAIN, 17));
		lblEndTime.setBounds(651, 272, 110, 30);
		panel.add(lblEndTime);
		
		JLabel lblSelectDay = new JLabel("Select Day");
		lblSelectDay.setFont(new Font("Dialog", Font.PLAIN, 17));
		lblSelectDay.setBounds(68, 272, 110, 30);
		panel.add(lblSelectDay);
		
		 btnAddSe = new JButton("ADD ");
		 btnAddSe.addActionListener(this);
		btnAddSe.setBounds(497, 656, 133, 21);
		panel.add(btnAddSe);
		
		 btnAddClear = new JButton("CLEAR");
		 btnAddClear.addActionListener(this);
		btnAddClear.setBounds(781, 656, 121, 21);
		panel.add(btnAddClear);
		
		 comboBoxRoom = new JComboBox();
		 comboBoxRoom.setFont(new Font("Tahoma", Font.PLAIN, 13));
		 comboBoxRoom.setModel(new DefaultComboBoxModel(new String[] {"ID"}));
		comboBoxRoom.setBounds(202, 147, 110, 30);
		panel.add(comboBoxRoom);
		
		JLabel lblNewLabel_3_1 = new JLabel("Hours");
		lblNewLabel_3_1.setFont(new Font("Dialog", Font.PLAIN, 17));
		lblNewLabel_3_1.setBounds(853, 281, 46, 13);
		panel.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("Minutes");
		lblNewLabel_2_1.setFont(new Font("Dialog", Font.PLAIN, 17));
		lblNewLabel_2_1.setBounds(987, 281, 60, 13);
		panel.add(lblNewLabel_2_1);
		
		 comboBox_day = new JComboBox();
		 comboBox_day.setFont(new Font("Tahoma", Font.PLAIN, 13));
		 comboBox_day.setModel(new DefaultComboBoxModel(new String[] {"Day", "Monday", "Tuesday", "Wensday", "Thurstday", "Friday"}));
		comboBox_day.setBounds(202, 276, 110, 22);
		panel.add(comboBox_day);
		
		 comboBox_hrs_St = new JComboBox();
		 comboBox_hrs_St.setFont(new Font("Tahoma", Font.PLAIN, 13));
		 comboBox_hrs_St.setModel(new DefaultComboBoxModel(new String[] {"Hrs", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		comboBox_hrs_St.setBounds(799, 150, 48, 22);
		panel.add(comboBox_hrs_St);
		
		 comboBox_hrs_en = new JComboBox();
		 comboBox_hrs_en.setFont(new Font("Tahoma", Font.PLAIN, 13));
		 comboBox_hrs_en.setModel(new DefaultComboBoxModel(new String[] {"Hrs", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		comboBox_hrs_en.setBounds(799, 276, 48, 22);
		panel.add(comboBox_hrs_en);
		
		 comboBox_min_st = new JComboBox();
		 comboBox_min_st.setFont(new Font("Tahoma", Font.PLAIN, 13));
		 comboBox_min_st.setModel(new DefaultComboBoxModel(new String[] {"Min", "00", "30"}));
		comboBox_min_st.setBounds(921, 150, 46, 22);
		panel.add(comboBox_min_st);
		
		 comboBox_min_en = new JComboBox();
		 comboBox_min_en.setFont(new Font("Tahoma", Font.PLAIN, 13));
		 comboBox_min_en.setModel(new DefaultComboBoxModel(new String[] {"Min", "00", "30"}));
		comboBox_min_en.setBounds(931, 272, 46, 22);
		panel.add(comboBox_min_en);
		
		JLabel lblNewLabel_4 = new JLabel("ADD Location");
		lblNewLabel_4.setFont(new Font("DialogInput", Font.BOLD, 40));
		lblNewLabel_4.setBounds(294, 43, 456, 64);
		panel.add(lblNewLabel_4);
		
		 btn_update = new JButton("UPDATE");
		 btn_update.addActionListener(this);
		btn_update.setBounds(651, 655, 89, 23);
		panel.add(btn_update);
		
		 btn_delete = new JButton("DELETE");
		 btn_delete.addActionListener(this);
		btn_delete.setBounds(933, 655, 89, 23);
		panel.add(btn_delete);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(117, 348, 974, 214);
		panel.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(this);
		scrollPane.setViewportView(table);
		
		
		
	
		 
		
		 btn____Home = new JButton("");
		 btn____Home.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent arg0) {
		 		MainPanel_Home obj = new MainPanel_Home();
				obj.main(null);
			
		 	}
		 });
		 btn____Home.setIcon(new ImageIcon("F:\\_____SLIIT_____\\3_RD_YEAR\\IT3040______ITPM_____\\ITPMFinalWorkSpace\\TimeTable_Management_System\\TimeTableManagementSystem\\image\\Home-icon (1).png"));
		 btn____Home.setBounds(0, 0, 89, 80);
		 panel.add(btn____Home);
		

		

	
	
		
		fillComboBoxRoom();
		
		refreshTableUpdate();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// 
		
		if( e.getSource() == table ) {
			int row = table.getSelectedRow();
			lID = Integer.parseInt((table.getValueAt(row, 0)).toString());					
		
			editLocation edLoc = this.db.searcheitLoceById(lID);	
										
			String Stime = edLoc.getStratTime();
			String Etime = edLoc.getEndTime();
			
			String sHour = Character.toString(Stime.charAt(0));			
			String sMin = Character.toString(Stime.charAt(2)) + Character.toString(Stime.charAt(3));
			
			String eHour = Character.toString(Etime.charAt(0));			
			String eMin = Character.toString(Etime.charAt(2)) + Character.toString(Stime.charAt(3));
			
			comboBoxRoom.setSelectedItem(edLoc.getRoom());
			comboBox_day.setSelectedItem(edLoc.getDay());
			comboBox_hrs_St.setSelectedItem(sHour);
			comboBox_min_st.setSelectedItem(sMin);
			comboBox_hrs_en.setSelectedItem(eHour);
			comboBox_min_en.setSelectedItem(eMin);
		
			
		}	
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// 
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// 
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// 
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// 
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// 
		
			if(e.getSource() == btnAddSe) {
						
				String Room = (String) comboBoxRoom.getSelectedItem();
				String Day = (String) comboBox_day.getSelectedItem();
				String startHrs = (String) comboBox_hrs_St.getSelectedItem()+":"+ (String) comboBox_min_st.getSelectedItem();
				String EndHrs = (String) comboBox_hrs_en.getSelectedItem()+":"+ (String) comboBox_min_en.getSelectedItem();
				
				
				if(Room.equals("ID")) {
					JOptionPane.showMessageDialog(this, "Please Select ID", "Insert Error", JOptionPane.WARNING_MESSAGE);
					return;
				}
				if(Day.equals("Day")) {
					JOptionPane.showMessageDialog(this, "Please Select Day", "Insert Error", JOptionPane.WARNING_MESSAGE);
					return;
				}

			
				if(startHrs.equals("Hrs")) {
					JOptionPane.showMessageDialog(this, "Please Enter Time", "Insert Error", JOptionPane.WARNING_MESSAGE);
					return;
				}
				
				if(EndHrs.equals("Min")) {
					JOptionPane.showMessageDialog(this, "Please Enter Time", "Insert Error", JOptionPane.WARNING_MESSAGE);
					return;
				}
				
				inserteditLocation( Room, Day, startHrs, EndHrs);
				refreshComboBox();
				refreshTableUpdate();
				
				
				
				
					}
			
			if(e.getSource() == btn_delete) {
				
				try {
					System.out.println(lID);
					this.editLoc.deleteNoteditLocation(lID);
					
					this.showPlainMessageDialog("Delete Successfuly", "Insert");
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(this, "Please Select your data to delete", "Insert Error", JOptionPane.WARNING_MESSAGE);
				}
				this.refreshTableUpdate();

				
				
			}
			
			if(e.getSource() == btn_update) {
				
				String Room = (String) comboBoxRoom.getSelectedItem();
				String Day = (String) comboBox_day.getSelectedItem();
				String startTime = (String) comboBox_hrs_St.getSelectedItem() + ":" + (String) comboBox_min_st.getSelectedItem();
				String EndTime = (String) comboBox_hrs_en.getSelectedItem()+":"+ (String) comboBox_min_en.getSelectedItem();
				
				
			
				
				if(Room.equals("ID")) {
					JOptionPane.showMessageDialog(this, "Please Select ID", "Insert Error", JOptionPane.WARNING_MESSAGE);
					return;
				}
				if(Day.equals("Day")) {
					JOptionPane.showMessageDialog(this, "Please Select Day", "Insert Error", JOptionPane.WARNING_MESSAGE);
					return;
				}

			
				if(comboBox_hrs_St.getSelectedItem().equals("Hrs")) {
					JOptionPane.showMessageDialog(this, "Please Enter Time", "Insert Error", JOptionPane.WARNING_MESSAGE);
					return;
				}
				
				if(comboBox_hrs_en.getSelectedItem().equals("Min")) {
					JOptionPane.showMessageDialog(this, "Please Enter Time", "Insert Error", JOptionPane.WARNING_MESSAGE);
					return;
				}
				
				upateditLocation(Room, Day, startTime, EndTime);
				refreshComboBox();
				this.refreshTableUpdate();
				
			}
			
			if(e.getSource() == btnAddClear) {
				
				refreshComboBox();
			}
		
	}	
	
		
	private void upateditLocation(String room, String day, String startHrs, String endHrs) {
		// 
		
		
		int confirm;
		String changeMsg;
		editLocation edtLoc = null;
		
		try {
			
		}catch(Exception e) {
			
			
		}
		edtLoc = this.db.searcheitLoceById(lID);
		changeMsg = "Are you sure you want to update below fields of the Edit Location ID :" + lID + "\n\n";
		
		if( !( edtLoc.getRoom().equals(room) ) ) {			
			changeMsg += "Room ID : " + room;
			edtLoc.setRoom(room);
		}
		if( !( edtLoc.getDay().equals(day) ) ) {			
			changeMsg += "\nDay : " + day;
			edtLoc.setDay(day);
		}
		if( !( edtLoc.getStratTime().equals(startHrs) ) ) {			
			changeMsg += "\nStart Time : " + startHrs;
			edtLoc.setStratTime(startHrs);
		}
		if( !( edtLoc.getEndTime().equals(endHrs) ) ) {			
			changeMsg += "\nEnd Time : " + endHrs;
			edtLoc.setEndTime(endHrs);
		}
	
		
		confirm = showConfirmMessageDialog(changeMsg, "Confirm Required");
		
		
		if( confirm == 0 ) {			
			try {				
				this.editLoc.updateeditLocation(edtLoc);
				showPlainMessageDialog("Successfuly Updated", "Update");
			}catch(Exception e) {
				System.err.println("Exception :" +e.getMessage());
				System.out.println("!!!!!!");
				
			}
		}
		
	}



	public void refreshTableUpdate() {
		
		rs = this.db.refresheditLoc();
		this.table.setModel(DbUtils.resultSetToTableModel(rs));
		
		}

	
		public void refreshComboBox() {
			
			comboBoxRoom.setSelectedItem("ID");			
			comboBox_day.setSelectedItem("Day");
			comboBox_hrs_St.setSelectedItem("Hrs");
			comboBox_min_st.setSelectedItem("Min");
			comboBox_hrs_en.setSelectedItem("Hrs");
			comboBox_min_en.setSelectedItem("Min");
		}
		
	public void showWarningMessageDialog(String message, String title) {
		JOptionPane.showMessageDialog(getParent(), message, title, JOptionPane.WARNING_MESSAGE);
	}
	
	public void showPlainMessageDialog(String message, String title) {
		JOptionPane.showMessageDialog(getParent(), message, title, JOptionPane.PLAIN_MESSAGE);
	}
	
	public int showConfirmMessageDialog(String message, String title) {
		return JOptionPane.showConfirmDialog(getParent(), message, title, JOptionPane.YES_NO_OPTION);
	}
	
	public void showMessageDialog(String message) {
		JOptionPane.showMessageDialog(getParent(), message);
	}
	
	public void inserteditLocation(String Room,String Day,String startHrs,String EndHrs) {
		
		
		try {
				int loc_ID=0;
				
			editLocation n  = new editLocation(loc_ID, Room, Day, startHrs, EndHrs);
				System.out.println("created");
				editLoc.inserteditLocation(n);	
				this.showPlainMessageDialog("Successfuly Inserted", "Insert");
				
			
		} catch (SQLException e) {	
			System.out.println("db search error");
			System.err.println("Exception :" +e.getMessage());
		}
		
		
	}
	
		public  void fillComboBoxRoom() {
			
			
			try {
				rs = db.getRoom();
				while(rs.next()) {
					comboBoxRoom.addItem(rs.getString("RoomName"));
				}
			} catch (SQLException e) {
				// 
				System.out.println("The employee names data not retrive ");
				e.printStackTrace();
			}
		
	}
}
