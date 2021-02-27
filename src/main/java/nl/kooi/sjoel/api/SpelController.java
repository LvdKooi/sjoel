package nl.kooi.sjoel.api;

import lombok.RequiredArgsConstructor;
import nl.kooi.sjoel.api.dto.SpelDto;
import nl.kooi.sjoel.domain.SpelService;
import nl.kooi.sjoel.domain.command.spel.GetSpel;
import nl.kooi.sjoel.domain.command.spel.SpelActie;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class SpelController {

    private final SpelService spelService;

    @PostMapping("/spel")
    @ResponseStatus(value = HttpStatus.OK)
    public SpelDto saveSpel(@Valid @RequestBody SpelDto spel) {

        return Mapper.map(spelService.execute(SpelActie.voegNieuwSpelToe(Mapper.map(spel))));
    }

    @PutMapping("/spel/{spelId}")
    @ResponseStatus(value = HttpStatus.OK)
    public SpelDto updateSpel(@PathVariable int spelId, @RequestBody SpelDto spel) {
        return Mapper.map(spelService.execute(SpelActie.updateBestaandspel(spelId, Mapper.map(spel))));
}

    @GetMapping("/spel/{spelId}")
    @ResponseStatus(value = HttpStatus.OK)
    public SpelDto getSpel(@PathVariable int spelId) {
        return Mapper.map(spelService.get(GetSpel.of(spelId))); }

}
