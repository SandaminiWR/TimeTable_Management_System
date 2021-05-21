package com.models;


import javax.swing.Icon;
import javax.swing.table.AbstractTableModel;

public class JTableModel extends AbstractTableModel{
	private String[] columns;
	private Object[][] row; 
	
	public JTableModel() {}
	
	public JTableModel(String[] columns) {		
		this.columns = columns;
		
	}
	public JTableModel(String[] columns, Object[][] row) {		
		this.columns = columns;
		this.row = row;
	}
	
	public Class getColumnClass(int column) {
		return Icon.class;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return null;
	}
	


}
