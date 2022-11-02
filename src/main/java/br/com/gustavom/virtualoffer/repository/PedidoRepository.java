package br.com.gustavom.virtualoffer.repository;

import br.com.gustavom.virtualoffer.enums.StatusPedido;
import br.com.gustavom.virtualoffer.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido,Long> {
    List<Pedido> findByStatusPedido(StatusPedido status);
}
