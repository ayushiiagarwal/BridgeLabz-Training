import java.util.*;

public class AddressBook {

    private List<ContactPerson> contacts = new ArrayList<>();

    public void addContact(ContactPerson contact) {
        contacts.add(contact);
    }

    public ContactPerson findByName(String firstName) {
        for (ContactPerson c : contacts) {
            if (c.getFirstName().equalsIgnoreCase(firstName)) {
                return c;
            }
        }
        return null;
    }

    public boolean deleteContact(String firstName) {
        ContactPerson contact = findByName(firstName);
        if (contact != null) {
            contacts.remove(contact);
            return true;
        }
        return false;
    }

    public List<ContactPerson> getAllContacts() {
        return contacts;
    }
}
