package TestGraph;

import javafx.scene.layout.BorderPane;

import java.util.List;

import javafx.scene.Group;
import javafx.scene.control.Dialog;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.*;

public class GraphView extends BorderPane{
	private Graph<? extends Display> g;
	private Group gr = new Group();
	
	
	public GraphView(Graph<? extends Display> graph) {
		this.g = graph;
		this.setCenter(gr); // center the group
		repaintGraph();
		buttonInformation();
	}

	private void buttonInformation() {
		// TODO Auto-generated method stub
		
	}

	private void repaintGraph() {
		// TODO Auto-generated method stub
		gr.getChildren().clear();
		
		List<? extends Display> vertices = g.getVertices();
		// draw vertices and lable for each vertex
		for(int i = 0; i < vertices.size(); ++i) {
			double x = vertices.get(i).getX();
			double y = vertices.get(i).getY();
			String f = vertices.get(i).getFriend();
			
			gr.getChildren().add(new Circle(x,y,10));
			gr.getChildren().add(new Text(x-15,y-20,f));
		}
		
		// draw edge for pair of vertices
		for(int i = 0; i < g.getSize(); ++i) {
			List<Integer> neighbors = g.getNeighbors(i);
			double x1 = g.getVertex(i).getX();
			double y1 = g.getVertex(i).getY();
			for(int v : neighbors) {
				double x2 = g.getVertex(v).getX();
				double y2 = g.getVertex(v).getY();
				
				gr.getChildren().add(new Line(x1,y1,x2,y2));
			}
		}
	}

	
}
