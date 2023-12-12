import java.io.FileReader;
import java.io.FileWriter;

public class Q6 {
    public static void main(String[] args) {
        try {
            FileReader fr = new FileReader("Mydata.txt");
            FileWriter fw = new FileWriter("CopiedFile.txt");
            int i;
            while((i = fr.read()) != -1)
                fw.write((char)i); 
            fw.close();
            fr.close();
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
    }
}
