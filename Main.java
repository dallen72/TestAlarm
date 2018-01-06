
public class Main {
  public static void main(String[] args) {
    String str_arg = args[0];
    int secsPerQuestion = Integer.parseInt(str_arg);
    new Alarm(secsPerQuestion);
  }
}
