package nl.kooi.sjoel.api;

import lombok.RequiredArgsConstructor;
import nl.kooi.sjoel.domain.Mapper;
import nl.kooi.sjoel.domain.SjoelscoreService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class SjoelScoreController {
    private final SjoelscoreService sjoelscoreService;

    @PostMapping("sjoel/score")
    @ResponseStatus(HttpStatus.OK)
    public int submitScore(@ModelAttribute SjoelscoreDto score){

        return sjoelscoreService.getPunten(Mapper.map(score));
    }


}
