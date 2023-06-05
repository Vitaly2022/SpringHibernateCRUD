package vit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vit.models.Developer;
import vit.models.Position;
import vit.service.DeveloperService;
import vit.service.PositionService;

@Controller
@RequestMapping("/developer")
public class DeveloperController {

    private final DeveloperService developerService;
    private final PositionService positionService;

    @Autowired
    public DeveloperController(DeveloperService developerService, PositionService positionService) {
        this.developerService = developerService;
        this.positionService = positionService;
    }


    @GetMapping()
    public String index(Model model) {
        model.addAttribute("developer", developerService.getAllDeveloper());
        return "developer/index";
    }

    @GetMapping("/new")
    public String newDeveloper(Model model) {
        model.addAttribute("newDeveloperForm",new Developer());
        model.addAttribute("positions", positionService.getAllPosition());
        return "developer/new";
    }


    @PostMapping("/new")
    public String create(@ModelAttribute("newDeveloperForm") Developer developer) {
        developerService.createOrUpdateDeveloper(developer);
        return "redirect:/developer";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") long id, Model model) {
        Developer developer = developerService.findDeveloper((int) id);
        Position position = developer.getPosition();
        System.out.println(developer.toString());
        System.out.println("Position" + position.toString());
        model.addAttribute("developer", developer);
        model.addAttribute("position", positionService.findPosition(position.getId()));

        return "developer/show";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") long id) {
        model.addAttribute("editdeveloper", developerService.findDeveloper((int) id));
        model.addAttribute("position", positionService.getAllPosition());
        System.out.println("Metod Edit GET");

        return "developer/edit";
    }

    @PostMapping("/{id}/edit")
    public String update(@ModelAttribute("editdeveloper") Developer editdeveloper, @PathVariable("id") long id) {
        System.out.println("Untill update");

        developerService.createOrUpdateDeveloper(editdeveloper);
        //developerDAO.update(id, editdeveloper);

        //developerService.de.update(id, editdeveloper);

        System.out.println("After update");
        return "redirect:/developer";
    }

    //delete specific person via delete method
    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") long id) {
        developerService.deleteDeveloper(id);
        return "redirect:/developer";
    }
}
