package com.courier.model;

/**
 * Model class representing a Courier entity.
 */
public class Courier {
    private int courierId;
    private String name;
    private String contact;
    private String region;
    private int itemsDelivered;
    private String visitDate; // Format: yyyy-MM-dd. Consider using LocalDate for better type safety.
    private double hours;

    /**
     * Parameterized constructor.
     *
     * @param courierId       Unique ID for the courier
     * @param name            Name of the courier
     * @param contact         Contact number
     * @param region          Service region
     * @param itemsDelivered  Number of items delivered
     * @param visitDate       Date of visit (e.g., "2025-07-24")
     * @param hours           Hours worked
     */
    public Courier(int courierId, String name, String contact, String region,
                   int itemsDelivered, String visitDate, double hours) {
        this.courierId = courierId;
        this.name = name;
        this.contact = contact;
        this.region = region;
        this.itemsDelivered = itemsDelivered;
        this.visitDate = visitDate;
        this.hours = hours;
    }

    /**
     * Default no-argument constructor.
     */
    public Courier() {
    }

    // Getters and Setters
    public int getCourierId() {
        return courierId;
    }

    public void setCourierId(int courierId) {
        this.courierId = courierId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public int getItemsDelivered() {
        return itemsDelivered;
    }

    public void setItemsDelivered(int itemsDelivered) {
        this.itemsDelivered = itemsDelivered;
    }

    public String getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(String visitDate) {
        this.visitDate = visitDate;
    }

    public double getHours() {
        return hours;
    }

    public void setHours(double hours) {
        this.hours = hours;
    }

    /**
     * Returns a string representation of the courier object.
     */
    @Override
    public String toString() {
        return "Courier {" +
                "courierId=" + courierId +
                ", name='" + name + '\'' +
                ", contact='" + contact + '\'' +
                ", region='" + region + '\'' +
                ", itemsDelivered=" + itemsDelivered +
                ", visitDate='" + visitDate + '\'' +
                ", hours=" + hours +
                '}';
    }
}
