import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class writing {
    public static void main(String[] args) {


        try {

            Scanner input = new Scanner(System.in);
            boolean finish = true; // For while loop


            // For crating and appending to the file
            FileWriter myWrite = new FileWriter("Books.txt",true);


            // Loop for entering
            // Adding to the Books.txt
            while (finish) {
                System.out.println("Enter Author Name:");
                String NewAuthor = input.next();

                myWrite.write(NewAuthor); // Writing string to the file.
                myWrite.append("-");// For append space.
               // myWrite.append("\n"); // For new line.

                System.out.println("Enter The Book's Name:");
                String NewBook = input.next();
                myWrite.append(NewBook);// New Book Name.


                myWrite.append("\n");
                // Asking Admin for add a new book
                System.out.println("Do you want to add new Book(yes/no)?");
                String answer = input.next();
                if (answer.equals("no") || answer.equals("NO")) {
                    myWrite.close();
                    finish = false;

                }else if (answer.equals("yes") || answer.equals("YES")) {
                    System.out.println("--------------------------------");
                }

            }



            System.out.println("Successfully wrote to the file");
        }catch (IOException e ){

            e.printStackTrace();

        }


    }
}
