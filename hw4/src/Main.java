import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        System.out.println("Task #1");
        Map<String, Integer> hm = new HashMap<>();
        String[] words = {"Котик", "Собачка", "Юла", "Быль", "Котолампа", "Рыба", "Котик", "Песок", "Земля",
                "Вода", "Сказка", "Песок", "Быль", "Пыль", "Юла", "Краб", "Трава", "Акула", "Рыба"};
        for (String word : words) {
            if (hm.containsKey(word))
                hm.put(word, hm.get(word) + 1);
            else
                hm.put(word, 1);
        }
        System.out.println(hm);
        System.out.println();

        System.out.println("Task #2");
        Dictionary phones = new Dictionary();
        phones.add("Petrov","84955005555");
        phones.add("Ivanov","84957007777");
        phones.add("Petrov","84953003333");
        phones.add("Lala","84958008888");
        System.out.println("Petrov: " + phones.get("Petrov"));
        System.out.println("Ivanov: " + phones.get("Ivanov"));
    }
}
