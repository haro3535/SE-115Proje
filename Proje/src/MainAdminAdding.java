import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MainAdminAdding {
    public static void main(String[] args) {

        try {

            Scanner input = new Scanner(System.in);

            System.out.println("*** Add Administer***");
            System.out.println("--------------------------------");
            System.out.println("Admin Name:");
            String adminName = input.next();
            System.out.println("Admin Last Name:");
            String adminLastName = input.next();
            System.out.println("Admin ID:");
            String adminId = input.next();


            FileWriter mainAdminWriter = new FileWriter("AdminList.txt", true);


            mainAdminWriter.write(adminName);
            mainAdminWriter.write(" - ");
            mainAdminWriter.write(adminLastName);
            mainAdminWriter.write(" - ");
            mainAdminWriter.write(adminId);
            mainAdminWriter.write(" - ");
            mainAdminWriter.write("( Main Admin )");
            mainAdminWriter.write("\n");
            mainAdminWriter.write("--------------------------------\n");

            mainAdminWriter.close();





}catch (IOException e){
        e.printStackTrace();
        }
    }
}
