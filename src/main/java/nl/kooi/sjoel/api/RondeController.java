package nl.kooi.sjoel.api;

import lombok.RequiredArgsConstructor;
import nl.kooi.sjoel.api.dto.Mapper;
import nl.kooi.sjoel.api.dto.RondeDto;
import nl.kooi.sjoel.domain.command.ronde.GetRonde;
import nl.kooi.sjoel.domain.command.ronde.GetRondes;
import nl.kooi.sjoel.domain.command.ronde.RondeActie;
import nl.kooi.sjoel.domain.service.RondeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class RondeController {

    private final RondeService rondeService;

    @GetMapping("/spel/{spelId}/ronde/huidige-rondenummer")
    @ResponseStatus(value = HttpStatus.OK)
    public Integer getCurrentRondenummer(@PathVariable("spelId") int spelId) {
        return rondeService.get(GetRonde.huidigeInSpel(spelId)).getRondenummer();
    }

    @GetMapping("/spel/{spelId}/ronde")
    @ResponseStatus(value = HttpStatus.OK)
    public List<RondeDto> getRondesOfGame(@PathVariable("spelId") int spelId) {
        return rondeService.get(GetRondes.of(spelId)).stream().map(Mapper::map).collect(Collectors.toList());
    }

    @PostMapping("/spel/{spelId}/ronde/volgende")
    @ResponseStatus(value = HttpStatus.OK)
    public RondeDto createNextRonde(@PathVariable("spelId") int spelId) {
        rondeService.execute(RondeActie.volgendeRonde(spelId));
        return Mapper.map(rondeService.get(GetRonde.huidigeInSpel(spelId)));
    }

    @DeleteMapping("/spel/{spelId}/ronde/laatste")
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteLastRonde(@PathVariable("spelId") int spelId) {
        rondeService.execute(RondeActie.verwijderLaatsteRonde(spelId));
    }
}
