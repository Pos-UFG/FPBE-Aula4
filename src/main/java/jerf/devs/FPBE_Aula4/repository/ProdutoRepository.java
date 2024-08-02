package jerf.devs.FPBE_Aula4.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import jerf.devs.FPBE_Aula4.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
