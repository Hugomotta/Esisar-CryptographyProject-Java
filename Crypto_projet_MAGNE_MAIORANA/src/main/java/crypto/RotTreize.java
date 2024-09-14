/*
Le code ROT13 est un cas particulier du chiffrement Cesar avec un decalage precis de 13 caractères.
On aura donc pas besoin d'avoir une variable de clé de chiffrement

En pratique, lors du traitement d'un texte, les implémentations de ROT13 ne remplacent que les lettres non accentuées,
 et laissent inchangés les autres caractères, tels que les lettres accentuées, les chiffres et la ponctuation. 
*/

package crypto;

public class RotTreize extends Fonction{
    
    //Attribut de la classe 
    private final int TAILLE_ALPAHABET = 26 ;
    private String message; 

    // Getter et Setter de la classe 
    public String getMessage() {return message;}
    public void setMessage(String message) {this.message = message;}
    
    //Méthode qui chiffre le message en utilisant l'algorithme de César avec un décalage de 13
    public String chiffrer(){
    /*  Pas besoin de donner de condition sur la cle etant donné qu'on l'a connait et qu'elle est congru à elle meme modulo(26) */
        
        String message_chiffre = "" ;
        
        for(char elements : message.toCharArray()){
            if(Character.isLowerCase(elements)){
                char base = 'a' ;
                char c = chr( modulo(ord(elements) - ord(base) + 13,TAILLE_ALPAHABET) + ord(base) ) ;
                message_chiffre += c ;
                
            }
            else if(Character.isUpperCase(elements)){
                char base = 'A' ;
                char c = chr( modulo(ord(elements) - ord(base) + 13,TAILLE_ALPAHABET) + ord(base) ) ;
                message_chiffre += c ;
            }
            else{
                message_chiffre += elements ;
            }
        }
        return message_chiffre;
    }

    //Méthode qui déchiffre le message en utilisant l'algorithme de César avec un décalage de 13 
    public String dechiffrer(String messageCryptee){
        
        String message_dechiffre = "" ;

        for(char elements : messageCryptee.toCharArray()){
            if(Character.isLowerCase(elements)){
                char base = 'a' ;
                char c = chr( modulo(ord(elements) - ord(base) + 13,TAILLE_ALPAHABET) + ord(base) ) ;
                message_dechiffre += c ;
                
            }
            else if(Character.isUpperCase(elements)){
                char base = 'A' ;
                char c = chr( modulo(ord(elements) - ord(base) + 13,TAILLE_ALPAHABET) + ord(base) ) ;
                message_dechiffre += c ;
            }
            else{
                message_dechiffre += elements ;
            }
        }
        return message_dechiffre;
    }
    
    
    //Constructeurs 
    public RotTreize(){
        this.message = "Message par default" ; 
    }
    public RotTreize(String message) {
        this.message = message;
    }

    //ToString 
    @Override
    public String toString() {
        return "TAILLE_ALPAHABET = " + TAILLE_ALPAHABET 
               + "\n Message = " + message 
               + "\n chiffrer() = " + chiffrer() 
               + "\n déchiffrer = " + dechiffrer(chiffrer());
    }

}



    
