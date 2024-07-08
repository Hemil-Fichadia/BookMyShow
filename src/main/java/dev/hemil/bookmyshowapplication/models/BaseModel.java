package dev.hemil.bookmyshowapplication.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.web.WebProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseModel {
    /* To avoid code duplication across models of an entire project, we declare this kind
    of variable in a BaseModel class and that represents the common attributes of auditing.
    * */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreatedDate
    @Temporal(TemporalType.DATE)
    private Date createdAt;

    @LastModifiedDate
    @Temporal(TemporalType.DATE)
    private Date modifiedAt;
}
