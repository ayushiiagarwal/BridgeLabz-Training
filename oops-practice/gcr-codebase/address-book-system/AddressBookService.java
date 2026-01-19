public class AddressBookService {

    private AddressBook addressBook = new AddressBook();

    public void addContact(ContactPerson contact) {
        if (contact.getFirstName() == null || contact.getFirstName().isEmpty()) {
            System.out.println("First name cannot be empty");
            return;
        }
        addressBook.addContact(contact);
        System.out.println("Contact added");
    }

    public void editContact(String firstName, String newFirstName, String newLastName,
                            String newPhone, String newEmail) {

        ContactPerson contact = addressBook.findByName(firstName);
        if (contact == null) {
            System.out.println("Contact not found");
            return;
        }

        contact.setFirstName(newFirstName);
        contact.setLastName(newLastName);
        contact.setPhone(newPhone);
        contact.setEmail(newEmail);

        System.out.println("Contact updated");
    }

    public void deleteContact(String firstName) {
        if (addressBook.deleteContact(firstName)) {
            System.out.println("Contact deleted");
        } else {
            System.out.println("Contact not found");
        }
    }

    public void showContacts() {
        for (ContactPerson c : addressBook.getAllContacts()) {
            System.out.println(c);
        }
    }
}
