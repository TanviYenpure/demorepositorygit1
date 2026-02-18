package in.core.main;

import java.awt.geom.Ellipse2D;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class FrequencyComparator implements Comparator<Map.Entry<String, Integer>> 
{
    @Override
    public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
        return e2.getValue().compareTo(e1.getValue()); 
    }
}
public class MainClass 
{
   public static void main(String[] args) throws IOException 
  {
	   BufferedReader reader=new BufferedReader(new FileReader("words.txt"));
	   String line;
	   
	   HashMap<String, Integer> wordshmp=new HashMap<String, Integer>();
	   
	  while((line= reader.readLine()) != null)
	  {
		  String [] wordsarray=line.toLowerCase().split("\\W+");
		  for(String word: wordsarray)
		  {
			  if (!word.isEmpty()) 
			  {
                  if (wordshmp.containsKey(word)) 
                  {
                      int currentCount = wordshmp.get(word);
                      wordshmp.put(word, currentCount + 1);
                  }
                  else
                  {
                	  wordshmp.put(word, 1);
                  }
              }
		  }
		  
	  }

	  List<Map.Entry<String, Integer>> sortList=new ArrayList<>(wordshmp.entrySet());
	  Collections.sort(sortList, new FrequencyComparator());
	  
	  
	  System.out.println("Top 5 words : ");
	  int count = 0;
	  for (Map.Entry<String, Integer> entry : sortList) {
	      System.out.println(entry.getKey() + " : " + entry.getValue());
	      count++;
	      if (count == 5) break;
	  }

	 
}
}
