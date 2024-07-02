package ambiente;

public abstract class Item {
    private String nomeItem;
    private int precoItem;

    public Item (String nome, int precoItem){
        nomeItem = nome;
        this.precoItem = precoItem;
    }

    public String getNome(){
        return this.nomeItem;
    }
    public int getPrecoItem() {
    	return precoItem;
    }
}
