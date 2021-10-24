import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Dictionary {

    private final Map<String, List<String>> phoneList;

    public Dictionary() {
        this.phoneList = new HashMap<>();
    }

    public void add(String Surname, String phone) {
        List<String> phoneList;
        if (this.phoneList.containsKey(Surname)) {
            phoneList= this.phoneList.get(Surname);
        }
        else {
            phoneList=new ArrayList<>();
        }
        phoneList.add(phone);
        this.phoneList.put(Surname,phoneList);
    }

    public List<String> get(String Surname) {
        return phoneList.get(Surname);
    }
}
