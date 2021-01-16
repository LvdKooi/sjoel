package nl.kooi.sjoel.api;

import lombok.RequiredArgsConstructor;
import nl.kooi.sjoel.domain.Mapper;
import nl.kooi.sjoel.domain.SjoelscoreService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@Controller
public class SjoelscoreController {
    private final SjoelscoreService sjoelscoreService;

    @InitBinder("sjoelscore")
    public void initOwnerBinder(WebDataBinder dataBinder) {
    }

    @GetMapping("/sjoel")
    public String sjoelscoreForm(Model model) {
        var sjoelscoreDto = new SjoelscoreDto();
        model.addAttribute("sjoelscore", sjoelscoreDto);
        return "sjoelscore";
    }


    @PostMapping("/sjoel")
    @ResponseStatus(HttpStatus.OK)
    public String submitScore(@ModelAttribute("sjoelscore") @Valid SjoelscoreDto score, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "sjoelscore";
        }

        model.addAttribute("punten", String.valueOf(sjoelscoreService.getPunten(Mapper.map(score))));
        return "result";
    }


}
