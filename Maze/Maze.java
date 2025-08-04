import java.util.*;

public class Maze {
   
   // Instance fields
   private char[][] grid; // Maze data
   private Location start; // Store the start
   private Location end; // Store the end
   
   // Constructor 
   public Maze() {
      grid = new char[][] {
         {'#', '#', '#', '#', 'E'},
         {'#', ' ', '#', '#', ' '},
         {'#', ' ', ' ', ' ', ' '},
         {'#', ' ', '#', ' ', '#'},
         {'S', ' ', '#', '#', '#'}
      };
      
      for (int i = 0; i < grid.length; i++) {
         for (int j = 0; j < grid[0].length; j++) {
            if (grid[i][j] == 'S') {
               start = new Location(i, j);
               System.out.println("Start location found at: (" + start.getRow() + ", " + start.getCol() + ")");
            }
            
            if (grid[i][j] == 'E') {
               end = new Location(i, j);
               System.out.println("End location found at: (" + end.getRow() + ", " + end.getCol() + ")");
            }  
         }
      }
      
      if (start == null || end == null) {
         System.out.println("Start or End is missing");
      }
   }
   
   // Maze exploration
   public boolean exploreMazeWithStack() {
      Stack<Location> stack = new Stack<>();
      Set<Location> visited = new HashSet<>();
      int[][] moves = {
               {-1, 0},
               {1, 0},
               {0, -1}, 
               {0, 1}
            };
      
      stack.push(start);
      
      while (!stack.isEmpty()) {
         Location current = stack.pop();
         System.out.println("Exploring location: (" + current.getRow() + ", " + current.getCol() + ")");
         
         if (visited.contains(current)) {
            continue;
         } else if (current.equals(end)) {
            return true;
         } else {
            visited.add(current);
         }
         
         for (int[] move : moves) {
            int newRow = current.getRow() + move[0];
            int newCol = current.getCol() + move[1];
            
            if (newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length) {
               if (grid[newRow][newCol] != '#') {
                  Location neighbor = new Location(newRow, newCol);
                  if (!visited.contains(neighbor)) {
                     stack.push(neighbor);
                     System.out.println("Adding neighbor: (" + neighbor.getRow() + ", " + neighbor.getCol() + ")");
                  }
               }
            }
         }
      }
      
      return false;
   }
}