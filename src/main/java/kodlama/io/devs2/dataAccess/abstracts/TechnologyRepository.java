package kodlama.io.devs2.dataAccess.abstracts;

import kodlama.io.devs2.entities.Technology;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TechnologyRepository extends JpaRepository<Technology, Integer> {
}
