package peaksoft.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.CascadeType.*;

@Getter
@Setter
@NoArgsConstructor
//@Entity
//@Table(name = "instructors")
public class Instructor {
//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "instructor_seq")
//    @SequenceGenerator(name = "instructor_seq", sequenceName = "instructor_seq", allocationSize = 1)
//    private Long id;
//
//    @Column(length = 100000, name = "first_name")
//    private String firstName;
//
//    @Column(length = 100000, name = "last_name")
//    private String lastName;
//
//    @Column(length = 100000, name = "phone_number")
//    private String phoneNumber;
//
//    @Column(length = 100000, name = "email")
//    private String email;
//
//    @Column(length = 100000, name = "specialization")
//    private String specialization;
//
//    @ManyToOne(cascade = {MERGE,DETACH, REFRESH,PERSIST}, fetch = FetchType.EAGER)
//    private Course course;
}
