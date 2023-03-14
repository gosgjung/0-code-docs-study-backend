package io.study.lombok.lombok_howto.stock;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.Assert;

@Getter
@NoArgsConstructor
public class Stock2 {

    private String ticker;
    private String companyNameEn;
    private String companyName;
    private String sector;
    private String countryCode;

    @Builder(builderMethodName = "defaultBuilder")
    public Stock2(String ticker, String companyNameEn, String companyName, String sector, String countryCode) {
        Assert.hasText(ticker, "Ticker must not be empty.");
        Assert.hasText(companyName, "Company name must not be empty.");
        Assert.hasText(companyNameEn, "Company name in English must not be empty");
        Assert.hasText(countryCode, "Country code must not be empty");

        this.ticker = ticker;
        this.companyNameEn = companyNameEn;
        this.companyName = companyName;
        this.sector = sector;
        this.countryCode = countryCode;
    }

}
