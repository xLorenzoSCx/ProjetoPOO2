package model;

public class Consulta {

    private int medicoId;
    private String medico;

    private int pacienteId;
    private String paciente;

    private int LocalId;
    private String Local;

    public Consulta() {
    }

    public Consulta(int medicoId, String medico, int pacienteId, String paciente, int LocalId, String Local) {
        this.medicoId = medicoId;
        this.medico = medico;
        this.pacienteId = pacienteId;
        this.paciente = paciente;
        this.LocalId = LocalId;
        this.Local = Local;
    }

    public int getMedicoId() {
        return medicoId;
    }

    public void setMedicoId(int medicoId) {
        this.medicoId = medicoId;
    }

    public String getMedico() {
        return medico;
    }

    public void setMedico(String medico) {
        this.medico = medico;
    }

    public int getPacienteId() {
        return pacienteId;
    }

    public void setPacienteId(int pacienteId) {
        this.pacienteId = pacienteId;
    }

    public String getPaciente() {
        return paciente;
    }

    public void setPaciente(String paciente) {
        this.paciente = paciente;
    }

    public int getLocalId() {
        return LocalId;
    }

    public void setLocalId(int LocalId) {
        this.LocalId = LocalId;
    }

    public String getLocal() {
        return Local;
    }

    public void setLocal(String Local) {
        this.Local = Local;
    }

}
