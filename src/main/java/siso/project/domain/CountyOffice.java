package siso.project.domain;

import lombok.Builder;
import lombok.Data;

@Data
public class CountyOffice {

    private Long id;

    private String officeName;
    private String officeCity;
    private String officeCounty;
    private String officeAddress;

    @Builder
    public CountyOffice(Long id, String officeName, String officeCity, String officeCounty, String officeAddress) {
        this.id = id;
        this.officeName = officeName;
        this.officeCity = officeCity;
        this.officeCounty = officeCounty;
        this.officeAddress = officeAddress;
    }
}
