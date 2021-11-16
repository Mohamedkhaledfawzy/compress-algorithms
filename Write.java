
package vector;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Write {
    
	BufferedWriter wr;

	int log()
        {
	    return (int) Math.ceil((Math.log(1.0 * main.numOfVec) / Math.log(2.0)));
	}

	Write() throws IOException {

		BufferedWriter wr = new BufferedWriter(new FileWriter("LablesInBinary.txt"));
		int log2 = log();
		byte codeByte = 0;
		int mask = 0;
		String all = "";
		for (int i = 0; i < split.numOfCodeBook.size(); i++) {
			String ind = split.numOfCodeBook.get(i).toBinaryString(split.numOfCodeBook.get(i)); // Index to binary
		
			while (ind.length() < log2)
				ind = "0" + ind;

			all += ind;
		}
		for (int i = 0; i < all.length(); mask++, i++) {
			if (all.charAt(i) == '1')
				codeByte |= (1 << mask);
			if (mask == 6) {
				wr.write(codeByte);
				mask = -1;
				codeByte = 0;
			}
		}

		if (mask > 0) {
			wr.write(codeByte);
			main.lastBit = mask;
		}

		else
			main.lastBit = 7;  

		wr.close();
	}

	void writeCoodeBook() throws IOException {
		wr = new BufferedWriter(new FileWriter("CodeBook.txt"));
		wr.write(((Integer)main.row).toString());
		wr.newLine();
		wr.write(((Integer)main.column).toString());
		wr.newLine();
		wr.write(((Integer)main.row1).toString());
		wr.newLine();
		wr.write(((Integer)main.column1).toString());
		wr.newLine();
		wr.write(((Integer)main.numOfVec).toString());
		wr.newLine();
		wr.write(((Integer)main.lastBit).toString());
		wr.newLine();

		for (int i = 0; i < main.numOfVec; i++) {
			for (int j = 0; j < main.row1; j++) {
				for (int k = 0; k < main.column1; k++)
					if (k + 1 != main.column1)
						wr.write(CodeBooks.vectors.get(i)[j][k].toString() + " ");
					else
						wr.write(CodeBooks.vectors.get(i)[j][k].toString());
				wr.newLine();
			}
			if (i + 1 != main.numOfVec)
				wr.newLine();
		}
		wr.close();
	}

   /* void writeCoodeBook() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/
}
