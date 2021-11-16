
package arithmetic.coding;


public class Unichar {
    
   private char mychar ;
   private int count ;
   private double propability ;
   private double commu_prop ;
    
  /*  Unichar ()
    {
        mychar = '\0';
        count = 0 ;
        propability = 0.0 ;
        commu_prop = 0.0 ;
    }
    
    Unichar (char mych , int cou , double pro , double com_p )
    {
        mychar = mych ;
        count = cou ;
        propability = pro ;
        commu_prop = com_p ;
    }
*/
    public void setMychar(char mychar) {
        this.mychar = mychar;
    }

    public char getMychar() {
        return mychar;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void setPropability(double propability) {
        this.propability = propability;
    }

    public double getPropability() {
        return propability;
    }

    public void setCom_prop(double com_prop) {
        this.commu_prop = com_prop;
    }

    public double getCom_prop() {
        return commu_prop;
    }
    
    
    
}
