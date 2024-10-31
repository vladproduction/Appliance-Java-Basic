package com.vladproduction.appliances.service;

import com.vladproduction.appliances.model.*;

public class Mapper {

    // mapping to csv:
    public static String[] clientToCsv(Client values) {
        //long id, String name, String email, String password, String card
        String[] result = new String[5];
        result[0] = values.getId() + "";
        result[1] = values.getName();
        result[2] = values.getEmail();
        result[3] = values.getPassword();
        result[4] = values.getCard();
        return result;
    }

    public static String[] manufacturerToCsv(Manufacturer values) {
        //long id, String name
        String[] result = new String[2];
        result[0] = values.getId() + "";
        result[1] = values.getName();
        return result;
    }

    public static String[] employeeToCsv(Employee values) {
        //long id, String name, String email, String password, String department
        String[] result = new String[5];
        result[0] = values.getId() + "";
        result[1] = values.getName();
        result[2] = values.getEmail();
        result[3] = values.getPassword();
        result[4] = values.getDepartment();
        return result;
    }
    public static String[] applianceToCsv(Appliance values) {
        //long id, String name, Category category, String model, long manufactureId, PowerType powerType,
            // String characteristic, String description, int power
        String[] result = new String[9];
        result[0] = values.getId() + "";
        result[1] = values.getName();
        result[2] = values.getCategory() == null ? null : values.getCategory().name();
        result[3] = values.getModel();
        result[4] = values.getManufactureId() + "";
        result[5] = values.getPowerType() == null ? null : values.getPowerType().name();
        result[6] = values.getCharacteristic();
        result[7] = values.getDescription();
        result[8] = values.getPower() + "";
        return result;
    }

    public static String[] orderToCsv(Order values) {
        //long id, long employeeId, long clientId
        String[] result = new String[3];
        result[0] = values.getId() + "";
        result[1] = values.getEmployeeId() + "";
        result[2] = values.getClientId() + "";
        return result;
    }

    // mapping from csv:
    public static Client csvToClient(String[] strings) {
        //long id, String name, String email, String password, String card
        Client client = new Client();
        if(strings[0] != null && !strings[0].isEmpty()){
            client.setId(Long.parseLong(strings[0]));
        }
        client.setName(strings[1]);
        client.setEmail(strings[2]);
        client.setPassword(strings[3]);
        client.setCard(strings[4]);
        return client;
    }

    public static Manufacturer csvToManufacturer(String[] strings) {
        //long id, String name
        Manufacturer manufacturer = new Manufacturer();
        if(strings[0] != null && !strings[0].isEmpty()){
            manufacturer.setId(Long.parseLong(strings[0]));
        }
        manufacturer.setName(strings[1]);
        return manufacturer;
    }


    public static Employee csvToEmployee(String[] strings) {
        //long id, String name, String email, String password, String department
        Employee employee = new Employee();
        // Check if the first string (ID) is not null and not empty
        if (strings[0] != null && !strings[0].isEmpty()) {
            employee.setId(Long.parseLong(strings[0]));
        }
        employee.setName(strings[1]);
        employee.setEmail(strings[2]);
        employee.setPassword(strings[3]);
        employee.setDepartment(strings[4]);
        return employee;
    }

    public static Appliance csvToAppliance(String[] strings) {
        //long id, String name, Category category, String model, long manufactureId, PowerType powerType,
            // String characteristic, String description, int power
        Appliance appliance = new Appliance();
        if(strings[0] != null && !strings[0].isEmpty()){
            appliance.setId(Long.parseLong(strings[0]));
        }
        appliance.setName(strings[1]);
        if(strings[2] != null && !strings[2].isEmpty()){
            appliance.setCategory(Category.valueOf(strings[2]));
        }
        appliance.setModel(strings[3]);
        if(strings[4] != null && !strings[4].isEmpty()){
            appliance.setManufactureId(Long.parseLong(strings[4]));
        }
        if(strings[5] != null && !strings[5].isEmpty()){
            appliance.setPowerType(PowerType.valueOf(strings[5]));
        }
        appliance.setCharacteristic(strings[6]);
        appliance.setDescription(strings[7]);
        if(strings[8] != null && !strings[8].isEmpty()){
            appliance.setPower(Integer.parseInt(strings[8]));
        }
        return appliance;
    }

    public static Order csvToOrder(String[] strings) {
        //long id, long employeeId, long clientId
        Order order = new Order();
        if(strings[0] != null && !strings[0].isEmpty()){
            order.setId(Long.parseLong(strings[0]));
        }
        if(strings[1] != null && !strings[1].isEmpty()){
            order.setEmployeeId(Long.parseLong(strings[1]));
        }
        if(strings[2] != null && !strings[2].isEmpty()){
            order.setClientId(Long.parseLong(strings[2]));
        }
        return order;
    }


}
