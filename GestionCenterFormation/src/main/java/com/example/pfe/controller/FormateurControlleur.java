package com.example.pfe.controller;

import com.example.pfe.dao.IAvis;
import com.example.pfe.dao.ICondidat;
import com.example.pfe.dao.IFormateur;
import com.example.pfe.model.Formateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/formateur")
public class FormateurControlleur {
    @Autowired
    private IFormateur iFormateur;
    @Autowired
    private IAvis  AvisRepository ;
    @Autowired
    private ICondidat iCondidat;


    @GetMapping("/all")
    private List<Formateur> listformateur(){
        return this.iFormateur.findAll();
    }
    @PostMapping("/save")
    private Formateur ajoutformateur(@RequestBody Formateur formateur){
        return this.iFormateur.save(formateur);
    }
    @PutMapping("/modif/{id}")
    private Formateur modifierfomrateur(@RequestBody Formateur formateur,@PathVariable Long id){
        formateur.setId(id);
        return iFormateur.saveAndFlush(formateur);
    }
    @DeleteMapping("/delete/{id}")
    private HashMap<String,String> deleteformateur(@PathVariable Long id){
        HashMap hashMap=new HashMap();
        try {
            iFormateur.deleteById(id);
            hashMap.put("etat","formateur supprimer");
            return hashMap;
        }catch (Exception e){
            hashMap.put("etat","formateur non supprimer");
            return hashMap;
        }
    }
}
