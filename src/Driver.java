import java.io.IOException;
import java.io.RandomAccessFile;

public class Driver{
    public static void main(String[] args) {
        try{
            RandomAccessFile file = new RandomAccessFile("file.dat","rw");
            MergeSort mergeSort = new MergeSort(file, 1024);
            int [] array = {3,7,2,1,0,9,10,11};
            mergeSort.mergeSort(array);
            for(int x:array){
                System.out.println(x);
            }
        }catch(IOException e){
            System.out.println("Driver class");
        }
    }
}
