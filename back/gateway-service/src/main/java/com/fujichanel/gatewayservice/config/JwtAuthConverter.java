package com.fujichanel.gatewayservice.config;

import com.nimbusds.jwt.JWTClaimNames;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Configuration
@RequiredArgsConstructor
public class JwtAuthConverter implements Converter<Jwt, AbstractAuthenticationToken> {
    private final JwtAuthConfig configuration;
    private final JwtGrantedAuthoritiesConverter jwtGrantedAuthoritiesConverter;

    @Override
    public AbstractAuthenticationToken convert(Jwt jwt) {
        final List<GrantedAuthority> authorities = Stream.concat(
                extractRoles(jwt).stream(),
                jwtGrantedAuthoritiesConverter.convert(jwt).stream()
        ).toList();

        return new JwtAuthenticationToken(jwt, authorities, getClaimName(jwt));
    }

    public String getClaimName(Jwt jwt) {
        String claimName= JWTClaimNames.SUBJECT;

        if (!Objects.isNull(configuration.getPrincipalAttribute())) {
            claimName= configuration.getPrincipalAttribute();
        }

        return claimName;
    }

    public Collection<? extends GrantedAuthority> extractRoles(Jwt jwt) {
        Map<String, Object> accessResource= jwt.getClaims();
        Map<String, Object> resources;
        Collection<String> resourceRoles;

        if (Objects.isNull(accessResource)
            || (resources= (Map<String, Object>) accessResource.get(configuration.getResourceId()))== null
            || (resourceRoles= (Collection<String>) resources.get("role"))== null) {
            return Set.of();
        }

        return resourceRoles.stream()
                .map(role-> new SimpleGrantedAuthority("ROLE_"+role))
                .collect(Collectors.toSet());
    }
}
