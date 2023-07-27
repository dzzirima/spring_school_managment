package black.student.repository;

import black.student.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IStudentRepository  extends JpaRepository<Student , Long> {

    @Query("select s from Student s where s.emailId = ?1")
    Student getStudentByName(String emailid);


    @Query("select s.firstName from Student s where s.emailId = ?1")
    String getStudentFirstNameByEmailAddress(String emailid);


    //native query


    // using named Params
    @Query("select s.firstName from Student s where s.emailId = :emailId")
    String getStudentFirstNameByEmailAddressNative(
          @Param("emailId") String emailId
    );

}



// JPA Queries are defined based on classes you created not the tables