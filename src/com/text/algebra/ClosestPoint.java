package com.text.algebra;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Comparator;

public class ClosestPoint {

	static class PointXComparator implements Comparator<Point> {

		@Override
		public int compare(Point pointA, Point pointB) {
			return Integer.compare(pointA.x, pointB.x);
		}

	}

	static class PointYComparator implements Comparator<Point> {

		@Override
		public int compare(Point pointA, Point pointB) {
			return Integer.compare(pointA.y, pointB.y);
		}

	}

	public static float dist(Point p1, Point p2) {
		return (float) Math.sqrt((p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y));
	}

	public static float bruteForce(Point[] P, int n) {

		float min = Float.MAX_VALUE;
		float currMin = 0;
		for (int i = 0; i < n; ++i) {
			for (int j = i + 1; j < n; ++j) {
				currMin = dist(P[i], P[j]);
				if (currMin < min) {
					min = currMin;
				}
			}
		}
		return currMin;
	}

	public static float closestUtil(Point[] P, int startIndex, int endIndex) {
		if (endIndex - startIndex <= 3)
			return bruteForce(P, endIndex);

		int mid = startIndex + (endIndex - startIndex) / 2;
		Point midPoint = P[mid];
		float dl = closestUtil(P, startIndex, mid);
		float dr = closestUtil(P, mid + 1, endIndex);

		float d = Math.min(dl, dr);

		Point[] strip = new Point[endIndex];
		int j = 0;
		for (int i = startIndex; i < endIndex; i++) {
			if (Math.abs(P[i].x - midPoint.x) < d) {
				strip[j] = P[i];
				j++;
			}
		}
		return Math.min(d, stripClosest(strip, j, d));
	}

	public static float stripClosest(Point[] strip, int size, float d) {
		float min = d; // Initialize the minimum distance as d

		Arrays.sort(strip, 0, size, new PointYComparator());

		// Pick all points one by one and try the next points till the difference
		// between y coordinates is smaller than d.
		// This is a proven fact that this loop runs at most 6 times
		for (int i = 0; i < size; ++i) {
			for (int j = i + 1; j < size && (strip[j].y - strip[i].y) < min; ++j) {
				if (dist(strip[i], strip[j]) < min) {
					min = dist(strip[i], strip[j]);
				}
			}
		}
		return min;
	}

	public static float closest(Point[] P, int n) {
		Arrays.sort(P, 0, n, new PointXComparator());
		return closestUtil(P, 0, n);
	}

	public static void main(String[] args) {
		Point[] P = new Point[] { new Point(2, 3), new Point(12, 30), new Point(40, 50), new Point(5, 1),
				new Point(12, 10), new Point(3, 4)

		};
		DecimalFormat df = new DecimalFormat("#.######");
		System.out.println("The smallest distance is " + df.format(ClosestPoint.closest(P, P.length)));
	}
}
