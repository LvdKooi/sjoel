package nl.kooi.sjoel.api;

import lombok.RequiredArgsConstructor;
import nl.kooi.sjoel.domain.ScoreService;
import nl.kooi.sjoel.domain.command.score.GetScore;
import nl.kooi.sjoel.domain.command.score.SubmitScore;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ScoreController {
    private final ScoreService scoreService;

    @PostMapping("/spel/{spelId}/ronde/{rondenummer}/speler/{spelerId}/score")
    @ResponseStatus(value = HttpStatus.OK)
    public ScoreDto submitPunten(@PathVariable("spelId") int spelId, @PathVariable("rondenummer") int rondenummer, @PathVariable("spelerId") int spelerId, @RequestBody SjoelpuntenDto sjoelpunten) {
       return Mapper.map( scoreService.execute(SubmitScore
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

}
