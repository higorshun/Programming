package peerswork.week3;

public class Tape {


    private Cell currentCell; // Points to current cell.

    public Tape() {
        Cell cell = new Cell();
        cell.content = ' ';
        cell.prev = null;
        cell.next = null;
        currentCell = cell;
    }

    /**
     * Returns the pointer that points to the current cell.
     *
     * @return Pointer to the current cell.
     */
    public Cell getCurrentCell() {
        return currentCell;
    }

    /**
     * Returns the char from the current cell.
     *
     * @return The char from the current cell.
     */
    public char getContent() {
        return currentCell.content;
    }

    /**
     * Changes the char in the current cell to ch.
     *
     * @param ch Char to change the current cell to contain.
     */
    public void setContent(char ch) {
        currentCell.content = ch;
    }

    /**
     * Moves the current cell one position to the left along the tape.
     */
    public void moveLeft() {
        if (currentCell.prev == null) {

            Cell cell = new Cell();
            cell.content = ' ';
            cell.prev = null;
            cell.next = currentCell;

            currentCell.prev = cell;
            currentCell = cell;
        } else {
            currentCell = currentCell.prev;
        }
    }

    /**
     * Moves the current cell one position to the right along the tape.
     */
    public void moveRight() {
        if (currentCell.next == null) {
            Cell cell = new Cell();
            cell.content = ' ';
            cell.next = null;
            cell.prev = currentCell;

            currentCell.next = cell;
            currentCell = cell;
        } else {
            currentCell = currentCell.next;
        }
    }

    /**
     * Returns a String consisting of the chars from all the cells on the tape, read
     * left to right, except that leading or trailing blank characters should be
     * discarded.
     *
     * @return a String consisting of the chars from all the cells on the tape, read
     * from left to right.
     */
    public String getTapeContents() {

        Cell runner = currentCell;

        // After the loop, runner should point to the farthest left cell.
        while (runner.prev != null) {
            runner = runner.prev;
        }

        // StringBuilder makes handing the string append operation easier.
        StringBuilder sb = new StringBuilder();

        while (runner != null) {
            sb.append(runner.content);
            runner = runner.next;
        }

        // Returns a string with leading and trailing spaces removed trimmed.
        return sb.toString().trim();
    }


}
