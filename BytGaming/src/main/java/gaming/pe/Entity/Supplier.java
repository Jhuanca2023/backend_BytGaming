package gaming.pe.Entity;



import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.*;


    @Entity
    @Table(name = "suppliers")
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public class Supplier{

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        public String name;

        @Column(unique = true)
        private String ruc;

        @Column(unique = true)
        @Email
        private String email;

        @Pattern(regexp = "\\d{9}", message = "El número de teléfono debe tener 9 dígitos")
        @Column(unique = true)
        private String phone;

        private Boolean isActive;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getRuc() {
            return ruc;
        }

        public void setRuc(String ruc) {
            this.ruc = ruc;
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

        public Boolean getActive() {
            return isActive;
        }

        public void setActive(Boolean active) {
            isActive = active;
        }
    }
