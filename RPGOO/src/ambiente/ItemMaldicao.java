package ambiente;

import seres.Entidade;

public class ItemMaldicao extends Item{
    public ItemMaldicao (){
        super("Maldição", 300);
    }
    
    public void tiraVida(Entidade amaldicoada){
        amaldicoada.alteraVida(-25);
    }


    
}
