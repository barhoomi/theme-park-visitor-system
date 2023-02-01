import java.io.*;

public class testing {
    public static void main(String[] args) {
        try{
            ThemeParkADT themeParkADT = new ThemeParkADT();
            themeParkADT.readFileAndAnalyse("./src/testInput.txt");

            for(int i = 0; i < themeParkADT.regionArray.length; i++){

                LinkedList reg = themeParkADT.regionArray[i].vtype[0].visitList;
                LinkedList vip = themeParkADT.regionArray[i].vtype[1].visitList;

                System.out.println(reg);
                System.out.println(vip);
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
