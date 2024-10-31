package com.vladproduction.appliances.collection;

import com.vladproduction.appliances.model.Appliance;
import com.vladproduction.appliances.model.Manufacturer;
import com.vladproduction.appliances.model.Order;

import java.util.Set;

public interface Sort {
    Set<Manufacturer> sortManufacturersByName();

    Set<Order> sortOrderByClientId();

    Set<Appliance> sortAppliancesByCategory();

    Set<Order> sortOrderByAmount();
}
