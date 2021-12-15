import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ApplyWaitList {
    public static void main(String[] args) {
          try {
              Scanner input = new Scanner(System.in);

              boolean applyWaitListLoop = true;
              while (applyWaitListLoop){
                  System.out.println("--------------------------------");
                  System.out.println("*** Apply Wait List ***");
                  System.out.println("--------------------------------");
                  System.out.println("Show Wait List ( enter 1 )");
                  System.out.println("Register Wait List ( enter 2)");
                  System.out.println("<- Back ( enter 3 )");
                  System.out.println("--------------------------------");
                  System.out.print("Enter: ");
                  String chose = input.next();

                  switch (chose){
                      case "1":
                          File readWaitList = new File("WaitList.txt");
                          Scanner readerWaitList = new Scanner(readWaitList);

                          while (readerWaitList.hasNextLine()){
                              String waitListData = readerWaitList.nextLine();
                              if (waitListData.equals("--------------------------------")) {
                                  continue;
                              }
                              System.out.println("* " + waitListData);
                          }
                          readerWaitList.close();
                          System.out.println("--------------------------------");
                          System.out.println("*** Read Successfully ***");
                          System.out.println("--------------------------------");
                                  continue;
                      case "2":
                          // Burası gereksiz olmuşşşşşş consumer silme kısmı gibi olmuş
                          // Tek bir okuma ve yazdırmayla çözersin burayı
                          File readForTemp = new File("WaitList.txt");
                          Scanner readerForTemp = new Scanner(readForTemp);

                          FileWriter writerForTemp = new FileWriter("Temporary.txt",false);
                          int waitListCounter = 0;
                          while (readerForTemp.hasNextLine()){
                              String waitData = readerForTemp.nextLine();
                              if (waitData.equals("--------------------------------")) {
                                  continue;
                              }
                              waitListCounter++;
                              writerForTemp.write(waitData);
                          }
                          readerForTemp.close();
                          writerForTemp.close();

                          if (waitListCounter == 0) {
                              FileWriter reloadTemp = new FileWriter("Temporary.txt",false);
                              reloadTemp.close();
                              System.out.println("--------------------------------");
                              System.out.println("!!! Wait List is empty !!!");
                              System.out.println("- The operation could not be performed -");
                              System.out.println("--------------------------------");
                              continue;
                          }



                          FileWriter clearWaitList = new FileWriter("WaitList.txt",false);
                          clearWaitList.close();

                          File readTemp = new File("Temporary.txt");
                          Scanner readerTemp = new Scanner(readTemp);

                          FileWriter writeToConsumerList = new FileWriter("ConsumerList.txt",true);

                          boolean ok = false;
                          while (readerTemp.hasNextLine()){
                              String consumerData = readerTemp.nextLine();

                              writeToConsumerList.write(consumerData + "\n");
                              writeToConsumerList.write("--------------------------------\n");
                              ok = true;
                          }
                          readerTemp.close();
                          writeToConsumerList.close();

                          if (ok) {
                              System.out.println("*** Applications accepted ***");
                              applyWaitListLoop = false;
                              continue;
                          }

                          System.out.println("!!! An error occurred !!! ");

                            break;

                      case "3":
                          break;
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
