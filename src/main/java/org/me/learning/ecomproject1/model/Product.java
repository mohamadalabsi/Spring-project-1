package org.me.learning.ecomproject1.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    private String brand;
    private BigDecimal price;
    private String category;

//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-YYYY") // just to change the data format , but make sure it is not already handled in the frontend , because it cause an error
    private Date releaseDate;
    private boolean available; ;
    private int quantity;

//    now adding the image , one way is to store the image  in cloud storage and get the link of it like AWS and it is preferred and then store the url of the cloud storage in the DB , this is simpler
      private String imageName;
      private String imageType;
      @Lob // this means large object
      private byte[] imageData;



}
