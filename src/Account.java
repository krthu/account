public class Account {
    private double balance;
    private String name;

    public Account(double balance) {
        this.balance = balance;
    }

    public Account(String name){
        this.name = name;
        this.balance = 0;
    }

    public Account(String name, double balance){
        this.name = name;
        this.balance = balance;
    }


    public boolean whithdraw(double amount){
        if (amount <= balance && amount > 0){
            balance -= amount;
            return true;
        }
        return false;
    }

    public boolean deposit(double amount){
        if (amount > 0 ){
            balance += amount;
            return true;
        }
        return false;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public double getBalance(){return balance; }

    public String toString(){
        return (name +" har " + balance + "kr på kontot.");
    }





}
