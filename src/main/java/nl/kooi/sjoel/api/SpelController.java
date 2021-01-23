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
    public void saveSpel(@Valid @RequestBody SpelDto spel) {
        spelService.saveSpel(Mapper.map(spel));
    }

    @PutMapping("/spel/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public void updateSpel(@PathVariable int id, @RequestBody SpelDto spel) {
        spelService.getSpel(id);
        spel.setId(id);
        spelService.saveSpel(Mapper.map(spel));
}

    @GetMapping("/spel/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public void getSpel(@PathVariable int id) {
        spelService.getSpel(id);
    }

}
