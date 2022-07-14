package com.portifoliodharan.dharanportifolio.controller;

import com.portifoliodharan.dharanportifolio.dtos.EmailDto;
import com.portifoliodharan.dharanportifolio.models.EmailModel;
import com.portifoliodharan.dharanportifolio.repository.EmailRepository;
import com.portifoliodharan.dharanportifolio.service.EmailService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class EmailController {

    @Autowired
    EmailRepository repository;
    @Autowired
    EmailService emailService;

    @GetMapping("/sent-mails")
    public ResponseEntity<List<EmailModel>> getAll(){
        List<EmailModel>  sentMails = repository.findAll();
        if(sentMails.isEmpty()){
            return ResponseEntity.status(204).build();
        }else{
            return ResponseEntity.ok(repository.findAll());
        }
    }

    @PostMapping("/send-mail")
    public ResponseEntity<EmailModel> sendindEmail(@RequestBody @Valid EmailDto emailDto){
        EmailModel emailModel = new EmailModel();
        BeanUtils.copyProperties(emailDto,emailModel);
        emailService.sendEmail(emailModel);
        return new ResponseEntity<>(emailModel, HttpStatus.CREATED);
    }
}
