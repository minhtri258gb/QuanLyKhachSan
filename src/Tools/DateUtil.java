/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tools;
		
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date; 
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Massan
 */
public class DateUtil
{
	public static String getCurDate()
	{
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		Date date = new Date();
		return formatter.format(date);
	}
	
	public static int compare(String date1, String date2)
	{
		int num1 = getYear(date1);
		int num2 = getYear(date2);
		
		if(num1 > num2)
			return 1;
		else if(num1 < num2)
			return -1;
		
		num1 = getMonth(date1);
		num2 = getMonth(date2);

		if(num1 > num2)
			return 1;
		else if(num1 < num2)
			return -1;
		
		num1 = getDay(date1);
		num2 = getDay(date2);

		if(num1 > num2)
			return 1;
		else if(num1 < num2)
			return -1;
		
		return 0;
	}
	
	public static int getDay(String date)
	{
		return Integer.parseInt(date.substring(0, 2));
	}
	
	public static int getMonth(String date)
	{
		return Integer.parseInt(date.substring(3, 5));
	}
	
	public static int getYear(String date)
	{
		return Integer.parseInt(date.substring(6, 10));
	}
        
        public static Date convert(String date)
        {
            try {
                return new SimpleDateFormat("dd-MM-yyyy").parse(date);
            } catch (ParseException ex) {
                Logger.getLogger(DateUtil.class.getName()).log(Level.SEVERE, null, ex);
            }
            return null;
        }
}
