
class LowerCase 
{
    public static void main(String[] args) 
    {  
        String str = args[0];
        System.out.println(lowerCase(str));
    }
    public static String lowerCase(String s) 
    {
       String result = "";
       for (int i=0; i<s.length(); i++)
       {
        char c = s.charAt(i);
        if (Character.isUpperCase(c))
        {
            result += Character.toLowerCase(c);
        }
        else
        {
            result += c;

        }
       }
        return result;
    }
}
