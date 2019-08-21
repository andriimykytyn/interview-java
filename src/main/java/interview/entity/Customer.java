package interview.entity;

import java.util.Objects;

public class Customer {

    private Long id;
    private String email;
    private String password;
    private String first_name;
    private String last_name;
    private boolean certified;
    private Long tourId;

    public Customer() {
    }

    public Customer(Long id, String email,
                    String password, String first_name,
                    String last_name, boolean certified, Long tourId) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.first_name = first_name;
        this.last_name = last_name;
        this.certified = certified;
        this.tourId = tourId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public boolean isCertified() {
        return certified;
    }

    public void setCertified(boolean certified) {
        this.certified = certified;
    }

    public Long getTourId() {
        return tourId;
    }

    public void setTourId(Long tourId) {
        this.tourId = tourId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;
        Customer customer = (Customer) o;
        return certified == customer.certified &&
                Objects.equals(id, customer.id) &&
                Objects.equals(email, customer.email) &&
                Objects.equals(password, customer.password) &&
                Objects.equals(first_name, customer.first_name) &&
                Objects.equals(last_name, customer.last_name) &&
                Objects.equals(tourId, customer.tourId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, password, first_name, last_name, certified, tourId);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", certified=" + certified +
                ", tourId=" + tourId +
                '}';
    }
}
