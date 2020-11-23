package com.firstlab.aggregation;

import org.springframework.data.annotation.Id;

public class FirmAg {
    @Id
    private Integer year;
    private Integer countFirmYear;
    private Integer maxFirmsYear;

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getCountFirmYear() {
        return countFirmYear;
    }

    public void setCountFirmYear(Integer countFirmYear) {
        this.countFirmYear = countFirmYear;
    }

    public Integer getMaxFirmsYear() {
        return maxFirmsYear;
    }

    public void setMaxFirmsYear(Integer maxFirmsYear) {
        this.maxFirmsYear = maxFirmsYear;
    }

    @Override
    public String toString() {
        String res="";
        if(year!=null){
            res+="year=" + year;
        }
        if(countFirmYear!=null){
            res+=", countFirmYear=" + countFirmYear ;
        }
        if(maxFirmsYear!=null){
            res+=", maxFirmsYear=" + maxFirmsYear;
        }
        return res;
    }
}
