public class Carrinho<T> {
    private Object[] elementos;
    private int tamanho;

    // Construtor: inicia com capacidade padrão de 5 posições
    public Carrinho() {
        // Criamos como Object e depois fazemos a conversão interna
        this.elementos = new Object[5];
        this.tamanho = 0;
    }

    // Adiciona qualquer elemento do tipo T
    public void adicionar(T elemento) {
        // Opcional: se quiser, pode chamar um método para garantir capacidade se estourar 5
        if (this.tamanho == this.elementos.length) {
            Object[] novoArray = new Object[this.elementos.length * 2];
            System.arraycopy(this.elementos, 0, novoArray, 0, this.elementos.length);
            this.elementos = novoArray;
        }
        this.elementos[this.tamanho] = elemento;
        this.tamanho++;
    }

    // Esvaziar o carrinho de forma limpa (voltando ao tamanho inicial)
    public void esvaziar() {
        this.elementos = new Object[5];
        this.tamanho = 0;
    }

    // Eliminar um item deslocando os outros para não deixar buracos
    public void remover(int indice) {
        if (indice < 0 || indice >= this.tamanho) {
            throw new IndexOutOfBoundsException("Índice inválido: " + indice);
        }
        
        // Desloca todos os elementos após o índice para a esquerda
        for (int i = indice; i < this.tamanho - 1; i++) {
            this.elementos[i] = this.elementos[i + 1];
        }
        
        this.elementos[this.tamanho - 1] = null; // Limpa o último espaço sobressalente
        this.tamanho--; // Diminui o contador de itens reais
    }

    // Método correto para retornar a representação em texto do carrinho
    @Override
    public String toString() {
        if (this.tamanho == 0) {
            return "Carrinho vazio.";
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append("--- Itens no Carrinho ---\n");
        // Percorre apenas até o 'tamanho' real, ignorando posições vazias do array
        for (int i = 0; i < this.tamanho; i++) {
            sb.append("[").append(i).append("] ").append(this.elementos[i]).append("\n");
        }
        return sb.toString();
    }
}
