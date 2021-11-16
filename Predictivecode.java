
package predictivecode;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
import javax.imageio.ImageIO;


public class Predictivecode {

    
        
        public static void main(String[] args) throws IOException {
             
        File file = new File("treka.jpg");   
        FileInputStream fis;
        BufferedImage image = null;
        int width = 0, hieght = 0;
        int a = 0, b = 0, c = 0;
        System.out.println("Enter Number Of Levels : ");
        Scanner sc = new Scanner(System.in);
        int nlevels = sc.nextInt();  // entering number of levels nedded

        try {

            fis = new FileInputStream(file);
            image = ImageIO.read(fis);
       
        } catch (IOException e) {
            e.printStackTrace();
        }

        int[] low = new int[1000];
        int[] high = new int[1000];
        int[] DEQ = new int[1000];
        int h = 0, range = 0;
        
        if( 511 % nlevels == 0)     // getting the range of each level
            range = 511 / nlevels ;
        else
            range = (511 / nlevels) + 1 ;
        
        for (int i = 0 ; i < nlevels ; i++) {
            if (i == 0) {
                
                low[0] = -255;
                high[0] = range + low[0];            
                DEQ[0] = (high[0] + low[0]) / (high[0] - low[0]);
                
            } else {
                //low.set(i, hight.get(i - 1) + 1);
                low[i] = (high[i - 1] + 1);
                //hight.set(i, low.get(i) + range);
                high[i] = (low[i] + range);
                DEQ[i] = ((high[i] + low[i]) / (high[i] - low[i]));
            }
            System.out.println("low: " + low[i]);
            System.out.println("hight: " + high[i]);
            System.out.println("Deq: " + DEQ[i]);
        }

        width = image.getWidth();
        hieght = image.getHeight();
        int[][] pixels = new int[hieght][width];
        int[][] sample = new int[hieght][width];
        int[][] diff = new int[hieght][width];
        int[][] q = new int[hieght][width];
        int[][] deq = new int[hieght][width];
        int[][] error = new int[hieght][width];
        int[][] des = new int[hieght][width];
        double sum = 0, MSE = 0;
        
        String result = null;

        for (int x = 0;  x < width ; x++) {
            for (int y = 0; y < hieght; y++) {
                int rgb = image.getRGB(x, y);
                
                int R = (rgb >> 16) & 0xff;
                int G = (rgb >> 8) & 0xff;
                int B = (rgb >> 0) & 0xff;
               int avg = (R + B + G) / 3;
                //double Y = 0.2989 * R + 0.5870 * G + 0.1140 * B;
                pixels[y][x] = (int) avg; //avg;
             
                
                //double Y = 0.2989 * R + 0.5870 * G + 0.1140 * B;
                // System.out.print(pixels[y][x] + " ");
                // System.out.print(sample[y][x] + " ");
                sample[y][x] = 0;

                if (x == 0) {
                    sample[y][0] = pixels[y][0];
                    diff[y][0] = pixels[y][0];
                    q[y][0] = pixels[y][0];
                    deq[y][0] = pixels[y][0];
                    error[y][0] = pixels[y][0];
                } else {
                    sample[0][x] = pixels[0][x];
                    diff[0][x] = pixels[0][x];
                    q[y][0] = pixels[y][0];
                    deq[y][0] = pixels[y][0];
                    error[y][0] = pixels[y][0];

                }
                // System.out.print(diff[y][x] + " ");
            }
            //  System.out.println();

        }

            BufferedImage image3 = new BufferedImage(width, hieght, BufferedImage.TYPE_INT_RGB);
        //writer.write("c");
        for (int e = 0;  e < width ; e++) {
            for (int r = 0 ; r < hieght; r++) {
                image3.setRGB(e, r, pixels[r][e]);
            }
        }

        try {
            ImageIO.write(image3, "jpg", new File("imagee.jpg"));
         //   System.out.println("Done");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        
        
        for (int s = 1 ; s < width ; s++) {
            for (int w = 1 ; w < hieght ; w++) {
                 int n = pixels[w][s];
                 a = des[w][s - 1];
                 b = des[w - 1][s - 1];
                 c = des[w - 1][s];
                // System.out.println(n + " " + a + " " + b + " " + c);
                if (b <= Math.min(a, c)) {                  
                    sample[w][s] = Math.max(a, c);
                } else if (b >= Math.max(a, c)) {
                    sample[w][s] = Math.min(a, c);
                } else {
                    sample[w][s] = a + c - b;
                }
                // System.out.print(sample[w][s] + " ");

                diff[w][s] = pixels[w][s] - sample[w][s];  // getting the difference
                
                 for (int nl = 0; nl < nlevels ; nl++) {  // checking the range of the difference

                    if (diff[w][s] >= low[nl] && diff[w][s] <= high[nl]) {

                        q[w][s] = nl ;
                        deq[w][s] = DEQ[nl];
                    }
                }
                 
                //deocded=predictive + deQuantized
                des[w][s] = sample[w][s] + deq[w][s]; 
                
                
                //error=decoded-original
                error[w][s] = (des[w][s] - pixels[w][s]) * (des[w][s] - pixels[w][s]) ;  // getting mean square error
                sum += error[w][s];   // to get mean sqaure error
                // System.out.print(error[w][s] + " ");
            }
            // System.out.println();
            // System.out.println(sum);
        }

       // System.out.println("result" + result);
       // writer.write(result);
        MSE = sum / (width*hieght);  

        System.out.println(sum + " " + MSE);
        BufferedImage image2 = new BufferedImage(width, hieght, BufferedImage.TYPE_INT_RGB);
        //writer.write("c");
        for (int e = 0;  e < width ; e++) {
            for (int r = 0 ; r < hieght; r++) {
                image2.setRGB(e, r, des[r][e]);
            }
        }

        try {
            ImageIO.write(image2, "jpg", new File("image.jpg"));
            System.out.println("Done");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    }
    

