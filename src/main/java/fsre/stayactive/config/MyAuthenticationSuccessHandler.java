package fsre.stayactive.config;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
public class MyAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        // Preuzmite uloge korisnika
        var authorities = authentication.getAuthorities();

        // Logika preusmjeravanja na osnovu uloge
        if (authorities.stream().anyMatch(a -> a.getAuthority().equals("TRENER"))) {
            response.sendRedirect("/user/trainer");
        } else if (authorities.stream().anyMatch(a -> a.getAuthority().equals("KORISNIK"))) {

            response.sendRedirect("/user/gender");



        } else {
            response.sendRedirect("/login");
        }
    }
}