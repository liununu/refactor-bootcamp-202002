package cc.xpbootcamp.warmup.cashier;

import mockit.Mock;
import mockit.MockUp;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

public class MockLocalDateTime {

    public static void mockWednesday() {
        mockLocalDateTime(Clock.fixed(Instant.parse("2020-02-19T10:15:30.00Z"), ZoneId.of("UTC")));
    }

    public static void mockNotWednesday() {
        mockLocalDateTime(Clock.fixed(Instant.parse("2020-02-17T10:15:30.00Z"), ZoneId.of("UTC")));
    }

    public static void resetMockDate() {
        mockLocalDateTime(Clock.systemDefaultZone());
    }

    private static void mockLocalDateTime(Clock clock) {
        new MockUp<LocalDate>() {
            @Mock
            public LocalDate now() {
                return LocalDate.now(clock);
            }
        };
    }
}
