package com.example.agreements;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;

@Entity
@Table(name = "agreement_contact")
public class AgreementContactEntity
{

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "type")
    private String type;
    @Column(name = "salutation")
    private String salutation;
    @Column(name = "firstname")
    private String firstname;
    @Column(name = "lastname")
    private String lastname;
    @Column(name = "phone")
    private String phone;
    @Column(name = "mobile")
    private String mobile;
    @Column(name = "fax")
    private String fax;
    @Column(name = "email")
    private String email;
    @Column(name = "hint")
    private String hint;
    @Column(name = "department")
    private String department;
    @Column(name = "street")
    private String street;
    @Column(name = "house_number")
    private String houseNo;
    @Column(name = "zip_code")
    private String zip;
    @Column(name = "city")
    private String city;

    // set default id
    public AgreementContactEntity(final long id)
    {
        this.id = id;
    }

}
