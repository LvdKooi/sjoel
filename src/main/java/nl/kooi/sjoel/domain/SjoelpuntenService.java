package nl.kooi.sjoel.domain;

import org.springframework.stereotype.Service;

import javax.validation.Valid;

@Service
public class SjoelpuntenService {

    public int getPunten(@Valid Sjoelpunten sjoelpunten) {

        var laagsteScore = sjoelpunten.getScoremap().values()
                .stream()
                .min(Integer::compareTo)
                .orElseThrow();

        var totaalScore = laagsteScore * 20;

        totaalScore += sjoelpunten
                .getScoremap()
                .entrySet()
                .stream()
                .mapToInt(entry -> (entry.getValue() - laagsteScore) * entry.getKey()).sum();

        return totaalScore;
    }
}
