
package lzw;

import java.util.ArrayList;
import javax.swing.JOptionPane;


public class LZW {

   
    public static void main(String[] args) {
   
        
        JOptionPane p = new JOptionPane();
        
        ArrayList <String> dictionary = new ArrayList();
        for(int j=0 ; j<=127 ; j++)    // Loop to fill the dictionary from 0 -> 127
        {
            dictionary.add("0");
        }
        
        String x = p.showInputDialog("Enter Your String");
        String str = "";
        int cast = 0 ;
        String subs = "";
        int kk = 0 ;    // Only for braking out of a loop
        
        
        for(int i=0 ; i<x.length() ;  )               // loop on the string
        {
            str = "";
            str = str + x.charAt(i) ;   // Our stopping character
            str = str + x.charAt(i+1);  // we take the two characters
            
            int m = i ;
            
            for( ; ; )
            {
                if(dictionary.contains(str))
                {
                    str = str + x.charAt(m+1+1);
                    m++ ;
                    continue ;
                }
                else
                {
                    break ;
                }
            }    
          /*      for(int k = 128 ; k <= dictionary.size() ; k++)
                {
                    System.out.println(k);
                    if(str == dictionary.get(k))
                    {
                        str = str + x.charAt(m+1+1);  
                        m++ ;
                        break ;
                    }
                    else 
                    {
                        kk = k ;
                        continue ; 
                    }   
                }
                
                if(kk == dictionary.size())    // if (k) or (kk) reaches the end of dictionary without finding the str in it , we break
                {
                    break ;                      // ta2reban malhash lazma
                }  
            }
             */       dictionary.add(str);
                    
                    // ===========We have 2 conditions============================//
                    
                    //==============The first condition==================//
                    if( str.length() == 2 ) 
                    {
                        cast = (int)str.charAt(0);
                        p.showMessageDialog(null, "<"+ cast +">");
                        i++ ;
                        continue ;
                    }
                    //=============The second condition=================//
                    else if( str.length() > 2)
                    {
                        subs = "" ;
                        subs = str.substring( 0 , str.length()-1 );  //To get the index of string in dictionary
                        
                       /*for(int f = 128 ; f <= dictionary.size() ; f++)
                       { 
                           if( subs == dictionary.get(f))
                                 {
                                    p.showMessageDialog(null, "<"+ f +">");
                                 }
                        }  
                        i = m+1 ;
                        */
                        if( dictionary.contains(subs) )
                        {
                            System.out.println(dictionary.lastIndexOf(subs));
                        }
                        i = m+1 ;
                        
                        
                    } 
                }
            }
        }
        


