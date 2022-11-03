package kodlama.io.devs2.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;


@Table(name = "language")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "language_id")
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "language")
    Set<Technology> technologies;


}
