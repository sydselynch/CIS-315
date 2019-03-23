import java.util.*;


public class assignment2 {

	public static void main(String[] args) {
		int node, edge, weight;
		Scanner scanner = new Scanner(System.in);
		int numNodes = scanner.nextInt();
		int numEdges = scanner.nextInt();
		String[] nodeNames = new String[numNodes + 1];
		ArrayList<Integer> sorted;
		for (int i = 1; i < numNodes + 1; i++) {
			nodeNames[i] = scanner.next();
			//System.out.println(nodeNames[i]);
		}

		AdjacencyList adj = new AdjacencyList(numNodes + 1);

		for (int i = 0; i < numEdges; i++) {
			node = scanner.nextInt();
			edge = scanner.nextInt();
			weight = scanner.nextInt();
			//System.out.println(node + " " + edge + " " + weight);
			adj.insert(node, edge);
			
		}

		/*adj.edges(1);
		adj.edges(2);
		adj.edges(3);
		adj.edges(4);
		adj.edges(5);
		adj.edges(6);*/
		sorted = adj.topologicalSort(numNodes);
		System.out.println(sorted);
		for (int i = numNodes - 1; i >= 0 ; i--) {
			node = sorted.get(i);
			System.out.println(node + " " + nodeNames[node]);
		}
	}

}


