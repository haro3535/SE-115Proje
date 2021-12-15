
import javax.imageio.IIOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Login {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);


        try {
            boolean LoginLoop = true;
            while (LoginLoop) {
                // Interface for Users and Admins
                System.out.println("--------------------------------");
                System.out.println("***Log-In***");
                System.out.println("--------------------------------");
                System.out.println("Name:");
                String NameForEnter = input.next();

                System.out.println("Last Name:");
                String LastNameForEnter = input.next();

                System.out.println("Id:");
                String IDForEnter = input.next();

                File userChecker = new File("ConsumerList.txt");//Reader
                Scanner UserChecker = new Scanner(userChecker);

                File adminChecker = new File("AdminList.txt");//Reader
                Scanner AdminChecker = new Scanner(adminChecker);

                boolean noAdmin = true;
                boolean noUser = true;

                while (AdminChecker.hasNextLine()) {
                    //For Admins
                    String adminData = AdminChecker.nextLine();
                    if (adminData.equals(NameForEnter + " - " + LastNameForEnter + " - " + IDForEnter)
                            || adminData.equals(NameForEnter + " - " + LastNameForEnter + " - " + IDForEnter + " - " + "( Main Admin )")) {
                        noAdmin = false; // It means the above information belongs to the admin.
                        admin.main(args);
                        LoginLoop = false;
                        break;
                    }
                }

                while (UserChecker.hasNextLine()) {
                    //For Users
                    String userData = UserChecker.nextLine();
                    if (userData.equals(NameForEnter + " - " + LastNameForEnter + " - " + IDForEnter)) {
                        noUser = false;// It means the above information belongs to the user.
                        //   admin.main(args); //User.class
                        break;
                    }
                }

                if (noUser && noAdmin) {
                    // User or Admin not found
                    System.out.println("!!! Wrong Name, Password or ID !!!");
                    boolean QuestionLoop = true;
                    while (QuestionLoop) {
                        System.out.println("Want you try again(yes/no)?");
                        String chose = input.next();
                        switch (chose) {
                            case "no","NO","No","oN":  //Variables of No

                                LoginLoop = false;
                                QuestionLoop = false;
                                continue;//Finishes Loop

                            case "yes","YES","yeS","yES","Yes","YEs","YeS","yEs"://Variables of Yes

                                continue;//Continues loop

                            default:
                                System.out.println("Unexpected value : " + chose);

                        }
                    }
                }
            }
        }catch (FileNotFoundException error){
            error.printStackTrace();
        }

    }
}
