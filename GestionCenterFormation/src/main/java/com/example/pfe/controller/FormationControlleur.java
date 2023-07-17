package com.example.pfe.controller;

import com.example.pfe.dao.*;
import com.example.pfe.dao.IFormation;
import com.example.pfe.model.CategorieFormation;
import com.example.pfe.model.Condidat;
import com.example.pfe.model.Formateur;
import com.example.pfe.model.Formation;
import com.example.pfe.storage.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
@RestController
@RequestMapping("/formation")
    public class FormationControlleur {
    @Autowired
    private StorageService storageService;
    @Autowired
    private IFormation iFormation;
    @Autowired
    private ICategorieFormation iCategorieFormation;
    @Autowired
    private IFormateur iFormateur;
    @Autowired
    private ICondidat iCondidat;
    @GetMapping("/all")
    private List<Formation> listFormation(){
        return this.iFormation.findAll();
    }
    @PostMapping("/save/{idcategorie}/{idformateur}")
    private Formation ajoutFormation(@RequestBody Formation formation,@PathVariable Long idcategorie,@PathVariable Long idformateur){
        CategorieFormation categorieFormation=iCategorieFormation.getOne(idcategorie);
        Formateur formateur=iFormateur.getOne(idformateur);
        formation.setFormateur(formateur);
        formation.setCategorieFormation(categorieFormation);
        return this.iFormation.save(formation);
    }
//@PostMapping("/save/{idcategorie}")
//private Formation ajoutFormation(String prix, MultipartFile file , @PathVariable Long idcategorie){
//    CategorieFormation categorieFormation=iCategorieFormation.getOne(idcategorie);
//    Formation formation=new Formation();
//    formation.setPrix(prix);
//    storageService.store(file);
//    formation.setSupportCours(file.getOriginalFilename());
//    formation.setCategorieFormation(categorieFormation);
//    return this.iFormation.save(formation);
//}
    @PutMapping("/modif/{id}/{idformateur}")
    private Formation modifierfomrateur(@RequestBody Formation formation,@PathVariable Long id,@PathVariable Long idformateur){
        Formation formation0=iFormation.getOne(id);
        Formateur formateur=iFormateur.getOne(idformateur);
        formation.setFormateur(formateur);
        if(formation.getDateDebut()==null){
            formation.setDateDebut(formation0.getDateDebut());

        }
        if(formation.getCharge()==null){
            formation.setCharge(formation0.getCharge());

        } if(formation.getDateFin()==null){
            formation.setDateFin(formation0.getDateFin());

        } if(formation.getHoraire()==null){
            formation.setHoraire(formation0.getHoraire());

        } if(formation.getPrix()==null){
            formation.setPrix(formation0.getPrix());

        }
        formation.setCategorieFormation(formation0.getCategorieFormation());
        formation.setId(id);
        return iFormation.saveAndFlush(formation);
    }
    @DeleteMapping("/delete/{id}")
    private HashMap<String,String> deleteFormation(@PathVariable Long id){
        HashMap hashMap=new HashMap();
        try {
            iFormation.deleteById(id);
            hashMap.put("etat","Formation supprimer");
            return hashMap;
        }catch (Exception e){
            hashMap.put("etat","Formation non supprimer");
            return hashMap;
        }
    }
    @GetMapping("/getformationbycategorie/{idcategorie}")
    private List<Formation> getbyidcategorie(@PathVariable Long idcategorie){
List<Formation> formationList=new ArrayList<>();
for( Formation formation:iFormation.findAll()){
    if(formation.getCategorieFormation().getId_categorie().equals(idcategorie)){
    formationList.add(formation);}

}
        return formationList;
}
    @GetMapping("/getformationbyformateur/{idformateur}")
    private List<Formation> getbyidformateur(@PathVariable Long idformateur){
        List<Formation> formationList=new ArrayList<>();
        for( Formation formation:iFormation.findAll()){
            if(formation.getFormateur().getId().equals(idformateur)){
                formationList.add(formation);}

        }
        return formationList;
    }
    @GetMapping("affecterauformation/{idformation}/{idcondiday}")
    private Formation affecter(@PathVariable Long idformation,@PathVariable Long idcondiday)
    {
        Formation formation =iFormation.getOne(idformation);
        Condidat condidat= iCondidat.getOne(idcondiday);
        List<Condidat> list=formation.getCondidatList();
        if(list.size()==0){
            list.add(0,condidat);
        }
        list.add(list.size()+1,condidat);
        formation.setCondidatList(list);
          return iFormation.save(formation);
    }

}
