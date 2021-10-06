public class MatrixCounter {

    private static final int validMatrixSize = 4;

    public int calculate (String[][] matrix) throws MyArraySizeException, MyArrayDataException {

        int matrixSum = 0;

        if (matrix.length != 4) {
            throw new MyArraySizeException(matrix.length, validMatrixSize);
        }

        for (int x = 0; x < matrix.length; x++) {
            if (matrix[x].length != validMatrixSize) {
                throw new MyArraySizeException(validMatrixSize, matrix[x].length);
            }

            for (int y = 0; y < matrix[x].length; y++) {
                try {
                    matrixSum += Integer.parseInt(matrix[x][y]);
                } catch (NumberFormatException exception) {
                    throw new MyArrayDataException(x,y);
                }

            }
        }

        return matrixSum;
    }
}
