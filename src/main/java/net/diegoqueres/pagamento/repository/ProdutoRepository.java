package net.diegoqueres.pagamento.repository;

import net.diegoqueres.pagamento.entity.Produto;
import net.diegoqueres.pagamento.entity.Venda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
