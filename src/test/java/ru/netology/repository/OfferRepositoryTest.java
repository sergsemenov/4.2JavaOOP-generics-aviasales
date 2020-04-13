package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Offer;
import ru.netology.exception.NotFoundException;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class OfferRepositoryTest {
    private OfferRepository repository = new OfferRepository();

    private Offer testOffer1 = new Offer(1, 1100, "MOW", "LED", 100);
    private Offer testOffer2 = new Offer(2, 1200, "MOW", "LED", 120);
    private Offer testOffer3 = new Offer(3, 1300, "LED", "MOW", 130);
    private Offer testOffer4 = new Offer(4, 1400, "LED", "MOW", 140);
    private Offer testOffer5 = new Offer(5, 1500, "MOW", "UFA", 150);
    private Offer testOffer6 = new Offer(6, 1600, "MOW", "UFA", 160);
    private Offer testOffer7 = new Offer(7, 1700, "LED", "UFA", 170);
    private Offer testOffer8 = new Offer(8, 1800, "LED", "UFA", 180);
    private Offer testOffer9 = new Offer(9, 1900, "MOW", "TOF", 190);
    private Offer testOffer10 = new Offer(20, 2000, "MOW", "TOF", 200);

    private Offer offerToAdd = new Offer(999, 999, "XXX", "YYY", 999);

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
    void shouldSaveAndGetAll() {
        repository.save(offerToAdd);
        Offer[] expected = {
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
        Offer[] actual = repository.getAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRemoveByIdPositive() {
        repository.removeById(1);
        Offer[] actual = repository.getAll();
        Offer[] expected = {
                testOffer2,
                testOffer3,
                testOffer4,
                testOffer5,
                testOffer6,
                testOffer7,
                testOffer8,
                testOffer9,
                testOffer10
        };

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRemoveByIdNegative() {
        assertThrows(NotFoundException.class, () -> repository.removeById(11111));
    }
}
