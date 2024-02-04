package com.example.agreements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AgreementController
{
    @Autowired
    private AgreementRepository agreementRepository;

    @GetMapping("/test1")
    public String welcome()
    {

        return "agreements";
    }

    @GetMapping("/test1/profile")
    public String showAgreement(@RequestParam(name = "customerName") final String name, final Model model)
    {
        Iterable<AgreementEntity> customer = agreementRepository.findSelectedCustomer(name);
        model.addAttribute("customer", customer);
        return "profile";

    }

}
