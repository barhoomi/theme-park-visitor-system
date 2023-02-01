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
                vipList.findfirst();
                regList.findfirst();
                visitorInfo tempVip = vipList.retrieve();
                visitorInfo tempReg = regList.retrieve();


                while(tempVip != null){
                    System.out.println("--------------");
                    System.out.println("Visitor "+(++visitorCounter)+": ");
                    System.out.println("--------------");
                    tempVip.printVisitorInfo();
                    vipList.findnext();
                    tempVip = vipList.retrieve();
                }

                while(tempReg != null){
                    System.out.println("--------------");
                    System.out.println("Visitor "+(++visitorCounter)+": ");
                    System.out.println("--------------");
                    tempReg.printVisitorInfo();
                    regList.findnext();
                    tempReg = regList.retrieve();
                }
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
