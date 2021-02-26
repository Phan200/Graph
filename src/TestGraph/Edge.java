package TestGraph;

public class Edge {
	int u;
	int v;
	
	public Edge(int u, int v) {
		this.u = u;
		this.v = v;
	}
	
	public boolean equals(Object obj) {
		return u == ((Edge)obj).u && v == ((Edge)obj).v ;
	}
}
