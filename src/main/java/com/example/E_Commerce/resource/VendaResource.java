package com.example.E_Commerce.resource;


import com.example.E_Commerce.EventoGenerico;

import com.example.E_Commerce.dto.ItemSaleDTO;
import com.example.E_Commerce.dto.SaleDTO;
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
    public ResponseEntity<List<Sale>> findAllVenda(){
        List <Sale> sale = vendaRepository.findAll();
        if(sale.isEmpty()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Nada de compra por enquanto");
        }

        return ResponseEntity.ok().body(sale);

    }


    @PostMapping("/create")
    public ResponseEntity create(@RequestBody SaleDTO venda, HttpServletResponse response) {

            Sale saleSalva = new Sale();

        Client client = clienteRepository.findById(venda.getId_cliente()).get(); // verificando a existência do cliente
        saleSalva.setCliente(client);
        saleSalva.setStatus(false);


        // preciso de dois laços para melhor verificação

        for(ItemSaleDTO i: venda.getItems()){

            Product product = produtoRepository.findById(i.getId_produto()).get(); // verificando a existência do produto
            Stock stock =estoqueRepository.findByProduto(product);// verifico se o produto possui estoque

            int quantidade_produto_estoque=estoqueRepository.findByProduto(stock.getProduto()).getQuantidade();
            double valor_venda_produto=estoqueRepository.findByProduto(stock.getProduto()).getValor();

            if(product !=null && quantidade_produto_estoque > 0 && valor_venda_produto > 0){ // caminho feliz

                for(ItemSaleDTO cont : venda.getItems() ){

                    ItemsVenda itemsVenda = new ItemsVenda();

                    // SALVAR ITEMS NA LISTA DE VENDAS
                    itemsVenda.setProduto(product);
                    itemsVenda.setQuantidade(cont.getQuantidade());
                    itemsVenda.setValor(cont.getValor());
                    itemsVenda.setVenda(saleSalva);
                    saleSalva.addItem(itemsVenda);

                    stock.getProduto();
                    stock.setQuantidade(stock.getQuantidade() - i.getQuantidade());
                    stock.getValor();

                estoqueRepository.save(stock);
                saleSalva =vendaRepository.save(saleSalva);
            }

            }

            else {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND,"O ESTOQUE ESTÁ VAZIO");
            }
        }


        publisher.publishEvent(new EventoGenerico(this,response, saleSalva.getId()));
        return ResponseEntity.status(HttpStatus.CREATED).body(saleSalva);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Sale> findClienteById(@PathVariable Long id){
        Optional<Sale> venda = vendaRepository.findById(id);
        return venda.isPresent() ? ResponseEntity.ok(venda.get()): ResponseEntity.notFound().build();
    }

    @PutMapping("update/{id}")
    public ResponseEntity<Sale> update(@PathVariable Long id, @RequestBody Sale sale){
        Sale saleSave = vendaService.update(id, sale);
        return ResponseEntity.ok(saleSave);
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