package com.example.agreements;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "agreement")
public class AgreementEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "customer_name")
    private String customer;

    @Column(name = "begin_date")
    private LocalDateTime beginDate;

    public Long getId()
    {
        return id;
    }

    public void setId(final Long id)
    {
        this.id = id;
    }

    public String getCustomer()
    {
        return customer;
    }

    public void setCustomer(final String customer)
    {
        this.customer = customer;
    }

    public LocalDateTime getBeginDate()
    {
        return beginDate;
    }

    public void setBeginDate(final LocalDateTime beginDate)
    {
        this.beginDate = beginDate;
    }
}
