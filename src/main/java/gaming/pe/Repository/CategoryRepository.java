package gaming.pe.Repository;

import gaming.pe.Entity.Categorias;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Categorias, Integer> {
}
