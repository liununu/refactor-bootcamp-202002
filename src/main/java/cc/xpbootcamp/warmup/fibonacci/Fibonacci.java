package cc.xpbootcamp.warmup.fibonacci;

import cc.xpbootcamp.warmup.fibonacci.exception.PositionOutOfBoundsException;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {

  private static final int MIN_POSITION = 1;
  private static final int MAX_POSITION = 50;
  private static final Map<Integer, Long> fibonacciResultCacheMap = new HashMap<>();

  public long calculate(int position) {
    if (isPositionOutOfBounds(position)) {
      throw new PositionOutOfBoundsException();
    }
    if (isFirstOrSecondPosition(position)) {
      return 1;
    }
    return fibonacciResultCacheMap.computeIfAbsent(
        position, key -> calculate(key - 1) + calculate(key - 2));
  }

  private boolean isPositionOutOfBounds(int position) {
    return position < MIN_POSITION || position > MAX_POSITION;
  }

  private boolean isFirstOrSecondPosition(int position) {
    return position == 1 || position == 2;
  }
}
