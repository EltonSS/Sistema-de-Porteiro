
package ModeloSistema;

public class ModeloPrestadorServico {
    private int codPts; 
    private String nomePts;
    private String descForn;

    public int getCodPts() {
        return codPts;
    }

    public void setCodPts(int codPts) {
        this.codPts = codPts;
    }

    public String getNomePts() {
        return nomePts;
    }

    public void setNomePts(String nomePts) {
        this.nomePts = nomePts;
    }

    public String getDescForn() {
        return descForn;
    }

    public void setDescForn(String descForn) {
        this.descForn = descForn;
    }
}