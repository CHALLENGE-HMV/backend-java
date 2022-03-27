package br.com.fiap.challenge.minhasaude.Integration;


import br.com.fiap.challenge.minhasaude.api.request.UsuarioRegisterRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import br.com.fiap.challenge.minhasaude.MinhaSaudeApplication;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = MinhaSaudeApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
public class UsuarioControllerIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void ShouldRegisterNonExistUsuario() {

        UsuarioRegisterRequest registerRequest = new UsuarioRegisterRequest();
        registerRequest.setNome("Paciente Fiap");
        registerRequest.setEmail("hmv@fiap.com.br");
        registerRequest.setSenha("123456");

        ResponseEntity<String> responseEntity = this.restTemplate
                .postForEntity("http://localhost:" + port + "/api/users", registerRequest, String.class);

        assertEquals(201, responseEntity.getStatusCodeValue());
    }

    @Test
    public void ShouldNotRegisterExistingUsuario() {

        UsuarioRegisterRequest registerRequest = new UsuarioRegisterRequest();
        registerRequest.setEmail("Paciente Fiap");
        registerRequest.setEmail("hmv@fiap.com.br");
        registerRequest.setSenha("123456");

        ResponseEntity<String> responseEntity = this.restTemplate
                .postForEntity("http://localhost:" + port + "/api/users", registerRequest, String.class);

        assertNotEquals(201, responseEntity.getStatusCodeValue());
    }
}
