import java.io.*;

public class testing {
    public static void main(String[] args) {
        try{
            ThemeParkADT themeParkADT = new ThemeParkADT();
            themeParkADT.readFileAndAnalyse("./src/testInput.txt");

            for(int i = 0; i < themeParkADT.regionArray.length; i++){

                themeParkADT.regionArray[i].vtype[0].visitList.findfirst();
                themeParkADT.regionArray[i].vtype[1].visitList.findfirst();

                System.out.println(themeParkADT.regionArray[i].vtype[0].visitList.retrieve());
                System.out.println(themeParkADT.regionArray[i].vtype[1].visitList.retrieve());
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
