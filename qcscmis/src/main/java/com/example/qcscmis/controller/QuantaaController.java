package com.example.qcscmis.controller;

import com.example.qcscmis.common.Routes;
import com.example.qcscmis.model.Quantaa;
import com.example.qcscmis.service.QuantaaService;
import jakarta.persistence.Id;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class QuantaaController {
    private final QuantaaService service;

    public QuantaaController(QuantaaService service) {
        this.service = service;
    }

    @GetMapping(Routes.ADD_QUANTAA)
    public String createQuantaa(Model model) {
        model.addAttribute("quantaa", new Quantaa());
//        model.addAttribute("url", "/test-url");
        return "quantaa-form";
    }

    @PostMapping(Routes.ADD_QUANTAA)
    public String createQuantaa(@ModelAttribute Quantaa quantaa) {
        if (quantaa.getAction() == null) {
            quantaa = service.createQuantaa(quantaa);
        } else {
            return "redirect:" + Routes.QUANTAA_DELETE + "?id=" + quantaa.getId();
        }
        return "redirect:/quantaa?id=" + quantaa.getId();
    }

    @GetMapping(Routes.GET_QUANTAA)
    public String getQuantaa(@RequestParam(name = "id") Long id, Model model) {
        Quantaa quantaa = service.getQuantaaById(id);
        model.addAttribute("quantaa", quantaa);
        return "quantaa-form";
    }

    @GetMapping(Routes.QUANTAA_LIST)
    public String getQuantaaList(@RequestParam(name = "key", required = false) String key, Model model) {
        List<Quantaa> quantaaList = service.getQuantaList(key);
        model.addAttribute("quantaaList", quantaaList);
        return "quantaa-list";
    }

    @GetMapping(Routes.QUANTAA_DELETE)
    public String deleteQuantaa(@RequestParam(name = "id") Long id) {
        service.deleteQuantaa(id);
        return "redirect:" + Routes.QUANTAA_LIST;
    }

    @GetMapping("/update-test")
    public String updateTest() {
        Quantaa quantaa = new Quantaa();

        quantaa.setId(5L);
        quantaa.setName("test");
        quantaa.setQuantaId(132);
        quantaa.setCls(20);
        quantaa.setBloodType("Z+");

        quantaa = service.createQuantaa(quantaa);
        return "redirect:/add-quantaa";
    }

//    @GetMapping("/quantaa/{id}")
//    public String getQuanta(@PathVariable(name = "id") Long id, Model model) {
//        Quantaa quantaa = service.getQuantaaById(id);
//        model.addAttribute("quantaa", quantaa);
//        return "quantaa-form";
//    }


}
