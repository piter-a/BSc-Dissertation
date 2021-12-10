import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int choice;
		int vertices;
		int edges;
		int count = 1;
		int origin = 0;
		int end = 0;
		Scanner input = new Scanner(System.in);
		Graph graph;


		try {
			System.out.println("Create a Wheel Graph, a Prism Graph");
			System.out.println("Enter the number of vertices in your graph: ");
			vertices = input.nextInt();
			System.out.println("\nEnter the number of edges in your graph: ");
			edges = input.nextInt();
			graph = new Graph(vertices);
			graph.setVertices(vertices);
			graph.setEdges(edges);
			
			//enter the edges in following form: OriginVertex EndVertex then press
			//Enter and input another edge
			System.out.println("\nEnter the edges of your graph: <origin><end>");

			while (count <= edges) {
				origin = input.nextInt();
				end = input.nextInt();

				graph.addEdge(origin, end);
				count++;
			}

			System.out.println("\nThe adjacency matrix for input graph is: ");
			System.out.print("  ");

			for (int i = 1; i <= vertices; i++)
				System.out.print(i + " ");
			    System.out.println();

			for (int i = 1; i <= vertices; i++) {
				System.out.print(i + " ");
				for (int j = 1; j <= vertices; j ++)
					System.out.print(graph.getEdge(i, j) + " ");
				    System.out.println();
			}
			
			boolean quit = false;
			
			do {

				System.out.println("\n------ Other Operations ------");
				System.out.println("1: Show the degree of a particular vertex");
				System.out.println("2: Show the neighbours of a vertex");
				System.out.println("3: Remove an edge from your graph");
				System.out.println("4: Add an edge to your graph");
				System.out.println("5: Color your wheel graph using the least amount of colors");
				System.out.println("6: Color your prism graph using the least amounts of colors");
				System.out.println("7: Quit");
				System.out.println("Enter your choice: ");
				choice = input.nextInt();

				switch(choice) {
				case 1:
					int vertex = 0;
					System.out.println("Enter the number of the vertex: ");
					vertex = input.nextInt();
					System.out.println("Degree of vertex " + vertex + " = " + graph.degree(vertex));
					break;

				case 2:
					int vertex1;
					System.out.println("Enter the number of the vertex: ");
					vertex1 = input.nextInt();
					System.out.println("Vertices adjacent to vertex " + vertex1 + ": " + graph.neighbours(vertex1));
					break;

				case 3:
					int vertex3;
					int vertex4;
					System.out.println("Enter the edge you wish to remove: <origin><end>");
					vertex3 = input.nextInt();
					vertex4 = input.nextInt();
					graph.removeEdge(vertex3, vertex4);
					System.out.println("The new adjacency matrix of your graph: ");
					System.out.print("  ");
					for (int i = 1; i <= vertices; i++)
						System.out.print(i + " ");
					    System.out.println();

					for (int i = 1; i <= vertices; i++) {
						System.out.print(i + " ");
						for (int j = 1; j <= vertices; j ++)
							System.out.print(graph.getEdge(i, j) + " ");
						    System.out.println();
					}
					break;

				case 4:
					int vertex5;
					int vertex6;

					System.out.println("Enter the edge you wish to add: <origin><end>");
					vertex5 = input.nextInt();
					vertex6 = input.nextInt();
					graph.addEdge(vertex5, vertex6);
				System.out.println("The new adjacency matrix of your graph: ");
					System.out.print("  ");
					for (int i = 1; i <= vertices; i++)
						System.out.print(i + " ");
					    System.out.println();

					for (int i = 1; i <= vertices; i++) {
						System.out.print(i + " ");
						for (int j = 1; j <= vertices; j ++)
							System.out.print(graph.getEdge(i, j) + " ");
						    System.out.println();
					}
					break;
					
				case 5:
					System.out.println("\nColoring of your wheel graph: <Vertex = color>");
					graph.wheelColoringAlgorithm();
					System.out.println();
					break;
					
				case 6:
					System.out.println("\nColoring of your prism graph: <Vertex = color>");
					graph.prismColoringAlgorithm();
					System.out.println();
					break;
					
				case 7: 
					quit = true;
					break;

				default: 
					break;
				}

			} while (quit != true);
			System.out.println("Program closed");

		} catch (Exception E) {
			System.out.println("Something went wrong.");
		}

		input.close();
	}

}
