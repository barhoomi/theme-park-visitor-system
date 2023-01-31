import java.io.*;

public class testing {
    public static void main(String[] args) {
        try{
            ThemeParkADT.readFileAndAnalyse("./src/testInput.txt");
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
