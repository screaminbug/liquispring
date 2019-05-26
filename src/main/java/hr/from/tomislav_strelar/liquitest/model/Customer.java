package hr.from.tomislav_strelar.liquitest.model;

import lombok.*;

import javax.persistence.*;

import java.util.Date;
import java.util.Set;

import static javax.persistence.CascadeType.ALL;

@Entity
@Table(name = "CUSTOMER")
@NoArgsConstructor
@RequiredArgsConstructor
@Data public class Customer {
    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    private Long id;

    @Column(name = "FIRST_NAME")
    @NonNull private String firstName;

    @Column(name = "LAST_NAME")
    @NonNull private String lastName;

    @Column(name = "BIRTH_DATE")
    private Date birthDate;

    @Column(name = "SOME_FLOAT")
    private Float someFloat;

    @OneToMany(cascade = ALL, mappedBy = "customer")
    private Set<CustomerData> customerData;
}
