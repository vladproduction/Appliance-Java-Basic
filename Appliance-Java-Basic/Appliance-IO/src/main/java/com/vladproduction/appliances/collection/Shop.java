package com.vladproduction.appliances.collection;

import com.vladproduction.appliances.model.*;

import java.math.BigDecimal;
import java.util.*;

public class Shop implements Add, Sort, Find {

    private Set<Client> clients;
    private Set<Employee> employees;
    private Set<Order> orders;
    private Set<Appliance> appliances;
    private Set<Manufacturer> manufacturers;

    public Shop() {
        this.clients = new HashSet<>();
        this.employees = new HashSet<>();
        this.orders = new HashSet<>();
        this.appliances = new HashSet<>();
        this.manufacturers = new HashSet<>();
    }


    //sets managing methods:
    public void removeClient(Client client) {
        clients.remove(client);
    }

    public Set<Client> getClients() {
        return clients;
    }

    public void removeEmployee(Employee employee) {
        employees.remove(employee);
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void removeOrder(Order order) {
        orders.remove(order);
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void removeAppliance(Appliance appliance) {
        appliances.remove(appliance);
    }

    public Set<Appliance> getAppliances() {
        return appliances;
    }

    public void removeManufacturer(Manufacturer manufacturer) {
        manufacturers.remove(manufacturer);
    }

    public Set<Manufacturer> getManufacturers() {
        return manufacturers;
    }

    //implemented Add interface methods:
    public void addClient(Client client) {
        clients.add(client);
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public void addAppliance(Appliance appliance) {
        appliances.add(appliance);
    }

    public void addManufacturer(Manufacturer manufacturer) {
        manufacturers.add(manufacturer);
    }

    //implemented Find interface methods:
    @Override
    public Manufacturer findManufacturerById(long id) {
        for (Manufacturer manufacturer : manufacturers) {
            if (manufacturer.getId() == id) {
                return manufacturer;
            }
        }
        throw new RuntimeException("Manufacturer with id=" + id + " was not found");
    }

    @Override
    public Manufacturer findManufacturerByName(String name) {
        for (Manufacturer manufacturer : manufacturers) {
            if (name.equals(manufacturer.getName())) {
                return manufacturer;
            }
        }
        throw new RuntimeException("Manufacturer with name=" + name + " was not found");
    }

    @Override
    public List<Order> findOrderByEmployee(Employee employee) {
        List<Order> ordersByEmployee = new ArrayList<>();
        for (Order order : orders) {
            if (employee == null) {
                if (order.getEmployeeId() == 0) {
                    ordersByEmployee.add(order);
                }
            } else {
                if (employee.equals(order.getEmployeeId())) {
                    ordersByEmployee.add(order);
                }
            }
        }
        return ordersByEmployee;
    }

    @Override
    public Order findCheapestOrder() {
        if (orders.isEmpty()) {
            throw new RuntimeException("Order not found");
        }
        Order cheapestOrder = null;
        for (Order order : orders) {
            if (cheapestOrder == null || order.getTotalPrice().compareTo(cheapestOrder.getTotalPrice()) < 0) {
                cheapestOrder = order;
            }
        }
        return cheapestOrder;
    }

    @Override
    public Order findMostExpensiveOrder() {
        if (orders.isEmpty()) {
            throw new RuntimeException("Order not found");
        }
        Order mostExpensiveOrder = null;
        for (Order order : orders) {
            if (mostExpensiveOrder == null || order.getTotalPrice().compareTo(mostExpensiveOrder.getTotalPrice()) > 0) {
                mostExpensiveOrder = order;
            }
        }
        return mostExpensiveOrder;
    }

    //implemented Sort interface methods:
    @Override
    public Set<Manufacturer> sortManufacturersByName() {
        Set<Manufacturer> sortedManufacturers = new TreeSet<>(new Comparator<Manufacturer>() {
            @Override
            public int compare(Manufacturer m1, Manufacturer m2) {
                //if both are null --> considered equal.
                if (m1.getName() == null && m2.getName() == null) {
                    return 0;
                }
                //greater --> goes bottom
                if(m1.getName() == null){
                    return 1;
                }
                //m1 is greater and stands first then m2
                if (m2.getName() == null){
                    return -1;
                }
                //comparing in natural order
                return m1.getName().compareTo(m2.getName());
            }
        });
        sortedManufacturers.addAll(manufacturers);

        return sortedManufacturers;
    }

    @Override
    public Set<Order> sortOrderByClientId() {
        Set<Order> sortedOrders = new TreeSet<>(new Comparator<Order>() {
            @Override
            public int compare(Order o1, Order o2) {
                if (o1.getClientId() == 0 && o2.getClientId() == 0) {
                    return 0;
                }
                if (o1.getClientId() == 0) {
                    return 1;
                }
                if (o2.getClientId() == 0) {
                    return -1;
                }
                return Long.compare(o1.getClientId(), o2.getClientId());
            }
        });
        sortedOrders.addAll(orders);
        return sortedOrders;
    }

    @Override
    public Set<Appliance> sortAppliancesByCategory() {
        Set<Appliance> sortedAppliancesByCategory = new TreeSet<>(new Comparator<Appliance>() {
            @Override
            public int compare(Appliance a1, Appliance a2) {
                if (a1.getCategory() == null && a2.getCategory() == null) {
                    return 0;
                }
                if (a1.getCategory() == null) {
                    return 1;
                }
                if (a2.getCategory() == null) {
                    return -1;
                }
                return a1.getCategory().compareTo(a2.getCategory());
            }
        });
        sortedAppliancesByCategory.addAll(appliances);
        return sortedAppliancesByCategory;
    }

    @Override
    public Set<Order> sortOrderByAmount() {
        Set<Order> sortedOrdersByAmount = new TreeSet<>(new Comparator<Order>() {
            @Override
            public int compare(Order o1, Order o2) {
                BigDecimal amount1 = o1.getTotalPrice();
                BigDecimal amount2 = o2.getTotalPrice();
                return amount1.compareTo(amount2);
            }
        });
        sortedOrdersByAmount.addAll(orders);
        return sortedOrdersByAmount;
    }
}
