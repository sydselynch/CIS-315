import java.util.*;


public class assignment2 {

	public static void main(String[] args) {
		int node, edge, weight;
		Scanner scanner = new Scanner(System.in);
		int numNodes = scanner.nextInt();
		int numEdges = scanner.nextInt();
		String[] nodeNames = new String[numNodes + 1];
		
		for (int i = 1; i < numNodes + 1; i++) {
			nodeNames[i] = scanner.next();
		}

		AdjacencyList adj = new AdjacencyList(numNodes + 1);

		for (int i = 0; i < numEdges; i++) {
			node = scanner.nextInt();
			edge = scanner.nextInt();
			weight = scanner.nextInt();
			adj.insert(node, edge);
			
		}

		adj.topologicalSort(numNodes, nodeNames);
		
	}

}


