package crypto;

public class test {

	public static void main(String[] args) {

		String message = "Message a dechiffrer " ;
		
		//ROT13 
		
		System.out.println("\n ROT13 :\n") ;
        RotTreize rot13 = new RotTreize(message) ;
        System.out.println("Affichage : \n " + rot13.toString());
		System.out.println(("test : " + rot13.getMessage()+ "\n")) ;
		
        //César

        System.out.println("\n CESAR :\n");
        Cesar caesar = new Cesar(10,message) ;
		System.out.println("Affichage : \n" + caesar.toString());

		//MonoAlphabetique 
		
		System.out.println("\n MONOALPHETIQUE : \n");
		MonoAlphabetique cryptage = new MonoAlphabetique(message) ;
		System.out.println("Affichage :\n " + cryptage.toString()); 

		//Vernam 
		
		System.out.println("\n Vernam : \n");
		VernamCipher Vernam = new VernamCipher(message, "Message par default trop long") ;
		System.out.println("Affichage :\n " + Vernam.toString()); 
	}

}
