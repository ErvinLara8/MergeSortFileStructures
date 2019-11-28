import java.io.IOException;
import java.io.RandomAccessFile;

public class MergeSort {
    private BufferFile source;
    private BufferFile left;
    private BufferFile right;
    private int bufferSize;
    final double e = 2.718281828;

    public MergeSort(RandomAccessFile source, int bufferSize ){
        this.source = new BufferFile(source, bufferSize, "Source");
        try{
            RandomAccessFile leftFile = new RandomAccessFile("left","rw");
            RandomAccessFile rightFile = new RandomAccessFile("right","rw");
            left = new BufferFile(leftFile, bufferSize, "Left");
            right = new BufferFile(rightFile, bufferSize, "Right");
        }catch (IOException e){
            System.out.println("Constructor of MergeSort");
        }
    }

     public void mergeSort(int[] array){
        int n = array.length;
        int totalIterations = (int)Math.ceil(Math.log(n)/ Math.log(2))+1;
        int[] temp = new int[n];
        int max = 2;
        int tempPointer = 0;
        for(int i = 1; i < totalIterations; i++){
            int j = 0;
            for(int t = 0; t < n/max; t ++){ //Changing to another group
                int leftindex = j;
                int rightIndex = j + max/2;
                for(int c = 0; c < max; c++){ //Looping trough elements of each group
                    if(leftindex>= rightIndex){
                        for(int k = rightIndex; k < j+max-1; k++){
                            temp[tempPointer] = array[k];
                            tempPointer++;
                        }
                        break;
                    }else if(rightIndex >= (j+max)){
                        for(int k = leftindex; k < rightIndex-max/2; k++){
                            temp[tempPointer] = array[k];
                            tempPointer++;
                        }
                        break;
                    }else{
                        if(array[leftindex]<=array[rightIndex]){
                            temp[tempPointer] = array[leftindex];
                            leftindex++;
                            tempPointer++;
                        }else{
                            temp[tempPointer] = array[rightIndex];
                            rightIndex++;
                            tempPointer++;
                        }
                    }
                }
                j+=max;
            }
            max = max*2;
            for(int k = 0; k<n; k++){
                array[k] = temp[k];
            }
            tempPointer = 0;
        }
     }
}
