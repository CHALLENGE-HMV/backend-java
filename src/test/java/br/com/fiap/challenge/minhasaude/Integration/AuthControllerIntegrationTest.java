package br.com.fiap.challenge.minhasaude.Integration;

import br.com.fiap.challenge.minhasaude.api.request.LoginRequest;
import br.com.fiap.challenge.minhasaude.api.request.UsuarioRegisterRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import static org.junit.jupiter.api.Assertions.*;

import br.com.fiap.challenge.minhasaude.MinhaSaudeApplication;

@SpringBootTest(classes = MinhaSaudeApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
public class AuthControllerIntegrationTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void ShouldAuthExistingUsuario() {

        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("hmv@fiap.com.br");
        loginRequest.setPassword("123456");

        ResponseEntity<String> responseEntity = this.restTemplate
                .postForEntity("http://localhost:" + port + "/api/auth/login", loginRequest, String.class);

        assertEquals(200, responseEntity.getStatusCodeValue());
    }
}
