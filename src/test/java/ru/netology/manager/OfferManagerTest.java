package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.OfferComparator;
import ru.netology.domain.OfferToFly;
import ru.netology.repository.Repository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class OfferManagerTest {
    private Repository repository = new Repository();
    private OfferManager manager = new OfferManager(repository);

    private OfferToFly testOffer1 = new OfferToFly(1, 1300, "MOW", "LED", 100);
    private OfferToFly testOffer2 = new OfferToFly(2, 1200, "MOW", "LED", 120);
    private OfferToFly testOffer3 = new OfferToFly(3, 1100, "MOW", "LED", 130);
    private OfferToFly testOffer4 = new OfferToFly(4, 1400, "LED", "MOW", 140);
    private OfferToFly testOffer5 = new OfferToFly(5, 1600, "MOW", "UFA", 150);
    private OfferToFly testOffer6 = new OfferToFly(6, 1500, "MOW", "UFA", 160);
    private OfferToFly testOffer7 = new OfferToFly(7, 1800, "LED", "UFA", 170);
    private OfferToFly testOffer8 = new OfferToFly(8, 1700, "LED", "UFA", 180);
    private OfferToFly testOffer9 = new OfferToFly(9, 1900, "MOW", "TOF", 190);
    private OfferToFly testOffer10 = new OfferToFly(20, 2000, "MOW", "TOF", 200);

    private OfferToFly offerToAdd = new OfferToFly(999, 999, "XXX", "YYY", 999);

    @BeforeEach
    void SetUp() {
        repository.save(testOffer1);
        repository.save(testOffer2);
        repository.save(testOffer3);
        repository.save(testOffer4);
        repository.save(testOffer5);
        repository.save(testOffer6);
        repository.save(testOffer7);
        repository.save(testOffer8);
        repository.save(testOffer9);
        repository.save(testOffer10);
    }

    @Test
    void shouldAddOffer() {
        manager.add(offerToAdd);
        OfferToFly[] expected = {
                testOffer1,
                testOffer2,
                testOffer3,
                testOffer4,
                testOffer5,
                testOffer6,
                testOffer7,
                testOffer8,
                testOffer9,
                testOffer10,
                offerToAdd
        };

        assertArrayEquals(expected, repository.getAll());
    }

    @Test
    void shouldFindAllFromTo() {
        OfferToFly[] actual = manager.findAllFromTo("MOW","UFA");
        OfferToFly[] expected = {
                testOffer6,
                testOffer5
        };

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindAllSorted() {
        OfferToFly[] actual = manager.findAllFromToSortedBy("LED","MOW", new OfferComparator());
        OfferToFly[] expected = {testOffer4};

        assertArrayEquals(expected, actual);
    }

    void shouldFindAllSorted() {
        OfferToFly[] actual = manager.findAllFromToSortedBy("LED","LED", new OfferComparator());
        OfferToFly[] expected = {};

        assertArrayEquals(expected, actual);
    }
}
