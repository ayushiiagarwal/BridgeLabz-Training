interface Sensitive{

}

class Account implements Sensitive{
    String accountNo;
    String accountHolder;

    Account(String accountNo, String accountHolder){
        this.accountNo = accountNo;
        this.accountHolder = accountHolder;
    }
}

class Transactions {
    static void records(Object obj){
        if(obj instanceof Sensitive)
            System.out.println("Encrypring sensitive data!");
        else
            System.out.println("Storing normal data!");
    }
}

public class SensitiveData {
    public static void main(String[] args) {
        Account user = new Account("AS1545", "Adam");

        Transactions.records(user);
    }
}
