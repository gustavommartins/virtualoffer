package br.com.gustavom.virtualoffer.domain;

import br.com.gustavom.virtualoffer.model.Pedido;

public class NovoPedidoDTO {

    public String nomeProduto;
    public String urlProduto;
    public String imagemProduto;
    public String descricaoProduto;

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getUrlProduto() {
        return urlProduto;
    }

    public void setUrlProduto(String urlProduto) {
        this.urlProduto = urlProduto;
    }

    public String getImagemProduto() {
        return imagemProduto;
    }

    public void setImagemProduto(String imagemProduto) {
        this.imagemProduto = imagemProduto;
    }

    public String getDescricaoProduto() {
        return descricaoProduto;
    }

    public void setDescricaoProduto(String descricaoProduto) {
        this.descricaoProduto = descricaoProduto;
    }

    public Pedido pedidoTo(){
        Pedido pedido = new Pedido();
        pedido.setUrl(this.urlProduto);
        pedido.setDescricao(this.descricaoProduto);
        pedido.setImagem(this.imagemProduto);
        pedido.setNomeProduto(this.nomeProduto);
        return pedido;
    }

}
