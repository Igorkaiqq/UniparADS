/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.conversor.pessoas.model;

<<<<<<< HEAD
import jakarta.persistence.*;
=======
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
>>>>>>> d772ed9c5f7e64b03fa61d21e2469180235e3b9c
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author igork
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
<<<<<<< HEAD
@Table(name="pessoa")
public class PessoaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

=======
@Table(name = "pessoa")
public class PessoaModel {

    @Id
    @Column(name="id")
    private int id;
>>>>>>> d772ed9c5f7e64b03fa61d21e2469180235e3b9c
    @Column(name="nome")
    private String nome;

    @Column(name="cpf")
    private String cpf;

    @Column(name="rg")
    private String rg;

    @Column(name="data_nasc")
    private String data_nasc;

    @Column(name="sexo")
    private String sexo;

    @Column(name="signo")
    private String signo;

    @Column(name="mae")
    private String mae;

    @Column(name="pai")
    private String pai;

    @Column(name="email")
    private String email;

    @Column(name="senha")
    private String senha;

    @Column(name="cep")
    private String cep;

    @Column(name="endereco")
    private String endereco;

    @Column(name="numero")
    private int numero;

    @Column(name="bairro")
    private String bairro;

    @Column(name="estado")
    private String estado;

    @Column(name="telefone_fixo")
    private String telefone_fixo;

    @Column(name="celular")
    private String celular;

    @Column(name="altura")
    private double altura;

    @Column(name="peso")
    private double peso;

    @Column(name="tipo_sanguineo")
    private int tipo_sanguineo;

    @Column(name="cor")
    private String cor;

}
