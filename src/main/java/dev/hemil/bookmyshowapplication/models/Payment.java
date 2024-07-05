package dev.hemil.bookmyshowapplication.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Payment extends BaseModel {
    /* Now this is something that is purely a case of common-sense, while adding the
    annotation for @ManyToMany, we know it will create a mapping table, as multiple
    attributes are being related with each other, but when we relate two normal single
    attributes with annotation @OneToMany or @ManyToOne, then we know that we will get
    the id of one on the side of many like in netflix example, one account can have multiple
    profiles but one profile can belong to only one account, so account_id will be present
    on the profile side.

    But the game changes as we have this @OneToMany or @ManyToOne relation in terms of
    list attribute, like here in booking class we have List<Payment> as we support partial
    payments with multiple modes, but on the payment side we don't have booking attribute
    to map like which booking_id does this payment belongs to, so when we are creating the
    table with the help of hibernate, deepak sir was puzzled with the results as it created
    a mapping table of booking_payments, the reason seems quite simple, as we are allowing
    multiple payments, we are having a list of payment and that's why we cannot store that
    in booking's table, and we don't even have a booking_id on the payment side so hibernate
    is so smart that it created a mapping table, and this really fascinates me.
    */

    private int amount;
    private String referenceNumber;

    @Enumerated(EnumType.ORDINAL)
    private PaymentMode paymentMode;

    @Enumerated(EnumType.ORDINAL)
    private PaymentStatus paymentStatus;
}
