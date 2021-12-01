package by.itrex.wirehouse.util;

public class DistanceCalculator {

  private DistanceCalculator() {
  }

  //https://www.geeksforgeeks.org/program-distance-two-points-earth/
  public static double calculate(double sourceLat, double sourceLon, double destinationLat, double destinationLon) {
    // The math module contains a function
    // named toRadians which converts from
    // degrees to radians.
    sourceLon = Math.toRadians(sourceLon);
    destinationLon = Math.toRadians(destinationLon);
    sourceLat = Math.toRadians(sourceLat);
    destinationLat = Math.toRadians(destinationLat);

    // Haversine formula
    double dlon = destinationLon - sourceLon;
    double dlat = destinationLat - sourceLat;
    double a = Math.pow(Math.sin(dlat / 2), 2)
        + Math.cos(sourceLat) * Math.cos(destinationLat)
        * Math.pow(Math.sin(dlon / 2), 2);

    double c = 2 * Math.asin(Math.sqrt(a));

    // Radius of earth in kilometers. Use 3956
    // for miles
    double r = 6371;

    // calculate the result
    return (c * r);
  }

}
