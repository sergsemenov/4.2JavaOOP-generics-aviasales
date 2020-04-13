package ru.netology.manager;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.netology.domain.Offer;
import ru.netology.repository.OfferRepository;

import java.util.Arrays;
import java.util.Comparator;

@AllArgsConstructor
@Data
public class OfferManager {
    private OfferRepository repository;

    public void add(Offer offer) {
        repository.save(offer);
    }

    public Offer[] findAllFromTo(String from, String to) {
        Offer[] result = new Offer[0];
        for (Offer offer : repository.getAll()) {
            int length = result.length;
            if (offer.getDeparture().equals(from) && offer.getArrival().equals(to)) {
                Offer[] tmp = new Offer[length + 1];
                System.arraycopy(result, 0, tmp, 0, length);
                int lastIndex = tmp.length - 1;
                tmp[lastIndex] = offer;
                result = tmp;
            }
        }
        if (result.length > 1) {
            Arrays.sort(result);
        }
        return result;
    }

    public Offer[] findAllFromToSortedBy(String from, String to, Comparator<Offer> comparator) {
        Offer[] result = new Offer[0];
        for (Offer offer : repository.getAll()) {
            int length = result.length;
            if (offer.getDeparture().equals(from) && offer.getArrival().equals(to)) {
                Offer[] tmp = new Offer[length + 1];
                System.arraycopy(result, 0, tmp, 0, length);
                int lastIndex = tmp.length - 1;
                tmp[lastIndex] = offer;
                result = tmp;
            }
        }
        Arrays.sort(result, comparator);
        return result;
    }
}
