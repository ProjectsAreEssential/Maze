public class Location {
   
   // Instance fields
   private int row;
   private int col;
   
   // Constructor
   public Location(int row, int col) {
      this.row = row;
      this.col = col;   
   }
   
   // Gets the row
   public int getRow() {
      return row;
   }
   
   // Gets the column
   public int getCol() {
      return col;
   }
   
   // Compares two objects
   @Override
   public boolean equals(Object o) {
      if (this == o) {
         return true;
      } else if (o == null || !(o instanceof Location)) {
         return false;
      }
      
      Location other = (Location) o;
      
      if (this.row == other.row) {
         if (this.col == other.col) {
            return true;
         }
      }
      return false;
   }
   
   // Content representation
   @Override
   public int hashCode() {
      int num = 1;
      
      num = num * 31 + row;
      num = num * 31 + col;
      
      return num;
   }
   
   // String representation
   public String toString() {
      return "Location [row=" + row + ", col=" + col + "]";
   }
}