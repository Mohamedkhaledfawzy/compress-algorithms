
package decompression;

import javax.swing.JOptionPane;


public class Decompression {

    
    public static void main(String[] args) {
        
        JOptionPane k = new JOptionPane();
        
        int pointer  = 0 ;
        int length  = 0 ;
        String next_char = null ;
        
        int pointback = 0 ;
        
        int num_tag = Integer.parseInt(k.showInputDialog("Enter Tags Number"));
        String mystr = "" ;
          
        for(int i = 0 ; i < num_tag ; i++)
        {
            pointer = Integer.parseInt(k.showInputDialog("Enter pointer"));
            
            length = Integer.parseInt(k.showInputDialog("Enter length"));
            
            next_char = k.showInputDialog("Enter next char");
            
            if(pointer == 0)    //
            {
                mystr += next_char ;
                continue ;
            }        
            else if(pointer > 0)    // no pointer bel (-ve)
            {
               pointback = mystr.length() - pointer ;   // bya5od el pointer eli rge3nalo
               for(int j = pointback ; j <= pointback + length-1 ; j++)
               {
                   mystr = mystr + mystr.charAt(j);
               }       
               mystr += next_char ;  
            }
        }
        
                k.showMessageDialog( k , mystr); //  My Output
        
    
     /*   
        JOptionPane k = new JOptionPane();
        
        String x ;
        
        for(int i=1 ; ; )
        {
            x = k.showInputDialog("Enter Your Tag");
            x.split(",");
            
            char y = x.charAt(0);
            
           int point = Integer.parseInt(y);
            
            if(x.charAt(0)== 0)
            {
                k.showMessageDialog(k, "enta sa7");
                break;
            }
        }
        
       */ 
 
    }
    
}
