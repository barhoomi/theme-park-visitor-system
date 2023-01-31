import java.io.*;

public class ThemeParkADT {
	private rgnInfo regionArray[];
	private rgnInfo rgnSortedArray[];
	private int r;
	private LinkedList<visitorInfo> visitors;
	private LinkedList<visitorInfo> vips;

	public static void readFileAndAnalyse(String f) throws IOException, ClassNotFoundException {
		LinkedList<visitorInfo> vips = new LinkedList<visitorInfo>();
		LinkedList<visitorInfo> visitors = new LinkedList<visitorInfo>();

		File inF = new File(f);
		FileReader FR = new FileReader(inF);
		BufferedReader BFR = new BufferedReader(FR);

		try {
			String currentLine = "";
			while (true) {
				currentLine = BFR.readLine();
				String[] info = currentLine.split(",");
				visitorInfo visitor = new visitorInfo(info);
				System.out.println(visitor);
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
