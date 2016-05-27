package com.kenhia.ps;

import java.util.EventObject;

public class FormEvent extends EventObject {
    private String name;
    private String occupation;
    private int ageCategory;


    private String employmentCategory;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getOccupation() { return occupation; }
    public void setOccupation(String occupation) { this.occupation = occupation; }
    public int getAgeCategory() { return ageCategory; }
    public void setAgeCategory(int ageCategory) { this.ageCategory = ageCategory; }
    public String getEmploymentCategory() { return employmentCategory; }
    public void setEmploymentCategory(String employmentCategory) { this.employmentCategory = employmentCategory;}

    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public FormEvent(Object source) {
        super(source);
    }

    public FormEvent(Object source, String name, String occupation, int ageCategory, String employmentCategory) {
        super(source);
        this.name = name;
        this.occupation = occupation;
        this.ageCategory = ageCategory;
        this.employmentCategory = employmentCategory;
    }
}
