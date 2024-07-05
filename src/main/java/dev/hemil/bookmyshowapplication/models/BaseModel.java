package dev.hemil.bookmyshowapplication.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.util.Date;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseModel {
    /* To avoid code duplication across models of an entire project, we declare this kind
    of variable in a BaseModel class and that represents the common attributes of auditing.
    * */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date createdAt;
    private Date modifiedAt;
}
