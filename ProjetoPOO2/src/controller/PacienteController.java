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
import model.Paciente;

public class PacienteController {

    public boolean inserir(Paciente paciente) {

        String sql = "INSERT into paciente (nome, CPF, senha, telefone, email, datanasc)" + "values (?,?,?,?,?,?)";

        GerenciadorConexao gerenciador = new GerenciadorConexao();

        PreparedStatement comando = null;

        try {

            comando = gerenciador.prepararComando(sql);

            comando.setString(1, paciente.getNome());
            comando.setInt(2, paciente.getCpf());
            comando.setString(3, paciente.getSenha());
            comando.setInt(4, paciente.getTelefone());
            comando.setString(5, paciente.getEmail());
            comando.setDate(6, new java.sql.Date(paciente.getDatanasc().getTime()));

            comando.executeUpdate();

            return true;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            gerenciador.fecharConexao(comando);

        }
        return false;

    }

    public List<Paciente> consultarPaciente(int opcaoFiltro, String filtro) {
        //Montar o comando a ser executado
        //os ? são variáveis que são preenchidas mais adiante
        String sql = "SELECT * from paciente ";

        //Cria uma instância do gerenciador de conexão
        //(conexão com o banco de dados),
        GerenciadorConexao gerenciador = new GerenciadorConexao();

        //Declara as variáveis como nulas antes do try 
        //para poder usar no finally
        PreparedStatement comando = null;
        ResultSet resultado = null;

        //crio a lista de usuários, vazia ainda
        List<Paciente> lista = new ArrayList<>();

        try {
            //prepara o sql, analisando o formato e as váriaveis
            comando = gerenciador.prepararComando(sql);

            //executa o comando e guarda o resultado da consulta 
            //o resultado é semelhante a uma grade
            resultado = comando.executeQuery();

            while (resultado.next()) {
                Paciente paciente = new Paciente();

                paciente.setPkPaciente(resultado.getInt("pkpaciente"));
                paciente.setNome(resultado.getString("nome"));
                paciente.setCpf(resultado.getInt("CPF"));
                paciente.setSenha(resultado.getString("senha"));
                paciente.setTelefone(resultado.getInt("telefone"));
                paciente.setEmail(resultado.getString("email"));
                paciente.setDatanasc(resultado.getDate("datanasc"));

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
