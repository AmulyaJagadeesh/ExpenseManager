package nz.co.aj.expensemanager.type;

public class TypeDTO
{

    private Long idtype;

    private String name;

    private String description;

    public TypeDTO() {
    }

    public TypeDTO(Long idtype, String name, String description) {
        this.idtype = idtype;
        this.name = name;
        this.description = description;
    }

    public Long getIdtype() {
        return idtype;
    }

    public void setIdtype(Long idtype) {
        this.idtype = idtype;
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
