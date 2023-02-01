
public class visitorType {
	public int type;
	public int num_visitors;
	public LinkedList<visitorInfo> visitList;


	public visitorType(int type){
		this.type = type;
		num_visitors = 0;
		visitList = new LinkedList();
	}
  
}
