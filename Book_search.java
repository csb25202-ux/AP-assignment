import java.util.ArrayList;
import java.util.Scanner;

public class Book_search{
    public static void main(String[] args){
        ArrayList<String>Books = new ArrayList<>();
        Books.add("Harry potter and the philosopher's stone");
        Books.add("The lord of the Rings");
        Books.add("The great gatsby");
        Books.add("Pride and prejudice");
        Books.add("Bhagavad Gita");

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a word to search for Books : ");
        String word = sc.nextLine();
        System.out.println("Books containing the word "+ word + " are : ");
        for(String title:Books){
            if(title.toLowerCase().contains(word.toLowerCase())){
                System.out.println(title);
            }
        }
                    System.out.println("Not found ");
    }

}
