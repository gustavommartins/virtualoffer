package br.com.gustavom.virtualoffer.controller;

import br.com.gustavom.virtualoffer.model.Pedido;
import br.com.gustavom.virtualoffer.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    private PedidoRepository repository;

    @Autowired
    public HomeController(PedidoRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/")
    public String home(Model page){
        List<Pedido> pedidos = repository.findAll();
        page.addAttribute("pedidos", pedidos);
        return "home";
    }

}
