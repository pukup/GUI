package psa.cesa.controller;

import psa.cesa.model.ComLine;
import psa.cesa.view.PrimaryController;

import java.util.TimerTask;

public class TimerCacheTask extends TimerTask {

    PrimaryController primaryController;
    private ComLine comLine16, comLine15, comLine14, comLine13, comLine12, comLine11, comLine10, comLine9, comLine8, comLine7, comLine6, comLine5, comLine4, comLine3, comLine2, comLine1;

    public TimerCacheTask(PrimaryController primaryController) {
        this.primaryController = primaryController;
    }

    @Override
    public void run() {
        getCache();
        setPrimaryControllerRows();
    }

    public ComLine getComLine16() {
        return comLine16;
    }

    public ComLine getComLine15() {
        return comLine15;
    }

    public ComLine getComLine14() {
        return comLine14;
    }

    public ComLine getComLine13() {
        return comLine13;
    }

    public ComLine getComLine12() {
        return comLine12;
    }

    public ComLine getComLine11() {
        return comLine11;
    }

    public ComLine getComLine10() {
        return comLine10;
    }

    public ComLine getComLine9() {
        return comLine9;
    }

    public ComLine getComLine8() {
        return comLine8;
    }

    public ComLine getComLine7() {
        return comLine7;
    }

    public ComLine getComLine6() {
        return comLine6;
    }

    public ComLine getComLine5() {
        return comLine5;
    }

    public ComLine getComLine4() {
        return comLine4;
    }

    public ComLine getComLine3() {
        return comLine3;
    }

    public ComLine getComLine2() {
        return comLine2;
    }

    public ComLine getComLine1() {
        return comLine1;
    }

    private void getCache() {
        comLine16 = ComLineController.getCache(16);
        comLine15 = ComLineController.getCache(15);
        comLine14 = ComLineController.getCache(14);
        comLine13 = ComLineController.getCache(13);
        comLine12 = ComLineController.getCache(12);
        comLine11 = ComLineController.getCache(11);
        comLine10 = ComLineController.getCache(10);
        comLine9 = ComLineController.getCache(9);
        comLine8 = ComLineController.getCache(8);
        comLine7 = ComLineController.getCache(7);
        comLine6 = ComLineController.getCache(6);
        comLine5 = ComLineController.getCache(5);
        comLine4 = ComLineController.getCache(4);
        comLine3 = ComLineController.getCache(3);
        comLine2 = ComLineController.getCache(2);
        comLine1 = ComLineController.getCache(1);
    }

    private void setPrimaryControllerRows() {
        primaryController.setRows();
    }
}
