package org.solidbyte.editeaqui.infrastructure.web.provider;

import com.auth0.jwt.interfaces.DecodedJWT;
import org.solidbyte.editeaqui.infrastructure.web.security.profile.Role;

public interface TokenProvider {

    String createUserToken(String subject);

    DecodedJWT verify(String token);

    Role[] extractRoles(DecodedJWT decodedJWT);
}
