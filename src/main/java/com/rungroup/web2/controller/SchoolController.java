package com.rungroup.web2.controller;

import com.rungroup.web2.model.school;
import com.rungroup.web2.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class SchoolController {
    private SchoolService schoolservice;
    @Autowired
    public SchoolController(SchoolService schoolservice) {
        this.schoolservice = schoolservice;
    }

    @GetMapping("/schools")

    public String listSchools(Model model){

        List<school> school = schoolservice.findAllschools();
        model.addAttribute("school", school);
        return "schools-list";

    }

    @GetMapping("/")

    public String HomeSchools(Model model){

        List<school> school = schoolservice.findAllschools();
        model.addAttribute("school", school);
        return "Home";

    }
  /*  @GetMapping
    public String createSchoolForm(Model model){

         school sch = new school();

         model.addAttribute(attributeName: "school", sch );

return "schools1-list";
    } */

    @GetMapping("/schools/new")
    public String createSchoolForm(Model model){

        school school = new school();
        model.addAttribute("school", school);
        return "schools-create";

    }
    @PostMapping("/schools/new")
    public String saveschool(@ModelAttribute("school") school sch){

        schoolservice.saveSchool(sch);

        return "redirect:/schools";

    }


    @GetMapping("/school/{user_id}/delete")
    public String delete(@PathVariable("user_id") long user_id){
        schoolservice.delete(user_id);
        return "redirect:/schools";
    }

    @GetMapping("/school/{user_id}/edit")
    public String editUser(@PathVariable("user_id") long user_id, Model model){
        school sch = schoolservice.findById(user_id);
        model.addAttribute("sch",sch);
        return "EditUser";
    }

    @PostMapping("/school/{user_id}/edit")
    public String updateUser(@PathVariable("user_id") long user_id, @ModelAttribute("sch") school school){
        school.setId(user_id);
        schoolservice.update(school);
        return "redirect:/schools";
    }


}
