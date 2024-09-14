package crypto;
import java.util.ArrayList ;
import java.util.Collections ;


public class MonoAlphabetique {

    // Attribut  de la classe
    private final int nombreCaractere = 78 ; 
    private char[][] tableauSubstitution = new char[2][nombreCaractere] ;
    private String message ;
    
    // Getter et Setter de la classe 
    public char[][] getTableauSubstitution() {return tableauSubstitution;}
    public void setTableauSubstitution(char[][] tS) {this.tableauSubstitution = tS;}
    public String getMessage() {return message;}
    public void setMessage(String message) {this.message = message;}
    
    //Permet de générer un tableau de cryptage de manière aléatoire
    public void genererSubstitution(){
        ArrayList<Character> caracteresCryptes = new ArrayList<>() ;

        //On ajoute les lettres dans une liste
        //Minuscule
        for(char c = 'a' ; c <= 'z'; c++){
            caracteresCryptes.add(c) ;
        }
        //Majuscule
        for(char c = 'A' ; c <= 'Z' ; c++){
            caracteresCryptes.add(c) ;
        }
        //Lettre avec accent 
        for(char c ='à' ; c <= 'ú'; c++){
            caracteresCryptes.add(c) ;
        }

        //Mélange des caractères
        Collections.shuffle(caracteresCryptes) ;

        //On remplit notre tableau des lettres alphabétiques en minuscules, en majuscules et celles avec des accents
        for(int i = 0; i < 26; i++){
            tableauSubstitution[0][i] = (char)('a' + i) ;
            tableauSubstitution[0][26 + i] = (char)('A' + i) ;
            tableauSubstitution[0][52 + i] = (char)('à'+ i) ;  
        }

        //On ajoute les caractères cryptées sur la deuxième ligne du tableau
        for(int j = 0; j < nombreCaractere ; j++){
            tableauSubstitution[1][j] = caracteresCryptes.get(j) ;
        }
        
    }
    
    
    //Méthode qui chiffre le message
    public String chiffrer(){
        String messageCrypte = "" ;

        for(char charactere : this.message.toCharArray()){
        	// Parcours de tableau pour trouver notre caractère 
        	int k ;
            for(k = 0 ; k < nombreCaractere ; k++){
            	
                if(charactere == tableauSubstitution[0][k]){
                	messageCrypte += tableauSubstitution[1][k] ;
                	break;
                }
 
            }
            if (k == 78) {
            	messageCrypte += charactere ;
            }
            
        }
        
        return messageCrypte ;
    }

    //Méthode qui déchiffre le message
    public String dechiffrer(String messageCrypte){
        String messageDecrypte = "" ;
        
        //Parcours de notre message caractère par caractère 
        for(char charactere : messageCrypte.toCharArray()){
        	
        	int k ;
        	//Parcours de tableau pour trouver notre caractère 
            for(k = 0 ; k < nombreCaractere ; k++){
            	
                if (charactere == tableauSubstitution[1][k]){
                	messageDecrypte += tableauSubstitution[0][k] ;   
                	break;
                }
            }
            
            
            if (k == 78 ) {
            	messageDecrypte += charactere ;
            }
        }
        return messageDecrypte ;
    }

    //Constructeurs 
    public MonoAlphabetique(){
        genererSubstitution();
        this.message = "Message par défault" ;
    }

    public MonoAlphabetique(char[][] alphabet){
        this.tableauSubstitution = alphabet ;
        this.message = "Message par défault" ;
    }

    public MonoAlphabetique(String message) {
        this.message = message;
        genererSubstitution();
    }

    public MonoAlphabetique(char[][] tableauSubstitution, String message) {
        this.tableauSubstitution = tableauSubstitution;
        this.message = message;
    }

    //ToString
    @Override
    public String toString() {
        return "nombreCaractere = " + nombreCaractere 
                + "\n Message = " + message 
                + "\n chiffrer = " + chiffrer() 
                + "\n déchiffrage = "  + dechiffrer(chiffrer()) ;
    }
    
    

}


