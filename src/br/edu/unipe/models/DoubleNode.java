package br.edu.unipe.models;
public class DoubleNode <T> {
    
    private T conteudo;
    private DoubleNode<T> nodeNext;
    private DoubleNode<T> nodePrevious;
   
    public DoubleNode(T conteudo) {
        this.conteudo = conteudo;
    }

    public T getConteudo() {
        return conteudo;
    }

    public void setConteudo(T conteudo) {
        this.conteudo = conteudo;
    }

    public DoubleNode<T> getNodeNext() {
        return nodeNext;
    }

    public void setNodeNext(DoubleNode<T> nodeNext) {
        this.nodeNext = nodeNext;
    }

    public DoubleNode<T> getNodePrevious() {
        return nodePrevious;
    }

    public void setNodePrevious(DoubleNode<T> nodePrevious) {
        this.nodePrevious = nodePrevious;
    }

    
    
}
