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

   public void searchVISITOR(String lNamee) {
    	int c=0;
    	visitors.findfirst();
	   while(!visitors.last()) {
    		visitorInfo temp = visitors.retrieve();
    		if(temp.lName.equalsIgnoreCase(lNamee))
    			printVisData(++c, temp);
    		visitors.findnext();
    	}
    }
    
    private void printVisData(int n,visitorInfo v) {
    	System.out.println("Visitor "+n+":");
    	System.out.println("Name: "+v.fName+v.lName);
    	System.out.println("Rwgion: "+v.region);
    	String s;
    	if(v.type==1)
    		s="Yes";
    	else
    		s="No";
    	System.out.println("VIP Pass holder: "+s);
    	System.out.println("Phone number: "+v.phone);
    	
    	System.out.print("Order of visiting the kingdoms: ");
    	printStack(v.order);
    		
    }
    
    private void printStack (ArrayStack<Integer> st) {
    	if (st.empty ())
    		return ;
    	Integer top = st.pop () ;
    	System.out.println(top);
    	printStack (st);
    	st.push (top);
    	return ;
    }


    public void rgnCount() {
    	System.out.println("The total number of regions are "+r);
    }
    
    public void popularRgn() {
    	for(int i =0;i<rgnSortedArray.length;i++) {
    		System.out.println("Region "+rgnSortedArray[i].region+": "+rgnSortedArray[i].total_visitors);
    	}
    }

    public void vipRgn(int r) {
    	for(int i =0;i<regionArray.length;i++) {
    		if(regionArray[i].region==r)
    			System.out.println("The total number of VIP pass holders coming from Region "+r+" is "+regionArray[i].vtype[0].num_visitors);
    	}
    }

    public void vipLication() {
    	while(!vips.last()) {
    		vips.findfirst();
    		visitorInfo temp = vips.retrieve();
    		Integer x = temp.order.pop();
    		System.out.println(temp.fName+" "+temp.lName+" in Kingdom "+x);
    		temp.order.push(x);
    		vips.findnext();
    	}
    }
    
    public boolean checkVipLoc(String n1,String n2, boolean flag) {
    	return false;
    }

    public boolean checkRegLoc(int r, String n1, String n2, boolean flag) {
        return false;
    }
	
}
