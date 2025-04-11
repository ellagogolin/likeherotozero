package com.ella.studium.emissions.Controller;

import com.ella.studium.emissions.Entity.Emission;
import com.ella.studium.emissions.Repository.EmissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class IndexController {
    @Autowired
    private EmissionRepository emissionRepository;

    @GetMapping("/")
    public String index(
        @RequestParam(value = "search", required = false) String search,
        Model model
    )
    {
        Iterable<Emission> emissions;
        if (search == null || search.isBlank()) {
            emissions = this.emissionRepository.findAll();
        } else {
            try {
                int phoneCountryCode = Integer.parseInt(search);
                emissions = this.emissionRepository.findByPhoneCountryCode(phoneCountryCode);
            } catch (NumberFormatException exception) {
                emissions = this.emissionRepository.findByCountryNameContaining(search);
            }
        }

        model.addAttribute("emissions", emissions);
        model.addAttribute("searchInput", search);

        return "home";
    }
}
