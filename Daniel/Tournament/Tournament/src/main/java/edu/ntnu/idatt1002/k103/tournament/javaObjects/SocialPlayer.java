package edu.ntnu.idatt1002.k103.tournament.javaObjects;

public class SocialPlayer extends Person{
    /**
     * social player, has an id of -1 to signify not being a member of ntnui
     * @param name name of player
     * @param surname surname of player
     * @param epost email of player
     * @param telnumber phone number of player
     */
    public SocialPlayer(String name, String surname, String epost, int telnumber){
        super(name, surname, epost, telnumber);
    }
}
