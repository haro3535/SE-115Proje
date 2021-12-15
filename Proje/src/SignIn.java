import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class SignIn {

    public String Name , Last, ID;



    public String getID() {
        return ID;
    }



    public String getLast() {
        return Last;
    }



    public String getName() {
        return Name;
    }




    public static void main(String[] args) {


try {
    Scanner inputSignIn = new Scanner(System.in);


            SignIn transport = new SignIn();
            boolean SignInLoop = true;
            while (SignInLoop) {
                System.out.println("--------------------------------");
                System.out.println("*** Sign-in ***");
                System.out.println("--------------------------------");
                System.out.println("First Name:");
                String FirstName = inputSignIn.next();
                System.out.println("Last Name:");
                String LastName = inputSignIn.next();
                System.out.println("Student ID:");
                String ID = inputSignIn.next();
                System.out.println("--------------------------------");
                System.out.println("Do you want to apply?(yes/no)");
                String apply = inputSignIn.next();

                boolean QuestionLoop = true;
                while (QuestionLoop) {//For Question
                    switch (apply) {
                        case "no", "NO", "No", "oN":  //Variables of No

                            SignInLoop = false; // Ends Loop
                            QuestionLoop = false;
                            continue;//Finishes Loop

                        case "yes", "YES", "yeS", "yES", "Yes", "YEs", "YeS", "yEs"://Variables of Yes

                            // Save point

                            transport.Name = FirstName;
                            transport.ID = ID;
                            transport.Last = LastName;



                            File ReadList = new File("AdminList.txt"); // Reads AdminList
                            Scanner adminReaderList = new Scanner(ReadList);
                            int adminListCounter = 0;


                            while (adminReaderList.hasNextLine()) {
                                String data = adminReaderList.nextLine();
                                adminListCounter++;
                            }
                            adminReaderList.close();

                            if (adminListCounter == 0) {

                                MainAdminAdding.main(args);
                                QuestionLoop = false;
                                SignInLoop = false;
                                break;

                            }



                                File firstReadList = new File("AdminList.txt"); // Reads AdminList
                                Scanner adminReader = new Scanner(firstReadList);

                                File secondReadList = new File("ConsumerList.txt"); // Reads UserList
                                Scanner userReader = new Scanner(secondReadList);

                                File thirdReadList = new File("WaitList.txt"); // Reads WaitList
                                Scanner waitReader = new Scanner(thirdReadList);


                                boolean checker = true;

                                while (waitReader.hasNextLine()) {

                                    String data = waitReader.nextLine();
                                    if (data.equals(transport.getName() + " - " + transport.getLast() + " - " + transport.getID())) {
                                        System.out.println("--------------------------------");
                                        System.out.println("!!! Your request has already been received !!! ");
                                        System.out.println("--------------------------------");
                                        checker = false;

                                        break;
                                    }

                                }
                                while (userReader.hasNextLine()) {
                                    String data = userReader.nextLine();
                                    if (data.equals(transport.getName() + " - " + transport.getLast() + " - " + transport.getID())) {
                                        System.out.println("--------------------------------");
                                        System.out.println("!!! You are already registered !!! ");
                                        System.out.println("--------------------------------");
                                        checker = false;
                                        break;
                                    }
                                }

                                while (adminReader.hasNextLine()) {
                                    String data = adminReader.nextLine();
                                    if (data.equals(transport.getName() + " - " + transport.getLast() + " - " + transport.getID())) {
                                        System.out.println("--------------------------------");
                                        System.out.println("!!! This record belongs to Administer !!! ");
                                        System.out.println("--------------------------------");
                                        checker = false;
                                        break;
                                    }

                                    if (data.equals(transport.getName() + " - " + transport.getLast() + " - " + transport.getID() + " - " + "( Main Admin )")) {
                                        System.out.println("--------------------------------");
                                        System.out.println("!!! This record belongs to Administer !!! ");
                                        System.out.println("--------------------------------");
                                        checker = false;
                                        break;
                                    }
                                }


                                if (checker) {
                                    FileWriter toWaitList = new FileWriter("WaitList.txt", true);

                                    toWaitList.append(transport.getName());
                                    toWaitList.append(" - ");
                                    toWaitList.append(transport.getLast());
                                    toWaitList.append(" - ");
                                    toWaitList.append(transport.getID());
                                    toWaitList.append("\n");
                                    toWaitList.append("--------------------------------");
                                    toWaitList.append("\n");
                                    toWaitList.close();

                                    System.out.println("--------------------------------");
                                    System.out.println("***Applied Successfully***");
                                    System.out.println("***Now You Are In Waiting List***");
                                    System.out.println("--------------------------------");

                                }// End If


                               QuestionLoop = false;
                               SignInLoop = false;


                            break;
                        default:
                            System.out.println("Unexpected value : " + apply);

                    }
                }//End While
            }//End While
} catch (IOException error) {
    System.out.println("!!!An error occurred while saving!!!");
    error.printStackTrace();

}// End Catch

    }//End Main
}//End Class
