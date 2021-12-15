import javax.imageio.IIOException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.annotation.Target;

public class yazi1 {

    public static void main(String[] args) {

        try {
            FileWriter myWriter = new FileWriter("Writing.txt",true);

            myWriter.close();
        }catch (IOException err){
            System.out.println("An error occurred");
            err.printStackTrace();
        }
    }
}
