package com.KG.Support;


import com.KG.Pages.BrandPageKG;
import com.KG.Pages.CheckOutPageKG;
import com.KG.Pages.DashBoardPageKG;
import com.KG.Pages.Mens_ShoePageKG;

public class WebModel {

    public ElementUtils utils;

    private DashBoardPageKG dashBoardPageKG;
    private BrandPageKG brandPageKG;
    private Mens_ShoePageKG mensShoePageKG;
    private CheckOutPageKG checkOutPageKG;


    public WebModel() {
        utils = new ElementUtils();

        dashBoardPageKG = new DashBoardPageKG();
        brandPageKG = new BrandPageKG();
        mensShoePageKG = new Mens_ShoePageKG();
        checkOutPageKG = new CheckOutPageKG();


    }

    public ElementUtils getUtils() {
        return utils;
    }

    public DashBoardPageKG getDashBoardPageKG() {
        return dashBoardPageKG;
    }

    public BrandPageKG getBrandPageKG() {
        return brandPageKG;
    }

    public Mens_ShoePageKG getMensShoePageKG() {
        return mensShoePageKG;
    }

    public CheckOutPageKG getCheckOutPageKG() {
        return checkOutPageKG;
    }

}



