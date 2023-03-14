package io.study.lombok.lombok_howto.stock;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Stock1 {

    private String ticker;
    private String companyNameEn;
    private String companyName;
    private String sector;
    private String countryCode;

    @Builder(builderMethodName = "defaultBuilder")
    public Stock1(String ticker, String companyNameEn, String companyName, String sector, String countryCode) {
        this.ticker = ticker;
        this.companyNameEn = companyNameEn;
        this.companyName = companyName;
        this.sector = sector;
        this.countryCode = countryCode;
    }

}
