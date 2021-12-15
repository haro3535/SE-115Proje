import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class AddConsumer {
    public static void main(String[] args) {
        try{
            Scanner input = new Scanner(System.in);

               boolean addLoop = true;
            while (addLoop){
                System.out.println("--------------------------------");
                System.out.println("*** Add Consumer ***");
                System.out.println("--------------------------------");
                System.out.println("Add New Consumer ( enter 1 )");// Finished
                System.out.println("Apply Wait List ( enter 2 )");//Finished
                System.out.println("<- Back ( enter 3 )");//Finished
                System.out.println("--------------------------------");
                System.out.print("Enter: ");
                String chose = input.next();

                switch (chose){
                    case "1":


                        boolean informationLoop = true;
                        while (informationLoop){

                            System.out.println("--------------------------------");
                            System.out.println("*** Add New Consumer ***");
                            System.out.println("--------------------------------");
                            System.out.println("Add -> ( 1 )  / Cancel -> ( 2 ) :");
                            System.out.println("--------------------------------");
                            System.out.print("Enter: ");
                            String decision = input.next();



                            switch (decision) {
                                case "1":


                                    System.out.println("--------------------------------");
                                    System.out.println("Name:");
                                    String consumerName = input.next();
                                    System.out.println("Last Name:");
                                    String consumerLastName = input.next();
                                    System.out.println("ID:");
                                    String consumerID = input.next();





                                    File consumerListChecker = new File("ConsumerList.txt");
                                    Scanner consumerExist = new Scanner(consumerListChecker); // To avoid conflict

                                    File adminListChecker = new File("AdminList.txt");
                                    Scanner adminChecker = new Scanner(adminListChecker);// To avoid conflict

                                    File waitListChecker = new File("WaitList.txt");
                                    Scanner consumerWaiting = new Scanner(waitListChecker); // To avoid conflict



                                    boolean condition1 = true;
                                    boolean condition2 = true;


                                    while (adminChecker.hasNextLine()){
                                        String adminData = adminChecker.nextLine();
                                        if (adminData.equals(consumerName + " - " + consumerLastName + " - " + consumerID)
                                                || adminData.equals(consumerName + " - " + consumerLastName + " - " + consumerID + " - " + "( Main Admin )")){
                                            System.out.println("--------------------------------");
                                            System.out.println("!!! This information belongs to Administer !!!");
                                            condition1 = false;
                                            break;
                                        }
                                    }


                                    while (consumerExist.hasNextLine()){
                                        String existData = consumerExist.nextLine();
                                        if (existData.equals(consumerName + " - " + consumerLastName + " - " + consumerID)) {
                                            System.out.println("--------------------------------");
                                            System.out.println("!!! Consumer has been already exists !!!");
                                            condition2 = false;
                                            break;
                                        }

                                    }

                                    while (consumerWaiting.hasNextLine()){
                                        String waitingData = consumerWaiting.nextLine();
                                        if (waitingData.equals(consumerName + " - " + consumerLastName + " - " + consumerID)) {
                                            System.out.println("--------------------------------");
                                            System.out.println("!!! Consumer is waiting in Wait List !!!");
                                            condition2 = false;
                                            break;
                                        }

                                    }

                                    if (condition1) {
                                        if (condition2) {
                                            FileWriter newConsumer = new FileWriter("ConsumerList.txt",true);

                                            newConsumer.write(consumerName + " - " + consumerLastName + " - " + consumerID + "\n");
                                            newConsumer.write("--------------------------------\n");
                                            newConsumer.close();

                                            System.out.println("--------------------------------");
                                            System.out.println("*** Consumer Successfully Registered ***");
                                            break;
                                        }

                                    }


                                      informationLoop = false;
                                    continue;

                                case "2":
                                    informationLoop=false;
                                    continue;
                                default:
                                    System.out.println("Unaccepted value : " + decision);
                                    break;
                            }
                        }


                            break;
                    case "2":
                        ApplyWaitList.main(args);
                        break;
                    case "3":
                        addLoop = false;
                        continue;
                    default:
                        System.out.println("Unaccepted value : " + chose);
                        break;
                }
            }



        }catch (IOException err){
            err.printStackTrace();
        }
    }
}
