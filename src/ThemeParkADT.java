import java.io.*;

public class ThemeParkADT {
    public rgnInfo[] regionArray;
    public rgnInfo[] rgnSortedArray;
    private int r;
    private LinkedList<visitorInfo> visitors;
    private LinkedList<visitorInfo> vips;

    public void readFileAndAnalyse(String f) throws IOException, ClassNotFoundException {
        vips = new LinkedList();
        visitors = new LinkedList();

        //r = number of regions
        r = 0;

        File inF = new File(f);
        FileReader FR = new FileReader(inF);
        BufferedReader BFR = new BufferedReader(FR);

        String currentLine = "";
        int maxRegion = 1;

        try {
            while (true) {
                currentLine = BFR.readLine();

                String[] info = currentLine.split(",");
                visitorInfo visitor = new visitorInfo(info);

                visitors.insert(visitor);
                if (visitor.type == 1) vips.insert(visitor);
                if (visitor.region > maxRegion) maxRegion = visitor.region;
            }

        } catch (Exception e) {
            System.out.println("end of file reached");
        }
        BFR.close();
        FR.close();


        int k = maxRegion;
        regionArray = new rgnInfo[k];
        rgnInfo.fillArray(regionArray,k);

        r = insertRegions(visitors, regionArray);

        rgnSortedArray = new rgnInfo[r];
        rgnInfo.fillArray(rgnSortedArray,r);

        r = insertRegions(visitors, rgnSortedArray);

        sortRegions(rgnSortedArray,r);
    }

    public void sortRegions(rgnInfo[] arr, int n){
        for(int i = 0; i<n-1; i++){
            for(int j = 0; j<n-1-i; j++){
                if(arr[j].getTotal_visitors() < arr[j+1].getTotal_visitors()){
                    rgnInfo temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    private int insertRegions(LinkedList<visitorInfo> visitors, rgnInfo[] array){
        r = 0;
        visitors.findfirst();
        visitorInfo temp;
        boolean last = false;
        while (!last) {
            temp = visitors.retrieve();
            for (int i = 0; i < r; i++) {
                if (array[i].region == temp.region) {
                    array[i].total_visitors++;
                    if (temp.type == 1) {
                        array[i].vtype[0].visitList.insert(temp);
                    } else
                        array[i].vtype[1].visitList.insert(temp);
                }
            }
            if(!(r == array.length)){
                array[r].region = temp.region;
                array[r].total_visitors++;
                if (temp.type == 1) {
                    array[r].vtype[0].visitList.insert(temp);
                } else
                    array[r].vtype[1].visitList.insert(temp);
                r++;
            }
            if (visitors.last()) last = true;
            else {
                visitors.findnext();
            }
        }
        return r;
    }

    public void searchVISITOR(String lName) {

    }

    public void popularRgn() {

    }

    public void vipRgn(int i) {

    }

    public void vipLication() {

    }

    public boolean checkRegLoc(int r, String n1, String n2, boolean flag) {
        return false;
    }

}
