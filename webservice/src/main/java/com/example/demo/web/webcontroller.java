package com.example.demo.web;
import java.util.List;
import com.example.demo.domain.Journal;
import com.example.demo.repository.JournalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;

@Controller
public class webcontroller {
    @Autowired
    JournalRepository repo;
    @RequestMapping("/")
    public String index(Model model){
        model.addAttribute("journal",repo.findAll());
        return "index";
    }
    @RequestMapping(value = "/journal",produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public @ResponseBody List<Journal> getJournal(){
        return repo.findAll();
    }
}
