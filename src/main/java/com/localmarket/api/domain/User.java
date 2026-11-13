package com.localmarket.api.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

/**
 *
 * @author rerah
 */

@Entity
@Table(name = "users")
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String fullName;
    private String email;
    private String phone;
    private String passwordHash;
    
    @Enumerated(EnumType.STRING)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private Role role = Role.USER;
    
    private boolean phoneVerified;
    private boolean ageConfirmed;
    
    @Enumerated(EnumType.STRING)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private UserStatus status = UserStatus.ACTIVE;
    
    private String City;
    
    @Column(precision = 9, scale = 6)
    private BigDecimal latitude;
    
    @Column(precision = 9, scale = 6)
    private BigDecimal longitude;
    
    private LocalDateTime createdAt;
    
    @PrePersist
    void onCreate(){
        createdAt = LocalDateTime.now();
    }
    
    /*  ---- NOTES ---- 

    1. @Table(name = "users") is needed because the class is called User and the table users. Without it, Hibernate would look for a table named user.
    2. @Enumerated(EnumType.STRING) stores the enum as the text "USER". The default stores a number like 0, which would break if you ever reordered the enum, and wouldn’t match your VARCHAR column.
    3. @JdbcTypeCode(SqlTypes.VARCHAR) tells Hibernate the column is a plain VARCHAR. Recent Hibernate versions assume MySQL’s native ENUM type for enums, and validation would complain that your column doesn’t match.
    4. @Column(precision = 9, scale = 6) mirrors your DECIMAL(9,6). We use BigDecimal, not double, so coordinates don’t drift.
    5. @PrePersist runs just before the first save and fills in createdAt.
    6. role = Role.USER and status = ACTIVE are the Java defaults, matching the SQL defaults.
    */
    
    
    //getters and setters 
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public boolean isPhoneVerified() {
        return phoneVerified;
    }

    public void setPhoneVerified(boolean phoneVerified) {
        this.phoneVerified = phoneVerified;
    }

    public boolean isAgeConfirmed() {
        return ageConfirmed;
    }

    public void setAgeConfirmed(boolean ageConfirmed) {
        this.ageConfirmed = ageConfirmed;
    }

    public UserStatus getStatus() {
        return status;
    }

    public void setStatus(UserStatus status) {
        this.status = status;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String City) {
        this.City = City;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    
    
}


