
package assilz77;


public class Tag {
    
    private int pointer ;
    private int length ;
    private char next_char ;

    public void setPointer(int pointer) {
        this.pointer = pointer;
    }
    public int getPointer() {
        return pointer;
    }

    public void setLength(int length) {
        this.length = length;
    }
    public int getLength() {
        return length;
    }

    public void setNext_char(char next_char) {
        this.next_char = next_char;
    }
    public char getNext_char() {
        return next_char;
    }
    public void print(){
        System.out.println("<"+this.getPointer()+","+this.getLength()+","+this.getNext_char()+">");
    }
    
  
    
}
