package crypto;

public abstract class Fonction {
    
    //Méthode utilisé dans les classes RotTreize et Cesar 
    public int ord(char caractere){
        return (int)caractere ;
    }

    public char chr(int entier){
        return (char)entier ;
    }

    public int modulo(int a, int b){
        int c = 0 ;
        if(b != 0){
            c = a%b ;
        }
        return c ;
    }

    //Contructeur
    public Fonction(){}
}
