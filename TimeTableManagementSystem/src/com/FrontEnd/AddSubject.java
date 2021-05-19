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

import com.dao.EmployeeDao;
import com.dao.SubjectDao;
import com.models.Lecture;
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
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.Enumeration;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import java.awt.event.MouseAdapter;

public class AddSubject extends JFrame implements ActionListener, MouseListener{

	private JPanel contentPane;
	private JTextField textField_Name_Insert;
	private JTextField textField_Code_Insert;
	private JTextField textField_Name_Update;
	private JTextField textField_Code_Update;
	private JPanel panelUpdate;
	private JPanel panelInsert;
	private JLayeredPane layeredPane;
	private JComboBox comboBox_offYear_Insert;
	private JRadioButton rdbtn_1stSem_Insert;
	private JRadioButton rdbtn_2stSem_Insert;
	private JComboBox comboBox_LecHrs_Insert;
	private JComboBox comboBox_LecMin_Insert;
	private JComboBox comboBox_TuteHrs_Insert;
	private JComboBox comboBox_TuteMin_Insert;
	private JComboBox comboBox_LabHrs_Insert ;
	private JComboBox comboBox_LabMin_Insert; 
	private JButton btnSave_Insert ;
	private JButton btnReset_Insert;
	private JButton btnBack_Insert;
	private JButton btnRefresh_Update;
	private JButton btn_SwitchAddSub_update;
	private JButton btn_Update_update ;
	private JButton btn_Delete_update;
	private JButton btnNewButton;
	
	private JComboBox comboBox_LabMin__Update;
	private JComboBox comboBox_LabHrs__Update;
	private JComboBox comboBox_LecMin__Update;
	private JComboBox comboBox_OffYear__Update;
	private JComboBox comboBox_LecHrs__Update;
	private JComboBox comboBox_TutHrs__Update;
	private JComboBox comboBox_TuteMin__Update;
	private JRadioButton rdbtn_1stSem_update;
	private JRadioButton rdbtn_2ndSem_update;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
	private static ResultSet rs  = null;
	
	private DBUtill db;
	private SubjectDao subject;
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private JTable table_Update;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddSubject frame = new AddSubject();
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
	public AddSubject() {
		
		
		this.db = new DBUtill();
		this.subject = new SubjectDao();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0,0,1366,768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 1350, 729);
		contentPane.add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		panelInsert = new JPanel();
		panelInsert.setLayout(null);
		layeredPane.add(panelInsert, "name_7909728703700");
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBounds(0, 0, 1340, 729);
		panelInsert.add(panel_4);
		
		JPanel panel_3_1 = new JPanel();
		panel_3_1.setLayout(null);
		panel_3_1.setBorder(new CompoundBorder(new TitledBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), "Subject Insert", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), new CompoundBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 200, 0), new Color(64, 64, 64), new Color(0, 0, 0), new Color(255, 0, 0)), new MatteBorder(11, 11, 11, 11, (Color) new Color(128, 128, 128)))));
		panel_3_1.setBounds(86, 39, 836, 634);
		panel_4.add(panel_3_1);
		
		JLabel lblNewLabel_1 = new JLabel("Offered Year");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(57, 60, 141, 32);
		panel_3_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Offered Semester");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(57, 120, 141, 32);
		panel_3_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Subject Name");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(57, 179, 141, 32);
		panel_3_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_5 = new JLabel("Subject Code");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_5.setBounds(57, 240, 141, 32);
		panel_3_1.add(lblNewLabel_5);
		
		btnSave_Insert = new JButton("SAVE");
		btnSave_Insert.addActionListener(this);
		btnSave_Insert.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSave_Insert.setBackground(Color.GRAY);
		btnSave_Insert.setBounds(141, 548, 146, 32);
		panel_3_1.add(btnSave_Insert);
		
		JLabel lblNewLabel_6 = new JLabel("Number Of Lecture Hours");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_6.setBounds(57, 300, 178, 32);
		panel_3_1.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Number Of Tutorial Hours");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_7.setBounds(57, 360, 212, 32);
		panel_3_1.add(lblNewLabel_7);
		
		JLabel lblNewLabel_9 = new JLabel("Number Of Lab Hours");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_9.setBounds(57, 420, 212, 32);
		panel_3_1.add(lblNewLabel_9);
		
		comboBox_LecMin_Insert = new JComboBox();
		comboBox_LecMin_Insert.setModel(new DefaultComboBoxModel(new String[] {"00", "30"}));
		comboBox_LecMin_Insert.setBounds(448, 306, 83, 24);
		panel_3_1.add(comboBox_LecMin_Insert);
		
		btnReset_Insert = new JButton("RESET");
		btnReset_Insert.addActionListener(this);
		btnReset_Insert.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnReset_Insert.setBackground(Color.GRAY);
		btnReset_Insert.setBounds(395, 548, 146, 32);
		panel_3_1.add(btnReset_Insert);
		
		btnBack_Insert = new JButton("BACK");
		btnBack_Insert.addActionListener(this);
		btnBack_Insert.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnBack_Insert.setBackground(Color.GRAY);
		btnBack_Insert.setBounds(612, 548, 146, 32);
		panel_3_1.add(btnBack_Insert);
		
		comboBox_offYear_Insert = new JComboBox();
		comboBox_offYear_Insert.setModel(new DefaultComboBoxModel(new String[] {"Select a Year", "1 st year", "2 nd Year", "3 rd Year", "4 th Year"}));
		comboBox_offYear_Insert.setBounds(300, 66, 257, 24);
		panel_3_1.add(comboBox_offYear_Insert);
		
		rdbtn_1stSem_Insert = new JRadioButton("1 st Semester");
		buttonGroup.add(rdbtn_1stSem_Insert);
		rdbtn_1stSem_Insert.setBounds(300, 127, 109, 23);
		panel_3_1.add(rdbtn_1stSem_Insert);
		
		rdbtn_2stSem_Insert = new JRadioButton("2 nd Semester");
		buttonGroup.add(rdbtn_2stSem_Insert);
		rdbtn_2stSem_Insert.setBounds(448, 127, 109, 23);
		panel_3_1.add(rdbtn_2stSem_Insert);
		
		textField_Name_Insert = new JTextField();
		textField_Name_Insert.setBounds(300, 185, 257, 24);
		panel_3_1.add(textField_Name_Insert);
		textField_Name_Insert.setColumns(10);
		
		textField_Code_Insert = new JTextField();
		textField_Code_Insert.setColumns(10);
		textField_Code_Insert.setBounds(300, 246, 257, 24);
		panel_3_1.add(textField_Code_Insert);
		
		comboBox_LecHrs_Insert = new JComboBox();
		comboBox_LecHrs_Insert.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03"}));
		comboBox_LecHrs_Insert.setBounds(300, 306, 83, 24);
		panel_3_1.add(comboBox_LecHrs_Insert);
		
		comboBox_TuteHrs_Insert = new JComboBox();
		comboBox_TuteHrs_Insert.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03"}));
		comboBox_TuteHrs_Insert.setBounds(300, 367, 83, 24);
		panel_3_1.add(comboBox_TuteHrs_Insert);
		
		comboBox_TuteMin_Insert = new JComboBox();
		comboBox_TuteMin_Insert.setModel(new DefaultComboBoxModel(new String[] {"00", "30"}));
		comboBox_TuteMin_Insert.setBounds(448, 367, 83, 24);
		panel_3_1.add(comboBox_TuteMin_Insert);
		
		comboBox_LabHrs_Insert = new JComboBox();
		comboBox_LabHrs_Insert.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03"}));
		comboBox_LabHrs_Insert.setBounds(300, 427, 83, 24);
		panel_3_1.add(comboBox_LabHrs_Insert);
		
		comboBox_LabMin_Insert = new JComboBox();
		comboBox_LabMin_Insert.setModel(new DefaultComboBoxModel(new String[] {"00", "30"}));
		comboBox_LabMin_Insert.setBounds(448, 427, 83, 24);
		panel_3_1.add(comboBox_LabMin_Insert);
		
		JLabel lblNewLabel = new JLabel("hrs");
		lblNewLabel.setBounds(392, 311, 46, 14);
		panel_3_1.add(lblNewLabel);
		
		JLabel lblNewLabel_10 = new JLabel("hrs");
		lblNewLabel_10.setBounds(392, 431, 46, 14);
		panel_3_1.add(lblNewLabel_10);
		
		JLabel lblNewLabel_8 = new JLabel("hrs");
		lblNewLabel_8.setBounds(392, 371, 46, 14);
		panel_3_1.add(lblNewLabel_8);
		
		JLabel lblMin = new JLabel("min");
		lblMin.setBounds(541, 311, 46, 14);
		panel_3_1.add(lblMin);
		
		JLabel lblMin_1 = new JLabel("min");
		lblMin_1.setBounds(541, 371, 46, 14);
		panel_3_1.add(lblMin_1);
		
		JLabel lblMin_2 = new JLabel("min");
		lblMin_2.setBounds(541, 431, 46, 14);
		panel_3_1.add(lblMin_2);
		
		JLabel lblNewLabel_4 = new JLabel("Subject Insert Form");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_4.setBounds(586, 0, 204, 42);
		panel_4.add(lblNewLabel_4);
		
		btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(this);
		btnNewButton.setBounds(1083, 143, 97, 25);
		panel_4.add(btnNewButton);
		
		panelUpdate = new JPanel();
		panelUpdate.setLayout(null);
		layeredPane.add(panelUpdate, "name_9924311256900");
		
		JPanel panel_4_1_2_1 = new JPanel();
		panel_4_1_2_1.setLayout(null);
		panel_4_1_2_1.setBounds(0, 0, 1340, 729);
		panelUpdate.add(panel_4_1_2_1);
		
		btnRefresh_Update = new JButton("REFRESH");
		btnRefresh_Update.addActionListener(this);
		btnRefresh_Update.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		btnRefresh_Update.setBounds(1184, 517, 146, 32);
		panel_4_1_2_1.add(btnRefresh_Update);
		
		btn_SwitchAddSub_update = new JButton("ADD SUBJECT");
		btn_SwitchAddSub_update.addActionListener(this);
		btn_SwitchAddSub_update.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		btn_SwitchAddSub_update.setBounds(1143, 658, 168, 32);
		panel_4_1_2_1.add(btn_SwitchAddSub_update);
		
		JButton btn_Back_Update = new JButton("BACK");
		btn_Back_Update.addActionListener(this);
		btn_Back_Update.setFont(new Font("Tahoma", Font.BOLD, 13));
		btn_Back_Update.setBackground(Color.GRAY);
		btn_Back_Update.setBounds(31, 7, 146, 32);
		panel_4_1_2_1.add(btn_Back_Update);
		
		JPanel panel_4_2 = new JPanel();
		panel_4_2.setLayout(null);
		panel_4_2.setBounds(0, 0, 1340, 729);
		panel_4_1_2_1.add(panel_4_2);
		
		JPanel panel_3_1_2 = new JPanel();
		panel_3_1_2.setLayout(null);
		panel_3_1_2.setBorder(new CompoundBorder(new TitledBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), "Subject Update", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), new CompoundBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 200, 0), new Color(64, 64, 64), new Color(0, 0, 0), new Color(255, 0, 0)), new MatteBorder(11, 11, 11, 11, (Color) new Color(128, 128, 128)))));
		panel_3_1_2.setBounds(84, 52, 714, 634);
		panel_4_2.add(panel_3_1_2);
		
		JLabel lblNewLabel_1_2 = new JLabel("Offered Year");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_2.setBounds(57, 60, 141, 32);
		panel_3_1_2.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_2_2 = new JLabel("Offered Semester");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_2.setBounds(57, 120, 141, 32);
		panel_3_1_2.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_3_2 = new JLabel("Subject Name");
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3_2.setBounds(57, 179, 141, 32);
		panel_3_1_2.add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_5_2 = new JLabel("Subject Code");
		lblNewLabel_5_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_5_2.setBounds(57, 240, 141, 32);
		panel_3_1_2.add(lblNewLabel_5_2);
		
		btn_Update_update = new JButton("UPDATE");
		btn_Update_update.addActionListener(this);
		btn_Update_update.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		btn_Update_update.setBounds(76, 548, 146, 32);
		panel_3_1_2.add(btn_Update_update);
		
		JLabel lblNewLabel_6_2 = new JLabel("Number Of Lecture Hours");
		lblNewLabel_6_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_6_2.setBounds(57, 300, 203, 32);
		panel_3_1_2.add(lblNewLabel_6_2);
		
		JLabel lblNewLabel_7_2 = new JLabel("Number Of Tutorial Hours");
		lblNewLabel_7_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_7_2.setBounds(57, 360, 203, 32);
		panel_3_1_2.add(lblNewLabel_7_2);
		
		JLabel lblNewLabel_9_2 = new JLabel("Number Of Lab Hours");
		lblNewLabel_9_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_9_2.setBounds(57, 420, 203, 32);
		panel_3_1_2.add(lblNewLabel_9_2);
		
		comboBox_LecMin__Update = new JComboBox();
		comboBox_LecMin__Update.setModel(new DefaultComboBoxModel(new String[] {"00", "30"}));
		comboBox_LecMin__Update.setEditable(true);
		comboBox_LecMin__Update.setBounds(448, 306, 83, 24);
		panel_3_1_2.add(comboBox_LecMin__Update);
		
		btn_Delete_update = new JButton("DELETE");
		btn_Delete_update.addActionListener(this);
		btn_Delete_update.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		btn_Delete_update.setBounds(458, 548, 146, 32);
		panel_3_1_2.add(btn_Delete_update);
		
		comboBox_OffYear__Update = new JComboBox();
		comboBox_OffYear__Update.setEditable(true);
		comboBox_OffYear__Update.setBounds(300, 66, 257, 24);
		panel_3_1_2.add(comboBox_OffYear__Update);
		
		rdbtn_1stSem_update = new JRadioButton("1 st Semester");
		buttonGroup_1.add(rdbtn_1stSem_update);
		rdbtn_1stSem_update.setBounds(300, 127, 109, 23);
		panel_3_1_2.add(rdbtn_1stSem_update);
		
		rdbtn_2ndSem_update = new JRadioButton("2 nd Semester");
		buttonGroup_1.add(rdbtn_2ndSem_update);
		rdbtn_2ndSem_update.setBounds(448, 127, 109, 23);
		panel_3_1_2.add(rdbtn_2ndSem_update);
		
		textField_Name_Update = new JTextField();
		textField_Name_Update.setColumns(10);
		textField_Name_Update.setBounds(300, 185, 257, 24);
		panel_3_1_2.add(textField_Name_Update);
		
		textField_Code_Update = new JTextField();
		textField_Code_Update.setEditable(false);
		textField_Code_Update.setColumns(10);
		textField_Code_Update.setBounds(300, 246, 257, 24);
		panel_3_1_2.add(textField_Code_Update);
		
		comboBox_LecHrs__Update = new JComboBox();
		comboBox_LecHrs__Update.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03"}));
		comboBox_LecHrs__Update.setEditable(true);
		comboBox_LecHrs__Update.setBounds(300, 306, 83, 24);
		panel_3_1_2.add(comboBox_LecHrs__Update);
		
		comboBox_TutHrs__Update = new JComboBox();
		comboBox_TutHrs__Update.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03"}));
		comboBox_TutHrs__Update.setEditable(true);
		comboBox_TutHrs__Update.setBounds(300, 367, 83, 24);
		panel_3_1_2.add(comboBox_TutHrs__Update);
		
		comboBox_TuteMin__Update = new JComboBox();
		comboBox_TuteMin__Update.setModel(new DefaultComboBoxModel(new String[] {"00", "30"}));
		comboBox_TuteMin__Update.setEditable(true);
		comboBox_TuteMin__Update.setBounds(448, 367, 83, 24);
		panel_3_1_2.add(comboBox_TuteMin__Update);
		
		comboBox_LabHrs__Update = new JComboBox();
		comboBox_LabHrs__Update.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03"}));
		comboBox_LabHrs__Update.setEditable(true);
		comboBox_LabHrs__Update.setBounds(300, 427, 83, 24);
		panel_3_1_2.add(comboBox_LabHrs__Update);
		
		comboBox_LabMin__Update = new JComboBox();
		comboBox_LabMin__Update.setModel(new DefaultComboBoxModel(new String[] {"00", "30"}));
		comboBox_LabMin__Update.setEditable(true);
		comboBox_LabMin__Update.setBounds(448, 427, 83, 24);
		panel_3_1_2.add(comboBox_LabMin__Update);
		
		JLabel lblNewLabel_12 = new JLabel("hrs");
		lblNewLabel_12.setBounds(392, 311, 46, 14);
		panel_3_1_2.add(lblNewLabel_12);
		
		JLabel lblNewLabel_10_2 = new JLabel("hrs");
		lblNewLabel_10_2.setBounds(392, 431, 46, 14);
		panel_3_1_2.add(lblNewLabel_10_2);
		
		JLabel lblNewLabel_8_2 = new JLabel("hrs");
		lblNewLabel_8_2.setBounds(392, 371, 46, 14);
		panel_3_1_2.add(lblNewLabel_8_2);
		
		JLabel lblMin_4 = new JLabel("min");
		lblMin_4.setBounds(541, 311, 46, 14);
		panel_3_1_2.add(lblMin_4);
		
		JLabel lblMin_1_2 = new JLabel("min");
		lblMin_1_2.setBounds(541, 371, 46, 14);
		panel_3_1_2.add(lblMin_1_2);
		
		JLabel lblMin_2_2 = new JLabel("min");
		lblMin_2_2.setBounds(541, 431, 46, 14);
		panel_3_1_2.add(lblMin_2_2);
		
		JLabel lblNewLabel_4_2 = new JLabel("Subject Update Form");
		lblNewLabel_4_2.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_4_2.setBounds(586, 0, 204, 42);
		panel_4_2.add(lblNewLabel_4_2);
		
		JScrollPane scrollPane_1_1 = new JScrollPane();
		scrollPane_1_1.setBounds(831, 62, 499, 386);
		panel_4_2.add(scrollPane_1_1);
		
		table_Update = new JTable();
		scrollPane_1_1.setViewportView(table_Update);
		table_Update.addMouseListener(this);
		
		refreshTableUpdate();
		HiFiLookAndFeel();
	}
	
	public void HiFiLookAndFeel() {
		
		try {
	        //here you can put the selected theme class name in JTattoo
	        UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
	        SwingUtilities.updateComponentTreeUI(this);

	    } catch (ClassNotFoundException ex) {
	        java.util.logging.Logger.getLogger(AddLecturer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	    } catch (InstantiationException ex) {
	        java.util.logging.Logger.getLogger(AddLecturer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	    } catch (IllegalAccessException ex) {
	        java.util.logging.Logger.getLogger(AddLecturer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
	        java.util.logging.Logger.getLogger(AddLecturer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	    }		
		
		
		
	}
	
	public void McWinLookAndFeel() {
		
		try {
	        //here you can put the selected theme class name in JTattoo
	        UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
	        SwingUtilities.updateComponentTreeUI(this);

	    } catch (ClassNotFoundException ex) {
	        java.util.logging.Logger.getLogger(AddLecturer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	    } catch (InstantiationException ex) {
	        java.util.logging.Logger.getLogger(AddLecturer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	    } catch (IllegalAccessException ex) {
	        java.util.logging.Logger.getLogger(AddLecturer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
	        java.util.logging.Logger.getLogger(AddLecturer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	    }		
		
		
		
	}
	
	public void showWarningMessageDialog(String message, String title) {
		JOptionPane.showMessageDialog(getParent(), message, title, JOptionPane.WARNING_MESSAGE);;
	}
	
	public void showPlainMessageDialog(String message, String title) {
		JOptionPane.showMessageDialog(getParent(), message, title, JOptionPane.PLAIN_MESSAGE);
	}
	
	public void refreshComboBox() {
		comboBox_offYear_Insert.setSelectedIndex(0);
		comboBox_LecHrs_Insert.setSelectedIndex(0);
		comboBox_LecMin_Insert.setSelectedIndex(0);;
		comboBox_TuteHrs_Insert.setSelectedIndex(0);
		comboBox_TuteMin_Insert.setSelectedIndex(0);
		comboBox_LabHrs_Insert.setSelectedIndex(0);
		comboBox_LabMin_Insert.setSelectedIndex(0);;
	}

	
	public void switchPanels(JPanel panel) {
		layeredPane.removeAll();		
		layeredPane.add(panel);
		layeredPane.repaint();
		layeredPane.revalidate();
		
	}
	
	public void refreshTableUpdate() {
		
		rs = this.db.refreshSubjectTable();
		this.table_Update.setModel(DbUtils.resultSetToTableModel(rs));
		
		textField_Code_Update.setText(null);
		textField_Name_Update.setText(null);
		comboBox_OffYear__Update.setSelectedItem(null);
		comboBox_LecHrs__Update.setSelectedItem(null);
		comboBox_LecMin__Update.setSelectedItem(null);
		comboBox_LabHrs__Update.setSelectedItem(null);
		comboBox_LabMin__Update.setSelectedItem(null);
		comboBox_TutHrs__Update.setSelectedItem(null);
		comboBox_TuteMin__Update.setSelectedItem(null);
		buttonGroup_1.clearSelection();
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		
		
		if( e.getSource() == btnSave_Insert ) {
			
			String name = textField_Name_Insert.getText();
			String code = textField_Code_Insert.getText();
			//String password;
			String offYear = (String)comboBox_offYear_Insert.getSelectedItem();			
			String LecHrs = (String) comboBox_LecHrs_Insert.getSelectedItem()+":"+ (String)comboBox_LecMin_Insert.getSelectedItem();
			//String LecMin = (String) comboBox_LecMin_Insert.getSelectedItem();
			String TuteHrs = (String) comboBox_TuteHrs_Insert.getSelectedItem() +":"+ (String)comboBox_TuteMin_Insert.getSelectedItem();
			//String TuteMin =   (String) comboBox_TuteMin_Insert.getSelectedItem();
			String LabHrs =   (String) comboBox_LabHrs_Insert.getSelectedItem()+":"+ (String)comboBox_LabMin_Insert.getSelectedItem();;
			//String LabMin =   (String) comboBox_LabMin_Insert.getSelectedItem();
			String offSem ="";
			
			System.out.println(TuteHrs);
			
			if( name.equals("")) {
				JOptionPane.showMessageDialog(this, "Please Enter a Subject Name", "Insert Error", JOptionPane.WARNING_MESSAGE);
				return ;
			}
			else  if( code.equals("")) {
				JOptionPane.showMessageDialog(this, "Please Enter a Subject Code", "Insert Error", JOptionPane.WARNING_MESSAGE);
				return ;
			}else if( offYear.equals("Select a Year") ) {
				JOptionPane.showMessageDialog(this, "Please Select a Offered Year", "Insert Error", JOptionPane.WARNING_MESSAGE);
				return ;
			}else if(!(rdbtn_1stSem_Insert.isSelected() | rdbtn_2stSem_Insert.isSelected())) {
				JOptionPane.showMessageDialog(this, "Please Select a Offered Semester", "Insert Error", JOptionPane.WARNING_MESSAGE);
				return ;
			}
			
				
			Enumeration<AbstractButton> bg = buttonGroup.getElements();
			while(bg.hasMoreElements()) {
				
				JRadioButton jrd = (JRadioButton)bg.nextElement();
				
				if(jrd.isSelected())
					offSem = jrd.getText();
			}
			
	
			InsertSubject(offYear,offSem,name,code, LecHrs, TuteHrs, LabHrs );
			
			textField_Name_Insert.setText(null);
			textField_Code_Insert.setText(null);
			buttonGroup.clearSelection();
			refreshComboBox();
		}
		
	if( e.getSource() == btnReset_Insert ) {
			
		textField_Name_Insert.setText(null);
		textField_Code_Insert.setText(null);
		refreshComboBox();
			
			
		}
	
	
	if( e.getSource() == btnNewButton ) {
		
		McWinLookAndFeel();
		refreshTableUpdate();
		switchPanels(panelUpdate);
		
	}
		
	/*========================================================
	 * 
	 * Manage SubJect
	 * 
	 * ========================================================

	*/
	if( e.getSource() == btn_Update_update ) {
		
		String name = textField_Name_Update.getText();
		String code = textField_Code_Update.getText();
		//String password;
		String offYear = (String)comboBox_OffYear__Update.getSelectedItem();			
		String LecHrs =  comboBox_LecHrs__Update.getSelectedItem().toString()+":"+ comboBox_LecMin__Update.getSelectedItem().toString();
		//String LecMin = (String) comboBox_LecMin_Insert.getSelectedItem();
		String TuteHrs = comboBox_TutHrs__Update.getSelectedItem().toString() +":"+ comboBox_TuteMin__Update.getSelectedItem().toString();
		//String TuteMin =   (String) comboBox_TuteMin_Insert.getSelectedItem();
		String LabHrs =    comboBox_LabHrs__Update.getSelectedItem().toString()+":"+comboBox_LabMin__Update.getSelectedItem().toString();
		//String LabMin =   (String) comboBox_LabMin_Insert.getSelectedItem();
		String offSem ="";
		
		System.out.println(name);
		System.out.println(code);
		System.out.println(offYear);
		System.out.println(LecHrs);
		System.out.println(TuteHrs);
		System.out.println(LabHrs);
		
		
		if( code.equals("")) {
			JOptionPane.showMessageDialog(this, "No Data Found", "Insert Error", JOptionPane.WARNING_MESSAGE);
			return ;
		}
		else if( name.equals("")) {
			JOptionPane.showMessageDialog(this, "Subject Name cant be null", "Insert Error", JOptionPane.WARNING_MESSAGE);
			return ;
		}
		else if( offYear.equals("Select a Year") ) {
			JOptionPane.showMessageDialog(this, "Please Select a Offered Year", "Insert Error", JOptionPane.WARNING_MESSAGE);
			return ;
		}else if(!(rdbtn_1stSem_update.isSelected() | rdbtn_2ndSem_update.isSelected())) {
			JOptionPane.showMessageDialog(this, "Please Select a Offered Semester", "Insert Error", JOptionPane.WARNING_MESSAGE);
			return ;
		}
		
			System.out.println("here");
		Enumeration<AbstractButton> bg = buttonGroup_1.getElements();
		while(bg.hasMoreElements()) {
			
			JRadioButton jrd = (JRadioButton)bg.nextElement();
			
			if(jrd.isSelected())
				offSem = jrd.getText();
		}
		
		
		UpdateSubject(offYear,offSem,name,code, LecHrs, TuteHrs, LabHrs );
		
		
		refreshTableUpdate();
		
	}
	
	
	if( e.getSource() == btn_Delete_update ) {
		
		String code = textField_Code_Update.getText();
		this.DeleteSubject(code);
		this.refreshTableUpdate();
		
	}
		
	
	
	
		if( e.getSource() == btnRefresh_Update ) {
			
			refreshTableUpdate();
		}
		
		
		if( e.getSource() == btn_SwitchAddSub_update ) {
			
			HiFiLookAndFeel();
			switchPanels(panelInsert);
			
		}
		
		
	}
	
	public void InsertSubject(String offYear,String offSem,String name,String code,String LecHrs,String TuteHrs ,String LabHrs) {
		 
		
		try {
			if(this.db.searchBySubType("Subject_Code", code).next() == true ) {
				showWarningMessageDialog("Subject Code has already Exists", "Insert Error");
			}else {				
				
				subject.insertSubject(new Subject( offYear,offSem,name,code, LecHrs, TuteHrs, LabHrs ));	
				this.showPlainMessageDialog("Successfuly Inserted", "Insert");
				
			}
		} catch (SQLException e) {	
			System.out.println("db search error");
			System.err.println("Exception :" +e.getMessage());
		}
		
			
	}
	
	public void UpdateSubject(String offYear,String offSem,String name,String code,String LecHrs,String TuteHrs ,String LabHrs) {
		
		
		int confirm;
		String changeMsg;
		Subject sub = null;
		
		sub = db.searchSubjectByCode(code);
		
		changeMsg = "Are you sure you want to update below fields of the Subject Code :" + code + "\n\n";
		
		if( !( sub.getSubName().equals(name) ) ) {			
			changeMsg += "\\Subjecte Name : " + name;
			sub.setSubName(name);
		}
		if( !( sub.getOfferedYear().equals(offYear) ) ) {			
			changeMsg += "\nOffered Year : " + offYear;
			sub.setOfferedYear(offYear);;
		}
		if( !( sub.getOfferedSem().equals(offSem)) )  {			
			changeMsg += "\nOffered Semester : " + offSem;
			sub.setOfferedSem(offSem);
		}
		if( !( sub.getLechrs().equals(LecHrs)) )  {			
			changeMsg += "\nLecture Hours : " + LecHrs;
			sub.setLechrs(LecHrs);
		}if( !( sub.getLabhrs().equals(LabHrs) ) ) {			
			changeMsg += "\nLab Hours : " + LabHrs;
			sub.setLabhrs(LabHrs);
		}
		if( !( sub.getTutehrs().equals(TuteHrs) ) ) {			
			changeMsg += "\nTute Hours : " + TuteHrs;
			sub.setTutehrs(TuteHrs);
		}
		
		confirm = showConfirmMessageDialog(changeMsg, "Confirm Required");
		
		if( confirm == 0 ) {			
			try {				
				this.subject.updateSubject(sub);
				showPlainMessageDialog("Successfuly Updated", "Update");
			}catch(Exception e) {
				System.err.println("Exception :" +e.getMessage());
				System.out.println("!!!!!!");
				
			}
		}
		
			
		
	}
	
	
	public void DeleteSubject(String code) {
		
		
		int confirm;
		
		confirm = showConfirmMessageDialog("Are you sure You want to delete Subject code : " + code, "Confirm Required");
		
		if( confirm == 0 ) {
			try {
				subject.deleteSubject(code);
				showMessageDialog("Successfully Subject Deleted");		
			}catch(Exception e) {
				System.err.println("Exception :" +e.getMessage());
				e.printStackTrace();
				System.out.println("!!!!!!");				
			} 
						
		}
		
		
	}
	

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
		if( e.getSource() == table_Update ) {
			int row = table_Update.getSelectedRow();
			String code = table_Update.getValueAt(row, 0).toString();					
		
			Subject sub = this.db.searchSubjectByCode(code);	
										
			comboBox_OffYear__Update.setSelectedItem(sub.getOfferedYear());
			textField_Name_Update.setText(sub.getSubName());
			textField_Code_Update.setText(sub.getSubCode());
			
			String lechours = sub.getLechrs();
			String labhours = sub.getLabhrs();
			String tutehours = sub.getTutehrs();
			
			
			LocalTime lectime = LocalTime.parse(lechours);
			LocalTime labtime = LocalTime.parse(labhours);
			LocalTime tuttime = LocalTime.parse(tutehours);
			
			
			String lechour = Integer.toString(lectime.getHour());
			if(lechour.length()==2) {
				comboBox_LecHrs__Update.setSelectedItem(lechour);
			}
			else {
				lechour = "0"+lechour;
				 comboBox_LecHrs__Update.setSelectedItem(lechour);
			}
						
			
			
			String lecmin = Integer.toString(lectime.getMinute());
			if(lecmin.length()==2) {
				comboBox_LecMin__Update.setSelectedItem(lecmin);
			}
			else {
				 lecmin = "0"+lecmin;
				 comboBox_LecMin__Update.setSelectedItem(lecmin);
			}
			
			
			String labhour = Integer.toString(labtime.getHour());
			if(labhour.length()==2) {
				comboBox_LabHrs__Update.setSelectedItem(labhour);
			}
			else {
				labhour = "0"+labhour;
				 comboBox_LabHrs__Update.setSelectedItem(labhour);
			}
			
			
			
			
			String labmin = Integer.toString(labtime.getMinute());
			if(labmin.length()==2) {
				comboBox_LabMin__Update.setSelectedItem(labmin);
			}
			else {
				labmin = "0"+labmin;
				 comboBox_LabMin__Update.setSelectedItem(labmin);
			}
			
			
			
			String tutehour = Integer.toString(tuttime.getHour());
			if(tutehour.length()==2) {
				comboBox_TutHrs__Update.setSelectedItem(tutehour);
			}
			else {
				tutehour = "0"+tutehour;
				 comboBox_TutHrs__Update.setSelectedItem(tutehour);
			}
			
			
			String tutemin = Integer.toString(tuttime.getMinute());
			if(tutemin.length()==2) {
				comboBox_LecMin__Update.setSelectedItem(tutemin);
			}
			else {
				tutemin = "0"+tutemin;
				 comboBox_TuteMin__Update.setSelectedItem(tutemin);
			}
				 comboBox_TuteMin__Update.setSelectedItem(tutemin);
			
			String sem = sub.getOfferedSem();
			
			
			if(sem.startsWith("1")) {
				
				rdbtn_1stSem_update.setSelected(true);
				
				
			}else {
				rdbtn_2ndSem_update.setSelected(true);
			}
		}
		
		
		
		
		
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	public int showConfirmMessageDialog(String message, String title) {
		return JOptionPane.showConfirmDialog(getParent(), message, title, JOptionPane.YES_NO_OPTION);
	}
	
	public void showMessageDialog(String message) {
		JOptionPane.showMessageDialog(getParent(), message);
	}
}
