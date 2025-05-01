package gaming.pe.DTO;

import java.time.LocalDate;

public class KardexDTO {
    private Long id;
    private LocalDate dateOperation;
    private LocalDate expirationDate;
    private Integer count;
    private String description;
    private String productName;
    private Long supplierId;

    public KardexDTO() {
    }

    public KardexDTO(Long id, LocalDate dateOperation, LocalDate expirationDate, Integer count, String description, String productName, Long supplierId) {
        this.id = id;
        this.dateOperation = dateOperation;
        this.expirationDate = expirationDate;
        this.count = count;
        this.description = description;
        this.productName = productName;
        this.supplierId = supplierId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDateOperation() {
        return dateOperation;
    }

    public void setDateOperation(LocalDate dateOperation) {
        this.dateOperation = dateOperation;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }
}
