public class rgnInfoArray {
    rgnInfo[] data;
    public rgnInfoArray(int size){
        data = new rgnInfo[size];
        for(int i = 0; i < size; i++){
            data[i] = new rgnInfo();
        }
    }
}
