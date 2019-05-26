package hr.from.tomislav_strelar.liquitest.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "CUSTOMER_DATA")
@NoArgsConstructor
@RequiredArgsConstructor
@Data public class CustomerData {
    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    private Long id;

    @Column(name = "KEY")
    @NonNull private Integer key;

    @Column(name = "VALUE")
    @NonNull private String value;

    @Column(name = "PURCHASE_STRENGHT")
    private Integer purchaseStrenght;

    @ManyToOne
    @JoinColumn(name = "CUSTOMER_ID", nullable = false)
    @NonNull private Customer customer;
}
