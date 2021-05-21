package com.FrontEnd;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.CardLayout;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.ImageIcon;

import java.awt.FlowLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.dao.WorkingDaysAndHoursDao;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.models.WorkingDaysHours;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;

public class WorkingDaysAndHours extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField textField_empID_insert;
	private JTextField textField_id_mang;
	private JPanel panelInsertWorking;
	private JPanel panelmanageWorking;
	private JButton btnNewButton_back_mng;
	private JButton btnNewButton_clear_mng;
	private JButton btnNewButton_edit_mng;
	private JButton btnNewButton_Add_Insert;
	private JButton btnNewButton_Clear_Insert;
	private JButton btnNewButton_switch_ins;
	private JLayeredPane layeredPane;
	private JCheckBox chckbxNewCheckBox_Fr_Fh;
	private JCheckBox chckbxNewCheckBox_Fr_Fd;
	private JCheckBox chckbxNewCheckBox_Mo_Fd;
	private JCheckBox chckbxNewCheckBox_Tu_Fd;
	private JCheckBox chckbxNewCheckBox_We_Fd;
	private JCheckBox chckbxNewCheckBox_Th_Fd;
	private JCheckBox chckbxNewCheckBox_We_Fh;
	private JCheckBox chckbxNewCheckBox_Mo_Fh;
	private JCheckBox chckbxNewCheckBox_Tu_Fh;
	private JCheckBox chckbxNewCheckBox_Sa_Fd;
	private JCheckBox chckbxNewCheckBox_Su_Fd;
	private JCheckBox chckbxNewCheckBox_Sa_Fh;
	private JCheckBox chckbxNewCheckBox_Su_Fh;
	private JCheckBox chckbxNewCheckBox_Mo_Sh;
	private JCheckBox chckbxNewCheckBox_We_Sh;
	private JCheckBox chckbxNewCheckBox_Th_Sh;
	private JCheckBox chckbxNewCheckBox_Fr_Sh;
	private JCheckBox chckbxNewCheckBox_Tu_Sh;
	private JCheckBox chckbxNewCheckBox_Sa_Sh;
	private JCheckBox chckbxNewCheckBox_Su_Sh;
	private JCheckBox chckbxNewCheckBox_Th_Fh;
	private JCheckBox chckbxNewCheckBox_Fr_Fh_M;
	private JCheckBox chckbxNewCheckBox_Fr_Fd_M;
	private JCheckBox chckbxNewCheckBox_Mo_Fd_M;
	private JCheckBox chckbxNewCheckBox_Tu_Fd_M;
	private JCheckBox chckbxNewCheckBox_We_Fd_M;
	private JCheckBox chckbxNewCheckBox_Th_Fd_M;
	private JCheckBox chckbxNewCheckBox_We_Fh_M;
	private JCheckBox chckbxNewCheckBox_Mo_Fh_M;
	private JCheckBox chckbxNewCheckBox_Tu_Fh_M;
	private JCheckBox chckbxNewCheckBox_Sa_Fd_M;
	private JCheckBox chckbxNewCheckBox_Su_Fd_M;
	private JCheckBox chckbxNewCheckBox_Sa_Fh_M;
	private JCheckBox chckbxNewCheckBox_Su_Fh_M;
	private JCheckBox chckbxNewCheckBox_Mo_Sh_M;
	private JCheckBox chckbxNewCheckBox_We_Sh_M;
	private JCheckBox chckbxNewCheckBox_Th_Sh_M;
	private JCheckBox chckbxNewCheckBox_Fr_Sh_M;
	private JCheckBox chckbxNewCheckBox_Tu_Sh_M;
	private JCheckBox chckbxNewCheckBox_Sa_Sh_M;
	private JCheckBox chckbxNewCheckBox_Su_Sh_M;
	private JCheckBox chckbxNewCheckBox_Th_Fh_M;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private final ButtonGroup buttonGroup_2 = new ButtonGroup();
	private final ButtonGroup buttonGroup_3 = new ButtonGroup();
	private final ButtonGroup buttonGroup_4 = new ButtonGroup();
	private final ButtonGroup buttonGroup_5 = new ButtonGroup();
	private final ButtonGroup buttonGroup_6 = new ButtonGroup();
	private JPanel Daypanel;
	private JPanel DaypanelManage;
	
	
	private WorkingDaysAndHoursDao wdh;
	private JButton btnNewButton_confirm_mng;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WorkingDaysAndHours frame = new WorkingDaysAndHours();
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
	public WorkingDaysAndHours() {
		setTitle("Working Days and Hours");
		
		wdh = new WorkingDaysAndHoursDao();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1366, 768);
		contentPane = new JPanel();
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
				dispose();
			}
		});
		btn_home.setBackground(new Color(0,0,0,0));
		btn_home.setIcon(new ImageIcon("F:\\_____SLIIT_____\\3_RD_YEAR\\IT3040______ITPM_____\\ITPMFinalWorkSpace\\TimeTable_Management_System\\TimeTableManagementSystem\\image\\Home-icon (1).png"));
		btn_home.setBounds(0, 0, 88, 80);
		contentPane.add(btn_home);
		
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(5, 5, 925, 633);
		contentPane.add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		panelInsertWorking = new JPanel();
		layeredPane.add(panelInsertWorking, "name_368922204128700");
		panelInsertWorking.setLayout(null);
		
		btnNewButton_Add_Insert = new JButton("ADD");
		btnNewButton_Add_Insert.addActionListener(this);
		btnNewButton_Add_Insert.setBounds(348, 548, 97, 25);
		panelInsertWorking.add(btnNewButton_Add_Insert);
		
		JLabel lblNewLabel = new JLabel("Employee ID");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(153, 59, 90, 16);
		panelInsertWorking.add(lblNewLabel);
		
		textField_empID_insert = new JTextField();
		textField_empID_insert.setBounds(319, 57, 171, 22);
		panelInsertWorking.add(textField_empID_insert);
		textField_empID_insert.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Monday");
		lblNewLabel_1.setBounds(64, 169, 77, 16);
		panelInsertWorking.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Tuesday");
		lblNewLabel_2.setBounds(64, 212, 77, 16);
		panelInsertWorking.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Wednesday");
		lblNewLabel_3.setBounds(64, 258, 77, 16);
		panelInsertWorking.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Thursday");
		lblNewLabel_4.setBounds(64, 306, 77, 16);
		panelInsertWorking.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Friday");
		lblNewLabel_5.setBounds(64, 350, 77, 16);
		panelInsertWorking.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Saturday");
		lblNewLabel_6.setBounds(64, 395, 77, 16);
		panelInsertWorking.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Sunday");
		lblNewLabel_7.setBounds(64, 440, 77, 16);
		panelInsertWorking.add(lblNewLabel_7);
		
		btnNewButton_Clear_Insert = new JButton("CLEAR");
		btnNewButton_Clear_Insert.addActionListener(this);
		btnNewButton_Clear_Insert.setBounds(535, 548, 97, 25);
		panelInsertWorking.add(btnNewButton_Clear_Insert);
		
		JLabel lblNewLabel_8 = new JLabel("Full Day");
		lblNewLabel_8.setBounds(243, 121, 77, 16);
		panelInsertWorking.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("First Half");
		lblNewLabel_9.setBounds(460, 121, 77, 16);
		panelInsertWorking.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Second Half");
		lblNewLabel_10.setBounds(660, 121, 77, 16);
		panelInsertWorking.add(lblNewLabel_10);
		
		JLabel lblNewLabel_12 = new JLabel("Insert Working Days And Hours");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_12.setBounds(309, 6, 301, 37);
		panelInsertWorking.add(lblNewLabel_12);
		
		Daypanel = new JPanel();
		Daypanel.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), new LineBorder(new Color(192, 192, 192), 2, true)));
		Daypanel.setBounds(178, 150, 601, 334);
		panelInsertWorking.add(Daypanel);
		Daypanel.setLayout(null);
		
		chckbxNewCheckBox_Mo_Fd = new JCheckBox("");
		chckbxNewCheckBox_Mo_Fd.setToolTipText("1");
		chckbxNewCheckBox_Mo_Fd.setBounds(84, 15, 30, 25);
		Daypanel.add(chckbxNewCheckBox_Mo_Fd);
		buttonGroup.add(chckbxNewCheckBox_Mo_Fd);
		
		chckbxNewCheckBox_Mo_Fh = new JCheckBox("");
		chckbxNewCheckBox_Mo_Fh.setToolTipText("2");
		chckbxNewCheckBox_Mo_Fh.setBounds(302, 15, 25, 25);
		Daypanel.add(chckbxNewCheckBox_Mo_Fh);
		buttonGroup.add(chckbxNewCheckBox_Mo_Fh);
		
		chckbxNewCheckBox_Tu_Fd = new JCheckBox("");
		chckbxNewCheckBox_Tu_Fd.setToolTipText("4");
		chckbxNewCheckBox_Tu_Fd.setBounds(84, 59, 21, 25);
		Daypanel.add(chckbxNewCheckBox_Tu_Fd);
		buttonGroup_1.add(chckbxNewCheckBox_Tu_Fd);
		
		chckbxNewCheckBox_We_Fd = new JCheckBox("");
		chckbxNewCheckBox_We_Fd.setToolTipText("7");
		chckbxNewCheckBox_We_Fd.setBounds(84, 106, 21, 25);
		Daypanel.add(chckbxNewCheckBox_We_Fd);
		buttonGroup_2.add(chckbxNewCheckBox_We_Fd);
		
		chckbxNewCheckBox_Th_Fd = new JCheckBox("");
		chckbxNewCheckBox_Th_Fd.setToolTipText("10");
		chckbxNewCheckBox_Th_Fd.setBounds(84, 149, 21, 25);
		Daypanel.add(chckbxNewCheckBox_Th_Fd);
		buttonGroup_3.add(chckbxNewCheckBox_Th_Fd);
		
		chckbxNewCheckBox_Fr_Fd = new JCheckBox("");
		chckbxNewCheckBox_Fr_Fd.setToolTipText("13");
		chckbxNewCheckBox_Fr_Fd.setBounds(84, 189, 21, 25);
		Daypanel.add(chckbxNewCheckBox_Fr_Fd);
		buttonGroup_4.add(chckbxNewCheckBox_Fr_Fd);
		
		chckbxNewCheckBox_Sa_Fd = new JCheckBox("");
		chckbxNewCheckBox_Sa_Fd.setToolTipText("16");
		chckbxNewCheckBox_Sa_Fd.setBounds(84, 229, 21, 25);
		Daypanel.add(chckbxNewCheckBox_Sa_Fd);
		buttonGroup_5.add(chckbxNewCheckBox_Sa_Fd);
		
		chckbxNewCheckBox_Su_Fd = new JCheckBox("");
		chckbxNewCheckBox_Su_Fd.setToolTipText("19");
		chckbxNewCheckBox_Su_Fd.setBounds(84, 272, 21, 25);
		Daypanel.add(chckbxNewCheckBox_Su_Fd);
		buttonGroup_6.add(chckbxNewCheckBox_Su_Fd);
		
		chckbxNewCheckBox_Th_Fh = new JCheckBox("");
		chckbxNewCheckBox_Th_Fh.setToolTipText("11");
		chckbxNewCheckBox_Th_Fh.setBounds(302, 149, 25, 25);
		Daypanel.add(chckbxNewCheckBox_Th_Fh);
		buttonGroup_3.add(chckbxNewCheckBox_Th_Fh);
		
		chckbxNewCheckBox_Mo_Sh = new JCheckBox("");
		chckbxNewCheckBox_Mo_Sh.setToolTipText("3");
		chckbxNewCheckBox_Mo_Sh.setBounds(500, 15, 30, 25);
		Daypanel.add(chckbxNewCheckBox_Mo_Sh);
		buttonGroup.add(chckbxNewCheckBox_Mo_Sh);
		
		chckbxNewCheckBox_Tu_Sh = new JCheckBox("");
		chckbxNewCheckBox_Tu_Sh.setToolTipText("6");
		chckbxNewCheckBox_Tu_Sh.setBounds(500, 55, 24, 25);
		Daypanel.add(chckbxNewCheckBox_Tu_Sh);
		buttonGroup_1.add(chckbxNewCheckBox_Tu_Sh);
		
		chckbxNewCheckBox_We_Sh = new JCheckBox("");
		chckbxNewCheckBox_We_Sh.setToolTipText("9");
		chckbxNewCheckBox_We_Sh.setBounds(500, 99, 24, 25);
		Daypanel.add(chckbxNewCheckBox_We_Sh);
		buttonGroup_2.add(chckbxNewCheckBox_We_Sh);
		
		chckbxNewCheckBox_Th_Sh = new JCheckBox("");
		chckbxNewCheckBox_Th_Sh.setToolTipText("12");
		chckbxNewCheckBox_Th_Sh.setBounds(500, 146, 24, 25);
		Daypanel.add(chckbxNewCheckBox_Th_Sh);
		buttonGroup_3.add(chckbxNewCheckBox_Th_Sh);
		
		chckbxNewCheckBox_Fr_Sh = new JCheckBox("");
		chckbxNewCheckBox_Fr_Sh.setToolTipText("15");
		chckbxNewCheckBox_Fr_Sh.setBounds(500, 189, 24, 25);
		Daypanel.add(chckbxNewCheckBox_Fr_Sh);
		buttonGroup_4.add(chckbxNewCheckBox_Fr_Sh);
		
		chckbxNewCheckBox_Sa_Sh = new JCheckBox("");
		chckbxNewCheckBox_Sa_Sh.setToolTipText("18");
		chckbxNewCheckBox_Sa_Sh.setBounds(500, 236, 24, 25);
		Daypanel.add(chckbxNewCheckBox_Sa_Sh);
		buttonGroup_5.add(chckbxNewCheckBox_Sa_Sh);
		
		chckbxNewCheckBox_Su_Sh = new JCheckBox("");
		chckbxNewCheckBox_Su_Sh.setToolTipText("21");
		chckbxNewCheckBox_Su_Sh.setBounds(500, 276, 24, 25);
		Daypanel.add(chckbxNewCheckBox_Su_Sh);
		buttonGroup_6.add(chckbxNewCheckBox_Su_Sh);
		
		chckbxNewCheckBox_We_Fh = new JCheckBox("");
		chckbxNewCheckBox_We_Fh.setToolTipText("8");
		chckbxNewCheckBox_We_Fh.setBounds(302, 106, 25, 25);
		Daypanel.add(chckbxNewCheckBox_We_Fh);
		buttonGroup_2.add(chckbxNewCheckBox_We_Fh);
		
		chckbxNewCheckBox_Tu_Fh = new JCheckBox("");
		chckbxNewCheckBox_Tu_Fh.setToolTipText("5");
		chckbxNewCheckBox_Tu_Fh.setBounds(302, 59, 25, 25);
		Daypanel.add(chckbxNewCheckBox_Tu_Fh);
		buttonGroup_1.add(chckbxNewCheckBox_Tu_Fh);
		
		chckbxNewCheckBox_Sa_Fh = new JCheckBox("");
		chckbxNewCheckBox_Sa_Fh.setToolTipText("17");
		chckbxNewCheckBox_Sa_Fh.setBounds(302, 236, 25, 25);
		Daypanel.add(chckbxNewCheckBox_Sa_Fh);
		buttonGroup_5.add(chckbxNewCheckBox_Sa_Fh);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 0, 1, 2);
		Daypanel.add(separator);
		
		chckbxNewCheckBox_Fr_Fh = new JCheckBox("");
		chckbxNewCheckBox_Fr_Fh.setToolTipText("14");
		chckbxNewCheckBox_Fr_Fh.setBounds(302, 189, 25, 25);
		Daypanel.add(chckbxNewCheckBox_Fr_Fh);
		buttonGroup_4.add(chckbxNewCheckBox_Fr_Fh);
		
		chckbxNewCheckBox_Su_Fh = new JCheckBox("");
		chckbxNewCheckBox_Su_Fh.setToolTipText("20");
		chckbxNewCheckBox_Su_Fh.setBounds(302, 272, 25, 25);
		Daypanel.add(chckbxNewCheckBox_Su_Fh);
		buttonGroup_6.add(chckbxNewCheckBox_Su_Fh);
		
		btnNewButton_switch_ins = new JButton("Manage Panel");
		btnNewButton_switch_ins.addActionListener(this);
		btnNewButton_switch_ins.setBounds(59, 548, 128, 25);
		panelInsertWorking.add(btnNewButton_switch_ins);
		
		panelmanageWorking = new JPanel();
		panelmanageWorking.setLayout(null);
		layeredPane.add(panelmanageWorking, "name_372382469468100");
		
		btnNewButton_back_mng = new JButton("BACK");
		btnNewButton_back_mng.addActionListener(this);
		btnNewButton_back_mng.setBounds(198, 547, 97, 25);
		panelmanageWorking.add(btnNewButton_back_mng);
		
		JLabel lblNewLabel_11 = new JLabel("Employee ID");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_11.setBounds(98, 58, 90, 16);
		panelmanageWorking.add(lblNewLabel_11);
		
		textField_id_mang = new JTextField();
		textField_id_mang.setColumns(10);
		textField_id_mang.setBounds(198, 56, 171, 22);
		panelmanageWorking.add(textField_id_mang);
		
		JLabel lblNewLabel_1_1 = new JLabel("Monday");
		lblNewLabel_1_1.setBounds(64, 169, 77, 16);
		panelmanageWorking.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("Tuesday");
		lblNewLabel_2_1.setBounds(64, 212, 77, 16);
		panelmanageWorking.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_3_1 = new JLabel("Wednesday");
		lblNewLabel_3_1.setBounds(64, 258, 77, 16);
		panelmanageWorking.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_4_1 = new JLabel("Thursday");
		lblNewLabel_4_1.setBounds(64, 306, 77, 16);
		panelmanageWorking.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_5_1 = new JLabel("Friday");
		lblNewLabel_5_1.setBounds(64, 350, 77, 16);
		panelmanageWorking.add(lblNewLabel_5_1);
		
		JLabel lblNewLabel_6_1 = new JLabel("Saturday");
		lblNewLabel_6_1.setBounds(64, 395, 77, 16);
		panelmanageWorking.add(lblNewLabel_6_1);
		
		JLabel lblNewLabel_7_1 = new JLabel("Sunday");
		lblNewLabel_7_1.setBounds(64, 440, 77, 16);
		panelmanageWorking.add(lblNewLabel_7_1);
		
		btnNewButton_clear_mng = new JButton("CLEAR");
		btnNewButton_clear_mng.addActionListener(this);
		btnNewButton_clear_mng.setBounds(511, 547, 97, 25);
		panelmanageWorking.add(btnNewButton_clear_mng);
		
		JLabel lblNewLabel_8_1 = new JLabel("Full Day");
		lblNewLabel_8_1.setBounds(243, 121, 77, 16);
		panelmanageWorking.add(lblNewLabel_8_1);
		
		JLabel lblNewLabel_9_1 = new JLabel("First Half");
		lblNewLabel_9_1.setBounds(460, 121, 77, 16);
		panelmanageWorking.add(lblNewLabel_9_1);
		
		JLabel lblNewLabel_10_1 = new JLabel("Second Half");
		lblNewLabel_10_1.setBounds(660, 121, 77, 16);
		panelmanageWorking.add(lblNewLabel_10_1);
		
		JLabel lblNewLabel_13 = new JLabel(" Manage Working Days And Hours");
		lblNewLabel_13.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_13.setBounds(334, 13, 356, 30);
		panelmanageWorking.add(lblNewLabel_13);
		
		btnNewButton_edit_mng = new JButton("EDIT");
		btnNewButton_edit_mng.addActionListener(this);
		btnNewButton_edit_mng.setBounds(681, 547, 97, 25);
		panelmanageWorking.add(btnNewButton_edit_mng);
		
		DaypanelManage = new JPanel();
		DaypanelManage.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), new LineBorder(new Color(128, 128, 128), 2, true)));
		DaypanelManage.setBounds(181, 150, 597, 356);
		panelmanageWorking.add(DaypanelManage);
		DaypanelManage.setLayout(null);
		
		chckbxNewCheckBox_Tu_Fd_M = new JCheckBox("");
		buttonGroup_1.add(chckbxNewCheckBox_Tu_Fd_M);
		chckbxNewCheckBox_Tu_Fd_M.setToolTipText("4");
		chckbxNewCheckBox_Tu_Fd_M.setBounds(73, 62, 32, 25);
		DaypanelManage.add(chckbxNewCheckBox_Tu_Fd_M);
		
		chckbxNewCheckBox_Mo_Fd_M = new JCheckBox("");
		buttonGroup.add(chckbxNewCheckBox_Mo_Fd_M);
		chckbxNewCheckBox_Mo_Fd_M.setToolTipText("1");
		chckbxNewCheckBox_Mo_Fd_M.setBounds(73, 21, 32, 25);
		DaypanelManage.add(chckbxNewCheckBox_Mo_Fd_M);
		
		chckbxNewCheckBox_Th_Fd_M = new JCheckBox("");
		buttonGroup_3.add(chckbxNewCheckBox_Th_Fd_M);
		chckbxNewCheckBox_Th_Fd_M.setToolTipText("10");
		chckbxNewCheckBox_Th_Fd_M.setBounds(73, 158, 32, 25);
		DaypanelManage.add(chckbxNewCheckBox_Th_Fd_M);
		
		chckbxNewCheckBox_Fr_Fd_M = new JCheckBox("");
		buttonGroup_4.add(chckbxNewCheckBox_Fr_Fd_M);
		chckbxNewCheckBox_Fr_Fd_M.setToolTipText("13");
		chckbxNewCheckBox_Fr_Fd_M.setBounds(73, 202, 32, 25);
		DaypanelManage.add(chckbxNewCheckBox_Fr_Fd_M);
		
		chckbxNewCheckBox_Sa_Fd_M = new JCheckBox("");
		buttonGroup_5.add(chckbxNewCheckBox_Sa_Fd_M);
		chckbxNewCheckBox_Sa_Fd_M.setToolTipText("16");
		chckbxNewCheckBox_Sa_Fd_M.setBounds(73, 247, 32, 25);
		DaypanelManage.add(chckbxNewCheckBox_Sa_Fd_M);
		
		chckbxNewCheckBox_Su_Fd_M = new JCheckBox("");
		buttonGroup_6.add(chckbxNewCheckBox_Su_Fd_M);
		chckbxNewCheckBox_Su_Fd_M.setToolTipText("19");
		chckbxNewCheckBox_Su_Fd_M.setBounds(73, 292, 32, 25);
		DaypanelManage.add(chckbxNewCheckBox_Su_Fd_M);
		
		chckbxNewCheckBox_We_Fd_M = new JCheckBox("");
		buttonGroup_2.add(chckbxNewCheckBox_We_Fd_M);
		chckbxNewCheckBox_We_Fd_M.setToolTipText("7");
		chckbxNewCheckBox_We_Fd_M.setBounds(73, 108, 32, 25);
		DaypanelManage.add(chckbxNewCheckBox_We_Fd_M);
		
		chckbxNewCheckBox_Mo_Fh_M = new JCheckBox("");
		buttonGroup.add(chckbxNewCheckBox_Mo_Fh_M);
		chckbxNewCheckBox_Mo_Fh_M.setToolTipText("2");
		chckbxNewCheckBox_Mo_Fh_M.setBounds(290, 21, 28, 25);
		DaypanelManage.add(chckbxNewCheckBox_Mo_Fh_M);
		
		chckbxNewCheckBox_Tu_Fh_M = new JCheckBox("");
		buttonGroup_1.add(chckbxNewCheckBox_Tu_Fh_M);
		chckbxNewCheckBox_Tu_Fh_M.setToolTipText("5");
		chckbxNewCheckBox_Tu_Fh_M.setBounds(290, 64, 28, 25);
		DaypanelManage.add(chckbxNewCheckBox_Tu_Fh_M);
		
		chckbxNewCheckBox_We_Fh_M = new JCheckBox("");
		buttonGroup_2.add(chckbxNewCheckBox_We_Fh_M);
		chckbxNewCheckBox_We_Fh_M.setToolTipText("8");
		chckbxNewCheckBox_We_Fh_M.setBounds(290, 110, 28, 25);
		DaypanelManage.add(chckbxNewCheckBox_We_Fh_M);
		
		chckbxNewCheckBox_Th_Fh_M = new JCheckBox("");
		buttonGroup_3.add(chckbxNewCheckBox_Th_Fh_M);
		chckbxNewCheckBox_Th_Fh_M.setToolTipText("11");
		chckbxNewCheckBox_Th_Fh_M.setBounds(290, 158, 28, 25);
		DaypanelManage.add(chckbxNewCheckBox_Th_Fh_M);
		
		chckbxNewCheckBox_Fr_Fh_M = new JCheckBox("");
		buttonGroup_4.add(chckbxNewCheckBox_Fr_Fh_M);
		chckbxNewCheckBox_Fr_Fh_M.setToolTipText("14");
		chckbxNewCheckBox_Fr_Fh_M.setBounds(290, 202, 28, 25);
		DaypanelManage.add(chckbxNewCheckBox_Fr_Fh_M);
		
		chckbxNewCheckBox_Sa_Fh_M = new JCheckBox("");
		buttonGroup_5.add(chckbxNewCheckBox_Sa_Fh_M);
		chckbxNewCheckBox_Sa_Fh_M.setToolTipText("17");
		chckbxNewCheckBox_Sa_Fh_M.setBounds(290, 251, 28, 25);
		DaypanelManage.add(chckbxNewCheckBox_Sa_Fh_M);
		
		chckbxNewCheckBox_Su_Fh_M = new JCheckBox("");
		buttonGroup_6.add(chckbxNewCheckBox_Su_Fh_M);
		chckbxNewCheckBox_Su_Fh_M.setToolTipText("20");
		chckbxNewCheckBox_Su_Fh_M.setBounds(290, 297, 28, 25);
		DaypanelManage.add(chckbxNewCheckBox_Su_Fh_M);
		
		chckbxNewCheckBox_Su_Sh_M = new JCheckBox("");
		buttonGroup_6.add(chckbxNewCheckBox_Su_Sh_M);
		chckbxNewCheckBox_Su_Sh_M.setToolTipText("21");
		chckbxNewCheckBox_Su_Sh_M.setBounds(494, 292, 25, 25);
		DaypanelManage.add(chckbxNewCheckBox_Su_Sh_M);
		
		chckbxNewCheckBox_Sa_Sh_M = new JCheckBox("");
		buttonGroup_5.add(chckbxNewCheckBox_Sa_Sh_M);
		chckbxNewCheckBox_Sa_Sh_M.setToolTipText("18");
		chckbxNewCheckBox_Sa_Sh_M.setBounds(494, 250, 25, 25);
		DaypanelManage.add(chckbxNewCheckBox_Sa_Sh_M);
		
		chckbxNewCheckBox_Fr_Sh_M = new JCheckBox("");
		buttonGroup_4.add(chckbxNewCheckBox_Fr_Sh_M);
		chckbxNewCheckBox_Fr_Sh_M.setToolTipText("15");
		chckbxNewCheckBox_Fr_Sh_M.setBounds(494, 202, 25, 25);
		DaypanelManage.add(chckbxNewCheckBox_Fr_Sh_M);
		
		chckbxNewCheckBox_Th_Sh_M = new JCheckBox("");
		buttonGroup_3.add(chckbxNewCheckBox_Th_Sh_M);
		chckbxNewCheckBox_Th_Sh_M.setToolTipText("12");
		chckbxNewCheckBox_Th_Sh_M.setBounds(494, 158, 25, 25);
		DaypanelManage.add(chckbxNewCheckBox_Th_Sh_M);
		
		chckbxNewCheckBox_We_Sh_M = new JCheckBox("");
		buttonGroup_2.add(chckbxNewCheckBox_We_Sh_M);
		chckbxNewCheckBox_We_Sh_M.setToolTipText("9");
		chckbxNewCheckBox_We_Sh_M.setBounds(494, 110, 25, 25);
		DaypanelManage.add(chckbxNewCheckBox_We_Sh_M);
		
		chckbxNewCheckBox_Tu_Sh_M = new JCheckBox("");
		buttonGroup_1.add(chckbxNewCheckBox_Tu_Sh_M);
		chckbxNewCheckBox_Tu_Sh_M.setToolTipText("6");
		chckbxNewCheckBox_Tu_Sh_M.setBounds(494, 64, 25, 25);
		DaypanelManage.add(chckbxNewCheckBox_Tu_Sh_M);
		
		chckbxNewCheckBox_Mo_Sh_M = new JCheckBox("");
		buttonGroup.add(chckbxNewCheckBox_Mo_Sh_M);
		chckbxNewCheckBox_Mo_Sh_M.setToolTipText("3");
		chckbxNewCheckBox_Mo_Sh_M.setBounds(494, 21, 25, 25);
		DaypanelManage.add(chckbxNewCheckBox_Mo_Sh_M);
		
		btnNewButton_confirm_mng = new JButton("CONFIRM");
		btnNewButton_confirm_mng.addActionListener(this);
		btnNewButton_confirm_mng.setBounds(348, 547, 97, 25);
		panelmanageWorking.add(btnNewButton_confirm_mng);
		
		AcrylLookAndFeel();
	}
	
	public void lookAndFeelYellowBack() {
		try {
	        //here you can put the selected theme class name in JTattoo
	        UIManager.setLookAndFeel("com.jtattoo.plaf.bernstein.BernsteinLookAndFeel");
	        SwingUtilities.updateComponentTreeUI(this);

	    } catch (ClassNotFoundException ex) {
	        java.util.logging.Logger.getLogger(WorkingDaysAndHours.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	    } catch (InstantiationException ex) {
	        java.util.logging.Logger.getLogger(WorkingDaysAndHours.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	    } catch (IllegalAccessException ex) {
	        java.util.logging.Logger.getLogger(WorkingDaysAndHours.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
	        java.util.logging.Logger.getLogger(WorkingDaysAndHours.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	    }		
	}
	
	public void AcrylLookAndFeel() {
		
		try {
	        //here you can put the selected theme class name in JTattoo
	        UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
	        SwingUtilities.updateComponentTreeUI(this);

	    } catch (ClassNotFoundException ex) {
	        java.util.logging.Logger.getLogger(WorkingDaysAndHours.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	    } catch (InstantiationException ex) {
	        java.util.logging.Logger.getLogger(WorkingDaysAndHours.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	    } catch (IllegalAccessException ex) {
	        java.util.logging.Logger.getLogger(WorkingDaysAndHours.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
	        java.util.logging.Logger.getLogger(WorkingDaysAndHours.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	    }
		
	}
	
	
	public void LunaLookAndFeel() {
		
		try {
	        //here you can put the selected theme class name in JTattoo
	        UIManager.setLookAndFeel("com.jtattoo.plaf.luna.LunaLookAndFeel");
	        SwingUtilities.updateComponentTreeUI(this);

	    } catch (ClassNotFoundException ex) {
	        java.util.logging.Logger.getLogger(WorkingDaysAndHours.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	    } catch (InstantiationException ex) {
	        java.util.logging.Logger.getLogger(WorkingDaysAndHours.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	    } catch (IllegalAccessException ex) {
	        java.util.logging.Logger.getLogger(WorkingDaysAndHours.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
	        java.util.logging.Logger.getLogger(WorkingDaysAndHours.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	    }
		
	}
	
	
	public void switchPanels(JPanel panel) {
		layeredPane.removeAll();		
		layeredPane.add(panel);
		layeredPane.repaint();
		layeredPane.revalidate();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// 
		
		if( e.getSource() == btnNewButton_Add_Insert ) {
			
			
			String id = textField_empID_insert.getText();
			//String result="";
			if( id.equals("")) {
				JOptionPane.showMessageDialog(this, "Please Enter a Employee ID", "Insert Error", JOptionPane.WARNING_MESSAGE);
				return ;
				
			}
			
			
			
			ArrayList<Integer>days =  new ArrayList<Integer>();
			
			
			
			for (Component c : Daypanel.getComponents()) {
				if (c.getClass().equals(JCheckBox.class)) {
					JCheckBox jck = (JCheckBox) c;
					if (jck.isSelected()) {
						//result += jck.getToolTipText() + ",";
						days.add(Integer.parseInt(jck.getToolTipText()));
					
					}
				}
				//System.out.println(y);
				//System.out.println(result);
			}
				//System.out.println(result);
			
			Collections.sort(days);
			try {
				
				for(int x : days){
					System.out.println(x);
					
					String s= "";
					
					if(x == WorkingDaysHours.MonFullDay) {
						s = "MonFullDay";
					}else if(x == WorkingDaysHours.MonFirstHalf) {
						s = "MonFirstHalf";
					}else if(x == WorkingDaysHours.MonSecondHalf) {
						s = "MonSecondHalf";
					}
					
					else if(x == WorkingDaysHours.TueFullDay) {
						s = "TueFullDay";
					}else if(x == WorkingDaysHours.TueFirstHalf) {
						s = "TueFirstHalf";
					}else if(x == WorkingDaysHours.TueSecondHalf) {
						s = "TueSecondHalf";
					}
					
					else if(x == WorkingDaysHours.WedFullDay) {
						s = "WedFullDay";
					}else if(x == WorkingDaysHours.WedFirstHalf) {
						s = "WedFirstHalf";
					}else if(x == WorkingDaysHours.WedSecondHalf) {
						s = "WedSecondHalf";
					}
					
					else if(x == WorkingDaysHours.ThurFullDay) {
						s = "ThurFullDay";
					}else if(x == WorkingDaysHours.ThurFirstHalf) {
						s = "ThurFirstHalf";
					}else if(x == WorkingDaysHours.ThurSecondHalf) {
						s = "ThurSecondHalf";
					}
					
					else if(x == WorkingDaysHours.FriFullDay) {
						s = "FriFullDay";
					}else if(x == WorkingDaysHours.FriFirstHalf) {
						s = "FriFirstHalf";
					}else if(x == WorkingDaysHours.FriSecondHalf) {
						s = "FriSecondHalf";
					}
					
					else if(x == WorkingDaysHours.SatFullDay) {
						s = "SatFullDay";
					}else if(x == WorkingDaysHours.SatFirstHalf) {
						s = "SatFirstHalf";
					}else if(x == WorkingDaysHours.SatSecondHalf) {
						s = "SatSecondHalf";
					}
					
					else if(x == WorkingDaysHours.SunFullDay) {
						s = "SunFullDay";
					}else if(x == WorkingDaysHours.SunFirstHalf) {
						s = "SunFirstHalf";
					}else if(x == WorkingDaysHours.SunSecondHalf) {
						s = "SunSecondHalf";
					}
					
					 
					this.wdh.insertworkingDays(id, s);
				 
				}
				
				this.showPlainMessageDialog("Successfuly Inserted", "Insert");
			
			}catch (SQLException e1) {
					// 
					e1.printStackTrace();
			}
		
			buttonGroup.clearSelection();
			buttonGroup_1.clearSelection();
			buttonGroup_2.clearSelection();
			buttonGroup_3.clearSelection();
			buttonGroup_4.clearSelection();
			buttonGroup_5.clearSelection();
			buttonGroup_6.clearSelection();
			textField_empID_insert.setText(null);
					
			
 	switchPanels(panelmanageWorking);
			
			
		}
		
		
		if( e.getSource() == btnNewButton_clear_mng ) {
			
			buttonGroup.clearSelection();
			buttonGroup_1.clearSelection();
			buttonGroup_2.clearSelection();
			buttonGroup_3.clearSelection();
			buttonGroup_4.clearSelection();
			buttonGroup_5.clearSelection();
			buttonGroup_6.clearSelection();
			textField_id_mang.setText(null);
			
		}
		
		if( e.getSource() == btnNewButton_Clear_Insert ) {

			buttonGroup.clearSelection();
			buttonGroup_1.clearSelection();
			buttonGroup_2.clearSelection();
			buttonGroup_3.clearSelection();
			buttonGroup_4.clearSelection();
			buttonGroup_5.clearSelection();
			buttonGroup_6.clearSelection();
			textField_empID_insert.setText(null);
		}
		
		
		if( e.getSource() == btnNewButton_edit_mng ) {
			
			String empID = textField_id_mang.getText();
			ArrayList<String> det=null;
			
			
			try {
				 det = this.getWorkingDaysAndHoursList(empID);
			} catch (Exception e2) {
				// 
				JOptionPane.showMessageDialog(this, "Employee ID is not Exists. Please check ", "Insert Error", JOptionPane.WARNING_MESSAGE);
				return;
				
			}
			
			
			for(String day : det) {
				
				if(day.equalsIgnoreCase("MonFullDay")) {
					chckbxNewCheckBox_Mo_Fd_M.setSelected(true);
				}
				else if(day.equalsIgnoreCase("MonFirstHalf")) {
					chckbxNewCheckBox_Mo_Fh_M.setSelected(true);
				}
				else if(day.equalsIgnoreCase("MonSecondHalf")) {
					chckbxNewCheckBox_Mo_Sh_M.setSelected(true);
				}
				
				
				if(day.equalsIgnoreCase("TueFullDay")) {
					chckbxNewCheckBox_Tu_Fd_M.setSelected(true);
				}
				else if(day.equalsIgnoreCase("TueFirstHalf")) {
					chckbxNewCheckBox_Tu_Fh_M.setSelected(true);
				}
				else if(day.equalsIgnoreCase("TueSecondHalf")) {
					chckbxNewCheckBox_Tu_Sh_M.setSelected(true);
				}
				
				if(day.equalsIgnoreCase("WedFullDay")) {
					chckbxNewCheckBox_We_Fd_M.setSelected(true);
				}
				else if(day.equalsIgnoreCase("WedFirstHalf")) {
					chckbxNewCheckBox_We_Fh_M.setSelected(true);
				}
				else if(day.equalsIgnoreCase("WedSecondHalf")) {
					chckbxNewCheckBox_We_Sh_M.setSelected(true);
				}
				
				if(day.equalsIgnoreCase("ThurFullDay")) {
					chckbxNewCheckBox_Th_Fd_M.setSelected(true);
				}
				else if(day.equalsIgnoreCase("ThurFirstHalf")) {
					chckbxNewCheckBox_Th_Fh_M.setSelected(true);
				}
				else if(day.equalsIgnoreCase("ThurSecondHalf")) {
					chckbxNewCheckBox_Th_Sh_M.setSelected(true);
				}
				
				if(day.equalsIgnoreCase("FriFullDay")) {
					chckbxNewCheckBox_Fr_Fd_M.setSelected(true);
				}
				else if(day.equalsIgnoreCase("FriFirstHalf")) {
					chckbxNewCheckBox_Fr_Fh_M.setSelected(true);
				}
				else if(day.equalsIgnoreCase("FriSecondHalf")) {
					chckbxNewCheckBox_Fr_Sh_M.setSelected(true);
				}
				
				if(day.equalsIgnoreCase("SatFullDay")) {
					chckbxNewCheckBox_Sa_Fd_M.setSelected(true);
				}
				else if(day.equalsIgnoreCase("SatFirstHalf")) {
					chckbxNewCheckBox_Sa_Fh_M.setSelected(true);
				}
				else if(day.equalsIgnoreCase("SatSecondHalf")) {
					chckbxNewCheckBox_Sa_Sh_M.setSelected(true);
				}
				
				if(day.equalsIgnoreCase("SunFullDay")) {
					chckbxNewCheckBox_Su_Fd_M.setSelected(true);
				}
				else if(day.equalsIgnoreCase("SunFirstHalf")) {
					chckbxNewCheckBox_Su_Fh_M.setSelected(true);
				}
				else if(day.equalsIgnoreCase("SunSecondHalf")) {
					chckbxNewCheckBox_Su_Sh_M.setSelected(true);
				}
				
				
				
			}
			
			
			
		}
		
		
		if( e.getSource() == btnNewButton_switch_ins ) {
			lookAndFeelYellowBack();
			switchPanels(panelmanageWorking);
			
		}
		
		if( e.getSource() == btnNewButton_back_mng ) {
			AcrylLookAndFeel();
			switchPanels(panelInsertWorking);
			
		}
		
		
		
		if( e.getSource() == btnNewButton_confirm_mng ) {
			
			String id = textField_id_mang.getText();
			
			//String result="";
			
			
			ArrayList<Integer>days =  new ArrayList<Integer>();
			
			try {
				this.wdh.deleteworkingDays(id);
			} catch (SQLException e2) {
				// 
				e2.printStackTrace();
			}
			
			for (Component c : DaypanelManage.getComponents()) {
				if (c.getClass().equals(JCheckBox.class)) {
					JCheckBox jck = (JCheckBox) c;
					if (jck.isSelected()) {
						//result += jck.getToolTipText() + ",";
						days.add(Integer.parseInt(jck.getToolTipText()));
					 
					}
				}
				//System.out.println(y);
				//System.out.println(result);
			}
				//System.out.println(result);
			
			Collections.sort(days);
			
			try {			
				
				
				for(int x : days){
					System.out.println(x);
					
					String s= "";
					
					if(x == WorkingDaysHours.MonFullDay) {
						s = "MonFullDay";
					}else if(x == WorkingDaysHours.MonFirstHalf) {
						s = "MonFirstHalf";
					}else if(x == WorkingDaysHours.MonSecondHalf) {
						s = "MonSecondHalf";
					}
					
					else if(x == WorkingDaysHours.TueFullDay) {
						s = "TueFullDay";
					}else if(x == WorkingDaysHours.TueFirstHalf) {
						s = "TueFirstHalf";
					}else if(x == WorkingDaysHours.TueSecondHalf) {
						s = "TueSecondHalf";
					}
					
					else if(x == WorkingDaysHours.WedFullDay) {
						s = "WedFullDay";
					}else if(x == WorkingDaysHours.WedFirstHalf) {
						s = "WedFirstHalf";
					}else if(x == WorkingDaysHours.WedSecondHalf) {
						s = "WedSecondHalf";
					}
					
					else if(x == WorkingDaysHours.ThurFullDay) {
						s = "ThurFullDay";
					}else if(x == WorkingDaysHours.ThurFirstHalf) {
						s = "ThurFirstHalf";
					}else if(x == WorkingDaysHours.ThurSecondHalf) {
						s = "ThurSecondHalf";
					}
					
					else if(x == WorkingDaysHours.FriFullDay) {
						s = "FriFullDay";
					}else if(x == WorkingDaysHours.FriFirstHalf) {
						s = "FriFirstHalf";
					}else if(x == WorkingDaysHours.FriSecondHalf) {
						s = "FriSecondHalf";
					}
					
					else if(x == WorkingDaysHours.SatFullDay) {
						s = "SatFullDay";
					}else if(x == WorkingDaysHours.SatFirstHalf) {
						s = "SatFirstHalf";
					}else if(x == WorkingDaysHours.SatSecondHalf) {
						s = "SatSecondHalf";
					}
					
					else if(x == WorkingDaysHours.SunFullDay) {
						s = "SunFullDay";
					}else if(x == WorkingDaysHours.SunFirstHalf) {
						s = "SunFirstHalf";
					}else if(x == WorkingDaysHours.SunSecondHalf) {
						s = "SunSecondHalf";
					}
					
					 
					this.wdh.insertworkingDays(id, s);
				 
					
			
				}
				
				showPlainMessageDialog("Successfuly Updated", "Update");
				
				
				}catch (SQLException e1) {
			// 
					e1.printStackTrace();
				}
		
		
		}
		
		
		
	}
	
	
	
	public ArrayList<String> getWorkingDaysAndHoursList(String id) throws Exception  {
		
		ArrayList<String> det = new ArrayList<String>();
				
		det = wdh.getWorkingDaysList(id);
				
		
		return det;
	}
	
	
	public void showPlainMessageDialog(String message, String title) {
		JOptionPane.showMessageDialog(getParent(), message, title, JOptionPane.PLAIN_MESSAGE);
	}
}

/*
		
		JPanel panel_manage = new JPanel();
		panel_manage.setBounds(0, 0, 1350, 729);
		frame.getContentPane().add(panel_manage);
		
		JLabel lblNewLabel = new JLabel("Select Lecture");
		lblNewLabel.setBounds(53, 132, 120, 30);
		panel_allocation.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Select Group");
		lblNewLabel_1.setBounds(305, 132, 120, 30);
		panel_allocation.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Select Sub Group");
		lblNewLabel_2.setBounds(53, 222, 120, 30);
		panel_allocation.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Select Session ID");
		lblNewLabel_3.setBounds(305, 222, 120, 30);
		panel_allocation.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Time");
		lblNewLabel_4.setBounds(68, 316, 79, 20);
		panel_allocation.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Hours");
		lblNewLabel_5.setBounds(207, 320, 40, 13);
		panel_allocation.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Minutes");
		lblNewLabel_6.setBounds(305, 320, 52, 13);
		panel_allocation.add(lblNewLabel_6);
		
		JComboBox comboLec = new JComboBox();
		comboLec.setBounds(179, 132, 110, 30);
		panel_allocation.add(comboLec);
		
		JComboBox comboGroup = new JComboBox();
		comboGroup.setBounds(435, 132, 110, 30);
		panel_allocation.add(comboGroup);
		
		JComboBox comboSub = new JComboBox();
		comboSub.setBounds(179, 222, 110, 30);
		panel_allocation.add(comboSub);
		
		JComboBox comboSID = new JComboBox();
		comboSID.setBounds(435, 226, 110, 30);
		panel_allocation.add(comboSID);
		
		JSpinner spinnerH = new JSpinner();
		spinnerH.setBounds(157, 317, 46, 20);
		panel_allocation.add(spinnerH);
		
		JSpinner spinnerM = new JSpinner();
		spinnerM.setBounds(255, 317, 46, 20);
		panel_allocation.add(spinnerM);
		
		JButton btnSub = new JButton("SUBMIT");
		btnSub.setBounds(225, 370, 120, 30);
		panel_allocation.add(btnSub);
		
		JButton btnView = new JButton("VIEW");
		btnView.setBounds(135, 445, 85, 21);
		panel_allocation.add(btnView);
		
		JButton btnClear = new JButton("CLEAR");
		btnClear.setBounds(355, 445, 85, 21);
		panel_allocation.add(btnClear);

*/