package com.text.algebra;

public class PointOrientation {

	public static int orientation(Point p1, Point p2, Point p3) {
		int val = (p2.y - p1.y) * (p3.x - p2.x) - (p2.x - p1.x) * (p3.y - p2.y);

		if (val == 0)
			return 0; // collinear

		// clock or counterclock wise
		return (val > 0) ? 1 : 2;
	}

	public static void main(String[] args) {
		Point p1 = new Point(0, 0);
		Point p2 = new Point(4, 4);
		Point p3 = new Point(1,1);

		int o = orientation(p1, p2, p3);

		if (o == 0)
			System.out.print("Linear");
		else if (o == 1)
			System.out.print("Clockwise");
		else
			System.out.print("CounterClockwise");
	}
}
