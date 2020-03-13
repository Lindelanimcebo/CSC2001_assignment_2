/**
* This is a model class to hold Loadshedding slot and area information
*@ implements Comparable 
*
*@author Lindelani Mbatha
**/
public class Entry implements Comparable<Entry>{

    private String slot;
    private String areas;
    
    /**
    * Entry Constructor
    * @param slot is a string representing the slot
    * @param areas is a String representing the areas
    * 
    * 
    */   
    public Entry(String slot, String areas) {
        this.slot = slot;
        this.areas = areas;
    }
    
    /**
    * Entry dummy constructor
    * @param slot is a String representing the slot
    * used to check if slots are equal
    */
    public Entry ( String slot ) {
        this( slot , "");
    }
    
    /**
    * Gets the areas affected by the slot
    * @return a <code> String </code> representing the
    * areas
    */   
    public String getAreas () {
        return areas;
    }
    
    /**
    * Gets the slot
    * @return a <code> String </code> representing the
    * slot
    */
    public String getSlot () {
        return this.slot;
    }

    /**
    * Checks for equality through slots
    * @param stage is the stage as a String
    * @param day is the day as a String
    * @param time is the time as a String
    * @return a <code> boolean </code> indicating
    * if the provided slot equals the current slot
    */
    public boolean equals ( String stage, String day, String startTime) {
        return ( this.slot.equals( stage+"_"+day+"_"+startTime ) );
    }
    
    /**
    * Checks if this object equals another
    * @param other is the other Entry object
    * @return a <code> boolean </code> indicating
    * equality
    **/   
    public boolean equals ( Entry other) {
        return this.slot.equals( other.getSlot() );
    }
    
    /**
    * Compares this slot and other based on String precedence
    * @param other is the other Entry object 
    * @returns an <code> int </code> that
    * = 0 if the objects are equal, > 0 if this comes before other, < 0 if this comes after other
    */
    public int compareTo ( Entry other) {
        return this.slot.compareTo( other.getSlot() );
    }
    
    
    /**
    * to print the slot and area
    * @return a <code> String </code> in the format
    * Slot ${slot} \n Areas ${areas}
    */    
    public String toString() {
        return "Slot " + slot + "\n" + "Areas : " + areas;
    }

}