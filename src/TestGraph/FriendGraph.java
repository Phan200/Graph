package TestGraph;

public class FriendGraph extends UnweightedGraph<Friend> {
	public FriendGraph(Friend[] f, int[][] edge) {
		// TODO Auto-generated constructor stub
		for(int i = 0; i < f.length; ++i) {
			addVertex(f[i]);
		}
		createdAdjList(edge,f.length);
	}
	private void createdAdjList(int[][] e, int length) {
		// TODO Auto-generated method stub
		for(int i = 0; i< e.length; ++i) {
			addEdge(e[i][0], e[i][1]);
		}
	}
	public void printEdge() {
		for(int u =0 ; u< neighbors.size(); ++u) {
			System.out.print((u+1)+ ". "+ getVertex(u).getName()+ ": ");
			for(Edge e : neighbors.get(u)) {
				System.out.print(getVertex(e.v).getName()+ ", ");
			}
			System.out.println("...");
		}
	}
	@Override
	public int getIndex(String name) {
		// TODO Auto-generated method stub
		for(int i = 0; i < vertices.size(); ++i) {
			if(vertices.get(i).getName() == name) {
				return i;
			}
		}
		return -1;
	}
	
	
}
