public class rgnInfo {
	public int region;
	public int total_visitors;
	public visitorType vtype[];
	
	public rgnInfo() {
		region = 0;
		total_visitors = 0;
		vtype = new visitorType[]{new visitorType(1), new visitorType(0)};
	}

	public static void fillArray(rgnInfo[] array, int size){
		for(int i = 0; i <= size; i++){
			array[i] = new rgnInfo();
		}
	}

	public int getTotal_visitors() {
		return total_visitors;
	}
}
