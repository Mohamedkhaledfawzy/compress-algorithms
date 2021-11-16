
package vector;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Read {
	

	void read() throws IOException {
		BufferedReader re = new BufferedReader(new FileReader("CodeBook.txt"));

		main.row = Integer.parseInt(re.readLine());
		main.column = Integer.parseInt(re.readLine());
		main.row1 = Integer.parseInt(re.readLine());
		main.column1 = Integer.parseInt(re.readLine());
		main.numOfVec = Integer.parseInt(re.readLine());
		main.lastBit = Integer.parseInt(re.readLine());

		Integer tmp[][] = new Integer[main.row1][main.column1];
		int numOfblocks = 0, numOfrow = 0, numOfcoloumn = 0;
		String[] buff = null;
		while (true) {
			String line = re.readLine();
			if (line == null) {
				CodeBooks.vectors.add(tmp);
				break;
			}
			buff = line.split(" ");

			if (buff.length == 1)
				continue;

			for (int i = 0; i < buff.length; numOfcoloumn++, i++) {
				if (numOfcoloumn == main.column1) {
					numOfcoloumn = 0;
					numOfrow++;
				}

				if (numOfrow == main.row1) {

					numOfrow = 0;
					numOfblocks++;
					numOfcoloumn = 0;
					CodeBooks.vectors.add(tmp);

					tmp = new Integer[main.row1][main.column1];
				}

				tmp[numOfrow][numOfcoloumn] = Integer.parseInt(buff[i]);
			}
		}
	}

	int log(int x, int base)  
	{
		return (int) Math.ceil((Math.log(x) / Math.log(base)));
	}

	void read1() throws IOException {
		int bitnum = log(main.numOfVec, 2);
		int log = 0;
		log |= (1 << bitnum);
		main.numOfVec = log;

		FileInputStream re = new FileInputStream(new File("LablesInBinary.txt"));// for the byte in the file
		
		byte Content[] = new byte[(int) new File("LablesInBinary.txt").length()];

		String now = "", text = "", res = "";

		re.read(Content);
		for (int i = 0; i < Content.length; i++) {
			for (int j = 0; j < 7; j++)
				text += (i + 1 < Content.length ? ((Content[i] & (1 << j)) > 0 ? '1' : '0')
						: (j < main.lastBit) ? ((Content[i] & (1 << j)) > 0 ? '1' : '0') : "");
		}

		for (int i = 0; i < text.length(); i += bitnum) {

			String num = text.substring(i, i + bitnum);
			split.numOfCodeBook.add(Integer.parseInt(num, 2));
		}
		
	}

   /* void read() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/
}



