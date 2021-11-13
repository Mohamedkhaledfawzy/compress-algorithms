
package assilz77;

import java.util.ArrayList;
import java.util.Scanner;
//import javax.swing.JOptionPane;

public class AssiLZ77 {

    
    public static void main(String[] args) {
   
        
        int count = 0 ;  // el variable dah 3shan el length
        int ind ;      // el variable dah 3shan nshof awl index lel char eli shabah el charAt(i) w ngeeb el pointer
        
          Scanner s = new Scanner(System.in);
       // JOptionPane p = new JOptionPane();
        String x ;
       // String x = p.showInputDialog("Enter Your String") ;
        
        x = s.next();
        
        ArrayList<Tag>arr1 = new ArrayList();  /////////////
           
        Tag t=new Tag();
              
        t.setPointer(0);
        t.setLength(0);
        t.setNext_char(x.charAt(0));
       // arr1.add(t);
    
      //  p.showMessageDialog(null, t);
        System.out.println("<"+t.getPointer()+","+t.getLength()+","+t.getNext_char()+">");
        
        
    //    int prev=0;
        
            //int Counrer=0 ;
        for(int i=1 ; i<x.length() ;  )
        {
            int k = i ;   // da 3shan hnesta5dem el i fe loop whan3'ayar feha , fa bnestdm variable bnafs el value
            
            String z = "";
            if(i<x.length()-1)
            {
            z = z + x.charAt(i);  // el (z) da bya5od el character eli ana wa2f 3ndo fel (x)
            }
            else{ break;}
            String y = x.substring(0,i); // el (y) da bya5od substring mn (x) 
            boolean bol = y.contains(z);
         //   int ind = y.lastIndexOf(z); // el (ind) dah bya5od el index bta3 el (z)
                                        // hena hya5od el index bta3 awl char fel substring(y) shabah el char eli mashyen 3leh  
           
         /*  if(ind > -1)                  // hena hwa la2a char shabaho
           {
               prev = ind ;
           }
          */
         System.out.println("y is  "+y);
         System.out.println("Z is  "+z);   
         if(bol == true)
               { 
                   char w =' ';
                   for( ; ; )
                    {
                      count++;       // variable count da 3shan ye count el length bta3 el tag
            if(i<x.length()-1)
            {
                      z = z + x.charAt(i+1);
            }
            else
            {break;}
                      System.out.println("Z if bool is true is  "+z);
                      w = x.charAt(i+1);    //dah 3shan el next character ne3rf ngebo  // i++;
                      bol = y.contains(z);
                      
                      if(bol == true)
                      {
                          //i++ ;
                          continue ;
                      }
                      else {
                          
                          break ;
                           }   // w7ott el count fel length
                    }
                   ind = y.lastIndexOf(z);   // El error byebteddy henaaaaaaaaaaaaaaaaaaaaaaaa           
                   System.out.println(" last ind of z is "+ind);
                   Tag c = new Tag();
                   c.setPointer(i-ind) ;
                   
                   c.setLength(count);
                   c.setNext_char(w);
                 ///  c.setNext_char(z.charAt(z.length()-1));
                   System.out.println("<"+c.getPointer()+","+c.getLength()+","+c.getNext_char()+">");
                   
                  // arr1.add(c);
                   
                   i = i + count  ; // this for next char
               }
               
           else                           // hena hwa mala2ash char shabaho
           {
             //  int len = i-z.length()-1 ;
               
               Tag tt = new Tag();
               tt.setPointer(0);
             //  tt.setPointer(len-prev);     
               tt.setLength(0);
               tt.setNext_char(x.charAt(i));
               System.out.println("<"+tt.getPointer()+","+tt.getLength()+","+tt.getNext_char()+">");
               
               i++ ;  // this for next char
               
             //  arr1.add(tt);           
           }
             
          /* for(int h = 0 ; h < arr1.size() ; h++)
           {
               System.out.println(arr1.get(h));
           }
           */
            
        }    
        
        
        
    }
    
}
