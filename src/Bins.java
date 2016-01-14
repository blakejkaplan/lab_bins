import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Runs a number of algorithms that try to fit files onto disks.
 */
public class Bins {
    public static final String DATA_FILE = "example.txt";

    /**
     * Reads list of integer data from the given input.
     *
     * @param input tied to an input source that contains space separated numbers
     * @return list of the numbers in the order they were read
     */
    public List<Integer> readData (Scanner input) {
        List<Integer> results = new ArrayList<Integer>();
        while (input.hasNext()) {
            results.add(input.nextInt());
        }
        return results;
    }
    
    /**
     * Populates the priority queue
     * @param data
     * The list of file sizes
     * @param pq
     * The priority queue used to process the files
     * @param total
     * Total size of all the files
     * @param type
     * Dictates whether or not the files are sorted by size from high to low
     * @return
     * The total size of all the files
     */
    private static int addToDisk(List<Integer> data, PriorityQueue<Disk> pq, Integer total, String type){
    	int diskId = 1;
        
        for (Integer size : data) {
            Disk d = pq.peek();
            if (d.freeSpace() < size) {
            	Disk d2 = new Disk(diskId);
                diskId++;
                d2.add(size);
                pq.add(d2);
            } else if ((type.equals("first") && d.freeSpace() > size) || 
            		(type.equals("second"))) {
            	pq.poll();
                d.add(size);
                pq.add(d);
            }
            total += size;
        }
        return total;
    }
    
    /**
     * Prints out the results of the algorithm
     * @param type
     * Dictates whether or not the input data is sorted
     * @param total
     * The total size of all the files
     * @param pq
     * The populated priority queue
     */
	private static void printInfo(String type, int total, PriorityQueue<Disk> pq) {

		if (type.equals("unsorted")) {
			System.out.println("total size = " + total / 1000000.0 + "GB");
		}

		System.out.println();
		
		if (type.equals("unsorted")) {
			System.out.println("worst-fit method");
		}
		
		else if (type.equals("decreasing")) {
			System.out.println("worst-fit decreasing method");
		}
		System.out.println("number of pq used: " + pq.size());
		while (!pq.isEmpty()) {
			System.out.println(pq.poll());
		}
		System.out.println();

	}
    
	/**
	 * The initial setup and helper function calls
	 */
    private static void start(){
    	Bins b = new Bins();
        Scanner input = new Scanner(Bins.class.getClassLoader().getResourceAsStream(DATA_FILE));
        List<Integer> data = b.readData(input);

        PriorityQueue<Disk> pq = new PriorityQueue<Disk>();
        pq.add(new Disk(0));
        
    	int total1 = addToDisk(data, pq, 0, "first");
    	printInfo("unsorted", total1, pq);
    	
    	Collections.sort(data, Collections.reverseOrder());
    	pq.add(new Disk(0));
    	int total2 = addToDisk(data, pq, 0, "second");
    	printInfo("decreasing", total2, pq);
    }

    /**
     * The main program.
     */
    public static void main (String args[]) {
        start();
    }
}
