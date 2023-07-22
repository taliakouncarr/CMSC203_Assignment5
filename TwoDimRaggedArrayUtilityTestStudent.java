import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
/*
 * Class: CMSC203 
 * Instructor: Grinberg
 * Description: TwoDimRaggedArrayUtilityTestStudent class
 * Due: 7/24/2023
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently.
*  I have not copied the code from a student or any source. 
*  I have not given my code to any student.
*  Print your Name here: Talia Kouncar
*/

import junit.framework.TestCase;

public class TwoDimRaggedArrayUtilityTestStudent extends TestCase {
	private double[][] dataSet1 = { { 1, 2, 3 }, { 4, 5 }, { 6, 7, 8 } };

	private double[][] dataSet2 = { { 2, -1, 4 }, { 3, 2, 6 }, { 5, 4 } };

	public void testGetTotal() {
		double[][] data = { { 1, 2, 3 }, { 4, 5 }, { 6, 7, 8 } };
		double expected = 36.0;
		double result = TwoDimRaggedArrayUtility.getTotal(data);
		assertEquals(expected, result, 0.001);
	}

	public void testGetAverage() {
		double[][] data = { { 1, 2, 3 }, { 4, 5 }, { 6, 7, 8 } };
		double expected = 4.5;
		double result = TwoDimRaggedArrayUtility.getAverage(data);
		assertEquals(expected, result, 0.001);
	}

	public void testGetRowTotal() {
		double expectedRowTotal1 = 6.0;
		double resultRowTotal1 = TwoDimRaggedArrayUtility.getRowTotal(dataSet1, 0);
		assertEquals(expectedRowTotal1, resultRowTotal1, 0.001);

		double expectedRowTotal2 = 11.0;
		double resultRowTotal2 = TwoDimRaggedArrayUtility.getRowTotal(dataSet2, 1);
		assertEquals(expectedRowTotal2, resultRowTotal2, 0.001);
	}

	public void testGetColumnTotal() {
		double expectedColumnTotal1 = 14.0;
		double resultColumnTotal1 = TwoDimRaggedArrayUtility.getColumnTotal(dataSet1, 1);
		assertEquals(expectedColumnTotal1, resultColumnTotal1, 0.001);

		double expectedColumnTotal2 = 5.0;
		double resultColumnTotal2 = TwoDimRaggedArrayUtility.getColumnTotal(dataSet2, 1);
		assertEquals(expectedColumnTotal2, resultColumnTotal2, 0.001);
	}

	public void testGetHighestInRow() {
		double expectedHighestInRow1 = 3.0;
		double resultHighestInRow1 = TwoDimRaggedArrayUtility.getHighestInRow(dataSet1, 0);
		assertEquals(expectedHighestInRow1, resultHighestInRow1, 0.001);

		double expectedHighestInRow2 = 6.0;
		double resultHighestInRow2 = TwoDimRaggedArrayUtility.getHighestInRow(dataSet2, 1);
		assertEquals(expectedHighestInRow2, resultHighestInRow2, 0.001);
	}

	public void testGetHighestInRowIndex() {
		int expectedHighestInRowIndex1 = 2;
		int resultHighestInRowIndex1 = TwoDimRaggedArrayUtility.getHighestInRowIndex(dataSet1, 2);
		assertEquals(expectedHighestInRowIndex1, resultHighestInRowIndex1);

		int expectedHighestInRowIndex2 = 0;
		int resultHighestInRowIndex2 = TwoDimRaggedArrayUtility.getHighestInRowIndex(dataSet2, 2);
		assertEquals(expectedHighestInRowIndex2, resultHighestInRowIndex2);
	}

	public void testGetLowestInRow() {
		double expectedLowestInRow1 = 1.0;
		double resultLowestInRow1 = TwoDimRaggedArrayUtility.getLowestInRow(dataSet1, 0);
		assertEquals(expectedLowestInRow1, resultLowestInRow1, 0.001);

		double expectedLowestInRow2 = 2.0;
		double resultLowestInRow2 = TwoDimRaggedArrayUtility.getLowestInRow(dataSet2, 1);
		assertEquals(expectedLowestInRow2, resultLowestInRow2, 0.001);
	}

	public void testGetLowestInRowIndex() {
		double expectedLowestInRow1 = 1.0;
		double resultLowestInRow1 = TwoDimRaggedArrayUtility.getLowestInRow(dataSet1, 0);
		assertEquals(expectedLowestInRow1, resultLowestInRow1, 0.001);
		double expectedLowestInRow6 = 4.0;
		double resultLowestInRow6 = TwoDimRaggedArrayUtility.getLowestInRow(dataSet2, 2);
	}

	public void testGetHighestInColumn() {
		double expectedHighestInColumn1 = 7.0;
		double resultHighestInColumn1 = TwoDimRaggedArrayUtility.getHighestInColumn(dataSet1, 1);
		assertEquals(expectedHighestInColumn1, resultHighestInColumn1, 0.001);

		double expectedHighestInColumn2 = 4.0;
		double resultHighestInColumn2 = TwoDimRaggedArrayUtility.getHighestInColumn(dataSet2, 1);
		assertEquals(expectedHighestInColumn2, resultHighestInColumn2, 0.001);
	}

	public void testGetHighestInColumnIndex() {
		int expectedHighestInColumnIndex1 = 2;
		int resultHighestInColumnIndex1 = TwoDimRaggedArrayUtility.getHighestInColumnIndex(dataSet1, 2);
		assertEquals(expectedHighestInColumnIndex1, resultHighestInColumnIndex1);

		int expectedHighestInColumnIndex2 = 1;
		int resultHighestInColumnIndex2 = TwoDimRaggedArrayUtility.getHighestInColumnIndex(dataSet2, 2);
		assertEquals(expectedHighestInColumnIndex2, resultHighestInColumnIndex2);
	}

	public void testGetLowestInColumn() {
		double expectedLowestInColumn1 = 2.0;
		double resultLowestInColumn1 = TwoDimRaggedArrayUtility.getLowestInColumn(dataSet1, 1);
		assertEquals(expectedLowestInColumn1, resultLowestInColumn1, 0.001);

		double expectedLowestInColumn2 = -1.0;
		double resultLowestInColumn2 = TwoDimRaggedArrayUtility.getLowestInColumn(dataSet2, 1);
		assertEquals(expectedLowestInColumn2, resultLowestInColumn2, 0.001);
	}

	public void testGetLowestInColumnIndex() {
		int expectedLowestInColumnIndex1 = 0;
		int resultLowestInColumnIndex1 = TwoDimRaggedArrayUtility.getLowestInColumnIndex(dataSet1, 1);
		assertEquals(expectedLowestInColumnIndex1, resultLowestInColumnIndex1);

		int expectedLowestInColumnIndex2 = 0;
		int resultLowestInColumnIndex2 = TwoDimRaggedArrayUtility.getLowestInColumnIndex(dataSet2, 0);
		assertEquals(expectedLowestInColumnIndex2, resultLowestInColumnIndex2);
	}

	public void testGetHighestInArray() {
		double expectedHighestInArray1 = 8.0;
		double resultHighestInArray1 = TwoDimRaggedArrayUtility.getHighestInArray(dataSet1);
		assertEquals(expectedHighestInArray1, resultHighestInArray1, 0.001);

		double expectedHighestInArray2 = 6.0;
		double resultHighestInArray2 = TwoDimRaggedArrayUtility.getHighestInArray(dataSet2);
		assertEquals(expectedHighestInArray2, resultHighestInArray2, 0.001);
	}

	public void testGetLowestInArray() {
		double expectedLowestInArray1 = 1.0;
		double resultLowestInArray1 = TwoDimRaggedArrayUtility.getLowestInArray(dataSet1);
		assertEquals(expectedLowestInArray1, resultLowestInArray1, 0.001);

		double expectedLowestInArray2 = -1.0;
		double resultLowestInArray2 = TwoDimRaggedArrayUtility.getLowestInArray(dataSet2);
		assertEquals(expectedLowestInArray2, resultLowestInArray2, 0.001);
	}

	public void testWriteToFile() throws IOException {
		double[][] data = { { 1.0, 2.0, 3.0 }, { 4.0, 5.0, 6.0 }, { 7.0, 8.0 }, { 9.0 }, };
		File outputFile = new File("outputData.txt");

		try {
			TwoDimRaggedArrayUtility.writeToFile(data, outputFile);

			double[][] readData = TwoDimRaggedArrayUtility.readFile(outputFile);

			assertTrue(Arrays.deepEquals(data, readData));
		} finally {
			outputFile.delete();
		}
	}

	

}
