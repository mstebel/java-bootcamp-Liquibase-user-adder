package pl.ms.useradder;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
class AppUser {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;
    private String email;
    private boolean newsletter;

    public AppUser(String firstName, String lastName, LocalDate localDate, String email, boolean newsletter) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = localDate;
        this.email = email;
        this.newsletter = newsletter;
    }

    public AppUser() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate localDate) {
        this.birthDate = localDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isNewsletter() {
        return newsletter;
    }

    public void setNewsletter(boolean newsletter) {
        this.newsletter = newsletter;
    }

    @Override
    public String toString() {
        String news = newsletter ? "tak" : "nie";
        return String.format("imię: %s, nazwisko: %s, data urodzenia: %s, adres email: %s, zapisano do newslettera: %s",
                firstName, lastName, birthDate.toString(), email, news);
    }
}
