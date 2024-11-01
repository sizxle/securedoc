package com.sudocode.securedoc.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
@JsonInclude(JsonInclude.Include.NON_DEFAULT) // leaves out default values on serialization
public class UserEntity extends Auditable {

    @Column(updatable = false, unique = true, nullable = false)
    private String userId;

    private String firstName;

    private String lastName;

    @Column(unique = true, nullable = false)
    private String email;

    private Integer loginAttempts;

    private LocalDateTime lastLogin;

    private String phone;

    private String bio;

    private String imgUrl;

    private boolean accountNonExpired; //For spring security

    private boolean accountNonLocked;

    private boolean enabled;

    private boolean mfa;

    @JsonIgnore
    private String qrCodeSecret;

    @Column(columnDefinition = "TEXT")
    private String qrCodeImgUri;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(
                    name = "user_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id"))
    private RoleEntity role;
}
