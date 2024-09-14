package crypto;

public class VernamCipher {
    //Attribut de la classe
    private String message ; 
    private String clef ; 

    //Getter et Setter de la classe
    public String getMessage() {return message;}
    public void setMessage(String message) {this.message = message;}
    public String getClef() {return clef;}
    public void setClef(String clef) {this.clef = clef;}

    
    
    public String chiffrer() {
        
		if(clef.length() < message.length()){
            return "Erreur : la cle est trop courte" ;
        }
		
		StringBuilder encryptedMessage = new StringBuilder() ;
        for (int i = 0; i < message.length(); i++) {
            char charMessage = message.charAt(i);
            char charClef = clef.charAt(i % clef.length()) ;

            // Opération XOR entre le caractère du message et le caractère de la clé
            char encryptedChar = (char) (charMessage ^ charClef) ;
            encryptedMessage.append(encryptedChar);
        }
        return encryptedMessage.toString() ;
    }

    public String dechiffrer(String message_chiffre) {
        // Le déchiffrement est similaire à l'encryption dans le cas de l'opération XOR

        if(clef.length() < message_chiffre.length()){
            return "Erreur : la cle est trop courte" ;
        }
		
		StringBuilder message_dechiffrer = new StringBuilder() ;
        for (int i = 0; i < message_chiffre.length(); i++) {
            char charMessage = message_chiffre.charAt(i);
            char charClef = clef.charAt(i % clef.length()) ;

            // Opération XOR entre le caractère du message et le caractère de la clé
            char char_dechiffrer = (char) (charMessage ^ charClef) ;
            message_dechiffrer.append(char_dechiffrer);
        }
        return message_dechiffrer.toString() ;
    }

    //Constructeur 
    public VernamCipher(String message, String clef) {
        this.message = message;
        this.clef = clef;
    }
    public VernamCipher(String message) {
        this.message = message;
        this.clef = message ;
    }
    public VernamCipher() {
        this.message = "Message par default" ;
        this.clef = this.message ; 
    }

    //ToString 
    @Override
    public String toString() {
        return "message = " + message 
                + "\n clef = " + clef 
                + "\n cryptage() = \n" + chiffrer();
    }

    



}
