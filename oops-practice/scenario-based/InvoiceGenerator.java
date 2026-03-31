class InvalidInvoiceFormatException extends Exception {
    public InvalidInvoiceFormatException(String message) {
        super(message);
    }
}

public class InvoiceGenerator {
    public void parseInvoice(String input) {
        try {
            String[] tasks = input.split(",");
            
            System.out.println("--- Invoice Details ---");
            for (String entry : tasks) {
                String entries = entry.trim();
                
                if (!entries.contains("-") || !entries.contains("INR")) {
                    throw new InvalidInvoiceFormatException("Invalid format in: " + entries);
                }
                
                System.out.println(entries);
            }

            double total = getTotalAmount(tasks);
            System.out.println("-----------------------");
            System.out.println("Total Amount: " + total + " INR");

        } catch (InvalidInvoiceFormatException e) {
            System.out.println(e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Amount must be a valid number.");
        }
    }

    public double getTotalAmount(String[] tasks) {
        double sum = 0;
        for (String entry : tasks) {
            String[] parts = entry.split("-");
            String amountPart = parts[1].trim().replace("INR", "").trim();
            
            sum += Double.parseDouble(amountPart);
        }
        return sum;
    }

    public static void main(String[] args) {
        InvoiceGenerator generator = new InvoiceGenerator();

        String input1 = "Logo Design - 3000 INR, Web Page - 4500 INR";
        generator.parseInvoice(input1);

        System.out.println("\nTesting Invalid Input:");
        String input2 = "Consulting 1000 INR";
        generator.parseInvoice(input2);
    }
}
