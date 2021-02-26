package TestGraph;
import java.util.*;

public class UnweightedGraph<V> implements Graph<V> {
	protected List<V> vertices = new ArrayList<>();
	// adjEdge list
	protected List<List<Edge> > neighbors = new ArrayList<>();
	
	protected UnweightedGraph() {
		
	}
    
	protected UnweightedGraph(V[] v, int[][] e) {
		for(int i = 0; i < v.length; ++i) {
			addVertex(v[i]);
		}
		createdAdjList(e,v.length);
	}
	private void createdAdjList(int[][] e, int length) {
		// TODO Auto-generated method stub
		for(int i = 0; i< e.length; ++i) {
			addEdge(e[i][0], e[i][1]);
		}
	}

	protected UnweightedGraph(List<V> v, List<Edge> n) {
		for(int i = 0; i< v.size();++i) {
			addVertex(v.get(i));
		}
		createdAdjList(n,v.size());
	}
	private void createdAdjList(List<Edge> n, int size) {
		// TODO Auto-generated method stub
		for(Edge e: n) {
			addEdge(e.u,e.v);
		}
	}

	protected UnweightedGraph(List<Edge> e, int v) {
		for(int i = 0; i< v; ++i) {
			addVertex((V)(new Integer(i)));
		}
		createdAdjList(e,v);
	}
	
	protected UnweightedGraph(int[][] e, int v) {
		for(int i = 0; i< v; ++i) {
			addVertex((V)(new Integer(i)));
		}
		createdAdjList(e,v);
	}
	
	public class Search{
		private int root;
		private int[] parent;
		private List<Integer> searchOrder;
		
		public Search(int root, int[] parent, List<Integer> searchOrder) {
			super();
			this.root = root;
			this.parent = parent;
			this.searchOrder = searchOrder;
		}
		public int getRoot() {
			return root;
		}
		public void setRoot(int root) {
			this.root = root;
		}
		public int[] getParent() {
			return parent;
		}
		public void setParent(int[] parent) {
			this.parent = parent;
		}
		public List<Integer> getSearchOrder() {
			return searchOrder;
		}
		
		public int getNumberofVerticesFound() {
			return searchOrder.size();
		}
		
		public List<V> getPath(int ind){
			List<V> path = new ArrayList<>();
			do {
				path.add(vertices.get(ind));
				ind = parent[ind];
			} while(ind != -1);
			return path;
		}
		
		public void printPath(int ind) {
			List<V> p = getPath(ind);
			System.out.print("Path from " + vertices.get(root) + "to "+
			vertices.get(ind) + " : ");
			for(int i = p.size()-1; i>= 0; --i) {
				System.out.print(p.get(i)+ " ");
			}
		}
		
		public void printAll() {
			System.out.println("Root is: " + vertices.get(root));
			System.out.print("Edges: ");
			for(int i = 0 ;i < parent.length; ++i) {
				if(parent[i] != -1) {
					System.out.print("(" + vertices.get(parent[i]) + "," +
				                     vertices.get(i) + ") ");
				}
			}
			System.out.println();
		}
	}
	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return vertices.size();
	}
	@Override
	public List<V> getVertices() {
		// TODO Auto-generated method stub
		return vertices;
	}
	@Override
	public V getVertex(int index) {
		// TODO Auto-generated method stub
		return vertices.get(index);
	}
	@Override
	public int getIndex(V v) {
		// TODO Auto-generated method stub
		return vertices.indexOf(v);
	}
	@Override
	public List<Integer> getNeighbors(int index) {
		// TODO Auto-generated method stub
		List<Integer> res = new ArrayList<>();
		for(Edge e : neighbors.get(index)) {
			res.add(e.v);
		}
		return res;
	}
	@Override
	public int getDegree(int v) {
		// TODO Auto-generated method stub
		return neighbors.get(v).size();
	}
	@Override
	public void printEdges() {
		// TODO Auto-generated method stub
		for(int u = 0 ; u< neighbors.size(); ++u) {
			System.out.print("Dinh thu " + u + "-" + getVertex(u)+": ");
			for(Edge e : neighbors.get(u)) {
				System.out.print("(" + getVertex(e.u) + "," + 
			                          getVertex(e.v)+") ");
			}
			System.out.println();
		}
	}
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		vertices.clear();
		neighbors.clear();
	}
	@Override
	public boolean addVertex(V vertex) {
		// TODO Auto-generated method stub
		if(!vertices.contains(vertex)) {
			vertices.add(vertex);
			neighbors.add(new ArrayList<Edge>());
			return true;
		}
		return false;
	}
	@Override
	public boolean addEdge(int u, int v) {
		// TODO Auto-generated method stub
		return addEdge(new Edge(u,v)) && addEdge(new Edge(v,u));
	}
	@Override
	public boolean addEdge(Edge e) {
		// TODO Auto-generated method stub
		if(e.u < 0 || e.u > getSize()-1) {
			throw new IllegalArgumentException("Error! There's no ind  "+ e.u);
		}
		if(e.v < 0 || e.v > getSize()-1) {
			throw new IllegalArgumentException("Error! There's no ind  "+ e.v);
		}
		if(!neighbors.get(e.u).contains(e)) {
			neighbors.get(e.u).add(e);
			return true;
		}
		return false;
	}
	@Override
	public boolean remove(V v) {
		// TODO Auto-generated method stub
		if(vertices.contains(v)) {
			vertices.remove(vertices.indexOf(v));
			return true;
		}
		return false;
	}
	@Override
	public boolean remove(int u, int v) {
		// TODO Auto-generated method stub
		if(neighbors.contains(u)) {
			neighbors.get(u).remove(neighbors.get(u).indexOf(new Edge(u,v)));
			return true;
		}
		return false;
	}
	
	


	public int getIndex(String name) {
		return 0;
	}

	@Override
	public Search dfs(int v) {
		// TODO Auto-generated method stub
		List<Integer> searchOrder = new ArrayList<>();
		int[] parent = new int[vertices.size()];
		for(int i =0 ; i< vertices.size(); ++i) {
			parent[i] =-1;
		}
		boolean[] isVisited =  new boolean[vertices.size()];
		DFS(v,parent,searchOrder,isVisited);
		
		return new Search(v,parent,searchOrder);
	}
	
	private void DFS(int v, int[] parent, List<Integer> searchOrder, boolean[] isVisited) {
		searchOrder.add(v);
		isVisited[v] = true;
		for(Edge e: neighbors.get(v)) {
			if(!isVisited[e.v]) {
				parent[e.v] = v;
				DFS(e.v, parent, searchOrder,isVisited);
			}
		}
	}

	@Override
	public UnweightedGraph<V>.Search bfs(int v) {
		// TODO Auto-generated method stub
		List<Integer> searchOrder = new ArrayList<>();
		int[] parent = new int[vertices.size()];
		for(int i =0 ; i< vertices.size(); ++i) {
			parent[i] =-1;
		}
		boolean[] isVisited =  new boolean[vertices.size()];
		Queue<Integer> q = new LinkedList<>();
		q.offer(v);
		isVisited[v]= true;
		while(!q.isEmpty()) {
			int u = q.poll();
			searchOrder.add(u);
			for(Edge e : neighbors.get(u)) {
				if(!isVisited[e.v]) {
					q.offer(e.v);
					parent[e.v] = u;
					isVisited[e.v] =true;
				}
			}
		}
		return new Search(v,parent,searchOrder);
	}
}
