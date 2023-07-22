
/*
 * Class: CMSC203 
 * Instructor: Grinberg
 * Description: TwoDimRaggedArray class 
 * Due: 7/24/2023
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently.
*  I have not copied the code from a student or any source. 
*  I have not given my code to any student.
*  Print your Name here: Talia Kouncar
*/
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class TwoDimRaggedArrayUtility {

	private TwoDimRaggedArrayUtility() {
		// Don't need to add anything in constructor since this class contains static
		// utility methods
	}

	/**
	 * Reads from a file and returns a ragged array of doubles The maximum rows is
	 * 10 and the maximum columns for each row is 10 Each row in the file is
	 * separated by a new line Each element in the row is separated by a space
	 * 
	 * @param file
	 * @return
	 * @throws FileNotFoundException
	 */
	public static double[][] readFile(File file) throws FileNotFoundException {
		// Max rows and columns
		final int MAX_ROW = 10;
		final int MAX_COLUMN = 10;

		/// Temp array to hold data
		String[][] arrayTemp = new String[MAX_ROW][MAX_COLUMN];

		// Initialize temparray with nulls
		for (int i = 0; i < MAX_ROW; i++) {
			for (int j = 0; j < MAX_COLUMN; j++) {
				arrayTemp[i][j] = null;
			}
		}

		// Read from the file and fill in temp array
		int rows = 0;
		int[] colPerRow = new int[MAX_ROW];
		try (Scanner scanner = new Scanner(file)) {
			while (scanner.hasNextLine() && rows < MAX_ROW) {

				// Refrences:
				// https://stackoverflow.com/questions/40090776/what-does-s-split-s-means-here-in-the-below-code#:~:text=split(%22%5C%5Cs%2B%22),for%20one%20or%20more%20spaces.&text=It%20simply%20means%3A%20slice%20the,on%20the%20given%20regular%20expression.&text=Thus%3A%20that%20call%20to%20split,%22fitzgerald%22%2C%20...
				String line = scanner.nextLine().trim();
				String[] elements = line.split("\\s+");
				int cols = Math.min(elements.length, MAX_COLUMN);
				colPerRow[rows] = cols;
				for (int j = 0; j < cols; j++) {
					arrayTemp[rows][j] = elements[j];
				}
				rows++;
			}
		} catch (FileNotFoundException ex) { // in case of an error
			System.err.println("File not found");
			return null;
		}

		// Create the ragged array based on the number of rows & columns per row
		double[][] ar = new double[rows][];
		for (int i = 0; i < rows; i++) {
			ar[i] = new double[colPerRow[i]];
			int j = 0; // Column index for the current row
			for (String value : arrayTemp[i]) {
				if (value != null) {
					// Convert the String value to a double and assign it to the array
					ar[i][j] = Double.parseDouble(value);
					j++; // Move to the next column index
				}
			}
		}

		return ar;
	}

	/**
	 * Writes the ragged array of doubles into the file. Each row is on a separate
	 * line within the file and each double is separated by a space.
	 * 
	 * @param data
	 * @param outputFile
	 * @throws FileNotFoundException
	 */
	public static void writeToFile(double[][] data, File outputFile) throws FileNotFoundException {
		try (BufferedWriter br = new BufferedWriter(new FileWriter(outputFile))) {
			for (double[] row : data) {
				for (int j = 0; j < row.length; j++) {
					br.write(String.valueOf(row[j]));
					// Add space between elements
					if (j < row.length - 1) {
						br.write(" ");
					}
				}
				br.newLine(); // Move to the next line for the next row
			}
		} catch (IOException ex) {
			throw new FileNotFoundException("Output file not found");
		}
	}

	/**
	 * Returns the total of all the elements of the two dimensional array
	 * 
	 * @param data
	 * @return
	 */

	public static double getTotal(double[][] data) {
		double ourTotal = 0.0;

		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				ourTotal += data[i][j];
			}
		}
		return ourTotal;
	}

	/**
	 * Returns the average of the elements in the two dimensional array
	 * 
	 * @param data
	 * @return
	 */
	public static double getAverage(double[][] data) {
		int elements = 0;
		double sum = 0.0;

		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				sum += data[i][j];
				elements++;
			}
			if (elements == 0) {
				// Avoid division by zero if the array is empty
				throw new IllegalArgumentException("Array is empty, cannot calculate average.");
			}

		}
		return sum / elements;

	}

	/**
	 * Returns the total of the selected row in the two dimensional array index 0
	 * refers to the first row.
	 * 
	 * @param data
	 * @param row
	 * @return
	 */
	public static double getRowTotal(double[][] data, int row) {
		double total = 0.0;
		for (int j = 0; j < data[row].length; j++) {
			total += data[row][j];
		}
		if (row < 0 || row >= data.length) {
			throw new IllegalArgumentException("Invalid row index");
		}

		return total;
	}

	/**
	 * Returns the total of the selected column in the two dimensional array index 0
	 * refers to the first column If a row in the two dimensional array doesn't have
	 * this column index, it is not an error, it doesn't participate in this method.
	 * 
	 * @param data
	 * @param col
	 * @return
	 */
	public static double getColumnTotal(double[][] data, int col) {
		double total = 0.0;
		for (int i = 0; i < data.length; i++) {
			if (col < data[i].length) {
				total += data[i][col];
			}
			if (col < 0) {
				throw new IllegalArgumentException("Invalid column index.");
			}
		}
		return total;

	}

	/**
	 * 
	 * @param data
	 * @param row
	 * @return
	 */
	   public static double getHighestInRow(double[][] data, int row) {
	        double highestInRow = Double.MIN_VALUE;

	        for (int j = 0; j < data[row].length; j++) {
	            if (data[row][j] > highestInRow) {
	                highestInRow = data[row][j];
	            }
	        }

	        return highestInRow;
	    }

	/**
	 * 
	 * @param data
	 * @param row
	 * @return
	 */
	public static int getHighestInRowIndex(double[][] data, int row) {
		double highestInRow = Double.MIN_VALUE;
		int highestIndex = -1;

		for (int j = 0; j < data[row].length; j++) {
			if (data[row][j] > highestInRow) {
				highestInRow = data[row][j];
				highestIndex = j;
			}
		}
		if (row < 0 || row >= data.length) {
			throw new IllegalArgumentException("Invalid row index.");
		}

		return highestIndex;
	}

	/**
	 * 
	 * @param data
	 * @param row
	 * @return
	 * 
	 */
	public static double getLowestInRow(double[][] data, int row) {
		double lowestInRow = Double.MAX_VALUE;
		for (int j = 0; j < data[row].length; j++) {
			if (data[row][j] < lowestInRow) {
				lowestInRow = data[row][j];
			}
		}
		if (row < 0 || row >= data.length) {
			throw new IllegalArgumentException("Invalid row index.");
		}
		return lowestInRow;
	}

	/**
	 * 
	 * @param data
	 * @param row
	 * @return
	 */
	public static int getLowestInRowIndex(double[][] data, int row) {
		double lowestInRow = Double.MAX_VALUE;
		int lowestIndex = -1;
		for (int j = 0; j < data[row].length; j++) {
			if (data[row][j] < lowestInRow) {
				lowestInRow = data[row][j];
				lowestInRow = j;
			}
			if (row < 0 || row >= data.length) {
				throw new IllegalArgumentException("Invalid row index.");
			}
		}
		return lowestIndex;
	}

	/**
	 * 
	 * @param data
	 * @param col
	 * @return
	 */
	public static double getHighestInColumn(double[][] data, int col) {
		double highestInCol = Double.NEGATIVE_INFINITY;
		for (int i = 0; i < data.length; i++) {
			if (col < data[i].length && data[i][col] > highestInCol) {
				highestInCol = data[i][col];
			}
		}
		if (col < 0) {
			throw new IllegalArgumentException("Invalid column index.");
		}
		return highestInCol;

	}

	/**
	 * 
	 * @param data
	 * @param col
	 * @return
	 */
	public static int getHighestInColumnIndex(double[][] data, int col) {
		double highestInCol = Double.MIN_VALUE;
		int highestIndex = -1;
		for (int i = 0; i < data.length; i++) {
			if (col < data[i].length && data[i][col] > highestInCol) {
				highestInCol = data[i][col];
				highestIndex = i;
			}
			if (col < 0) {
				throw new IllegalArgumentException("Invalid column index.");
			}
		}
		return highestIndex;
	}

	/**
	 * 
	 * @param data
	 * @param col
	 * @return
	 */
	public static double getLowestInColumn(double[][] data, int col) {
		double lowestInCol = Double.POSITIVE_INFINITY;
		for (int row = 0; row < data.length; row++) {
			if (col < data[row].length) {
				if (data[row][col] < lowestInCol) {
					lowestInCol = data[row][col];
				}
			}
			if (col < 0 || col >= data[0].length) {
				throw new IllegalArgumentException("Invalid column index");
			}
		}

		return lowestInCol;
	}

	/**
	 * 
	 * @param data
	 * @param col
	 * @return
	 */
	public static int getLowestInColumnIndex(double[][] data, int col) {
		double lowestInCol = Double.POSITIVE_INFINITY;
		int lowestIndex = -1;
		for (int row = 0; row < data.length; row++) {
			if (col < data[row].length) {
				if (data[row][col] < lowestInCol) {
					lowestInCol = data[row][col];
					lowestIndex = row;
				}
			}
		}

		return lowestIndex;
	}

	/**
	 * 
	 * @param data
	 * @return
	 */
	public static double getHighestInArray(double[][] data) {
		double highestElem = Double.NEGATIVE_INFINITY;
		for (int row = 0; row < data.length; row++) {
			for (int col = 0; col < data[row].length; col++) {
				if (data[row][col] > highestElem) {
					highestElem = data[row][col];
				}
			}
		}

		return highestElem;

	}

	/**
	 * 
	 * @param data
	 * @return
	 */
	public static double getLowestInArray(double[][] data) {
		double lowestElem = Double.POSITIVE_INFINITY;
		for (int row = 0; row < data.length; row++) {
			for (int col = 0; col < data[row].length; col++) {
				if (data[row][col] < lowestElem) {
					lowestElem = data[row][col];
				}
			}
		}
		return lowestElem;
	}
}
