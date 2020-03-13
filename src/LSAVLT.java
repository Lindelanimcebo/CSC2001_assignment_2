/**
* This is a model class to stro and handle operations of the AVL Tree
*
* @author Lindelani Mbatha
*/
public class LSAVLT {
    
    private AVLTree<Entry> tree;
    private FileHelper helper;
    
    /**
    * Constructor to initialise instance variables and add entries to the AVL tree
    * @param file is a string representing the file path
    * @see #addEntries()
    */
    public LSAVLT ( String file) {
        
        tree = new AVLTree<Entry>();
        helper = new FileHelper( file );
        
        this.addEntries();
    }
    
    /**
    * Helper method to add entries from the file to the AVL tree
    */
    private void addEntries () {
        
        while( helper.hasNextLine() ){
            tree.insert( helper.readLine() );
        }
        
    }
    
    /**
    * Finds the entry from the AVL tree
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