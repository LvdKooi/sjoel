package nl.kooi.sjoel.api;

import lombok.RequiredArgsConstructor;
import nl.kooi.sjoel.domain.Mapper;
import nl.kooi.sjoel.domain.SjoelscoreService;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
public class SjoelscoreController {
    private final SjoelscoreService sjoelscoreService;

    @RequestMapping("/sjoel")
    public String initSubmitForm(Model model) {
        var sjoelscoreDto = new SjoelscoreDto();
        model.addAttribute("sjoelscoreDto", sjoelscoreDto);
        return "submitScoreForm";
    }


    @PostMapping("/sjoel/score")
    @ResponseStatus(HttpStatus.OK)
    public int submitScore(@Valid SjoelscoreDto score){

        return sjoelscoreService.getPunten(Mapper.map(score));
    }


}
