package com.launchcode.job_application_tracker.controllers;

import com.launchcode.job_application_tracker.data.PositionRepository;
import com.launchcode.job_application_tracker.models.Position;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/positions")
public class PositionController {

    @Autowired
    private PositionRepository positionRepository;

    @GetMapping
    public String displayPositionsPage(Model model, HttpSession session) {
        model.addAttribute("appliedPositionList", positionRepository.findAll());
        model.addAttribute("loggedIn", session.getAttribute("user") != null);
        return "/positions/index";
    }

    @GetMapping("/add")
    public String displayAddPositiontForm(Model model, HttpSession session) {
        model.addAttribute("loggedIn", session.getAttribute("user") != null);
        model.addAttribute("position", new Position());
        return "positions/add";
    }

    @PostMapping("/add")
    public String processAddArtistForm(@ModelAttribute("position") @Valid Position appliedPosition, Errors errors,Model model) {
        if (errors.hasErrors()) {
//            model.addAttribute("appliedPosition", appliedPosition);
            return "positions/add";
        } else {
            positionRepository.save(appliedPosition);
            return "redirect:/positions";
        }
    }

    @GetMapping("/delete")
    public String displayDeleteArtistForm(Model model, HttpSession session) {
        model.addAttribute("appliedPositionList", positionRepository.findAll());
        model.addAttribute("loggedIn", session.getAttribute("user") != null);

        return "positions/delete";
    }

    @PostMapping("/delete")
    public String processDeleteArtistForm(@RequestParam(required = false) int[] positionIds) {
        if (positionIds != null) {
            for (int id : positionIds) {
                positionRepository.deleteById(id);
            }
        }
        return "redirect:/positions";
    }

}
