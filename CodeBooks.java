
package vector;

import java.util.ArrayList;

public class CodeBooks {

	static ArrayList<Integer[][]> vectors = new ArrayList<Integer[][]>(); 

	CodeBooks(ArrayList<Integer[][]> vectors) {   // ba3atnalo arraylist "vector"
		this.vectors = vectors;               // w5alenah equal lel "vectors"

		getCodeBooks(new ArrayList<Integer[][]>());
	}

    

	void getCodeBooks(ArrayList<Integer[][]> prev) {
		boolean ok = true; // 7alet El-3adad we Spliting

		if (vectors.size() == main.numOfVec) // Lww wasltt Le-3aded ElVectors eli 3wznha Fel-CodeBook Wlaa L22
		{                                        // bnkaren el values bta3thom beba3d  
			boolean check = true; // 7alet El-Moqarnaa  mabeen el splitting wel association el adem wel gded

			if (prev.size() == vectors.size())// Finished Spliting and Moqarnaa
                        { 
			    for (int i = 0; i < vectors.size(); i++)
				for (int j = 0; j < main.row1; j++)
					for (int k = 0; k < main.column1; k++)
						if (vectors.get(i)[j][k].equals(prev.get(i)[j][k]) == false)
							check = false;

			}

			else
			check = false;

			if (check) { // get the final CodeBooks

				return;
			}
                 
			// prev not qual curr
			prev = vectors;

			ok = false;
		}

		int size = vectors.size();  // awl mara el size be 1

		if (ok) // not get the size for codeBook

			for (int i = 0; i < size; i++) {
				// split the mid to left and right

				Integer left[][] = new Integer[main.row1][main.column1]; 
				Integer right[][] = new Integer[main.row1][main.column1];

				for (int j = 0; j < main.row1; j++)
					for (int k = 0; k < main.column1; k++) {
						left[j][k] = vectors.get(0)[j][k] + 1;
						right[j][k] = vectors.get(0)[j][k] - 1;
					}

				vectors.add(left);
				vectors.add(right);
				vectors.remove(0);
			}

		ArrayList<Integer[][]> sum = new ArrayList<Integer[][]>(); 
		ArrayList<Integer> cont = new ArrayList<Integer>(); // count number of blocks in these mid
															

		for (int i = 0; i < vectors.size(); i++) {
			sum.add(new Integer[main.row1][main.column1]);
			cont.add(0);
		}
		
		
		// ---> Ba3mell Assigning Le-Kull Chunk for every mid 
	        for (int i = 0; i < split.vector.size(); i++) {  // ba loop 3la kol el blocks bta3t el sora 
			int ind = getSum(split.vector.get(i)); // get index for minimum diff
			// Nearest vector
			int tmp = cont.get(ind);
			cont.remove(ind);
			cont.add(ind, tmp + 1); // For each codeblock ,ElBlock Elly tab3oo ,Counter 
                        

			// add the index for the block
			split.numOfCodeBook.remove(i);
			split.numOfCodeBook.add(i, ind); // Baddy Kull Block Rakmm Mn El-Codebok , we ba2ool kull Wa7ed Tab33 Meen

			
			for (int j = 0; j < main.row1; j++)  //For Summation
				for (int k = 0; k < main.column1; k++) {
					if (cont.get(ind) == 1)
						sum.get(ind)[j][k] = 0;
					sum.get(ind)[j][k] += split.vector.get(i)[j][k];
				}
		}
	
                // hageeeb El-Mean For Each Blocks 3andyyyy ..
		for (int i = 0; i < sum.size(); i++)
			for (int j = 0; j < main.row1; j++)
				for (int k = 0; k < main.column1; k++)
					if (cont.get(i) > 0)
						sum.get(i)[j][k] = /* (int)Math.ceil(1.0 **/sum.get(i)[j][k] / cont.get(i); 
					else
						sum.get(i)[j][k] = 0;
		vectors = sum; 

		getCodeBooks(prev); //7etet El-Calling 

		return;

	}

	
	
	
	// get the index of minimum Diff between Block and all mids
	int getSum(Integer curr[][]) 
	{
		int mini = 1000000000, ind = 0;

		for (int i = 0; i < vectors.size(); i++) {
			int sum = 0;
			for (int j = 0; j < curr.length; j++)

				for (int k = 0; k < curr[j].length; k++)
					if (vectors.get(i)[j][k] != null)
						sum += Math.abs(vectors.get(i)[j][k] - curr[j][k]);
			if (mini > sum) {
				mini = sum;
				ind = i;
			}
		}

		return ind;
	}
}
