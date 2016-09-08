package chapter06.matrix

import spock.lang.Specification

/**
 * This code doesn't appear in the book. It tests the sample matrix multiplication.
 */
class MatrixTest extends Specification {

    def "1x1 times 1x1"() {
        expect:
        MatrixOperations.multiply([[5]] as double[][], [[6]] as double[][]) == [[30]] as double[][]
    }

    def "3x1 times 1x3"() {
        expect:
        MatrixOperations.multiply([[1, 2, 3]] as double[][], [[4], [5], [6]] as double[][]) == [[32]] as double[][]
    }

    def "1x3 times 3x1"() {
        expect:
        MatrixOperations.multiply([[1], [2], [3]] as double[][], [[4, 5, 6]] as double[][]) == [[4, 5, 6], [8, 10, 12], [12, 15, 18]] as double[][]
    }

    def "3x2 times 2x3"() {
        expect:
        MatrixOperations.multiply([[1, 2, 3], [4, 5, 6]] as double[][], [[7, 8], [9, 10], [11, 12]] as double[][]) == [[58, 64], [139, 154]] as double[][]
    }

    def "3x3 times 3x3 identity"() {
        expect:
        MatrixOperations.multiply([[1, 2, 3], [4, 5, 6], [7, 8, 9]] as double[][], [[1, 0, 0], [0, 1, 0], [0, 0, 1]] as double[][]) == [[1, 2, 3], [4, 5, 6], [7, 8, 9]] as double[][]
    }


    def "[] times [] expect exception"() {
        when:
        MatrixOperations.multiply([[]] as double[][], [[]] as double[][])

        then:
        thrown IllegalArgumentException
    }

    def "1x2 times 1x2 expect exception"() {
        when:
        MatrixOperations.multiply([[1, 1]] as double[][], [[2, 2]] as double[][])

        then:
        thrown IllegalArgumentException
    }
}
