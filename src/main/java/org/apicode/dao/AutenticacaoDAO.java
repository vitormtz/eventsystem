/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.apicode.dao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import org.apicode.model.Autenticacao;
import org.apicode.util.ConexaoBD;
import org.apicode.util.IDAOT;

/**
 *
 * @author vitor
 */
public class AutenticacaoDAO implements IDAOT<Autenticacao> {

    ResultSet resultadoQ = null;

    @Override
    public Autenticacao salvar(Autenticacao o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean atualizar(Autenticacao o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean excluir(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Autenticacao> consultarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Autenticacao consultar(String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Autenticacao consultar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Autenticacao consultar(Autenticacao o) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "SELECT COUNT(*) AS count "
                    + "FROM usuarios "
                    + "WHERE email = '" + o.getEmail() + "' AND senha = '" + o.getSenha() + "';";

            resultadoQ = st.executeQuery(sql);

            if (resultadoQ.next()) {
                if (resultadoQ.getInt("count") == 0) {
                    throw new RuntimeException();
                }
            }
            return o;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Integer consultarUltimoId() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
