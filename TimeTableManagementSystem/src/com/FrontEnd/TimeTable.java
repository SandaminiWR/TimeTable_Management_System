package com.FrontEnd;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.dao.SessionDao;
import com.models.Session;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TimeTable extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private SessionDao ses;

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
		scrollPane.setColumnHeaderView(table);
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
	
	
	
}
