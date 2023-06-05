package vit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vit.models.Position;
import vit.repository.PositionRepository;
import vit.service.DeveloperService;
import vit.service.PositionService;

@Controller
@RequestMapping("/position")
public class PositionController {

    private final PositionService positionService;

    private final PositionRepository positionRepository;
    private final DeveloperService developerService;

    public PositionController(PositionService positionService, PositionRepository positionRepository, DeveloperService developerService) {
        this.positionService = positionService;
        this.positionRepository = positionRepository;
        this.developerService = developerService;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("position", positionService.getAllPosition());
        return "position/index";
    }

    //return form page with person object
//    @GetMapping("/new")
//    public String newPerson(@ModelAttribute("position") Developer developer) { почему Developer
//        return "position/new";
//    }

    @GetMapping("/new")
    public String newPerson(@ModelAttribute("position") Position position) {
        return "position/new";
    }

    @PostMapping("/new")
    public String create(@ModelAttribute("position") Position position) {

        positionService.createOrUpdatePosition(position);
        return "redirect:/position";
    }

    // gets one person by id from DAO and sends to view
    @GetMapping("/{id}")
    public String show(@PathVariable("id") long id, Model model) {
        model.addAttribute("position", positionService.findPosition(id));
        model.addAttribute("DeveloperPos", developerService.getAllDeveloperByPosition(id));

        return "position/show";
    }

    //get page to edit specific person
    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") long id) {
        model.addAttribute("positions", positionService.findPosition(id));//ns
        return "position/edit";
    }

    //update specific person via patch method
    @PatchMapping("/{id}")
    public String update(@ModelAttribute("position") Position position, @PathVariable("id") long id) {

        //positionDAO.update(id, position);
        positionRepository.updatePosition(position);
        return "redirect:/position";
    }

    //delete specific person via delete method
    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") long id) {
        positionService.deletePosition(id);
        return "redirect:/position";
    }

}
