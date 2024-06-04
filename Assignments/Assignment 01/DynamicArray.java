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
        // Make sure there is room in array data
        if (this.position == this.data.length) {
            resize();
        }
        // Now array has room for more elements.
        this.data[this.position] = string;
        this.position++;
    } // method add
    
    public void resize() {
        //create "newArray" with the size being 10 positions bigger than the original string   
        String[] newArray= new String[size + 10];

        for(int x; x<data.length; x++){
            newArray[x] = data[x];
        }
    } // method resize

    public boolean contains(String string) {
        boolean contains = false;
        //While the array doesn't have the
        while (!contains){
            if (data == string){
                contains = true;
            }
        }
        return contains;

    } // method contains

    public int count(String string) {
        int count = 0;
        while(data.length){
            if (data[data.position] == string){ //If the element of the array is the same as the input string
                count++;    //Add to the counter
            }
            data.position++;    //Add to increase the element position.
        }
        return count;
    } // method count

    public boolean addUnique (String string) {
        //boolean because we want to know if adding the string we input is a success.
        boolean success = !this.contains(string);
        if (sucess){
            this.add(string);
        }
        return success;
    } // method addUnique

} // class DynamicArray