import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class bfs {

	public static String a = "a", b = "b", c = "c", d = "d", e = "e", f = "f",
			g = "g", h = "h";
	public static String[][] graph = { { a, c }, { a, b }, { b, d }, { c, d },
			{ b, c }, { d, g }, { d, f }, { c, e }, { f, e }, { f, g },
			{ g, h } };
	public static String[] allNodes = { a, b, c, d, e, f, g, h };

	public static ArrayList<String> traversedNodes = new ArrayList<String>();
	public static Queue<String> orderedNodes = new LinkedList<String>();

	public static void main(String[] args) {
		traversedNodes.add(d);
		startBfs(d);
	}

	public static void startBfs(String startNode) {

		if (traversedNodes.size() == allNodes.length) {
			return;
		}

		System.out.println("Checking node: " + startNode);
		ArrayList<String> connectedNodes = getConnectedNodes(startNode);
		for (String endNode : connectedNodes) {
			if (!isNodeExplored(endNode)) {
				System.out.println("Exploring: " + endNode);
				traversedNodes.add(endNode);
				orderedNodes.offer(endNode);
			}
		}
		System.out.println("-------------");

		String nextNode = null;
		for (int i = 0; i < orderedNodes.size(); i++) {
			nextNode = orderedNodes.poll(); // Use queue
			if (getConnectedNodes(nextNode).size() != 0) {
				break;
			}
		}
		if (nextNode == null) {
			return;
		}
		startBfs(nextNode);
	}

	public static ArrayList<String> getConnectedNodes(String node) {
		ArrayList<String> edges = new ArrayList<String>();
		for (String[] edge : graph) {
			if (edge[0].equals(node)) {
				edges.add(edge[1]);
			} else if (edge[1].equals(node)) {
				edges.add(edge[0]);
			}
		}
		return edges;
	}

	public static boolean isNodeExplored(String aNode) {
		for (String node : traversedNodes) {
			if (node.equals(aNode)) {
				return true;
			}
		}
		return false;
	}
}
