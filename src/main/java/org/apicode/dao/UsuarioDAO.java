/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.apicode.dao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import org.apicode.model.Usuario;
import org.apicode.util.ConexaoBD;
import org.apicode.util.IDAOT;

/**
 *
 * @author vitor
 */
public class UsuarioDAO implements IDAOT<Usuario> {

    ResultSet resultadoQ = null;

    @Override
    public Usuario salvar(Usuario o) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "";

            sql = "INSERT INTO usuarios VALUES ("
                    + "" + o.getId() + ", "
                    + "'" + o.getNome() + "', "
                    + "'" + o.getEmail() + "', "
                    + "'" + o.getSenha() + "')";

            st.executeUpdate(sql);

            return o;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public boolean atualizar(Usuario o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean excluir(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Usuario> consultarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public ArrayList<Usuario> consultarUsuarioEventos(int id) {
        ArrayList<Usuario> usuarios = new ArrayList<>();

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "SELECT u.id AS id, u.nome, u.email "
                    + "FROM inscricoes i INNER JOIN eventos e ON e.id = i.id_evento "
                    + "INNER JOIN usuarios u ON u.id = i.id_usuario "
                    + "WHERE e.id = " + id;

            resultadoQ = st.executeQuery(sql);

            while (resultadoQ.next()) {
                // Criar um objeto Usuario para cada linha do resultado
                Usuario usuario = new Usuario();
                usuario.setId(resultadoQ.getInt("id"));
                usuario.setNome(resultadoQ.getString("nome"));
                usuario.setEmail(resultadoQ.getString("email"));
                // Adicionar o evento à lista
                usuarios.add(usuario);
            }
        } catch (Exception e) {
        }
        return usuarios;
    }

    @Override
    public Usuario consultar(String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Usuario consultar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Integer consultarUltimoId() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Usuario consultar(Usuario o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
