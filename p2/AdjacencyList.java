import java.util.*;

public class AdjacencyList {
	// Adjacency list with each linked list containing that node's adjacent nodes
	ArrayList<LinkedList<Integer>> adjList;
	int numNodes;

	public AdjacencyList(int nodes) {
		numNodes = nodes;
		adjList = new ArrayList<LinkedList<Integer>>(nodes);
		for (int i = 0; i < nodes; i++) {
			adjList.add(new LinkedList<Integer>());
		}
	}

	public void insert(int node, int edge) {
		adjList.get(node).add(edge);
	}

	public void edges(int node) {
		System.out.println(adjList.get(node));
	}

	public void topologicalSort(int nodes, String[] nodeNames) {
		ArrayList<Integer> sorted = new ArrayList<Integer>(nodes);
		// Array initialized to 0 for each node (1 when visited)
		int visited[] = new int[nodes + 1];
		int node;

		// If node has not been visited, call visit method on that node
		for (int i = 1; i < nodes + 1; i++) {
			if (visited[i] == 0) {
				visit(i, visited, sorted);
			}
		}

		// Output topological sorting
		for (int i = nodes - 1; i >= 0 ; i--) {
			node = sorted.get(i);
			System.out.println(node + " " + nodeNames[node]);
		}

	}

	public void visit(int node, int[] visited, ArrayList<Integer> sorted) {
		visited[node] = 1;
		LinkedList<Integer> adjacent = adjList.get(node);
		
		// Loop through adjacent nodes, recursively visit a node if it has not been visited
		for (int next : adjacent) {
			if (visited[next] == 0) {
				visit(next, visited, sorted);
			}
		}

		sorted.add(node);
	}

}