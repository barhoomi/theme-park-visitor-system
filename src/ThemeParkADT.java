import java.io.*;

public class ThemeParkADT {
	private rgnInfo regionArray[];
	private int b;
	private rgnInfo rgnSortedArray[];
	private int r;
	private LinkedList<visitorInfo> visitors;
	private LinkedList<visitorInfo> vips;

	public static void readFileAndAnalyse(String f) throws IOException, ClassNotFoundException {
		 vips = new LinkedList(); b=0;
		 visitors = new LinkedList();

		File inF = new File(f);
		FileReader FR = new FileReader(inF);
		BufferedReader BFR = new BufferedReader(FR);

		try {
			String currentLine = "";
			while (true) {
				currentLine = BFR.readLine();
				String[] info = currentLine.split(",");
				visitorInfo visitor = new visitorInfo(info);
				visitorInfo temp = visitor;
						visitors.insert(temp);
							if(temp.type == 1)
								vips.insert(temp);
							for(int i=0 ; i<b ;i++) {
								if(regionArray[i].region==temp.region) {
									if(temp.type==1) {
										regionArray[i].vtype[0].visitList.insert(temp);}
									else 
										regionArray[i].vtype[1].visitList.insert(temp);
								}
							}
							regionArray[b].region=temp.region;
							if(temp.type==1) {
								regionArray[b].vtype[0].type=1;
								regionArray[b].vtype[0].visitList.insert(temp);}
							else {
								regionArray[b].vtype[1].type=0;
								regionArray[b].vtype[1].visitList.insert(temp);}
							b++;
			}
		}
		catch(Exception e){
			System.out.println("end of file reached");
		}

		BFR.close();
		FR.close();
	}
	
	public void searchVISITOR(String lName){
		
	}
	
	public void popularRgn() {
		
	}
	
	public void vipRgn(int i) {
		
	}
	
	public void vipLication() {
		
	}
	
	public boolean checkRegLoc(int r,String n1,String n2,boolean flag) {
		return false;
	}
	
}
