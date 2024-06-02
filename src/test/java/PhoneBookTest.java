import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.TreeMap;

public class PhoneBookTest {

    @Test
    public void testAdd() {
        PhoneBook phoneBook = new PhoneBook();
        String name = "Name";
        String number = "+79452007010";

        int result = phoneBook.add(name, number);
        Map<String, String> phoneMap = new TreeMap<>();
        phoneMap.put(name, number);

        Assertions.assertEquals(result, phoneMap.size());
    }

    @Test
    public void testAdd_repeatName() {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Name", "+79452007010");

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            phoneBook.add("Name", "+79372003040");
        });
    }

    @Test
    public void testFindByNumber() {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Name", "+79452007010");

        String name = phoneBook.findByNumber("+79452007010");

        Assertions.assertEquals(name, "Name");
    }

    @Test
    public void testFindByName() {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Name", "+79452007010");

        String number = phoneBook.findByName("Name");

        Assertions.assertEquals(number, "+79452007010");
    }

    @Test
    public void testPrintAllNames() {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Ame", "+79452007010");
        phoneBook.add("Cate", "89452004050");
        phoneBook.add("Bjorg", "+7900302010");

        String allNames = phoneBook.printAllNames();

        Assertions.assertEquals(allNames, "[Ame, Bjorg, Cate]");
    }
}
