public class rgnInfo {
	public int region;
	public int total_visitors;
	public visitorType vtype[];
	
	public rgnInfo() {
		region = 0;
		total_visitors = 0;
		vtype = new visitorType[]{new visitorType(1), new visitorType(0)};
	}

	public static rgnInfo[] createEmptyArray(int size){
		rgnInfo[] array = new rgnInfo[size];
		for(int i = 0; i < size; i++){
			array[i] = new rgnInfo();
		}
		return array;
	}
}
