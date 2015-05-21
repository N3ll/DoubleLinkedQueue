public class DoubleLinkedQueue<T> implements QueueI<T> {
	private Node<T> head;
	private Node<T> tail;

	public DoubleLinkedQueue() {
		clear();
	}

	@Override
	public void enqueue(T newEntry) {
		Node<T> toAdd = new Node<T>(newEntry, tail, tail.previous);
		tail.previous.next = toAdd;
		tail.previous = toAdd;
	}

	@Override
	public T dequeue() {
		if (isEmpty())
			return null;

		Node<T> removed = head.next;

		head.next.next.previous = head;
		head.next = head.next.next;


		return removed.data;
	}

	@Override
	public T getFront() {
		return head.next.data;
	}

	@Override
	public boolean isEmpty() {
		return head.next == tail && tail.previous == head;
	}

	@Override
	public void clear() {
		head = new Node<T>(null, null, null);
		tail = new Node<T>(null, null, null);
		head.next = tail;
		tail.previous = head;
	}

	// if not static - the inner class can use the instance fields from the
	// outer class and the T
	private static class Node<T> {

		// all fields are visible to the outer class
		private T data; // entry in bag
		private Node<T> next; // link to next node
		private Node<T> previous; // link to the previous node

		public Node(T data, Node<T> next, Node<T> previous) {
			this.data = data;
			this.next = next;
			this.previous = previous;
		}

	} // end Node<T> class

}
