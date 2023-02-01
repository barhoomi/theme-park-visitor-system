public class testing {
    public static void main(String[] args) {
        try{
            ThemeParkADT themeParkADT = new ThemeParkADT();
            themeParkADT.readFileAndAnalyse("./src/testInput.txt");

            //testRegionSortedArray(themeParkADT);

        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    public static void testArray(rgnInfoArray rgnInfoArray){
        for(int i = 0; i < rgnInfoArray.data.length; i++){

            System.out.println("========REGION "+i+"=============");

            LinkedList<visitorInfo> vipList = rgnInfoArray.data[i].vtype[0].visitList;
            LinkedList<visitorInfo> regList = rgnInfoArray.data[i].vtype[1].visitList;

            vipList.printVisitors();
            regList.printVisitors();
        }
    }

    public static void testRegionSortedArray(){
        testArray()
    }
}
