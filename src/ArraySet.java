import java.util.Arrays;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

public class ArraySet {

	private ElementType[] theElements;
	private int numElements;

	/*
	 * ArraySet(int n)
	 * Create and initially empty set with initial capacity
	 */

	public ArraySet(int n){
		numElements = 0;
		theElements = new ElementType [n];
	}

	/*
	 * 
	 */

	public ArraySet(ElementType []numbers, int n){
		numElements = n;
		theElements = new ElementType[n*2];

		for (int i = 0; i < n; i++) {
			theElements[i]=numbers[i];
		}
	}

	/*
	 * isEmpty()
	 * Returns true if the target set has no element
	 */

	public boolean isEmpty(){
		return numElements==0;
	}

	public int cardinality(){
		return numElements;
	}

	public ElementType max(){
		if(!this.isEmpty()){
			ElementType m = theElements[0];
			for (int i = 1; i < numElements; i++) {
				if(theElements[i].greaterThan(m)){
					m=theElements[i];
				}
			}return m;
		}
		else{
			throw new RuntimeException("Attempted to find max of empty set");
		}
	}

	public ElementType min(){
		if(!this.isEmpty()){
			ElementType m = theElements[0];
			for (int i = 1; i < numElements; i++) {
				if(m.greaterThan(theElements[i])){
					m=theElements[i];
				}
			}
			return m;
		}
		else{
			throw new RuntimeException("Attempted to find max of empty set");
		}
	}

	public long sum(){
		long m = 0;
		for (int i = 0; i < numElements; i++) {
			m += theElements[i].valueOf();
		}
		return m;
	}

	public long product(){
		long m = 1;
		for (int i = 0; i < numElements; i++) {
			m*=theElements[i].valueOf();
		}
		return m;
	}

	public boolean isMember(ElementType key){
		for (int i = 0; i < numElements; i++) {
			if(theElements[i].equals(key)){
				return true;
			}
		}
		return false;
	}

	public void addMember(ElementType key){
		if(!isMember(key)){
			if(theElements.length <= numElements){
				theElements = Arrays.copyOf(theElements, numElements*2);
			}
			theElements[numElements] = key;
			numElements++;
		}
	}
	
	public void deleteMember(ElementType key){
		if(isMember(key)){
			for(int i = 0; i < numElements; i++){
				if(theElements[i].equals(key)){
					theElements[i]=theElements[numElements-1];
					numElements--;
					return;
				}
			}
		}
	}
	
	public ArraySet union(ArraySet s){
		int resultSize = 2*Math.max(this.cardinality()+s.cardinality(), 10);
		ArraySet result = new ArraySet(resultSize);
		for(int i=0; i<this.cardinality(); i++){
			result.addMember(this.theElements[i]);
		}
		for(int i=0; i<s.cardinality(); i++){
			result.addMember(s.theElements[i]);
		}
		return result;
	}
	
	public ArraySet intersection(ArraySet s){
		int resultSize = 2*Math.max(this.cardinality(), s.cardinality());
		ArraySet result = new ArraySet(resultSize);
		for(int i=0; i<this.cardinality(); i++){
			if(s.isMember(this.theElements[i])){
				result.addMember(this.theElements[i]);
			}
		}
		return result;
	}
}
