
public class Tape{
    /** Your task is to write a class named Tape to represent Turing machine tapes.
     The class should have an instance variable of type Cell that points to the current cell.
     To be compatible with the classes that will use the Tape class,
     your class must include the following method*/

    private Cell currentCell; // Current cell pointer
    public Tape() { //Constructor to create a blank tape with a single cell, which contains a blank space.
        Cell newCell = new Cell();
        newCell.content = ' ';
        newCell.prev = null;
        newCell.next = null;
        currentCell = newCell;
    }


    /** getCurrentCell Method returns the pointer that points to the current cell. */
    public Cell getCurrentCell(){
        return this.currentCell;
    }

    /** getContent Method returns the char from the current cell.*/
    public char getContent(){
        return currentCell.content;

    }

    /** setContent Method changes the char in the current cell to the specified value. */
    public void setContent(char ch) { //ch The character to be set into the current cell.
        currentCell.content = ch;
    }

    /**moves the current cell one position to the right along the tape.
     Note that if the current cell is the rightmost cell that exists,
     then a new cell must be created and added to the tape at the right of the current cell,
     and then the current cell pointer can be moved to point to the new cell.
     The content of the new cell should be a blank space.*/


    public void moveLeft(){
        if (currentCell.prev == null) {
            Cell newCell = new Cell();
            newCell.content = ' ';
            newCell.prev = null;
            newCell.next = currentCell;
            currentCell.prev = newCell;
        }
        currentCell = currentCell.prev;

    }

    /** moveRight moves the current cell one position to the right along the tape.
    Note that if the current cell is the rightmost cell that exists,
    then a new cell must be created and added to the tape at the right of the current cell,
    and then the current cell pointer can be moved to point to the new cell.
    The content of the new cell should be a blank space.*/


    public void moveRight(){
        if (currentCell.next == null) {
            Cell newCell = new Cell();
            newCell.content = ' ';
            newCell.next = null;
            newCell.prev = currentCell;
            currentCell.next = newCell;
        }
        currentCell = currentCell.next;
    }

    /** getTapeContents returns a String consisting of the chars from all the cells on the tape,
     read from left to right, except that leading or trailing blank characters should be
     discarded. The current cell pointer should not be moved by this method;
     it should point to the same cell after the method is called as it did before.
     You can create a different pointer to move along the tape and get the full contents.
     (This method is the hardest one to implement.)*/

    public String getTapeContents(){
        Cell pointer = currentCell;

        while (pointer.prev != null)
            pointer = pointer.prev;

        String strContent = "";
        while (pointer != null) {
            strContent += pointer.content;
            pointer = pointer.next;
        }

        strContent = strContent.trim(); //Returns a copy of the string, with leading and trailing whitespace omitted.
        return strContent;

    }


}
