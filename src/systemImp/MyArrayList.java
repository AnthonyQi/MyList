package systemImp;

import java.util.Arrays;

public class MyArrayList {
    
    // Public final field to store the class type
    public final Class<?> elementType;
    
    // Underlying array to store the list's elements
    private Object[] elements;
    
    // Current size of the list
    private int size;
    
    public MyArrayList(Class<?> elementType) throws IllegalArgumentException {
    	if(elementType == null) {
    		throw new IllegalArgumentException("Element type cannot be null.");
    	}
    	this.elementType = elementType;
    	this.elements = new Object[10];
    	this.size = 0;
    }
    
    public void add(Object element) throws IllegalArgumentException {
    	//checks type
    	if(element != null && !elementType.isInstance(element)) {
            throw new IllegalArgumentException("Invalid element type.");
    	}
    	//checks if the current size is equal to the array length 
    	if(size == elements.length) {
    		int newCap = elements.length * 2;
            elements = Arrays.copyOf(elements, newCap);
    	}
    	//increases size after adding the element
    	elements[size++] = element;
    }
    
    public Object get(int index) throws IndexOutOfBoundsException {
    	//checks if larger than size and less than 0
    	if(index >= size || index < 0) {
    		throw new IndexOutOfBoundsException("Index out of bounds.");
    	}
    	//returns element at certain index
    	return elements[index];
    }
    
    public void remove(int index) throws IndexOutOfBoundsException {
    	//checks if larger than size, and less than 0
        if(index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index out of bounds.");
        }
        //sets to null
        elements[index] = null;
        //creates new temp array to move all elements down one index
        Object[] temp = new Object[this.elements.length];
        int ind = 0; 
        for(int i = 0; i < elements.length; i++ ) {
        	if(this.elements[i] != null) {
        		temp[ind] = this.elements[i];
        		ind++;
        	}
        }
        //sets temp to elements array
        this.elements = temp;
        //subtracts from size
        size--;
    }

    public void remove(Object element) throws IllegalArgumentException {
    	//checks for same instance
        if(element != null && !elementType.isInstance(element)) {
            throw new IllegalArgumentException("Invalid element type.");
        }
        //int ind to set index to if found
        int ind = -1;
        for (int i = 0; i < size; i++) {
            if (elements[i] == element ||
            		(elements[i] != null && elements[i].equals(element))) {
            	//if found set to i
                ind = i;
                break;
            }
        }
        //if not found should still be -1
        if (ind == -1) {
            throw new IllegalArgumentException("Element not found.");
        }
        //calls the index removing method
        remove(ind);
    }
    
    public int size() {
    	//just returns size
    	return size;
    }
    
    public void trimToSize() {
    	//trims using copyOf with length size
    	Object[] temp = Arrays.copyOf(elements, size());
    	//sets elements to temp
    	this.elements = temp;
    }
    
    public MyArrayList sublist(int fromIndex, int toIndex)
    		throws IndexOutOfBoundsException {
    	//checks if fromIndex and toIndex are less than 
    	//zero and greater than size. also checks if toIndex is less than or
    	//equal to fromIndex
    	if(fromIndex < 0 || toIndex < 0 || toIndex <= fromIndex
    			|| toIndex > size() || fromIndex > size()) {
    		throw new IndexOutOfBoundsException("Invalid index range.");
    	}
        MyArrayList subList = new MyArrayList(this.elementType);
        //loops between from and to
        for (int i = fromIndex; i < toIndex; i++) {
        	//using the add method
            subList.add(elements[i]);
        }
    	return subList;
    }
    
    public void addAll(Object[] array) throws IllegalArgumentException {
    	for(Object o: array) {
    		//add method handles the illegal arguments
    		add(o);
    	}
    }
    
    public void clear() {
    	//basic reset: setting size to 0 and creating a new default object
    	size = 0;
    	Object[] o = new Object[10];
    	elements = o;
    }
    
    public boolean contains(Object element) {
    	//loops through entire elements array
    	for(int i = 0; i < size; i++) {
    		if(elements[i].equals(element)) {
    			return true;
    		}
    	}
    	//if not found return false otherwise
    	return false;
    }
    
    public String toString() {
    	//creates a temp array to copy all elements of array
    	Object[] arr = new Object[size()];
    	int ind = 0;
    	for(Object o: elements) {
    		if(o != null) {
    			arr[ind] = o;
    			ind++;
    		}
    	}
    	//returns the object[] to string
        return Arrays.toString(arr);
    }
    
    public String printFullArray() {
        String completeList = Arrays.toString(elements);
        return completeList;
    }

}
