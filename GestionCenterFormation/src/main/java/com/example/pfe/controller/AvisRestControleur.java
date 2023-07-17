package com.example.pfe.controller;

import com.example.pfe.dao.IAvis;
import com.example.pfe.dao.ICondidat;
import com.example.pfe.dao.IFormateur;
import com.example.pfe.model.Avis;
import com.example.pfe.model.Formateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

public class AvisRestControleur {
    @Autowired
    IAvis iAvis;
    @Autowired
    IFormateur iFormateur;
    @Autowired
    ICondidat iCondidat;
    @GetMapping("/all")
    public List<Avis> allavis() {
        return iAvis.findAll();
    }
    @PostMapping("/add/{idF}/{idC}")
    public Avis addavis(@RequestBody Avis avis, @PathVariable Long idF, @PathVariable Long idC) {

        avis.setFormateur(iFormateur.getOne(idF));
        avis.setCondidat(iCondidat.getOne(idC));
        return this.iAvis.save(avis);

    }
    @PostMapping("/addavis/{idC}")
    public Avis addavis(@PathVariable Long idC,@RequestBody Avis avis) {

        Formateur formateur = iFormateur.getOne(idC);

        formateur.setId(idC);
        avis.setFormateur(formateur);

        if(formateur.getNote()==0){
            formateur.setNote(avis.getRaiting());
        }
        iFormateur.save(formateur);

        return iAvis.save(avis);
    }
    @PutMapping("/edit/{id}/{idF}/{idC}")
    public Avis editavis (@RequestBody Avis avis, @PathVariable Long id,@PathVariable Long idF,@PathVariable Long idC ) {




        avis.setId(id);
        avis.setFormateur(iFormateur.getOne(idF));
        avis.setCondidat(iCondidat.getOne(idC));

        return iAvis.save(avis);




    }
    @DeleteMapping("/delete/{id}")
    public HashMap<String, String> deleteavis(@PathVariable Long id) {
        HashMap<String, String> hashMap = new HashMap<>();
        try {
            iAvis.deleteById(id);
            hashMap.put("state", "yes");
            return hashMap;
        } catch (Exception e) {
            hashMap.put("state", "no");
            return hashMap;
        }


    }

    @GetMapping("/avisconducteur/{idC}")
    public  List<Avis> getAvisconducteur (@PathVariable  String idC){
        return iAvis.findAll();
    }




}


