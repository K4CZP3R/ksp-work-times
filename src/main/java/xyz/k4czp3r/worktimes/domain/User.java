package xyz.k4czp3r.worktimes.domain;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"

    )
    @Column(name = "id", updatable = false, unique = true, length = 36)
    @Type(type = "uuid-char")
    private UUID id;

    @Column(length = 64)
    private String username;

    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"

    )
    @Column(unique = true, length = 36)
    @Type(type = "uuid-char")
    private UUID secretKey;

    public String getUsername() {
        return username;
    }

    public UUID getSecretKey() {
        return secretKey;
    }

    public UUID getId() {
        return id;
    }

    public static class Builder{
        private final String username;
        private UUID id;
        private UUID secretKey;
        public Builder(String username)
        {
            this.username = username;
            this.secretKey = UUID.randomUUID();
        }
        public Builder setId(UUID id)
        {
            this.id = id;
            return this;
        }
        public Builder setSecretKey(UUID key)
        {
            this.secretKey = key;
            return this;
        }

        public User build(){
            User user = new User();
            user.id = id;
            user.secretKey = secretKey;
            user.username = username;
            return user;
        }
    }
}
