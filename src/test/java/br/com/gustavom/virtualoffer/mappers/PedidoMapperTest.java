package br.com.gustavom.virtualoffer.mappers;

import br.com.gustavom.virtualoffer.domain.NovoPedidoDTO;
import br.com.gustavom.virtualoffer.enums.StatusPedido;
import br.com.gustavom.virtualoffer.model.Pedido;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class PedidoMapperTest {

    static NovoPedidoDTO novoPedidoDTO = new NovoPedidoDTO();
    static Pedido pedido = new Pedido();

    @BeforeAll
    static void criaMock(){
        novoPedidoDTO.setNomeProduto("Nome");
        novoPedidoDTO.setImagemProduto("Imagem");
        novoPedidoDTO.setUrlProduto("Url");
        novoPedidoDTO.setDescricaoProduto("Descricao");
        pedido = PedidoMapper.INSTANCE.mapper(novoPedidoDTO);
    }

    @Test
    @DisplayName("Verifica a conversão do nome")
    void convertNome(){
        assertEquals("Nome", pedido.getNomeProduto());
    }

    @Test
    @DisplayName("Verifica a conversão da imagem")
    void convertImagem(){
        assertEquals("Imagem", pedido.getImagem());
    }

    @Test
    @DisplayName("Verifica a conversão da url")
    void convertUrl(){
        assertEquals("Url", pedido.getUrl());
    }

    @Test
    @DisplayName("Verifica a conversão da descrição")
    void convertDescricao(){
        assertEquals("Descricao", pedido.getDescricao());
    }

    @Test
    @DisplayName("Verifica a conversão do status do pedido")
    void convertStatus(){
        assertEquals(StatusPedido.AGUARDANDO, pedido.getStatusPedido());
    }

}
