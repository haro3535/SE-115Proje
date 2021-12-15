
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class AddAdmin {
    public static void main(String[] args) {
        try{
            Scanner input = new Scanner(System.in);

            boolean add = true;
        while (add) {

            System.out.println("*** Add Administer***");
            System.out.println("--------------------------------");
            System.out.println("Admin Name:");
            String adminName = input.next();
            System.out.println("Admin Last Name:");
            String adminLastName = input.next();
            System.out.println("Admin ID:");
            String adminId = input.next();

            File readAdminList = new File("AdminList.txt");
            Scanner ReadAdminList = new Scanner(readAdminList);

            boolean again = false;
            boolean addingAdmin = true;
            while (ReadAdminList.hasNextLine()) {
                String adminData = ReadAdminList.nextLine();
                if (adminData.equals(adminName + " - " + adminLastName + " - " + adminId)
                || adminData.equals(adminName + " - " + adminLastName + " - " + adminId + " - " + "( Main Admin )")) {
                    System.out.println("!!! Admin already registered !!!");
                    addingAdmin=false;
                    again = true;
                    break;
                }
            }

            if (again) {
                System.out.println("Do you want to try again? (yes/no)");
                String chose = input.next();
                switch (chose) {
                    case "no", "NO", "No", "oN":  //Variables of No
                           add = false;
                           continue;//Ends Loop
                    case "yes", "YES", "yeS", "yES", "Yes", "YEs", "YeS", "yEs"://Variables of Yes
                            continue;//Continues Loop
                    default:
                        System.out.println("Unexpected value : " + chose);
                }
            }//End If

            System.out.println("--------------------------------");
            System.out.println("- Are You Sure (yes/no)");
            String sure = input.next();

            switch (sure) {
                case "no", "NO", "No", "oN":  //Variables of No
                    add = false;
                    continue;//Ends Loop
                case "yes", "YES", "yeS", "yES", "Yes", "YEs", "YeS", "yEs"://Variables of Yes
                    if (addingAdmin ) {
                        FileWriter adminWriter = new FileWriter("AdminList.txt",true);

                        adminWriter.write(adminName);
                        adminWriter.write(" - ");
                        adminWriter.write(adminLastName);
                        adminWriter.write(" - ");
                        adminWriter.write(adminId);
                        adminWriter.write("\n");
                        adminWriter.write("--------------------------------\n");


                        adminWriter.close();

                        System.out.println("--------------------------------");
                        System.out.println("***Successfully Wrote***");
                        System.out.println("--------------------------------");
                        add = false;
                        break;
                    }//End If
                default:
                    System.out.println("Unexpected value : " + sure);
            }

        }//End While

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
