package com.example.agreements;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface AgreementRepository extends CrudRepository<AgreementEntity, Long>
{
    @Query("SELECT a FROM AgreementEntity a WHERE a.customer = 'Peter'")
    Iterable<AgreementEntity> findWithCustomerNamePeter();

    @Query("SELECT a FROM AgreementEntity a WHERE a.customer = :customerName")
    Iterable<AgreementEntity> findWithCustomerName(@Param("customerName") String customerName);

    @Query("SELECT a FROM AgreementEntity a WHERE a.customer = :customerName")
    Iterable<AgreementEntity> findSelectedCustomer(@Param("customerName") String customerName);

}
