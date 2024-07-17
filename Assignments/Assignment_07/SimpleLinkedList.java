
/**
 * A basic linked list that offers stack-like and queue-like behavior.
 */
public class SimpleLinkedList implements Stack271<String>, Queue271<String> {

    /** The first node of the linked list */
    private Node head;

    /** The last node of the linked list */
    private Node tail;

    /** The used capacity of the linked list */
    private int usage;
    
    /** Arbitrary size */
    public int capacity = 100;

    public SimpleLinkedList(){
        this.head = null;
        this.tail = null;
        this.usage = 0;
    }

    public boolean push(String e) {
        Node newNode = new Node(e);
        boolean pushed = true;
        if (isFull()){
            pushed = false;
        } else {
            /** When there are no elements in the 
             * linkedList, the head AND the tail will 
             * be the newly added Node */
            
            if (head == null){
                head = newNode;
                tail = newNode;
            } else {
                /** Set the newNode to be before the Head */
                newNode.setNext(head);
                
                /** Set the newNode as the new Head */
                head = newNode;
            }
            usage++;    // Increment usage
        }
        return pushed;
    } // Push Method

    public String pull() {
        String data = null;
        
        /** If the list is NOT empty */
        if (head != null) {
            
            /** Take the data from the current head */
            data = head.toString();
            
            /** Set the next Node in line as head */
            head = head.getNext();
            
            usage--;    // Lower the usage by 1
            
             /** if there are no elements in the list
              * anymore, set the tail to also be null.*/
            if (head == null) {
                tail = null;
            }

        }
        return data;
    } // Pull Method

    public boolean add(String e) {
        Node newNode = new Node(e);
        boolean added = true;
         
        if (isFull()){
            added = false;
        } else {
            /** When there are no elements in the 
             * linkedList, the head AND the tail will 
             * be the newly added Node */ 
            //[Yes, this is the same as the one above]

            if (tail == null) {
                head = newNode;
                tail = newNode;
            } else {
                /** Set the added Node after the tail */
                tail.setNext(newNode);
                /** Set the new Node as tail */
                tail = newNode;
            }
    }
        return added;
    } // Add method

    public String remove() {
        String data = null;
        
        /** Set the next Node in line as head */
        if (head != null){
            /** Take the data from Head */
            data = head.toString();
            /** Set the head as the next Node */
            head = head.getNext();
            usage--;    // Lower the usage by 1

            /** if there are no elements in the list
              * anymore, set the tail to also be null.*/ 
              //[This is ALSO the same as above]
            if (head == null) {
                tail = null;
            }
        }
        return data;
    } // remove method

    /** I believe having an isFull method is the best way of ensuring usage does not exceed capacity */
    public boolean isFull(){
        boolean isFull = false;
        if (usage > capacity){
            isFull = true;
        }
        return isFull;
    } //isFull method
} // class SimpleLinkedList
