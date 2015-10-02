class Queue<T> {
	Node<T> front;
  	Node<T> rear;
  	int count = 0;
	public void enQueue(T element) {
		Node<T> newNode = new Node<T>();
		newNode.setElement(element);
		if (front == null) {
			front = newNode;
			rear = newNode;
			rear.setNextNode(front);
			count++;
		} else {
			rear.setNextNode(newNode);
      		rear = newNode;
      		rear.setNextNode(front);
      		count++;
		}
	}
	
	public void deQueue(){
    	front = front.getNextNode();
    	count--;
	}
	
	public boolean isEmpty(){
		if (front == null) {
			return true;
		}
		return false;
	}

	public T getFront(){
		return front.getElement();
	}

	public void print() {
		Node<T> printNode = front;
		int p = 0;
		if (!isEmpty()) {
			 while (p < count) {
		      System.out.println(printNode.getElement());
		      printNode = printNode.getNextNode();
		      p++;
		    }
		} else {
			System.out.println("Queue is empty");
		}
	   
	}
}