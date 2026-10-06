public class RegistroResumos {
    private String[] temas;
    private String[] conteudos;
    private int quantidade;
    private int proximo;

    public RegistroResumos(int numeroDeResumos) {
        this.temas = new String[numeroDeResumos];
        this.conteudos = new String[numeroDeResumos];
        this.quantidade = 0;
        this.proximo = 0;
    }

    public void adicionaResumo(String tema, String conteudo) {
        if (temResumo(tema)) {
            return;
        }

        temas[proximo] = tema;
        conteudos[proximo] = conteudo;

        if (quantidade < temas.length) {
            quantidade++;
        }

        proximo = (proximo + 1) % temas.length;
    }

    public void adiciona(String tema, String conteudo) {
        adicionaResumo(tema, conteudo);
    }

    public String[] pegaResumos() {
        String[] resumos = new String[quantidade];

        int inicio = (quantidade == temas.length) ? proximo : 0;

        for (int i = 0; i < quantidade; i++) {
            int indice = (inicio + i) % temas.length;
            resumos[i] = temas[indice] + ": " + conteudos[indice];
        }

        return resumos;
    }

    public String imprimeResumos() {
        String resultado = "- " + quantidade +
                " resumo(s) cadastrado(s)\n- ";

        for (int i = 0; i < quantidade; i++) {
            int indice = (quantidade == temas.length)
                    ? (proximo + i) % temas.length
                    : i;

            resultado += temas[indice];

            if (i < quantidade - 1) {
                resultado += " | ";
            }
        }

        return resultado;
    }
// metodo redundante
    public int conta() {
        return quantidade;
    }

    public boolean temResumo(String tema) {
        for (int i = 0; i < quantidade; i++) {
            int indice = (quantidade == temas.length)
                    ? (proximo + i) % temas.length
                    : i;

            if (temas[indice].equals(tema)) {
                return true;
            }
        }

        return false;
    }
}