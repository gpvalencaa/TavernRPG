package progressao;

import ambiente.*;
import exceptions.InventarioCheioException;
import seres.Jogador;

public class Inventario {
    private Item[] itens;
    private int contadorItem;
    public Jogador jogador;
    //private Queue<Item> itens = new PriorityQueue<Item>();


    //inventario com no maximo 10 itens (fora um item default)
    public Inventario(Jogador jogador){
    	this.jogador = jogador;
        itens = new Item[11];
        itens[0] = new ItemTavern();
        contadorItem = 1;
    }


   /* public void addItem(Item item) //throws InventarioCheioException{
    {
    	if (contadorItem > 11) {
    	this.itens[contadorItem] = item;
        contadorItem = contadorItem + 1;
        System.out.println(contadorItem);
    	} //else {
    		//throw new InventarioCheioException();
    	//}
    }*/

    public int getContadorItem() {
        return contadorItem;
    }
    
    public void addItem(Item item) throws InventarioCheioException{
    	if(contadorItem <= 11) {
    		this.itens[contadorItem] = item;
    		contadorItem = contadorItem +1;
    	} else throw new InventarioCheioException();
    }
    
    public Item[] getArrItem() {
    	return itens;
    }
    
    public void removeItem(int posicao) {
    	itens[posicao] = null;
    	contadorItem = contadorItem - 1;
    }
    
    public int getLenghtArrItem() {
    	return itens.length;
    }
}