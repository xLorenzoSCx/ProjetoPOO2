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
import model.Local;
import model.Usuario;

public class LocalController {

    public boolean inserir(Local local) {

        String sql = "INSERT into local (nome, numero, CEP)" + "values (?,?,?)";

        GerenciadorConexao gerenciador = new GerenciadorConexao();

        PreparedStatement comando = null;

        try {

            comando = gerenciador.prepararComando(sql);

            comando.setString(1, local.getNomeLocal());
            comando.setInt(2, local.getNumeroLocal());
            comando.setInt(3, local.getCep());

            comando.executeUpdate();

            return true;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            gerenciador.fecharConexao(comando);

        }
        return false;

    }

    public List<Local> consultarLocal(int opcaoFiltro, String filtro) {
        //Montar o comando a ser executado
        //os ? são variáveis que são preenchidas mais adiante
        String sql = "SELECT * from local ";

        //Cria uma instância do gerenciador de conexão
        //(conexão com o banco de dados),
        GerenciadorConexao gerenciador = new GerenciadorConexao();

        //Declara as variáveis como nulas antes do try 
        //para poder usar no finally
        PreparedStatement comando = null;
        ResultSet resultado = null;

        //crio a lista de usuários, vazia ainda
        List<Local> lista = new ArrayList<>();

        try {
            //prepara o sql, analisando o formato e as váriaveis
            comando = gerenciador.prepararComando(sql);

            //executa o comando e guarda o resultado da consulta 
            //o resultado é semelhante a uma grade
            resultado = comando.executeQuery();

            while (resultado.next()) {
                Local local = new Local();

                local.setPkLocal(resultado.getInt("pklocal"));
                local.setNomeLocal(resultado.getString("nome"));
                local.setNumeroLocal(resultado.getInt("numero"));
                local.setCep(resultado.getInt("CEP"));

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

}
