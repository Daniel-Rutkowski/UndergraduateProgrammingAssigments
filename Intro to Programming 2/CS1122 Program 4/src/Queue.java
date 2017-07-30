import java.util.Arrays;

/**
 * This class is a queue provided for Program 4 to use.
 * 
 * Date Last Modified: 04 /7 / 2017
 * 
 * @author Daniel Rutkowski
 *
 *         CS1122, Spring 2017
 * 
 */

public class Queue<T> implements QueueInterface<T> {

	private final int defaultSize = 10; // default size of a queue

    private T[ ] queue; // the queue
    private int front = 0; // the front of the queue
	private int back = 0;  // the back of the queue
	private int size = 0;  // the current size of the queue
	private int maxSize = 0; // the max size of the queue array
	
    public Queue( ) {
    	queue = ( T[ ] ) new Object[ defaultSize ];
    	// This is an unavoidable error because generics and arrays don't work perfectly together.
    	maxSize = defaultSize;
    }
	
    public Queue( int sizeLimit ) {
    	queue = ( T[ ] ) new Object[ sizeLimit ];
    	// This is an unavoidable error because generics and arrays don't work perfectly together.
    	maxSize = sizeLimit;
    }
    
	public static void main(String[] args) {
		Queue<Integer> prog = new Queue<Integer>(12);
		try {
			System.out.println( prog );
			for ( int i = 0; i < 5; i++ ) {
				prog.enqueue(1);
				prog.enqueue(2);
				prog.enqueue(3);
				prog.enqueue(4);
			}
			System.out.println( prog );
		} catch ( QueueFullException e) {
			System.out.println( e );
			System.out.println( prog );
		}
		System.out.println(prog.size());
		System.out.println( prog.toString() );
	}

	/**
	 * This method adds an element to the queue.
	 * 
	 * @param element : The element to be added.
	 */
	@Override
	public void enqueue(T element) throws QueueFullException {
	
		if ( isFull( ) ) {
			if ( front != back ) {
				throw new RuntimeException( "front != back" );
			}
			throw new QueueFullException( );
		}
		queue[ back ] = element;
		back = ( back + 1 ) % queue.length;
		size++;
	}

	/**
	 * This method removes an element from the queue.
	 * 
	 * @return the element that has been removed.
	 */
	@Override
	public T dequeue() throws QueueEmptyException {
		if ( isEmpty( ) ) {
			if ( front != back ) {
				throw new RuntimeException( "front != back" );
			}
			throw new QueueEmptyException( );
		}
		T value = queue[ front ];
		queue[ front ] = null;
		front = ( front + 1 ) % queue.length;
		size--;
		return value;
	}

	/**
	 * This method returns the first element in the queue.
	 * 
	 * @return the element at the front of the list.
	 */
	@Override
	public T peek() throws QueueEmptyException {
		return queue[front];
	}

	/**
	 * This method tests if the queue is empty or not.
	 * 
	 * @return a boolean that is true if is empty or false if it is not
	 */
	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	
	/**
	 * This method tests if the queue is full or not.
	 * 
	 * @return a boolean that is true if is full or false if it is not
	 */
	@Override
	public boolean isFull() {
		return size == queue.length;
	}

	/**
	 * This method returns the current size of the queue.
	 * 
	 * @return an integer that is the current size of the queue
	 */
	@Override
	public int size() {
		return size;
	}
	
	/**
	 * This method returns the queue as a string.
	 * 
	 * @return an string representation of a queue
	 */
	public String toString() {
		if ( size() == 0 ) {
			return "[]";
		}
		
		if ( size() == 1 ) {
			return "[" + queue[0] + "]";
		}
		
		int index = 0;
		if ( back == 0 ) {
			index = maxSize - 1;
		} else {
			index = back - 1;
		}
		String result = "[" + queue[index];
		boolean flag = isFull();
		while (index != front || flag ) {
			if (index == 0) {
				index = maxSize - 1;
			} else {
				index--;
			}
			flag = false;
			result += (index == back - 1 ? " " : ", " ) + queue[index];
		}
		return result + "]";
	
		// What we did in class
				/*String result = "[";
				int current = front;
				if ( isFull() ) {
					result += " " + queue[ current ];
					current = ( current + 1 ) % queue.length;
				}
				while ( current != back ) {
					result += " " + queue[ current ];
					current = ( current + 1 ) % queue.length;
				}
				return result + "]";*/

	}
	
		// What we did in class
			// extends the queue instead of using circular arrays
			/*public void extendQueue() {
				T[ ] newqueue = ( T [] ) new Object[ queue.length + 50 ];
				int i = 0;
				int current = front;
				while ( !isEmpty() ) {
					try {
						newqueue[ i++ ] = dequeue();
					} catch (QueueEmptyException e) {
						// Should never reach this
						e.printStackTrace();
					}
				}
				queue = newqueue;
				front = 0;
				back = i;
			}*/

	
}
