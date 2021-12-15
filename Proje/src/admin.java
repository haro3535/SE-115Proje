import java.util.Scanner;

public class admin {




    private String AdminName, AdminPassword, AdminID;

  admin(String AdminName, String AdminPassword,String AdminID){
      this.AdminName = AdminName;
      this.AdminPassword = AdminPassword;
      this.AdminID = AdminID;
  }

    public void setAdminName(String adminName) {
        AdminName = adminName;
    }

    public String getAdminName() {
        return AdminName;
    }

    public void setAdminPassword(String adminPassword) {
        AdminPassword = adminPassword;
    }

    public String getAdminPassword() {
        return AdminPassword;
    }

    public void setAdminID(String adminID) {
        AdminID = adminID;
    }

    public String getAdminID() {
        return AdminID;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
      //  admin second = new admin("Harun","12345","20210602042");

        boolean value = true;
        while (value){
            System.out.println("***Welcome Admin***");
            System.out.println("--------------------------------");
            System.out.println("Add/Delete Administrator ( enter 1 )");// Finished
            System.out.println("ADD/Delete New Consumer ( enter 2 )");//Kaldı
            System.out.println("Add a New Content ( enter 3 )");//Kaldı
            System.out.println("Library-Deposit-Return-Add ( enter 4 )");//Kaldı
            System.out.println("Sign-out ( enter 5 )");//Finished
            System.out.println("--------------------------------");
            System.out.println("Enter: ");
            String adminInput = input.next();
            switch (adminInput){
                case "1":
                    AdminManagement.main(args);
                    break;
                case "2":
                    ConsumerManagement.main(args);
                    break;
                case "3":

                case "4":
                    reading.main(args);
                    break;
                case "5":
                    System.out.println("--------------------------------");
                    System.out.println("Sign-out ( enter 1)");
                    System.out.println("Sign-out and Exit ( enter 2)");
                    System.out.println(" <-- Back ( enter 3 )");
                    System.out.println("--------------------------------");
                    String adminDecision1 = input.next();
                    switch (adminDecision1){
                        case "1":
                            System.out.println("--------------------------------");
                            System.out.println("*** Sign-out Successfully ***");
                            System.out.println("--------------------------------");
                            value = false;
                            continue;
                        case "2":
                            System.out.println("--------------------------------");
                            System.out.println("*** Sign-out And Exit Successfully ***");
                            System.out.println("--------------------------------");

                            return;


                        case "3":
                            System.out.println("--------------------------------");
                            continue;
                        default:
                            System.out.println("--------------------------------");
                            System.out.println("!!! Unexpected value:" + adminInput);
                            System.out.println("--------------------------------");
                            System.out.println("(Enter anything to continue):");
                            String anything = input.next();
                            if (anything.equals(anything)) {
                                System.out.println("--------------------------------");
                                continue;
                            }

                          //  throw new IllegalStateException("Unexpected value: " + adminInput);
                    }

                default :
                    throw new IllegalStateException("Unexpected value: " + adminInput);
            }
       }
    }
}
