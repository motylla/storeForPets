package pl.sda.storeforpets.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.sda.storeforpets.model.ContactMe;
import pl.sda.storeforpets.service.ContactMeService;

import javax.validation.Valid;

@Controller
public class ContactController {

    private ContactMeService contactMeService;

    @Autowired
    public ContactController(ContactMeService contactMeService) {
        this.contactMeService = contactMeService;
    }

    @GetMapping("/contact")
    public String ContactForm(Model model) {
        ContactMe contactMe = new ContactMe();
        model.addAttribute("contactMe", contactMe);
        return "contact/index";
    }

    @PostMapping("/contact")
    public String contact(@ModelAttribute @Valid ContactMe contactMe) {
        contactMeService.saveContactMessage(contactMe);
        return "redirect:/";
    }
}
