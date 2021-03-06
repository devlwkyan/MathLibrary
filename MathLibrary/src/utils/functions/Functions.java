/*******************************************************************************
 * Copyright (C) 2018-2019 Retopall Services
 * For more information please check www.retopall.com
 * RetopMathUtils can not be copied and/or distributed without the express
 * permission of dDev Tech
 ******************************************************************************/

package utils.functions;

public class Functions {
	public static double sigmoidFunction(double x) {
		return 1/(1+Math.pow(Math.E,x));
	}
	public static double hypTanh(double x) {
		return Math.tanh(x);
	}
}
