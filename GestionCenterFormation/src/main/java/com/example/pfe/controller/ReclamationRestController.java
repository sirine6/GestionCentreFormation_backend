package com.example.pfe.controller;


import com.example.pfe.dao.ICondidat;
import com.example.pfe.dao.IFormateur;
import com.example.pfe.dao.IReclamation;
import com.example.pfe.model.*;
import com.example.pfe.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/reclamation")
public class ReclamationRestController {


    @Autowired
    private IReclamation iReclamation;

    @Autowired
    private IFormateur iFormateur;

    @Autowired
    private ICondidat iCondidat;

    @Autowired
    private MailService mailService;

    @GetMapping("/all")
    public List<Reclamation> getAll(){
        return (List<Reclamation>) iReclamation.findAll();
    }

    @PostMapping("/add/{idU}")
    public Reclamation addreclamation(@RequestBody Reclamation r,@PathVariable Long idU)
    {
        for(Formateur formateur:iFormateur.findAll()) {
            if (formateur.getId().equals(idU)) {
                r.setPerson(formateur);
            }
        }

        for(Condidat condidat:iCondidat.findAll()) {
            if (condidat.getId().equals(idU)) {
                r.setPerson(condidat);
            }
        }

        return this.iReclamation.save(r);
    }
    @PutMapping("/update/{id}/{idU}")

    public Reclamation updatereclamtion(@RequestBody Reclamation r, @PathVariable  Long id, @PathVariable Long idU){
        r.setId(id);
        for(Formateur formateur:iFormateur.findAll()) {
            if (formateur.getId().equals(idU)) {
                r.setPerson(formateur);
            }
        }

        for(Condidat condidat:iCondidat.findAll()) {
            if (condidat.getId().equals(idU)) {
                r.setPerson(condidat);
            }
        }

        return iReclamation.save(r);}

    @GetMapping("/reponse/{id}")
    public Response reponse (@PathVariable Long id){
        Response rs= new Response();
        try {
            Reclamation reclamation;
            reclamation = iReclamation.getOne(id);

            iReclamation.save(reclamation);
            rs.setState("ok");
            return rs;
        }
        catch (Exception e){
            rs.setState("non");
            return rs;
        }
    }

    @DeleteMapping("/delete/{id}")
    public Response deleteUser(@PathVariable Long id){

        Response res = new Response();
        System.out.println("id=" +id);
        try {
            iReclamation.deleteById(id);
            res.setState("ok");
        }catch (Exception e){
            System.out.println(e.getMessage());
            res.setState("non");
        }
        return res ;
    }
    @GetMapping("/one/{id}")
    public Reclamation getOne(@PathVariable  Long id){

        return iReclamation.getOne(id);
    }

    @PostMapping(value="/sendMail/{idreclamation}")
    public Response sendMail(@RequestBody Mail mail, @PathVariable Long idreclamation)


    {
        Response rs=new Response();


        System.out.println("Spring Mail - Sending Simple Email with JavaMailSender Example");

        mail.setFrom("krbsirine@gmail.com");
        mail.setTo(mail.getTo());
        mail.setSubject("Reponse pour votre Reclamation");
        mail.setContent(mail.getContent());
        mailService.sendSimpleMessage(mail);



        rs.setState("email ok");
        return rs;

    }

}
