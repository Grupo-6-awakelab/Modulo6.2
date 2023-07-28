package cl.awakelab.Grupal6M6.web.security;


import cl.awakelab.Grupal6M6.model.persistence.repository.UsuarioRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
@EnableWebSecurity
public class SecurityConfig {
    private final AuthenticationSuccessHandlerImpl auth;



/*    @Bean
    public InMemoryUserDetailsManager userDetailsManager(PasswordEncoder encoder) {
        UserDetails user = User.withUsername("user")
                .password(encoder.encode("user"))
                .roles("USER")
                .build();
        UserDetails admin = User.withUsername("admin")
                .password(encoder.encode("admin"))
                .roles("USER", "ADMIN")
                .build();

        return new InMemoryUserDetailsManager(user, admin);
    */

    UsuarioRepository repository;
    public SecurityConfig(AuthenticationSuccessHandlerImpl auth, UsuarioRepository repository){
        this.auth = auth;
        this.repository = repository;
    }

    @Bean
    public UserDetailsService userDetailsService(){
        return new UserDetailServiceImpl(repository);
    }
    @Bean
    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService());
        authenticationProvider.setPasswordEncoder(encoder());
        return authenticationProvider;
    }

    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.authenticationProvider(authenticationProvider());
    }


   /* public SecurityConfig(AuthenticationSuccessHandlerImpl auth) {
        this.auth = auth;
    }

    @Bean
    public AuthenticationSuccessHandler successHandler() {
        SimpleUrlAuthenticationSuccessHandler handler = new SimpleUrlAuthenticationSuccessHandler();
        handler.setUseReferer(true);
        return handler;
    }*/
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {


        http
                .authorizeRequests()
                .requestMatchers("/js/**", "/css/**", "/img/**").permitAll()
                /*.requestMatchers("/").permitAll()*/
                .requestMatchers("/dashboard").hasAnyRole("USER", "ADMIN")
                .and()
                .cors().and().csrf().disable()
                .httpBasic(Customizer.withDefaults())
                .formLogin()
                .loginPage("/login")
                .successHandler(auth)
                .permitAll()
                .and()
                .logout() // This is missing and is important
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login")
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID");

        return http.build();
    }

    @Bean
    public PasswordEncoder encoder() {
       /* return PasswordEncoderFactories.createDelegatingPasswordEncoder();*/
        return new BCryptPasswordEncoder();
    }
}