import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Graph{
	private int vertex;
	private int edges;
	private String[] colors = {"Blue", "Red", "Green", "Yellow"};
	private int[][] graphMatrix;
	private HashMap<Integer, String> colorings;

	public Graph(int v) {
		this.vertex = v;
		graphMatrix = new int[vertex + 1][vertex + 1];
		this.colorings = new HashMap<Integer, String>();

		for (int i = 0; i < vertex; i++) {
			for (int j = 0; j < vertex; j++) {
				graphMatrix[i][j] = 0;
			}
		}
	}

	public void addEdge(int origin, int end) {
		try {
			graphMatrix[origin][end] = 1;
			graphMatrix[end][origin] = 1;
		} catch (ArrayIndexOutOfBoundsException index) {
			System.out.println("These vertices do not exist.");
		}
	}

	public void removeEdge(int origin, int end) {
		try {
			graphMatrix[origin][end] = 0;
			graphMatrix[end][origin] = 0;
		} catch (ArrayIndexOutOfBoundsException index) {
			System.out.println("These vertices do not exist.");
		}
	}

	public int getEdge(int origin, int end) {
		try {
			return graphMatrix[origin][end];
		} catch (ArrayIndexOutOfBoundsException index) {
			System.out.println("These vertices do not exist.");
		}
		return -1;
	}

	public List<Integer> neighbours(int vertex) {
		List<Integer> neighbours = new ArrayList<Integer>();

		for (int i = 0; i <= getVertices(); i++) {
			if (graphMatrix[vertex][i] != 0) {
				neighbours.add(i);
			}
		}
		return neighbours;

	}

	public int degree(int vertex) {
		int count = 0;

		for (int i = 0; i <= getVertices(); i++) {
			if (graphMatrix[vertex][i] == 1) {
				count ++;
			}
		}

		return count;
	}

	//this method is not useful for a wheel graph as all vertices are within two nodes of each other
	public List<Integer> getNeighboursTwoApart(int vertex) {
		List<Integer> twoApart = new ArrayList<Integer>();

		for (int i = 6; i <= getVertices(); i++) {
			if (graphMatrix[vertex][i] != 0) {
				twoApart.addAll(neighbours(i));
			}
		}

		Collections.sort(twoApart);
		return twoApart;
	}

	public void wheelColoringAlgorithm() {
		int max = 0;
		for (int i = 0; i < graphMatrix.length; i++) {
			max = i;
		}

		if (getVertices() % 2 != 0) {
			for (int i = 1; i <= getVertices(); i++) {
				if (i == max)
					colorings.put(i, colors[0]);
				if (i % 2 != 0 && i != max)
					colorings.put(i, colors[1]);
				if (i % 2 == 0) {
					colorings.put(i, colors[2]);
				}
			}
		} else {
			for (int i = 1; i <= getVertices(); i++) {
				if (i == max) 
					colorings.put(i, colors[0]);
				if (i == 1)
					colorings.put(i, colors[1]);
				if(i % 2 != 0)
					colorings.put(i, colors[2]);
				if (i % 2 == 0 && i != max) 
					colorings.put(i, colors[3]);
			}
		}
		System.out.print(colorings);
	}

	public void prismColoringAlgorithm() {
		int max_inside = 0;
		int max_outside = 0;

		for (int i = 0; i < graphMatrix.length; i++) {
			max_inside = i;
		}

		for (int i = 0; i <= (graphMatrix.length / 2); i++) {
			max_outside = i;
		}
		if ((getVertices() / 2) % 2 == 0) {
			for (int i = 1; i <= (getVertices() / 2); i++) {
				if (i % 2 != 0)
					colorings.put(i, colors[0]);
				if (i % 2 == 0)
					colorings.put(i, colors[1]);
			}
			for (int i = 1 + (getVertices() / 2); i <= getVertices(); i++) {
				if (i % 2 != 0)
					colorings.put(i, colors[0]);
				if (i % 2 == 0)
					colorings.put(i, colors[1]);
			}
		} else {
			for (int i = 1; i <= (getVertices() / 2); i++) {
				if (i % 2 != 0 && i != max_outside)
					colorings.put(i, colors[0]);
				if (i % 2 == 0)
					colorings.put(i, colors[1]);
				if (i == max_outside)
					colorings.put(i, colors[2]);
			}
			for (int i = 1 + (getVertices() / 2); i <= getVertices(); i++) {
				if (i % 2 != 0)
					colorings.put(i, colors[1]);
				if(i % 2 == 0 && i != max_inside)
					colorings.put(i, colors[0]);
				if (i == max_inside)
					colorings.put(i, colors[2]);
			}
		}
		
		System.out.println(colorings);

	}

	//public void chainWheelGraphColoring() {
		
		//}


	//get and set methods
	public int getVertices() {
		return vertex;
	}

	public int getEdges() {
		return edges;
	}

	public void setVertices(int v) {
		vertex = v;
	}

	public void setEdges(int e) {
		edges = e;
	}

}


