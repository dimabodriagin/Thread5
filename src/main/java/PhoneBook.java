import java.util.Map;
import java.util.TreeMap;

public class PhoneBook {

    private Map<String, String> phoneBook;

    public int add(String name, String number) {
        if (phoneBook == null) {
            phoneBook = new TreeMap<>();
        }
        phoneBook.put(name, number);
        return phoneBook.size();
    }
}
