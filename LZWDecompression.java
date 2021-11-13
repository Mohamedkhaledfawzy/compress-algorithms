
package lzw.decompression;

import java.util.ArrayList;
import javax.swing.JOptionPane;


public class LZWDecompression {


    public static void main(String[] args) {
        
        ArrayList <String> dictionary = new ArrayList();  // we are filling the dictionary from 0 -> 127
        for(int i = 0 ; i <= 127 ; i++)
        {
            dictionary.add("0");
        }
        
        JOptionPane p = new JOptionPane();
        
        int x = Integer.parseInt(p.showInputDialog("Enter Number Of Tags")) ;   // (x) is the tags number.
        int tag = 0 ;
        String str = "" ;
        String All = ""; // it appends all characters that are in arr_tags
        
        String [] arr_tags = new String [x];     // da bya5od kol el characters (tags)
        
        tag = Integer.parseInt(p.showInputDialog("Enter Your Tag"));    // this for putting the first tag only
        arr_tags[0] = (char)tag + "" ;
        
        for(int i = 1 ; i < x ; i++)     // loop for entering the tags to get the string
        {
           tag = Integer.parseInt(p.showInputDialog("Enter Your Tag")) ;
           
           if(tag >= dictionary.size())           // condition for the last tag
           {
               arr_tags[i] = arr_tags[i-1] + arr_tags[i-1].charAt(0);
               dictionary.add(arr_tags[i]);
           }
           
          else if(tag > 64 && tag < 91 || tag > 96 && tag < 123)
           {
               arr_tags[i] = (char)tag + "" ;      // to change char to string and put it in array
          //     str = str + arr_tags[i] ;
               dictionary.add( arr_tags[i-1] + arr_tags[i].charAt(0) ) ;
               continue ;
           }
               
           else
           {
               for(int j = 128 ; j < 1000 ; j++)
               {
                   if(j == tag)
                   {
                     arr_tags[i] = dictionary.get(j);
                     dictionary.add( arr_tags[i-1] + arr_tags[i].charAt(0) );
                     break;
                   }
               }
           }  
        }
        
        for(int y=0 ; y < x ; y++)
        {
            All = All + arr_tags[y];
        }
        p.showMessageDialog(null, All);
    
  }
}