package br.com.gustavom.virtualoffer.repository;

import br.com.gustavom.virtualoffer.enums.StatusPedido;
import br.com.gustavom.virtualoffer.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido,Long> {
    List<Pedido> findByStatusPedido(StatusPedido status);

    @Query("select p from Pedido p join p.user u where u.username = :usuario")
    List<Pedido> findAllByUser(@PathVariable("usuario") String usuario);
}
