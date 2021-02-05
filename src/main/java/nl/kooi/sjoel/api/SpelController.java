package nl.kooi.sjoel.api;

import lombok.RequiredArgsConstructor;
import nl.kooi.sjoel.domain.SpelService;
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

        return Mapper.map(spelService.saveSpel(Mapper.map(spel)));
    }

    @PutMapping("/spel/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public SpelDto updateSpel(@PathVariable int id, @RequestBody SpelDto spel) {
        spelService.getSpel(id);
        spel.setId(id);
        return Mapper.map(spelService.saveSpel(Mapper.map(spel)));
}

    @GetMapping("/spel/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public SpelDto getSpel(@PathVariable int id) {
       return Mapper.map(spelService.getSpel(id));
    }

}
