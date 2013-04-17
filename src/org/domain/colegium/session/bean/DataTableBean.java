package org.domain.colegium.session.bean;

import java.io.Serializable;
import java.util.ArrayList;

import org.jboss.seam.annotations.Name;

@Name("dataTableBean")
public class DataTableBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Column> arrayListColumns ;	
	private ArrayList<Item> arrayListItem;

	public DataTableBean(ArrayList<Column> arrayListColumns,
			ArrayList<Item> arrayListItem) {
		super();
		this.arrayListColumns = arrayListColumns;
		this.arrayListItem = arrayListItem;
	}
	
	

	public DataTableBean() {
		super();
		// TODO Auto-generated constructor stub
	}



	public ArrayList<Column> getArrayListColumns() {
		return arrayListColumns;
	}

	public void setArrayListColumns(ArrayList<Column> arrayListColumns) {
		this.arrayListColumns = arrayListColumns;
	}

	public ArrayList<Item> getArrayListItem() {
		return arrayListItem;
	}

	public void setArrayListItem(ArrayList<Item> arrayListItem) {
		this.arrayListItem = arrayListItem;
	}

	
	
}
