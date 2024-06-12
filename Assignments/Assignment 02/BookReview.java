import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;
import java.io.InputStream;

/*
NO IMPORT STATEMENTS. NO CALLS TO SYSTEM.anything, except for 
System.out.println or print or printf as needed.
 */ 
public class BookReview {

    /**
     * Establishes a Scanner on a weblink. If the connection can not be made,
     * the method returns a null. That's how we can tell something went wrong
     * and decide what to do next.
     * @param link String with link to website with text to scan
     * @return Scanner connected to the website or null if connection cannot be made
     */
    public static Scanner connectToBook(String link) {
        Scanner bookScanner;
        try {
            URL url = new URL(link);
            URLConnection connection = url.openConnection();
            InputStream stream = connection.getInputStream();
            bookScanner = new Scanner(stream);
        } catch (Exception e) {
            bookScanner = null;
        }
        return bookScanner;
    } // method connecttoBook

    public static void main(String[] args) {
        // https://gutenberg.org/cache/epub/98/pg98.txt is a link
        // to the text of "Tale of Two Cities" from Project Gutenberg
        String book = "https://gutenberg.org/cache/epub/98/pg98.txt";
        uniqueCount(book);
    } // method main

    public static int uniqueCount(String book) {
        // Convert to lowercase, so "Hello" and "hello" are the same word
        String lower = book.toLowerCase();
        
        // Separate the lowercase string into different words
        String[] words = lower.split(" ", -1);
        
        // Create empty array "uniqueWords" to compare to the original. This is to see if each word is already used in the count.
        String[] uniqueWords = new String[words.length];
        int uniqueCount = 0;

        for (int i = 0; i < words.length; i++) {    
        /*  Skip empty strings. There are more likely than not sections in the book that include more than one space. 
            The ".split" command would create null spaces in the "uniqueWords" array that must be ignored when iterating through.
            
            The pitfall of this strategy is that it may end up with an array that includes many null elements.
            We could fix this, but for the scope of this assignment we only need to skip them with a loop that checks for it.      */
            
                if (words[i].isEmpty()) {
                continue;
            }
            // Check if the word is already in the uniqueWords array
            boolean isDuplicate = false;
            for (int j = 0; j < uniqueCount; j++) {
                if (words[i].equals(uniqueWords[j])) {
                    isDuplicate = true;
                    break;
                }
            }
            // If the word is not a duplicate, add it to the uniqueWords array
            if (!isDuplicate) {
                uniqueWords[uniqueCount] = words[i];
                uniqueCount++;
            }
        }
        return uniqueCount;
    }

} // class BookReview
