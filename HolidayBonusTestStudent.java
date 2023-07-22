import junit.framework.TestCase;
/*
 * Class: CMSC203 
 * Instructor: Grinberg
 * Description: HolidayBonusTestStudent class
 * Due: 7/24/2023
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently.
*  I have not copied the code from a student or any source. 
*  I have not given my code to any student.
*  Print your Name here: Talia Kouncar
*/
public class HolidayBonusTestStudent extends TestCase {

	private double[][] dataSet2 = { { 2, -1, 4 }, { 3, 2, 6 }, { 5, 4 } };
	private double[][] dataSet3 = { { -4, 5, 3 }, { 6, 1 }, { 4, 2, 5 } };

	public void testCalculateHolidayBonus() {

		try {
			double[] result = HolidayBonus.calculateHolidayBonus(dataSet2);
			assertEquals(2000.0, result[0], .001);
			assertEquals(9000.0, result[1], .001);
			assertEquals(10000.0, result[2], .001);
		} catch (Exception ex) {
			fail("This should not have caused an Exception");
		}

		try {
			double[] result = HolidayBonus.calculateHolidayBonus(dataSet3);
			assertEquals(6000.0, result[0], .001);
			assertEquals(6000.0, result[1], .001);
			assertEquals(9000.0, result[2], .001);
		} catch (Exception ex) {
			fail("This should not have caused an Exception");
		}
	}

	public void testCalculateTotalHolidayBonus() {
		assertEquals(21000.0, HolidayBonus.calculateTotalHolidayBonus(dataSet2), .001);
		assertEquals(21000.0, HolidayBonus.calculateTotalHolidayBonus(dataSet3), .001);

	}

}
