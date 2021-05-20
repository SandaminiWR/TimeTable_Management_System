package com.FrontEnd;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.awt.CardLayout;
import javax.swing.border.CompoundBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.StyledEditorKit.BoldAction;

import com.dao.SessionDao;
import com.models.Lecture;
import com.models.Session;
import com.models.Subject;
import com.util.DBUtill;

import net.proteanit.sql.DbUtils;

import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;




public class AddSession extends JFrame implements ActionListener, MouseListener{

	private JPanel contentPane;
	private JPanel panelUpdate;
	private JTextField textField_No_Student_Insert;

	
	
	private JButton btnSave_Insert;
	private JButton btnReset_Insert;
	private JButton btnBack_Insert;
	private JButton btnBack_Update;
	private JButton btnRefresh_Update;
	private JButton btnSwitchAddSession_update;
	
	private JComboBox comboBox_MainGroup_Insert;
	private JComboBox comboBox_Tag_Insert;
	private JComboBox comboBox_sele_lec_Insert;
	private JComboBox comboBox_TimeSlot_Insert;
	private JComboBox comboBox_SubCode_Insert;
	private JComboBox comboBox_Day_Insert_1;
	private JComboBox comboBox_Room_Insert_1;
	private JComboBox comboBox_SubGroup_Insert_1;
	private JComboBox comboBox_Subj_Insert_1;
	private DefaultTableModel tableModel;
	private DefaultTableModel tableModelx;
	
	private SessionDao ses;
	private Session session;
	private Lecture lecture;
	private DBUtill db;
	private static ResultSet rs  = null;
	//private static int sessionID;
	private JTable table_Update;
	private JTable tableLecSelecInsert;
	private JPanel panel_3;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_9;
	private JLabel lblNewLabel_10;
	private JButton btnUpdate_Update;
	private JComboBox comboBox_Tag_Update;
	private JLabel lblNewLabel_11;
	private JLabel lblNewLabel_12;
	private JLabel lblNewLabel_13;
	private JTextField textField_Update;
	private JComboBox comboBox_SubCode_Update;
	private JComboBox comboBox_MainGroup_Update;
	private JComboBox comboBox_sele_lec_Update;
	private JComboBox comboBox_TimeSlot_Update;
	private JButton btnDelete_Update;
	private JLabel lblNewLabel_5_1;
	private JComboBox comboBox_Room_Update;
	private JLabel lblNewLabel_8_2;
	private JComboBox comboBox_Day_Update;
	private JLabel lblNewLabel_5_4;
	private JComboBox comboBox_SubGroup_Update;
	private JLabel lblNewLabel_6_1;
	private JComboBox comboBox_Subj_Update;
	private JTable table_selec_lec_update;
	private int x = 1;
	private int y = 1;
	private int z= 0;
	private JScrollPane scrollPane_2;

	private JLayeredPane layeredPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddSession frame = new AddSession();
					frame.setVisible(true);
				} catch (Exception e) {
					System.out.println("frame error");
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AddSession() {
		setTitle("Add Session");
		
		
		this.ses = new SessionDao();
		this.session = new Session();
		this.lecture = new Lecture();
		this.db = new DBUtill();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1366, 768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		 JButton btn_home = new JButton("");
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
		layeredPane.setBounds(5, 5, 1338, 711);
		contentPane.add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		JPanel panelInsert = new JPanel();
		panelInsert.setLayout(null);
		layeredPane.add(panelInsert, "name_20874509085900");
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBounds(0, 0, 1340, 729);
		panelInsert.add(panel_4);
		
		JPanel panel_3_1 = new JPanel();
		panel_3_1.setLayout(null);
		panel_3_1.setBorder(new CompoundBorder(new TitledBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), "Session Insert", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), new CompoundBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 200, 0), new Color(64, 64, 64), new Color(0, 0, 0), new Color(255, 0, 0)), new MatteBorder(11, 11, 11, 11, (Color) new Color(128, 128, 128)))));
		panel_3_1.setBounds(82, 62, 631, 656);
		panel_4.add(panel_3_1);
		
		JLabel lblNewLabel_1 = new JLabel("Select Lecture(s)");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(57, 60, 141, 32);
		panel_3_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Tag");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(57, 295, 141, 32);
		panel_3_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_5 = new JLabel("Group");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_5.setBounds(57, 203, 141, 32);
		panel_3_1.add(lblNewLabel_5);
		
		btnSave_Insert = new JButton("SAVE");
		btnSave_Insert.addActionListener(this);
		btnSave_Insert.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSave_Insert.setBounds(43, 561, 146, 32);
		panel_3_1.add(btnSave_Insert);
		
		comboBox_Tag_Insert = new JComboBox();
		comboBox_Tag_Insert.setModel(new DefaultComboBoxModel(new String[] {"select a type"}));
		comboBox_Tag_Insert.setBounds(57, 338, 131, 24);
		panel_3_1.add(comboBox_Tag_Insert);
		
		JLabel lblNewLabel_6 = new JLabel("Subject Code");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_6.setBounds(57, 105, 141, 32);
		panel_3_1.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("No.Of Students");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_7.setBounds(57, 391, 142, 32);
		panel_3_1.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Time Slot");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_8.setBounds(300, 434, 131, 32);
		panel_3_1.add(lblNewLabel_8);
		
		
		textField_No_Student_Insert = new JTextField();
		textField_No_Student_Insert.setFont(new Font("Calibri", Font.PLAIN, 12));
		textField_No_Student_Insert.setColumns(10);
		textField_No_Student_Insert.setBounds(300, 398, 257, 24);
		panel_3_1.add(textField_No_Student_Insert);
		
		comboBox_SubCode_Insert = new JComboBox();
		comboBox_SubCode_Insert.setModel(new DefaultComboBoxModel(new String[] {"select a type"}));
		comboBox_SubCode_Insert.setBounds(300, 111, 257, 24);
		panel_3_1.add(comboBox_SubCode_Insert);
		
		comboBox_MainGroup_Insert = new JComboBox();
		comboBox_MainGroup_Insert.setModel(new DefaultComboBoxModel(new String[] {"select a type"}));
		comboBox_MainGroup_Insert.setBounds(57, 246, 131, 24);
		panel_3_1.add(comboBox_MainGroup_Insert);
		
		comboBox_sele_lec_Insert = new JComboBox();
		comboBox_sele_lec_Insert.addActionListener(this);
		comboBox_sele_lec_Insert.addMouseListener(this);
		comboBox_sele_lec_Insert.setModel(new DefaultComboBoxModel(new String[] {"select a type"}));
		comboBox_sele_lec_Insert.setBounds(300, 66, 257, 24);
		panel_3_1.add(comboBox_sele_lec_Insert);
		
		comboBox_TimeSlot_Insert = new JComboBox();
		comboBox_TimeSlot_Insert.setModel(new DefaultComboBoxModel(new String[] {"1", "2"}));
		comboBox_TimeSlot_Insert.setBounds(300, 477, 163, 24);
		panel_3_1.add(comboBox_TimeSlot_Insert);
		
		btnReset_Insert = new JButton("RESET");
		btnReset_Insert.addActionListener(this);
		btnReset_Insert.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnReset_Insert.setBounds(251, 561, 146, 32);
		panel_3_1.add(btnReset_Insert);
		
		btnBack_Insert = new JButton("BACK");
		btnBack_Insert.addActionListener(this);
		btnBack_Insert.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnBack_Insert.setBounds(451, 561, 146, 32);
		panel_3_1.add(btnBack_Insert);
		
		JLabel lblNewLabel_5_2 = new JLabel("Room");
		lblNewLabel_5_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_5_2.setBounds(300, 295, 141, 32);
		panel_3_1.add(lblNewLabel_5_2);
		
		comboBox_Room_Insert_1 = new JComboBox();
		comboBox_Room_Insert_1.setModel(new DefaultComboBoxModel(new String[] {"select a type"}));
		comboBox_Room_Insert_1.setBounds(300, 338, 131, 24);
		panel_3_1.add(comboBox_Room_Insert_1);
		
		JLabel lblNewLabel_8_1 = new JLabel("Day");
		lblNewLabel_8_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_8_1.setBounds(57, 434, 131, 32);
		panel_3_1.add(lblNewLabel_8_1);
		
		comboBox_Day_Insert_1 = new JComboBox();
		comboBox_Day_Insert_1.setModel(new DefaultComboBoxModel(new String[] {"select a Day"}));
		comboBox_Day_Insert_1.setBounds(57, 477, 163, 24);
		panel_3_1.add(comboBox_Day_Insert_1);
		
		JLabel lblNewLabel_5_3 = new JLabel("Sub Group");
		lblNewLabel_5_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_5_3.setBounds(300, 203, 141, 32);
		panel_3_1.add(lblNewLabel_5_3);
		
		comboBox_SubGroup_Insert_1 = new JComboBox();
		comboBox_SubGroup_Insert_1.setModel(new DefaultComboBoxModel(new String[] {"select a type"}));
		comboBox_SubGroup_Insert_1.setBounds(300, 246, 126, 24);
		panel_3_1.add(comboBox_SubGroup_Insert_1);
		
		JLabel lblNewLabel_6_2 = new JLabel("Subject");
		lblNewLabel_6_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_6_2.setBounds(57, 155, 141, 32);
		panel_3_1.add(lblNewLabel_6_2);
		
		comboBox_Subj_Insert_1 = new JComboBox();
		comboBox_Subj_Insert_1.setModel(new DefaultComboBoxModel(new String[] {"select a type"}));
		comboBox_Subj_Insert_1.setBounds(300, 163, 257, 24);
		panel_3_1.add(comboBox_Subj_Insert_1);
		
		JLabel lblNewLabel_4 = new JLabel("Session Insert Form");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_4.setBounds(586, 0, 204, 42);
		panel_4.add(lblNewLabel_4);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				switchPanels(panelUpdate);
			}
		});
		btnNewButton.setBounds(1201, 39, 97, 25);
		panel_4.add(btnNewButton);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(799, 110, 491, 73);
		panel_4.add(scrollPane_1);
		
		
		
		
		
		panelUpdate = new JPanel();
		panelUpdate.setLayout(null);
		layeredPane.add(panelUpdate, "name_20894920200200");
		
		JPanel panel_4_1 = new JPanel();
		panel_4_1.setLayout(null);
		panel_4_1.setBounds(0, 0, 1340, 729);
		panelUpdate.add(panel_4_1);
		
		JLabel lblNewLabel_4_1 = new JLabel("Session Management");
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_4_1.setBounds(653, 0, 204, 42);
		panel_4_1.add(lblNewLabel_4_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(769, 248, 561, 200);
		panel_4_1.add(scrollPane);
		
		table_Update = new JTable();
		//String[] xcolumns = {"ID", "First Lecture", "Second Lecture", "Tag", "Room", "Main Group", "Sub Group", "Subject" , "Subject Code", "No Of Students", "Day", "Time Slot"};		
	   // tableModel = new DefaultTableModel(xcolumns, 0);
		//this.tableLecSelecInsert.setModel(tableModel);
		table_Update.addMouseListener(this);
		scrollPane.setViewportView(table_Update);
		refreshTableUpdate() ;
		
		btnRefresh_Update = new JButton("REFRESH");
		btnRefresh_Update.addActionListener(this);
		btnRefresh_Update.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnRefresh_Update.setBounds(1184, 517, 146, 32);
		panel_4_1.add(btnRefresh_Update);
		
		btnSwitchAddSession_update = new JButton("ADD SESSION");
		btnSwitchAddSession_update.addActionListener(this);
		btnSwitchAddSession_update.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSwitchAddSession_update.setBounds(1143, 658, 168, 32);
		panel_4_1.add(btnSwitchAddSession_update);
		
		btnBack_Update = new JButton("BACK");
		btnBack_Update.addActionListener(this);
		btnBack_Update.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnBack_Update.setBackground(Color.GRAY);
		btnBack_Update.setBounds(31, 7, 146, 32);
		panel_4_1.add(btnBack_Update);
		
		panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBorder(new CompoundBorder(new TitledBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), "Session Update", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), new CompoundBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 200, 0), new Color(64, 64, 64), new Color(0, 0, 0), new Color(255, 0, 0)), new MatteBorder(11, 11, 11, 11, (Color) new Color(128, 128, 128)))));
		panel_3.setBounds(31, 70, 672, 622);
		panel_4_1.add(panel_3);
		
		lblNewLabel = new JLabel("Select Lecture(s)");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(57, 60, 141, 32);
		panel_3.add(lblNewLabel);
		
		lblNewLabel_9 = new JLabel("Tag");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_9.setBounds(57, 295, 141, 32);
		panel_3.add(lblNewLabel_9);
		
		lblNewLabel_10 = new JLabel("Group");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_10.setBounds(57, 203, 141, 32);
		panel_3.add(lblNewLabel_10);
		
		btnUpdate_Update = new JButton("UPDATE");
		btnUpdate_Update.addActionListener(this);
		btnUpdate_Update.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnUpdate_Update.setBounds(136, 561, 146, 32);
		panel_3.add(btnUpdate_Update);
		
		comboBox_Tag_Update = new JComboBox();
		comboBox_Tag_Update.setModel(new DefaultComboBoxModel(new String[] {"select a type"}));
		comboBox_Tag_Update.setBounds(57, 338, 131, 24);
		panel_3.add(comboBox_Tag_Update);
		
		lblNewLabel_11 = new JLabel("Subject Code");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_11.setBounds(57, 105, 141, 32);
		panel_3.add(lblNewLabel_11);
		
		lblNewLabel_12 = new JLabel("No.Of Students");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_12.setBounds(57, 391, 142, 32);
		panel_3.add(lblNewLabel_12);
		
		lblNewLabel_13 = new JLabel("Time Slot");
		lblNewLabel_13.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_13.setBounds(300, 434, 131, 32);
		panel_3.add(lblNewLabel_13);
		
		textField_Update = new JTextField();
		textField_Update.setFont(new Font("Calibri", Font.PLAIN, 12));
		textField_Update.setColumns(10);
		textField_Update.setBounds(300, 398, 257, 24);
		panel_3.add(textField_Update);
		
		comboBox_SubCode_Update = new JComboBox();
		comboBox_SubCode_Update.setModel(new DefaultComboBoxModel(new String[] {"select a type"}));
		comboBox_SubCode_Update.setBounds(300, 111, 257, 24);
		panel_3.add(comboBox_SubCode_Update);
		
		comboBox_MainGroup_Update = new JComboBox();
		comboBox_MainGroup_Update.setModel(new DefaultComboBoxModel(new String[] {"select a type"}));
		comboBox_MainGroup_Update.setBounds(57, 246, 131, 24);
		panel_3.add(comboBox_MainGroup_Update);
		
		comboBox_sele_lec_Update = new JComboBox();
		comboBox_sele_lec_Update.addMouseListener(this);
		comboBox_sele_lec_Update.setModel(new DefaultComboBoxModel(new String[] {"select a type"}));
		comboBox_sele_lec_Update.addActionListener(this);
		comboBox_sele_lec_Update.setBounds(300, 66, 257, 24);
		panel_3.add(comboBox_sele_lec_Update);
		
		comboBox_TimeSlot_Update = new JComboBox();
		comboBox_TimeSlot_Update.setModel(new DefaultComboBoxModel(new String[] {"select a type", "1", "2"}));
		comboBox_TimeSlot_Update.setBounds(300, 477, 163, 24);
		panel_3.add(comboBox_TimeSlot_Update);
		
		btnDelete_Update = new JButton("DELETE");
		btnDelete_Update.addActionListener(this);
		btnDelete_Update.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnDelete_Update.setBounds(421, 561, 146, 32);
		panel_3.add(btnDelete_Update);
		
		lblNewLabel_5_1 = new JLabel("Room");
		lblNewLabel_5_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_5_1.setBounds(300, 295, 141, 32);
		panel_3.add(lblNewLabel_5_1);
		
		comboBox_Room_Update = new JComboBox();
		comboBox_Room_Update.setModel(new DefaultComboBoxModel(new String[] {"select a type"}));
		comboBox_Room_Update.setBounds(300, 338, 131, 24);
		panel_3.add(comboBox_Room_Update);
		
		lblNewLabel_8_2 = new JLabel("Day");
		lblNewLabel_8_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_8_2.setBounds(57, 434, 131, 32);
		panel_3.add(lblNewLabel_8_2);
		
		comboBox_Day_Update = new JComboBox();
		comboBox_Day_Update.setModel(new DefaultComboBoxModel(new String[] {"select a type"}));
		comboBox_Day_Update.setBounds(57, 477, 163, 24);
		panel_3.add(comboBox_Day_Update);
		
		lblNewLabel_5_4 = new JLabel("Sub Group");
		lblNewLabel_5_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_5_4.setBounds(300, 203, 141, 32);
		panel_3.add(lblNewLabel_5_4);
		
		comboBox_SubGroup_Update = new JComboBox();
		comboBox_SubGroup_Update.setModel(new DefaultComboBoxModel(new String[] {"select a type"}));
		comboBox_SubGroup_Update.setBounds(300, 246, 126, 24);
		panel_3.add(comboBox_SubGroup_Update);
		
		lblNewLabel_6_1 = new JLabel("Subject");
		lblNewLabel_6_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_6_1.setBounds(57, 155, 141, 32);
		panel_3.add(lblNewLabel_6_1);
		
		comboBox_Subj_Update = new JComboBox();
		comboBox_Subj_Update.setModel(new DefaultComboBoxModel(new String[] {"select a type"}));
		comboBox_Subj_Update.setBounds(300, 163, 257, 24);
		panel_3.add(comboBox_Subj_Update);
		
		scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(769, 121, 537, 80);
		panel_4_1.add(scrollPane_2);
		
		
		tableLecSelecInsert = new JTable();
		String[] columns = {"ID", "Name"};		
	    tableModel = new DefaultTableModel(columns, 0);
		this.tableLecSelecInsert.setModel(tableModel);	
		scrollPane_1.setViewportView(tableLecSelecInsert);
		
		table_selec_lec_update = new JTable();
		String[] columnx = {"ID", "Name"};		
	    tableModelx = new DefaultTableModel(columnx, 0);
		this.table_selec_lec_update.setModel(tableModelx);	
		scrollPane_2.setViewportView(table_selec_lec_update);
		
		fillComboBoxLectureUpdate();
		fillComboBoxGroupsUpdate();
	    fillComboBoxTagsUpdate();
	    fillComboBoxRoomUpdate();
		fillComboBoxSubjectUpdate();
		
		fillComboBoxLecture();
		fillComboBoxGroups();
	    fillComboBoxTags();
	    fillComboBoxRoom();
		fillComboBoxSubject();
	}
	
	
	

	public void switchPanels(JPanel panel) {
		
		
		refreshTableUpdate();
		
		//frame.setVisible(true);
		layeredPane.removeAll();		
		layeredPane.add(panel);
		layeredPane.repaint();
		layeredPane.revalidate();
		
		
		
	}
	
	public void refreshTableUpdate() {
		
		
		rs = this.db.refreshSessionTable();
		this.table_Update.setModel(DbUtils.resultSetToTableModel(rs));
		
		textField_No_Student_Insert.setText(null);
		
	}
	
	
	
	public  void fillComboBoxLecture() {
		
	
		try {
			rs = db.getLectureNames();
			while(rs.next()) {
				comboBox_sele_lec_Insert.addItem(rs.getString("Full_Name"));
				
				
			}
		} catch (SQLException e) {
			// 
			System.out.println("The employee names data not retrive ");
			e.printStackTrace();
		}
		
	}
	
	public  void fillComboBoxTags() {
		
		
		try {
			rs = db.getTags();
			while(rs.next()) {
				comboBox_Tag_Insert.addItem(rs.getString("Related_Tags"));
			
			}
		} catch (SQLException e) {
			// 
			System.out.println("The employee names data not retrive ");
			e.printStackTrace();
		}
		
	}
	
	public  void fillComboBoxRoom() {
		
		
		try {
			rs = db.getRoom();
			while(rs.next()) {
				comboBox_Room_Insert_1.addItem(rs.getString("RoomName"));
			
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
				comboBox_MainGroup_Insert.addItem(rs.getString("Group_ID"));
				comboBox_SubGroup_Insert_1.addItem(rs.getString("Sub_Group_Id"));
			
			}
		} catch (SQLException e) {
			// 
			System.out.println("The employee names data not retrive ");
			e.printStackTrace();
		}
		
	}
	
	public  void fillComboBoxSubject() {
		
		
		try {
			rs = db.getSubject();
			while(rs.next()) {
				comboBox_SubCode_Insert.addItem(rs.getString("Subject_Code"));
				comboBox_Subj_Insert_1.addItem(rs.getString("Subject_Name"));
				
				
			}
		} catch (SQLException e) {
			// 
			System.out.println("The Subject names data not retrive ");
			e.printStackTrace();
		}
		
	}
	
	
	//////////////////////////////////////////////////////////////////////////////////////
	
	public  void fillComboBoxLectureUpdate() {
		
		
		try {
			rs = db.getLectureNames();
			while(rs.next()) {
				
				comboBox_sele_lec_Update.addItem(rs.getString("Full_Name"));
				
			}
		} catch (SQLException e) {
			// 
			System.out.println("The employee names data not retrive ");
			e.printStackTrace();
		}
		
	}
	
	public  void fillComboBoxTagsUpdate() {
		
		
		try {
			rs = db.getTags();
			while(rs.next()) {
				
				comboBox_Tag_Update.addItem(rs.getString("Related_Tags"));
			}
		} catch (SQLException e) {
			// 
			System.out.println("The employee names data not retrive ");
			e.printStackTrace();
		}
		
	}
	
	public  void fillComboBoxRoomUpdate() {
		
		
		try {
			rs = db.getRoom();
			while(rs.next()) {
				
				comboBox_Room_Update.addItem(rs.getString("RoomName"));
			}
		} catch (SQLException e) {
			// 
			System.out.println("The employee names data not retrive ");
			e.printStackTrace();
		}
		
	}
	
	public  void fillComboBoxGroupsUpdate() {
		
		
		try {
			rs = db.getStudentGroups();
			while(rs.next()) {
				
				comboBox_MainGroup_Update.addItem(rs.getString("Group_ID"));
				comboBox_SubGroup_Update.addItem(rs.getString("Sub_Group_Id"));
			}
		} catch (SQLException e) {
			// 
			System.out.println("The employee names data not retrive ");
			e.printStackTrace();
		}
		
	}
	
	public  void fillComboBoxSubjectUpdate() {
		
		
		try {
			rs = db.getSubject();
			while(rs.next()) {
			
				comboBox_SubCode_Update.addItem(rs.getString("Subject_Code"));
				comboBox_Subj_Update.addItem(rs.getString("Subject_Name"));
				
			}
		} catch (SQLException e) {
			// 
			System.out.println("The Subject names data not retrive ");
			e.printStackTrace();
		}
		
	}
	
	
	
	
	public void refreshtableLecSelecInsert() {	
	
		String[] columns = {"ID", "Name"};		
	    tableModel = new DefaultTableModel(columns, 0);
		this.tableLecSelecInsert.setModel(tableModel);

		x=1;
		
	}
	
	public void refreshtableLecSelecUpdate() {	
		
		String[] ecolumns = {"ID", "Name"};		
	    tableModelx = new DefaultTableModel(ecolumns, 0);
		this.table_selec_lec_update.setModel(tableModelx);

		y=1;
		
	}
	
	


	public void actionPerformed(ActionEvent e) {
		
		
		if( e.getSource() == btnSave_Insert ) {
		
			String lec1="";
			String lec2 ="";
			String Tag = (String) comboBox_Tag_Insert.getSelectedItem();
			String Room = (String) comboBox_Room_Insert_1.getSelectedItem();
			String Maingroup = (String) comboBox_MainGroup_Insert.getSelectedItem();
			String Subgroup = (String) comboBox_SubGroup_Insert_1.getSelectedItem();
			String subjectCode = (String) comboBox_SubCode_Insert.getSelectedItem();
			String subject = (String) comboBox_Subj_Insert_1.getSelectedItem();
			String noOfStudent = textField_No_Student_Insert.getText();
			String timeslot = (String) comboBox_TimeSlot_Insert.getSelectedItem();
			String Day = (String) comboBox_Day_Insert_1.getSelectedItem();
			
			try {
			
				Subject sub = db.searchSubjectByCode(subjectCode);
				if(!subject.equals(sub.getSubName())) {
					JOptionPane.showMessageDialog(this, "Subject Code and Subject Name is not match", "Insert Error", JOptionPane.WARNING_MESSAGE);
					return;
				}
				if(noOfStudent.equals("")) {
					JOptionPane.showMessageDialog(this, "Please Enter No Of Student", "Insert Error", JOptionPane.WARNING_MESSAGE);
					return;
				}
			}
			catch(Exception ea) {
				
			}
			
			
			try {
				lec1 = tableLecSelecInsert.getValueAt(0, 1).toString();				
				lec2 = tableLecSelecInsert.getValueAt(1, 1).toString();
			}
			catch(Exception ea) {
				//ea.printStackTrace();
			}
		
			
			int noStudent;
			
			try {
				noStudent = Integer.parseInt(noOfStudent);	
			
			}catch(Exception ex) {
				JOptionPane.showMessageDialog(this, "Inputs are not valid", "Insert Error", JOptionPane.WARNING_MESSAGE);
				return;
			}
				System.out.println(lec2);
			  
			if(lec2.equals("")) {
				insertSession( lec1, subject,subjectCode, Tag, Room, Maingroup, Subgroup, Day, timeslot, noStudent);
			}else {
				
				insertSession( lec1, lec2, subject, subjectCode, Tag, Room, Maingroup, Subgroup, Day, timeslot, noStudent);
			}
			
			x=0;
			refreshComboBox();
			refreshtableLecSelecInsert();
			textField_No_Student_Insert.setText(null);
				
    	}
		
		if( e.getSource() == btnReset_Insert ) {
			
			refreshComboBox();			
			textField_No_Student_Insert.setText(null);
						
		}
		
		
		if( e.getSource() == btnBack_Insert ) {
			
			
		}
		
		/*
		 * 
		 * 
		 * Update methods
		 * 
		 * 
		 * 
		 * 
		 */
		
		
		if( e.getSource() == btnDelete_Update ) {
			
			int id ;
			try {
				 id = session.getSession_ID();
				 System.out.println(id);
				 DeleteSession(id);
				 
			}
			catch(Exception eq) {
				JOptionPane.showMessageDialog(this, "Please select data to Delete", "Delete  Error", JOptionPane.WARNING_MESSAGE);
				return;
			}
			
			
		}
		
		if( e.getSource() == btnUpdate_Update ) {
			
			String lec1="";
			String lec2 ="";
			String Tag = (String) comboBox_Tag_Update.getSelectedItem();
			String Room = (String) comboBox_Room_Update.getSelectedItem();
			String Maingroup = (String) comboBox_MainGroup_Update.getSelectedItem();
			String Subgroup = (String) comboBox_SubGroup_Update.getSelectedItem();
			String subjectCode = (String) comboBox_SubCode_Update.getSelectedItem();
			String subject = (String) comboBox_Subj_Update.getSelectedItem();
			String noOfStudent = textField_Update.getText();
			String timeslot = (String) comboBox_TimeSlot_Update.getSelectedItem();
			String Day = (String) comboBox_Day_Update.getSelectedItem();
			int id;
			
			
			
			try {
				
				Subject sub = db.searchSubjectByCode(subjectCode);
				if(!subject.equals(sub.getSubName())) {
					JOptionPane.showMessageDialog(this, "Subject Code and Subject Name is not match", "Insert Error", JOptionPane.WARNING_MESSAGE);
					return;
				}
				if(noOfStudent.equals("")) {
					JOptionPane.showMessageDialog(this, "Please Enter No Of Student", "Insert Error", JOptionPane.WARNING_MESSAGE);
					return;
				}
			}
			catch(Exception ea) {
				
			}
			
			
			try {
				lec1 = table_selec_lec_update.getValueAt(0, 1).toString();				
				lec2 = table_selec_lec_update.getValueAt(1, 1).toString();
			}
			catch(Exception ea) {
				//ea.printStackTrace();
			}
		
			
			
		
			try {
				 id = session.getSession_ID();
				 System.out.println(id);
			}catch(Exception ex) {
				JOptionPane.showMessageDialog(this, "Please select data to Update", "Update Error", JOptionPane.WARNING_MESSAGE);
				return;
			}
			int noStudent;
		
			try {
				noStudent = Integer.parseInt(noOfStudent);	
			
			}catch(Exception ex) {
				JOptionPane.showMessageDialog(this, "Inputs are not valid", "Update Error", JOptionPane.WARNING_MESSAGE);
				return;
			}
			
			if(lec2.equals("")) {
				updateSession( id,  lec1,  subject,  subjectCode,  Tag,  Room,  Maingroup,  Subgroup,  Day, timeslot,noStudent);
			}else {
				
				updateSession( id,  lec1, lec2, subject,  subjectCode,  Tag,  Room,  Maingroup,  Subgroup,  Day, timeslot, noStudent);
			}
			y=0;
			refreshTableUpdate();
			refreshComboBoxUpdate();
			//textField_selected_lec_insert.setText(null);
			textField_Update.setText(null);
			refreshtableLecSelecUpdate();
		
			
		}
		
		if( e.getSource() == btnRefresh_Update ) {
			
			
		}
		
		if( e.getSource() == btnBack_Update ) {
			
			
		}

		if( e.getSource() == btnSwitchAddSession_update ) {
			
			
		}
		
		
		if( e.getSource() == btnRefresh_Update ) {
			
			
		}
		
		
		if(e.getSource() == comboBox_sele_lec_Insert ) {
			
			boolean lecFound ;
			int id = 0;
			String Name="";
		
			
			
			if(x<3) {
				String lec = (String) comboBox_sele_lec_Insert.getSelectedItem();
			
				try {
					rs = db.searchByEmpType("Full_Name", lec);
					
					
					while(rs.next()) {
						id = rs.getInt(1);
						 Name = rs.getString(2);
																		
					}
				
					if(x==2) {
						lecFound = lecFoundInsert(id);
						
					
						if(lecFound == true) {
							JOptionPane.showMessageDialog(this, "Lecture Already Selected", "Insert Error", JOptionPane.WARNING_MESSAGE);
						}else {
							tableModel.addRow(new Object[] {id,Name});
							this.tableLecSelecInsert.setModel(tableModel);
							x++;
						}
					}else {
						tableModel.addRow(new Object[] {id,Name});
						this.tableLecSelecInsert.setModel(tableModel);
						x++;
					}
				}
				catch(Exception eb) {
					System.out.println("The employee names data not retrive ");
					eb.printStackTrace();
					
				}
			}
			else {
				JOptionPane.showMessageDialog(this, "Only 2 lectures can be selected", "Insert Error", JOptionPane.WARNING_MESSAGE);
			}
			
									
		}
	
		/*********************************************************
		*****
		*
		*
		*
		*
		*/
		
		
		if(e.getSource() == comboBox_sele_lec_Update ) {
			
			boolean lecFound ;
			int id = 0;
			String Name="";
		
			int confirm;
			String changeMsg;
			
			
			
			if(y<3) {
				String lec = (String) comboBox_sele_lec_Update.getSelectedItem();
			
				try {
					rs = db.searchByEmpType("Full_Name", lec);
					
					
					while(rs.next()) {
						id = rs.getInt(1);
						 Name = rs.getString(2);
																		
					}
				
					if(y==2) {
						lecFound = lecFoundUpdate(id);
						
						System.out.println(lecFound);
						if(lecFound == true) {
							JOptionPane.showMessageDialog(this, "Lecture Already Selected", "Insert Error", JOptionPane.WARNING_MESSAGE);
						}else {
							tableModelx.addRow(new Object[] {id,Name});
							this.table_selec_lec_update.setModel(tableModelx);
							y++;
						}
					}else {
						tableModelx.addRow(new Object[] {id,Name});
						this.table_selec_lec_update.setModel(tableModelx);
						y++;
					}
				}
				catch(Exception eb) {
					System.out.println("The  data not retrive ");
					eb.printStackTrace();
					
				}
			}
			else {
				JOptionPane.showMessageDialog(this, "Only 2 lectures can be selected", "Insert Error", JOptionPane.WARNING_MESSAGE);
			}
			
									
		}
		
		
	
	}
	
	public boolean lecFoundInsert(int id) {
		int lecid=0;
		try {
			lecid = Integer.parseInt(tableLecSelecInsert.getValueAt(0, 0).toString());
			
			
		}catch(Exception e) {
			System.out.println("error");
			e.printStackTrace();
		}
		
		
		if(lecid == id) {
			return true;
		}
		return false;
			
	}
	
	public boolean lecFoundUpdate(int id) {
		int lecid=0;
		try {
			lecid = Integer.parseInt(table_selec_lec_update.getValueAt(0, 0).toString());
			
			
		}catch(Exception e) {
			System.out.println("error");
			e.printStackTrace();
		}
		
		
		if(lecid == id) {
			return true;
		}
		return false;
			
	}
	
	public void refreshComboBox() {
		
		comboBox_sele_lec_Insert.setSelectedItem("select a type");			
		comboBox_MainGroup_Insert.setSelectedItem("select a type");
		comboBox_SubGroup_Insert_1.setSelectedItem("select a type");
		comboBox_SubCode_Insert.setSelectedItem("select a type");
		comboBox_Subj_Insert_1.setSelectedItem("select a type");
		comboBox_Tag_Insert.setSelectedItem("select a type");
		comboBox_TimeSlot_Insert.setSelectedIndex(0);
		
	}
	
	public void refreshComboBoxUpdate() {
		
		comboBox_sele_lec_Update.setSelectedItem("select a type");			
		comboBox_MainGroup_Update.setSelectedItem("select a type");
		comboBox_SubGroup_Update.setSelectedItem("select a type");
		comboBox_SubCode_Update.setSelectedItem("select a type");
		comboBox_Subj_Update.setSelectedItem("select a type");
		comboBox_Tag_Update.setSelectedItem("select a type");
		comboBox_TimeSlot_Update.setSelectedIndex(0);
		
	}
	
	
	public void insertSession( String lec1, String subject, String subjectCode, String Tag, String Room, String Maingroup, String Subgroup, String Day, String timeslot, int noOfStudent) {
		
	
		int id =0;
		
		
		int confirm;
		String changeMsg;
		
		changeMsg = "Session Details" + "\n\n";
		
		changeMsg += lec1;
		changeMsg += "\n" + subject;
		changeMsg += "\n" + Tag;		
		changeMsg += "\n" + Subgroup;
		changeMsg += "\n" + noOfStudent;
	
		
		
		confirm = showConfirmMessageDialog(changeMsg, "Confirm Required");
		
		
		if( confirm == 0 ) {	
			try {
				ses.InsertSession( new Session(id, lec1, Tag, Room, Subgroup, Maingroup, subject,  subjectCode, noOfStudent,  Day, timeslot ));	
				this.showPlainMessageDialog("Successfuly Inserted", "Insert");
				x=0;
				}			
			catch (SQLException e) {	
				System.out.println("db search error");
				System.err.println("Exception :" +e.getMessage());
			}
		}
		
	}
	

	public void insertSession( String lec1, String lec2, String subject, String subjectCode, String Tag, String Room, String Maingroup, String Subgroup, String Day, String timeslot, int noOfStudent) {
		
		
		int id =0;
		int confirm;
		String changeMsg;
		
		changeMsg = "Session Details" + "\n\n";
		
		changeMsg += lec1+"  ";
		changeMsg += lec2;
		changeMsg += "\n" + subject;
		changeMsg += "\n" + Tag;		
		changeMsg += "\n" + Subgroup;
		changeMsg += "\n" + noOfStudent;
	
		
		
		confirm = showConfirmMessageDialog(changeMsg, "Confirm Required");
		
		if( confirm == 0 ) {	
			try {
				ses.insertSession( new Session(id, lec1, lec2, Tag, Room, Subgroup, Maingroup, subject,  subjectCode, noOfStudent,  Day, timeslot ));	
				this.showPlainMessageDialog("Successfuly Inserted", "Insert");
				x=0;
				}			
			catch (SQLException e) {	
				System.out.println("db search error");
				System.err.println("Exception :" +e.getMessage());
			}
		}
		
	}
	
		
	
	
	public void updateSession(int ID, String lec1, String lec2, String subject, String subjectCode, String Tag, String Room, String Maingroup, String Subgroup, String Day, String timeslot, int noOfStudent) {
		
		int confirm;
		String changeMsg;
		Session usession = null;
		usession = this.db.searchSessionById(ID);
		
		changeMsg = "Session Details of Session id :" + ID + "\n\n";
		
		System.out.println(usession.getLecture2());
		
		if( !( usession.getLecture1().equals(lec1) ) ) {			
			changeMsg += lec1+"  ";
			usession.setLecture1(lec1);
		}
		
		try {
			if( !( lec2.equals(usession.getLecture2()) ) ) {			
				changeMsg += lec2;
				usession.setLecture2(lec2);
			}		
		}
		catch(Exception e) {
			
		}
		if( !( usession.getSub().equals(subject) ) ) {			
			changeMsg += "\n" + subject;
			usession.setSub(subject);;
		}
		if( !( usession.getTag().equals(Tag) ) ) {			
			changeMsg += "\n" + Tag;
			usession.setTag(Tag);
		}
		if( !( usession.getMaingroup().equals(Maingroup) ) ) {			
			changeMsg += "\n" + Maingroup;
			usession.setMaingroup(Maingroup);
		}
		if( !( usession.getSubgroup().equals(Subgroup) ) ) {			
			changeMsg += "." + Subgroup;
			usession.setSubgroup(Subgroup);
		}
		if( !( usession.getNoOfStudent() == noOfStudent )) {			
			changeMsg += "\n" + noOfStudent;
			usession.setNoOfStudent(noOfStudent);
		}
		
		
		confirm = showConfirmMessageDialog(changeMsg, "Confirm Required");
		
		if( confirm == 0 ) {			
			try {				
				this.ses.updateSession(usession);
				showPlainMessageDialog("Successfuly Updated", "Update");
				y=0;
			}catch(Exception e) {
				System.err.println("Exception :" +e.getMessage());
				System.out.println("!!!!!!");
				
			}
		}
		
	}
	
	
	public void updateSession(int ID, String lec1, String subject, String subjectCode, String Tag, String Room, String Maingroup, String Subgroup, String Day, String timeslot, int noOfStudent) {
		
		int confirm;
		String changeMsg;
		Session usession = null;
		usession = this.db.searchSessionById(ID);
		
		changeMsg = "Session Details of Session id :" + ID + "\n\n";
		
		
		
		if( !( usession.getLecture1().equals(lec1) ) ) {			
			changeMsg += lec1+"  ";
			usession.setLecture1(lec1);
		}
				
		if( !( usession.getSub().equals(subject) ) ) {			
			changeMsg += "\n" + subject;
			usession.setSub(subject);;
		}
		if( !( usession.getTag().equals(Tag) ) ) {			
			changeMsg += "\n" + Tag;
			usession.setTag(Tag);
		}
		if( !( usession.getMaingroup().equals(Maingroup) ) ) {			
			
			usession.setMaingroup(Maingroup);
		}
		if( !( usession.getSubgroup().equals(Subgroup) ) ) {			
			changeMsg += "." + Subgroup;
			usession.setSubgroup(Subgroup);
		}
		if( !( usession.getNoOfStudent() == noOfStudent )) {			
			changeMsg += "\n" + noOfStudent;
			usession.setNoOfStudent(noOfStudent);
		}
		
		
		confirm = showConfirmMessageDialog(changeMsg, "Confirm Required");
		
		if( confirm == 0 ) {			
			try {				
				this.ses.updateSessionu(usession);
				showPlainMessageDialog("Successfuly Updated", "Update");
				y=0;
			}catch(Exception e) {
				System.err.println("Exception :" +e.getMessage());
				System.out.println("!!!!!!");
				
			}
		}
		
	}
	
	
	public void DeleteSession(int id) {
				
		int confirm;
		
		confirm = showConfirmMessageDialog("Are you sure You want to delete session id : " + id, "Confirm Required");
		
		if( confirm == 0 ) {
			try {
				ses.deleteSession(id);
				showMessageDialog("Successfully Session Deleted");	
				refreshTableUpdate();
			}catch(Exception e) {
				System.err.println("Exception :" +e.getMessage());
				e.printStackTrace();
				System.out.println("!!!!!!");				
			} 
						
		}
		
	}
	
	
	
	public void showWarningMessageDialog(String message, String title) {
		JOptionPane.showMessageDialog(getParent(), message, title, JOptionPane.WARNING_MESSAGE);;
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

	@Override
	public void mouseClicked(MouseEvent e) {
		// 
		
		
		if(e.getSource() == table_Update ) {
			y=1;
			int row = table_Update.getSelectedRow();
			int id = Integer.parseInt((table_Update.getValueAt(row, 0)).toString());					
			int eid = 0;
			String Name;
			session = this.db.searchSessionById(id);	
			z=0;
			comboBox_sele_lec_Update.setSelectedItem(session.getLecture1());
			comboBox_SubCode_Update.setSelectedItem(session.getSubCode());
			comboBox_Subj_Update.setSelectedItem(session.getSub());
			comboBox_MainGroup_Update.setSelectedItem(session.getMaingroup());
			comboBox_SubGroup_Update.setSelectedItem(session.getSubgroup());
			comboBox_Room_Update.setSelectedItem(session.getRoom());
			comboBox_Tag_Update.setSelectedItem(session.getTag());
			
			comboBox_Day_Update.setSelectedItem(session.getDay());
			comboBox_TimeSlot_Update.setSelectedItem(session.getTimeslot());
			
			
			textField_Update.setText(Integer.toString(session.getNoOfStudent()));
			String[] rcolumns = {"ID", "Name"};		
		    tableModelx = new DefaultTableModel(rcolumns, 0);
			this.table_selec_lec_update.setModel(tableModelx);
			
			try {
				rs = db.searchByEmpType("Full_Name", session.getLecture1());
				
				
				while(rs.next()) {
					
					eid = rs.getInt(1);
					Name = rs.getString(2);
					tableModelx.addRow(new Object[] {eid,Name});
				}
				
				
				
				if(!session.getLecture2().equals("null")){
					rs = db.searchByEmpType("Full_Name", session.getLecture2());
					
					
					while(rs.next()) {
						
						eid = rs.getInt(1);
						Name = rs.getString(2);
						tableModelx.addRow(new Object[] {eid,Name});
					}
					
				}
				
								
			}
			catch(Exception eq) {
				
				
			}
			
			this.table_selec_lec_update.setModel(tableModelx);
	
				
				String changeMsg;
				int confirm;
				
				if(z==0) {
					changeMsg  = "Please confirm to Select new Lecture";
					
					confirm = showConfirmMessageDialog(changeMsg, "Confirm Required");
				
					if( confirm == 0 ) {	
						
							 this.refreshtableLecSelecUpdate();
							 z++;
					}
				}
				y=1;
							
		}
		
		
				
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// 
	
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// 
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// 
	
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// 
	
	}
}
