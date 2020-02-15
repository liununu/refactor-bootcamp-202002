package cc.xpbootcamp.warmup.fibonacci;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class FibonacciTest {
  private Fibonacci fibonacci = new Fibonacci();

  @Test
  void should_return_1_when_calculate_given_position_is_1() {
    long result = fibonacci.calculate(1);

    assertThat(result).isEqualTo(1);
  }

  @Test
  void should_return_1_when_calculate_given_position_is_2() {
    long result = fibonacci.calculate(2);

    assertThat(result).isEqualTo(1);
  }

  @Test
  void should_return_2_when_calculate_given_position_is_3() {
    long result = fibonacci.calculate(3);

    assertThat(result).isEqualTo(2);
  }
}
