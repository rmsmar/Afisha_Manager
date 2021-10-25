package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Afisha;

import static org.junit.jupiter.api.Assertions.*;


public class AfishaManagerTest {

    private AfishaManager manager;
    private Afisha item1 = new Afisha(1, "Bloodshot", "action");
    private Afisha item2 = new Afisha(2, "Onward", "cartoon");
    private Afisha item3 = new Afisha(3, "Hotel Belgrad", "comedy");
    private Afisha item4 = new Afisha(4, "The Gentlemen", "action");
    private Afisha item5 = new Afisha(5, "Invisible Man", "horror");
    private Afisha item6 = new Afisha(6, "Trolls. World Tour", "cartoon");
    private Afisha item7 = new Afisha(7, "Star Wars episode 1", "sci-fi");
    private Afisha item8 = new Afisha(8, "Star Wars episode 2", "sci-fi");
    private Afisha item9 = new Afisha(9, "Star Wars episode 3", "sci-fi");
    private Afisha item10 = new Afisha(10, "Star Wars episode 4", "sci-fi");
    private Afisha item11 = new Afisha(11, "Star Wars episode 5", "sci-fi");

    private void fillFirstData() {
        manager.add(item1);
        manager.add(item2);
        manager.add(item3);
        manager.add(item4);
        manager.add(item5);
        manager.add(item6);
        manager.add(item7);
        manager.add(item8);
        manager.add(item9);
        manager.add(item10);
        manager.add(item11);
    }

    @Test
    void getLastLessZeroOutCount() {
        manager = new AfishaManager(-1);
        fillFirstData();

        Afisha[] expected = new Afisha[]{item11, item10, item9, item8, item7, item6, item5, item4, item3, item2};
        Afisha[] actual = manager.getLast();

        assertArrayEquals(expected, actual);
    }

    @Test
    void getLastZeroOutCount() {
        manager = new AfishaManager(0);
        fillFirstData();

        Afisha[] expected = new Afisha[0];
        Afisha[] actual = manager.getLast();

        assertArrayEquals(expected, actual);
    }

    @Test
    void getLastLessOutCount() {
        manager = new AfishaManager();
        manager.add(item1);
        manager.add(item2);
        manager.add(item3);
        manager.add(item4);
        manager.add(item5);

        Afisha[] expected = new Afisha[]{item5, item4, item3, item2, item1};
        Afisha[] actual = manager.getLast();

        assertArrayEquals(expected, actual);
    }

    @Test
    void getLastEqualOutCount() {
        manager = new AfishaManager(11);
        fillFirstData();

        Afisha[] allItems = manager.getAll();
        Afisha[] expected = new Afisha[allItems.length];
        for (int i = 0; i < allItems.length; i++) {
            expected[i] = allItems[allItems.length - i - 1];
        }

        Afisha[] actual = manager.getLast();

        assertArrayEquals(expected, actual);
    }

    @Test
    void getLastMoreOutCount() {
        manager = new AfishaManager(3);
        fillFirstData();

        Afisha[] expected = new Afisha[]{item11, item10, item9};
        Afisha[] actual = manager.getLast();

        assertArrayEquals(expected, actual);
    }

    @Test
    void add() {
        manager = new AfishaManager(5);
        fillFirstData();

        Afisha[] actual = manager.getAll();
        Afisha[] expected = new Afisha[]{item1, item2, item3, item4, item5, item6, item7, item8, item9, item10, item11};

        assertArrayEquals(expected, actual);
    }
}