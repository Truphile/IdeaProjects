public class LinearRegression {

    int numberOfDataPoints;
    int [] yValues;
    int [] xValues;

    public LinearRegression(int datapopulation, int[] yValues, int[] xValues) {
        this.yValues = yValues;
        this.xValues = xValues;
        this.numberOfDataPoints = datapopulation;
    }

    public int getDataPointCount() {
        return numberOfDataPoints;
    }

    public int[] getYValues() {
        return yValues;
    }

    public int[] getXValues() {
        return xValues;
    }

    public int[] calculateXYProducts() {
        int[] product = new int[numberOfDataPoints];
        for (int count = 0; count < numberOfDataPoints; count++) {
            product[count] = xValues[count] * yValues[count];
        }
        return product;
    }

    public int[] calculateXSquared() {
        int[] productX = new int[numberOfDataPoints];
        for (int count = 0; count < numberOfDataPoints; count++) {
            productX[count] = xValues[count] * xValues[count];
        }
        return productX;
    }

    public int sum(int[] Values) {
        int sum = 0;
        for (int count : Values) {sum += count;

        }
        return sum;
    }

    public double computeSlope() {
        int n = getDataPointCount();
        int sumXY = sum(calculateXYProducts());
        int sumX = sum(xValues);
        int sumY = sum(yValues);
        int sumXX = sum(calculateXSquared());

       double slope = (double) (n * sumXY - sumX * sumY) / (n * sumXX - sumX * sumX);
       String formattedSlope = String.format("%.2f", slope);
       return Double.parseDouble(formattedSlope);




    }

    public double computeIntercept() {
        int n = getDataPointCount();
        int sumX = sum(xValues);
        int sumY = sum(yValues);

        return ((double) sumY - computeSlope() * sumX) / n;
    }

    public double predictY(int x) {
        return computeSlope() * x + computeIntercept();

    }

    public String formatRegressionTable() {
        StringBuilder sb = new StringBuilder();
        sb.append("X\tY\tXY\tX^2\n");

        int[] xy = calculateXYProducts();
        int[] xSquared = calculateXSquared();
        for (int count = 0; count < getDataPointCount(); count++) {
            sb.append(xValues[count]).append("\t")
                    .append(yValues[count]).append("\t")
                    .append(xy[count]).append("\t")
                    .append(xSquared[count]).append("\n");
        }
        return sb.toString();

    }
}
