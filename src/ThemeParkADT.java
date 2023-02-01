import java.io.*;

public class ThemeParkADT {
    public rgnInfoArray regionArray;
    public rgnInfoArray rgnSortedArray;
    public int r;
    public LinkedList<visitorInfo> visitors;
    public LinkedList<visitorInfo> vips;

    public void readFileAndAnalyse(String f) throws IOException, ClassNotFoundException {
        //r = number of regions
        r = 0;

        //k = max region
        int k = readFile(f);

        regionArray = new rgnInfoArray(k);
        r = insertRegions(visitors, regionArray.data);

        rgnSortedArray = new rgnInfoArray(r);
        r = insertRegions(visitors, rgnSortedArray.data);

        sortRegions(rgnSortedArray.data, r);
    }

    public int readFile(String f) throws IOException, ClassNotFoundException{
        int maxRegion = 0;

        vips = new LinkedList();
        visitors = new LinkedList();

        File inF = new File(f);
        FileReader FR = new FileReader(inF);
        BufferedReader BFR = new BufferedReader(FR);

        String currentLine = "";

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
        return maxRegion;
    }

    private void sortRegions(rgnInfo[] arr, int n) {
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j].getTotal_visitors() < arr[j + 1].getTotal_visitors()) {
                    rgnInfo temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    private int insertRegions(LinkedList<visitorInfo> visitors, rgnInfo[] array) {
        r = 0;
        visitors.findfirst();
        visitorInfo visitor = visitors.retrieve();

        while (visitor != null) {
            boolean addedRegion = false;
            for (int i = 0; i < r; i++) {
                if (array[i].region == visitor.region) {

                    array[i].total_visitors++;
                    addedRegion = true;

                    LinkedList vipList = array[i].vtype[0].visitList;
                    LinkedList regularList = array[i].vtype[1].visitList;

                    if (visitor.type == 1) {
                        vipList.insert(visitor);
                    } else {
                        regularList.insert(visitor);
                    }

                }
            }
            if (r < array.length && !addedRegion) {

                array[r].region = visitor.region;
                array[r].total_visitors++;

                LinkedList vipList = array[r].vtype[0].visitList;
                LinkedList regularList = array[r].vtype[1].visitList;

                //
                if (visitor.type == 1) {
                    vipList.insert(visitor);
                } else {
                    regularList.insert(visitor);
                }

                r++;
            }

            visitors.findnext();
            visitor = visitors.retrieve();
        }
        return r;
    }

    public void searchVisitor(String lName) {
        int n = 1;

        visitors.findfirst();
        visitorInfo visitor = visitors.retrieve();

        while (visitor != null) {

            if (visitor.lName.equalsIgnoreCase(lName)) {
                printVisitorData(n++, visitor);
            }

            visitors.findnext();
            visitor = visitors.retrieve();
        }

        if(n==1){
            System.out.println("No visitors with the last name '"+lName+"' found");
        }
    }

    private void printVisitorData(int n, visitorInfo v) {
        System.out.println("Visitor " + n + ":");
        System.out.println("Name: " + v.fName + " " + v.lName);
        System.out.println("Region: " + v.region);
        System.out.println("VIP Pass holder: " + (v.type == 1? "Yes" : "No"));
        System.out.println("Phone number: " + v.phone);

        System.out.print("Order of visiting the kingdoms: ");
        printStack(v.order);

    }

    private void printStack(ArrayStack<Integer> st) {
        if (st.empty()) return;

        Integer top = st.pop();
        System.out.println(top);

        printStack(st);
        st.push(top);
    }


    public void rgnCount() {
        System.out.println("The total number of regions are " + r);
    }

    public void popularRgn() {
        for (int i = 0; i < rgnSortedArray.data.length; i++) {
            System.out.println("Region " + rgnSortedArray.data[i].region + ": " + rgnSortedArray.data[i].total_visitors);
        }
    }

    public void vipRgn(int r) {
        for (int i = 0; i < regionArray.data.length; i++) {
            if (regionArray.data[i].region == r)
                System.out.println("The total number of VIP pass holders coming from Region " + r + " is " + regionArray.data[i].vtype[0].num_visitors);
        }
    }

    public void vipLocation() {
        vips.findfirst();
        visitorInfo visitor = vips.retrieve();
        while (visitor != null) {

            Integer kingdom = visitor.order.pop();
            System.out.println(visitor.fName + " " + visitor.lName + " in Kingdom " + kingdom);
            visitor.order.push(kingdom);

            vips.findnext();
            visitor = vips.retrieve();
        }
    }

    public boolean checkVipLoc(String n1, String n2, boolean flag) {
        visitorInfo v1 = null, v2 = null;
        vips.findfirst();
        while (!vips.last() && (v1 == null || v2 == null)) {
            visitorInfo v = vips.retrieve();
            if (v.phone.equals(n1))
                v1 = v;
            else if (v.phone.equals(n2))
                v2 = v;
            vips.findnext();
        }
        if (v1 == null || v2 == null) {
            if (v1 == null)
                System.out.println("There is no visitor with number: " + n1 + ".");
            if (v2 == null)
                System.out.println("There is no visitor with number: " + n2 + ".");
            flag = false;
        } else if (v1.region != v2.region) {
            System.out.println("Not in the same region.");
            flag = false;
        } else
            flag = true;
        return flag;
    }

  public boolean checkRegLoc(int r, String n1, String n2, boolean flag) {
    	visitorInfo v1 = null, v2 = null;
        visitors.findfirst();
        while (!visitors.last() && (v1 == null || v2 == null)) {
            visitorInfo v = visitors.retrieve();
            if (v.phone.equals(n1))
                v1 = v;
            else if (v.phone.equals(n2))
                v2 = v;
            visitors.findnext();
           
        }
        if (v1 == null || v2 == null)
        	return flag=false;
        if (v1.order.empty())
            return true;
        Integer top1 = v1.order.pop();
        Integer top2 = v2.order.pop();
        v1.order.push(top1);
        v2.order.push(top2);
        if(top1 != top2)
        flag=false;
        else checkRegLoc(r, n1, n2, flag);
        
        
        
    }

}
