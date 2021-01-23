package nl.kooi.sjoel.api;

import lombok.RequiredArgsConstructor;
import nl.kooi.sjoel.domain.SpelerService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

import static nl.kooi.sjoel.api.Mapper.map;

@RestController
@RequiredArgsConstructor
public class SpelerController {
    private final SpelerService spelerService;

    @PostMapping("/spel/{spelId}/speler")
    @ResponseStatus(value = HttpStatus.OK)
    public void saveSpeler(@PathVariable int spelId, @Valid @RequestBody SpelerDto speler) {
        spelerService.addSpelerToSpel(spelId, Mapper.map(speler));
    }

    @PutMapping("/spel/{spelId}/speler/{spelerId}")
    @ResponseStatus(value = HttpStatus.OK)
    public void updateSpeler(@PathVariable("spelId") int spelId, @PathVariable("spelerId") int spelerId, @RequestBody SpelerDto speler) {
        spelerService.getSpelerBySpelIdAndSpelerId(spelId, spelerId);
        speler.setId(spelerId);
        spelerService.addSpelerToSpel(spelId, map(speler));
    }

    @GetMapping("/spel/{spelId}/speler/{spelerId}")
    @ResponseStatus(value = HttpStatus.OK)
    public SpelerDto getSpeler(@PathVariable("spelId") int spelId, @PathVariable("spelerId") int spelerId) {
        return map(spelerService.getSpelerBySpelIdAndSpelerId(spelId, spelerId));
    }

    @GetMapping("/spel/{spelId}/speler")
    @ResponseStatus(value = HttpStatus.OK)
    public List<SpelerDto> getSpelers(@PathVariable("spelId") int spelId) {
        return spelerService.getSpelersBySpelId(spelId).stream().map(Mapper::map).collect(Collectors.toList());
    }

}
