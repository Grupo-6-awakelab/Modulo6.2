package cl.awakelab.Grupal6M6.web.security;

import cl.awakelab.Grupal6M6.model.persistence.repository.UsuarioRepository;
import cl.awakelab.Grupal6M6.web.service.UsuarioService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.security.Principal;

@Component
public class AuthenticationSuccessHandlerImpl extends SavedRequestAwareAuthenticationSuccessHandler {
    HttpSession session;
    UsuarioRepository repository;
    private final UsuarioService service;
    private final Logger logger = LoggerFactory.getLogger(AuthenticationSuccessHandlerImpl.class);


    public AuthenticationSuccessHandlerImpl(HttpSession session, UsuarioRepository repository, UsuarioService service) {
        this.session = session;
        this.repository = repository;
        this.service = service;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authentication) throws IOException, ServletException {
        super.onAuthenticationSuccess(request, response, chain, authentication);


    }


    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        System.out.println("HEP HEP");
        String userName = "";
        if (authentication.getPrincipal() instanceof UserDetails) {
            userName = ((UserDetails) authentication.getPrincipal()).getUsername();
        } else {
            // Manejar otros casos de autenticación, si es necesario.
        }
        logger.info("userName: " + userName);

        session.setAttribute("userId", userName);
        super.onAuthenticationSuccess(request, response, authentication);
    }
}
