package com.lambdaschool.backend.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "rentals")
public class Rental extends Auditable
{
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private long rentalid;

   @Column(nullable = false)
   private String name;

   @Column( length = 100000 )
   private String description;

   private String image;

   @Column(nullable = false)
   private double price;

   @ManyToOne
   @JoinColumn(name = "userid", nullable = false)
   @JsonIgnoreProperties(value = "rentals", allowSetters = true)
   private User user;

   public Rental() { }

   public Rental(User user, String name, String description, double price, String image)
   {
      this.user = user;
      this.name = name;
      this.description = description;
      this.price = price;
      this.image = image;
   }

   public long getRentalid()
   {
      return rentalid;
   }

   public void setRentalid(long rentalid)
   {
      this.rentalid = rentalid;
   }

   public String getName()
   {
      return name;
   }

   public void setName(String name)
   {
      this.name = name;
   }

   public String getDescription()
   {
      return description;
   }

   public void setDescription(String description)
   {
      this.description = description;
   }

   public double getPrice()
   {
      return price;
   }

   public void setPrice(double price) { this.price = price; }

   public User getUser()
   {
      return user;
   }

   public void setUser(User user) { this.user = user; }

   public String getImage() { return image; }

   public void setImage(String image) { this.image = image; }
}
