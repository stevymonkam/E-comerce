package com.stevy.contratti.controllers;

import com.stevy.contratti.models.Messages;
import com.stevy.contratti.payload.response.MessageResponse;
import com.stevy.contratti.repository.ContratRepository;
import com.stevy.contratti.service.ContraService;
import com.stevy.contratti.service.email.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class EmailController {
    @Autowired
    private ContratRepository contratRepository;
    @Autowired
    private  ContraService contraService;
    @Autowired
    EmailService es;

    @PostMapping("/sendNotallegato")
    public ResponseEntity<MessageResponse>  sentEmailTest(@RequestBody Messages ap){
        String[] s1 = ap.getA();
        String[] s2 = ap.getCc();
        es.sendSimpleMessage(s1,s2,ap.getOggetto(),ap.getCorpo());
        return ResponseEntity.ok(new MessageResponse("send mail", "ok",true, "mail send successfully",ap));
    }
    @PostMapping("/sendMailWithallegato")
    public String sentEmailTest2(@RequestBody Messages ap){
        //String[] s1 = new String[]{"stevy.monkam@yahoo.fr","s.monkam@be-tse.it"};
        String[] s1 = ap.getA();
        String[] s2 = ap.getCc();
        es.sendMessageWithAttachment(s1,s2, ap.getOggetto(), ap.getCorpo(), ap.getAllegato());
        return  "success";
    }

}
