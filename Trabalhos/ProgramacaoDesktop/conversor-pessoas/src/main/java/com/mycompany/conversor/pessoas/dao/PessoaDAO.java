/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.conversor.pessoas.dao;

import com.mycompany.conversor.pessoas.model.PessoaModel;
import jakarta.persistence.EntityManager;
<<<<<<< HEAD
=======
import jakarta.persistence.EntityTransaction;
>>>>>>> d772ed9c5f7e64b03fa61d21e2469180235e3b9c

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author igork
 */
public class PessoaDAO {

<<<<<<< HEAD
    private final EntityManager entityManager;

    public PessoaDAO(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public int salvarPessoas(PessoaModel pessoa){
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(pessoa);
            entityManager.getTransaction().commit();
            return 1;
=======
    private EntityManager entityManager;

    public PessoaDAO() {
        this.entityManager = entityManager;
    }

    public int salvarPessoas(PessoaModel pessoa) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
        transaction.begin();
        entityManager.persist(pessoa);
        transaction.commit();
        return 1;
>>>>>>> d772ed9c5f7e64b03fa61d21e2469180235e3b9c
        } catch (Exception e) {
            if (transaction.isActive()){
                transaction.rollback();
            }
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
        return 0;
    }

    public List<PessoaModel> getAllPessoas() {
        try {
<<<<<<< HEAD
            return (ArrayList<PessoaModel>) entityManager.createQuery("SELECT p FROM PessoaModel p").getResultList();
=======
            return entityManager.createQuery("SELECT p FROM PessoaModel p", PessoaModel.class).getResultList();
>>>>>>> d772ed9c5f7e64b03fa61d21e2469180235e3b9c
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

}
