/** 
 * Prints the calendars of all the years in the 20th century.
 */
public class Calendar1 
{	
    // Starting the calendar on 1/1/1900
	static int dayOfMonth = 1;   
	static int month = 1;
	static int year = 1900;
	static int dayOfWeek = 2;     // 1.1.1900 was a Monday
	static int nDaysInMonth = 31; // Number of days in January
	static int specialSunday = 0;
	
	/** 
	 * Prints the calendars of all the years in the 20th century. Also prints the  
	 * number of Sundays that occured on the first day of the month during this period.
	 */
	public static void main(String args[]) 
	{
		// Advances the date and the day-of-the-week from 1/1/1900 till 31/12/1999, inclusive.
	    // Prints each date dd/mm/yyyy in a separate line. If the day is a Sunday, prints "Sunday".
	    // The following variable, used for debugging purposes, counts how many days were advanced so far.
	    int debugDaysCounter = 0; 

	    //// Write the necessary initialization code, and replace the condition
	    //// of the while loop with the necessary condition 
	 	while (year <= 1999) 
		{
	 		for (int k =1; k <= 12; k++)
			{
				advance(dayOfMonth, month, year);
	 		    debugDaysCounter++;
				month++;
			}
			if (month == 13)
			{
				month = 1;
			}	
	 		year++;			
	 		//// If you want to stop the loop after n days, replace the condition of the
	 		//// if statement with the condition (debugDaysCounter == n)
	 		if (debugDaysCounter > 36500) 
			{ 
	 			break;
	 		}
        }
		System.out.println("During the 20th century, " +specialSunday+ " Sundays fell on the first day of the month");
	 }
	
	 // Advances the date (day, month, year) and the day-of-the-week.
	 // If the month changes, sets the number of days in this month.
	 // Side effects: changes the static variables dayOfMonth, month, year, dayOfWeek, nDaysInMonth.
	 private static void advance(int dayOfMonth, int month, int year) 
	 {
		nDaysInMonth = nDaysInMonth(month, year);
		for (int j = 1; j <= nDaysInMonth; j++)
		{
			System.out.print(dayOfMonth + "/" + month + "/" + year);
			if (dayOfWeek == 1)
			{
				System.out.print(" Sunday");
				if (dayOfMonth == 1)
				{
					specialSunday++;
				}

			}
			System.out.println();
			if (dayOfWeek == 7)
			{
				dayOfWeek = 1;
			}
			else
			{
				dayOfWeek ++;
			} 
			dayOfMonth ++;
		}		
	 } 
		 

	private static boolean isLeapYear(int year) 
	{
	    if (year % 4 == 0)
		{
			return true;
		}	
		if ((year % 100 ==0) && (year % 400 == 0))
		{
			return true;
		}	
		else return false;
	}
	 
	private static int nDaysInMonth(int month, int year) 
	{
		int days = 0;
		if (month == 2)
		{
			if (isLeapYear(year))
			{
				days = 29;
			}
			else days = 28;
		}
		else if ((month == 4) || (month == 6) || (month == 9) || (month == 11))
		{
			days = 30;
		}
		else days = 31;
		return days;
	}
}
