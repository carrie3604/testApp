package com.example.agreements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DatabaseController
{
    @Autowired
    private AgreementCrudRepository agreementRepository;

    @GetMapping("/agreement-1")
    public String showAgreement1()
    {
        var agreements = agreementRepository.findAll();
        return "text-from-controller";
    }

    @GetMapping("/agreement-2")
    public String showAgreement2()
    {
        var agreements = agreementRepository.findWithCustomerNamePeter();
        return "text-from-controller";
    }

    @GetMapping("/agreement-3")
    public String showAgreement3(@RequestParam(name = "name") final String name)
    {
        var agreements = agreementRepository.findWithCustomerName(name);
        return "text-from-controller";
    }

    // agreement-4: show selected agreements
    @GetMapping("/agreement-4")
    public Iterable<AgreementEntity> showAgreement4(@RequestParam(name = "customerName") final String name)
    {
        Iterable<AgreementEntity> customer = agreementRepository.findSelectedCustomer(name);
        return customer;
        //
        // Iterable<AgreementEntity> agreements = agreementRepository.findSelectedCustomer(name);
        // var htmlPage = "id, name<br>";
        // for (var agreement : agreements) {
        // htmlPage += agreement.getId();
        // htmlPage += ",";
        // htmlPage += agreement.getId();
        // htmlPage += "<br>;
        // }
        // return htmlPage;

    }

    // agreement-5: input-field, button, click -> show found agreements

}
