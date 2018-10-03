/*******************************************************************************
 * Copyright (C) 2018-2019 Retopall Services
 * For more information please check www.retopall.com
 * RetopMathUtils can not be copied and/or distributed without the express
 * permission of dDev Tech
 ******************************************************************************/

package draw;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

import drawable.Function;
import drawable.GraphicalPoint;
import stadistic.Data;
import stadistic.Dataset;

public class Canvas extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Thread render;
	private Graphics g;
	private CoordinateAxis axis;
	private ArrayList<GraphicalPoint> points = new ArrayList<>();
	private ArrayList<Function> functions = new ArrayList<>();
	public Canvas() {
		this.setBackground(Color.white);
		render = new Thread(new Runnable() {

			@Override
			public void run() {
				render(g);

			}
		});
		setup();
	}

	public void setup() {
		axis = new CoordinateAxis();
	}

	public void paint(Graphics g) {
		super.paint(g);
		this.g = g;
		render.run();
		repaint();
	}

	public void render(Graphics g) {
		axis.render(g);
		for (GraphicalPoint point : points) {
			point.render(g);
		}
		for (Function function : functions) {
			function.render(g);
		}
	}

	/**
	 * Add data and resize the value of each point depending on the max value of the
	 * dataset
	 * 
	 * @param dataset
	 */
	public void addDataset(Dataset dataset) {
		ArrayList<Data> data = dataset.getDataset();
		int maxX = 0;
		int maxY = 0;
		for (int i = 0; i < data.size(); i++) {
			maxX = (int) Math.max(data.get(i).getX(), maxX);
			maxY = (int) Math.max(data.get(i).getY(), maxY);
		}
	
		if(maxX>axis.getXAxis()) {
			axis.setXAxis(maxX);
		}
		if(maxY>axis.getYAxis()) {
			axis.setYAxis(maxY);
		}
		for(int i=0;i<data.size();i++) {
			points.add(new GraphicalPoint(dataset.get(i).getX(),dataset.get(i).getY(),axis));
		}
	}

	public void addPoint(double x, double y) {
		points.add(new GraphicalPoint(x + CoordinateAxis.MARGIN,
				MathViewerConstants.HEIGHT_SCREEN - y - CoordinateAxis.MARGIN,axis));
	}
	public void addFunction(double[]polynomialValues) {
		Function f = new Function(polynomialValues, axis);
		functions.add(f);
	}
	public void removePoint(GraphicalPoint p) {
		points.remove(p);
	}

	public void clearCanvas() {
		points.clear();
	}
}
