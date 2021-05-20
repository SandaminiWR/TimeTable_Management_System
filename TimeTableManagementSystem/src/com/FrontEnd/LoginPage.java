package com.FrontEnd;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Font;

public class LoginPage {

	private JFrame frmLoginPage;
	private JTextField txt_name;
	private JPasswordField txt_Pass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage window = new LoginPage();
					window.frmLoginPage.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLoginPage = new JFrame();
		frmLoginPage.setTitle("Login Page");
		frmLoginPage.setBounds(100, 100, 1022, 495);
		frmLoginPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLoginPage.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 1006, 456);
		frmLoginPage.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 11, 986, 434);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("User Name");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 22));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(137, 186, 159, 33);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 22));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(137, 273, 174, 26);
		panel_1.add(lblNewLabel_1);
		
		txt_name = new JTextField();
		txt_name.setFont(new Font("Tahoma", Font.PLAIN, 22));
		txt_name.setBounds(368, 179, 287, 33);
		panel_1.add(txt_name);
		txt_name.setColumns(10);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.setFont(new Font("DialogInput", Font.BOLD, 22));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String un = txt_name.getText();
				String pas = txt_Pass.getText();
				
				if(un.equals("admin")&&pas.equals("123") ) {
					
					JOptionPane.showMessageDialog(null, "Login Successful.");
					
					MainPanel_Home sup = new MainPanel_Home();
					MainPanel_Home.main(null);
					frmLoginPage.setVisible(false);
				}
				
				else {
					
					JOptionPane.showMessageDialog(null, "Invalid User Name or Password.");
				}
					
				
			}
		});
		btnNewButton.setBounds(723, 351, 174, 51);
		panel_1.add(btnNewButton);
		
		txt_Pass = new JPasswordField();
		txt_Pass.setFont(new Font("Tahoma", Font.PLAIN, 22));
		txt_Pass.setBounds(368, 266, 287, 33);
		panel_1.add(txt_Pass);
		
		JLabel lblNewLabel_3 = new JLabel("SIGN IN");
		lblNewLabel_3.setFont(new Font("DialogInput", Font.BOLD | Font.ITALIC, 42));
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(352, 25, 266, 117);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(10, 11, 966, 412);
		
		lblNewLabel_2.setIcon(new ImageIcon("F:\\_____SLIIT_____\\3_RD_YEAR\\IT3040______ITPM_____\\TimeManagmentSystem\\TimeTableManagementSystem\\image\\login.png"));
		panel_1.add(lblNewLabel_2);
	}
}
