import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String cityName = scanner.nextLine();
        String cityCode = RequestHandler.cityDetect(cityName);
        System.out.println(RequestHandler.weatherDetect(cityCode));
    }
}
