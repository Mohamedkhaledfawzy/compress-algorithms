
package vector;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class main {
    
	static int row, column, row1, column1, numOfVec, image[][], lastBit;
	

	static int log(int x, int base)    // function to get number of vectors bezzabt
         {
		return (int) Math.ceil((Math.log(x) / Math.log(base)));
	 }

	public static void main(String args[]) throws IOException {
            
		Scanner in = new Scanner(System.in);
		System.out.println("Press 1 For The Compression OR Press 2 For The Decompression");
		int choice = in.nextInt();  // choice for compress or decompress
                
		if (choice == 1) 
                {
                        System.out.println("vector size : ");
	         	row1 = in.nextInt();                    // bnda5al el data bta3t el block
			column1 = in.nextInt();

			System.out.println("Enter Number Of Vectors In The CodeBook");
			numOfVec = in.nextInt();

			int bitnum = log(numOfVec, 2);   // number of bits to represent vectors in codebook
			int log = 0;
			log |= (1 << bitnum);
			numOfVec = log;          // getting real number of vectors

			System.out.println("Read image");

			Read_image imagee = new Read_image();   // object from Read_image class

			split s = new split();
                        
                        
			Integer sum[][] = new Integer[row1][column1]; // sum 2D-array bta3 el vector el average                  
                        // bngeeb el vector eli shayel el average(the initial vector)(sum)
			for (int i = 0 ; i < row1 ; i++)
                        {
                            for (int j = 0 ; j < column1 ; j++)
                            {
				sum[i][j] = 0;
				for (int k = 0 ; k < split.vector.size() ; k++)
				sum[i][j] += split.vector.get(k)[i][j];
			    }
                        }
				
			for (int i = 0; i < row1; i++)
                        {
                            for (int j = 0; j < column1; j++)
                            {
                                sum[i][j] = sum[i][j] / split.vector.size();
                            }			
                        }
				                
                        // l7aad hena

			ArrayList<Integer[][]> vector = new ArrayList<Integer[][]>(); // byshel vectors

			vector.add(sum);

			CodeBooks c = new CodeBooks(vector);
			Write wr1 = new Write();
		
			wr1.writeCoodeBook();
                }	

		 else {
			Read re = new Read();
			re.read();
			re.read1();
			
			DeCompress de = new DeCompress();
		}
	}
}

        
    
    

