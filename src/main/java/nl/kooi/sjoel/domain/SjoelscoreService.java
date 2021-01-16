package nl.kooi.sjoel.domain;

import org.springframework.stereotype.Service;

import javax.validation.Valid;

@Service
public class SjoelscoreService {

    public int getPunten(@Valid Sjoelscore sjoelscore) {
        var laagsteScore = sjoelscore.getScoremap().values().stream().min(Integer::compareTo)
                .orElseThrow();

        var totaalScore = laagsteScore * 20;

        totaalScore += sjoelscore
                .getScoremap()
                .entrySet()
                .stream()
                .mapToInt(entry -> (entry.getValue() - laagsteScore) * entry.getKey()).sum();

        return totaalScore;
    }
}
