/*
 * Class: CMSC203 
 * Instructor: Grinberg
 * Description: HolidayBonus class
 * Due: 7/24/2023
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently.
*  I have not copied the code from a student or any source. 
*  I have not given my code to any student.
*  Print your Name here: Talia Kouncar
*/
public class HolidayBonus {
	// create our constant variables
	private static final int HIGHEST_AMT = 5000;
	private static final int OTHER = 2000;
	private static final int LOWEST_AMT = 1000;

	/**
	 * 
	 */
	public HolidayBonus() {
//our constructor 
	}

	/**
	 * 
	 * @param data
	 * @return
	 */
	public static double[] calculateHolidayBonus(double[][] data) {

		double[] holidayBonus = new double[data.length];

		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				if (data[i][j] > 0) {

					if (data[i][j] == data[TwoDimRaggedArrayUtility.getHighestInColumnIndex(data, j)][j]) {
						holidayBonus[i] += HIGHEST_AMT;
					} else if (data[i][j] == data[TwoDimRaggedArrayUtility.getLowestInColumnIndex(data, j)][j]) {
						holidayBonus[i] += LOWEST_AMT;
					} else
						holidayBonus[i] += OTHER;

				}
			}
		}
		return holidayBonus;
	}

	/**
	 * 
	 * @param data
	 * @return
	 */
	public static double calculateTotalHolidayBonus(double[][] data) {
		double x = 0;

		double[] holidayBonus = calculateHolidayBonus(data);

		for (int i = 0; i < data.length; i++) {
			x += holidayBonus[i];
		}

		return x;
	}
}