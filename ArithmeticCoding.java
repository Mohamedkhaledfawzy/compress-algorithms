
package arithmetic.coding;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;


public class ArithmeticCoding {
    
    
    public static void main(String[] args) throws IOException {

        
        FileOutputStream f  = null;
        try {
            
            System.out.println("Enter Your String");
            Scanner sc  = new Scanner(System.in);
            String x = sc.next();
            String y = "";        // string of unique chars
            for(int i=0 ; i<x.length() ; i++)  // loop to get string of unique chars
            {
                if(!y.contains(x.charAt(i)+""))
                {
                    y = y + (x.charAt(i)+"");
                }
            }
            System.out.println("string of unique chars "+ y); // for checking only
            
            int c = 0 ; // counter that count how many times each character displays in the input string
            double p = 0.0 ; // variable that carries the propabilities of each character display
            Unichar[]mycharacters = new Unichar[y.length()]; // array of type unichar that carries each character with its data
            for(int i=0 ; i<y.length() ; i++)  // loop that fills data of each character
            {
                c = 0 ;
                p = 0.0 ;
                for(int j=0 ; j<x.length() ; j++)  // loop of counter
                {
                    if(x.charAt(j) == y.charAt(i))
                    {
                        c++ ;           
                    }
                }
                p = (double)c/x.length() ; // propability calculating
                
                mycharacters[i] = new Unichar();  // object from unichar
                mycharacters[i].setMychar(y.charAt(i));   // kan feh error hena 3shan el object
                mycharacters[i].setCount(c);
                mycharacters[i].setPropability(p);
            }
            for(int i=0 ; i<mycharacters.length ; i++)  // for checking
            {
                System.out.println("=> Data of character number "+i+" is ");
                System.out.print(mycharacters[i].getMychar()+"  ");
                System.out.print(mycharacters[i].getCount()+"  ");
                System.out.print(mycharacters[i].getPropability()+"  ");
                System.out.print(mycharacters[i].getCom_prop()+"  ");   // Still empty
                System.out.println();
            }
            System.out.println("The Ascii =  "+(int)mycharacters[0].getMychar()); // checking for ascii only
            
            /*  for(int i=0 ; i<mycharacters.length ; i++)   // sort array according to ascii of characters
            {
            for(int j=1 ; j<mycharacters.length ; j++)
            {
            if((int)mycharacters[j].getMychar() < (int)mycharacters[j-1].getMychar())
            {
            Unichar temp = new Unichar();
            temp = mycharacters[j] ;
            mycharacters[j] = mycharacters[j-1];
            mycharacters[j-1] = temp ;
            }
           }
        }
      */
            System.out.println("Showing the array after sorting");  // for checking of sorting
            for(int i=0 ; i<mycharacters.length ; i++)  // for checking
            {
                System.out.println("=> Data of character number "+i+" is ");
                System.out.print(mycharacters[i].getMychar()+"  ");
                System.out.print(mycharacters[i].getCount()+"  ");
                System.out.print(mycharacters[i].getPropability()+"  ");
                System.out.print(mycharacters[i].getCom_prop()+"  ");   // Still empty
                System.out.println();
            }
           
            mycharacters[0].setCom_prop(mycharacters[0].getPropability()); // set commu.prop. for only the first character
            for(int i=1 ; i<mycharacters.length ; i++)  // loop of setting commulative propability to each character
            {
                mycharacters[i].setCom_prop( mycharacters[i].getPropability() + mycharacters[i-1].getCom_prop() );
            }
            
            
            /*===========================Start Algorithm============================*/
            
            System.out.println("===Starting The Algorithm===");
            Intervalchar[] myinterval = new Intervalchar[y.length()]; // array carries characters with thier intervals
            myinterval[0] = new Intervalchar(); // object for accessing 1st only
            myinterval[0].setMychar(mycharacters[0].getMychar()); // bn set awl character
            myinterval[0].setLow_range(0); // El low range bta3 awl character equal zero dyman
            myinterval[0].setHigh_range(mycharacters[0].getCom_prop()); // El high range bta3 awl character equal prop. aw comm.prop.
            for(int i=1 ; i<myinterval.length ; i++) // setting data of class Intervalchar
            {
                myinterval[i] = new Intervalchar(); // object
                myinterval[i].setMychar(mycharacters[i].getMychar());
                myinterval[i].setLow_range(myinterval[i-1].getHigh_range());
                myinterval[i].setHigh_range(myinterval[i-1].getHigh_range() + mycharacters[i].getPropability());
            }
            /*   ArrayList <Double> comm = new ArrayList();  // Arraylist carries commulative of all characters
            for(int i=0 ; i<myinterval.length ; i++)  // loop to fill arraylist with commu.
            {
            comm.add(mycharacters[i].getCom_prop());
            }
            */
            
            double L = 0 ;   // my fixed Lower Range
            double U = 1 ;   // my fixed Uppre Range
            
            double L1 = 0 ;
            double U1 = 0 ;
            for(int i=0 ; i<x.length() ; i++)
            {
                for(int j=0 ; j<myinterval.length ; j++)
                {
                    if(x.charAt(i) == myinterval[j].getMychar()==true)
                    {
                        L1 = myinterval[j].getLow_range();
                        U1 = myinterval[j].getHigh_range();
                        break;
                    }
                }
                
                double b = L + (U-L) * L1 ;
                       U = L + (U-L) * U1 ;
                       L = b;
            }
            
            double compcode = (L+U)/2 ;  // Equation of solving
            //System.out.println("l="+L+" u= "+U);
            for(int i=0 ; i<myinterval.length ; i++)  // loop for checking only
             {
                 System.out.println(myinterval[i].getLow_range() +"         "+ myinterval[i].getHigh_range());
             }
            
             System.out.println();
             System.out.println(compcode);
            
            // File
            f = new FileOutputStream("C:\\Users\\DELL\\Desktop\\compress.txt");
            DataOutputStream d=new DataOutputStream(f);
            float ff = (float) compcode;
            try {
                d.writeFloat(ff);
            } catch (IOException ex) {
                
            }
            
            
            /*================================Decompress====================================*/
            
            FileInputStream f1=new FileInputStream("C:\\Users\\DELL\\Desktop\\compress.txt");
            DataInputStream d1=new DataInputStream(f1);
            compcode=d1.readFloat();
            
            double L2 = 0 ;
            double U2 = 1 ;
            
            double L3 = 0 ;
            double U3 = 0 ;
            
            String str = "" ;
            
            for(int i=0 ; i<x.length() ; i++)
            {
                double comp = (compcode - L2)/(U2 - L2); // Equation bta3t el solution
                
                for(int j=0 ; j<myinterval.length ; j++)
                {
                    if( comp < myinterval[j].getHigh_range() && comp > myinterval[j].getLow_range() )
                    {
                        str += myinterval[j].getMychar() ;
                        L3 = myinterval[j].getLow_range();
                        U3 = myinterval[j].getHigh_range();
                    }
                }  
                
                double bb = L2 + (U2-L2) * L3 ; 
                       U2 = L2 + (U2-L2) * U3 ;
                       L2 = bb;           
            }
            
            System.out.println(str);
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ArithmeticCoding.class.getName()).log(Level.SEVERE, null, ex);
            
        } finally {
            try {
                f.close();
            } catch (IOException ex) {
                Logger.getLogger(ArithmeticCoding.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
  
    }
    
}
