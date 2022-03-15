package edu.ntnu.idatt1002.k103.tournament.javaObjects;

import java.util.Locale;

/**
 * The type Person.
 */
// May we have an ID for class person?
public abstract class Person {
    private String name;
    private String surname;
    private String ePost;
    private int telNumber;
    private int rating;

    /**
     * Instantiates a new Person.
     *
     * @param name      the name of the person
     * @param surname   the surname of the person
     * @param ePost     the e post of the person
     * @param telNumber the phone number of the person
     * @throws IllegalArgumentException the illegal argument exception
     */
    public Person(String name, String surname, String ePost, int telNumber)
            throws IllegalArgumentException{
        if(name.isEmpty()) throw new IllegalArgumentException("The name cannot be empty. Define the name of the person");
        if(surname.isEmpty()) throw new IllegalArgumentException("The surname cannot be empty. Define the surname of the person");
        if(ePost.isEmpty()) throw new IllegalArgumentException("The ePost cannot be empty. Define the ePost of the person");
        if(telNumber<9999999 || telNumber>99999999 ) throw new IllegalArgumentException
                ("The telephone number must have 8 cipher. Define a correct telephone number");
        this.name = name.trim().toUpperCase(Locale.ROOT);
        this.surname = surname.trim().toUpperCase(Locale.ROOT);
        this.ePost = ePost.trim();
        this.telNumber = telNumber;
        this.rating = 100;
    }

    /**
     * Gets name.
     *
     * @return the name of the person
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name of the person
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets surname.
     *
     * @return the surname of the person
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Sets surname.
     *
     * @param surname the surname of the person
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * Gets post.
     *
     * @return the post of the person
     */
    public String getePost() {
        return ePost;
    }

    /**
     * Sets post.
     *
     * @param ePost the e post of the person
     */
    public void setePost(String ePost) {
        this.ePost = ePost;
    }

    /**
     * Gets tel number.
     *
     * @return the phone number of the person
     */
    public int getTelNumber() {
        return telNumber;
    }

    /**
     * Sets tel number.
     *
     * @param telNumber the phone number of the person
     */
    public void setTelNumber(int telNumber) {
        this.telNumber = telNumber;
    }

    /**
     * Gets rating.
     *
     * @return the rating of the person
     */
    public int getRating() {
        return rating;
    }

    /**
     * Sets rating.
     *
     * @param rating the rating of the person
     */
    public void setRating(int rating) {
        this.rating = rating;
    }

}
