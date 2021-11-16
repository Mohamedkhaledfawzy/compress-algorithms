
package arithmetic.coding;


public class Intervalchar {
    
    private char mychar ;
    private double low_range ; // dol el ranges eli sabta  
    private double high_range ; // dol el ranges eli sabta 
    
    Intervalchar()  // constructor
    {
        mychar = '\0';
        low_range = 0.0 ;
        high_range = 0.0 ;
    }
    Intervalchar(char mych , double low , double high)  // constructor
    {
        mychar = mych;
        low_range = low ;
        high_range = high ;
    }

    public void setMychar(char mychar) {
        this.mychar = mychar;
    }

    public char getMychar() {
        return mychar;
    }

    public void setLow_range(double low_range) {
        this.low_range = low_range;
    }

    public double getLow_range() {
        return low_range;
    }

    public void setHigh_range(double high_range) {
        this.high_range = high_range;
    }

    public double getHigh_range() {
        return high_range;
    }

    
    
    
    
}
