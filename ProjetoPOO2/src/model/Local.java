package model;

public class Local {

    private int pkLocal;
    private String nomeLocal;
    private int numeroLocal;
    private int cep;

    public Local() {
    }

    public Local(int pkLocal, String nomeLocal, int numeroLocal, int cep) {
        this.pkLocal = pkLocal;
        this.nomeLocal = nomeLocal;
        this.numeroLocal = numeroLocal;
        this.cep = cep;
    }

    public int getPkLocal() {
        return pkLocal;
    }

    public void setPkLocal(int pkLocal) {
        this.pkLocal = pkLocal;
    }

    public String getNomeLocal() {
        return nomeLocal;
    }

    public void setNomeLocal(String nomeLocal) {
        this.nomeLocal = nomeLocal;
    }

    public int getNumeroLocal() {
        return numeroLocal;
    }

    public void setNumeroLocal(int numeroLocal) {
        this.numeroLocal = numeroLocal;
    }

    public int getCep() {
        return cep;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }

    @Override
    public String toString() {
        return "Local{" + "pkLocal=" + pkLocal + ", nomeLocal=" + nomeLocal + '}';
    }

}
