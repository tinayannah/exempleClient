//parametre port d'ecoute TCP serveur 
import java.io.*;
import java.net.*;

class ServeurTCP{

    public static void main(String args[]) throws Exception{

        String phraseClient , phraseMajuscule;

        try{

            //creer une socket d'ecoute
            ServerSocket socketEcoute = new ServerSocket(Integer.parseInt("1"));
            
            while(true){
                //attendre connexion client
                Socket socketConnexion = socketEcoute.accept();

              //creer flux d'entrée attaché à la socket
               BufferedReader entreeDepuisClient = new BufferedReader(new InputStreamReader(socketConnexion.getInputStream()));

               //creer flux de sortie attache a la socket
               DataOutputStream sortieVersClient =  new DataOutputStream(socketConnexion.getOutputStream());

                //lire la chaine depuis la socket
                phraseClient = entreeDepuisClient.readLine();
               // phraseMajuscule = phraseClient.toUpperCase() + '\n'; //muniscule en majuscule
               phraseMajuscule = good(phraseClient) + '\n';
                System.out.println("Connection from : " + socketConnexion.getInetAddress() + " Message Client " + phraseClient);

                //ecrire au client
                sortieVersClient.writeBytes(phraseMajuscule);

            }//fin boucle attendre un nouvelle connexion
         
        }

        catch(Exception e){
            System.err.println(e);
        }
    }

     public static String good(String calcul){
          
           String a= "";
           String b= "";
           String signe ="";
           int index=0;
           int resultat;
           int i;
           String res;
           
         // recuperer le parametre dde calcul
          for(i=0; i<calcul.length(); i++){
              if(calcul.charAt(i)== '/' || calcul.charAt(i) == '*' ||calcul.charAt(i) =='-' ||calcul.charAt(i) =='+'){
              signe+= calcul.charAt(i);
              index = i;
              break;
              }
              a+= calcul.charAt(i);
          }
          
          for(i=index+1 ; i<calcul.length() ; i++){
              b+=calcul.charAt(i);
          }
         
         if (signe.equals("+")) {
               resultat=Integer.parseInt(a)+Integer.parseInt(b);
               res = String.valueOf(resultat);
            
             } 
        else if (signe.equals("-")) {
               resultat=Integer.parseInt(a)-Integer.parseInt(b);
               res = String.valueOf(resultat);
            
             } 
        else if (signe.equals("*")) {
               resultat=Integer.parseInt(a)*Integer.parseInt(b);
               res = String.valueOf(resultat);
               
             } 
        
         else {
              resultat=Integer.parseInt(a)/Integer.parseInt(b);
              res = String.valueOf(resultat);
            
             }
             return res;
    }

     public static String goodgood(String calcul){
             int 

     }
}