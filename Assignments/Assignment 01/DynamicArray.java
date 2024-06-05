/*
 * To save this assignment, make sure you commit your changes to your GitHub repository,
 * following the instructions in Sakai. IF YOU DO NOT COMMIT THE CHANGES, IT IS POSSIBLE THAT
 * YOUR WORK MAY BE LOST AND YOU MAY HAVE TO START ALL OVER AGAIN.
 */
public class DynamicArray {

    /** The underlying array for this object */
    private String[] data;

    /** Currently available position in array data */
    private int position;

    /** Constant with default size */
    private static final int DEFAULT_SIZE = 10;

    /**
     * Basic constructor for the object
     * @param size initial size of array data
     */
    public DynamicArray(int size) {
        this.data = new String[size];
        this.position = 0;
    } // basic constructor

    /** Default constructor */
    public DynamicArray() {
        this(DEFAULT_SIZE);
    } // default constructor

    /**
     * Adds a new item to array data after ensurig there is 
     * sufficient room by resizing the array if necessary.
     * @param string new item to add to array
     */
    public void add(String string) {
    /* Make sure there is room in array data*/
        if (this.position == this.data.length) {
            resize();
        }
    /* Now array has room for more elements.*/
        this.data[this.position] = string;
        this.position++;
    } // method add
    
    public void resize() {
    /*create "newArray" being 10 elements bigger than the original*/   
        String[] newArray= new String[size + 10];

        for(int x; x<data.length; x++){
            newArray[x] = data[x];
        }
    } // method resize

    public boolean contains(String string) {
        boolean contains = false;
    /*While we haven't found the string we are looking for yet: */
        while (!contains){
    /*If we find the string we want, set contains to true & break from the loop*/
            if (data == string){
                contains = true;
                break;
            }
    /*Break if we reach the end of the list*/
            if (data.position == data.length){
                break;
            }
    /*Bring us to the next element of the array*/
            data.position++;
        }
        return contains;

    } // method contains

    public int count(String string) {
        int count = 0;
        while(data.length){
    /*If the element of the array is the same as the input string*/
            if (data[data.position] == string){
                //Add to the counter
                count++;
            }
             //Add to increase the element position.
            data.position++;
        }
        return count;
    } // method count

    public boolean addUnique (String string) {
    /*boolean: we want to know if adding the string we input is a success.*/
        boolean success = !this.contains(string);
        if (sucess){
            this.add(string);
        }
        return success;
    } // method addUnique

} // class DynamicArray