import java.io.*;

public class testing {
    public static void main(String[] args) {
        try{
            ThemeParkADT themeParkADT = new ThemeParkADT();
            themeParkADT.readFileAndAnalyse("./src/testInput.txt");
            System.out.println(themeParkADT.regionArray[0].vtype[0].visitList.retrieve());

        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
