package com.FrontEnd;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import stu.Cons_ss;
import stu.Non_Overlapping;
import stu.Parl_S;
import stu.Stu_grpt;
import stu.Tag_sub;

import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuItem;

public class MainPanel_Home {

	private JFrame frmHome;
	
	private JPanel sess;
	private JPanel Static;
	private JPanel time;
	private JPanel loction;
	private JPanel tag;
	private JPanel sub;
	private JPanel stu;
	private JPanel lec;
	

	private JLabel lbl_Static;
	private JLabel lbl_Time;
	private JLabel lbl_Loc;
	private JLabel lbl_Tag;
	private JLabel lbl_stu;
	private JLabel lbl_Sub;
	private JLabel lbl_Lec;
	private JLabel lbl_sess;
	private JLabel lblNewLabel;
	private JMenu mnNotAvailable;
	private JMenuItem menu_time;
	private JMenuItem meny_location;
	private JMenuItem menu_conss;
	private JMenuItem menu_Parallel;
	private JMenuItem menu_nonOverlap;
	private JMenuItem menu_session;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainPanel_Home window = new MainPanel_Home();
					window.frmHome.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainPanel_Home() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frmHome = new JFrame();
		frmHome.setTitle("Home");
		frmHome.getContentPane().setBackground(Color.BLACK);
		frmHome.setBounds(0, 0, 1366, 768);
		frmHome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmHome.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(0,0,1366,718);
		frmHome.getContentPane().add(panel);
		panel.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(1080, 35, 258, 100);
		panel.add(menuBar);
		
		mnNotAvailable = new JMenu("NOT AVAILABLE");
		mnNotAvailable.setForeground(Color.BLACK);
		mnNotAvailable.setFont(new Font("Dialog", Font.BOLD, 15));
		mnNotAvailable.setIcon(new ImageIcon("F:\\_____SLIIT_____\\3_RD_YEAR\\IT3040______ITPM_____\\ITPMFinalWorkSpace\\TimeTable_Management_System\\TimeTableManagementSystem\\image\\Configuration-icon (1).png"));
		menuBar.add(mnNotAvailable);
		
		menu_time = new JMenuItem("Manage Not-Available Time");
		menu_time.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddNotAvalable obj = new AddNotAvalable();
				obj.main(null);
				frmHome.dispose();
			}
		});
		mnNotAvailable.add(menu_time);
		
		meny_location = new JMenuItem("Manage Eit Location");
		meny_location.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddEditLocation obj = new AddEditLocation();
				obj.main(null);
				frmHome.dispose();
			}
		});
		mnNotAvailable.add(meny_location);
		
		menu_conss = new JMenuItem("Create Conseccutive Sessions");
		menu_conss.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Cons_ss obj = new Cons_ss();
				obj.main(null);
				frmHome.dispose();
			}
		});
		mnNotAvailable.add(menu_conss);
		
		menu_Parallel = new JMenuItem("Create Paralle Sessions");
		menu_Parallel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Parl_S obj = new Parl_S();
				obj.main(null);
				frmHome.dispose();
			}
		});
		mnNotAvailable.add(menu_Parallel);
		
		menu_nonOverlap = new JMenuItem("Create Non - Overlapping Session");
		menu_nonOverlap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Non_Overlapping obj = new Non_Overlapping();
				obj.main(null);
				frmHome.dispose();
			}
		});
		mnNotAvailable.add(menu_nonOverlap);
		
		menu_session = new JMenuItem("Manage Session Room");
		menu_session.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Non_Overlapping obj = new Non_Overlapping();
				obj.main(null);
				frmHome.dispose();
			}
		});
		mnNotAvailable.add(menu_session);
		
		Static = new JPanel();
		Static.setLayout(null);
		Static.setBackground(new Color(0, 0, 0, 0));
		Static.setBounds(21, 577, 582, 130);
		panel.add(Static);
		
		lbl_Static = new JLabel("Statistic Reviwe");
		lbl_Static.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				AddLecturer sup = new AddLecturer();
				AddLecturer.main(null);
				frmHome.setVisible(false);
			}
		});
		lbl_Static.setIcon(new ImageIcon("F:\\_____SLIIT_____\\3_RD_YEAR\\IT3040______ITPM_____\\TimeManagmentSystem\\TimeTableManagementSystem\\image\\static.png"));
		lbl_Static.setForeground(Color.WHITE);
		lbl_Static.setFont(new Font("Dialog", Font.BOLD, 40));
		lbl_Static.setBounds(10, 11, 536, 128);
		Static.add(lbl_Static);
		
		time = new JPanel();
		time.setLayout(null);
		time.setBackground(new Color(0, 0, 0, 0));
		time.setBounds(683, 441, 582, 141);
		panel.add(time);
		
		lbl_Time = new JLabel("Working Days & Hours");
		lbl_Time.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				WorkingDaysAndHours sup = new WorkingDaysAndHours();
				WorkingDaysAndHours.main(null);
				frmHome.setVisible(false);
			}
		});
		lbl_Time.setIcon(new ImageIcon("F:\\_____SLIIT_____\\3_RD_YEAR\\IT3040______ITPM_____\\TimeManagmentSystem\\TimeTableManagementSystem\\image\\time.png"));
		lbl_Time.setForeground(Color.WHITE);
		lbl_Time.setFont(new Font("Dialog", Font.BOLD, 40));
		lbl_Time.setBounds(0, 0, 572, 136);
		time.add(lbl_Time);
		
		loction = new JPanel();
		loction.setLayout(null);
		loction.setBackground(new Color(0, 0, 0, 0));
		loction.setBounds(21, 447, 582, 119);
		panel.add(loction);
		
		lbl_Loc = new JLabel("Loction Registration");
		lbl_Loc.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				AddLecturer sup = new AddLecturer();
				AddLecturer.main(null);
				frmHome.setVisible(false);
			}
		});
		lbl_Loc.setIcon(new ImageIcon("F:\\_____SLIIT_____\\3_RD_YEAR\\IT3040______ITPM_____\\TimeManagmentSystem\\TimeTableManagementSystem\\image\\loc.png"));
		lbl_Loc.setForeground(Color.WHITE);
		lbl_Loc.setFont(new Font("Dialog", Font.BOLD, 40));
		lbl_Loc.setBounds(10, 0, 536, 117);
		loction.add(lbl_Loc);
		
		tag = new JPanel();
		tag.setLayout(null);
		tag.setBackground(new Color(0, 0, 0, 0));
		tag.setBounds(683, 311, 582, 119);
		panel.add(tag);
		
		lbl_Tag = new JLabel("Tag Registration");
		lbl_Tag.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				Tag_sub sup = new Tag_sub();
				Tag_sub.main(null);
				frmHome.setVisible(false);
			}
		});
		lbl_Tag.setIcon(new ImageIcon("F:\\_____SLIIT_____\\3_RD_YEAR\\IT3040______ITPM_____\\TimeManagmentSystem\\TimeTableManagementSystem\\image\\tag.png"));
		lbl_Tag.setForeground(Color.WHITE);
		lbl_Tag.setFont(new Font("Dialog", Font.BOLD, 40));
		lbl_Tag.setBounds(0, 0, 536, 114);
		tag.add(lbl_Tag);
		
		sub = new JPanel();
		sub.setLayout(null);
		sub.setBackground(new Color(0, 0, 0, 0));
		sub.setBounds(21, 318, 582, 105);
		panel.add(sub);
		
		lbl_Sub = new JLabel("Subject Registration");
		lbl_Sub.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				AddSubject sup = new AddSubject();
				AddSubject.main(null);
				frmHome.setVisible(false);
				
			}
		});
		lbl_Sub.setIcon(new ImageIcon("F:\\_____SLIIT_____\\3_RD_YEAR\\IT3040______ITPM_____\\TimeManagmentSystem\\TimeTableManagementSystem\\image\\sub.png"));
		lbl_Sub.setForeground(Color.WHITE);
		lbl_Sub.setFont(new Font("Dialog", Font.BOLD, 40));
		lbl_Sub.setBounds(0, 0, 536, 107);
		sub.add(lbl_Sub);
		
		stu = new JPanel();
		stu.setLayout(null);
		stu.setBackground(new Color(0, 0, 0, 0));
		stu.setBounds(683, 175, 582, 125);
		panel.add(stu);
		
		lbl_stu = new JLabel("Student Registration");
		lbl_stu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				Stu_grpt sup = new Stu_grpt();
				Stu_grpt.main(null);
				frmHome.setVisible(false);
			}
		});
		lbl_stu.setIcon(new ImageIcon("F:\\_____SLIIT_____\\3_RD_YEAR\\IT3040______ITPM_____\\TimeManagmentSystem\\TimeTableManagementSystem\\image\\stu.png"));
		lbl_stu.setForeground(Color.WHITE);
		lbl_stu.setFont(new Font("Dialog", Font.BOLD, 40));
		lbl_stu.setBounds(0, 0, 536, 128);
		stu.add(lbl_stu);
		
		lec = new JPanel();
		lec.setLayout(null);
		lec.setBackground(new Color(0, 0, 0, 0));
		lec.setBounds(21, 162, 582, 130);
		panel.add(lec);
		
		lbl_Lec = new JLabel("Lecture Registration");
		lbl_Lec.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				AddLecturer sup = new AddLecturer();
				AddLecturer.main(null);
				frmHome.setVisible(false);
				
			}
		});
		lbl_Lec.setIcon(new ImageIcon("F:\\_____SLIIT_____\\3_RD_YEAR\\IT3040______ITPM_____\\TimeManagmentSystem\\TimeTableManagementSystem\\image\\lec.png"));
		lbl_Lec.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Lec.setForeground(Color.WHITE);
		lbl_Lec.setFont(new Font("Dialog", Font.BOLD, 40));
		lbl_Lec.setBounds(0, 0, 536, 128);
		lec.add(lbl_Lec);
		
		sess = new JPanel();
		sess.setLayout(null);
		sess.setBackground(new Color(0, 0, 0, 0));
		sess.setBounds(683, 593, 582, 114);
		panel.add(sess);
		
		lbl_sess = new JLabel("Manage Session ");
		lbl_sess.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				AddSession sup = new AddSession();
				AddSession.main(null);
				frmHome.setVisible(false);
			}
		});
		lbl_sess.setIcon(new ImageIcon("F:\\_____SLIIT_____\\3_RD_YEAR\\IT3040______ITPM_____\\TimeManagmentSystem\\TimeTableManagementSystem\\image\\sess.png"));
		lbl_sess.setBounds(10, 0, 536, 108);
		sess.add(lbl_sess);
		lbl_sess.setForeground(Color.WHITE);
		lbl_sess.setFont(new Font("Dialog", Font.BOLD, 40));
		
		lblNewLabel = new JLabel("ABC INSTITUTE TIME TABLE ");
		lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD | Font.ITALIC, 43));
		lblNewLabel.setBounds(312, 11, 592, 81);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("MANAGEMENT SYSTEM");
		lblNewLabel_2.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel_2.setBounds(391, 61, 375, 49);
		panel.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TimeTable obj = new TimeTable();
				obj.main(null);
			}
		});
		btnNewButton.setIcon(new ImageIcon("F:\\_____SLIIT_____\\3_RD_YEAR\\IT3040______ITPM_____\\ITPMFinalWorkSpace\\TimeTable_Management_System\\TimeTableManagementSystem\\image\\Generate-tables-icon.png"));
		btnNewButton.setBounds(84, 36, 128, 99);
		panel.add(btnNewButton);
		
		JLabel txt_timetable = new JLabel("");
		txt_timetable.setForeground(Color.WHITE);
		txt_timetable.setIcon(new ImageIcon("F:\\_____SLIIT_____\\3_RD_YEAR\\IT3040______ITPM_____\\TimeManagmentSystem\\TimeTableManagementSystem\\image\\wfDvqk.jpeg"));
		txt_timetable.setBounds(10, 11, 1330, 707);
		panel.add(txt_timetable);
		
	}
}
