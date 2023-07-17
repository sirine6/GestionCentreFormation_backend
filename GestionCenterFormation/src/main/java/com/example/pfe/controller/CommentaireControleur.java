package com.example.pfe.controller;

import com.example.pfe.dao.ICommentaire;
import com.example.pfe.dao.ICondidat;
import com.example.pfe.dao.IFormation;
import com.example.pfe.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/commentaire")
public class CommentaireControleur {
    @Autowired
    private ICommentaire iCommentaire;
    @Autowired
    private IFormation iFormation;
    @Autowired
    private ICondidat iCondidat;
    @GetMapping("/all")
    private List<Commentaire> listCommentaire(){
        return this.iCommentaire.findAll();
    }
    @PostMapping("/save/{idcondidat}/{idformation}")
    private Commentaire savecommentaire (@RequestBody Commentaire commentaire, @PathVariable Long idcondidat, @PathVariable Long idformation){
        Formation formation=iFormation.getOne(idformation);
        Condidat condidat=iCondidat.getOne(idcondidat);
       commentaire.setCondidat(condidat);
       commentaire.setFormation(formation);
        return this.iCommentaire.save(commentaire);
    }
    @PutMapping("/modif/{idcommentaire}")
    private Commentaire modifcommentaire (@RequestBody Commentaire commentaire, @PathVariable Long idcommentaire){
       commentaire.setId(idcommentaire);
        return this.iCommentaire.save(commentaire);
    }
    @DeleteMapping("/delete/{idcommentaire}")
    private HashMap<String,String> deletecommentaire(@PathVariable Long idcommentaire){
        HashMap hashMap=new HashMap();
        try {
            iCommentaire.deleteById(idcommentaire);
            hashMap.put("etat","commentaire supprimer");
            return hashMap;
        }catch (Exception e){
            hashMap.put("etat","commentaire non supprimer");
            return hashMap;
        }
    }
}
