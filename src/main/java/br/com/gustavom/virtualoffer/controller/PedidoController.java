package br.com.gustavom.virtualoffer.controller;

import br.com.gustavom.virtualoffer.domain.NovoPedidoDTO;
import br.com.gustavom.virtualoffer.mappers.PedidoMapper;
import br.com.gustavom.virtualoffer.model.Pedido;
import br.com.gustavom.virtualoffer.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/pedido")
public class PedidoController {

    private final PedidoRepository repository;
    private final PedidoMapper pedidoMapper;

    @Autowired
    public PedidoController(PedidoRepository repository, PedidoMapper pedidoMapper) {
        this.repository = repository;
        this.pedidoMapper = pedidoMapper;
    }

    @GetMapping("/novo_pedido")
    public String formulario(@ModelAttribute("novoPedido") NovoPedidoDTO novoPedido, Model ui) {
        ui = createTituloDescricaoNavbar(ui);
        return "pedido/formulario";
    }

    @PostMapping("/novo")
    public String novoPedido(@Valid @ModelAttribute("novoPedido") NovoPedidoDTO novoPedido, BindingResult validate, Model ui) {
        ui = createTituloDescricaoNavbar(ui);
        if (validate.hasErrors()) {
            return "pedido/formulario";
        }
        Pedido pedido = pedidoMapper.criaNovoPedido(novoPedido);
        repository.save(pedido);
        return "redirect:/home";
    }

    private Model createTituloDescricaoNavbar(Model ui) {
        ui.addAttribute("status", "novo pedido");
        ui.addAttribute("descricaoPagina", "Aqui você pode fazer novos pedidos na plataforma.");
        return ui;
    }

}
