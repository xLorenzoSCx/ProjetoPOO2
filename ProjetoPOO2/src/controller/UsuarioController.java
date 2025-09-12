package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Usuario;

public class UsuarioController {

    public boolean autenticar(int crm, String senha) {

        String sql = "SELECT * from poo2 "
                + " WHERE CRM = ? and senha = ?";

        GerenciadorConexao gerenciador = new GerenciadorConexao();

        PreparedStatement comando = null;
        ResultSet resultado = null;

        try {

            comando = gerenciador.prepararComando(sql);

            comando.setInt(1, crm);
            comando.setString(2, senha);

            resultado = comando.executeQuery();

            if (resultado.next()) {
                return true;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            gerenciador.fecharConexao(comando, resultado);
        }
        return false;
    }

    public boolean inserir(Usuario usu) {

        String sql = "INSERT into poo2 (nome, CRM, senha, telefone )" + "values (?,?,?,?)";

        GerenciadorConexao gerenciador = new GerenciadorConexao();

        PreparedStatement comando = null;

        try {

            comando = gerenciador.prepararComando(sql);

            comando.setString(1, usu.getNome());
            comando.setInt(2, usu.getCrm());
            comando.setString(3, usu.getSenha());
            comando.setInt(4, usu.getTelefone());

            comando.executeUpdate();

            return true;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            gerenciador.fecharConexao(comando);

        }
        return false;

    }

}
