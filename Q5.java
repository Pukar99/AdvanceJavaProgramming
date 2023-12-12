import java.io.FileWriter;
import java.util.Scanner;

public class Q5 {
    public static void main(String[] args) {
        try {
            FileWriter fw = new FileWriter("Mydata.txt");
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter your text: ");
            String text = sc.nextLine();
            fw.write(text);
            fw.close();
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
    }
}
