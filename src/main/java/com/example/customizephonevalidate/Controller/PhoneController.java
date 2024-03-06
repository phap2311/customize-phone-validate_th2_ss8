package com.example.customizephonevalidate.Controller;

import com.example.customizephonevalidate.Model.PhoneNumber;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class PhoneController {
    @GetMapping("/phone")
    public String showForm(Model model) {
        model.addAttribute("phoneNumber", new PhoneNumber());
        return "/index";
    }

    @PostMapping("/phone")
    public String checkValidate(@Valid @ModelAttribute("phoneNumber") PhoneNumber phoneNumber, BindingResult bindingResult, Model model) {
        new PhoneNumber().validate(phoneNumber, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return "/index";
        } else {
            model.addAttribute("phoneNumber", phoneNumber);
        }
        return "/result";
    }
}
