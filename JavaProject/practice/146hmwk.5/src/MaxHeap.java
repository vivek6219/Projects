import java.util.ArrayList;
import java.util.Collection;

public class MaxHeap
{
   private ArrayList<Student> students;
   
   public MaxHeap(int capacity)
   {
      students = new ArrayList<Student>(capacity);
   }
      
   public MaxHeap(Collection<Student> collection)
   {
      students = new ArrayList<Student>(collection);
      for(int i = size()/2; i >= 0; i--)
      {
         maxHeapify(i);
      }
   }
   
   public Student getMax()
   {
      if(size() < 1)
      {
         throw new IndexOutOfBoundsException("No maximum value:  the heap is empty.");
      }
      return students.get(0);
   }
   
   public Student extractMax()
   {
      Student value = getMax();
      students.set(0,students.get(size()-1));
      students.remove(size()-1);
      maxHeapify(0);
      return value;
   }
   
   
   public void insert(Student elt)
   {
	   students.add(elt);
       int current = students.indexOf(elt);
       int parent = parent(current);
       
      while(elt.compareTo(students.get(parent))>0)
      {
    	  swap(current, parent);
    	  current=parent;
    	  parent=parent(parent);
    	  
      }
    	  
   }
   
   public void changeKey(Student s, double newGPA)
   {
	   int current;
	   double oldGPA;
      if(students.contains(s))
      {
    	  current = students.indexOf(s);
    	   oldGPA = s.gpa();
    	  s.setGPA(newGPA);
    	  if(newGPA>oldGPA)
    		  maxHeapify(parent(current) );
    	  else
    		  maxHeapify(current);
      }
   }

   private int parent(int index)
   {
      return (index - 1)/2;
   }
   
   private int left(int index)
   {
      return 2 * index + 1;
   }
   
   private int right(int index)
   {
      return 2 * index + 2;
   }
   
   private int size()
   {
      return students.size();
   }
   
   private void swap(int from, int to)
   {
      Student val = students.get(from);
      students.set(from,  students.get(to));
      students.set(to,  val);
   }
   
   private void maxHeapify(int index)
   {
      int left = left(index);
      int right = right(index);
      int largest = index;
      if (left <  size() && students.get(left).compareTo(students.get(largest)) > 0)
      {
         largest = left;
      }
      if (right <  size() && students.get(right).compareTo(students.get(largest)) > 0)
      {
         largest = right;
      }
      if (largest != index)
      {
         swap(index, largest);
         maxHeapify(largest);
      }  
   }   
}