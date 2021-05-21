package com.models;

import java.awt.Component;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.TableCellRenderer;

public class MultipleLine extends JTextArea implements TableCellRenderer{

	private List<List<Integer>> rowColHeight = new ArrayList<>();
	
	public MultipleLine() {
		
		setLineWrap(true);
		setWrapStyleWord(true);
		setOpaque(true);
		
	}
	
	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		
		setText((value == null) ? "" : value.toString());
		setEditable(false);
		adjustRowHeight(table, row, column);
		
		
		return this;
	}

	public void adjustRowHeight(JTable table, int row, int column) {
		// TODO Auto-generated method stub
		
	}

}
