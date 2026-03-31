import java.util.*;

public class BankingSystem {
    public static void main(String[] args) {
        HashMap<Integer, Integer> accounts = new HashMap<>();
        accounts.put(101, 5000);
        accounts.put(102, 3000);
        accounts.put(103, 7000);

        System.out.println("Accounts: " + accounts);


        Queue<Integer> withdrawal = new LinkedList<>();
        withdrawal.add(101);
        withdrawal.add(102);

        int withdrawAmount = 1000;

        while ((!withdrawal.isEmpty())) {
            int accountNumber = withdrawal.poll();
            int balance = accounts.get(accountNumber);

            if(balance >= withdrawAmount)
                accounts.put(accountNumber, balance - withdrawAmount);
        }

        TreeMap<Integer, Integer> sorted = new TreeMap<>();
        for (Map.Entry<Integer, Integer> entry : accounts.entrySet()) {
            sorted.put(entry.getValue(), entry.getKey());
        }

        System.out.println("Accounts after Withdrawals: " + accounts);
        System.out.println("Customers Sorted By Balance: " + sorted);
    }
}
