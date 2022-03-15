package gerimedica.jo.assignment.adapter.out.persistence;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EXERCISE")
public class ExerciseEntity {
    private String source;

    private String codeListCode;

    @Id
    private String code;

    private String displayValue;

    private String longDescription;

    private String fromDate;

    private String toDate;

    private Integer sortingPriority;

    public ExerciseEntity(){}
    
    public ExerciseEntity(
        String source,
        String codeListCode,
        String code,
        String displayValue,
        String longDescription,
        String fromDate,
        String toDate,
        Integer sortingPriority) {
        
            this.source = source;
            this.codeListCode = codeListCode;
            this.code = code;
            this.displayValue = displayValue;
            this.longDescription = longDescription;
            this.fromDate = fromDate;
            this.toDate = toDate;
            this.sortingPriority = sortingPriority;
    }

    // Getters

    public String getSource() {
        return source;
    }

    public String getCode() {
        return code;
    }

    public String getCodeListCode() {
        return codeListCode;
    }

    public String getDisplayValue() {
        return displayValue;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public String getFromDate() {
        return fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    
    public Integer getSortingPriority() {
        return sortingPriority;
    }

    // Setters

    public void setSource(String source) {
        this.source = source;
    }

    public void setCodeListCode(String codeListCode) {
        this.codeListCode = codeListCode;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setDisplayValue(String displayValue) {
        this.displayValue = displayValue;
    }


    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public void setSortingPriority(Integer sortingPriority) {
        this.sortingPriority = sortingPriority;
    }

}
