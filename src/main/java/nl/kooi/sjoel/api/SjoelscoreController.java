package nl.kooi.sjoel.api;

import lombok.RequiredArgsConstructor;
import nl.kooi.sjoel.domain.Mapper;
import nl.kooi.sjoel.domain.SjoelscoreService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@Controller
public class SjoelscoreController {
    private final SjoelscoreService sjoelscoreService;

    @GetMapping("/sjoel")
    public String sjoelscoreForm(Model model) {
        var sjoelscoreDto = new SjoelscoreDto();
        model.addAttribute("sjoelscore", sjoelscoreDto);
        return "sjoelscore";
    }


    @PostMapping("/sjoel")
    @ResponseStatus(HttpStatus.OK)
    public String submitScore(@ModelAttribute SjoelscoreDto score, Model model){
        model.addAttribute("punten", String.valueOf(sjoelscoreService.getPunten(Mapper.map(score))));
        return "result";
    }


}
