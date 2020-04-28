import java.io.IOException;
/**
* Binary Search Tree application main class
* 
* @author Lindelani Mbatha
*/
public class LSBSTApp {
    /**
    * application main method
    * @param <code> String [] <code> args can either be empty or 3 spaced 1-2 digit numbers, 
    * and the third param speceifies the file to search on
    */
    public static void main ( String [] args ) {
    
        int length = args.length;
        
        String file_name = length == 4 ? args[3] : "./data/data.txt";
        
        BTHelper tree = new BTHelper( file_name , new BinarySearchTree<Entry>() );
        
        if ( length == 0 ) {
            tree.printAllAreas();
        }
        else if ( length == 3 || length == 4){
            System.out.println( tree.printAreas( args[0], args[1], args[2] ) );
        }
        else {
            System.out.println("Invalid arguments to main function");
        } 
    }
    
}