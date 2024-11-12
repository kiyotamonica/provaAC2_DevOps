package com.ead_gamificada.vo;

import java.util.Objects;
import jakarta.persistence.Embeddable;

@Embeddable
public class Email {
	private String address;
	
	protected Email() {
		
	}

    public Email(String address) {
        if (!isValidEmail(address)) {
            throw new IllegalArgumentException("Email inválido");
        }
        this.address = address;
    }

    private boolean isValidEmail(String email) {
        
        return email != null;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Email email = (Email) o;
        return Objects.equals(address, email.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address);
    }

    @Override
    public String toString() {
        return address;
    }
}
