
package vector;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Read_image {

	Read_image() {
	    try {
		BufferedImage image = ImageIO.read(new File("treka.jpg"));
		// cut image to available to vector size
		main.row = image.getWidth();
		main.column = image.getHeight();
		main.image = new int[main.row][main.column];

		for (int i = 0; i < main.row; i++)
                {
                    for (int j = 0; j < main.column; j++) 
                    {
		       int pixel = image.getRGB(i, j);
	               main.image[i][j] = (pixel) & 0xff;  
		    }
                }
			
		}

		catch (IOException e) {

			System.out.println(e.getMessage());
		}
	}

}

