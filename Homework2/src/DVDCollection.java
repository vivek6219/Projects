import java.io.*;
import java.util.Arrays;

import javax.annotation.processing.Filer;

public class DVDCollection {

	// Data fields
	
	/** The current number of DVDs in the array */
	private int numdvds;
	
	/** The array to contain the DVDs */
	private DVD[] dvdArray;
	
	/** The name of the data file that contains dvd data */
	private String sourceName;
	
	/** Boolean flag to indicate whether the DVD collection was
	    modified since it was last saved. */
	private boolean modified;
	
	/**
	 *  Constructs an empty directory as an array
	 *  with an initial capacity of 7. When we try to
	 *  insert into a full array, we will double the size of
	 *  the array first.
	 */
	public DVDCollection() {
		numdvds = 0;
		dvdArray = new DVD[7];
	}
	
	public String toString() {
		// Return a string containing all the DVDs in the
		// order they are stored in the array along with
		// the values for numdvds and the length of the array.
		// See homework instructions for proper format.
		System.out.println("Num of DVDS:" + numdvds);
		for(int i =0; i<dvdArray.length; i++)
		{
			System.out.println(dvdArray[i] );
		}
		
		return "end of DVD's";
		



		// STUB: Remove this line.
	}

	public void addOrModifyDVD(String title, String rating, String runningTime) {
		// NOTE: Be careful. Running time is a string here
		// since the user might enter non-digits when prompted.
		// If the array is full and a new DVD needs to be added,
		// double the size of the array first.
		if(dvdArray.length== numdvds)
			dvdArray= Arrays.copyOf(dvdArray, numdvds*2); //built in method to increase array size. 
		for(int i =0; i<dvdArray.length; i++)
		{
			if(dvdArray[i]== null) {
				numdvds++;
				dvdArray[i] = new DVD(title, rating, Integer.parseInt(runningTime));
			}
		}
	}
	
	public void removeDVD(String title) 
	{		
		for(int i=0; i<dvdArray.length; i++)
		{
			if(dvdArray[i].getTitle().equals(title))
			{
				dvdArray[i]= null;
				numdvds--;
			}
		}

	}
	
	public String getDVDsByRating(String rating) {
		int counter =0;
		String dvdsTitles="";
		while(true)
		{
		counter++;
		if(counter>dvdArray.length)
			break;
			if(dvdArray[counter].getRating().equals(rating))
				dvdsTitles=dvdsTitles+dvdArray[counter].getTitle();
			
		}
		if(dvdsTitles.equals(""))
			return "No dvds with this rating:"+rating;	// STUB: Remove this line.
		else 
			return dvdsTitles;

	}

	public int getTotalRunningTime() {

		int totalTime =0;
		for(int i =0; i<dvdArray.length; i++)
			totalTime+=dvdArray[i].getRunningTime();
	return totalTime;
	}

	
	public void loadData(String filename) throws IOException {
		FileReader fr = new FileReader("C:\\Users\\vivek\\OneDrive\\Desktop\\main\\Uni\\CSUEB\\Fall19\\Software Engineering\\Homework2\\src\\dvddata.txt");
		int i =0;
		while((i=fr.read())!=-1)
			System.out.print((char) i);

		
	}
	
	public void save() throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter("myDVD.txt"));
		bw.write(dvdArray.toString());
		bw.close();
	}

	// Additional private helper methods go here:



	
}
