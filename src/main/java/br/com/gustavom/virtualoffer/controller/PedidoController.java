package br.com.gustavom.virtualoffer.controller;

import br.com.gustavom.virtualoffer.domain.NovoPedidoDTO;
import br.com.gustavom.virtualoffer.model.Pedido;
import br.com.gustavom.virtualoffer.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pedido")
public class PedidoController {

    private PedidoRepository repository;

    @Autowired
    public PedidoController(PedidoRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/novo_pedido")
    public String formulario(Model ui){
        return "pedido/formulario";
    }

    @PostMapping("/novo")
    public String novoPedido(NovoPedidoDTO novoPedido){
        Pedido pedido = novoPedido.pedidoTo();
        repository.save(pedido);
        return "pedido/formulario";
    }

}
