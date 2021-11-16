
package vector;


import java.util.ArrayList;

public class split 
{	
	static ArrayList<Integer[][]>vector=new ArrayList<Integer[][]>(); // blocks for image
	static ArrayList<Integer>numOfCodeBook=new ArrayList<Integer>(); // store codeBook vector for every block
	public split()
	{
		int rowNumb = main.row / main.row1 ; // number of levels in virtical
		int columnNumb = main.column / main.column1; // number of levels in horizontal
				
		if(main.row % main.row1 !=0)
                {
                    rowNumb++;
                }
		if(main.column % main.column1 != 0)
                {
                    columnNumb++;
                }
                
		int pointerRow=0,pointerColoumn=0; 
		
	for(int h=0 ; h < rowNumb ; h++)
	{
	  int tmpPointerRow=pointerRow , tmpPointerColoumn=pointerColoumn=0;
                   
	    for(int i=0 ; i<columnNumb ; i++)
            {
	        pointerRow=tmpPointerRow; 
				
		Integer tmp[][]=new Integer[main.row1][main.column1];
				
		for(int j=0 ; j<main.row1 ; j++,pointerRow++)
		{	
		    pointerColoumn=tmpPointerColoumn;			
		    for(int k=0 ; k <main.column1;k++,pointerColoumn++)
					
			if(pointerRow>=main.row || pointerColoumn>=main.column)
				tmp[j][k]=0;
			else
				tmp[j][k]=main.image[pointerRow][pointerColoumn];
		}
			
			tmpPointerColoumn=pointerColoumn;
				
			vector.add(tmp);
			numOfCodeBook.add(0);
			
                        
			System.out.println("----------------------------------------");
			for(int r=0;r<tmp.length;r++)
			{
				for(int c=0;c<tmp[r].length;c++)
				System.out.print(tmp[r][c]+" ");
				System.out.println();
			}
				System.out.println("----------------------------------------");
		}
		}
	}
}

