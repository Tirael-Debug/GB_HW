import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Box<Apple> boxWithApples1 = new Box<>();
        Box<Apple> boxWithApples2 = new Box<>(Arrays.asList(
                new Apple(),
                new Apple(),
                new Apple()));
        Box<Orange> boxWithOranges = new Box<>();
        boxWithOranges.addFruit(new Orange());
        boxWithOranges.addFruit(new Orange());
        System.out.printf("Box #1: %.1f\n", boxWithApples1.getWeight());
        System.out.printf("Box #2: %.1f\n", boxWithApples2.getWeight());
        System.out.printf("Box #3: %.1f\n", boxWithOranges.getWeight());
        System.out.printf("\nBox2 weight is equals Box3: %b\n", boxWithApples2.compare(boxWithOranges));
        boxWithOranges.addFruit(new Orange());
        boxWithApples1.addFruit(new Apple());
        boxWithApples1.addFruit(new Apple());
        boxWithApples2.moveTo(boxWithApples1);
        System.out.printf("Box #1: %.1f\n", boxWithApples1.getWeight());
        System.out.printf("Box #2: %.1f\n", boxWithApples2.getWeight());
        System.out.printf("Box #3: %.1f\n", boxWithOranges.getWeight());
        System.out.printf("\nNow Box#1 weight equal Box#3: %b\n", boxWithApples1.compare(boxWithOranges));
    }
}
