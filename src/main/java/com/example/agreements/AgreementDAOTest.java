package com.example.agreements;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class AgreementDAOTest
{
    public void test()
    {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("UsersDB"); // used to create an EntityManager.
        EntityManager entityManager = factory.createEntityManager(); // interact with the database

        Query query = entityManager.createQuery("SELECT a FROM AgreementEntity a WHERE a.id = :id");
        query.setParameter("id", 123);
        query.getResultList();

        // AgreementEntity newAgreement = new AgreementEntity();
        // newAgreement.setId(); //muss id setzen wenn autoincrement
        // newAgreement.setsetBeginDate("2023-12-29");
        // newAgreement.setCustomer("Michael");
        //
        //
        // entityManager.persist(newAgreement);
        //
        // entityManager.getTransaction().commit();

        entityManager.close();
        factory.close();
    }
}
