package uk.co.zenitech.core.framework.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import uk.co.zenitech.core.configuration.ApplicationConfiguration;

import java.util.List;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CorsConfigurationSource corsConfigurationSource;

    public SecurityConfig(CorsConfigurationSource corsConfigurationSource){
        this.corsConfigurationSource = corsConfigurationSource;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .cors()
                .configurationSource(corsConfigurationSource)
                .and()
                .authorizeRequests()
                .antMatchers("/actuator/health").permitAll()
                .anyRequest().authenticated()
                .and()
                .oauth2ResourceServer()
                .jwt();

        // Is tokeno visa mum relevant info pasiversti i Authorities - "ROLE_ADMIN", "ROLE_READ_ONLY", "ROLE_ADMIN_{ORGID}_{BUSINESS_STREAM}", UID_${sub

//        {
//         Header -  asdfghj. - Informacija apie signature (algoritmas, algoritmo key), kas isduoda otkena
//                Body -   asdjlasjdl. (visa informacija - sub (subject - kam isduodama), iat(issued at - kada isduotas tokenas), exp(expiry)
//                iss (issuer - kas isdave (OP id), aud (audience) - KAM isduota (client id), ... visi kiti claims (roles, name, email)) )
//            Signature - asldjalsdjasl
//        }
    }

}
