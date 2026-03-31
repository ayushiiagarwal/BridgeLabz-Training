import java.util.*;

class Transaction {
    String type;
    int amount;
    int remainingLimit;

    Transaction(String type, int amount, int remainingLimit) {
        this.type = type;
        this.amount = amount;
        this.remainingLimit = remainingLimit;
    }
}

class CreditCard {
    String cardNumber;
    String cardHolderName;
    int creditLimit;
    int availableLimit;
    List<Transaction> transactions;

    CreditCard(String cardNumber, String cardHolderName, int creditLimit) {
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
        this.creditLimit = creditLimit;
        this.availableLimit = creditLimit;
        this.transactions = new ArrayList<>();
    }
}

class CreditCardSystem {

    Map<String, CreditCard> cards = new HashMap<>();

    // ISSUE
    public int issueCard(String cardNumber, String holderName, int creditLimit) {
        if (cards.containsKey(cardNumber)) {
            return 0;
        }
        cards.put(cardNumber, new CreditCard(cardNumber, holderName, creditLimit));
        return 1;
    }

    // SPEND
    public int spendAmount(String cardNumber, int amount) {
        if (!cards.containsKey(cardNumber)) {
            System.out.println("Transaction declined");
            return 0;
        }

        CreditCard card = cards.get(cardNumber);

        if (amount > card.availableLimit) {
            System.out.println("Transaction declined");
            return 0;
        }

        card.availableLimit -= amount;
        card.transactions.add(new Transaction("SPEND", amount, card.availableLimit));

        System.out.println("SPENT " + cardNumber + " " + card.availableLimit);
        return 1;
    }

    // PAYMENT
    public int makePayment(String cardNumber, int amount) {
        if (!cards.containsKey(cardNumber)) {
            System.out.println("Card not found");
            return 0;
        }

        CreditCard card = cards.get(cardNumber);

        card.availableLimit += amount;

        if (card.availableLimit > card.creditLimit) {
            card.availableLimit = card.creditLimit;
        }

        card.transactions.add(new Transaction("PAYMENT", amount, card.availableLimit));

        System.out.println("PAYMENT DONE " + cardNumber + " " + card.availableLimit);
        return 1;
    }

    // HOLDER
    public void getCardsByHolder(String holderName) {
        List<CreditCard> list = new ArrayList<>();

        for (CreditCard card : cards.values()) {
            if (card.cardHolderName.equals(holderName)) {
                list.add(card);
            }
        }

        if (list.isEmpty()) {
            System.out.println("No cards found");
            return;
        }

        // sort by cardNumber
        Collections.sort(list, (a, b) -> a.cardNumber.compareTo(b.cardNumber));

        for (CreditCard card : list) {
            System.out.println(card.cardNumber + " " + card.availableLimit);
        }
    }
}

public class CreditCardManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        CreditCardSystem system = new CreditCardSystem();

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            String[] parts = line.split(" ");

            String command = parts[0];

            if (command.equals("ISSUE")) {
                String cardNumber = parts[1];
                String holderName = parts[2];
                int creditLimit = Integer.parseInt(parts[3]);
                system.issueCard(cardNumber, holderName, creditLimit);
            }

            else if (command.equals("SPEND")) {
                String cardNumber = parts[1];
                int amount = Integer.parseInt(parts[2]);
                system.spendAmount(cardNumber, amount);
            }

            else if (command.equals("PAYMENT")) {
                String cardNumber = parts[1];
                int amount = Integer.parseInt(parts[2]);
                system.makePayment(cardNumber, amount);
            }

            else if (command.equals("HOLDER")) {
                String holderName = parts[1];
                system.getCardsByHolder(holderName);
            }
        }

        sc.close();
    }
}