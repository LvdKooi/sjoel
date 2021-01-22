package nl.kooi.sjoel.api;

import lombok.RequiredArgsConstructor;
import nl.kooi.sjoel.domain.SpelService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class SpelController {

    private final SpelService spelService;

    @PostMapping("/spel")
    @ResponseStatus(value = HttpStatus.OK)
    public void saveSpel( @Valid  @RequestBody SpelDto spel) {
            spelService.saveSpel(Mapper.map(spel));
    }

}
