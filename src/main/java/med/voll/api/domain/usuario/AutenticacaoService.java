package med.voll.api.domain.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AutenticacaoService implements UserDetailsService {

    @Autowired
    private UsuarioRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Aqui você busca o Usuario diretamente
        Optional<Usuario> usuarioOptional = repository.findByLogin(username);

        // Se não encontrar, lança uma exceção
        Usuario usuario = usuarioOptional.orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));

        // Retorna o Usuario diretamente, que já é um UserDetails
        return usuario;
    }
}
