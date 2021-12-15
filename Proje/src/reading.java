import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class reading {
    public static void main(String[] args) {
        try {
            Scanner UsersInput = new Scanner(System.in);
            boolean value = true;
      while (value) {
          File users = new File("Books.txt");
          Scanner reader = new Scanner(users);


          System.out.println("--------------------------------");
          System.out.println("Look Library( enter 1)");
          System.out.println("Search Book( enter 2)");//Buralara ekleme yap
          System.out.println("<-- Go Back( enter 3 ) ");
          System.out.println("--------------------------------");
          System.out.println("Enter your decision:");

          int userInput = UsersInput.nextInt();

          switch (userInput) {
              case 1:
                  System.out.println("--------------------------------");
                  System.out.println("**The Library**");
                  System.out.println("--------------------------------");
                  while (reader.hasNextLine()) {

                      String data1 = reader.nextLine();
                      System.out.println("* "+data1);

                  }
                  System.out.println("--------------------------------");
                  System.out.println("***Reading Successfully***");
                  boolean questionValue = true;
                while (questionValue) {
                    System.out.println("Do you want to barrow a book?(yes/no) ");
                    String decision1 = UsersInput.next();
                    if (decision1.equals("no") || decision1.equals("NO")) {

                        questionValue= false;


                    } else if (decision1.equals("yes") || decision1.equals("YES")) {
                        // This place will be doing taking book and deleting

                    } else
                        System.out.println("!!! Wrong Comment !!!");

                }
                  continue;

              case 2:
                  System.out.println("Enter The Book Name:");
                  String search = UsersInput.next();
                  boolean found = false;
                  int testcounter = 0;
                  while (reader.hasNextLine()) {
                      testcounter++;
                      String data2 = reader.nextLine();
                      if (data2.equals(search)) {
                          System.out.println("** Book Found:");
                          System.out.println("* " + data2 + " - ENABLE");
                          found = true;
                      }
                  }

                  System.out.println(testcounter);
                  if (!found) {
                      System.out.println("!!! Book Could Not Found !!!");
                      System.out.println("Do you Want to try again?(yes/no)");
                      String decision2 = UsersInput.next();
                      if (decision2.equals("no") || decision2.equals("NO")) {
                          UsersInput.close();
                          continue;
                      }else if (decision2.equals("yes") || decision2.equals("YES")) {
                          value=true;
                      }

                  }
                  System.out.println("***Reading Successfully***");
                  System.out.println("Do you want to continue?(yes/no)");
                  String decision3 = UsersInput.next();
                  if (decision3.equals("no") || decision3.equals("NO")) {
                      continue;
                  }


                  break;
              case 3:
                  System.out.println("***Sign-out Successfully***");
                  return;
              default:
                  System.out.println("Undefined Comment. Do you Want to try again?(yes/no)");
                  String decision4 = UsersInput.next();
                  if (decision4.equals("no") || decision4.equals("NO")) {
                      value=false;
                  }
          }
      }
        }catch (FileNotFoundException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
