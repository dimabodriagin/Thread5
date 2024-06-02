import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.TreeMap;

public class PhoneBook {

    private Map<String, String> phoneBook;

    public int add(String name, String number) throws IllegalArgumentException {
        if (phoneBook == null) {
            phoneBook = new TreeMap<>();
        }
        if (phoneBook.containsKey(name)) {
            throw new IllegalArgumentException("This name is already in phone book");
        }
        phoneBook.put(name, number);
        return phoneBook.size();
    }

    public String findByNumber(String number) {
        Optional<String> result = phoneBook.entrySet()
                .stream()
                .filter(entry -> number.equals(entry.getValue()))
                .map(Entry::getKey)
                .findFirst();

        if (result.isPresent())
            return result.get();
        return null;
    }

    public String findByName(String name) {
        return null;
    }
}
