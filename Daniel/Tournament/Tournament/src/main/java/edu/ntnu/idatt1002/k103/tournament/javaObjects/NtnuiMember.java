package edu.ntnu.idatt1002.k103.tournament.javaObjects;

public class NtnuiMember extends Person{

    private int id;
    /**
     * NTNUI member, has an id meaning the player can compete in the open tournament.
     * @param name name of the player
     * @param surname surname of the player
     * @param epost email of the player
     * @param telnumber phone number of the player
     * @param id ntnui membership id
     */
    public NtnuiMember(String name, String surname, String epost, int telnumber, int id){
        super(name, surname, epost, telnumber);
        this.id = id;
    }

    public int getId(){
        return id;
    }
}
