package za.co.lzinc.heriplay.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import lombok.RequiredArgsConstructor;
import za.co.lzinc.heriplay.security.JwtAuthenticationFilter;

import java.util.Arrays;
import java.util.List;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final AuthenticationProvider authenticationProvider;
    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    @Bean
    @ConditionalOnMissingBean(SecurityFilterChain.class) // only create this chain when none other exists
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .cors(cors -> cors.configurationSource(corsConfigurationSource()))
                .authorizeHttpRequests(auth -> auth
                        // Public endpoints - no authentication required
                        .requestMatchers("/api/authentication/register", "/api/authentication/login").permitAll()

                        // Admin-only endpoints for Users
                        .requestMatchers(HttpMethod.GET, "/api/users").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/api/users/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/api/users/**").hasRole("ADMIN")

                        // Admin-only endpoints for Subjects
                        .requestMatchers(HttpMethod.POST, "/api/subject/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/api/subject/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/api/subject/**").hasRole("ADMIN")

                        // Admin-only endpoints for Insurance
                        .requestMatchers(HttpMethod.POST, "/api/achievements/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/api/achievements/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/api/achievements/**")
                        .hasRole("ADMIN")

                        // Admin-only endpoints for Maintenance
                        .requestMatchers(HttpMethod.POST, "/api/maintenance/**")
                        .hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/api/maintenance/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/api/maintenance/**")
                        .hasRole("ADMIN")

                        // Admin-only endpoints for Maintenance
                        .requestMatchers(HttpMethod.POST, "/api/maintenance/create").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/api/maintenance/update/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/api/maintenance/delete/**").hasRole("ADMIN")

                        // Maintenance read access for all authenticated users
                        .requestMatchers(HttpMethod.GET, "/api/maintenance/**").authenticated()

                        // Admin-only endpoint for sending Notifications
                        .requestMatchers(HttpMethod.POST, "/api/notifications/**")
                        .hasRole("ADMIN")

                        // Admin-only endpoint for locations
                        .requestMatchers(HttpMethod.POST, "/api/location/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/api/location/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/api/location/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/api/location/delete/**").hasRole("ADMIN")

                        // Admin-only for admin panel
                        .requestMatchers("/api/admin/**").hasRole("ADMIN")

                        // Customer operations - all authenticated users can access
                        .requestMatchers("/api/subject/**").authenticated()
                        .requestMatchers("/api/quiz/**").authenticated()
                        .requestMatchers("/api/achievements/**").authenticated()

                        // Location read access for all authenticated users
                        .requestMatchers(HttpMethod.GET, "/api/quiz/**").authenticated()



                        // User profile management - users can manage their own profile
                        .requestMatchers(HttpMethod.GET, "/api/users/**").authenticated()
                        .requestMatchers(HttpMethod.PUT, "/api/users/**").authenticated()

                        .anyRequest().authenticated())
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList(
                "http://localhost:4516",
                "http://172.20.10.9:4516"));
        configuration.setAllowedMethods(Arrays.asList(
                "GET", "POST", "PUT", "DELETE", "OPTIONS"));
        configuration.setAllowedHeaders(Arrays.asList(
                "Authorization",
                "Content-Type",
                "X-Requested-With",
                "Accept",
                "Origin",
                "Access-Control-Request-Method",
                "Access-Control-Request-Headers"));
        configuration.setExposedHeaders(List.of("Authorization"));
        configuration.setAllowCredentials(true);
        configuration.setMaxAge(3600L);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}
