package nl.kooi.sjoel.api;

import lombok.RequiredArgsConstructor;
import nl.kooi.sjoel.domain.RondeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class RondeController {

    private final RondeService rondeService;

    @PostMapping("/spel/{spelId}/ronde")
    @ResponseStatus(value = HttpStatus.OK)
    public void saveRonde(@PathVariable("spelId") int spelId, @Valid @RequestBody RondeDto ronde) {
        rondeService.saveRonde(spelId, Mapper.map(ronde));
    }

    @GetMapping("/spel/{spelId}/ronde/{rondenummer}")
    @ResponseStatus(value = HttpStatus.OK)
    public RondeDto getRonde(@PathVariable("spelId") int spelId, @PathVariable("rondenummer") int rondenummer) {
       return Mapper.map(rondeService.getRonde(spelId, rondenummer));
    }

}
