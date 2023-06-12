package br.com.gustavom.virtualoffer.controller;

import br.com.gustavom.virtualoffer.enums.StatusPedido;
import br.com.gustavom.virtualoffer.model.Pedido;
import br.com.gustavom.virtualoffer.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.time.ZoneId;
import java.util.List;

@Controller
public class HomeController {

    private final PedidoRepository repository;

    @Autowired
    public HomeController(PedidoRepository repository) {
        this.repository = repository;
    }

    @RequestMapping("/meus_pedidos/todos")
    public String todosOsPedidos(Model ui, Principal principal){
        List<Pedido> pedidos = repository.findAllByUser(principal.getName());
        ui.addAttribute("pedidos", pedidos);
        ui.addAttribute("status", "todos");
        ui.addAttribute("descricaoPagina", "Aqui você encontra todos os seus pedidos em nossa plataforma.");
        ui.addAttribute("locale", ZoneId.of("America/Sao_Paulo"));
        return "pedido/home";
    }

    @GetMapping("/meus_pedidos/{status}")
    public String todosOsPedidos(@PathVariable("status") @ModelAttribute("status") String status, Model ui){
        List<Pedido> pedidos = repository.findByStatusPedido(StatusPedido.valueOf(status.toUpperCase()));
        ui.addAttribute("pedidos", pedidos);
        ui.addAttribute("descricaoPagina", "Aqui você encontra todos os seus pedidos com o status " + status + ".");
        ui.addAttribute("locale", ZoneId.of("America/Sao_Paulo"));
        return "pedido/home";
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public String onError(){
        return "redirect:/";
    }

}
