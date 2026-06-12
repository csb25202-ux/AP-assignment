import java.util.ArrayList;
import java.util.List;

public class Main{
    public static void main(String[] args) {
        System.out.println("INITIALIZING SYSTEM...\n");
        List<Account> masterList = new ArrayList<>();

        SavingsAccount strategist = new SavingsAccount("S-001" , "Rohit" , 50000.0 , 4.5);
        CurrentAccount Highroller = new CurrentAccount("C-001" , "Anand" , 30000.0 , 10000.0);

        masterList.add(strategist);
        masterList.add(Highroller);

        System.out.println("--- REAL-TIME TRANSACTIONS ---");
        Highroller.withdraw(3000.0); 
        System.out.println();
        System.out.println("=== INITIATING SYSTEM-WIDE AUDIT ===\n");

        for (Account operative : masterList) {
            operative.display(); 
        }
    }
}