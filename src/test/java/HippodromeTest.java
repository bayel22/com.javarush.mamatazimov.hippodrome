import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class HippodromeTest {

    @Test
    void throwsExceptionWithMessageWhenListIsNull() {
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> new Hippodrome(null));
        assertEquals("Horses cannot be null.", illegalArgumentException.getMessage());
    }

    @Test
    void throwsExceptionWithMessageWhenKListIsEmpty() {
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> new Hippodrome(new ArrayList<>()));
        assertEquals("Horses cannot be empty.", illegalArgumentException.getMessage());
    }


    @Test
    void getHorses() {
        List<Horse> horses = new ArrayList<>();
        for (int i = 1; i <= 30; i++) {
            horses.add(new Horse("h"+i,i,i));
        }
        Hippodrome hippodrome = new Hippodrome(horses);
        assertEquals(horses, hippodrome.getHorses());
    }

    @Test
    void move() {
        List<Horse> horses = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            horses.add(mock(Horse.class));
        }
        new Hippodrome(horses).move();

        for (Horse horse : horses) {
            verify(horse).move();
        }
    }


    @Test
    void getWinner() {
        Horse horse1 = new Horse("h1",1,1);
        Horse horse2 = new Horse("h2",1,2);
        Horse horse3 = new Horse("h3",1,3);
        Horse horse4 = new Horse("h4",1,4);
        Hippodrome hippodrome = new Hippodrome(List.of(horse1, horse2, horse3, horse4));

        assertSame(horse4, hippodrome.getWinner());

    }
}