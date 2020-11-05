package com.example.travel_agency.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@EnableAutoConfiguration
@Entity
@Data
@Table(name = "CLIENT")
public class Client {

    @Id
    private String clientId;

    private String name;
    private String surname;
    private int age;
    private int background;
    private boolean student;
    private boolean frequentBuyer;

    @JsonManagedReference(value="order-client")
    @OneToMany(mappedBy = "client")
    List<Order> orders;

    public Client(String name, String surname, int age, int background, boolean student){
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.background = background;
        this.student = student;
        this.frequentBuyer = false;
    }

    public int getAge(){return this.age;}

    public int getBackground(){return this.background;}

    public boolean isStudent(){return this.student;}

    public boolean isFrequentBuyer(){return this.frequentBuyer;}

    public void makeFrequentBuyer(){this.frequentBuyer = true;}

    @Override
    public String toString(){
        return "\n-CLIENT-\nName: " + this.name + "\nSurname: " + this.surname + "\nAge: " +
                this.age + "\nBackground: " + this.background + "\nStudent: " + this.student +
                "\nFrequent buyer: " + this.frequentBuyer;
    }
}
