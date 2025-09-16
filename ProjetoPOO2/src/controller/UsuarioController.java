package controller;

import java.util.List;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
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
            comando.setString(2, usu.getCrm());
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

    public List<Usuario> consultar(int opcaoFiltro, String filtro) {
        //Montar o comando a ser executado
        //os ? são variáveis que são preenchidas mais adiante
        String sql = "SELECT * from TBUSUARIO ";

        //Cria uma instância do gerenciador de conexão
        //(conexão com o banco de dados),
        GerenciadorConexao gerenciador = new GerenciadorConexao();

        //Declara as variáveis como nulas antes do try 
        //para poder usar no finally
        PreparedStatement comando = null;
        ResultSet resultado = null;

        //crio a lista de usuários, vazia ainda
        List<Usuario> lista = new ArrayList<>();

        try {
            //prepara o sql, analisando o formato e as váriaveis
            comando = gerenciador.prepararComando(sql);

            //executa o comando e guarda o resultado da consulta 
            //o resultado é semelhante a uma grade
            resultado = comando.executeQuery();

            while (resultado.next()) {
                Usuario usu = new Usuario();

                usu.setPkUsuario(resultado.getInt("pkUsuario"));
                usu.setNome(resultado.getString("nome"));
                usu.setCrm(resultado.getString("email"));
                usu.setSenha(resultado.getString("senha"));

            }
        } catch (SQLException e) {
            //caso ocorra um erro relacionado ao banco de dados
            //exibe popup com o erro
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            //depois de executar o try, dando erro ou não executa o finally
            gerenciador.fecharConexao(comando, resultado);
        }
        return lista;
    }

    public boolean alterar(Usuario usu) {
        //Montar o comando a ser executado
        //os ? são variáveis que são preenchidas mais adiante
        String sql = "UPDATE TBUSUARIO SET "
                + " nome = ?, " //1
                + " CRM = ?, " //2
                + " telefone = ? ";
        //5
        if (usu.getSenha() != null) {
            sql += " ,senha = ? "; //6
        }

        sql += " WHERE pkUsuario = ? "; //6 ou 7

        //Cria uma instância do gerenciador de conexão
        //(conexão com o banco de dados),
        GerenciadorConexao gerenciador = new GerenciadorConexao();

        //Declara as variáveis como nulas antes do try 
        //para poder usar no finally
        PreparedStatement comando = null;

        try {
            //prepara o sql, analisando o formato e as váriaveis
            comando = gerenciador.prepararComando(sql);

            //define o valor de cada variável(?) pela posição em que aparece no sql
            comando.setString(1, usu.getNome());
            comando.setString(2, usu.getCrm());
            comando.setInt(3, usu.getTelefone());

            if (usu.getSenha() != null) {
                comando.setString(6, usu.getSenha());
                comando.setInt(7, usu.getPkUsuario());
            } else {
                comando.setInt(6, usu.getPkUsuario());
            }

            //executa o comando 
            comando.executeUpdate();
            return true;
        } catch (SQLException e) {
            //caso ocorra um erro relacionado ao banco de dados
            //exibe popup com o erro
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            //depois de executar o try, dando erro ou não executa o finally
            gerenciador.fecharConexao(comando);
        }
        return false;
    }

    public boolean deletar(int pkUsuario) {
        //Montar o comando a ser executado
        //os ? são variáveis que são preenchidas mais adiante
        String sql = "DELETE FROM poo2 "
                + " WHERE pkUsuario = ? "; //1

        //Cria uma instância do gerenciador de conexão
        //(conexão com o banco de dados),
        GerenciadorConexao gerenciador = new GerenciadorConexao();

        //Declara as variáveis como nulas antes do try 
        //para poder usar no finally
        PreparedStatement comando = null;

        try {
            //prepara o sql, analisando o formato e as váriaveis
            comando = gerenciador.prepararComando(sql);

            //define o valor de cada variável(?) pela posição em que aparece no sql
            comando.setInt(1, pkUsuario);

            //executa o comando 
            comando.executeUpdate();

            return true;
        } catch (SQLException e) {
            //caso ocorra um erro relacionado ao banco de dados
            //exibe popup com o erro
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            //depois de executar o try, dando erro ou não executa o finally
            gerenciador.fecharConexao(comando);
        }
        return false;
    }

}
