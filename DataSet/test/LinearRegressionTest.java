import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class LinearRegressionTest {

    LinearRegression linear;
    @Before
    public void setup(){
        int[] x = {1,2,3,4,5};
        int[] y = {40,55,65,80,95};
        linear = new LinearRegression(5,y,x);
    }

    @Test
    public void numberOfDataPoints_shouldBeKnown() {
        assertEquals(5, linear.getDataPointCount());
    }

    @Test
    public void yValues_shouldBeSetCorrectly() {
        int[] expectedY = {40, 55, 65, 80,95};
        assertArrayEquals(expectedY, linear.getYValues());
    }

    @Test
    public void xValues_shouldBeSetCorrectly() {
        int[] expectedX = {1, 2, 3, 4,5};
        assertArrayEquals(expectedX, linear.getXValues());
    }

    @Test
    public void xyProducts_shouldBeCalculatedCorrectly() {
        int[] expected = {40, 110, 195, 320, 475};
        assertArrayEquals(expected, linear.calculateXYProducts());
    }

    @Test
    public void xSquaredValues_shouldBeCalculatedCorrectly() {
        int[] expected = {1, 4, 9, 16, 25};
        assertArrayEquals(expected, linear.calculateXSquared());
    }
    @Test
    public void sumOfX_shouldBeCorrect() {
        int[] xValues = linear.getXValues();
        assertEquals(15, linear.sum(xValues));
    }

    @Test
    public void sumOfXY_shouldBeCorrect() {
        int[] xyValues = linear.calculateXYProducts();
        assertEquals(1140, linear.sum(xyValues));
    }

    @Test
    public void sumOfXSquared_shouldBeCorrect() {
        int[] xSquared = linear.calculateXSquared();
        assertEquals(55, linear.sum(xSquared));
    }

    @Test
    public void slope_shouldBeComputedCorrectly() {
        assertEquals(17.88, 15, linear.computeSlope());
    }

    @Test
    public void intercept_shouldBeComputedCorrectly() {
        assertEquals(31.32, 30, linear.computeIntercept());
    }


    @Test
    public void predictedYValue_shouldBeCorrect() {
        System.out.print(linear.formatRegressionTable());
        assertEquals(49.2, 40, linear.predictY(1));
    }









}
