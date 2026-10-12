public class RegistroResumos {
    private Resumo[] resumos;
    private int quantidade;
    private int proximo;

    public RegistroResumos(int numeroDeResumos) {
        this.resumos = new Resumo[numeroDeResumos];
        this.quantidade = 0;
        this.proximo = 0;
    }

    public void adicionaResumo(String tema, String conteudo) {
        if (temResumo(tema)) {
            return;
        }

        resumos[proximo] = new Resumo(tema, conteudo);

        if (quantidade < resumos.length) {
            quantidade++;
        }

        proximo = (proximo + 1) % resumos.length;
    }

    public void adiciona(String tema, String conteudo) {
        adicionaResumo(tema, conteudo);
    }

    public String[] pegaResumos() {
        String[] resumos = new String[quantidade];

        int inicio = (quantidade == this.resumos.length) ? proximo : 0;

        for (int i = 0; i < quantidade; i++) {
            int indice = (inicio + i) % this.resumos.length;
            resumos[i] = this.resumos[indice].getTema() + ": " + this.resumos[indice].getConteudo();
        }

        return resumos;
    }

    public String imprimeResumos() {
        String resultado = "- " + quantidade +
                " resumo(s) cadastrado(s)\n- ";

        for (int i = 0; i < quantidade; i++) {
            int indice = (quantidade == resumos.length)
                    ? (proximo + i) % resumos.length
                    : i;

            resultado += resumos[indice].getTema();

            if (i < quantidade - 1) {
                resultado += " | ";
            }
        }

        return resultado;
    }
// metodo redundante
    public int contaResumos() {
        return quantidade;
    }

    public boolean temResumo(String tema) {
        for (int i = 0; i < quantidade; i++) {
            int indice = (quantidade == resumos.length)
                    ? (proximo + i) % resumos.length
                    : i;

            if (resumos[indice].getTema().equals(tema)) {
                return true;
            }
        }

        return false;
    }


    public String[] busca(String chaveDeBusca) {
        String[] encontrados = new String[quantidade];
        int total = 0;

        for (int i = 0; i < quantidade; i++) {
            int indice = (quantidade == resumos.length)
                    ? (proximo + i) % resumos.length
                    : i;

            String conteudo = resumos[indice].getConteudo();

            if (conteudo.toLowerCase().contains(chaveDeBusca.toLowerCase())) {
                encontrados[total] = resumos[indice].getTema();
                total++;
            }
        }

        String[] resultado = new String[total];

        for (int i = 0; i < total; i++) {
            resultado[i] = encontrados[i];
        }

        ordena(resultado);
        return resultado;
    }

    private void ordena(String[] temas) {
        for (int i = 0; i < temas.length - 1; i++) {
            for (int j = 0; j < temas.length - 1 - i; j++) {
                if (temas[j].compareToIgnoreCase(temas[j + 1]) > 0) {
                    String temporario = temas[j];
                    temas[j] = temas[j + 1];
                    temas[j + 1] = temporario;
                }
            }
        }
    }

}