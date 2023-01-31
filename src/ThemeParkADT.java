
public class ThemeParkADT {
	public class ThemeParkADT {
	private rgnInfo regionArray[];
	private final int k = 100;
	private rgnInfo rgnSortedArray[];
	private int r;
	private LinkedList<visitorInfo> visitors;
	private LinkedList<visitorInfo> vips;

	public void readFileAndAnalyse(String f) throws IOException, ClassNotFoundException {
		regionArray = new rgnInfo[k];
		rgnSortedArray = new rgnInfo[k];
		vips = new LinkedList<visitorInfo>();
		visitors = new LinkedList<visitorInfo>();
		File inFile = new File(f);
		FileInputStream inFileStream = new FileInputStream(inFile);
		ObjectInputStream inObjectStream = new ObjectInputStream(inFileStream);
		visitorInfo v;
		while (true) {
			v = (visitorInfo) inObjectStream.readObject();
			visitors.insert(v);
			if (v.type == 0) {
				vips.insert(v);
				regionArray[v.region].vtype[0].visitList.insert(v);
			} else
				regionArray[v.region].vtype[1].visitList.insert(v);
		}
	}
	
	public void searchVISITOR(String lName){
		
	}
	
	public void popularRgn() {
		
	}
	
	public void vipRgn(int i) {
		
	}
	
	public void vipLication() {
		
	}
	
	public boolean checkRegLoc(inr r,String n1,String n2,boolean flag) {
		
	}
	
}
