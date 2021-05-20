package com.FrontEnd;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.awt.CardLayout;
import javax.swing.JButton;
import javax.swing.border.CompoundBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.StyledEditorKit.BoldAction;

import com.dao.EmployeeDao;
import com.models.Lecture;
import com.util.DBUtill;

import net.proteanit.sql.DbUtils;

import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JComboBox;
import javax.swing.border.EtchedBorder;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import java.awt.event.MouseAdapter;

public class AddLecturer extends JFrame implements ActionListener, MouseListener {

	private JPanel contentPane;
	private JTextField textField_EmpName_Insert;
	private JTextField textField_rank_Insert;
	private JTextField textField_EmpID_Insert;
	private JTextField textField_Name_Update;
	private JTextField textField_Rank_Update;
	private JTextField textField_ID_Update;
	private JTable table_Update;
	private JPanel panelInsert;
	private JPanel panelUpdate;
	private JLayeredPane layeredPane;
	
	private JButton btnSave_Insert;
	private JButton btnReset_Insert;
	private JButton btnSwitchAddLec_update;
	private JButton btnGenarateRank_Insert;
	private JButton btnGenarateRank_Update;
	private JButton btnActiveHours__Update;
	private JButton btnUpdate_Update;
	private JButton btnDelete_Update;
	private JButton btnRefresh_Update;
	private JButton btnBack_Update;
	
	private JComboBox comboBox_Fac_Insert;
	private JComboBox comboBox_Dep_Insert;
	private JComboBox comboBox_Center_Insert;
	private JComboBox comboBox_Buld_Insert;
	private JComboBox comboBox_Level_Insert;
	
	private JComboBox comboBox_Fac__Update;
	private JComboBox comboBox_Dep_Update;
	private JComboBox comboBox_Center_Update;
	private JComboBox comboBox_Buld_Update;
	private JComboBox comboBox_Level_Update;
		
	private EmployeeDao employee;
	private static ResultSet rs  = null;
	
	
	private DBUtill db;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddLecturer frame = new AddLecturer();
					
					
					
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
	public AddLecturer() {
		setTitle("Add Lecture");
		
		//lookAndFeelYellowBack();
		
		this.db = new DBUtill();
		this.employee = new EmployeeDao();
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
		
		//TextureLookAndFeel();
		
		panelInsert = new JPanel();
		panelInsert.setLayout(null);
		layeredPane.add(panelInsert, "name_27704104286300");
		
		JPanel panel_4 = new JPanel();
		//panel_4.setBackground(Color.WHITE);
		panel_4.setLayout(null);
		panel_4.setBounds(0, 0, 1340, 729);
		panelInsert.add(panel_4);
		
		JPanel panel_3_1 = new JPanel();
		//panel_3_1.setBackground(Color.WHITE);
		panel_3_1.setLayout(null);
		panel_3_1.setBorder(new CompoundBorder(new TitledBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), "Lecturer Insert", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), new CompoundBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 200, 0), new Color(64, 64, 64), new Color(0, 0, 0), new Color(255, 0, 0)), new MatteBorder(11, 11, 11, 11, (Color) new Color(128, 128, 128)))));
		panel_3_1.setBounds(86, 39, 836, 679);
		panel_4.add(panel_3_1);
		
		JLabel lblNewLabel_1 = new JLabel("Employee Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(57, 60, 141, 32);
		panel_3_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Employee ID");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(57, 120, 141, 32);
		panel_3_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Faculty");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(57, 179, 141, 32);
		panel_3_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_5 = new JLabel("Department ");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_5.setBounds(57, 240, 141, 32);
		panel_3_1.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Center");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_6.setBounds(57, 300, 141, 32);
		panel_3_1.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Building");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_7.setBounds(57, 360, 142, 32);
		panel_3_1.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Active Hours");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_8.setBounds(57, 540, 131, 32);
		panel_3_1.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Level");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_9.setBounds(57, 420, 142, 32);
		panel_3_1.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Rank");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_10.setBounds(57, 480, 141, 32);
		panel_3_1.add(lblNewLabel_10);
		
		btnSave_Insert = new JButton("SAVE");
		
		btnSave_Insert.addActionListener(this);
		btnSave_Insert.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSave_Insert.setBounds(142, 618, 146, 32);
		panel_3_1.add(btnSave_Insert);
		
		textField_EmpName_Insert = new JTextField();
		textField_EmpName_Insert.setFont(new Font("Calibri", Font.PLAIN, 12));
		textField_EmpName_Insert.setColumns(10);
		textField_EmpName_Insert.setBounds(300, 65, 257, 24);
		panel_3_1.add(textField_EmpName_Insert);
		
		JButton btnSwitchActiveHours_Insert = new JButton("Click Here");
		btnSwitchActiveHours_Insert.setBounds(300, 546, 164, 24);
		panel_3_1.add(btnSwitchActiveHours_Insert);
		
		textField_rank_Insert = new JTextField();
		textField_rank_Insert.setEditable(false);
		textField_rank_Insert.setFont(new Font("Calibri", Font.PLAIN, 12));
		textField_rank_Insert.setColumns(10);
		textField_rank_Insert.setBounds(300, 480, 164, 24);
		panel_3_1.add(textField_rank_Insert);
		
		comboBox_Dep_Insert = new JComboBox();
		comboBox_Dep_Insert.setModel(new DefaultComboBoxModel(new String[] {"select a type", "Academic Staff", "Administration Staff"}));
		comboBox_Dep_Insert.setBounds(300, 240, 257, 24);
		panel_3_1.add(comboBox_Dep_Insert);
		
		textField_EmpID_Insert = new JTextField();
		textField_EmpID_Insert.setFont(new Font("Calibri", Font.PLAIN, 12));
		textField_EmpID_Insert.setColumns(10);
		textField_EmpID_Insert.setBounds(300, 120, 257, 24);
		panel_3_1.add(textField_EmpID_Insert);
		
		comboBox_Center_Insert = new JComboBox();
		comboBox_Center_Insert.setModel(new DefaultComboBoxModel(new String[] {"select a type", "Malabe Campus", "Kandy Center", "Metropolitan campus", "Jaffna Center", "Kurunegala center"}));
		comboBox_Center_Insert.setBounds(300, 300, 257, 24);
		panel_3_1.add(comboBox_Center_Insert);
		
		comboBox_Buld_Insert = new JComboBox();
		comboBox_Buld_Insert.setModel(new DefaultComboBoxModel(new String[] {"select a type", "Faculty of Computing Building", "Faculty of Engineering Building", "Faculty of Business & Studies Building", "Faculty of Humanities & Science Building"}));
		comboBox_Buld_Insert.setBounds(300, 366, 257, 24);
		panel_3_1.add(comboBox_Buld_Insert);
		
		comboBox_Fac_Insert = new JComboBox();
		comboBox_Fac_Insert.setModel(new DefaultComboBoxModel(new String[] {"select a type", "Faculty Of Business", "Faculty Of Computing", "Faculty Of Engineering", "Humanities $ Science", "Graduate Studies $ Research", "School of Architecture", "School of Law", "School of Hospitality & Culinary"}));
		comboBox_Fac_Insert.setBounds(300, 185, 257, 24);
		panel_3_1.add(comboBox_Fac_Insert);
		
		comboBox_Level_Insert = new JComboBox();
		comboBox_Level_Insert.setModel(new DefaultComboBoxModel(new String[] {"select a type", "Professor", "Assistant Professor", "Senior Lecturer(HG)", "Senior Lecturer", "Lecturer", "Assistant Lecturer"}));
		comboBox_Level_Insert.setBounds(300, 426, 257, 24);
		panel_3_1.add(comboBox_Level_Insert);
		
		btnGenarateRank_Insert = new JButton("Genarate Rank");
		btnGenarateRank_Insert.addActionListener(this);			
		btnGenarateRank_Insert.setBounds(463, 480, 121, 24);
		panel_3_1.add(btnGenarateRank_Insert);
		
		btnReset_Insert = new JButton("RESET");
		btnReset_Insert.addActionListener(this);
		
		btnReset_Insert.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnReset_Insert.setBounds(396, 618, 146, 32);
		panel_3_1.add(btnReset_Insert);
		
		JButton btnBack_Insert = new JButton("BACK");
		
		btnBack_Insert.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnBack_Insert.setBounds(613, 618, 146, 32);
		panel_3_1.add(btnBack_Insert);
		
		JLabel lblNewLabel_4 = new JLabel("Lecturer Insert Form");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_4.setBounds(586, 0, 204, 42);
		panel_4.add(lblNewLabel_4);
		
		panelUpdate = new JPanel();
		layeredPane.add(panelUpdate, "name_26406102267800");
		panelUpdate.setLayout(null);
		/*try {
        //here you can put the selected theme class name in JTattoo
        UIManager.setLookAndFeel("com.jtattoo.plaf.texture.TextureLookAndFeel");
        SwingUtilities.updateComponentTreeUI(this);

    } catch (ClassNotFoundException ex) {
        java.util.logging.Logger.getLogger(AddLecturer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
        java.util.logging.Logger.getLogger(AddLecturer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
        java.util.logging.Logger.getLogger(AddLecturer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
        java.util.logging.Logger.getLogger(AddLecturer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }*/
		
		JPanel panel_4_1 = new JPanel();
		panel_4_1.setLayout(null);
		
		panel_4_1.setBounds(0, 0, 1340, 729);
		panelUpdate.add(panel_4_1);
		
		JPanel panel_3_1_1 = new JPanel();
		panel_3_1_1.setLayout(null);
		panel_3_1_1.setBorder(new CompoundBorder(new TitledBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), "Lecturer Update", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), new CompoundBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 200, 0), new Color(64, 64, 64), new Color(0, 0, 0), new Color(255, 0, 0)), new MatteBorder(11, 11, 11, 11, (Color) new Color(128, 128, 128)))));
		panel_3_1_1.setBounds(26, 72, 714, 644);
		panel_4_1.add(panel_3_1_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Employee Name");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(57, 60, 141, 32);
		panel_3_1_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("Employee ID");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_1.setBounds(57, 120, 141, 32);
		panel_3_1_1.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_3_1 = new JLabel("Faculty");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3_1.setBounds(57, 179, 141, 32);
		panel_3_1_1.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_5_1 = new JLabel("Department ");
		lblNewLabel_5_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_5_1.setBounds(57, 240, 141, 32);
		panel_3_1_1.add(lblNewLabel_5_1);
		
		JLabel lblNewLabel_6_1 = new JLabel("Center");
		lblNewLabel_6_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_6_1.setBounds(57, 300, 141, 32);
		panel_3_1_1.add(lblNewLabel_6_1);
		
		JLabel lblNewLabel_7_1 = new JLabel("Building");
		lblNewLabel_7_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_7_1.setBounds(57, 360, 142, 32);
		panel_3_1_1.add(lblNewLabel_7_1);
		
		JLabel lblNewLabel_8_1 = new JLabel("Active Hours");
		lblNewLabel_8_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_8_1.setBounds(57, 540, 131, 32);
		panel_3_1_1.add(lblNewLabel_8_1);
		
		JLabel lblNewLabel_9_1 = new JLabel("Level");
		lblNewLabel_9_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_9_1.setBounds(57, 420, 142, 32);
		panel_3_1_1.add(lblNewLabel_9_1);
		
		JLabel lblNewLabel_10_1 = new JLabel("Rank");
		lblNewLabel_10_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_10_1.setBounds(57, 480, 141, 32);
		panel_3_1_1.add(lblNewLabel_10_1);
		
		
		textField_Name_Update = new JTextField();
		textField_Name_Update.setFont(new Font("Calibri", Font.PLAIN, 12));
		textField_Name_Update.setColumns(10);
		textField_Name_Update.setBounds(300, 65, 257, 24);
		panel_3_1_1.add(textField_Name_Update);
		
		btnActiveHours__Update = new JButton("Click Here");
		btnActiveHours__Update.addActionListener(this);
		btnActiveHours__Update.setBounds(300, 546, 164, 24);
		panel_3_1_1.add(btnActiveHours__Update);
		
		textField_Rank_Update = new JTextField();
		textField_Rank_Update.setFont(new Font("Calibri", Font.PLAIN, 12));
		textField_Rank_Update.setEditable(false);
		textField_Rank_Update.setColumns(10);
		textField_Rank_Update.setBounds(300, 480, 164, 24);
		panel_3_1_1.add(textField_Rank_Update);
		
		comboBox_Dep_Update = new JComboBox();
		comboBox_Dep_Update.setModel(new DefaultComboBoxModel(new String[] {"Academic Staff", "Administration Staff"}));
		comboBox_Dep_Update.setBounds(300, 240, 257, 24);
		panel_3_1_1.add(comboBox_Dep_Update);
		
		
		textField_ID_Update = new JTextField();
		textField_ID_Update.setEditable(false);
		textField_ID_Update.setFont(new Font("Calibri", Font.PLAIN, 12));
		textField_ID_Update.setColumns(10);
		textField_ID_Update.setBounds(300, 120, 257, 24);
		panel_3_1_1.add(textField_ID_Update);
		
		comboBox_Center_Update = new JComboBox();
		comboBox_Center_Update.setModel(new DefaultComboBoxModel(new String[] {"Malabe Campus", "Kandy Center", "Metropolitan campus", "Jaffna Center", "Kurunegala center"}));
		comboBox_Center_Update.setBounds(300, 300, 257, 24);
		panel_3_1_1.add(comboBox_Center_Update);
		
		comboBox_Buld_Update = new JComboBox();
		comboBox_Buld_Update.setModel(new DefaultComboBoxModel(new String[] {"Faculty of Computing Building", "Faculty of Engineering Building", "Faculty of Business & Studies Building", "Faculty of Humanities & Science Building"}));
		comboBox_Buld_Update.setBounds(300, 366, 257, 24);
		panel_3_1_1.add(comboBox_Buld_Update);
		
		comboBox_Fac__Update = new JComboBox();
		comboBox_Fac__Update.setModel(new DefaultComboBoxModel(new String[] {"Faculty Of Business", "Faculty Of Computing", "Faculty Of Engineering", "Humanities $ Science", "Graduate Studies $ Research", "School of Architecture", "School of Law", "School of Hospitality & Culinary"}));
		comboBox_Fac__Update.setBounds(300, 185, 257, 24);
		panel_3_1_1.add(comboBox_Fac__Update);
		
		comboBox_Level_Update = new JComboBox();
		comboBox_Level_Update.setModel(new DefaultComboBoxModel(new String[] {"Professor", "Assistant Professor", "Senior Lecturer(HG)", "Senior Lecturer", "Lecturer", "Assistant Lecturer"}));
		comboBox_Level_Update.setBounds(300, 426, 257, 24);
		panel_3_1_1.add(comboBox_Level_Update);
		
		btnGenarateRank_Update = new JButton("Genarate Rank");
		btnGenarateRank_Update.addActionListener(this);
		btnGenarateRank_Update.setBounds(463, 480, 121, 24);
		panel_3_1_1.add(btnGenarateRank_Update);
		
		btnUpdate_Update = new JButton("UPDATE");
		btnUpdate_Update.addActionListener(this);
		btnUpdate_Update.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		btnUpdate_Update.setBounds(127, 583, 146, 32);
		panel_3_1_1.add(btnUpdate_Update);
		
		
		btnDelete_Update = new JButton("DELETE");
		btnDelete_Update.addActionListener(this);
		btnDelete_Update.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		btnDelete_Update.setBounds(457, 583, 146, 32);
		panel_3_1_1.add(btnDelete_Update);
		
		JLabel lblNewLabel_4_1 = new JLabel("Lecturer Management");
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_4_1.setBounds(653, 0, 204, 42);
		panel_4_1.add(lblNewLabel_4_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(769, 110, 561, 338);
		panel_4_1.add(scrollPane);
		
		table_Update = new JTable();
		table_Update.addMouseListener(this);
		scrollPane.setViewportView(table_Update);
		
		btnRefresh_Update = new JButton("REFRESH");
		btnRefresh_Update.addActionListener(this);
		btnRefresh_Update.setBounds(1184, 517, 146, 32);
		panel_4_1.add(btnRefresh_Update);
		btnRefresh_Update.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		
		btnSwitchAddLec_update = new JButton("ADD LECTURE");
		btnSwitchAddLec_update.addActionListener(this);
		btnSwitchAddLec_update.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		btnSwitchAddLec_update.setBounds(1143, 658, 168, 32);
		panel_4_1.add(btnSwitchAddLec_update);
		
		btnBack_Update = new JButton("BACK");
		btnBack_Update.addActionListener(this);
		btnBack_Update.setBounds(31, 7, 146, 32);
		panel_4_1.add(btnBack_Update);
		btnBack_Update.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnBack_Update.setBackground(Color.GRAY);
		
		this.refreshComboBox();
		this.refreshTableUpdate();
		//.TextureLookAndFeel();
		McWinLookAndFeel();
		
		//lookAndFeelYellowBack();
		
		
	
	}
	
	public void lookAndFeelYellowBack() {
		try {
	        //here you can put the selected theme class name in JTattoo
	        UIManager.setLookAndFeel("com.jtattoo.plaf.bernstein.BernsteinLookAndFeel");
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
	
	public void TextureLookAndFeel() {
		
		try {
	        //here you can put the selected theme class name in JTattoo
	        UIManager.setLookAndFeel("com.jtattoo.plaf.texture.TextureLookAndFeel");
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
	

	
	public void actionPerformed(ActionEvent e) {
		
		if( e.getSource() == btnSave_Insert ) {
			
			String name = textField_EmpName_Insert.getText();
			String id = textField_EmpID_Insert.getText();
			//String password;
			String faculty = (String) comboBox_Fac_Insert.getSelectedItem();
			String department = (String) comboBox_Dep_Insert.getSelectedItem();
			String center = (String) comboBox_Center_Insert.getSelectedItem();
			String building = (String) comboBox_Buld_Insert.getSelectedItem();
			String level =   (String) comboBox_Level_Insert.getSelectedItem();
			String ranktext = textField_rank_Insert.getText();
			System.out.println(faculty);
			double rank;
			
			int did;
			
			
			 	if( id.equals("")) {
					JOptionPane.showMessageDialog(this, "Please Enter a Employee ID", "Insert Error", JOptionPane.WARNING_MESSAGE);
					return ;
				}else if( id.length() != 6) {
					JOptionPane.showMessageDialog(this, "Employee ID is must be six digits number", "Insert Error", JOptionPane.WARNING_MESSAGE);
					return ;
				}else if( ranktext.equals("")) {
					JOptionPane.showMessageDialog(this, "Please click on the Generate Rank button to generate the rank", "Insert Error", JOptionPane.WARNING_MESSAGE);
					return ;
				}
			
			try {
				did = Integer.parseInt(id);				
			}catch(Exception ex) {
				JOptionPane.showMessageDialog(this, "Employee ID is not valid", "Insert Error", JOptionPane.WARNING_MESSAGE);
				return;
			}
			
			rank = Double.parseDouble(ranktext);
			
			
			if( name.equals("")) {
				JOptionPane.showMessageDialog(this, "Please Enter a Employee Name", "Insert Error", JOptionPane.WARNING_MESSAGE);
				return ;
			}else if( faculty.equalsIgnoreCase("select a type") ) {
				JOptionPane.showMessageDialog(this, "Please Select a Faculty", "Insert Error", JOptionPane.WARNING_MESSAGE);
				return ;
			}else if( department.equals("select a type") ) {
				JOptionPane.showMessageDialog(this, "Please Enter a Department", "Insert Error", JOptionPane.WARNING_MESSAGE);
				return ;
			}else if( center.equals("select a type") ) {
				JOptionPane.showMessageDialog(this, "Please Select a Center", "Insert Error", JOptionPane.WARNING_MESSAGE);
				return ;
			}else if( building.equals("select a type") ) {
				JOptionPane.showMessageDialog(this, "Please Select a Building", "Insert Error", JOptionPane.WARNING_MESSAGE);
				return ;
			}else if( level.equals("select a type") ) {
				JOptionPane.showMessageDialog(this, "Please Select a Level", "Insert Error", JOptionPane.WARNING_MESSAGE);
				return ;
			}
			
			
						
			
			InsertUser(did, name, faculty, department, center, building, rank, level);
			
			textField_EmpName_Insert.setText(null);
			textField_EmpID_Insert.setText(null);
			refreshComboBox();
			textField_rank_Insert.setText(null);
			
		}
		
		
		if( e.getSource() == btnReset_Insert ) {
			
			textField_EmpName_Insert.setText(null);
			textField_EmpID_Insert.setText(null);
			refreshComboBox();
			textField_rank_Insert.setText(null);
			
			
		}
		
		if( e.getSource() == btnSwitchAddLec_update) {
			
			//lookAndFeelYellowBack();
			TextureLookAndFeel();
			switchPanels(panelInsert);
		}
		
		if(e.getSource() == btnGenarateRank_Insert) {
			
			
			String id = textField_EmpID_Insert.getText();
			int level =    comboBox_Level_Insert.getSelectedIndex();
			double rank=0;
			//String textrank;
			int did;
			
			if( id.equals("")) {
				JOptionPane.showMessageDialog(this, "Please Enter a Employee ID", "Insert Error", JOptionPane.WARNING_MESSAGE);
				return ;
			}else if( id.length() != 6) {
				JOptionPane.showMessageDialog(this, "Employee ID not valid", "Insert Error", JOptionPane.WARNING_MESSAGE);
				return ;
			}
			
			try {
				did = Integer.parseInt(id);				
			}catch(Exception ex) {
				JOptionPane.showMessageDialog(this, "Employee ID is not valid", "Insert Error", JOptionPane.WARNING_MESSAGE);
				return;
			}
			
			
			
			
			//textrank = level + "." + id;
			//System.out.println(textrank);
			try {
				 rank = this.generateRank(did, level);
				
			}catch(Exception ex) {
				JOptionPane.showMessageDialog(this, "Rank is not generated", "Insert Error", JOptionPane.WARNING_MESSAGE);
				return;
			}
			
			textField_rank_Insert.setText(Double.toString(rank));
			
						
		}
		
		
		
		
		/*==========================================================================================================================
		 *                                                 
		 *                                                 LECTURE MANAGEMENT
		 * 
		 * =========================================================================================================================
		 */
		
		if(e.getSource() == btnUpdate_Update) {
			
			String name = textField_Name_Update.getText();
			String id = textField_ID_Update.getText();
			String faculty = (String) comboBox_Fac__Update.getSelectedItem();
			String department = (String) comboBox_Dep_Update.getSelectedItem();
			String center = (String) comboBox_Center_Update.getSelectedItem();
			String building = (String) comboBox_Buld_Update.getSelectedItem();
			String level =   (String) comboBox_Level_Update.getSelectedItem();
			String ranktext = textField_Rank_Update.getText();
			double rank = 0;
			int did;
			
			
			
			if( id.equals("")) {
				JOptionPane.showMessageDialog(this, "No Data Found id", "Insert Error", JOptionPane.WARNING_MESSAGE);
				return ;
			}else if( id.length() != 6) {
				JOptionPane.showMessageDialog(this, "Employee ID must be six digits", "Insert Error", JOptionPane.WARNING_MESSAGE);
				return ;
			}else if( ranktext.equals("")) {
				JOptionPane.showMessageDialog(this, "No Data Foundrank", "Insert Error", JOptionPane.WARNING_MESSAGE);
				return ;
			}
		
		try {
			did = Integer.parseInt(id);				
		}catch(Exception ex) {
			JOptionPane.showMessageDialog(this, "Employee ID is not valid", "Insert Error", JOptionPane.WARNING_MESSAGE);
			return;
		}
			
			
			
			
			if( name.equals("")) {
				JOptionPane.showMessageDialog(this, "Employee Name can not be null", "Insert Error", JOptionPane.WARNING_MESSAGE);
				return ;
			}else if( faculty.equals("select a type") ) {
				JOptionPane.showMessageDialog(this, "No Data Found in Faculty  ", "Please choose", JOptionPane.WARNING_MESSAGE);
				return ;
			}else if( department.equals("select a type") ) {
				JOptionPane.showMessageDialog(this, "No Data Found in Department", "Please choose", JOptionPane.WARNING_MESSAGE);
				return ;
			}else if( center.equals("select a type") ) {
				JOptionPane.showMessageDialog(this, "No Data Found in Center", "Please choose", JOptionPane.WARNING_MESSAGE);
				return ;
			}else if( building.equals("select a type") ) {
				JOptionPane.showMessageDialog(this, "No Data Found in Building", "Please choose", JOptionPane.WARNING_MESSAGE);
				return ;
			}else if( level.equals("select a type") ) {
				JOptionPane.showMessageDialog(this, "No Data Found in Level", "Please choose", JOptionPane.WARNING_MESSAGE);
				return ;
			}
			
			
			try {
				rank = Double.parseDouble(ranktext);
				
				
			}catch(Exception ex) {
				JOptionPane.showMessageDialog(this, "Inputs are not Valid, Please Check Again ", "Insert Error", JOptionPane.WARNING_MESSAGE);
				return;
			}
			int rnk = (int) rank;
			
			System.out.println(rnk);
			System.out.println(comboBox_Level_Update.getSelectedIndex()+1);
			
			if( !( rnk == comboBox_Level_Update.getSelectedIndex()+1 ) ) {			
				JOptionPane.showMessageDialog(this, "Please click on Genrated Rank", "Insert Error", JOptionPane.WARNING_MESSAGE);
				return;
			}
			
			
			UpdateUser(did, name, faculty, department, center, building, rank, level);
			
			this.refreshTableUpdate();
			
			/*textField_Name_Update.setText(null);
			textField_ID_Update.setText(null);
			refreshComboBox();
			textField_Rank_Update.setText(null);*/
			
		}
		
		if(e.getSource() == btnDelete_Update) {
			
			int id = Integer.parseInt(textField_ID_Update.getText());
			this.DeleteUser(id);
			this.refreshTableUpdate();
			
		}
		
		
		if(e.getSource() == btnGenarateRank_Update) {
			
			
			String id = textField_ID_Update.getText();
			int level =    comboBox_Level_Update.getSelectedIndex() + 1;
			double rank=0;
			
			int did;
			
			if( id.length() != 6) {
				JOptionPane.showMessageDialog(this, "Employee ID must be six digits", "Insert Error", JOptionPane.WARNING_MESSAGE);
				return ;
			}
			
			try {
				did = Integer.parseInt(id);				
			}catch(Exception ex) {
				JOptionPane.showMessageDialog(this, "Employee ID is not valid", "Insert Error", JOptionPane.WARNING_MESSAGE);
				return;
			}
			
			
			try {
				 rank = this.generateRank(did, level);
				
			}catch(Exception ex) {
				JOptionPane.showMessageDialog(this, "Rank is not generated", "Insert Error", JOptionPane.WARNING_MESSAGE);
				return;
			}
			
			textField_Rank_Update.setText(Double.toString(rank));
			
						
		}
		
		if(e.getSource() == btnRefresh_Update) {
			
			this.refreshTableUpdate();
			
		}
		
		if(e.getSource() == btnBack_Update) {
			
			TextureLookAndFeel();
			switchPanels(panelInsert);
			
		}
		
		
		
		
	}
	
	
	public double generateRank(int id, int level) {
		double rank;
		
		String textrank = level + "." + id;
		
		rank = Double.parseDouble(textrank);
		
		return rank;
		
	}
	
	public void InsertUser(int empID, String fullname, String faculty, String department, String center,
			String building, double rank, String level) {
		
		
		try {
			if(this.db.searchByEmpType("Employee_ID", empID).next() == true ) {
				showWarningMessageDialog("Employee ID has already Exists", "Insert Error");
			}else {	
				System.out.println("insert new user run");
				System.out.println(level);
				Lecture l = new Lecture( empID, fullname, faculty, department, center, building, rank, level);
				System.out.println("created");
				employee.insertEmployee(l);	
				this.showPlainMessageDialog("Successfuly Inserted", "Insert");
				
			}
		} catch (SQLException e) {	
			System.out.println("db search error");
			System.err.println("Exception :" +e.getMessage());
		}
		
		
		
		
	}
	
	
	public void UpdateUser(int empID, String fullname, String faculty, String department, String center,
			String building, double rank, String level) {
		
		int confirm;
		String changeMsg;
		Lecture lec = null;
		
		
		lec = this.db.searchLectureById(empID);
		changeMsg = "Are you sure you want to update below fields of the Employee id :" + empID + "\n\n";
		
		lec.setRank(rank);
		
		if( !( lec.getFullname().equals(fullname) ) ) {			
			changeMsg += "Employee Name : " + fullname;
			lec.setFullname(fullname);
		}
		if( !( lec.getFaculty().equals(faculty) ) ) {			
			changeMsg += "\nFaculty : " + faculty;
			lec.setFaculty(faculty);
		}
		if( !( lec.getDepartment().equals(department) ) ) {			
			changeMsg += "\nDepartment : " + department;
			lec.setDepartment(department);
		}
		if( !( lec.getCenter().equals(center) ) ) {			
			changeMsg += "\nCenter : " + center;
			lec.setCenter(center);
		}
		if( !( lec.getBuilding().equals(building) ) ) {			
			changeMsg += "\nBuilding : " + building;
			lec.setBuilding(building);
		}
		if( !( lec.getLevel().equals(level) ) ) {			
			changeMsg += "\nlevel : " + level;
			lec.setLevel(level);;
		}
		
		
		
		confirm = showConfirmMessageDialog(changeMsg, "Confirm Required");
		
		
		if( confirm == 0 ) {			
			try {				
				this.employee.updateEmployee(lec);
				showPlainMessageDialog("Successfuly Updated", "Update");
			}catch(Exception e) {
				System.err.println("Exception :" +e.getMessage());
				System.out.println("!!!!!!");
				
			}
		}
			
		
	}
	
	
	public void DeleteUser(int id) {
		
		
		int confirm;
		
		confirm = showConfirmMessageDialog("Are you sure You want to delete Empoyee id : " + id, "Confirm Required");
		
		if( confirm == 0 ) {
			try {
				employee.deleteEmployee(id);
				showMessageDialog("Successfully Employee Deleted");		
			}catch(Exception e) {
				System.err.println("Exception :" +e.getMessage());
				e.printStackTrace();
				System.out.println("!!!!!!");				
			} 
						
		}
		
		
	}
	
	
	public void refreshComboBox() {
		
		comboBox_Fac_Insert.setSelectedItem("select a type");			
		comboBox_Center_Insert.setSelectedIndex(0);
		comboBox_Dep_Insert.setSelectedItem("select a type");
		comboBox_Fac_Insert.setSelectedItem("select a type");
		comboBox_Level_Insert.setSelectedItem("select a type");
		comboBox_Buld_Insert.setSelectedItem("select a type");
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
	
	public void refreshTableUpdate() {
		
		rs = this.db.refreshEmployeeTable();
		this.table_Update.setModel(DbUtils.resultSetToTableModel(rs));
		
		textField_ID_Update.setText(null);
		textField_Name_Update.setText(null);
		textField_Rank_Update.setText(null);
		comboBox_Buld_Update.setSelectedItem(null);
		comboBox_Center_Update.setSelectedItem(null);
		comboBox_Dep_Update.setSelectedItem(null);
		comboBox_Fac__Update.setSelectedItem(null);
		comboBox_Level_Update.setSelectedItem(null);
		
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		// 
		
		if( e.getSource() == table_Update ) {
			int row = table_Update.getSelectedRow();
			int ID = Integer.parseInt((table_Update.getValueAt(row, 0)).toString());					
		
			Lecture lec = this.db.searchLectureById(ID);	
										
			textField_ID_Update.setText(Integer.toString(lec.getEmpID()));
			textField_Name_Update.setText(lec.getFullname());
			comboBox_Fac__Update.setSelectedItem(lec.getFaculty());
			comboBox_Dep_Update.setSelectedItem(lec.getDepartment());
			comboBox_Center_Update.setSelectedItem(lec.getCenter());
			comboBox_Buld_Update.setSelectedItem(lec.getBuilding());
			comboBox_Level_Update.setSelectedItem(lec.getLevel());
			textField_Rank_Update.setText(Double.toString(lec.getRank()));
		
			
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
