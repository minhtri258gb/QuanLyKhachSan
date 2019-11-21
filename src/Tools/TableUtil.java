/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tools;

import javax.swing.JTable;

/**
 *
 * @author tuan gh
 */
public class TableUtil {
	public static int getMaFromTable(JTable tbl)
	{
		if(tbl.getSelectedRow() == -1)
			return -1;
		return (int) tbl.getValueAt(tbl.getSelectedRow(), 0);
	}
}
