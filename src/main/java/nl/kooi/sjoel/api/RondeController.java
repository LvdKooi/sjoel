package nl.kooi.sjoel.api;

import lombok.RequiredArgsConstructor;
import nl.kooi.sjoel.domain.RondeService;
import nl.kooi.sjoel.domain.command.GetRonde;
import nl.kooi.sjoel.domain.command.RondeActie;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class RondeController {

    private final RondeService rondeService;

    @GetMapping("/spel/{spelId}/ronde/huidige-rondenummer")
    @ResponseStatus(value = HttpStatus.OK)
    public Integer getCurrentRondenummer(@PathVariable("spelId") int spelId) {
        return rondeService.get(GetRonde.huidigeInSpel(spelId));
    }

    @PostMapping("/spel/{spelId}/ronde/volgende")
    @ResponseStatus(value = HttpStatus.OK)
    public Integer createNextRonde(@PathVariable("spelId") int spelId) {
        rondeService.execute(RondeActie.volgendeRonde(spelId));
        return rondeService.get(GetRonde.huidigeInSpel(spelId));
    }

    @DeleteMapping("/spel/{spelId}/ronde/laatste")
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteLastRonde(@PathVariable("spelId") int spelId) {
        rondeService.execute(RondeActie.verwijderLaatsteRonde(spelId));
    }
}
