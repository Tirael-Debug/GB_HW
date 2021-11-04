public class Main {

    public static final String[] testHeader = new String[]{"Day", "Month", "Year", "Value"};

    public static final int[][] testData = new int[][]{
            {2, 6, 2000, 306},
            {12, 8, 2009, 505},
            {21, 10, 2000, 400},
            {10, 7, 2021, 477},
            {1, 9, 2020, 667},
            {7, 12, 20001, 333},
    };

    public static void main(String[] args) {
        System.out.println("Task #1");
        AppData csvSaveData = new AppData();
        csvSaveData.setHeader(testHeader);
        csvSaveData.setData(testData);
        csvSaveData.save("hw5\\resources\\testSave.csv");
        System.out.println("\nTask #2");
        AppData csvLoadData = new AppData();
        csvLoadData.load("hw5\\resources\\testLoad.csv");
        csvLoadData.echoData();
    }
}
