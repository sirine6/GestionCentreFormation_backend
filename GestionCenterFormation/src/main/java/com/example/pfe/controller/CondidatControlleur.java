package com.example.pfe.controller;

import com.example.pfe.dao.ICondidat;
import com.example.pfe.model.Condidat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/condidat")
public class CondidatControlleur {
    @Autowired
    private ICondidat iCondidat;
    @GetMapping("/all")
    private List<Condidat> listcondidat()
    { return iCondidat.findAll();}
    @PostMapping("/save")
    private Condidat ajoutercondidat(@RequestBody Condidat condidat)
    { return this.iCondidat.save(condidat);}
    @PutMapping("/modif/{id}")
    private Condidat modifiercondidat(@RequestBody Condidat condidat,@PathVariable Long id)
    {
        condidat.setId(id);
        return iCondidat.saveAndFlush(condidat);
    }
    @DeleteMapping("/delete/{id}")
    private HashMap<String,String> deleteCondidat(@PathVariable Long id){
        HashMap hashMap=new HashMap();
        try {
            iCondidat.deleteById(id);
            hashMap.put("etat","condidat supprimer");
            return hashMap;
        }catch (Exception e){
            hashMap.put("etat","condidat non supprimer");
            return hashMap;
        }}




}
