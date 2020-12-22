package lab4;

import java.awt.geom.Rectangle2D;

public class Mandelbrot extends FractalGenerator { // Наследуемся от FractalGenerator
  public static final int LIMIT = 2000; //Устанавливаем лимит по количеству итераций не больше 2000

  public void getInitialRange(Rectangle2D.Double range) { // Записываем значение из формулы
    range.x = -2;
    range.y = -1.5;
    range.width = 3;
    range.height = 3;
  }

  public int numIterations(double x, double y) { // Циклический высчитывает комплексные числа фрактала пока не дойдет до лимита с помощью класса Complex Num
    ComplexNum cmplx = new ComplexNum(0, 0);
    int iterator = 0;

    while (iterator < LIMIT && cmplx.getSquaredModule() < 4) {
      cmplx.makeSquaredInPoint(x, y); //Функция по формуле высчитывает комплексные числа

      iterator++;
    }

    if (iterator == LIMIT) return -1;

    return iterator;
  }
}
