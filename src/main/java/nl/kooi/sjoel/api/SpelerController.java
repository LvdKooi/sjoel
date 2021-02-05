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

    @PostMapping("/speler")
    @ResponseStatus(value = HttpStatus.OK)
    public SpelerDto saveSpeler( @Valid @RequestBody SpelerDto speler) {
        return Mapper.map(spelerService.saveSpeler(Mapper.map(speler)));
    }

    @PutMapping("speler/{spelerId}")
    @ResponseStatus(value = HttpStatus.OK)
    public SpelerDto updateSpeler(@PathVariable("spelerId") int spelerId, @RequestBody SpelerDto speler) {
        spelerService.findSpelerById( spelerId);
        speler.setId(spelerId);
        return Mapper.map(spelerService.saveSpeler(Mapper.map(speler)));
    }

    @GetMapping("speler/{spelerId}")
    @ResponseStatus(value = HttpStatus.OK)
    public SpelerDto getSpeler(@PathVariable("spelerId") int spelerId) {
        return map(spelerService.findSpelerById(spelerId));
    }

    @GetMapping("/speler")
    @ResponseStatus(value = HttpStatus.OK)
    public List<SpelerDto> getSpelers() {
        return spelerService.getSpelers().stream().map(Mapper::map).collect(Collectors.toList());
    }

}
