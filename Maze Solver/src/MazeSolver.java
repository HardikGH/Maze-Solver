import java.util.LinkedList;
import java.util.Scanner;
import java.io.File;

/* Maze Solver
 * This class coordinates the loading and parsing of a 'maze' datafile, the creation of
 * a Maze object (which you'll be writing), and the invocation of the Maze's solve()
 * method (which you'll obviously also be writing).
 * It also handles file input and tells the Maze object to output the maze status and
 * solution (again, tasks you'll be implementing yourself).
 *
 * Three sample floors (floor1.txt - floor3.txt) are included.
 */

public class MazeSolver {
    char[][] charmap = null; // 2D array to represent the maze
    int startRow = -1; // Starting row position
    int startCol = -1; // Starting column position
    // LinkedList to trace the solution path
    LinkedList<Character> trace = new LinkedList<>();

    public MazeSolver() {
        // Constructor for MazeSolver class
    }

    private void loadMaze() {
        int height, width; // Dimensions of the maze
        String filename; // Filename for maze data
        Scanner console = new Scanner(System.in); // Input scanner for console
        Scanner file; // Scanner for file input
        String temp; // Temporary string to read lines from the file

        // Prompt user for the maze filename
        System.out.print("Enter maze filename: ");
        filename = console.nextLine();

        try {
            // Initialize file scanner
            file = new Scanner(new File(filename));

            // Read height and width from the file
            height = file.nextInt();
            width = file.nextInt();
            charmap = new char[height][width]; // Initialize the maze array
            file.nextLine(); // Move to the next line after reading dimensions

            // Read maze data from the file
            for (int i = 0; i < height; i++) {
                temp = file.nextLine(); // Read a line of the maze
                charmap[i] = temp.toCharArray(); // Convert line to char array
                // Find the starting position marked by 'S'
                if (temp.indexOf('S') >= 0) {
                    startRow = i; // Set starting row
                    startCol = temp.indexOf('S'); // Set starting column
                    System.out.println("Start at " + startRow + "," + startCol + ".");
                }
            }

            System.out.println("File transcription complete!\n"); // Notify user of successful load
        } catch (Exception exn) {
            // Handle file reading exceptions
            System.out.println("\nFile transcription problem. Exiting now.");
            System.exit(0); // Exit if there's an error
        }

        solve(); // Call the solve method to find a solution to the maze
    }

    private void solve() {
        System.out.println("Initial State:"); // Print initial maze state
        printMap(); // Print the maze

        // Attempt to solve the maze starting from the initial position
        if (recursiveSolve(startRow, startCol)) {
            System.out.println("\nFinal Maze:"); // Print final maze state
            printMap(); // Print the maze after solving
            System.out.print("Solution Path: ");
            // DISPLAY SOLUTION PATH HERE
            for (char path : trace) {
                System.out.print(path + " "); // Print the solution path
            }
        } else {
            System.out.println("Oops! No solution found!"); // Notify if no solution exists
        }
    }

    // Recursive method to solve the maze
    private boolean recursiveSolve(int row, int col) {
        // Check for out-of-bounds or obstacles
        if (row < 0 || col < 0 || row >= charmap.length || col >= charmap[0].length || charmap[row][col] == 'O') {
            return false; // Return false if invalid move
        } else {
            // Check if the current position is the goal 'K'
            if (charmap[row][col] == 'K') {
                return true; // Return true if goal is reached
            }
        }

        // Check if the current position has already been visited
        if (charmap[row][col] == '1') {
            return false; // Return false if visited
        } else {
            // Mark the current position as visited
            charmap[row][col] = '1';
            // Try moving in each direction: Up, Right, Down, Left
            if (recursiveSolve(row - 1, col)) { // Up
                trace.addFirst('U'); // Add move to trace
                return true; // Return true if path is found
            }
            if (recursiveSolve(row, col + 1)) { // Right
                trace.addFirst('R'); // Add move to trace
                return true; // Return true if path is found
            }
            if (recursiveSolve(row + 1, col)) { // Down
                trace.addFirst('D'); // Add move to trace
                return true; // Return true if path is found
            }
            if (recursiveSolve(row, col - 1)) { // Left
                trace.addFirst('L'); // Add move to trace
                return true; // Return true if path is found
            }
        }
        return false; // Return false if no path is found
    }

    // Method to print the maze
    private void printMap() {
        for (char[] row : charmap) {
            for (char c : row) {
                System.out.print(c); // Print each character in the row
            }
            System.out.println(); // Move to the next line after printing a row
        }
    }

    // Main method to run the maze solver
    public static void main(String args[]) {
        new MazeSolver().loadMaze(); // Create a new MazeSolver instance and load the maze
    }
}