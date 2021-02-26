package TestGraph;

import java.util.List;

public class TestGraph {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Friend[] f = {
				new Friend("Sam","Vancouver",25,"Doctor","Sleep, read book, climb",  
				"Married with Mia"), 
				new Friend("Mia","Canada", 23, "Teacher","Game, Running","Married with Sam"),
				new Friend("Lee Dohuyn","Seoul",23, "Actor","Game,Meditation,Sing","Single"),
				new Friend("Lee Dongwook","Seoul", 35, "Actor","Watch movie, Cooking","Single"),
				new Friend("Zayn","New York",30,"Singer","Horror movie, Sing, Swim","Married"),
				new Friend("Huy","Hanoi", 27, "Accountant","Read book, Write Diary, Cooking", "In a relationship"),
				new Friend("Zaya", "Paris",15,"Student","Playing piano, sketch","In a relationship"),
				new Friend("Ben","HCM",30,"Teacher","Coffee, read book, drawing","Single"),
				new Friend("Khiem","Danang", 17, "Student","Game","Single"),
				new Friend("Phuong","Nha Trang",22,"Student","Photograph, make blog","In a relationship")};
		
		int[][] edge = {
				{0,1},{0,3},{0,5},{0,9},
				{1,0},{1,2},{1,8},{1,9},
				{2,1},{2,3},{2,7},{2,8},{2,9},
				{3,0},{3,2},{3,5},
				{4,5},
				{5,0},{5,3},{5,4},
				{6,9},
				{7,2},{7,9},
				{8,1},{8,2},
				{9,0},{9,1},{9,2},{9,6},{9,7},
		};
		
		FriendGraph G = new FriendGraph(f,edge);
		System.out.println("Number of friend that I have is " + G.getSize());
		System.out.println("Ben is my " + (G.getIndex("Ben")+1) +  "th friend in my friend list;");
		System.out.println("My list friend and our mutual friends are: ");
		G.printEdge();
		
		// add new friend
		System.out.println("\nAfter add Nicky, ....");
		G.addVertex(new Friend("Nicky","London",30,"Engineer", "Doing yoga, Meditation, Playing with pet","Married"));
		G.addEdge(G.getIndex("Nicky"), 3);
		
		System.out.println("My list friend and our mutual friends are: ");
		G.printEdge();
		
		// Search DFS
		UnweightedGraph<Friend>.Search s = G.dfs(G.getIndex("Sam"));
		List<Integer> p = s.getSearchOrder();
		System.out.println("\nSearch DFS: ");
		for(int i = 0 ;i<p.size();++i) {
			if(i!=p.size()-1) {
				System.out.print(G.getVertex(p.get(i)).getName() + "-> ");
			} else System.out.print(G.getVertex(p.get(i)).getName() + "; ");
			
		}
		System.out.println();
		
		// search BFS
		s = G.bfs(G.getIndex("Ben"));
		p = s.getSearchOrder();
		System.out.println("\nSearch BFS: ");
		for(int i = 0 ;i<p.size();++i) {
			if(i!=p.size()-1) {
				System.out.print(G.getVertex(p.get(i)).getName() + "-> ");
			} else System.out.print(G.getVertex(p.get(i)).getName() + "; ");
			
		}
		System.out.println();
	}

}
