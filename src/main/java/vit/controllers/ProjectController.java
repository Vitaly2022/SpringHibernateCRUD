//package vit.controllers;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//import vit.dao.ProjectDAO;
//import vit.models.Project;
//
//@Controller
//@RequestMapping("/project")
//public class ProjectController {
//    private final ProjectDAO projectDAO;
//
//    @Autowired
//    public ProjectController(ProjectDAO projectDAO) {
//        this.projectDAO = projectDAO;
//    }
//
//    @GetMapping()
//    public String index(Model model) {
//        model.addAttribute("project", projectDAO.index());
//        return "project/index";
//    }
//
//    @GetMapping("/new")
//    public String newPerson(@ModelAttribute("project") Project project) {
//        return "project/new";
//    }
//
//    @PostMapping("/new")
//    public String create(@ModelAttribute("project") Project project) {
//
//        projectDAO.save(project);
//        return "redirect:/project";
//    }
//
//    @GetMapping("/{id}")
//    public String show(@PathVariable("id") long id, Model model) {
//        model.addAttribute("project", projectDAO.show((int) id));
//        return "project/show";
//    }
//
//    @GetMapping("/{id}/edit")
//    public String edit(Model model, @PathVariable("id") long id) {
//        model.addAttribute("project", projectDAO.show((int) id));
//        return "project/edit";
//    }
//
//    @PatchMapping("/{id}")
//    public String update(@ModelAttribute("project") Project project, @PathVariable("id") long id) {
//
//        projectDAO.update(id, project);
//        return "redirect:/project";
//    }
//
//    @DeleteMapping("/{id}")
//    public String delete(@PathVariable("id") long id) {
//        projectDAO.delete((int) id);
//        return "redirect:/project";
//    }
//}
