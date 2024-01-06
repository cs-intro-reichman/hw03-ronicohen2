
public class Calendar1 
{	
    // Starting the calendar on 1/1/1900
	static int dayOfMonth = 1;   
	static int month = 1;
	static int year = 1900;
	static int dayOfWeek = 2;     // 1.1.1900 was a Monday
	static int nDaysInMonth = 31; // Number of days in January
	static int specialSunday = 0;
	
	
	public static void main(String args[]) 
	{
		
	    int debugDaysCounter = 0; 	    
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
	 		if (debugDaysCounter > 36500) 
			{ 
	 			break;
	 		}
        }
		System.out.println("During the 20th century, " +specialSunday+ " Sundays fell on the first day of the month");
	 }
	

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
		dayOfMonth = 1;	
	 } 
		 

	private static boolean isLeapYear(int year) 
	{
		if (year % 4 == 0) 
		{
			if (year % 100 == 0) 
			{
				return year % 400 == 0;
			} 
			else 
			{
				return true;
			}
		}
		else 
		{
			return false;
		}
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
