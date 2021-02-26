package TestGraph;

public class Knowing {
	int u;
	int v;
	
	Knowing(int u, int v){
		this.u = u;
		this.v = v;
	}
	
	public boolean equals(Object obj) {
		return u == ((Knowing)obj).u && v == ((Knowing)obj).v ;
	}	
}
