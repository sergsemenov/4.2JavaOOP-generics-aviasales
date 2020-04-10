package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.OfferToFly;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class OfferToFlyRepositoryTest {
    private Repository repository = new Repository();

    private OfferToFly testoffer1 = new OfferToFly(1, 1100, "MOW", "LED", 100);
    private OfferToFly testoffer2 = new OfferToFly(2, 1200, "MOW", "LED", 120);
    private OfferToFly testoffer3 = new OfferToFly(3, 1300, "LED", "MOW", 130);
    private OfferToFly testoffer4 = new OfferToFly(4, 1400, "LED", "MOW", 140);
    private OfferToFly testoffer5 = new OfferToFly(5, 1500, "MOW", "UFA", 150);
    private OfferToFly testoffer6 = new OfferToFly(6, 1600, "MOW", "UFA", 160);
    private OfferToFly testoffer7 = new OfferToFly(7, 1700, "LED", "UFA", 170);
    private OfferToFly testoffer8 = new OfferToFly(8, 1800, "LED", "UFA", 180);
    private OfferToFly testoffer9 = new OfferToFly(9, 1900, "MOW", "TOF", 190);
    private OfferToFly testoffer10 = new OfferToFly(20, 2000, "MOW", "TOF", 200);

    private OfferToFly offerToAdd = new OfferToFly(999, 999, "XXX", "YYY", 999);

    @BeforeEach
    void SetUp() {
        repository.save(testoffer1);
        repository.save(testoffer2);
        repository.save(testoffer3);
        repository.save(testoffer4);
        repository.save(testoffer5);
        repository.save(testoffer6);
        repository.save(testoffer7);
        repository.save(testoffer8);
        repository.save(testoffer9);
        repository.save(testoffer10);
    }

    @Test
    void shouldSaveAndGetAll() {
        repository.save(offerToAdd);
        OfferToFly[] expected = {
                testoffer1,
                testoffer2,
                testoffer3,
                testoffer4,
                testoffer5,
                testoffer6,
                testoffer7,
                testoffer8,
                testoffer9,
                testoffer10,
                offerToAdd
        };
        OfferToFly[] actual = repository.getAll();
        assertArrayEquals(expected, actual);
    }
}