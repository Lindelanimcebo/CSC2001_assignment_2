import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**
* This is a Helper class to handle operations of the Binary Tree.
* The binary tree can be AVL or Binary Search Tree.
* @author Lindelani Mbatha
*/
public class BTHelper {
    
    private BinaryTree<Entry> tree;
    private File file;
    private Scanner scanner;
    
    /**
    * Constructor to initialise instance variables and add entries to the Binary Search tree
    * @param file is a string representing the file path
    * @see #addEntries()
    */
    public BTHelper ( String file, BinarySearchTree<Entry> tree ){
        this.tree = tree;
        addEntries( file );
    }

    /**
    * Constructor to initialise instance variables and add entries to the AVL tree
    * @param file is a string representing the file path
    * @see #addEntries()
    */
    public BTHelper ( String file, AVLTree<Entry> tree ){
        this.tree = tree;
        addEntries( file );
    }

    /**
    * Helper method to add entries from the file to the Binary tree
    */
    private void addEntries ( String file ) {
        try{
            this.file = new File( file );
            this.scanner = new Scanner( this.file );

            while (scanner.hasNextLine() ){
                String line[] = scanner.nextLine().split(" ",2);
                this.tree.insert( new Entry( line[0], line[1] ) );
            }

        } catch(Exception e){
            e.printStackTrace();
        }
    }
    
    /**
    * Finds the entry from the Binary tree
    * @param other is an Entry object in question
    * @return an Entry object with the data of the found BianryTreeNode
    */
    public Entry find ( Entry other ) {
        BinaryTreeNode<Entry> result  = tree.find(other);
        return result == null ? null : result.data;
    }
    
    /**
    * finds the Entry with a specific slot
    * @param slot is the slot to find
    * @return Entry object with the slot
    * @see #find( Entry other )
    */
    public Entry find ( String slot ) {
        return this.find( new Entry(slot) );
    }
    
    /**
    * Prints areas of a specif slot
    * @param stage is the stage string
    * @param day is the string day
    * @param startTime is the string start time
    * @returns a <code> String </code> with the results
    */   
    public String printAreas ( String stage , String day , String time) {
    
        Entry entry = this.find( stage+"_"+day+"_"+time );
        
        return ( entry == null ? "No Areas Found " : "The areas are: "+entry.getAreas()+
        "\n"+
        "insert\tfind"+
        "\n"+
        ( ( tree.getInsertCounter() ) + "\t" + ( tree.getComparisonCounter() ) )
        );
    }
    
    /**
    * void function to print all areas
    */    
    public void printAllAreas () {
        tree.inOrder();        
    }
    
}