public class MyArrayDataException extends IllegalArgumentException{
    public MyArrayDataException(int xIndex, int yIndex) {
        super(String.format("Unable to parse element [%d, %d]", xIndex, yIndex));
    }
}
