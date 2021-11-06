import javax.persistence.*;

@Entity
@Table(name="person")
public class Person {
  private long personID;
  private int age;
  private String name;


  public Person() {
  }

  @Id
  @Column(name="person_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public long getPersonID() {
    return personID;
  }

  public void setPersonID(long personID) {
    this.personID = personID;
  }

  @Column(name="age")
  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age=age;
  }

  @Column(name="name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name=name;
  }
}
/*
  CREATE TABLE `person` (
        `person_id` int(11) NOT NULL AUTO_INCREMENT,
        `name` varchar(128) NOT NULL,
        `age` int NOT NULL,
        PRIMARY KEY (`person_id`),
        UNIQUE KEY `person_id_UNIQUE` (`person_id`)
        );
*/