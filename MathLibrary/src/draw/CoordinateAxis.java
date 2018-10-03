/*******************************************************************************
 * Copyright (C) 2018-2019 Retopall Services
 * For more information please check www.retopall.com
 * RetopMathUtils can not be copied and/or distributed without the express
 * permission of dDev Tech
 ******************************************************************************/

package draw;

import java.awt.Color;
import java.awt.Graphics;

public class CoordinateAxis implements Drawable{
	public static int MARGIN=50;
	private int XAxisReal;
	private int YAxisReal;
	private int defaultXAxis;
	private int defaultYAxis;
	public CoordinateAxis() {
		setDefaultXAxis(MathViewerConstants.WIDTH_SCREEN-MARGIN-2*MARGIN);
		setDefaultYAxis(MathViewerConstants.HEIGHT_SCREEN-MARGIN-2*MARGIN);
		XAxisReal=MathViewerConstants.WIDTH_SCREEN-MARGIN-2*MARGIN;
		YAxisReal=MathViewerConstants.HEIGHT_SCREEN-MARGIN-2*MARGIN;
	}
	public void render(Graphics g) {
		g.setColor(Color.black);
		g.drawLine(MARGIN, MathViewerConstants.HEIGHT_SCREEN-MARGIN, MathViewerConstants.WIDTH_SCREEN-MARGIN, MathViewerConstants.HEIGHT_SCREEN-MARGIN);
		g.drawLine(MARGIN, MathViewerConstants.HEIGHT_SCREEN-MARGIN, MARGIN, MARGIN);
		g.drawString(Integer.toString(XAxisReal), MathViewerConstants.HEIGHT_SCREEN-MARGIN, MathViewerConstants.HEIGHT_SCREEN-MARGIN+10);
		g.drawString(Integer.toString(XAxisReal),MARGIN, MARGIN-10);
	}
	public int getXAxis() {
		return XAxisReal;
	}
	public void setXAxis(int xAxis) {
		XAxisReal = xAxis;
	}
	public int getYAxis() {
		return YAxisReal;
	}
	public void setYAxis(int yAxis) {
		this.YAxisReal = yAxis;
	}
	public int getDefaultYAxis() {
		return defaultYAxis;
	}
	public void setDefaultYAxis(int defaultYAxis) {
		this.defaultYAxis = defaultYAxis;
	}
	public int getDefaultXAxis() {
		return defaultXAxis;
	}
	public void setDefaultXAxis(int defaultXAxis) {
		this.defaultXAxis = defaultXAxis;
	}
	
}