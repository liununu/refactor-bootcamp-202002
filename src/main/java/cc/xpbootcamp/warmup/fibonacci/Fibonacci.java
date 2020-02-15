package cc.xpbootcamp.warmup.fibonacci;

import cc.xpbootcamp.warmup.fibonacci.exception.OutOfPositionException;

public class Fibonacci {

  private static final int MAX_POSITION = 50;

  public long calculate(int position) {
    if (position > MAX_POSITION) {
      throw new OutOfPositionException();
    }
    if (position == 1 || position == 2) {
      return 1;
    }
    return calculate(position - 2) + calculate(position - 1);
  }
}
