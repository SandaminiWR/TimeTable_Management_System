package com.FrontEnd;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.border.EmptyBorder;

import com.dao.NotAvailableDao;
import com.models.Lecture;
import com.models.NotAvailable;
import com.models.Session;
import com.util.DBUtill;

import net.proteanit.sql.DbUtils;

import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLayeredPane;
import java.awt.CardLayout;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

public class AddNotAvalable extends JFrame implements ActionListener, MouseListener {

	private NotAvailableDao ntAvail;
	private NotAvailable notAvailable;
	private Lecture lecture;
	private Session session;
	private DBUtill db;
	private static ResultSet rs  = null;
	
	private JPanel panel_allocation;
	private JPanel panel_manage;
	private JPanel contentPane;
	private JLayeredPane layeredPane;
	private JTable table;
	
	private JComboBox comboLec;
	private JComboBox comboGroup;
	private JComboBox comboSub;
	private JComboBox comboSID;
	private JComboBox comboBox_Hrs;
	private JComboBox comboBox_Min;
	
	private JButton btnSub;
	private JButton btnClear;
	private JButton btn_view;
	private JButton BTN_REFRESH_UP;
	private JButton btn_Delete_UP;
	private JButton btn_bck_UP;
	
	private int ID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddNotAvalable frame = new AddNotAvalable();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void switchPanels(JPanel panel) {
		
		
		
		//frame.setVisible(true);
		layeredPane.removeAll();		
		layeredPane.add(panel);
		layeredPane.repaint();
		layeredPane.revalidate();
		
	}
	
	/**
	 * Create the frame.
	 */
	public AddNotAvalable() {
		setTitle("Session and Not Available Times Allocation");
		
		this.ntAvail = new NotAvailableDao();
		this.notAvailable = new NotAvailable();
		this.lecture = new Lecture();
		this.session = new Session();
		this.db = new DBUtill();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1366, 768);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		 
		 JButton btn_home = new JButton("");
		 btn_home.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent arg0) {
		 	}
		 });
		 btn_home.addMouseListener(new MouseAdapter() {
		 	@Override
		 	public void mouseClicked(MouseEvent e) {
		 		MainPanel_Home obj = new MainPanel_Home();
				obj.main(null);
		 	}
		 });
		 btn_home.setBackground(new Color(0,0,0,0));
		 btn_home.setIcon(new ImageIcon("F:\\_____SLIIT_____\\3_RD_YEAR\\IT3040______ITPM_____\\ITPMFinalWorkSpace\\TimeTable_Management_System\\TimeTableManagementSystem\\image\\Home-icon (1).png"));
		 btn_home.setBounds(0, 0, 88, 80);
		 contentPane.add(btn_home);
		
		 layeredPane = new JLayeredPane();
		layeredPane.setBounds(22, 62, 1245, 640);
		contentPane.add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		panel_allocation = new JPanel();
		layeredPane.add(panel_allocation, "name_352852002985400");
		panel_allocation.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Select Lecture");
		lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblNewLabel.setBounds(141, 164, 170, 30);
		panel_allocation.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Select Group");
		lblNewLabel_1.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(707, 164, 120, 30);
		panel_allocation.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Select Sub Group");
		lblNewLabel_2.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(141, 290, 170, 30);
		panel_allocation.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Select Session ID");
		lblNewLabel_3.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(707, 290, 180, 30);
		panel_allocation.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Time");
		lblNewLabel_4.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(141, 450, 79, 20);
		panel_allocation.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Hours");
		lblNewLabel_5.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblNewLabel_5.setBounds(374, 443, 70, 35);
		panel_allocation.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Minutes");
		lblNewLabel_6.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblNewLabel_6.setBounds(545, 445, 121, 30);
		panel_allocation.add(lblNewLabel_6);
		
		 comboLec = new JComboBox();
		 comboLec.setModel(new DefaultComboBoxModel(new String[] {"Select a Lecture"}));
		comboLec.setFont(new Font("Dialog", Font.PLAIN, 14));
		comboLec.setBounds(422, 174, 203, 30);
		panel_allocation.add(comboLec);
		
		 comboGroup = new JComboBox();
		 comboGroup.setModel(new DefaultComboBoxModel(new String[] {"Select a Group"}));
		comboGroup.setFont(new Font("Dialog", Font.PLAIN, 14));
		comboGroup.setBounds(937, 164, 161, 30);
		panel_allocation.add(comboGroup);
		
		 comboSub = new JComboBox();
		 comboSub.setModel(new DefaultComboBoxModel(new String[] {"Select a Sub Group"}));
		comboSub.setFont(new Font("Dialog", Font.PLAIN, 14));
		comboSub.setBounds(422, 290, 194, 30);
		panel_allocation.add(comboSub);
		
		 comboSID = new JComboBox();
		 comboSID.setModel(new DefaultComboBoxModel(new String[] {"Select a ID"}));
		comboSID.setFont(new Font("Dialog", Font.PLAIN, 14));
		comboSID.setBounds(937, 290, 161, 30);
		panel_allocation.add(comboSID);
		
		 btnSub = new JButton("SUBMIT");
		 btnSub.addActionListener(this);
		btnSub.setBounds(528, 568, 120, 30);
		panel_allocation.add(btnSub);
		
		 btnClear = new JButton("CLEAR");
		 btnClear.addActionListener(this);
		btnClear.setBounds(910, 570, 96, 26);
		panel_allocation.add(btnClear);
		
		JLabel lblNewLabel_7 = new JLabel("Lectures , Groups & Sub Groups");
		lblNewLabel_7.setFont(new Font("DialogInput", Font.BOLD, 40));
		lblNewLabel_7.setBounds(339, 11, 759, 95);
		panel_allocation.add(lblNewLabel_7);
		
		 comboBox_Hrs = new JComboBox();
		 comboBox_Hrs.setModel(new DefaultComboBoxModel(new String[] {"Time", "1 ", "2"}));
		comboBox_Hrs.setBounds(299, 453, 70, 22);
		panel_allocation.add(comboBox_Hrs);
		
		 comboBox_Min = new JComboBox();
		 comboBox_Min.setModel(new DefaultComboBoxModel(new String[] {"Time", "00", "30"}));
		comboBox_Min.setBounds(472, 453, 63, 22);
		panel_allocation.add(comboBox_Min);
		
		 btn_view = new JButton("VIEW");
		 btn_view.addActionListener(this);
		btn_view.setBounds(733, 572, 89, 23);
		panel_allocation.add(btn_view);
		
		panel_manage = new JPanel();
		layeredPane.add(panel_manage, "name_357591971268900");
		panel_manage.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(44, 31, 1132, 334);
		panel_manage.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(this);
		scrollPane.setViewportView(table);
		
		 BTN_REFRESH_UP = new JButton("REFRESH");
		 BTN_REFRESH_UP.addActionListener(this);
		BTN_REFRESH_UP.setBounds(176, 487, 89, 23);
		panel_manage.add(BTN_REFRESH_UP);
		
		 btn_Delete_UP = new JButton("DELETE");
		 btn_Delete_UP.addActionListener(this);
		btn_Delete_UP.setBounds(406, 487, 89, 23);
		panel_manage.add(btn_Delete_UP);
		
		 btn_bck_UP = new JButton("BACK");
		 btn_bck_UP.addActionListener(this);
		btn_bck_UP.setBounds(650, 487, 89, 23);
		panel_manage.add(btn_bck_UP);
		
		
		fillComboBoxLecture();
		fillComboBoxGroups();
		fillComboBoxSessionID();
		
		
		this.refreshTableUpdate();
		
	}
	

	public  void fillComboBoxLecture() {
		
		
		try {
			rs = db.getLectureNames();
			while(rs.next()) {
				comboLec.addItem(rs.getString("Full_Name"));
			}
		} catch (SQLException e) {
			// 
			System.out.println("The employee names data not retrive ");
			e.printStackTrace();
		}
		
	}
	
	public  void fillComboBoxGroups() {
		
		
		try {
			rs = db.getStudentGroups();
			while(rs.next()) {
				comboGroup.addItem(rs.getString("Group_ID"));
				comboSub.addItem(rs.getString("Sub_Group_Id"));
			}
		} catch (SQLException e) {
			// 
			System.out.println("The employee names data not retrive ");
			e.printStackTrace();
		}
		
	}
	
	public  void fillComboBoxSessionID() {
		
		
		try {
			rs = db.getSessionID();
			while(rs.next()) {
				comboSID.addItem(rs.getString("ID"));
				
			}
		} catch (SQLException e) {
			// 
			System.out.println("The employee names data not retrive ");
			e.printStackTrace();
		}
		
	}
	
	
	
	public void refreshTableUpdate() {
		
		rs = this.db.refreshNotAvailableTable();
		this.table.setModel(DbUtils.resultSetToTableModel(rs));
		
		}


	@Override
	public void mouseClicked(MouseEvent e) {
		// 
		
		
		if( e.getSource() == table ) {
			int row = table.getSelectedRow();
			ID = Integer.parseInt((table.getValueAt(row, 0)).toString());					
		
			//NotAvailable notAvai = this.db.searchNotAvailById(ID);
			
			
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
		
		if(e.getSource() == btnSub) {
			
			String Lecture = (String) comboLec.getSelectedItem();
			String Maingroup = (String) comboGroup.getSelectedItem();
			String Subgroup = (String) comboSID.getSelectedItem();
			String SessssionID = (String) comboSID.getSelectedItem();
			String timesHrs = (String) comboBox_Hrs.getSelectedItem()+":"+(String) comboBox_Min.getSelectedItem();
		

			if(Lecture.equals("Select a Lecture")) {
				JOptionPane.showMessageDialog(this, "Please Select Lecture", "Insert Error", JOptionPane.WARNING_MESSAGE);
				return;
			}
			if(Maingroup.equals("Select a Group")) {
				JOptionPane.showMessageDialog(this, "Please Select Group", "Insert Error", JOptionPane.WARNING_MESSAGE);
				return;
			}

			if(Subgroup.equals("Select a Sub Group")) {
				JOptionPane.showMessageDialog(this, "Please Select a Sub Group", "Insert Error", JOptionPane.WARNING_MESSAGE);
				return;
			}

			if(SessssionID.equals("Select a ID")) {
				JOptionPane.showMessageDialog(this, "Please Select ID", "Insert Error", JOptionPane.WARNING_MESSAGE);
				return;
			}

			if(timesHrs.equals("Time")) {
				JOptionPane.showMessageDialog(this, "Please Enter Time", "Insert Error", JOptionPane.WARNING_MESSAGE);
				return;
			}

			
			InsertNotAvailable(Lecture,Maingroup,Subgroup,SessssionID,timesHrs);
			refreshComboBox();
			

			
		}
		
		if(e.getSource() == btn_view) {
			switchPanels(panel_manage);
			refreshTableUpdate();
			
			
		}
		
		if(e.getSource() == btnClear) {
			
			refreshComboBox();
			}
	
		if(e.getSource() == BTN_REFRESH_UP) {
			
			refreshTableUpdate();
			
		}
		if(e.getSource() == btn_Delete_UP) {
			
			
			
			try {
				this.ntAvail.deleteNotAvailable(ID);
				this.showPlainMessageDialog("Delete Successfuly", "Insert");
			} catch (SQLException e1) {
				JOptionPane.showMessageDialog(this, "Please Select your data to delete", "Insert Error", JOptionPane.WARNING_MESSAGE);
			}
			this.refreshTableUpdate();
			
		}
		if(e.getSource() == btn_bck_UP) {
			switchPanels(panel_allocation);
			
		}

	}

	public void refreshComboBox() {
		
		comboLec.setSelectedItem("Select a Lecture");			
		comboGroup.setSelectedItem("Select a Group");
		comboSub.setSelectedItem("Select a Sub Group");
		comboSID.setSelectedItem("select a ID");
		comboBox_Hrs.setSelectedItem("Time");
		comboBox_Min.setSelectedItem("Time");
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
	
	public void InsertNotAvailable(String Lecture,String Maingroup,String Subgroup,String SessssionID,String timesHrs) {
		
		
		try {
				int notAvai_ID=0;
				
			NotAvailable n  = new NotAvailable(notAvai_ID, Lecture, Maingroup, Subgroup, Integer.parseInt(SessssionID), timesHrs);
				System.out.println("created");
				ntAvail.insertNotAvailable(n);	
				this.showPlainMessageDialog("Successfuly Inserted", "Insert");
				
			
		} catch (SQLException e) {	
			System.out.println("db search error");
			System.err.println("Exception :" +e.getMessage());
		}
		
		
		
		
	}
		
}

