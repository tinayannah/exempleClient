/*parametres: (1) le nom de la machine Serveur(2) le port d'ecoute du serveur */

import java.io.*;
import java.net.*;

class ClientTCP{

    public static void main (String args[]) throws Exception{
        String phrase, phraseModifiee;

        try{
            //creer le flux d'entree
            BufferedReader entreeDepuisUtilisateur = new BufferedReader(new InputStreamReader(System.in));

            //creer socket client et la connecter au serveur
            Socket socketClient = new Socket("localhost", Integer.parseInt("1"));

            //creer le flux de sortie attaché à la socket
            DataOutputStream sortieVersServeur = new DataOutputStream(socketClient.getOutputStream());

            //creer le flux d'entree attaché à la socket
            BufferedReader entreeDepuisServeur = new BufferedReader(new InputStreamReader(socketClient.getInputStream()));
            phrase = entreeDepuisUtilisateur.readLine();

            //envoyer la chaine au serveur
            sortieVersServeur.writeBytes(phrase + '\n');

            //lire chaine depuis serveur 
            phraseModifiee = entreeDepuisServeur.readLine();

            System.out.println ("reponse serveur : " + phraseModifiee);

            socketClient.close();
        }

        catch(IOException e ){
            System.err.println(e);
        }
    }
}