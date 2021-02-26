package TestGraph;

import java.util.List;

import TestGraph.UnweightedGraph.Search;


public interface Graph<V> { 
	
	/** Return the number of vertices in the graph */
	  public int getSize();

	  /** Return the vertices in the graph */
	  public List<V> getVertices();

	  /** Return the object for the specified vertex index */
	  public V getVertex(int index);

	  /** Return the index for the specified vertex object */
	  public int getIndex(V v);

	  /** Return the neighbors of vertex with the specified index */
	  public List<Integer> getNeighbors(int index);

	  /** Return the degree for a specified vertex */
	  public int getDegree(int v);

	  /** Print the edges */
	  public void printEdges();

	  /** Clear the graph */
	  public void clear();

	  /** Add a vertex to the graph */  
	  public boolean addVertex(V vertex);

	  /** Add an edge (u, v) to the graph */  
	  public boolean addEdge(int u, int v);

	  /** Add an edge to the graph */  
	  public boolean addEdge(Edge e);

	  /** Remove a vertex v from the graph, return true if successful */  
	  public boolean remove(V v);

	  /** Remove an edge (u, v) from the graph */  
	  public boolean remove(int u, int v);

	  public int getIndex(String name);

	  
	  
	  /** Obtain a depth-first search tree */
	  @SuppressWarnings("rawtypes")
	  public UnweightedGraph<V>.Search dfs(int v);

	  /** Obtain a breadth-first search tree */
	  public Search bfs(int v);

}
