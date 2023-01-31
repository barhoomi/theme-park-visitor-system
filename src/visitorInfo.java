
public class visitorInfo {
	public String fName,lName,phone;
	public int region,type;
	public ArrayStack<Integer>order;
	
	visitorInfo(String fName, String inam,int region ,String phone , int type, int x) {
		this.fName = fName;
		lName = inam;
		this.phone = phone;
		this.region = region;
		this.type = type;
		order = new ArrayStack(1);
		Integer a = x;
		order.push(a);
	}
	visitorInfo(String fName, String inam,int region ,String phone , int type, int x,int y) {
		this.fName = fName;
		lName = inam;
		this.phone = phone;
		this.region = region;
		this.type = type;
		order = new ArrayStack(2);
		Integer a=x ,b=y; 
		order.push(a);
		order.push(b);
	}
	visitorInfo(String fName, String lnam,int region ,String phone , int type, int x,int y,int z) {
		this.fName = fName;
		lName = lnam;
		this.phone = phone;
		this.region = region;
		this.type = type;
		order = new ArrayStack(3);
		Integer a=x ,b=y,c=z; 
		order.push(a);
		order.push(b);
		order.push(c);
	}
	visitorInfo(String fName, String inam,int region ,String phone , int type, int x,int y,int z,int w) {
		this.fName = fName;
		lName = inam;
		this.phone = phone;
		this.region = region;
		this.type = type;
		order = new ArrayStack(4);
		Integer a=x ,b=y,c=z,d=w; 
		order.push(a);
		order.push(b);
		order.push(c);
		order.push(d);
	}
	
	 
	
}
