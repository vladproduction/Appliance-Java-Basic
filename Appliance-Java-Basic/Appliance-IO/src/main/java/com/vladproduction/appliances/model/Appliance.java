package com.vladproduction.appliances.model;

import java.util.Objects;

public class Appliance {
    private long id;
    private String name;
    private Category category;
    private String model;
    private long manufactureId;
    private PowerType powerType;
    private String characteristic;
    private String description;
    private int power;

    public Appliance() {
    }

    public Appliance(long id, String name, Category category, String model, long manufactureId, PowerType powerType, String characteristic, String description, int power) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.model = model;
        this.manufactureId = manufactureId;
        this.powerType = powerType;
        this.characteristic = characteristic;
        this.description = description;
        this.power = power;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public long getManufactureId() {
        return manufactureId;
    }

    public void setManufactureId(long manufactureId) {
        this.manufactureId = manufactureId;
    }

    public PowerType getPowerType() {
        return powerType;
    }

    public void setPowerType(PowerType powerType) {
        this.powerType = powerType;
    }

    public String getCharacteristic() {
        return characteristic;
    }

    public void setCharacteristic(String characteristic) {
        this.characteristic = characteristic;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Appliance appliance = (Appliance) o;
        return id == appliance.id && manufactureId == appliance.manufactureId && power == appliance.power && Objects.equals(name, appliance.name) && category == appliance.category && Objects.equals(model, appliance.model) && powerType == appliance.powerType && Objects.equals(characteristic, appliance.characteristic) && Objects.equals(description, appliance.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, category, model, manufactureId, powerType, characteristic, description, power);
    }

    @Override
    public String toString() {
        return "Appliance{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category=" + category +
                ", model='" + model + '\'' +
                ", manufactureId=" + manufactureId +
                ", powerType=" + powerType +
                ", characteristic='" + characteristic + '\'' +
                ", description='" + description + '\'' +
                ", power=" + power +
                '}';
    }
}
