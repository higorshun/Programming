/*
    This applet demonstrates stack and queue operations.  The applet shows
    a grid of squares.  When the user clicks on one of the squares, a computation
    is begun that visits all the squares of the grid.   As the squares
    are "encountered", they are colored red.  Red squares have been encountered
    but not yet processed.  A square is processed by adding its horizontal
    and vertical neighbors to the set of encountered squares, if they have
    not previously been encountered.  Once a square has been processed in
    this way, it is "finished", and it is colored gray.  At the end of the
    process, all the squares are gray.
       The question is, how does the program decide which red square to
    process?  There can be many red squares waiting for processing.
    The users can specify one of three methods for deciding which square
    to process:  with a stack, with a queue, or at random.  If the random
    method is chosen, then a red square is chosen for processing at random
    from among all the red squares.  If a queue is used, the red squares
    are stored on a queue and are processed in FIFO order.  If a stack
    is used, then the squares are processed in LIFO order.
       (Note:  If the user clicks on a white square while a computation is
    already running, then that square will be "encountered" and added to
    the set of red squares.)
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class DepthBreadth extends JApplet
        implements ActionListener, MouseListener {
                
   /*  All the auxiliary classes used in this program are defined as
       static nested classes.
   */

    static class Location {
        // Represents one square in the grid, by specifying the
        // row number and column number where it is found.
        int row;
        int column;
        Location(int r, int c) {
            // Constructor, specifying the row and column of a square.
            row = r;
            column = c;
        }
    }  // end nested class Location


    static class Node {
        // Represents a node in a linked list of Locations.  Both the
        // Stack and the Queue class use this type of linked list.
        Location loc;  // Represents one square in the grid.
        Node next;     // Pointer to next Node in the linked list.
    }  // end nested class Node


    static class Stack {
        // A stack of Locations, with the standard operations,
        // plus a getSize() method that returns the number of
        // Locations on the stack.
        private Node top = null;  // Pointer to the top of the stack.
        private int size = 0;     // Number of items on the stack.
        void push(Location loc) {
            // Add the specified location to the top of the stack.
            Node newTop = new Node();
            newTop.loc = loc;
            newTop.next = top;
            top = newTop;
            size++;
        }
        Location pop() {
            // Remove and return the top Location on the stack.
            // Note that this can throw a NullPointerException if
            // it is called when the stack is empty.
            Location topItem = top.loc;
            top = top.next;
            size--;
            return topItem;
        }
        boolean isEmpty() {
            // Return true if the stack is empty.
            return top == null;
        }
        int getSize() {
            // Return the number of Locations on the stack.
            return size;
        }
    }  // end nested class Stack


    static class Queue {
        // A queue of Locations, with the standard operations,
        // plus a getSize() method that returns the number of
        // Locations on the queue.
        private Node head = null;  // Points to first Node in the queue.
        private Node tail = null;  // Points to last Node in the queue.
        private int size;   // Number of items on the queue.
        void enqueue(Location loc) {
            // Add the specified Location to the end of the queue.
            Node newTail = new Node();
            newTail.loc = loc;
            if (head == null) {
                head = newTail;
                tail = newTail;
            }
            else {
                tail.next = newTail;
                tail = newTail;
            }
            size++;
        }
        Location dequeue() {
            // Remove and return the first item in the queue.
            // Note that this can throw a NullPointerException.
            Location firstItem = head.loc;
            head = head.next;
            if (head == null)
                tail = null;
            size--;
            return firstItem;
        }
        boolean isEmpty() {
            // Return true if the queue is empty.
            return head == null;
        }
        int getSize() {
            // Return the number of items on the queue.
            return size;
        }
    }  // end nested class Queue



    /* Instance variables for the DepthBreadth class */


    final static int SQUARE_SIZE = 12;  // Size of one square in the grid.

    int rows;     // Number of rows in the grid.  This depend on the size of the applet.
    int columns;  // Number of columns in the grid.  This depend on the size of the applet.

    boolean[][] encountered;  // encountered[r][c] is set to true when a square is
    //   first encountered.  (See comment at top of file.)
    //   A square that has been encountered but not
    //   finished is red.

    boolean[][] finished;     // finished[r][c] is set to true when a square is
    //   finished (i.e. processed).  Finished squares are gray.

    JButton abortButton;  // User can click this to terminate the computation.

    JLabel message;   // For displaying information to the user.

    JComboBox methodChoice;   // For selecting the method of
    //   selecting which red square to process.

    final static int STACK = 0,     // Possible values for the method.
            QUEUE = 1,
            RANDOM = 2;

    int method;   // Used to hold the selected method while a
    //    computation is running.

    Timer timer;  // A timer that drives the computation.
    // When no computation is in progress, timer is null.

    Queue queue = null;           // Exactly one of these is used to store the
    Stack stack = null;           //   red squares while the computation is running.
    ArrayList randomList = null;  //   Which one is used depends on the method.

    Content content;   // Content pane belonging to nested class.

    public void init() {
        // Initialize the applet.  Use a null layout and set the bounds
        // of the components in the applet directly.  The applet listens
        // for mouse clicks on itself.

        content = new Content();
        setContentPane(content);

        content.setLayout(null);
        content.setBackground(new Color(220,220,255));
        content.setBorder(BorderFactory.createMatteBorder(2,2,2,2,Color.blue));
        content.addMouseListener(this);
      
      /* Determine the number of rows and columns and create the
         encountered and finished arrays. */

        int width = getWidth();;
        int height = getHeight();

        rows = (height - 100) / SQUARE_SIZE;
        columns = (width - 20) / SQUARE_SIZE;

        encountered = new boolean[rows][columns];
        finished = new boolean[rows][columns];

        /* Create the components. */

        Font labelFont = new Font("Helvetica",Font.PLAIN,14);

        message = new JLabel("Click any square to begin.",JLabel.CENTER);
        message.setForeground(Color.blue);
        message.setFont(labelFont);

        methodChoice = new JComboBox();
        methodChoice.addItem("Stack");
        methodChoice.addItem("Queue");
        methodChoice.addItem("Random");
        methodChoice.setBackground(Color.white);

        abortButton = new JButton("Abort");
        abortButton.setEnabled(false);
        abortButton.addActionListener(this);
        abortButton.setBackground(Color.lightGray);

        JLabel lb = new JLabel("Use:", JLabel.RIGHT);  // An unchanging informational label.
        lb.setForeground(Color.blue);
        lb.setFont(labelFont);

        /* Add the components to the applet and set their sizes and positions. */

        content.add(message);
        content.add(lb);
        content.add(methodChoice);
        content.add(abortButton);

        message.setBounds(15, height-80, width-30, 18);
        lb.setBounds(15, height-54, 50, 18);
        methodChoice.setBounds(75, height-56, width-150, 22);
        abortButton.setBounds(75, height-29, width-150, 22);

    } // end init();


    public void mousePressed(MouseEvent evt) {
        // The user has clicked the mouse on the applet.  If the
        // user has clicked on a position in the grid, start a
        // computation to start processing from that square, or if a
        // computation is already running, "encounter" the square.
        int row = (evt.getY() - 10) / SQUARE_SIZE;
        int col = (evt.getX() - 10) / SQUARE_SIZE;
        if (row < 0 || row >= rows || col < 0 || col >= columns)
            return;
        if (timer == null) {
            // Start a new computation at the point where the user clicked.
            startComputation(row,col);
        }
        else {
            // A computation is already in progress.
            // Mark the square where the user clicked as encountered.
            encounter(row,col);
            content.repaint(10, 10, columns*SQUARE_SIZE, rows*SQUARE_SIZE);
        }
    } // end mousePressed()


    public void actionPerformed(ActionEvent evt) {
        // When the user clicks the button, call doAbort().
        // Otherwise, this is a Timer event, so do the next
        // step in the computation.
        if (evt.getSource() == abortButton)
            doAbort();
        else
            continueComputation();
    }



    void startComputation(int startRow, int startCol) {
        // Begin a new computation.
        // Set all the squares back to unencountered and start
        // a timer that will process the squares beginning with
        // the square at (startRow,startCol).
        for (int r = 0; r < rows; r++)
            for (int c = 0; c < columns; c++) {
                encountered[r][c] = false;
                finished[r][c] = false;
            }
        method = methodChoice.getSelectedIndex();
        switch (method) {
            case STACK:
                stack = new Stack();
                message.setText("Using a stack.");
                break;
            case QUEUE:
                queue = new Queue();
                message.setText("Using a queue.");
                break;
            case RANDOM:
                randomList = new ArrayList();
                message.setText("Using a randomized list.");
                break;
        }
        abortButton.setEnabled(true);
        methodChoice.setEnabled(false);
        encounter(startRow,startCol);
        content.repaint(10, 10, columns*SQUARE_SIZE, rows*SQUARE_SIZE);
        timer = new Timer(100,this);
        timer.start();
    }

    public void continueComputation() {
        // Do one step in a computation, by processing
        // one location from the stack, queue, or arraylist.
        // If no more items are available, finish the computation.
        Location loc = removeItem();
        if (loc != null) {
            finish(loc.row, loc.column);
        }
        else {
            // All squares have already been "finished".  The
            // computation is complete.
            timer.stop();
            timer = null;
            methodChoice.setEnabled(true);
            abortButton.setEnabled(false);
            message.setText("Click any square to begin.");
            queue = null;
            stack = null;
            randomList = null;
        }
        content.repaint(10, 10, columns*SQUARE_SIZE, rows*SQUARE_SIZE);
    }


    void doAbort() {
        // Stop the computation, if one is running.  This is called
        // when the user clicks the Abort button.
        if (timer != null) {
            timer.stop();
            timer = null;
            methodChoice.setEnabled(true);
            abortButton.setEnabled(false);
            message.setText("Click any square to begin.");
            queue = null;
            stack = null;
            randomList = null;
        }
    }


    Location removeItem() {
        // Get the next item to be processed from the appropriate
        // data structure.  The data structure that is being used
        // depends on the method.  If the data structure is
        // empty, return null.  Also, display the size of the
        // data structure to the user.
        Location loc = null;
        switch (method) {
            case STACK:
                if ( ! stack.isEmpty() )
                    loc = stack.pop();
                message.setText("Stack size is " + stack.getSize());
                break;
            case QUEUE:
                if ( ! queue.isEmpty() )
                    loc = queue.dequeue();
                message.setText("Queue size is " + queue.getSize());
                break;
            case RANDOM:
                if ( randomList.size() > 0 ) {
                    int index = (int)(randomList.size()*Math.random());
                    loc = (Location)randomList.get(index);
                    randomList.remove(index);
                }
                message.setText("List size is " + randomList.size());
                break;
        }
        return loc;
    }


    void encounter(int r, int c) {
        // If there is a square at (r,c) that has not already been encountered,
        // encounter it and add it to the data structure.  The data structure
        // that is used depends on the method.  Since the square changes from
        // white to red, redraw it.   Also, display the size of the data structure.
        if (r < 0 || r >= rows || c < 0 || c >= columns || encountered[r][c] == true)
            return;
        Location loc = new Location(r,c);
        switch (method) {
            case STACK:
                stack.push(loc);
                message.setText("Stack size is " + stack.getSize());
                break;
            case QUEUE:
                queue.enqueue(loc);
                message.setText("Queue size is " + queue.getSize());
                break;
            case RANDOM:
                randomList.add(loc);
                message.setText("List size is " + randomList.size());
                break;
        }
        encountered[r][c]  = true;
    }


    void finish(int r, int c) {
        // Process the red square at (r,c) by encountering
        // its horizontal and vertical neighbors.  The
        // square will change from red to gray, so redraw it.
        encounter(r-1,c);
        encounter(r+1,c);
        encounter(r,c-1);
        encounter(r,c+1);
        finished[r][c] = true;
    }


    public void start() {
        // When applet is restarted, resume running the
        // suspended computaion, if there is one.
        if (timer !=null) {
            timer.restart();
        }
    }


    public void stop() {
        // When applet is stopped, suspend the computation, if there
        // is one, by stopping the timer.
        if (timer != null) {
            timer.stop();
        }
    }


    public void mouseReleased(MouseEvent e) { }  // Methods required by MouseListener interface
    public void mouseClicked(MouseEvent e) { }
    public void mouseEntered(MouseEvent e) { }
    public void mouseExited(MouseEvent e) { }


    class Content extends JPanel {
        // nested class Content simply provides redrawing
        // of the applet's content pane.

        public void paintComponent(Graphics g) {
            // Paint the applet, showing the grid of squares.

            super.paintComponent(g);   //Fill with background color

            int width = getWidth();;
            int height = getHeight();

         /* Fill the area occupied by the grid with white, then draw
            black lines around this area and between the squares of
            the grid. */

            g.setColor(Color.white);
            g.fillRect(10, 10, columns*SQUARE_SIZE, rows*SQUARE_SIZE);

            g.setColor(Color.black);
            for (int i = 0; i <= rows; i++)
                g.drawLine(10, 10 + i*SQUARE_SIZE, columns*SQUARE_SIZE + 10, 10 + i*SQUARE_SIZE);
            for (int i = 0; i <= columns; i++)
                g.drawLine(10 + i*SQUARE_SIZE, 10, 10 + i*SQUARE_SIZE, rows*SQUARE_SIZE + 10);

         /* Fill "encountered" squares with red and "finished" squares with gray.
            Other squares remain white.  */

            for (int r = 0; r < rows; r++)
                for (int c = 0; c < columns; c++) {
                    if (finished[r][c]) {
                        g.setColor(Color.gray);
                        g.fillRect(11 + c*SQUARE_SIZE, 11 + r*SQUARE_SIZE, SQUARE_SIZE - 1, SQUARE_SIZE - 1);
                    }
                    else if (encountered[r][c]) {
                        g.setColor(Color.red);
                        g.fillRect(11 + c*SQUARE_SIZE, 11 + r*SQUARE_SIZE, SQUARE_SIZE - 1, SQUARE_SIZE - 1);
                    }
                }

        } // end paintComponent();

    } // end nested class Content


} // end class DepthBreadth