package ModeloSistema;

public class ModeloEntregaChaves {

    private int codPs;
    private int codPort;
    private int codChv;
    private int codSetor;
    private String dataEntChv;
    private String horaEntChv;
    private String detalhesPs;
    private String obsEntrega;
    private int saiu;    

    public int getCodPs() {
        return codPs;
    }

    public void setCodPs(int codPs) {
        this.codPs = codPs;
    }

    public int getCodPort() {
        return codPort;
    }

    public void setCodPort(int codPort) {
        this.codPort = codPort;
    }

    public int getCodChv() {
        return codChv;
    }

    public void setCodChv(int codChv) {
        this.codChv = codChv;
    }

    public int getCodSetor() {
        return codSetor;
    }

    public void setCodSetor(int codSetor) {
        this.codSetor = codSetor;
    }

    public String getDataEntChv() {
        return dataEntChv;
    }

    public void setDataEntChv(String dataEntChv) {
        this.dataEntChv = dataEntChv;
    }

    public String getHoraEntChv() {
        return horaEntChv;
    }

    public void setHoraEntChv(String horaEntChv) {
        this.horaEntChv = horaEntChv;
    }

    public String getDetalhesPs() {
        return detalhesPs;
    }

    public void setDetalhesPs(String detalhesPs) {
        this.detalhesPs = detalhesPs;
    }

    public String getObsEntregaChave() {
        return obsEntrega;
    }

    public void setObsEntregaChave(String obsEntrega) {
        this.obsEntrega = obsEntrega;
    }

    public int getSaiu() {
        return saiu;
    }

    public void setSaiu(int saiu) {
        this.saiu = saiu;
    }
}
