import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AppData {

    private static final String delimiter = ";";

    private String[] header;

    private int[][] data;

    public void setHeader(String[] header) {
        this.header = header;
    }

    public void setData(int[][] data) {
        this.data = data;
    }

    public void echoData() {
        System.out.println(Arrays.toString(header));
        for (int[] line: data) {
            System.out.println(Arrays.toString(line));
        }
    }

    public void load(String filePath) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String stringFromFile;
            int lineCounter = 0;
            List<int[]> tempData = new ArrayList<>();
            while ((stringFromFile = reader.readLine()) != null) {
                String[] lineValues = stringFromFile.split(delimiter);
                if (lineCounter < 1) {
                    this.header = lineValues;
                } else {
                    int[] dataValues = new int[lineValues.length];
                    for (int value = 0; value < lineValues.length; value++) {
                        dataValues[value] = Integer.parseInt(lineValues[value]);
                    }
                    tempData.add(dataValues);
                }
                lineCounter++;
            }
            this.data = new int[tempData.size()][tempData.get(0).length];
            for (int i = 0; i < tempData.size(); i++) {
                this.data[i] = tempData.get(i);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Incorrect file path!");
        } catch (IOException e) {
            System.out.println("Unable to read string from file!");
        }
    }

    public void save(String filePath) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
            if (this.header.length > 0) {
                writer.write(String.join(delimiter, this.header));
                writer.newLine();
            }
            if (this.data.length > 0) {
                for (int[] dataLine : this.data) {
                    if (dataLine.length > 0) {
                        StringBuilder dataValue = new StringBuilder();
                        String prefix = "";
                        for (int value : dataLine) {
                            dataValue.append(prefix);
                            prefix = delimiter;
                            dataValue.append(value);
                        }
                        writer.write(dataValue.toString());
                        writer.newLine();
                    }
                }
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Error with writing to file!");
        }
    }
}
