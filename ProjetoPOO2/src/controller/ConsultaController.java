
package controller;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Consulta;
import model.Local;

public class ConsultaController {
    
    
    public boolean inserir(Consulta consulta) {

        String sql = "INSERT into consulta (medico, paciente, local)" + "values (?,?,?)";

        GerenciadorConexao gerenciador = new GerenciadorConexao();

        PreparedStatement comando = null;

        try {

            comando = gerenciador.prepararComando(sql);

            comando.setString(1, consulta.getMedico());
            comando.setString(2, consulta.getPaciente());
            comando.setString(3, consulta.getLocal());

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
