package lab2;

public class Point3d extends Point2d {
  private double zAxis;

  public Point3d(double x, double y, double z) {
    super(x, y);
    zAxis = z;
  }

  public Point3d() {
    super();
    zAxis = 0;
  }

  public double getzAxis() {
    return zAxis;
  }

  public void setzAxis(double z) {
    zAxis = z;
  }

  public boolean equals(Point3d point) {
    return getxAxis() == point.getxAxis() && getyAxis() == point.getyAxis() && zAxis == point.zAxis;
  }

  public double distanceTo(Point3d point) {
    return Math.round(Math.sqrt(Math.pow(point.getxAxis() - getxAxis(), 2) + Math.pow(point.getyAxis() - getyAxis(), 2) + Math.pow(point.zAxis - zAxis, 2)) * 100.0) / 100.0;
  }
}
