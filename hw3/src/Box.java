import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit> {
    private List<T> fruits;

    public Box(List<T> fruits) {
        this.fruits = fruits;
    }

    public Box() {
        this.fruits = new ArrayList<>();
    }

    public void addFruit(T fruit) {
        this.fruits.add(fruit);
    }

    public float getWeight() {
        float boxWeight = 0.0f;
        for (T fruit : fruits) {
            boxWeight += fruit.fruitWeight();
        }
        return boxWeight;
    }

    public boolean compare(Box<? extends Fruit> box) {
        return this.getWeight() == box.getWeight();
    }

    public void moveTo(Box<T> box) {
        box.fruits.addAll(this.fruits);
        this.fruits = new ArrayList<>();
    }
}
