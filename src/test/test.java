import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;


public class test {
	
    private List<Vertex> nodes;
    private List<Edge> edges;

    
    /*
     *Comprobación de que los vertices del grafo se crean correctamente
     */
    @Test
    public void testGrafoVertices() {
          //nodos
      nodes = new ArrayList<Vertex>();
      for (int i = 0; i < 3; i++) {
        Vertex location = new Vertex("Node_" + i, "Node_" + i);
        nodes.add(location);
      }

      // Grafo
      Graph graph = new Graph(nodes, null);
      
      assertEquals(graph.getVertexes().size(), 3);
      assertEquals(graph.getVertexes().get(1).getId(), "Node_1");
    }
    
    
    /*
     *Comprobación de que las aristas del grafo se crean correctamente
     */
    @Test
    public void testGrafoAristas() {
          //nodos
      nodes = new ArrayList<Vertex>();
      for (int i = 0; i < 3; i++) {
        Vertex location = new Vertex("Node_" + i, "Node_" + i);
        nodes.add(location);
      }
      //Aristas
      edges = new ArrayList<Edge>();
      addLane("Arco_0", 0, 1, 85);
      addLane("Arco_1", 0, 2, 217);
      addLane("Arco_2", 1, 2, 173);

      // Grafo
      Graph graph = new Graph(nodes, edges);
      
      assertEquals(graph.getEdges().size(), 3);
      assertEquals(graph.getEdges().get(2).getId(),"Arco_2");
    }
    
    
    /*
     * Prueba desarrollada por el autor de la correcta ejecucion del algoritmo.
     */
    @Test
    public void testExcute() {
      nodes = new ArrayList<Vertex>();
      edges = new ArrayList<Edge>();
      for (int i = 0; i < 11; i++) {
        Vertex location = new Vertex("Node_" + i, "Node_" + i);
        nodes.add(location);
      }

      addLane("Edge_0", 0, 1, 85);
      addLane("Edge_1", 0, 2, 217);
      addLane("Edge_2", 0, 4, 173);
      addLane("Edge_3", 2, 6, 186);
      addLane("Edge_4", 2, 7, 103);
      addLane("Edge_5", 3, 7, 183);
      addLane("Edge_6", 5, 8, 250);
      addLane("Edge_7", 8, 9, 84);
      addLane("Edge_8", 7, 9, 167);
      addLane("Edge_9", 4, 9, 502);
      addLane("Edge_10", 9, 10, 40);
      addLane("Edge_11", 1, 10, 600);

      // Lets check from location Loc_1 to Loc_10
      Graph graph = new Graph(nodes, edges);
      Dijkstra dijkstra = new Dijkstra(graph);
      dijkstra.execute(nodes.get(0));
      LinkedList<Vertex> path = dijkstra.getPath(nodes.get(10));
      
      assertNotNull(path);
      assertTrue(path.size() > 0);            
    }
    
    
    /*
     * Prueba desarrollada por mi. Ejemplo obtenido de: http://www.youtube.com/watch?v=VENf0GXRd6E
     */
    @Test
    public void test1Funcionamieno() {
      nodes = new ArrayList<Vertex>();
      edges = new ArrayList<Edge>();
      for (int i = 1; i <= 6; i++) {
        Vertex location = new Vertex("Node_" + i, "Node_" + i);
        nodes.add(location);
      }
      int i = 1;
      addLane("Edge_0", 1-i, 2-i, 2);
      addLane("Edge_1", 1-i, 3-i, 1);
      addLane("Edge_2", 2-i, 4-i, 1);
      addLane("Edge_3", 3-i, 4-i, 3);
      addLane("Edge_4", 3-i, 5-i, 4);
      addLane("Edge_5", 5-i, 6-i, 2);
      addLane("Edge_6", 4-i, 6-i, 2);

      // Lets check from location Loc_1 to Loc_10
      Graph graph = new Graph(nodes, edges);
      Dijkstra dijkstra = new Dijkstra(graph);
      dijkstra.execute(nodes.get(0));
      LinkedList<Vertex> path = dijkstra.getPath(nodes.get(6-1));
                  
      //Resultado final
      assertNotNull(path);
      assertEquals("[Node_1, Node_2, Node_4, Node_6]",path.toString());
    }  
      
    private void addLane(String laneId, int sourceLocNo, int destLocNo,
        int duration) {
      Edge lane = new Edge(laneId,nodes.get(sourceLocNo), nodes.get(destLocNo), duration);
      edges.add(lane);
    }
	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
