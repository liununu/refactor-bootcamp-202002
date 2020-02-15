package cc.xpbootcamp.warmup.fibonacci;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import cc.xpbootcamp.warmup.fibonacci.exception.PositionOutOfBoundsException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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

  @Test
  void should_return_3_when_calculate_given_position_is_4() {
    long result = fibonacci.calculate(4);

    assertThat(result).isEqualTo(3);
  }

  @Test
  void should_return_12586269025_when_calculate_given_position_is_50() {
    long result = fibonacci.calculate(50);

    assertThat(result).isEqualTo(12586269025L);
  }

  @ParameterizedTest
  @ValueSource(ints = {51, 100, 300})
  void should_throw_position_out_of_bounds_exception_when_calculate_given_position_is_over_50(
      int over50Position) {
    assertThatExceptionOfType(PositionOutOfBoundsException.class)
        .isThrownBy(() -> fibonacci.calculate(over50Position));
  }

  @ParameterizedTest
  @ValueSource(ints = {0, -50, -100})
  void should_throw_position_out_of_bounds_exception_when_calculate_given_position_is_below_1(
      int below1Position) {
    assertThatExceptionOfType(PositionOutOfBoundsException.class)
        .isThrownBy(() -> fibonacci.calculate(below1Position));
  }
}
