package com.example.demo.controllers;

import com.example.demo.Repository.ArticlesDAO;
import com.example.demo.Repository.ListesDAO;
import com.example.demo.domain.Articles;
import com.example.demo.domain.Listes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping(path="/Course")
@Controller
public class CourseController {

    @Autowired
    public ListesDAO listesDAO;
    @Autowired
    public ArticlesDAO articlesDAO;

    @RequestMapping({"/list", "/"})
    public String allListName(Model model){
        model.addAttribute("Listes", listesDAO.getAllListesNames());

        return "listes/list";
    }

    @RequestMapping({"/edit/{id}"})
    public String edit(@PathVariable Integer id, Model model){
        model.addAttribute("Liste", listesDAO.getListesById(id));
        model.addAttribute("Articles", articlesDAO.getAllArticlebyid(id));
        return "listes/newList";
    }
    @RequestMapping({"/new"})
    public String newList( Model model){
        model.addAttribute("Liste", new Listes());
        model.addAttribute("Articles", new Articles());
        return "listes/newList";
    }
    @RequestMapping({"/panier/{id}"})
    public String panier(@PathVariable Integer id, Model model){
        model.addAttribute("Liste", listesDAO.getListesById(id));
        model.addAttribute("Articles", articlesDAO.getAllArticlebyid(id));
        return "listes/panier";
    }
    @RequestMapping(value = "/",method = RequestMethod.POST)
   public String InsertListeAndArticles(Listes listes){
        int id;
        id = listesDAO.InsertListe(listes);
        return "redirect:/Course/edit/"+id;
    }

    @RequestMapping({"/delete/{id}"})
    public String deleteListes(@PathVariable Integer id, Model model){
        listesDAO.deletById(id);
        return "redirect:/Course/list";
    }

}



