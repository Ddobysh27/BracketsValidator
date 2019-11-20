
import java.util.ArrayList;

public class ThreadsStart {
  public static void start() {
    ArrayList<MyThread> List = new ArrayList<MyThread>();
    for (int i = 0; i < 1; i++) {
      List.add(new MyThread(i));
    }
    for (int i = 0; i < 1; i++) {
      List.get(i).start();
    }
  }
}