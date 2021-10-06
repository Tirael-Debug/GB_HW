public class MyArraySizeException extends IllegalArgumentException {
    public MyArraySizeException(int sizeX, int sizeY) {
        super(String.format("Matrix with size[%d][%d] is incorrect. It must be 4x4", sizeX, sizeY));
    }
}
