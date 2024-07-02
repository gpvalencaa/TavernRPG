package progressao;

import ambiente.*;

public class Inventario {
    private Item[] itens;
    private int contadorItem;
    //private Queue<Item> itens = new PriorityQueue<Item>();


    //inventario com no maximo 10 itens (fora um item default)
    public Inventario(){
        itens = new Item[11];
        itens[0] = new ItemTavern();
    }


    public void addItem(Item item){
        int indexItem = this.itens.length;
        this.itens[indexItem] = item;
        contadorItem++;
    }

    public int getContadorItem() {
        return contadorItem;
    }
    
}