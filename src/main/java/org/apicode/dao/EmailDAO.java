/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.apicode.dao;

import java.sql.Statement;
import java.util.ArrayList;
import org.apicode.model.Email;
import org.apicode.util.ConexaoBD;
import org.apicode.util.IDAOT;

/**
 *
 * @author vitor
 */
public class EmailDAO implements IDAOT<Email> {

    @Override
    public Email salvar(Email o) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "";

            sql = "INSERT INTO registros_email VALUES ("
                    + "" + o.getId() + ", "
                    + "" + o.getIdUsuario() + ", "
                    + "" + o.getIdEvento() + ", "
                    + "'" + o.getDataHoraEnvio() + "',"
                    + "'" + o.getNomeEvento() + "',"
                    + "'" + o.getNomeParticipante() + "',"
                    + "'" + o.getDataHoraInscricao() + "')";

            st.executeUpdate(sql);

            return o;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public boolean atualizar(Email o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean excluir(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Email> consultarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Email consultar(String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Email consultar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Integer consultarUltimoId() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Email consultar(Email o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
