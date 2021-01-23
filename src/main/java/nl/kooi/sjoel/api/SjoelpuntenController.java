package nl.kooi.sjoel.api;

import lombok.RequiredArgsConstructor;
import nl.kooi.sjoel.domain.SjoelpuntenService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@RequiredArgsConstructor
@Controller
public class SjoelpuntenController {
    private final SjoelpuntenService sjoelpuntenService;

    @InitBinder("sjoelscore")
    public void initOwnerBinder(WebDataBinder dataBinder) {
    }

    @GetMapping("/sjoel")
    public String sjoelscoreForm(Model model) {
        var sjoelscoreDto = new SjoelpuntenDto();
        model.addAttribute("sjoelscore", sjoelscoreDto);
        return "sjoelscore";
    }


    @PostMapping("/sjoel")
    public String submitScore(@ModelAttribute("sjoelscore") @Valid SjoelpuntenDto score, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "sjoelscore";
        }

        model.addAttribute("punten", String.valueOf(sjoelpuntenService.getPunten(Mapper.map(score))));
        return "result";
    }


}
