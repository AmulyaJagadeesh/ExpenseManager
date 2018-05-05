package nz.co.aj.expensemanager.subType;

import nz.co.aj.expensemanager.type.TypeDTO;

public class SubTypeDTO {

    private Long idsubtype;

    private String name;

    private String description;

    public Long getIdsubtype() {
        return idsubtype;
    }

    public void setIdsubtype(Long idsubtype) {
        this.idsubtype = idsubtype;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
