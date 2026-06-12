public class SavingsAccount extends Account{

    private double interestRate ;

    public SavingsAccount(String Account_number , String Owner_name , double balance , double interestRate){
        super(Account_number,Owner_name,balance);
        this.interestRate = interestRate;
    }

@Override
public void display(){
    super.display();
    System.out.println("InterestRate: " + interestRate + "%");
    System.out.println("Projected Return: $" + (getbalance() * (interestRate / 100)));
    System.out.println("========================");

}
}