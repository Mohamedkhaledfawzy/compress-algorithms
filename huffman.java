 
package huffman;

import com.sun.org.apache.bcel.internal.generic.SWAP;
import java.io.*;
import java.lang.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;

public class huffman extends javax.swing.JFrame {

    public huffman() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Compress");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("DeCommpress");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(57, 57, 57))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        
  /* ********************** Compress ************************** */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        JFileChooser chooser = new JFileChooser();
        int result = chooser.showOpenDialog(null);
        if (JFileChooser.APPROVE_OPTION == result) 
        {
            File myfile = chooser.getSelectedFile();
            chooser.show(false);
            try {
                compress(myfile);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(huffman.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(huffman.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    void sort(ArrayList<Integer> x1 , ArrayList<String> x2)
    {
        for(int i=0 ; i<x1.size() ; i++)
        {
            for(int j=i ; j<x1.size() ; j++)
            {
                if((x1.get(i)) < (x1.get(j)))
                {
                    Collections.swap(x2, i, j);
                    Collections.swap(x1, i, j);
                }
            }    
        } 
    }
    private void compress(File file) throws FileNotFoundException, IOException 
    {
        String fc=""; // da string byshel el unique characters bss
        String out="";
        
        FileReader reader = new FileReader(file);  // new object form FileReader
        char[] chars2 = new char[(int) file.length()]; // array of characters its size is the size of string in file
        reader.read(chars2);     
        fc= new String(chars2);  
        reader.close();    // closing file
        System.out.println("text "+ " "+fc);    // bnetb3 eli fel file , checking
        
        /*
        for(int i=0 ; i<fc2.length() ; i++)
        {
            if(fc2.charAt(i) !='\n' && fc2.charAt(i) !='\r' && fc2.charAt(i) !=' ')
            {
                fc += fc2.charAt(i);
            }
        }*/
        
        ArrayList <String> chars=new ArrayList<>();   // el arraylist de btshel characters
        ArrayList <Integer> nchars=new ArrayList<>(); // el arraylist de btshel el count bta3 kol char
        
        for(int i=0 ; i<fc.length() ; i++)// loop on each character of string
        {
            int count=0;
            if(!chars.contains( String.valueOf( fc.charAt(i) ))) // Chech if the character is added recently in the arraylist to avoid adding the same character
            {
               for(int j=0 ; j<fc.length() ; j++)
                 {
                   if(fc.charAt(i)==fc.charAt(j))
                    {
                      count++;
                    }
                 }
                  chars.add(String.valueOf(fc.charAt(i)));
                  nchars.add(count);
            }
        }
        
      sort(nchars,chars);
        
      System.out.println(chars);  // malhash 3azaa
      System.out.println(nchars); // malhash 3aza
      
      while(chars.size() != 2)   // da loop l7ad ma newsal en fe 2 Nodes bs fel arraylist 
      {
          /*for chars*/
          int index = chars.size()-1 ;  // variable takes the last index of the arraylist
          String s1 = "" + chars.get(index);  
          String s2 = "" + chars.get(index-1);     
          chars.remove(index);
          chars.remove(index-1);
          s2 +=s1;   // Summation the 2 characters that have lowest count in s2
          chars.add(s2); // adding s2 in chars arraylist
          System.out.println("S2 :"+s2);  ///////////// malhash 3aza
          
          /*for numbers*/
          int i = nchars.get(index); // variable holds the count of last char
          i += nchars.get(index-1);  // summation of the count of last 2 characters
          nchars.remove(index);
          nchars.remove(index-1);
          nchars.add(i);
          sort(nchars,chars);
      }
      
      System.out.println(chars);  // 2 print malhomsh 3aza
      System.out.println(nchars);
      
      ArrayList <String> pro = new ArrayList();
      pro.add("0");
      pro.add("1");
      
      for(int o=0 ; o<pro.size() ; o++)   // loop malhash lazma
      {
        System.out.println("pro "+" "+pro.get(o));  
      }  //
      
      boolean t = true;
      while(t == true)
      {
          t=false;
          for(int i=0 ; i<chars.size() ; i++)// chars.size = 2 in our example // loop bndawr 3la el string eli feh characters aktr mn 1 3shan n2asemo
          {                                       // ya3ny looping till finding string that has more than 1 character
              System.out.println("size "+i+" "+chars.size());  // malhash 3aza
              
              if((chars.get(i)).length() > 1)         // whena bn check 3al string eli 3dd el chars akbar mn 1 3shan n2asmo
              { 
                    chars.add(""+(chars.get(i)).charAt(0));
      
                    System.out.println((chars.get(i)).charAt(0)); // malhash 3aza
                    String test="";
                    for(int j=1 ; j < (chars.get(i)).length() ; j++)
                    {
                        test += (chars.get(i)).charAt(j);
                        System.out.println(test);
                    }         
                    chars.add(test);
                    chars.remove(i);
                    /*Number*/
                    test="";    // hanesta5dm variable test f kaza est5dam
                    test = pro.get(i);
                    pro.remove(i);
                    pro.add(test+"0");
                    pro.add(test+"1");
                    t=true;           
              }
          }
      }
      
      System.out.println(chars);
      System.out.println(pro);

    /*  for(int i=0 ; i<pro.size() ; i++)
        {
            out +=chars.get(i);
            out +=">";
            out +=pro.get(i);
            out +=" ";
        }
        out +="-  ";
    */   
        for(int i=0 ; i<fc.length() ; i++)
        {
            for(int j=0;j<chars.size();j++)
            {
                if(chars.get(j).equals( String.valueOf(fc.charAt(i)) ))
                {
                     //  int aInt = Integer.parseInt(d);
                    out +=pro.get(j);
                    break;
                }
            }   
        }
         
        System.out.println(out);  // The Output bits
       // String d="ttttt";
        FileWriter fstream = new FileWriter("E:\\Compressed_File.txt");
        BufferedWriter write = new BufferedWriter(fstream);
        write.write(out);
        write.close();
    }
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new huffman().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify                     
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    // End of variables declaration                   


    /* ********************** DeCompress ************************** */
/*   private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        JFileChooser chooser = new JFileChooser();
        int result = chooser.showOpenDialog(null);
        if (JFileChooser.APPROVE_OPTION == result) 
        {
            File myfile = chooser.getSelectedFile();
            chooser.show(false);
            try {
                decompress(myfile);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(huffman.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(huffman.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }                                     
    private void decompress(File file) throws FileNotFoundException, IOException
    {
        String fc="";
        FileReader reader = new FileReader(file);
        char[] chars2 = new char[(int) file.length()];
        reader.read(chars2);
        fc=new String(chars2);
        reader.close();

        ArrayList <String> chars=new ArrayList<>();
        ArrayList <String> nchars=new ArrayList<>();
        
        Boolean t=true;
        int c=0;
        String test="";
        
        for(c=0 ; c<fc.length() ; c++)
        {
            if(fc.charAt(c)=='-')
            {
                c++;
                break;
            }
            else if(fc.charAt(c)=='>')
            {
                t=false;
            }
            else if(fc.charAt(c)==' ')
            {
                nchars.add(test);
                t=true;
                test="";
            }
            else
            {
                if(t==true)
                {
                    chars.add(String.valueOf(fc.charAt(c)));
                }
                else
                {
                    test +=fc.charAt(c);
                }
            }
        }

        String in="";
        for(int i=c;i<fc.length();i++)
        { 
            in +=fc.charAt(i);        
        }

        System.out.println(chars);
        System.out.println(nchars);
        System.out.println(in);

        String out="-";
        t=true;
        test="";
        for(int i=0;i<in.length();i++)
        {
            if(t==true)
            {
                test +=in.charAt(i);
            }
            for(int j=0;j<nchars.size();j++)
            {
                if(test.equals(nchars.get(j)))
                {
                    out +=chars.get(j);
                    test="";
                    t=false;
                    break;
                }
            }
            t=true;    
        }
        System.out.println(out);
        
        FileWriter fstream = new FileWriter("E:\\Decompressed_File.txt");
        BufferedWriter write = new BufferedWriter(fstream);
        write.write(out);
        write.close();

        
    } */
    
    
    
    
    
    
    
    
    
    
}
  