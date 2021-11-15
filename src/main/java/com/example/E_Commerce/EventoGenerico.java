package com.example.E_Commerce;

/*import com.example.E_Commerce.resource.CompraResource;*/
import com.example.E_Commerce.resource.FornecedorResource;
import com.example.E_Commerce.resource.VendaResource;
import org.springframework.context.ApplicationEvent;

import javax.servlet.http.HttpServletResponse;

public class EventoGenerico extends ApplicationEvent {

    private static final long serialVersionUID=1;

    private HttpServletResponse response;
    private String cnpj; // fornecedor
    private Long codigo; // produto
    private Long id; // compra
    private Long id_venda;// venda


    // PARA FORNECEDOR
    public EventoGenerico(Object source, HttpServletResponse response, String cnpj){
        super(source);
        this.response = response;
        this.cnpj = cnpj;
    }

    // PARA PRODUTO
    public EventoGenerico(Object source, HttpServletResponse response, Long codigo) {
        super(source);
        this.response=response;
        this.codigo=codigo;
    }



    // PARA COMPRA
    /*public EventoGenerico(CompraResource compraResource, HttpServletResponse response, Long id) {
        super(compraResource);
        this.response=response;
        this.id=id;
    }*/

    // PARA VENDA
    public EventoGenerico(VendaResource vendaResource, HttpServletResponse response, Long id_venda) {
        super(vendaResource);
        this.response=response;
        this.id_venda=id_venda;
    }

    public HttpServletResponse getResponse() {
        return response;
    }


    public String getCnpj() { // fornecedor
        return cnpj;
    }
    
    public Long getCodigo(){ // produto
        return codigo;
    }

    public Long getId(){
        return id;
    }

    public Long getId_venda(){
        return id_venda;
    }



}
