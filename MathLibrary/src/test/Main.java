/*******************************************************************************
 * Copyright (C) 2018-2019 Retopall Services
 * For more information please check www.retopall.com
 * RetopMathUtils can not be copied and/or distributed without the express
 * permission of dDev Tech
 ******************************************************************************/
package test;


import java.util.ArrayList;

import draw.MathViewer;
import stadistic.Dataset;
import stadistic.Regression;
import stadistic.Stadistic;
import utils.equations.EquationData;
import utils.equations.Solver;
import utils.matrix.Matrix;
import utils.vector.Vector;

public class Main {

	public static void main(String[] args) {
		double[][]values= {{1,1,1,-1},{1,1,-1,1},{1,-1,1,1},{-1,1,1,1}};
		double []outputsX= {49,69,89,99,109,20};
		double []outputsY= {124,95,36,45,55,30};
//		double []outputsY1= {124,45,71,45,18,30};
//		double []outputsY2= {16,95,71,45,18,30};
//		ArrayList<EquationData>data = new ArrayList<>();
//		
//			data.add(new EquationData(outputsX));
//			data.add(new EquationData(outputsY));
//			data.add(new EquationData(outputsY2));
//			data.add(new EquationData(outputsY2));
//		Solver.solver(data);
		MathViewer viewer= new MathViewer(600, 600);
	
		double solutions[]=Regression.executePolynomialRegression(outputsX, outputsY, 4);
		viewer.draw().addDataset(Dataset.arrayToDataset(outputsX, outputsY));
		viewer.draw().addFunction(solutions);
	}

}
