package com.example.E_Commerce.resource;


import com.example.E_Commerce.EventoGenerico;

import com.example.E_Commerce.dto.ItemVendaDTO;
import com.example.E_Commerce.dto.VendaDTO;
import com.example.E_Commerce.form.AtualizacaoStatusForm;
import com.example.E_Commerce.model.*;
import com.example.E_Commerce.repository.ClienteRepository;
import com.example.E_Commerce.repository.EstoqueRepository;
import com.example.E_Commerce.repository.ProdutoRepository;
import com.example.E_Commerce.repository.VendaRepository;
import com.example.E_Commerce.service.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
/*import org.springframework.security.access.prepost.PreAuthorize;*/
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RestController
//@PreAuthorize("hasRole('ROLE_CLIENTE')")
@RequestMapping("/venda")
public class VendaResource {

    @Autowired
    private VendaRepository vendaRepository;

    @Autowired
    private VendaService vendaService;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EstoqueRepository estoqueRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ApplicationEventPublisher publisher;


    @GetMapping
    public ResponseEntity<List<Venda>> findAllVenda(){
        List <Venda> venda = vendaRepository.findAll();
        if(venda.isEmpty()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Nada de compra por enquanto");
        }

        return ResponseEntity.ok().body(venda);

    }


    @PostMapping("/create")
    public ResponseEntity create(@RequestBody VendaDTO venda, HttpServletResponse response) {

            Venda vendaSalva = new Venda();

        Cliente cliente = clienteRepository.findById(venda.getId_cliente()).get(); // verificando a existência do cliente
        vendaSalva.setCliente(cliente);
        vendaSalva.setStatus(false);


        // preciso de dois laços para melhor verificação

        for(ItemVendaDTO i: venda.getItems()){

            Produto produto = produtoRepository.findById(i.getId_produto()).get(); // verificando a existência do produto
            Estoque estoque=estoqueRepository.findByProduto(produto);// verifico se o produto possui estoque

            int quantidade_produto_estoque=estoqueRepository.findByProduto(estoque.getProduto()).getQuantidade();
            double valor_venda_produto=estoqueRepository.findByProduto(estoque.getProduto()).getValor();

            if(produto!=null && quantidade_produto_estoque > 0 && valor_venda_produto > 0){ // caminho feliz

                for(ItemVendaDTO cont : venda.getItems() ){

                    ItemsVenda itemsVenda = new ItemsVenda();

                    // SALVAR ITEMS NA LISTA DE VENDAS
                    itemsVenda.setProduto(produto);
                    itemsVenda.setQuantidade(cont.getQuantidade());
                    itemsVenda.setValor(cont.getValor());
                    itemsVenda.setVenda(vendaSalva);
                    vendaSalva.addItem(itemsVenda);

                    estoque.getProduto();
                    estoque.setQuantidade(estoque.getQuantidade() - i.getQuantidade());
                    estoque.getValor();

                estoqueRepository.save(estoque);
                vendaSalva=vendaRepository.save(vendaSalva);
            }

            }

            else {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND,"O ESTOQUE ESTÁ VAZIO");
            }
        }


        publisher.publishEvent(new EventoGenerico(this,response,vendaSalva.getId()));
        return ResponseEntity.status(HttpStatus.CREATED).body(vendaSalva);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Venda> findClienteById(@PathVariable Long id){
        Optional<Venda> venda = vendaRepository.findById(id);
        return venda.isPresent() ? ResponseEntity.ok(venda.get()): ResponseEntity.notFound().build();
    }

    @PutMapping("update/{id}")
    public ResponseEntity<Venda> update(@PathVariable Long id, @RequestBody Venda venda){
        Venda vendaSave = vendaService.update(id,venda);
        return ResponseEntity.ok(vendaSave);
    }

    @PutMapping("confirmarRecebimento/{id}")
    @Transactional
    public ResponseEntity<String> confirmaRecebimento(@PathVariable Long id, @RequestBody AtualizacaoStatusForm atualizacao){
        atualizacao.atualizar(id,vendaRepository);
        String confirmada="Venda confirmada com sucesso, fique atento que sua entrega chegará pelo drone";
        return ResponseEntity.ok(confirmada);
    }


}



// listar produtos para o cliente
   /* @GetMapping("/listarProdutos")
    public ResponseEntity<List<Produto>> listarProdutos(){

        List <Produto> produto = produtoRepository.findAll();

        for(Estoque i: estoqueRepository.findAll()){

            int qtd_produto_estoque=estoqueRepository.findByProduto(i.getProduto()).getQuantidade();
            double valor_venda_produto=estoqueRepository.findByProduto(i.getProduto()).getValor();

            if(produto.isEmpty() || qtd_produto_estoque <= 0 || valor_venda_produto <= 0){
                String erro="NÃO HÁ NADA NO ESTOQUE OU NÃO TEM QUANTIDADE DESTE PRODUTO NO ESTOQUE OU O VALOR DE VENDA NÃO FOI DEFINIDO";
                throw new ResponseStatusException(HttpStatus.NOT_FOUND,erro);
            }

        }
        return ResponseEntity.ok().body(produto);

    }*/