package nl.kooi.sjoel.api;

import lombok.RequiredArgsConstructor;
import nl.kooi.sjoel.api.dto.Mapper;
import nl.kooi.sjoel.api.dto.ScoreDto;
import nl.kooi.sjoel.api.dto.SjoelpuntenDto;
import nl.kooi.sjoel.api.dto.SpelerDto;
import nl.kooi.sjoel.domain.command.score.GetScore;
import nl.kooi.sjoel.domain.command.score.GetTotaalScores;
import nl.kooi.sjoel.domain.command.score.SubmitScore;
import nl.kooi.sjoel.domain.service.ScoreService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class ScoreController {
    private final ScoreService scoreService;

    @PostMapping("/spel/{spelId}/ronde/{rondenummer}/speler/{spelerId}/score")
    @ResponseStatus(value = HttpStatus.OK)
    public ScoreDto submitPunten(@PathVariable("spelId") int spelId, @PathVariable("rondenummer") int rondenummer, @PathVariable("spelerId") int spelerId, @RequestBody SjoelpuntenDto sjoelpunten) {
        return Mapper.map(scoreService.execute(SubmitScore
                .metPunten(Mapper.map(sjoelpunten))
                .spel(spelId)
                .ronde(rondenummer)
                .speler(spelerId)));
    }

    @GetMapping("/spel/{spelId}/ronde/{rondenummer}/speler/{spelerId}/score")
    @ResponseStatus(value = HttpStatus.OK)
    public ScoreDto getScore(@PathVariable("spelId") int spelId, @PathVariable("rondenummer") int rondenummer, @PathVariable("spelerId") int spelerId) {
        return Mapper.map(scoreService.get(
                GetScore
                        .ofSpeler(spelerId)
                        .spel(spelId)
                        .ronde(rondenummer)));
    }

    @GetMapping("/spel/{spelId}/totaal-scores")
    @ResponseStatus(value = HttpStatus.OK)
    public Map<SpelerDto, Integer> getTotaalScores(@PathVariable("spelId") int spelId) {
        var scores = scoreService.get(
                GetTotaalScores
                        .of(spelId));

        return scores.entrySet().stream().collect(Collectors.toMap(e -> Mapper.map(e.getKey()), Map.Entry::getValue));

    }

}
