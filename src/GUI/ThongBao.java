/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javax.swing.JOptionPane;

/**
 *
 * @author Massan
 */
public class ThongBao
{
	public static void noitice(String message)
	{
                JOptionPane.showMessageDialog(null, message);
	}
	
	public static void error(String message)
	{
		// display pop up menu and exit
		System.out.print(message);
	}
	
	public static void warning(String message)
	{
		// display pop up menu and top action
		System.out.print(message);
	}
	
	public static void print(String message)
	{
		System.out.print(message);
	}
	
	public static void log(String message)
	{
		// Write to file log.txt
		System.out.print(message);
	}
}
