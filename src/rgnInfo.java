
public class rgnInfo {
	private int region;
	private int total_visitors;
	private visitorType vtype[];
	
	public rgnInfo(int r, int t, visitorType [] vt) {
		region = r;
		total_visitors = t;
		vtype = vt;
	}
}
