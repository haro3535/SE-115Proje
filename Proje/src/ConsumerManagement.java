import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ConsumerManagement {
    public static void main(String[] args) {
        try{
            Scanner input = new Scanner(System.in);

            boolean ManagementLoop = true;
            while (ManagementLoop) {
                System.out.println("--------------------------------");
                System.out.println("***Consumer Management***");
                System.out.println("--------------------------------");
                System.out.println("Add Consumer( enter 1 )");//Finished
                System.out.println("Delete Consumer ( enter 2 )");
                System.out.println("Show Consumer List ( enter 3 )");//Finished
                System.out.println("<- Back ( enter 4 )");//Finished
                System.out.println("--------------------------------");
                System.out.print("Enter : ");
                String chose = input.next();

                FileWriter adasda = new FileWriter("");

                switch (chose){
                    case "1":
                        AddConsumer.main(args);
                        break;
                    case "2":
                        DeleteConsumer.main(args);
                        break;
                    case "3":

                        System.out.println("--------------------------------");
                        System.out.println("*** Consumer List ***");
                        System.out.println("--------------------------------");
                        File readConsumerList = new File("ConsumerList.txt");
                        Scanner consumerListReader = new Scanner(readConsumerList);

                        while (consumerListReader.hasNextLine()){
                            String consumerData = input.next();
                             // For Showing Consumer List
                            if (consumerData.equals("--------------------------------")) {
                                continue;
                            }
                            System.out.println("* " + consumerData);
                        }
                        consumerListReader.close();// Closes Reader
                        break;

                    case "4":
                        ManagementLoop = false;
                        continue;
                    default:
                        System.out.println(" Unaccepted value : " + chose);
                        continue; // It is not necessary
                }// End Switch

            }//End While

        }catch (IOException err){
            err.printStackTrace();
        }//End Catch

    }//End Main
}//End Class
