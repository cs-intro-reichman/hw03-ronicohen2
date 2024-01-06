
public class Calendar 
{	
	static int dayOfMonth = 1;   
	static int month = 1;
	static int year = 1900;
	static int dayOfWeek = 2;     // 1.1.1900 was a Monday
	static int nDaysInMonth = 31; // Number of days in January
	

	public static void main(String args[]) 
	{
        int currentYear = Integer.parseInt(args[0]);

		while(year< currentYear)
		{
			
			while (month<13) 
			{
				nDaysInMonth = nDaysInMonth(month, year);
				for (int j = 1; j <= nDaysInMonth; j++)
				{
					if (dayOfWeek == 7)
					{
						dayOfWeek = 1;
					}
					else
					{  
						dayOfWeek ++;
					} 
				}
				month ++;	
			}
		  
			year++;
			month = 1;	
		}
		month = 1;
	 	for (int k =1; k <= 12; k++)
		{
			advance(dayOfMonth, month, currentYear);
			month++;
		}
		if (month == 13)
		{
			month = 1;
		}	
	 	year++;				
	 	
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
				//if (dayOfMonth == 1)
				//{
				//	specialSunday++;
				//}

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
