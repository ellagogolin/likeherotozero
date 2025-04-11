package com.ella.studium.emissions.Controller;

import com.ella.studium.emissions.Entity.Emission;
import com.ella.studium.emissions.Repository.EmissionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/emission")
public class EmissionManagementController {
    @Autowired
    private EmissionRepository emissionRepository;

    @GetMapping("/{id}")
    public String getView(@PathVariable("id") long id, Model model)
    {
        Emission emission = emissionRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "entity not found"));

        model.addAttribute("emission", emission);

        return "emission";
    }

    @GetMapping
    public String insertView()
    {
        return "emission";
    }

    @PutMapping
    public RedirectView insert(@Validated Emission payload, BindingResult result) {
        Emission emission = new Emission();
        emission.setCountryName(payload.getCountryName());
        emission.setEmissionInMegaTons(payload.getEmissionInMegaTons());
        emission.setPhoneCountryCode(payload.getPhoneCountryCode());
        emissionRepository.save(emission);

        return new RedirectView("/");
    }

    @PostMapping("/{id}")
    public RedirectView edit(@PathVariable("id") long id, @Validated Emission payload, BindingResult result)
    {
        Emission emission = emissionRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "entity not found"));
        emission.setCountryName(payload.getCountryName());
        emission.setEmissionInMegaTons(payload.getEmissionInMegaTons());
        emission.setPhoneCountryCode(payload.getPhoneCountryCode());
        emissionRepository.save(emission);

        return new RedirectView("/");
    }

    @DeleteMapping("/{id}")
    public RedirectView delete(@PathVariable("id") long id)
    {
        Emission emission = this.emissionRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "entity not found"));
        emissionRepository.delete(emission);

        return new RedirectView("/");
    }
}
