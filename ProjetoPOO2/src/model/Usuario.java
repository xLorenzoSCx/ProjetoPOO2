package model;

import javax.swing.Icon;

public class Usuario {

    private int pkUsuario;
    private String nome;
    private String crm;
    private int telefone;
    private String senha;
    private Icon image;

    public Usuario() {
    }

    public Usuario(int pkUsuario, String nome, String crm, int telefone, String senha, Icon image) {
        this.pkUsuario = pkUsuario;
        this.nome = nome;
        this.crm = crm;
        this.telefone = telefone;
        this.senha = senha;
        this.image = image;
    }

    public int getPkUsuario() {
        return pkUsuario;
    }

    public void setPkUsuario(int pkUsuario) {
        this.pkUsuario = pkUsuario;
    }

    public Icon getImage() {
        return image;
    }

    public void setImage(Icon image) {
        this.image = image;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Usuario{" + "pkUsuario=" + pkUsuario + ", nome=" + nome + '}';
    }
    
    
    

}
