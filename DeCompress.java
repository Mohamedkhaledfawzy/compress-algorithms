
package vector;


import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class DeCompress {
	DeCompress()
	{
		
		int rowNumb=main.row/main.row1, // number of levels in virtical
			columnNumb=main.column/main.column1; // number of levels in horizontal
		File fileout=new File("treka1.jpg");
        
                BufferedImage image2=new BufferedImage(main.row+(main.row1-(main.row%main.row1)),main.column+(main.column1-(main.column%main.column1)),BufferedImage.TYPE_INT_RGB );
		
                main.image=new int[main.row+(main.row1-(main.row%main.row1))][main.column+(main.column1-(main.column%main.column1))];
     
		
		if(main.row%main.row1!=0)
			rowNumb++;
		if(main.column%main.column1!=0)
			columnNumb++;
			
			int pointerRow=0,pointerColoumn=0,ind=0;
			// pointer Row last index of Row taken
			// Pointer coloumn last index of coloumn taken
			for(int h=0 ; h < rowNumb ;h++)
			{
				int tmpPointerRow=pointerRow , tmpPointerColoumn=pointerColoumn=0;
				
				for(int i=0 ; i < columnNumb ;i++)
				{
					pointerRow=tmpPointerRow; 
					
					Integer tmp[][]=CodeBooks.vectors.get(split.numOfCodeBook.get(ind++)); // From Label Get Specific Vector
					
					for(int j=0 ;j<main.row1;j++,pointerRow++)
					{	
						pointerColoumn=tmpPointerColoumn;
						
						for(int k=0 ; k <main.column1;k++,pointerColoumn++)
						{
							if(pointerRow>=main.row || pointerColoumn>=main.column)
							{
								main.image[pointerRow][pointerColoumn]=0;
								image2.setRGB(pointerRow,pointerColoumn,0);
							}
							else
							{
								main.image[pointerRow][pointerColoumn]=tmp[j][k];
								image2.setRGB(pointerRow,pointerColoumn,(tmp[j][k]<<24)|(tmp[j][k]<<16)|(tmp[j][k]<<8)|(tmp[j][k])); // hnaa baktebb El-7agaa El-Folanyaa Fel-Image.
							}
						}
					}
					
					tmpPointerColoumn=pointerColoumn;
				}
			}
			
			 try {
		            ImageIO.write(image2, "jpg", fileout);
		        } catch (IOException e) {
		            // TODO Auto-generated catch block
		            e.printStackTrace();
		        }
	}

}
