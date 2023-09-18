import java.util.HashMap;
import java.util.Scanner;

public class Main {
      static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        HashMap<String, Account> accounts = new HashMap<>();
        Account currentAccount = null;

        System.out.println("Välkommen till Banken");
        System.out.println("Skriv in ditt namn för att starta ett konto.");
        while (accounts.isEmpty()) {
            String nameOfCurrentAccount = sc.nextLine();
            if (!newCustomer(nameOfCurrentAccount, accounts)) {
                System.out.println("Det finns redan en person med det namnet. Du får byta namn :)");
            }else {
//                currentAccount = new Account(nameOfCurrentAccount);
//                accounts.put(currentAccount.getName() ,currentAccount);
//                currentAccount = accounts.get(nameOfCurrentAccount);
                currentAccount = accounts.get(nameOfCurrentAccount);
            }

        }
        String choice ="";
        System.out.println("Välkommen " + currentAccount.getName());
        while (!choice.equalsIgnoreCase("0")){
            System.out.println();

            System.out.println("Vad vill du göra " + currentAccount.getName() + ".");
            System.out.println("1. Sätta in pengar");
            System.out.println("2 Ta ut pengar");
            System.out.println("3 Saldo");
            System.out.println("4 Byta namn på konto");
            System.out.println("5 Skapa en kund till");
            System.out.println("6 Byt till annans konto");
            System.out.println("0 För att avsluta");
            choice =  sc.nextLine();

            switch ( choice){
                case "1" -> {
                    System.out.println(accounts);
                    makeDeposit(currentAccount);
                }
                case "2" -> {
                    makeWithdraw(currentAccount);
                }

                case "3" -> {
                    System.out.println(currentAccount.toString());
                }

                case "4" -> {
                    changeAccountName(currentAccount, accounts);
                }

                case "5" -> {
                    System.out.println("Vilket namn vill du ha på kontot?");
                    String name = sc.nextLine();
                    if (newCustomer(name, accounts)){
                        currentAccount = changeCurrentAccount(name, accounts);
                    }else{
                        System.out.println("Det finns redan en person med det namnet. Du får byta namn :)");
                    }

                }

                case "6" -> {
                    System.out.println("Vilket befintligt kontonamn vill du byta till?");
                    String name = sc.nextLine();
                    Account tempAccount = changeCurrentAccount(name, accounts);
                    if (tempAccount == null){
                        System.out.println("Användaren finns inte");
                    }else {
                        currentAccount = tempAccount;
                    }
                }
                case "0" ->{
                    System.out.println("Avslutas!");
                }
                default -> {
                    System.out.println("Ogiltigt menyval.");
                }
            }
        }



    }

    public static Account changeCurrentAccount(String name , HashMap<String, Account> accounts){
        return accounts.getOrDefault(name, null);
    }

    public static void changeAccountName(Account currentAccount, HashMap<String, Account> accounts){
        System.out.println("Vill du verkligen byta namn på kontot? (j/n)");
        String areYouSure = sc.nextLine();
        if (areYouSure.equalsIgnoreCase("j")){
            System.out.println("Vilket namn vill du byta till?");
            String name = sc.nextLine();
            if (accounts.containsKey(name)){
                System.out.println("Tyvärr det namnet finns redan.");
            }else {
                accounts.remove(currentAccount.getName());
                currentAccount.setName(name);
                accounts.put(name, currentAccount);
            }

        }else {
            System.out.println("Avbryter");
        }
    }

    public static void makeWithdraw(Account currentAccount){
        System.out.println("Hur mycket vill du ta ut?");
        double amount =  sc.nextDouble();
        sc.nextLine();
        if (currentAccount.whithdraw(amount)){
            System.out.println("Du har tagit ut " + amount + "kr. Ditt Saldo är " + currentAccount.getBalance() + "kr.");
        }else {
            System.out.println("Uttaget misslyckades. Har du tillräckligt på kontot?");
        }
    }

    public static void makeDeposit(Account currentAccount){
        System.out.println("Hur mycket vill du sätta in?");
        double amount = sc.nextDouble();
        sc.nextLine();
        if (currentAccount.deposit(amount)){
            System.out.println("Du har satt in " + amount +"kr. Ditt saldo är nu " + currentAccount.getBalance()+ "kr");
        }else{
            System.out.println("Insättningen misslyckades.");
        }

    }

    public static boolean newCustomer(String name, HashMap<String, Account> customers){
        if (customers.containsKey(name)){
            return false;
        }
        Account customer = new Account(name);
        customers.put(name, customer);
        return true;
    }
}