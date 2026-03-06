package completeTreesInArrays;

public class Test {

	public static void main(String[] args) {
		
		Tree mytree = new Tree(10);
		int k = 48;
		System.out.println("parent("+k+") = " + mytree.parent(k));
		System.out.println("left("+k+") = " + mytree.left(k));
		System.out.println("right("+k+") = " + mytree.right(k));
		System.out.println("Does " +k+ " exist? -->" + mytree.searchFor(k));
	}

}
