//package vit.controllers;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import vit.dao.DeveloperDAO;
//import vit.dao.ProjectDAO;
//import vit.models.Developer;
//
//@Controller
//@RequestMapping("/addproject")
//public class Developer_ProjectController {
//
//    private final DeveloperDAO developerDAO;
//    private final ProjectDAO projectDAO;
//
//    @Autowired
//    public Developer_ProjectController(DeveloperDAO developerDAO, ProjectDAO projectDAO) {
//        this.developerDAO = developerDAO;
//        this.projectDAO = projectDAO;
//    }
//
//    @GetMapping("/")
//    public String newPerson(Model model) {
//        model.addAttribute("addProjectForm", projectDAO.index());
////        model.addAttribute("position", positionDAO.index());
//        return "dev_proj/add";
//    }
//
//    @PostMapping("/")
//    public String create(@ModelAttribute("newDeveloperForm") Developer developer) {
//
//        developerDAO.save(developer);
//        return "redirect:/developer";
//    }
//}
