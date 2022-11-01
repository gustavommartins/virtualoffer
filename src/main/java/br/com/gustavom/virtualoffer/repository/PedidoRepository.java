package br.com.gustavom.virtualoffer.repository;

import br.com.gustavom.virtualoffer.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido,Long> {
}
