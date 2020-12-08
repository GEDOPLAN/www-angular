package de.gedoplan.ged.angular.www.persistence.model.dto;

/**
 * @author GEDOPLAN, Dominik Mathmann
 */
public class ListValue {

    private String label;

    private Integer id;

    public ListValue(String label, Integer id) {
        this.label = label;
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


}
