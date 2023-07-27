package black.student.model;

import black.guardian.model.Guardian;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "tbl_student")
public class Student {
    @Id
    @SequenceGenerator(
            name = "student_sequence_generator",
            sequenceName = "student_sequence_generator",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence_generator"
    )
    private Long studentId;
    private String firstName;
    private String lastName;

    @Column(
            name = "email_address",
            nullable = false,
            unique = true
    )
    private String emailId;

    @Embedded
    private Guardian guardian;

}
