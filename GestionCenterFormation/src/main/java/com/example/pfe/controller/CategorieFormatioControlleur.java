package com.example.pfe.controller;

import com.example.pfe.dao.ICategorieFormation;
import com.example.pfe.model.CategorieFormation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/Categorie")
public class CategorieFormatioControlleur {
    @Autowired
    private ICategorieFormation iCategorieFormationCategorie;
    @GetMapping("/all")
    private List<CategorieFormation> listformation(){
        return this.iCategorieFormationCategorie.findAll();
    }
    @PostMapping("/save")
    private CategorieFormation ajoutformation(@RequestBody CategorieFormation Categorie){
        return this.iCategorieFormationCategorie.save(Categorie);
    }
    @PutMapping("/modif/{id}")
    private CategorieFormation modifierFormation(@RequestBody  CategorieFormation Categorie, @PathVariable Long id){
        Categorie.setId_categorie(id);
        return iCategorieFormationCategorie.saveAndFlush(Categorie);
    }
    @DeleteMapping("/delete/{id}")
    private HashMap<String,String> deleteformation(@PathVariable Long id){
        HashMap hashMap=new HashMap();
        try {
            iCategorieFormationCategorie.deleteById(id);
            hashMap.put("etat","formation supprimer");
            return hashMap;
        }catch (Exception e){
            hashMap.put("etat","formation non supprimer");
            return hashMap;
        }
    }
}

