import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class phoneBook {
    Map<String, String> phoneBook;

    public phoneBook() {
        this.phoneBook = new HashMap<>();
    }

    /**
     * Добавить запись в телефонную книгу
     *
     * @param phoneNum   - номер телефона
     * @param phoneOwner - владелец
     */
    public void add(String phoneNum, String phoneOwner) {
        phoneBook.put(phoneNum, phoneOwner);
    }

    /**
     * Получить все номера телефонов владельца
     *
     * @param phoneOwner - имя владельца, номер
     * @return - уникальный набор номеров телефонов
     */
    public Set<String> getByStreamFilter(String phoneOwner) {
        return phoneBook.entrySet().
                stream().
                filter(x -> x.getValue().equals(phoneOwner)).
                collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)).keySet();
    }

    /**
     * Получить все номера владельца перебором
     *
     * @param phoneOwner - имя владельца номер
     * @return - уникальный набор номеров телефонов
     */
    public Set<String> getByIterate(String phoneOwner) {
        Set<String> ownerPhones = new TreeSet<>();
        for (String phone : phoneBook.keySet()) {
            String bookPhone = phoneBook.get(phone);
            if (bookPhone.equals(phoneOwner)) {
                ownerPhones.add(phone);
            }
        }
        return ownerPhones;
    }

    public Map<String, String> getphoneBook() {
        return phoneBook;
    }

    public static void main(String[] args) {
        phoneBook pb = new phoneBook();
        pb.add("12345", "Owner1");
        pb.add("12348", "Owner4");
        pb.add("11111", "Owner1");
        pb.add("12346", "Owner2");
        pb.add("12347", "Owner3");
        pb.add("12349", "Owner4"); 
        pb.add("98765", "Owner1"); 
        System.out.println("Показать всю книгу: ");
        System.out.println(pb.getphoneBook());
    }
}
    


