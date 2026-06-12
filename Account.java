public class Account{
    private String Account_number;
    private String Owner_name ;
    private double balance ;


    public Account(String Account_number , String Owner_name , double balance){
        this.Account_number = Account_number;
        this.Owner_name = Owner_name ;
        this.balance = balance ;
        System.out.println("LOG : master initialization complete for " + Owner_name);
    }

    public Account(String Account_number , String Owner_name){
        this(Account_number , Owner_name , 0.0);
    }


    public void deposit(double amount){
        if(amount <= 0){System.out.println("SECURITY ALERT: Invalid deposit amount. Must be greater than 0.");}
        else{
            this.balance += amount ;
            System.out.println("LOG: Deposited " + amount + " for " + this.Owner_name);
        }
    }

    public void withdraw(double amount){
        if (amount <= 0) {
            System.out.println("SECURITY ALERT: Invalid withdrawal amount.");
        }
        else if (amount > this.balance) {
            System.out.println("SECURITY ALERT: Insufficient funds. Operation blocked.");
        }
        else{
            this.balance -= amount;
            System.out.println("LOG: Withdrew " + amount + " for " + this.Owner_name);
        }
    }

    public void display(){
        System.out.println("=== TRANSACTION DETAILS ===");
        System.out.println("Operative ID : " + this.Account_number);
        System.out.println("Name       : " + this.Owner_name);
        System.out.println("Available balance: $" + this.balance);
        System.out.println("========================");
    }


    public String getAccount_number(){
        return Account_number ;
    }

    public void setAccount_number(String new_account_number){
        Account_number = new_account_number ; 
    }
    
    public String getOwner_name(){
        return Owner_name;
    }

    public void setOwner_name(String new_Owner_name){
        Owner_name = new_Owner_name ;
    }

    public double getbalance(){
        return balance;
    } 

    public void setbalance(double new_balance){
        if(new_balance <= 0){System.out.println("Invalid amount ! , transaction cancelled");}
        else{balance = new_balance;}
    }
}