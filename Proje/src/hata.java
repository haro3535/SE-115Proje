import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class hata {
    public static void main(String[] args) {
        try {
            File ReadList = new File("AdminList.txt"); // Reads AdminList
            Scanner adminReaderList = new Scanner(ReadList);
            int adminListCounter = 0;


            while (adminReaderList.hasNextLine()) {
                String data = adminReaderList.nextLine();
                adminListCounter++;
            }
            adminReaderList.close();

            if (adminListCounter == 0) {
                System.out.println("Hello");
                MainAdminAdding.main(args);

            }
            System.out.println("Kepaze");
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
