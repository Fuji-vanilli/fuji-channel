package com.fujichanel.videoservice.security;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtClaimNames;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Configuration
@RequiredArgsConstructor
@Slf4j
public class JwtAuthConverter implements Converter<Jwt, AbstractAuthenticationToken> {
    private final JwtAuthProperties properties;
    private final JwtGrantedAuthoritiesConverter jwtGrantedAuthoritiesConverter;

    @Override
    public AbstractAuthenticationToken convert(Jwt jwt) {
        final Collection<GrantedAuthority> authorities = Stream.concat(jwtGrantedAuthoritiesConverter.convert(jwt).stream(),
                        extractRoles(jwt).stream()
                )
                .toList();

        return new JwtAuthenticationToken(jwt, authorities, getClaimName(jwt));
    }

    public String getClaimName(Jwt jwt) {
        String claimName= JwtClaimNames.SUB;

        if (!Objects.isNull(properties.getPrincipalAttribute())) {
            claimName= properties.getPrincipalAttribute();
        }
        return claimName;
    }

    public Collection<? extends GrantedAuthority> extractRoles(Jwt jwt) {
        Map<String, Object> accessResources= jwt.getClaim("resource_access");
        Map<String, Object> resources;
        Collection<String> resources_roles;

        if (Objects.isNull(accessResources) ||
                Objects.isNull(resources= (Map<String, Object>) accessResources.get(properties.getResourceId())) ||
                Objects.isNull(resources_roles= (Collection<String>) resources.get("roles"))) {

            return Set.of();
        }

        return resources_roles.stream()
                .map(role-> new SimpleGrantedAuthority("ROLE_"+role))
                .collect(Collectors.toSet());
    }
}
