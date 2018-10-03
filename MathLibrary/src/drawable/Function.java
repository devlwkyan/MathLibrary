/*******************************************************************************
 * Copyright (C) 2018-2019 Retopall Services
 * For more information please check www.retopall.com
 * RetopMathUtils can not be copied and/or distributed without the express
 * permission of dDev Tech
 ******************************************************************************/

package drawable;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import draw.CoordinateAxis;
import draw.Drawable;
import draw.MathViewerConstants;

public class Function implements Drawable {
	private double[] polynomial;
	private CoordinateAxis axis;
	private BasicStroke stroke;
	public Function(double[] polynomial,CoordinateAxis axis) {
		this.polynomial = polynomial;
		this.axis = axis;
		stroke= new BasicStroke(2f);
	}

	@Override
	public void render(Graphics g) {
		Graphics2D g2=(Graphics2D)g;
		g2.setStroke(stroke);
		g.setColor(Color.black);
		
		int previousX=0;
		int previousY=0;
		for(int i=0;i<axis.getDefaultXAxis();i++) {
			int fx=0;
			for(int j=polynomial.length-1;j>=0;j--) {
				if(j==0) {
					fx+=polynomial[j];
				}else {
					fx+=polynomial[j]*Math.pow(i, j);
				}
			
			}
			int x=CoordinateAxis.MARGIN+i;
			int y=MathViewerConstants.HEIGHT_SCREEN-CoordinateAxis.MARGIN-  fx;
			if(i==0) {
				previousX=x;
				previousY=y;
			}else {
			if(fx>0) {
			g.drawLine(x,y , previousX, previousY);
			previousX=x;
			previousY=y;
			}
			}
		}
		
		
	}
	
}
