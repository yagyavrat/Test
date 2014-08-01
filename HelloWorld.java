import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class HelloWorld
{ 
    
public static String SortedString(String s)
{
    char[] Word = s.toCharArray();
    Arrays.sort(Word);
    return new String(Word);   
}

private static final HashMap<String, ArrayList<String>> myMap = new HashMap<String, ArrayList<String>>();

public static void main(String []args)
     {
         List<String> FileData = new ArrayList<String>();       
        try
         {  
            BufferedReader br = new BufferedReader(new FileReader("input.txt"));
            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null) 
            {
    		    FileData.add(sCurrentLine);
			}            
         }       
         catch(Exception e)
         {
             
         }   
        for(int i=0 ; i< FileData.size(); i++)
        {
            String s = SortedString(FileData.get(i));
            if(myMap.containsKey(s))
            {
                myMap.get(s).add(FileData.get(i));
            }
            else
            {
                myMap.put(s, new ArrayList<String>());
                myMap.get(s).add(FileData.get(i));
            }
        }
        
       for (Map.Entry<String, ArrayList<String>> entry : myMap.entrySet()) 
       {
          String key = entry.getKey();
          ArrayList<String> values = entry.getValue();
          if(values.size()>1)
          {
              for (String item : values) 
             {   
                System.out.print(item+" ");
             }
              System.out.println();
          }
    
        }
     }    
        
}     

