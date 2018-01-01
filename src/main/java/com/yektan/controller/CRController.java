package com.yektan.controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.yektan.model.CreditRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import com.yektan.repository.CRRepository;

import javax.validation.Valid;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by yektan on 1.01.2018.
 *
 * CRController sınıfım Restful servisin kendisidir.
 *
 */

@RestController // Restful servis olduğunu belirttik.
@RequestMapping("/api") // URL
public class CRController {

    @Autowired // crRepository beanı oluşturuluyor.
    CRRepository crRepository;

    @PostMapping(value = "/whatismyrate") //Sadece Post fonksiyonunu desteklemesini istedik.
    @ResponseBody// Java to JSON
    public ResponseEntity<?> getMyCreditRate(@Valid @RequestBody Integer credit,Errors errors){ //@RequestBody JSON to Java

        /*
        Aşağıdaki algoritma DB'den tüm datayı çeker ve arayüzden gelen datayla karşılaştırıp kararını
        Json olarak döndürür.
         */

        if (errors.hasErrors()) {
            return ResponseEntity.badRequest().body("Lütfen girmiş olduğunuz değeri kontrol edip tekrar deneyiniz.");
        }

        List<CreditRating> creditRatingList = (List<CreditRating>) crRepository.findAll();
        CreditRating creditRating;
        int rate=0;

        for (Iterator<CreditRating> i = creditRatingList.iterator(); i.hasNext();) {
            creditRating=i.next();
            if (credit>=creditRating.getStartAmount().intValueExact() && credit<=creditRating.getEndAmount().intValueExact())
                rate = creditRating.getRating();
        }

        return ResponseEntity.ok(rate);
    }

}
