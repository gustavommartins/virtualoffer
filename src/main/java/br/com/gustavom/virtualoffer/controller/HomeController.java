package br.com.gustavom.virtualoffer.controller;

import br.com.gustavom.virtualoffer.enums.StatusPedido;
import br.com.gustavom.virtualoffer.model.Pedido;
import br.com.gustavom.virtualoffer.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/meus_pedidos")
public class HomeController {

    private PedidoRepository repository;

    @Autowired
    public HomeController(PedidoRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/todos")
    public String todosOsPedidos(Model ui){
        List<Pedido> pedidos = repository.findAll();
        ui.addAttribute("pedidos", pedidos);
        ui.addAttribute("status", new String("todos"));
        ui.addAttribute("descricaoPagina", new String("Aqui você encontra todos os seus pedidos em nossa plataforma."));
        return "home";
    }

    @GetMapping("/{status}")
    public String todosOsPedidos(@PathVariable("status") @ModelAttribute("status") String status, Model ui){
        List<Pedido> pedidos = repository.findByStatusPedido(StatusPedido.valueOf(status.toUpperCase()));
        ui.addAttribute("pedidos", pedidos);
        ui.addAttribute("descricaoPagina", new String("Aqui você encontra todos os seus pedidos com o status " + status + "."));
        return "home";
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public String onError(){
        return "redirect:/meus_pedidos/todos";
    }

}
