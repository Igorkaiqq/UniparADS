/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.unipar.projetointegrado.apiinterfaces;

import java.util.List;
import models.Produto;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 *
 * @author rafae
 */
public interface ProdutoAPI {
    
    @GET("/produto/all")
    Call<List<Produto>> findAll();
    
}
