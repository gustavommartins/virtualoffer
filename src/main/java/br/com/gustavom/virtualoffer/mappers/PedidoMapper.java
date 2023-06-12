package br.com.gustavom.virtualoffer.mappers;

import br.com.gustavom.virtualoffer.domain.NovoPedidoDTO;
import br.com.gustavom.virtualoffer.model.Pedido;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PedidoMapper {

    PedidoMapper INSTANCE = Mappers.getMapper(PedidoMapper.class);

    @Mapping(target = "descricao", source = "descricaoProduto")
    @Mapping(target="url", source = "urlProduto")
    @Mapping(target="imagem", source = "imagemProduto")
    @Mapping(target="statusPedido", source = "statusPedido", defaultValue = "AGUARDANDO")
    Pedido mapper(NovoPedidoDTO novoPedidoDTO);

}
