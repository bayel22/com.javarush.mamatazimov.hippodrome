import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class HorseTest {

    private Horse horse;

    @Test
    void throwsExceptionWithMessageWhenNameIsNull() {
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> new Horse(null, 1, 1));
        assertEquals("Name cannot be null.", illegalArgumentException.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "\t", "\n", "\t\n", "\r"})
    void throwsExceptionWhenNameIsNullOrWhitespaceSymbols(String message) {
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> new Horse(message, -1, -1));
        assertEquals("Name cannot be blank.", illegalArgumentException.getMessage());
    }

    @Test
    void throwsExceptionWhenSpeedIsNegative() {
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> new Horse("horse", -1, 1));
        assertEquals("Speed cannot be negative.", illegalArgumentException.getMessage());
    }

    @Test
    void throwsExceptionWhenDistanceIsNegative() {
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> new Horse("horse", 1, -1));
        assertEquals("Distance cannot be negative.", illegalArgumentException.getMessage());
    }

    @Test
    void getName() {
        horse = new Horse("Horse", 1,1);
        assertEquals("Horse", horse.getName());
    }

    @Test
    void getSpeed() {
        horse = new Horse("Horse", 20,1);
        assertEquals(20, horse.getSpeed());
    }

    @Test
    void getDistance() {
        horse = new Horse("Horse", 1,1);
        assertEquals(1, horse.getDistance());
    }

    @Test
    void move() {

    }

    @Test
    void getRandomDouble() {
    }
}