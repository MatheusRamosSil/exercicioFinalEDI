package br.edu.unipe.domain;

import java.util.ArrayList;

import br.edu.unipe.models.DoubleNode;
import br.edu.unipe.models.Funcionario;

public class DoubleListLink {
    
    private DoubleNode<Funcionario> firstNode;
    private DoubleNode<Funcionario> lastNode;
    private int sizeList;

    
    public DoubleListLink() {
        this.firstNode = null;
        this.lastNode = null;
        this.sizeList = 0;
    }
    
    public DoubleNode<Funcionario> getFirstNode() {
        return firstNode;
    }

    public void setFirstNode(DoubleNode<Funcionario> firstNode) {
        this.firstNode = firstNode;
    }

    public DoubleNode<Funcionario> getLastNode() {
        return lastNode;
    }

    public void setLastNode(DoubleNode<Funcionario> lastNode) {
        this.lastNode = lastNode;
    }


    public Funcionario get(int index){
        return this.getNo(index).getConteudo();
    }

    private DoubleNode<Funcionario> getNo(int index) {
        DoubleNode<Funcionario> noAuxiliar = firstNode;
        for(int i=0; (i < index) && (noAuxiliar != null); i++){
            noAuxiliar = noAuxiliar.getNodeNext();
        }
        return noAuxiliar;
    }


	public int size(){
        return this.sizeList;
    }

    public void remove(int index) {
        if(index == 0){
            firstNode = firstNode.getNodeNext();
            if(firstNode != null){
                firstNode.setNodePrevious(null);
            }
        }else{
            DoubleNode<Funcionario> noAuxiliar = getNo(index);
            noAuxiliar.getNodePrevious().setNodeNext(noAuxiliar.getNodeNext());
            if(noAuxiliar != lastNode){
                noAuxiliar.getNodeNext().setNodePrevious(noAuxiliar.getNodePrevious());
            }else{
                lastNode = noAuxiliar;
            }
        }
        this.sizeList--;
    }

	public ArrayList<Funcionario> autocompleteNames(String nomeDoFuncionario, DoubleListLink listFuncionario) {
		
		ArrayList<Funcionario> funcionariosComNomesNaBusca = new ArrayList<>();
		for(int i = 0; i < listFuncionario.size(); i++ ) {
			
			if(listFuncionario.get(i).getNome().contains(nomeDoFuncionario)){
				
				funcionariosComNomesNaBusca.add(listFuncionario.get(i));
			}
		}
		
		return funcionariosComNomesNaBusca;
	}


    public void ordenarListaCrescenteSalario(Funcionario funcionario) {
    	DoubleNode<Funcionario> newNode = new DoubleNode<>(funcionario);
   	    
        
    	if(firstNode == null) {
			
			firstNode = newNode;
	        lastNode = newNode;
	        newNode.setNodeNext(null);
		}else {
			
			DoubleNode<Funcionario> noAuxilia = firstNode;
	        DoubleNode<Funcionario> anterior = null;
			
	        while(noAuxilia != null) {
	        	if (funcionario.getValorDoSalarioLiquido() < noAuxilia.getConteudo().getValorDoSalarioLiquido()) {
	        		break;
	        	}
	        	anterior = noAuxilia;
	        	noAuxilia = noAuxilia.getNodeNext();
	        	
	        }

	    	if (noAuxilia == firstNode) {
	    		newNode.setNodeNext(firstNode);
	    		firstNode = newNode;
	    		
	    	}else {
				anterior.setNodeNext(newNode);
				newNode.setNodeNext(noAuxilia);
					
			}
		}
        
       sizeList++;
	}


}
