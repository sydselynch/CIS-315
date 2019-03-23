import java.util.*;

public class AdjacencyList {
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

	public ArrayList<Integer> topologicalSort(int nodes) {
		ArrayList<Integer> sorted = new ArrayList<Integer>(nodes);
		boolean finished[] = new boolean[nodes + 1];
		
		/*for (int i = 1; i < nodes + 1; i++) {
			finished[i] = false;
		}*/

		for (int i = 1; i < nodes + 1; i++) {
			if (finished[i] == false) {
				visit(i, finished, sorted);
			}
		}

		return sorted;

	}

	public void visit(int node, boolean[] finished, ArrayList<Integer> sorted) {
		finished[node] = true;
		LinkedList<Integer> adjacent = adjList.get(node);
		System.out.println(adjacent);
		/*for (int i = 0; i < adjList.get(i).size(); i++) {
			adjacent = adjList.get(i);
			System.out.println(adjacent);*/
			//if (finished[adjacent] == false) {
			//	visit(next, finished, sorted);
			//}
		for (int next : adjacent) {
			//System.out.println(finished[next]);
			if (finished[next] == false) {
				visit(next, finished, sorted);
			}
		}


		//}

		//topologicalOrder.push( node);
		sorted.add(node);
		


	}

}