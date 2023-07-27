package black.guardian.model;

// this class should be embeddable it should not exist as an entity

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor

public class  Guardian {


    private String guardianName;
    private String guardianEmail;
    private String guardianMobile;
}
