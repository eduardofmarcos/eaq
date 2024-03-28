package org.solidbyte.editeaqui.infrastructure.provider;

import jakarta.enterprise.context.ApplicationScoped;
import org.mindrot.jbcrypt.BCrypt;
import org.solidbyte.editeaqui.domain.model.provider.HashProvider;


@ApplicationScoped
public class BCryptHashProvider implements HashProvider {

    @Override
    public String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    @Override
    public boolean checkPassword(String plaintext, String hashed) {
        return BCrypt.checkpw(plaintext, hashed);
    }
}
