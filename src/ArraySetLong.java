import java.util.Arrays;

public class ArraySetLong {

	private long[] theElements;
	private int numElements;

	/*
	 * ArraySetLong(int n)
	 * Create and initially empty set with initial capacity
	 */

	public ArraySetLong(int n){
		numElements = 0;
		theElements = new long [n];
	}

	/*
	 * 
	 */

	public ArraySetLong(long []numbers, int n){
		numElements = n;
		theElements = new long[n*2];

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

	public long max(){
		if(!this.isEmpty()){
			long m = theElements[0];
			for (int i = 1; i < numElements; i++) {
				if(theElements[i]>m){
					m=theElements[i];
				}
			}return m;
		}
		else{
			throw new RuntimeException("Attempted to find max of empty set");
		}
	}

	public long min(){
		if(!this.isEmpty()){
			long m = theElements[0];
			for (int i = 1; i < numElements; i++) {
				if(theElements[i]<m){
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
			m+=theElements[i];
		}
		return m;
	}

	public long product(){
		long m = 1;
		for (int i = 0; i < numElements; i++) {
			m*=theElements[i];
		}
		return m;
	}

	public boolean isMember(long key){
		for (int i = 0; i < numElements; i++) {
			if(theElements[i]==key){
				return true;
			}
		}
		return false;
	}

	public void addMember(long key){
		if(!isMember(key)){
			if(theElements.length <= numElements){
				theElements = Arrays.copyOf(theElements, numElements*2);
			}
			theElements[numElements] = key;
			numElements++;
		}
	}

	public void deleteMember(long key){
		if(isMember(key)){
			for(int i = 0; i < numElements; i++){
				if(theElements[i]==key){
					theElements[i]=theElements[numElements-1];
					numElements--;
					return;
				}
			}
		}
	}

	public ArraySetLong union(ArraySetLong s){
		int resultSize = 2*Math.max(this.cardinality()+s.cardinality(), 10);
		ArraySetLong result = new ArraySetLong(resultSize);
		for(int i=0; i<this.cardinality(); i++){
			result.addMember(this.theElements[i]);
		}
		for(int i=0; i<s.cardinality(); i++){
			result.addMember(s.theElements[i]);
		}
		return result;
	}

	public ArraySetLong intersection(ArraySetLong s){
		int resultSize = 2*Math.max(this.cardinality(), s.cardinality());
		ArraySetLong result = new ArraySetLong(resultSize);
		for(int i=0; i<this.cardinality(); i++){
			if(s.isMember(this.theElements[i])){
				result.addMember(this.theElements[i]);
			}
		}
		return result;
	}
}
