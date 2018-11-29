import java.util.Arrays;

/**
 * @author Manuel I. De Aguinaga
 * SortingThread synchronizes threads and sorts it's values.
 */
public class SortingThread implements Runnable{

	/**
	 * threadNumber hold the numbers from the treads
	 */
	private int threadNumber;
	
	/**
	 * arrayOfValues array that hold the values
	 */
	private int[] arrayOfValues;
	
	/**
	 * buffer is used to use the buffer 
	 */
	private SortingBuffer buffer;
	
	/**
	 * SortingThread is a constructor that will be used in SortingThread Object
	 * @param i
	 * @param array
	 * @param buffer
	 */
	public SortingThread(int i, int[] array, SortingBuffer buffer){
		threadNumber = i;
		arrayOfValues = array;
		this.buffer = buffer;
	}
	
	/**
	 * Run first prints out unsynchronized values and then prints
	 * out synchronized values of threads.void
	 */
	public void run(){
			Arrays.sort(arrayOfValues);
			for(int k : arrayOfValues){
				System.out.printf("%d unsynchronized %d\n", threadNumber,k);
			}
			try{
				for(int c : arrayOfValues){
					buffer.waitUntilMinimum(threadNumber,c);
					System.out.printf("%d synchronized %d\n", threadNumber, c );
				}
				buffer.finished(threadNumber);
			}catch (InterruptedException e) {
					System.err.println(e);
				}	
			}
}