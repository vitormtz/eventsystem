/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.apicode.dao;

import java.sql.Statement;
import java.util.ArrayList;
import org.apicode.model.Presenca;
import org.apicode.util.ConexaoBD;
import org.apicode.util.IDAOT;

/**
 *
 * @author vitor
 */
public class PresencaDAO implements IDAOT<Presenca> {

    @Override
    public Presenca salvar(Presenca o) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "";

            sql = "INSERT INTO presenca VALUES ("
                    + "" + o.getId() + ", "
                    + "" + o.getIdEvento() + ", "
                    + "" + o.getIdParticipante() + ", "
                    + "'" + o.getDataHoraCheckin() + "')";

            st.executeUpdate(sql);

            return o;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public boolean atualizar(Presenca o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean excluir(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Presenca> consultarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Presenca consultar(String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Presenca consultar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Integer consultarUltimoId() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Presenca consultar(Presenca o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
