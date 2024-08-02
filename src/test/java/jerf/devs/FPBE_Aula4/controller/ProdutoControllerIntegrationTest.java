package jerf.devs.FPBE_Aula4.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import jerf.devs.FPBE_Aula4.model.Produto;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProdutoControllerIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testSalvarProduto() {
        String nome = "Teste";
        double preco = 100;
        Produto produto = new Produto(null, nome, preco);
        
        ResponseEntity<Produto> response = restTemplate.postForEntity("/produtos", produto, Produto.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        
        Produto produtoSalvo = response.getBody();
        assertNotNull(produtoSalvo);
        assertNotNull(produtoSalvo.getId());
        assertEquals(nome, produtoSalvo.getNome());
        assertEquals(preco, produtoSalvo.getPreco());
    }
}
