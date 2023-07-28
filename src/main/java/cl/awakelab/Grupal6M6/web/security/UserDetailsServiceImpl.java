package cl.awakelab.Grupal6M6.web.security;

import cl.awakelab.Grupal6M6.model.persistence.entity.UsuarioEntity;
import cl.awakelab.Grupal6M6.model.persistence.repository.UsuarioRepository;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImpl implements UserDetailsService {

    private final UsuarioRepository repository;

    public UserDetailsServiceImpl(UsuarioRepository repository) {
        this.repository = repository;
    }

    public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UsuarioEntity user = repository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("Usuario no encontrado");
        }
        System.out.println(user.getUsername() + " " + user.getPassword() + " " + user.getRole());
        return new UserDetails(user);
    }
}