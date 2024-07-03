package entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="Users")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String login;

    private String password;
}
