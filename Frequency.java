import java.io.*;
import java.util.*;

public class Frequency{
     public static void main(String[] args) {
        String str;
        Scanner s=new Scanner(System.in);
        str=s.next();
        char ele;
        int i=0,j=0;
        for(i= 0 ;i<str.length();i++)
        {
            int c = 0;
            ele = str.charAt(i);
            if (ele != '-')
            {
                for(j= i ;j<str.length();j++)
                {
                    if (ele == str.charAt(j))
                        c++;
                    
                }
                str = str.replace(ele, '-');
                System.out.println(ele+" "+c);
            }  
        }
    }
}
