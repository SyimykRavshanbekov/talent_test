package peaksoft.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import static javax.persistence.CascadeType.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "instructors")
public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "instructor_seq")
    @SequenceGenerator(name = "instructor_seq", sequenceName = "instructor_seq", allocationSize = 1)
    private Long id;

    @Column(length = 100000, name = "first_name")
    @NotNull(message = "Instructor name can't be null")
    private String firstName;

    @Column(length = 100000, name = "last_name")
    @NotNull(message = "Instructor last name can't be null")
    private String lastName;

    @Column(length = 100000, name = "phone_number")
    @NotNull(message = "Instructor phone number can't be null")
    private String phoneNumber;

    @Column(length = 100000, name = "email")
    @NotNull(message = "Instructor email can't be null")
    private String email;

    @Column(length = 100000, name = "specialization")
    @NotNull(message = "Instructor specialization can't be null")
    private String specialization;

    private int students = 0;

    public void plusStudent(Course course1){
        for (Group group : course1.getGroups()) {
            for (Student student: group.getStudents()) {
                students++;
            }
        }
    }

    public void plus(){
        students++;
    }

    public void minus(){
        students--;
    }

    @ManyToOne(cascade = {MERGE, DETACH, REFRESH}, fetch = FetchType.EAGER)
    private Course course;
}
