package siso.project.repository.dto;

import lombok.Builder;
import lombok.Data;

@Data
public class CountyOfficeDto {
    private String officeName;
    private String officeCity;
    private String officeCounty;
    private String officeAddress;

    @Builder
    public CountyOfficeDto(String officeName, String officeCity, String officeCounty, String officeAddress) {
        this.officeName = officeName;
        this.officeCity = officeCity;
        this.officeCounty = officeCounty;
        this.officeAddress = officeAddress;
    }
}
