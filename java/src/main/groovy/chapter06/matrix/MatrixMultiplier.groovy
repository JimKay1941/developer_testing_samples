package chapter06.matrix

/**
 * This example illustrates a crude way of introducing temporal coupling
 * where it really ins't needed.
 */
class MatrixMultiplier {
    private double[][] m1
    private double[][] m2

    def initialize(double[][] m1, double[][] m2) {

        if (m1[0].length != m2.length) {
            throw new IllegalArgumentException(
                    "width of m1 must equal height of m2"
            )
        }

        this.m1 = m1
        this.m2 = m2
    }

    double[][] multiply() {
        final int rh = m1.length
        final int rw = m2[0].length

        double[][] result = new double[rh][rw]
        for (int y = 0; y < rh; y++) {
            for (int x = 0; x < rw; x++) {
                for (int xy = 0; xy < m2.length; xy++) {
                    result[y][x] += m1[y][xy] * m2[xy][x]
                }
            }
        }
        return result
    }

}
