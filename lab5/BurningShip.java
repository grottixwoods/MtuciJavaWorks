package lab5;

import java.awt.geom.Rectangle2D;
// Все то же самое что и в 4лр , только вызывает другой метод Complex Num
public class BurningShip extends FractalGenerator {
  public static final int LIMIT = 2000;

  public void getInitialRange(Rectangle2D.Double range) { // Значение из методички
    range.x = -2;
    range.y = -2.5;
    range.width = 4;
    range.height = 4;
  }

  public int numIterations(double x, double y) {
    ComplexNum cmplx = new ComplexNum(0, 0);
    int iterator = 0;

    while (iterator < LIMIT && cmplx.getSquaredModule() < 4) {
      cmplx.makeSquaredWithAbsInPoint(x, y); //другой метод Complex Num , который высчитывает числа

      iterator++;
    }

    if (iterator == LIMIT) return -1;

    return iterator;
  }

  @Override
  public String toString() { return "Burning Ship"; }
}
