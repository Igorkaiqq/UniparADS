/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.conversor.pessoas.dao;

import com.mycompany.conversor.pessoas.model.PessoaModel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author igork
 */
public class PessoaDAO {

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
        } catch (Exception e) {
            if (transaction.isActive()){
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return 0;
    }

    public List<PessoaModel> getAllPessoas() {
        try {
            return entityManager.createQuery("SELECT p FROM PessoaModel p", PessoaModel.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

}
