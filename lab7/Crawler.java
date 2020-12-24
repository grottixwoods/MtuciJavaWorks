package lab7;

import java.io.*;
import java.net.Socket;
import java.net.URL;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Crawler { // Выполнение основной логки
  public LinkedList<UrlDepthPair> proccessed; // Поле хранение всех ссылок

  public Crawler() {
    proccessed = new LinkedList<>();
  } //Связанный список

  public void startParsing(URL baseUrl, int maxDepth, int currentDepth) { // выполнение синтаксичечкого анализа сайта (парсинга) по изначальной ссылки

    if (currentDepth > maxDepth) return;

    LinkedList<UrlDepthPair> links = getAllLinks(baseUrl, currentDepth); // Вызывает метод getAllLinks

    for (UrlDepthPair link: links) {
      startParsing(link.realUrl, maxDepth, currentDepth + 1); //цикл проходит по уровням сайта и находит ссылки по очереди
    }

    proccessed.addAll(links); // Происходит запись в поле
  }

  private static LinkedList<UrlDepthPair> getAllLinks(URL url, int depth) { //
    try {
      LinkedList<UrlDepthPair> links = new LinkedList<>();

      int port = 80; // Обьявляем порт
      String hostname = url.getHost();

      Socket socket = new Socket(hostname, port); //Создаем сокет , чтобы установить  соединение
      socket.setSoTimeout(3000); // Определяем таймаут сокета

      OutputStream outStream = socket.getOutputStream(); //Получение потока из сокета

      PrintWriter writer = new PrintWriter(outStream, true);

      if (url.getPath().length() == 0) { //Htp заголовки для корректного запроса
        writer.println("GET / HTTP/1.1");
        writer.println("Host: " + hostname);
        writer.println("Accept: text/html");
        writer.println("Accept-Language: en,en-US;q=0.9,ru;q=0.8");
        writer.println("Connection: close");
        writer.println();
      }
      else {
        writer.println("GET " + url.getPath() + " HTTP/1.1");
        writer.println("Host: " + hostname);
        writer.println("Accept: text/html");
        writer.println("Accept-Language: en,en-US;q=0.9,ru;q=0.8");
        writer.println("Connection: close");
        writer.println();
      }

      InputStream input = socket.getInputStream(); //Отправляем потока на сервер
      BufferedReader reader = new BufferedReader(new InputStreamReader(input));

      String htmlLine;//для чтения как строки

      Pattern patternURL = Pattern.compile( //Выполнения поиска ссылок
              "(href=\"http|href=\"https)://([\\w_-]+(?:(?:\\.[\\w_-]+)+))([\\w.,@?^=%&:/~+#-]*[\\w@?^=%&/~+#-])?" //Парсинг строки
      );

      while ((htmlLine = reader.readLine()) != null) {
        Matcher matcherURL = patternURL.matcher(htmlLine); // Matcher по заданному циклу парсит сайт
        while (matcherURL.find()) {
          String link = htmlLine.substring(matcherURL.start() + 6,
                  matcherURL.end());

          links.add(new UrlDepthPair(link, depth));
//                    if (links.size() >= 10) return links;
        }
      }
      socket.close(); // Закрываем цикл

      return links; //Возвращение ссылок в Дин Массив
    } catch (Exception e) {
      System.out.print(e.getMessage());
      System.out.print(Arrays.toString(e.getStackTrace()));

      return new LinkedList<>();
    }
  }
}
