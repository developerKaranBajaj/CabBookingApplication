package com.cab.cabbookingapplication.util;

public class DistanceUtil {
    public static boolean isInsideArea(double x1, double y1, double x2, double y2, int dist) {
        return Math.sqrt(Math.pow(x2-x1,2) + Math.pow(y2-y1,2)) <= dist;
    }

    public static double calculateDistance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2-x1,2) + Math.pow(y2-y1,2));
    }
}
