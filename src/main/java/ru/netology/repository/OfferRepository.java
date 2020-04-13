package ru.netology.repository;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import ru.netology.domain.Offer;
import ru.netology.exception.NotFoundException;

@AllArgsConstructor
@NoArgsConstructor
public class OfferRepository {
    private Offer[] offers = new Offer[0];

    public void save(Offer offer) {
        int length = offers.length + 1;
        Offer[] tmp = new Offer[length];
        System.arraycopy(offers, 0, tmp, 0, offers.length);
        tmp[tmp.length - 1] = offer;
        offers = tmp;
    }

    public Offer findById(int id) {
        for (Offer offer : offers) {
            if (offer.getId() == id) {
                return offer;
            }
        }
        return null;
    }

    public void removeById(int id) {
        if (findById(id) == null) {
            throw new NotFoundException("Element with id: " + id + " not found!");
        } else {
            int length = offers.length - 1;
            Offer[] tmp = new Offer[length];
            int index = 0;
            for (Offer item : offers) {
                if (item.getId() != id) {
                    tmp[index] = item;
                    index++;
                }
            }
            offers = tmp;
        }
    }

    public Offer[] getAll() {
        return offers;
    }
}
