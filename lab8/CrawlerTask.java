package lab8;

import java.util.*;

public class CrawlerTask implements Runnable {
  public URLDepthPair depthPair;

  public URLPool myPool;

  public CrawlerTask(URLPool pool) {
    myPool = pool;
  }
// Выполняет одну задачу в потоке (1 задача которая передается потоку)
  public void run() { // для текущей ссылки в пуле находит все ссылки
    depthPair = myPool.get();

    int myDepth = depthPair.getDepth();

    LinkedList<String> linksList = new LinkedList<String>();
    linksList = Crawler.getAllLinks(depthPair); //Поиск с помощью getAllLinks

    for (String newURL : linksList) {
      URLDepthPair newDepthPair = new URLDepthPair(newURL, myDepth + 1);
      myPool.put(newDepthPair);
    }
  }
}
