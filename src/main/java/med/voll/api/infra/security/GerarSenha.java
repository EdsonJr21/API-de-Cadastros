package med.voll.api.infra.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class GerarSenha {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String senhaCriptografada = encoder.encode("12345");
        System.out.println("Senha criptografada: " + senhaCriptografada);
    }
}