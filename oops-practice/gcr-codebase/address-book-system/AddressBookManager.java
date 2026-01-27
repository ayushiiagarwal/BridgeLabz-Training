import java.util.*;
import java.io.*;

public class AddressBookManager implements AddressBookInterface {

    // UC-6 
    private Map<String, AddressBook> addressBooks = new HashMap<>(); 
    private Scanner scanner = new Scanner(System.in);

    public AddressBook getOrCreateAddressBook(String name) {
        return addressBooks.computeIfAbsent(name, AddressBook::new);
    }

    // UC-1
    @Override
    public Contact createContact() {

        System.out.println("\nEnter Contact Details");

        System.out.print("First Name: ");
        String firstName = scanner.nextLine();

        System.out.print("Last Name: ");
        String lastName = scanner.nextLine();

        System.out.print("Address: ");
        String address = scanner.nextLine();

        System.out.print("City: ");
        String city = scanner.nextLine();

        System.out.print("State: ");
        String state = scanner.nextLine();

        System.out.print("Zip: ");
        String zip = scanner.nextLine();

        System.out.print("Phone Number: ");
        String phoneNumber = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        return new Contact(firstName, lastName, address, city, state, zip, phoneNumber, email);
    }

    // UC-2 
    @Override
    public void addContact(Contact contact) {
        System.out.println("Enter Address Book Name: ");
        String bookname = scanner.nextLine();
        AddressBook book = getOrCreateAddressBook(bookname);
        boolean done = book.addContact(contact);
        
        if(done) System.out.println("Contact added to Address Book: " + bookname);
        else System.out.println("Duplicate contact found!");
    }

    // UC-5
    @Override
    public void addMultipleContacts(){
        while(true){

            System.out.println("Enter Address Book Name: ");
            String bookname = scanner.nextLine();
            AddressBook book = getOrCreateAddressBook(bookname);

            Contact contact = createContact();
            book.addContact(contact);

            System.out.println("Add new contact? (Yes/No): ");
            String ans = scanner.nextLine();

            if(!ans.equalsIgnoreCase("Yes")){
                break;
            }
        }

        System.out.println("Contacts saved succesfully!");
    }

    //  UC-3 
    @Override
    public void editContact() {
        System.out.println("Enter Address Book Name: ");
        String bookname = scanner.nextLine();
        AddressBook book = addressBooks.get(bookname);

        if (book == null) {
            System.out.println("Address Book not found.");
            return;
        }

        System.out.print("Enter First Name to edit: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter Last Name to edit: ");
        String lastName = scanner.nextLine();

        Contact contact = book.findContactByName(firstName, lastName);

        if (contact == null) {
            System.out.println("Contact not found.");
            return;
        }

        System.out.println("\nEnter new details");

        System.out.print("New Address: ");
        contact.setAddress(scanner.nextLine());

        System.out.print("New City: ");
        contact.setCity(scanner.nextLine());

        System.out.print("New State: ");
        contact.setState(scanner.nextLine());

        System.out.print("New Zip: ");
        contact.setZip(scanner.nextLine());

        System.out.print("New Phone Number: ");
        contact.setPhoneNumber(scanner.nextLine());

        System.out.print("New Email: ");
        contact.setEmail(scanner.nextLine());

        System.out.println("Contact updated successfully!");
    }

    //  UC-4
    @Override
    public void deleteContacts(){
        System.out.println("Enter Address Book Name: ");
        String bookname = scanner.nextLine();
        AddressBook book = addressBooks.get(bookname);

        if(book == null){
            System.out.println("Address Book not found.");
            return;
        }

        System.out.print("Enter First Name to delete: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter Last Name to delete: ");
        String lastName = scanner.nextLine();

        book.removeContact(firstName, lastName);
    }

    // UC-8
    @Override
    public void searchPersonByCityOrState(){
        System.out.println("Enter the criteria for your search(city/state): ");
        String choice = scanner.nextLine();
        System.out.println("Enter " + choice + " name: ");
        String name = scanner.nextLine();

        List<Contact> result = new ArrayList<>();

        for(AddressBook book : addressBooks.values()){
            for(Contact contact: book.getContacts()){
                if(choice.equalsIgnoreCase("city") && contact.getCity().equalsIgnoreCase(name)){
                    result.add(contact);
                }
                else if(choice.equalsIgnoreCase("state") && contact.getState().equalsIgnoreCase(name)){
                    result.add(contact);
                }
            }
        }

        if(result.isEmpty()){
            System.out.println("No contacts found!");
        }
        else{
            System.out.println("\nResults: ");
            for(Contact c : result){
                System.out.println(c);
            }
        }
    }

    // UC-9
    @Override
    public void viewPersonByCityOrState(){
        Map<String, List<Contact>> city = new HashMap<>();
        Map<String, List<Contact>> state = new HashMap<>();

        for(AddressBook book : addressBooks.values()){
            for(Contact c : book.getContacts()){
                city.computeIfAbsent(c.getCity(), k -> new ArrayList<>()).add(c);
                state.computeIfAbsent(c.getState(), k -> new ArrayList<>()).add(c);
            }
        }

        System.out.println("View Person by(city/state): ");
        String choice = scanner.nextLine();

        if(choice.equalsIgnoreCase("city")){
            displayMap(city, "city");
        }
        else if(choice.equalsIgnoreCase("state")){
            displayMap(state, "state");
        }
        else{
            System.out.println("Invalid Choice!");
        }
    }


    public void displayMap(Map<String, List<Contact>> map, String criteria){
        if(map.isEmpty()){
            System.out.println("No data found!");
            return;
        }

        System.out.println("\nView Person by " + criteria + " : ");

        for(Map.Entry<String, List<Contact>> entry : map.entrySet()){
            System.out.println("\n" + criteria + " : " + entry.getKey());
            for(Contact c : entry.getValue()){
                System.out.println(" " + c);
            }
        }
    }

    // UC-10
    @Override
    public void countPersonByCityOrState(){
        Map<String, Integer> cityCount = new HashMap<>();
        Map<String, Integer> stateCount = new HashMap<>();

        for(AddressBook book : addressBooks.values()){
            for(Contact c : book.getContacts()){
                cityCount.put(c.getCity(), cityCount.getOrDefault(c.getCity(), 0) + 1);
                stateCount.put(c.getState(), stateCount.getOrDefault(c.getState(), 0) + 1);
            }
        }

        System.out.println("Count Person by (city/state): ");
        String choice = scanner.nextLine();

        if(choice.equalsIgnoreCase("city")){
            displayCount(cityCount, "city");
        }
        else if(choice.equalsIgnoreCase("state")){
            displayCount(stateCount, "state");
        }
        else{
            System.out.println("Invalid Choice!");
        }
    }

    public void displayCount(Map<String, Integer> map, String criteria){
        if(map.isEmpty()){
            System.out.println("No data found!");
            return;
        }

        System.out.println("\nCount Person by " + criteria + " : ");

        for(Map.Entry<String, Integer> entry : map.entrySet()){
            System.out.println("Count of persons in:" + entry.getKey() + "is: " + entry.getValue());
        }
    }

    // UC-11
    @Override
    public void sortContacts(){
        System.out.println("Enter Address Book Name: ");
        String bookname = scanner.nextLine();

        AddressBook book = addressBooks.get(bookname);

        if(book == null){
            System.out.println("Book not found!");
            return;
        }

        book.sortContactsByName();

        System.out.println("Sorted contact by names: ");
        for(Contact c : book.getContacts()){
            System.out.println(c);
        }
    }

    // UC-12
    @Override
    public void sortContactsByCityStateOrZip() {

        System.out.print("Enter Address Book Name: ");
        String bookName = scanner.nextLine();

        AddressBook book = addressBooks.get(bookName);
        if (book == null) {
            System.out.println("Address Book not found.");
            return;
        }

        System.out.print("Sort by (city/state/zip): ");
        String choice = scanner.nextLine();

        
        switch (choice.toLowerCase()) {
            case "city":
                book.sortByCity();
                break;
            case "state":
                book.sortByState();
                break;
            case "zip":
                book.sortByZip();
                break;
            default:
                System.out.println("Invalid choice.");
                return;
        }

        System.out.println("\nSorted Contacts:");
        for (Contact c : book.getContacts()) {
            System.out.println(c); 
        }
    }

    // UC-13
    public void writeAddressBookToFile(){
        String bookname = scanner.nextLine();
        AddressBook book = addressBooks.get(bookname);
        if(book == null){
            System.out.println("Address Book not found.");
            return;
        }

        String file = bookname + ".txt";

        try(FileWriter writer = new FileWriter(file)){
            for(Contact c : book.getContacts()){
                writer.write(
                    c.getFirstName() + "," +
                    c.getLastName() + "," + 
                    c.getAddress() + "," + 
                    c.getCity() + "," +
                    c.getState() + "," + 
                    c.getZip() + "," +
                    c.getPhoneNumber() + "," +
                    c.getEmail() + "\n"
                );
            }
            System.out.println("Address book saved!");
        }
        catch(IOException e){
            System.out.println("Error writing to file.");
        }
    }

    public void readAddressBookFromFile(){
        String bookname = scanner.nextLine();
        AddressBook book = addressBooks.get(bookname);

        String file = bookname + ".txt";

        try(BufferedReader reader = new BufferedReader(new FileReader(file))){
            String line;

            while((line = reader.readLine()) != null){
                String[] data = line.split(",");

                Contact contact = new Contact(
                    data[0], data[1], data[2], 
                    data[3], data[4], data[5], 
                    data[6], data[7]);

                book.addContact(contact);
            }

            System.out.println("operation succesfull!");
        }
        catch(IOException e){
            System.out.println("file not found!");
        }
    }
}