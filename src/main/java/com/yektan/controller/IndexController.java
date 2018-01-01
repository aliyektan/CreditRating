package com.yektan.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by yektan on 1.01.2018.
 *
 * Bu sınıfım proje ayağa kalktığında ajax.html sayfasını çalıştırmak için yazıldı.
 *
 */


@Controller
public class IndexController {

    @GetMapping("/") // http://localhost:8080/ deseniyle oluşan proje direkt ajax.html ile ekrana basılır.
    public String index() {
        return "ajax";
    }

}