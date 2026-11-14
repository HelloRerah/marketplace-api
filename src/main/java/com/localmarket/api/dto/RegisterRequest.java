
package com.localmarket.api.dto;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

/**
 *
 * @author rerah
 */
public record RegisterRequest(
        
        @NotBlank(message = "Full name is required")
        @Size(max = 120, message = "Full name must be at most 120 characters")
        String fullName, 
        
        @NotBlank(message = "Email is required")
        @Email(message = "message must be valid")
        @Size(max = 255, message = "Email must be at most 255 characters")
        String email,        
                
        @NotBlank(message = "Phone number is required")
        @Pattern(regexp = "^(\\+27|0)[0-9]{9}$",
                message = "Phone must be a South African number, e.g. 0821234567")
        String phone,
        
        @NotBlank(message = "Password is required")
        @Size(min = 8, max = 72, message = "Password must be 8 to 72 characters")
        String password,
        
        @AssertTrue(message = "You must confirm that you meet the age requirement")
        boolean ageConfirmed
        
        ) {
    
}
