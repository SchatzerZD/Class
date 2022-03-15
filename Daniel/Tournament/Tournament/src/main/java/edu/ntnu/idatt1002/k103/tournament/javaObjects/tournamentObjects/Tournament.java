package edu.ntnu.idatt1002.k103.tournament.javaObjects.tournamentObjects;

import edu.ntnu.idatt1002.k103.tournament.javaObjects.Match;
import edu.ntnu.idatt1002.k103.tournament.javaObjects.Person;


import java.util.*;

/**
 * The type Tournament.
 */
public abstract class Tournament {
    private final ArrayList<Person> players;
    private ArrayList<Match> matches;

    /**
     * Instantiates a new Tournament.
     *
     * @param players the players that competes in the tournament.
     */
    public Tournament(ArrayList<Person> players) {
        this.players = new ArrayList<>(players);
        this.matches = new ArrayList<>();
    }

    /**
     * generates matches based on the amount of players and their rating.
     *
     */
    // what will happen with the last player when the number of player is odd.
    private void generateMatches(){
        players.sort(Comparator.comparing(Person::getRating));
        if((players.size()&2) ==0){
            for(int i=0; i<players.size();i=+2){
                matches.add(new Match(players.get(i), players.get(i+1) ));
            }
        } else {
            for(int i=0; i<players.size()-1;i=+2){
                matches.add(new Match(players.get(i), players.get(i+1) ));
            }
        }


    }
}

