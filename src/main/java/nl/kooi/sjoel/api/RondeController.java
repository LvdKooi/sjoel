package nl.kooi.sjoel.api;

import lombok.RequiredArgsConstructor;
import nl.kooi.sjoel.domain.RondeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class RondeController {

    private final RondeService rondeService;

    @GetMapping("/spel/{spelId}/ronde/huidige-rondenummer")
    @ResponseStatus(value = HttpStatus.OK)
    public int getCurrentRondenummer(@PathVariable("spelId") int spelId) {
        return rondeService.getHuidigeRondenummer(spelId);
    }

    @PostMapping("/spel/{spelId}/ronde/volgende")
    @ResponseStatus(value = HttpStatus.OK)
    public void createNextRonde(@PathVariable("spelId") int spelId) {
        rondeService.saveVolgendeRonde(spelId);
    }

    @DeleteMapping("/spel/{spelId}/ronde/laatste")
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteLastRonde(@PathVariable("spelId") int spelId) {
        rondeService.deleteLaatsteRonde(spelId);
    }
}
