import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class AdminManagement {
    public static void main(String[] args) {
        try {
            Scanner input = new Scanner(System.in);

            boolean ManagementLoop = true;
            while (ManagementLoop) {
                System.out.println("***Admin Management***");
                System.out.println("--------------------------------");
                System.out.println("Add Admin( enter 1 )");//Finished
                System.out.println("Delete Admin ( enter 2 )");//Finished
                System.out.println("Show Admin List ( enter 3 )");//Finished
                System.out.println("<- Back ( enter 4 )");//Finished
                System.out.println("--------------------------------");
                System.out.print("Enter : ");
                String chose = input.next();

                File readAdminList = new File("AdminList.txt");


                switch (chose) {
                    case "1":
                        AddAdmin.main(args);
                        break;
                    case "2":// temp muhabebeti burada
                        DeleteAdmin.main(args);
                        break;
                    case "3":
                        Scanner ReadAdminList = new Scanner(readAdminList);
                        System.out.println("--------------------------------");
                        System.out.println("*** Admin List ***");
                        System.out.println("--------------------------------");
                        while (ReadAdminList.hasNextLine()) {
                            String adminListData = ReadAdminList.nextLine();

                            if (adminListData.equals("--------------------------------")) {
                                continue;
                            }
                            System.out.println(adminListData);
                        }
                        System.out.println("--------------------------------");
                        System.out.println("***Reading Successfully***");
                        System.out.println("--------------------------------");
                        System.out.println("(Enter Something For Go Back)");
                        String enter = input.next();
                        if (enter.equals(enter)) {
                            continue;
                        }

                        break;
                    case "4":
                        ManagementLoop = false;
                        break;
                    default:
                        System.out.println(" Unaccepted value : " + chose);
                        continue; // It is not necessary
                } // End Switch
            }//End While

        }//End Try

        catch(IOException e){
                e.printStackTrace();
            }


    }
}
