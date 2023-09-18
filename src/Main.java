public class Main {
    public static void main(String[] args) {
        Account a1 = new Account();
        Account a2 = new Account("Kerstin", 200 );
        Account a3 = new Account(240);
        a1.setName("Olle");
        a1.deposit(1000);
        a1.whithdraw(200);
        System.out.println(a1);
        System.out.println(a2);
        a3.deposit(2000);
        System.out.println(a3);
    }
}