/** String processing exercise 2. */
public class UniqueChars 
{
    public static void main(String[] args) 
    {  
        String str = args[0];
        System.out.println(uniqueChars(str));
    }
    public static String uniqueChars(String s) 
    {
        String result = "";
        int leng = s.length();
        for (int i = 0; i < leng; i++)
        {
            char char1 = s.charAt(i);
            boolean isUnique = true;
            if (s.indexOf(" ", i) == i)
            {
                result = result + " ";
            }
            for (int j = 0; j < result.length(); j++)
            {
                char char2 = result.charAt(j);
                if (char1 == char2)
                {
                   isUnique = false;
                   break;
                }
            }
            if (isUnique)
            {
               result += char1; 
            }
            
        }
        return result;
    }
}
