package cc.xpbootcamp.warmup.fibonacci;

import cc.xpbootcamp.warmup.fibonacci.exception.PositionOutOfBoundsException;

public class Fibonacci {

  private static final int MIN_POSITION = 1;
  private static final int MAX_POSITION = 50;

  public long calculate(int position) {
    if (isPositionOutOfBounds(position)) {
      throw new PositionOutOfBoundsException();
    }
    if (isFirstOrSecondPosition(position)) {
      return 1;
    }
    return calculate(position - 2) + calculate(position - 1);
  }

  private boolean isPositionOutOfBounds(int position) {
    return position < MIN_POSITION || position > MAX_POSITION;
  }

  private boolean isFirstOrSecondPosition(int position) {
    return position == 1 || position == 2;
  }
}
