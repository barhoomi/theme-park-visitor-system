public class testing {
    public static void main(String[] args) throws Exception{
        ThemeParkADT themeParkADT = new ThemeParkADT();
        themeParkADT.readFileAndAnalyse("./src/testInput.txt");

        //testRegionSortedArray(themeParkADT);

        //Operation 1
        //themeParkADT.searchVisitor("AlAli");
        //themeParkADT.searchVisitor("AlSaleh");
        //themeParkADT.searchVisitor("Salem");
        //themeParkADT.searchVisitor("Al");

        //Operation 2
        //themeParkADT.rgnCount();

        //Operation 3
        //themeParkADT.popularRgn();

        //Operation 4
        //themeParkADT.vipRgn(1);
        //themeParkADT.vipRgn(2);
        //themeParkADT.vipRgn(3);
        //themeParkADT.vipRgn(4);
        //themeParkADT.vipRgn(5);
        //themeParkADT.vipRgn(6);

        //Operation 5
        //themeParkADT.vipLocation();

        //Operation 6
        //System.out.println(themeParkADT.checkVipLoc("0505000000","0504000000"));  //false
        //System.out.println(themeParkADT.checkVipLoc("0555555555","0544444444"));//true
        //System.out.println(themeParkADT.checkVipLoc("0533333333","0500000000")); //n1 is not vip

        //Operation 7
        //System.out.println(themeParkADT.checkRegLoc(1, "0555555555","0544444444"));
        //System.out.println(themeParkADT.checkRegLoc(2, "0533333333","0500000000"));
        //System.out.println(themeParkADT.checkRegLoc(1, "0511111111","0512211122"));
    }
}
