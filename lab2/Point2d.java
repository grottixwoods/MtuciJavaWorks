package lab2;

public class Point2d {
  private double xAxis;
  private double yAxis;

  public Point2d(double x, double y) {
    xAxis = x;
    yAxis = y;
  }

  public Point2d() {
    xAxis = 0;
    yAxis = 0;
  }

  public double getxAxis() {
    return xAxis;
  }

  public void setxAxis(double x) {
    xAxis = x;
  }

  public double getyAxis() {
    return yAxis;
  }

  public void setyAxis(double y) {
    yAxis = y;
  }

  public boolean equals(Point2d point) {
    return xAxis == point.xAxis && yAxis == point.yAxis;
  }

  public double distanceTo(Point2d point) {
    return Math.round(Math.sqrt(Math.pow(point.xAxis - xAxis, 2) + Math.pow(point.yAxis - yAxis, 2)) * 100.0) / 100.0;
  }
}
