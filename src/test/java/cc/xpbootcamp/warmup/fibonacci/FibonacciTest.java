package cc.xpbootcamp.warmup.fibonacci;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class FibonacciTest {

  @Test
  void should_return_1_when_calculate_given_position_is_1() {
    Fibonacci fibonacci = new Fibonacci();

    long result = fibonacci.calculate(1);

    assertThat(result).isEqualTo(1);
  }

  @Test
  void should_return_1_when_calculate_given_position_is_2() {
    Fibonacci fibonacci = new Fibonacci();

    long result = fibonacci.calculate(2);

    assertThat(result).isEqualTo(1);
  }
}
