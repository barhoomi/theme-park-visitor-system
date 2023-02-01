import java.io.*;

public class testing {
    public static void main(String[] args) {
        try{
            ThemeParkADT themeParkADT = new ThemeParkADT();
            themeParkADT.readFileAndAnalyse("./src/testInput.txt");
            int visitorCounter = 0;

            for(int i = 0; i < themeParkADT.regionArray.length; i++){

                System.out.println("========REGION: "+i+"=============");

                LinkedList<visitorInfo> vipList = themeParkADT.regionArray[i].vtype[0].visitList;
                LinkedList<visitorInfo> regList = themeParkADT.regionArray[i].vtype[1].visitList;

                vipList.printVisitors();
                regList.printVisitors();
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
