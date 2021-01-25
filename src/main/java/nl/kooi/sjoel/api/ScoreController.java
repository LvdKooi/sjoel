package nl.kooi.sjoel.api;

import lombok.RequiredArgsConstructor;
import nl.kooi.sjoel.domain.ScoreService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class ScoreController {
    private final ScoreService scoreService;

    @PostMapping("/spel/{spelId}/ronde/{rondenummer}/speler/{spelerId}/score")
    @ResponseStatus(value = HttpStatus.OK)
    public void submitPunten(@PathVariable("spelId") int spelId, @PathVariable("rondenummer") int rondenummer, @PathVariable("spelerId") int spelerId, @RequestBody SjoelpuntenDto sjoelpunten) {
        scoreService.submitPunten(spelerId, spelId, rondenummer, Mapper.map(sjoelpunten));
    }

    @GetMapping("/spel/{spelId}/ronde/{rondenummer}/speler/{spelerId}/score")
    @ResponseStatus(value = HttpStatus.OK)
    public ScoreDto getScore(@PathVariable("spelId") int spelId, @PathVariable("rondenummer") int rondenummer, @PathVariable("spelerId") int spelerId) {
        return Mapper.map(scoreService.getScore(spelerId, spelId, rondenummer));
    }
}
