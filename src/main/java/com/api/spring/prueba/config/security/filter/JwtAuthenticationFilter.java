package com.api.spring.prueba.config.security.filter;

import com.api.spring.prueba.exception.ObjectNotFoundException;
import com.api.spring.prueba.model.security.JwtToken;
import com.api.spring.prueba.model.security.User;
import com.api.spring.prueba.repository.security.JwtTokenRepository;
import com.api.spring.prueba.service.UserService;
import com.api.spring.prueba.service.auth.JwtService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Date;
import java.util.Optional;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {


    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserService userService;

    @Autowired
    private JwtTokenRepository jwtRepository;

    public JwtAuthenticationFilter(JwtService jwtService){
        this.jwtService = jwtService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException{

        String jwt = jwtService.extractJtwFromRequest(request);

        if (jwt == null || !StringUtils.hasText(jwt)){
            filterChain.doFilter(request, response);
            return;
        }

        Optional<JwtToken> token = jwtRepository.findByToken(jwt);
        boolean isValid = validateToken(token);

        if (!isValid) {
            filterChain.doFilter(request, response);
            return;
        }

        String username = jwtService.extractUsername(jwt);

        User user = userService.findByUsername(username).
                orElseThrow(() -> new ObjectNotFoundException("User not found. Username: "+ username));

        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(username, null,user.getAuthorities());
        authToken.setDetails(new WebAuthenticationDetails(request));
        SecurityContextHolder.getContext().setAuthentication(authToken);

        filterChain.doFilter(request, response);
    }

    private boolean validateToken(Optional<JwtToken> optionalToken){

        if(!optionalToken.isPresent()){
            System.out.println("token inexistente o no fue generado");
            return false;
        }

        JwtToken token = optionalToken.get();
        Date now = new Date(System.currentTimeMillis());
        boolean isValid = token.isValid() && token.getExpiration().after(now);

        if (!isValid){
            System.out.println("token invalido");
            updateTokenStatus(token);
        }

        return isValid;
    }

    private void updateTokenStatus(JwtToken token){
        token.setValid(false);
        jwtRepository.save(token);
    }

}
