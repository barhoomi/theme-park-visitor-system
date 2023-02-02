public class testing {
    public static void main(String[] args) throws Exception{
        ThemeParkADT themeParkADT = new ThemeParkADT();
        themeParkADT.readFileAndAnalyse("./src/testInput.txt");

        //testRegionSortedArray(themeParkADT);
        testSearchName(themeParkADT, "AlAli");

        //themeParkADT.rgnCount();

        //boolean b = themeParkADT.checkRegLoc(1, "0555555555","0544444444");
        //System.out.println(b);
    }

    public static void testArray(rgnInfoArray rgnInfoArray) {
        for (int i = 0; i < rgnInfoArray.data.length; i++) {

            System.out.println("========REGION " + i + "=============");

            LinkedList<visitorInfo> vipList = rgnInfoArray.data[i].vtype[0].visitList;
            LinkedList<visitorInfo> regList = rgnInfoArray.data[i].vtype[1].visitList;

            vipList.printVisitors();
            regList.printVisitors();
        }
    }

    public static void testSearchName(ThemeParkADT themeParkADT, String lName) {
        themeParkADT.searchVisitor(lName);
    }
}
