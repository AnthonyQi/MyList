package systemImp;


/**
 * A Stack class that is implemented using MyArrayList as the underlying data structure.
 * This class follows the Last-In-First-Out (LIFO) principle.
 */
public class MyStack {

    // The underlying MyArrayList instance
    private MyArrayList stackList;

    public MyStack(Class<?> elementType) throws IllegalArgumentException {
    	//checks if the class type is null
    	if(elementType == null) {
    		throw new IllegalArgumentException("Element type cannot be null.");
    	}
    	stackList = new MyArrayList(elementType);
    }
    
    public void push(Object element) {
    	//checks if correct instance
    	if(!stackList.elementType.isInstance(element)) {
    		throw new IllegalArgumentException
    			("Element type does not match stack element type.");
    	}
    	stackList.add(element);
    }
 
    public Object pop() {
    	//checks if size is less than 1.
    	if(stackList.size() < 1) {
    		throw new IllegalStateException("Stack is empty. Cannot pop.");
    	}
    	int size = stackList.size() - 1;
     	Object top = stackList.get(size);
     	//takes advantage of remove method
    	stackList.remove(size);
    	return top;
    }
    
    public Object peek() {
    	//checks if empty
    	if(stackList.size() == 0) {
    		throw new IllegalStateException
    			("Stack is empty. Cannot peek.");
    	}
    	//gets top of stack
    	int size = stackList.size() - 1;
     	Object top = stackList.get(size);
     	return top;
    }
    
    public boolean isEmpty() {
    	//checks if stackList is null or size is 0
    	//returns based on that
        return stackList == null || stackList.size() == 0;
    }
 
    public int size() {
    	//gets size through MAL size method
    	int s = stackList.size();
    	return s;
    }
    
    public void clear() {
    	//calls MAL clear method
    	stackList.clear();
    }
    
    public Class<?> elementType() {
    	//returns elementType
    	return stackList.elementType;
    }

    public String toString() {
    	return "Stack: " + stackList.toString();
    }

}
