import java.util.List;

class Invoice{
    int id;

    Invoice(int id){
        this.id = id;
    }

    public String toString(){
        return "Invoice for ID: " + id;
    }
}

public class InvoiceCreation {
    public static void main(String[] args) {
        List<Integer> ids = List.of(101, 102, 103, 104, 105);

        List<Invoice> invoices = ids.stream().map(Invoice::new).toList();

        invoices.forEach(System.out::println);

    }
}
