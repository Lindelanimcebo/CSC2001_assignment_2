import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
* This is a helper class to manage file operations
* 
* @see java.io.File
* @see java.util.Scanner
* @author Lindelani Mbatha
*/
public class FileHelper{
    
    private File file;
    private Scanner scanner;
    
    /**
    * FileHelper constructor
    *@param file is a path of the file
    */
    public FileHelper ( String file) {
     
        try {
            this.file = new File(file);
            this.scanner = new Scanner(this.file);
            
        } catch (Exception e) {
            System.out.println("Error Reading the file: ");
            e.printStackTrace();        
        }
        
    }
    
    /**
    * Checks for next line
    * @return a <code> boolean </boolean>
    * Specifies existence of a next line
    */
    public boolean hasNextLine(){
        return scanner.hasNextLine();
    }
    
    /**
    * Reads next line on a file
    * @return <code> Entry </code> representing
    * each line an Entry object
    */
    public Entry readLine(){
     
        String line = scanner.nextLine();
        int index = line.lastIndexOf("_")+3; 
        String slot = (line.substring(0, index)).trim();
        String areas = (line.substring(index)).trim();
        
        return new Entry( slot , areas );
    }
    
    /**
    * Prints all lines of the files
    */
    public void printFile () {
        System.out.println("File : "+this.file.getName());
        while( scanner.hasNextLine() ) {
            String data = scanner.nextLine();
            System.out.println(data);
        }
        scanner.close();
        System.out.println("**************DONE************");    
    }
    
    /**
    * @return a <code> String </code> representing
    * the file name
    */
    public String toString(){
        return this.file.getName();
    }
        
}