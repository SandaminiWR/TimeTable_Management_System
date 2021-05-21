package stu;

import java.awt.Color;
//import java.awt.Component;
//import java.awt.Container;
import java.awt.EventQueue;
import java.sql.*;

import javax.swing.JFrame;
//import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import com.FrontEnd.MainPanel_Home;

import java.awt.Font;
//import javax.swing.JEditorPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class Tag_sub {

	private JFrame frmCreateTags;
	private JTextField txtTagName;
	private JTextField txtTagCode;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tag_sub window = new Tag_sub();
					window.frmCreateTags.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Tag_sub() {
		
		initialize();
		Connect();

	}
	
	Connection con;
	 PreparedStatement pst;
	 ResultSet rs;
	 
	 public void Connect() {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver"); //com.mysql.jdbc.Driver
				con = DriverManager.getConnection("jdbc:mysql://localhost/tms", "root","");//localhost:8080/phpmyadmin/db_structure.php?db=timetablemgt
			}
			catch(ClassNotFoundException ex){
				
				
			}
			catch(SQLException ex) {
				
			}
			
		}
	 


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCreateTags = new JFrame();
		frmCreateTags.setTitle("Create Tags");
		frmCreateTags.setBounds(0, 0, 1366, 768);
		frmCreateTags.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCreateTags.getContentPane().setLayout(null);
		
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
		frmCreateTags.dispose();
		 	}
		 });
		 btn_home.setBackground(new Color(0,0,0,0));
		 btn_home.setIcon(new ImageIcon("F:\\_____SLIIT_____\\3_RD_YEAR\\IT3040______ITPM_____\\ITPMFinalWorkSpace\\TimeTable_Management_System\\TimeTableManagementSystem\\image\\Home-icon (1).png"));
		 btn_home.setBounds(0, 0, 88, 80);
	
		 frmCreateTags.getContentPane().add(btn_home);
		
		//tagname lable
		JLabel lblNewLabel = new JLabel("Name of Tag");
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(118, 53, 100, 25);
		frmCreateTags.getContentPane().add(lblNewLabel);
		
		//tag text
		txtTagName = new JTextField();
		txtTagName.setBounds(228, 52, 154, 24);
		frmCreateTags.getContentPane().add(txtTagName);
		txtTagName.setColumns(10);
		
		//related tag lable
		JLabel lblNewLabel_1 = new JLabel("Related Tags");
		lblNewLabel_1.setFont(new Font("Calibri", Font.BOLD, 14));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(118, 180, 100, 25);
		frmCreateTags.getContentPane().add(lblNewLabel_1);
		
		//tag code 
		JLabel lblNewLabel_1_1 = new JLabel("Tag Code");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Calibri", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(118, 115, 100, 25);
		frmCreateTags.getContentPane().add(lblNewLabel_1_1);
		
		//related tag text
		txtTagCode = new JTextField();
		txtTagCode.setColumns(10);
		txtTagCode.setBounds(228, 112, 154, 24);
		frmCreateTags.getContentPane().add(txtTagCode);
		
		//tag codes dropdown
		JComboBox<String> comboBoxRelTag = new JComboBox<>();
		comboBoxRelTag.setFont(new Font("Calibri Light", Font.PLAIN, 13));
		comboBoxRelTag.setModel(new DefaultComboBoxModel<String>(new String[] {"Lecture", "Tutorial", "Practical", "Evolution"}));
		comboBoxRelTag.setBounds(228, 180, 154, 21);
		frmCreateTags.getContentPane().add(comboBoxRelTag);
		
		//create button
		JButton btnCreate = new JButton("Create");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sub_name, sub_code, rel_tags;
				
				sub_name = txtTagName.getText();
				sub_code = txtTagCode.getText();
				rel_tags = comboBoxRelTag.getSelectedItem().toString();
				
				try {
					 
					pst = con.prepareStatement("insert into tags sub_name=?, sub_code=?, rel_tags=?");
					
					pst.setString(1, sub_name);
					pst.setString(2, sub_code);
					pst.setString(3, rel_tags);
				}
				catch(SQLException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		btnCreate.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCreate.setBounds(157, 281, 100, 25);
		frmCreateTags.getContentPane().add(btnCreate);
		
		//reset button
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtTagName.setText("");
				txtTagCode.setText("");
				comboBoxRelTag.setSelectedItem(null);
			}});
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnReset.setBounds(338, 281, 100, 25);
		frmCreateTags.getContentPane().add(btnReset);
	
	}
}

