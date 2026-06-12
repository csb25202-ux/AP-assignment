

public class CurrentAccount extends Account{
    private double OverdraftLimit ;

    public CurrentAccount(String Account_number , String Owner_name , double balance , double Overdraft){
        super(Account_number,Owner_name,balance);
        this.OverdraftLimit = Overdraft;       
    }

    @Override
    public void withdraw(double amount){
        if (amount <= 0) {
            System.out.println("SECURITY ALERT: Invalid withdrawal amount.");
        }
        else if(amount > (getbalance() + OverdraftLimit)){
            System.out.println("SECURITY ALERT: Overdraft limit exceeded. Operation blocked.");
        }
        else{
            double newbalance = getbalance() - amount;
            setbalance(newbalance);
            System.out.println("LOG: High-roller withdrawal of $" + amount + " authorized.");
        }
    }

    @Override
    public void display(){
        super.display();
        System.out.println("OverdraftLimit: $" + this.OverdraftLimit);
        System.out.println("========================");
    }

}