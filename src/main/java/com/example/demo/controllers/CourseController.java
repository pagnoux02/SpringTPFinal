package com.example.demo.controllers;

import com.example.demo.Repository.ArticlesDAO;
import com.example.demo.Repository.ListesDAO;
import com.example.demo.Repository.PossederRepositoryDAOImp;
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
    @Autowired
    public PossederRepositoryDAOImp possederRepositoryDAOImp;

    @RequestMapping({"/list", "/"})
    public String allListName(Model model){
        model.addAttribute("Listes", listesDAO.getAllListesNames());

        return "listes/list";
    }

    @RequestMapping({"/edit/{id}"})
    public String edit(@PathVariable Integer id, Model model){
        model.addAttribute("Liste", listesDAO.getListesById(id));
        model.addAttribute("Articles", articlesDAO.getAllArticlebyid(id));
        model.addAttribute("lArticle", new Articles());
        return "listes/newList";
    }
    @RequestMapping({"/new"})
    public String newList( Model model){
        model.addAttribute("Liste", new Listes());
        model.addAttribute("lArticle", new Articles());
        return "listes/newList";
    }
    @RequestMapping({"/panier/{id}"})
    public String panier(@PathVariable Integer id, Model model){
        model.addAttribute("Liste", listesDAO.getListesById(id));
        model.addAttribute("Articles", articlesDAO.getAllArticlebyid(id));
        return "listes/panier";
    }
    @RequestMapping({"/delete/{id}"})
    public String deleteListes(@PathVariable Integer id, Model model){
        listesDAO.deletById(id);
        return "redirect:/Course/list";
    }

    @RequestMapping(value = "/news",method = RequestMethod.POST)
    public String InsertListe(Listes listes,Articles articles ){

        System.out.println(listes.getNom() +" =/= "+articles.getNomArt());
        if(!listes.getNom().isEmpty()) {
            int idListe = listesDAO.InsertListe(listes);

            if (!articles.getNomArt().isEmpty()) {
                int idArticle = articlesDAO.insertArticle(articles);
                possederRepositoryDAOImp.insertPosseder(idArticle, idListe);
            }
            return "redirect:/Course/edit/"+idListe;
        }
        return "redirect:/Course/new";
    }

    @RequestMapping(value = "/newedit/{id}",method = RequestMethod.POST)
    public String Insertarticleid(@PathVariable Integer id, Articles articles ){
        if (!articles.getNomArt().isEmpty()) {
            int idArticle = articlesDAO.insertArticle(articles);
            possederRepositoryDAOImp.insertPosseder(idArticle,id);
        }
        return "redirect:/Course/edit/"+id;
    }

    @RequestMapping({"/deleteArt/{idart}/{idlist}"})
    public String deleteArticles(@PathVariable Integer idlist,@PathVariable Integer idart, Model model){
        articlesDAO.deleteById(idart);
        return "redirect:/Course/edit/"+idlist;
    }

}



