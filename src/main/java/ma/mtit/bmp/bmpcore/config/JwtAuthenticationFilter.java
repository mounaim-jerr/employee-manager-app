package ma.mtit.bmp.bmpcore.config;

import lombok.RequiredArgsConstructor;
import org.aspectj.bridge.MessageUtil;
import org.aspectj.weaver.tools.DefaultTrace;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    private final JwtService jwtService;
    private final UserDetailsService userDetailsService;
    @Override
    protected void doFilterInternal( HttpServletRequest request,  HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
final String authHeader = request.getHeader("Authorization");
final String jwt ;
final String userEmail;
if (authHeader == null ||!authHeader.startsWith("Bearer ") ){
    filterChain.doFilter(request, response);
    return;
}
jwt = authHeader.substring(7);
userEmail = jwtService.extractUsername(jwt);
if(userEmail!= null && SecurityContextHolder.getContext().getAuthentication() == null){
    UserDetails userDetails = this.userDetailsService.loadUserByUsername(userEmail);
    if (jwtService.isTokenValid(jwt, userDetails)){

        List<String> roles = jwtService.extractClaim(jwt, claims -> (List<String>) claims.get("roles"));
        if (roles != null) {
            System.out.println("Roles from token: " + roles);
            List<SimpleGrantedAuthority> authorities = roles.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
            UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                    userDetails,
                    null,
                    authorities

            );

        authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        SecurityContextHolder.getContext().setAuthentication(authToken);
    }
}
        filterChain.doFilter(request, response);


    }
}
}
