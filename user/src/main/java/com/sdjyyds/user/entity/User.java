package com.sdjyyds.user.entity;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    public enum Role {
        CONSUMER, MERCHANT, ADMIN
    }

    private Integer id;
    private String username;
    private String passwordHash;
    private Role role;
    private String realName;
    private String phone;
    private String address;
    private Boolean isVerified = false;
    private Date createdAt;
}