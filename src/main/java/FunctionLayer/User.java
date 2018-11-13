/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

/**
 *
 * @author Mark
 */
public class User {
    
    private String Name, Address, city, phonenumber, email;

    public User(String Name, String Address, String city, String phonenumber, String email) {
        this.Name = Name;
        this.Address = Address;
        this.city = city;
        this.phonenumber = phonenumber;
        this.email = email;
    }

    public String getName() {
        return Name;
    }

    public String getAddress() {
        return Address;
    }

    public String getCity() {
        return city;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public String getEmail() {
        return email;
    }
    
    
    
}
