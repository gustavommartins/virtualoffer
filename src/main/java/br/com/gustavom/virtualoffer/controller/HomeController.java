package br.com.gustavom.virtualoffer.controller;

import br.com.gustavom.virtualoffer.model.Pedido;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model page){

        Pedido p1 = new Pedido();
        p1.setNomeProduto("Echo Dot (4ª geração)");
        p1.setDescricao("Complete qualquer ambiente com Alexa. Nosso smart speaker de maior sucesso tem um design elegante e compacto que se encaixa perfeitamente em espaços pequenos. O novo design de áudio direcional (1 speaker de 1,6”) garante mais graves e um som completo. Ele oferece vocais nítidos e graves equilibrados para você aproveitar em qualquer lugar de sua casa.");
        p1.setDataEntrega(LocalDate.of(2022,12,20));
        p1.setImagem("https://m.media-amazon.com/images/I/61+UtBdcdKL._AC_SX679_.jpg");
        p1.setUrl("https://www.amazon.com.br/Novo-Echo-Dot-com-rel%C3%B3gio/dp/B084J4WP6J/?_encoding=UTF8&pd_rd_w=GSfg6&content-id=amzn1.sym.1c4f2e65-cd11-4cd4-86f1-9372e9be93f8&pf_rd_p=1c4f2e65-cd11-4cd4-86f1-9372e9be93f8&pf_rd_r=MV1QYAAWPBWF028WA83D&pd_rd_wg=VLCFN&pd_rd_r=06cda7a9-0543-4cd8-be0f-809ed584b82d&ref_=pd_gw_unk");
        p1.setValorNegociado(new BigDecimal(450.00));

        Pedido p2 = new Pedido();
        p2.setNomeProduto("Fire TV Stick 4K");
        p2.setDescricao("Descubra uma experiência completa em 4K Ultra HD. Com suporte para HDR, som Dolby Atmos, acesso a conteúdo em 4K, e um processador incrivelmente rápido, o Fire TV Stick 4K permite que você viva a experiência de filmes e séries em 4K Ultra HD em sua TV.");
        p2.setDataEntrega(LocalDate.of(2022,11,15));
        p2.setImagem("https://m.media-amazon.com/images/I/61jcHRT5AAL._AC_SX679_.jpg");
        p2.setUrl("https://www.amazon.com.br/Fire-TV-Stick-4K-Streaming/dp/B0872Y93TY/ref=d_p13n_ds_purchase_sim_1p_dp_desktop_sccl_1_3/137-2799218-5176614?pd_rd_w=sdkdf&content-id=amzn1.sym.bcb2ee29-2818-4fa9-a787-3b071b070ab8&pf_rd_p=bcb2ee29-2818-4fa9-a787-3b071b070ab8&pf_rd_r=RD4AYQJW0TB99VVB33ZC&pd_rd_wg=KeNRf&pd_rd_r=130bf7b6-a864-4748-b2ff-89867455e5e5&pd_rd_i=B0872Y93TY&psc=1");
        p2.setValorNegociado(new BigDecimal(250.00));

        List<Pedido> pedidos = new ArrayList<Pedido>();

        pedidos.add(p1);
        pedidos.add(p2);

        page.addAttribute("pedidos", pedidos);

        return "home";
    }

}
