import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

class BinaryTrees<T extends Comparable<T>> {
	Node<T> rootNode;
	int index = 0;
	int level = 0;
	int nodePointer = 0;
	Node<T> childNode;
	Node<T> traverseNode;
	Node<T> nextNode;
	public void insertElement(T element) {
		Node<T> newNode = new Node<T>();
		newNode.setElement(element);
		if (rootNode == null) {
			rootNode = newNode;
			traverseNode = newNode;
			childNode = newNode;
			nextNode = newNode;
			this.updateLevel(level);
			this.updateNodePointer();
		} else {
			if (childNode.getLeftNode() == null) {
			 	childNode.setLeftNode(newNode);
			} else if (childNode.getRightNode() == null) {
	 			childNode.setRightNode(newNode);
	 			this.updateNodePointer();
	 			this.updateLevel(level);
			}
			nextNode.setNextNode(newNode);
      		nextNode = newNode;
		}
		index++;
	}

	public void updateNodePointer() {
		Node<T> node1 = traverseNode;
		int i = 0;
		if (nodePointer == 0) {
			childNode = rootNode;
		} else {
			while (i <= nodePointer) {
				childNode = node1;
				node1 = node1.getNextNode();
				i++;
			}
		}
		nodePointer++;
	}

	public void swap() {
		Node<T> right = rootNode.getRightNode();
		Node<T> left = rootNode.getLeftNode();
		rootNode.setLeftNode(right);
		rootNode.setRightNode(left);
	}

	public void getLevelOrderTraversal() {
	    Queue<Node<T>> queue = new LinkedList<Node<T>>();  
	    ArrayList<T> elements = new ArrayList<T>();
	    queue.add(rootNode);
	    System.out.println("[" + rootNode.getElement() + "]");
	    int level = 1;
	    int n = 0;
	    while(!queue.isEmpty())  
	    {  
	    	Node<T> tempNode=queue.poll();
	     	if(tempNode.getLeftNode()!=null) {
	      		queue.add(tempNode.getLeftNode());
	      		elements.add(tempNode.getLeftNode().getElement());
	      		n++;
	      	}
	     	if(tempNode.getRightNode()!=null) { 
	      		queue.add(tempNode.getRightNode());  
	      		elements.add(tempNode.getRightNode().getElement());
	      		n++;
	      	}
	      	if (((int)Math.pow(2, level)) == n) {
	      		System.out.print("[");
	    		for (int i = 0; i < elements.size() - 1; i++) {
	     			System.out.print(elements.get(i) + ",");	    			
	    		}
	    		System.out.println(elements.get(elements.size() - 1) + "]");
	    		level++;
	    		n = 0;
	    		elements = new ArrayList<T>();
	    	}
	    }
	    if (elements.size() != 0) {
	    	System.out.print("[");
		    for (int i = 0; i < elements.size() - 1; i++) {
		     	System.out.print(elements.get(i) + ",");
		    }
		    System.out.println(elements.get(elements.size() - 1) + "]");	
	    }
	}

	public void updateLevel(int presentLevel) {
		if (index == ((2^level) - 1)) {
			level++;
		}
	}

	public static void main(String[] args) {
		BinaryTrees<Integer> bt = new BinaryTrees<Integer>();
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		StringTokenizer st = new StringTokenizer(s, "[, ]");
		while (st.hasMoreTokens()) {
			String s1 =  st.nextToken().trim();
			bt.insertElement(Integer.parseInt(s1));			
			// if (!s1.equals("#")) {
			// 	bt.insertElement(Integer.parseInt(s1));			
			// } else {
			// 	bt.insertElement(null);
			// }
		}
		bt.swap();
		bt.getLevelOrderTraversal();
	}

}