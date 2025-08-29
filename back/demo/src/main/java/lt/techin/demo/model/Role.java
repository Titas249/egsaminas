package lt.techin.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String roleName;

    public Role(String roleName) {
        this.roleName = roleName;
    }

    public Role() {
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return roleName;
    }

    public void setName(String roleName) {
        this.roleName = roleName;
    }

//    @Override
//    public String getAuthority() {
//        return roleName;
//    }
}
