package nl.kooi.sjoel.api;

import lombok.RequiredArgsConstructor;
import nl.kooi.sjoel.api.dto.SpelerDto;
import nl.kooi.sjoel.domain.SpelerService;
import nl.kooi.sjoel.domain.command.speler.GetSpeler;
import nl.kooi.sjoel.domain.command.speler.GetSpelers;
import nl.kooi.sjoel.domain.command.speler.SpelerActie;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class SpelerController {
    private final SpelerService spelerService;

    @PostMapping("/speler")
    @ResponseStatus(value = HttpStatus.OK)
    public SpelerDto saveSpeler(@Valid @RequestBody SpelerDto speler) {
        return Mapper.map(spelerService.execute(SpelerActie.voegNieuweSpelerToe(Mapper.map(speler))));
    }

    @PutMapping("speler/{spelerId}")
    @ResponseStatus(value = HttpStatus.OK)
    public SpelerDto updateSpeler(@PathVariable("spelerId") int spelerId, @RequestBody SpelerDto speler) {
        return Mapper.map(spelerService.execute(SpelerActie.updateBestaandespeler(spelerId, Mapper.map(speler))));
    }

    @GetMapping("speler/{spelerId}")
    @ResponseStatus(value = HttpStatus.OK)
    public SpelerDto getSpeler(@PathVariable("spelerId") int spelerId) {
        return Mapper.map(spelerService.get(GetSpeler.of(spelerId)));
    }

    @GetMapping("/speler")
    @ResponseStatus(value = HttpStatus.OK)
    public List<SpelerDto> getSpelers() {
        return spelerService.get(new GetSpelers()).stream().map(Mapper::map).collect(Collectors.toList());
    }
}
