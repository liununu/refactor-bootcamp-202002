package cc.xpbootcamp.warmup.fibonacci;

public class Fibonacci {

  public long calculate(int position) {
    if (position == 1) {
      return 1;
    }
    if (position == 2) {
      return 1;
    }
    if (position == 3) {
      return calculate(1) + calculate(2);
    }
    return 0;
  }
}
