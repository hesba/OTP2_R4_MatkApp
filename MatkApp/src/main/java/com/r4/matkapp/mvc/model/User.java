package com.r4.matkapp.mvc.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;


@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id", updatable = false, nullable = false)
    private int id;
    
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE, mappedBy = "users")
    private Set<Group> user_group = new HashSet<Group>();
    
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE, mappedBy = "joined_users")
    private Set<Expense> user_expenses = new HashSet<Expense>();
    
    @Column(name = "first_name")
    private String first_name;
    @Column(name = "last_name")
    private String last_name;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "street_address")
    private String street_address;
    @Column(name = "post_number")
    private String post_number;
    @Column(name = "city")
    private String city;
    @Column(name = "country")
    private String country;
    @Column(name = "phone_number")
    private String phone_number;
    @Column(name = "user_salt")
    private String user_salt;
    
    public User(String salt) {
        super();
        user_salt = salt;
    }
    
    public User() {
        super();
    }
    public User(String first_name, String last_name, String email, String password, String salt) {
        super();
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.password = password;
        this.user_salt = salt;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public int getId(){
        return id;
    }

    public Set<Group> getGroup() {
        return user_group;
    }
    
    public void addGroup(Group group) {
        user_group.add(group);
        group.getUsers().add(this);
    }

    
    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStreet_address() {
        return street_address;
    }

    public void setStreet_address(String street_address) {
        this.street_address = street_address;
    }

    public String getPost_number() {
        return post_number;
    }

    public void setPost_number(String post_number) {
        this.post_number = post_number;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }
    
    public String getSalt() {
        return user_salt;
    }

    /**
     * @return the user_expenses
     */
    public Set<Expense> getUser_expenses() {
        return user_expenses;
    }

    /**
     * @param user_expenses the user_expenses to set
     */
    public void setUser_expenses(Set<Expense> user_expenses) {
        this.user_expenses = user_expenses;
    }
    
    public void addUser_expense(Expense expense) {
        this.user_expenses.add(expense);
    }
 
}
