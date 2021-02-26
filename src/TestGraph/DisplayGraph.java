package TestGraph;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
public class DisplayGraph extends Application{

	@Override
	public void start(@org.jetbrains.annotations.NotNull Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		Friend[] f = {
				new Friend("Sam","Vancouver",25,"Doctor","Sleep, read book, climb",  "Married with Mia",75,60), 
				new Friend("Mia","Canada", 23, "Teacher","Game, Running","Married with Sam",55,400),
				new Friend("Lee Dohuyn","Seoul",23, "Actor","Game,Meditation,Sing","Single",562,225),
				new Friend("Lee Dongwook","Seoul", 35, "Actor","Watch movie, Cooking","Single",572,100.85),
				new Friend("Zayn","New York",30,"Singer","Horror movie, Sing, Swim","Married",510,48),
				new Friend("Huy","Hanoi", 27, "Accountant","Read book, Write Diary, Cooking", "In a relationship",394,60),
				new Friend("Zaya", "Paris",15,"Student","Playing piano, sketch","In a relationship",270,510),
				new Friend("Ben","HCM",30,"Teacher","Coffee, read book, drawing","Single",609,302),
				new Friend("Khiem","Danang", 17, "Student","Game","Single",244,225),
				new Friend("Phuong","Nha Trang",22,"Student","Photograph, make blog","In a relationship",600,400)};
		
		int[][] edge = {    {0,1},{0,3},{0,5},{0,9},
							{1,0},{1,2},{1,8},{1,9},
							{2,1},{2,3},{2,7},{2,8},{2,9},
							{3,0},{3,2},{3,5},
							{4,5},
							{5,0},{5,3},{5,4},
							{6,9},
							{7,2},{7,9},
							{8,1},{8,2},
							{9,0},{9,1},{9,2},{9,6},{9,7}};
		
		FriendGraph graph = new FriendGraph(f,edge);
		
		// create scene and place it in the stage
		Scene sc = new Scene(new GraphView(graph), 800, 700,Color.LIGHTSALMON);
		primaryStage.setTitle("Friend Graph");
		primaryStage.setScene(sc);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
	    launch(args);
	  }
}
