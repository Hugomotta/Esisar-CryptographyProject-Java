package crypto;

public class Cesar extends Fonction{

    //Attribut  de la classe
    private final int TAILLE_ALPAHABET = 26 ;
    private int decalage ;
    private String message;  

    //Getter et Setter de la classe 
    public int getDecalage(){return this.decalage;}
    public void setDecalage(int nombre){this.decalage = nombre;}
    public String getMessage() {return message;}
    public void setMessage(String message) {this.message = message;}

    //Méthode qui chiffre le message en utilisant l'algorithme de César
    public String chiffrer(){
        String message_chiffre = "" ;
        
        for(char elements : message.toCharArray()){
            if(Character.isLowerCase(elements)){
                char base = 'a' ;
                char c = chr( modulo((ord(elements) - ord(base) + this.decalage), TAILLE_ALPAHABET) + ord(base) ) ;
                message_chiffre += c ;
            }
            else if(Character.isUpperCase(elements)){
                char base = 'A' ;
                char c = chr( modulo(ord(elements) - ord(base) + this.decalage, TAILLE_ALPAHABET) + ord(base) ) ;
                message_chiffre += c ;
            }
            else{
                message_chiffre += elements ;
            }
        }
        return message_chiffre;
    }

    //Méthode qui déchiffre le message en utilisant l'algorithme de César
    public String dechiffrer(String messageCryptee){
        int decalage_dechiffrer = TAILLE_ALPAHABET - this.decalage ;
        String message_dechiffre = "" ;
        
        for(char elements : messageCryptee.toCharArray()){
            if(Character.isLowerCase(elements)){
                char base = 'a' ;
                char c = super.chr( super.modulo((super.ord(elements) - super.ord(base) + decalage_dechiffrer), TAILLE_ALPAHABET) + super.ord(base) ) ;
                message_dechiffre += c ;
            }
            else if(Character.isUpperCase(elements)){
                char base = 'A' ;
                char c = super.chr( super.modulo(super.ord(elements) - super.ord(base) + decalage_dechiffrer, TAILLE_ALPAHABET) + super.ord(base) ) ;
                message_dechiffre += c ;
            }
            else{
                message_dechiffre += elements ;
            }
        }
        return message_dechiffre;
    }  

    //Constructeurs
    public Cesar(){
        this.decalage = 1 ; 
        this.message = "Message par default" ; 
    }
    public Cesar(int decalage){
        this.decalage = decalage ;  
    }
    public Cesar(int decalage, String message) {
        this.decalage = decalage;
        this.message = message;
    }

    //ToString 
    
    @Override
    public String toString() {
        return "TAILLE_ALPAHABET = " + TAILLE_ALPAHABET 
                + "\n Decalage = " + decalage 
                + "\n Message = " + message
                + "\n chiffrer = " + chiffrer() 
                + "\n dechiffrer  = "+ dechiffrer(chiffrer());
    }
    

    
}
