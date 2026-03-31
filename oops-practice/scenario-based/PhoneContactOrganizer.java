import java.util.ArrayList;
// import java.util.Arrays;
import java.util.List;

class InvalidPhoneNumberException extends Exception{
    public InvalidPhoneNumberException(String message){
        super(message);
    }
}

class Contact{
    private String name, number;

    public Contact(String name, String number) throws InvalidPhoneNumberException{
        if(number == null || number.length() != 10 || !number.matches("\\d+")){
            throw new InvalidPhoneNumberException("Phone number must be 10 digits and numeric.");
        }
        this.name = name;
        this.number = number;
    }

    public String getName(){
        return name;
    }

    public String getPhoneNumber(){
        return number;
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj) return true;
        if(!(obj instanceof Contact)) return false;
        Contact other = (Contact) obj;
        return this.number.equals(other.number);
    }

    public void getDetails(){
        System.out.println("Name: " + name + "\nPhone Number: " + number);
        System.out.println();
    }

}

public class PhoneContactOrganizer{
    private List<Contact> contactList;

    public PhoneContactOrganizer(){
        this.contactList = new ArrayList<>();
    }

    public void addContact(String name, String number){
        try{
            Contact newContact = new Contact(name, number);

            if(contactList.contains(newContact))
                System.out.println("Phone number already exists");

            else{
                contactList.add(newContact);
                System.out.println("Contact added.");
            }
        }
        catch(InvalidPhoneNumberException e){
            System.out.println("Oops! " + e.getMessage());
        }
    }

    public void deleteContact(String phone){
        System.out.println("Deleting Contact Number: " + phone);
        int indexToRemove = -1;
        for (int i = 0; i < contactList.size(); i++) {
        Contact current = contactList.get(i);
        
        if (current.getPhoneNumber().equals(phone)) {
            indexToRemove = i; 
            break;             
        }
    }

    if (indexToRemove != -1) {
        contactList.remove(indexToRemove);
        System.out.println("Contact deleted successfully.");
    } else {
        System.out.println("No contact found with that phone number.");
    }
    }

    public void searchByName(String name) {
        boolean found = false;
        for (Contact c : contactList) {
            if (c.getName().equalsIgnoreCase(name)) {
                System.out.println("   " + c);
                found = true;
            }
        }
        if (!found) System.out.println("No matches found.");
    }

    public void getDetails(){
        if(contactList.isEmpty())
            System.out.println("Empty");

        else{
            for(Contact c : contactList){
                c.getDetails();
            }
        }
    }
    public static void main(String[] args) {
        PhoneContactOrganizer c1 = new PhoneContactOrganizer();

        c1.addContact("John Doe", "1234567890");
        c1.addContact("Jack Smith", "9876543210");

        c1.addContact("Shorty", "12345"); 

        c1.addContact("Duplicate John", "1234567890");

        c1.searchByName("Jane Smith");

        c1.getDetails();
        c1.deleteContact("1234567890");
        System.out.println();
        c1.getDetails();
    }
}