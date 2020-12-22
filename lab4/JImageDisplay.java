package lab4;

import javax.swing.JComponent;
import java.awt.*;
import java.awt.image.BufferedImage;

public class JImageDisplay extends JComponent { // Наследуемся по заданию от JComponent
  private final BufferedImage image; //Приватное поле , картинка которая будет воспроизводится

  public JImageDisplay(int w, int h){ //Конструрктор принимает целочисленное ширины и высоты
    if (w <= 0)                        // инициализирует обьект BufferedImage новым изображением с н Ш. и В.
      throw new IllegalArgumentException("w must be > 0; got " + w);

    if (h <= 0)
      throw new IllegalArgumentException("h must be > 0; got " + h);

    image = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB); // RGB - 8 бит в формате int в указанном порядке
    Dimension dimension = new Dimension(w, h);

    super.setPreferredSize(dimension);
  }

  @Override // Инкапсуляция. Переопределяем метод базового класса Graphics
  protected void paintComponent(Graphics g) { //Рисует картинку из приватного поля по Ш и В.
    super.paintComponent(g); // Супрекласс paintComponent(g) , класс производным от котого является текущий класс (Дочерический класс)

    g.drawImage (image, 0, 0, image.getWidth(), image.getHeight(), null);
  }

  public void clearImage() { // Очистка значений
    Graphics2D imageGraphics = image.createGraphics();
    imageGraphics.setColor(new Color(0, 0, 0));

    imageGraphics.fillRect(0, 0, image.getWidth(), image.getHeight());
  }

  public void drawPixel (int x, int y, int rgbColor){ // Этот метод принимает координаты и цвет , после чего закрашивает пискели
    image.setRGB(x, y, rgbColor);
  }
}
