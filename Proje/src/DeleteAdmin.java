import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DeleteAdmin {
    public static void main(String[] args) {
        try{
            Scanner input = new Scanner(System.in);

            System.out.println("*** Delete Admin ***");
            System.out.println("--------------------------------");
            System.out.println("*** Admin List ***");
            System.out.println("--------------------------------");

            File readerAdminList = new File("AdminList.txt");
            Scanner ReaderAdminList = new Scanner(readerAdminList);

            while (ReaderAdminList.hasNextLine()){
                String dataList = ReaderAdminList.nextLine();

                if (dataList.equals("--------------------------------")) {
                    continue;
                }
                System.out.println(" * " + dataList);
            }
            ReaderAdminList.close();


            System.out.println("--------------------------------");
            System.out.println("Admin Name:");
            String deleteName = input.next();
            System.out.println("Admin Last Name:");
            String deleteLastName = input.next();
            System.out.println("Admin ID:");
            String deleteId = input.next();
            System.out.println("--------------------------------");
            System.out.println("Are you sure?(yes/no)");
            String decision = input.next();

            switch (decision){
                case "no","NO","No","oN":  //Variables of No

                    break;

                case "yes","YES","yeS","yES","Yes","YEs","YeS","yEs"://Variables of Yes

                    File deletingAdmin =  new File("AdminList.txt");
                    // This step creates a reader for the Admin List
                    Scanner DeletingAdmin = new Scanner(deletingAdmin);

                    FileWriter temporary = new FileWriter("Temporary.txt");
                    // For writing to Temporary
                    // Append is false because it (Temporary.txt) needs to refresh before the writing part

                     boolean notFound = false;
                    while (DeletingAdmin.hasNextLine()){
                        // Reading Part
                        String adminData = DeletingAdmin.nextLine();
                        if (adminData.equals(deleteName + " - " + deleteLastName + " - " + deleteId) ) {
                            // In this part we find the person to be deleted
                            System.out.println("!!!Admin has been detected!!!");
                            notFound = true ;
                            continue;
                        }

                        if (adminData.equals("--------------------------------")) {
                            // To avoid confusion
                            continue;
                        }

                        temporary.write(adminData);
                        temporary.write("\n");


                    }// End While

                    DeletingAdmin.close();// Closes The Reader

                    if (!notFound ) {
                        // When the Admin can't be found
                        System.out.println("!!! Admin Does Not Exists !!!");
                        System.out.println("--------------------------------");

                        return;
                    }


                    if (notFound) {

                        temporary.close();

                        FileWriter deleteAdminList = new FileWriter("AdminList.txt",false);
                        deleteAdminList.close();

                        FileWriter temporaryToAdminList = new FileWriter("AdminList.txt",true);

                        File readTemporary = new File("Temporary.txt");
                        Scanner Reader = new Scanner(readTemporary);

                        while (Reader.hasNextLine()){
                            String dataTemp = Reader.nextLine();

                            temporaryToAdminList.write(dataTemp);
                            temporaryToAdminList.write("\n");
                            temporaryToAdminList.write("--------------------------------\n");

                        }
                        Reader.close();
                        temporaryToAdminList.close();

                        FileWriter deleteTemp = new FileWriter("Temporary.txt",false);
                        deleteTemp.close();

                        System.out.println("--------------------------------");
                        System.out.println("*** Update Successfully ***");
                        System.out.println("--------------------------------");

                        File lastReaderAdminList = new File("AdminList.txt");
                        Scanner AdminList = new Scanner(lastReaderAdminList);

                        System.out.println("*** New AdminList ***");
                        System.out.println("--------------------------------");

                        while (AdminList.hasNextLine()){
                            String lastDataList = AdminList.nextLine();

                            if (lastDataList.equals("--------------------------------")) {
                                continue;
                            }
                            System.out.println(" * " + lastDataList);
                        }
                        AdminList.close();
                        System.out.println("--------------------------------");


                    }

                    break;

                default:
                    System.out.println("Unexpected value : " + decision);





            }





        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
