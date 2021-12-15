import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        boolean MainLoop = true; // Loop For Main
        while (MainLoop) {
            System.out.println("***Welcome to IUE Library***");
            System.out.println("--------------------------------");
            System.out.println("- Log-in ( enter 1 )");//Enter
            System.out.println("- Sign-in ( enter 2 )");//Register
            System.out.println("- Exit ( enter 3 )");// Returns the program
            System.out.println("--------------------------------");
            System.out.print("Enter : ");
            String decision = input.next();


            switch (decision) {
                case "1": // For Log-in
                    Login.main(args);//LogIn Class

                    break;
                case "2":

                    // For Sign-in
                    SignIn.main(args);//SignIn Class
                    break;
                case "3":
                    System.out.println("***The program has been closed***");
                    MainLoop = false;

                    break;
                default:
                    System.out.println("--------------------------------");
                    System.out.println("Unaccepted value : " + decision);
                    System.out.println("--------------------------------");

            }//End Switch

        }// End While

    }
}


//////////// Bitti //////////



