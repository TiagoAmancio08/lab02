public class RegistroTempoOnline {

    private String nomeDisciplina;
    private int tempoOnline;
    private int tempoOnlineEsperado;

    public RegistroTempoOnline(String nomeD) {
        this.nomeDisciplina = nomeD;
        this.tempoOnlineEsperado = 120;
        this.tempoOnline = 0;
    }

    public RegistroTempoOnline(String nomeD, int tempoOnlineEsperado) {
        this.nomeDisciplina = nomeD;
        this.tempoOnlineEsperado = tempoOnlineEsperado;
        this.tempoOnline = 0;
    }

    public void adicionaTempoOnline(int tempo) {
        this.tempoOnline += tempo;
    }

    public boolean atingiuMetaTempoOnline() {
        return tempoOnline >= tempoOnlineEsperado;
    }

    public String toString() {
        return nomeDisciplina + " " + tempoOnline + "/" + tempoOnlineEsperado;
    }

}