package completeTreesInArrays;

import java.util.ArrayList;

public class Tree {
	public final int NOTEXISTING = -1;
	private Node[] nodes;
	//private ArrayList<Node> nodes;
	
	public Tree(int n) {
		nodes = new Node[n];
		//nodes = new ArrayList<Node>();
		/*for(Node n: nodes){
			
		}*/
		
		for(int i = 0; i < n; i++) {
			nodes[i] = new Node(i);
			//System.out.println(nodes[i].getValue());
		}
	}
	
	public int parent(int k) {
		double x = k/2;
		int y = (int) Math.ceil(x);
		return y - 1;
	}
	
	public int left(int k) {
		int z = 2*k + 1;
		if(z < nodes.length) {
			return z;
		}else {
			return NOTEXISTING;
		}
	}
	
	public int right(int k) {
		int q = 2*k + 2;
		if(q < nodes.length) {
			return q;
		}else {
			return NOTEXISTING;
		}
	}
	
	//Level-order
	public boolean searchFor(int k) {
		boolean found = false;
		int i = 0;
		while (!found && i < nodes.length) {
			found = nodes[i].getValue() == k;
			i++;
		}
		return found;
		//return true, if k exists
		//return false, if k doesn't exist
		//return false;
	}
	
	/*public ArrayList<Node> getNodes(){
		return nodes;
	}*/

}
