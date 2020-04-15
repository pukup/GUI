package psa.cesa.controller;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import psa.cesa.model.ComLine;
import psa.cesa.view.Primary;

public class RefreshTimeLine {

    private Primary primary;

    private ComLine comLine16, comLine15, comLine14, comLine13, comLine12, comLine11, comLine10, comLine9, comLine8, comLine7, comLine6, comLine5, comLine4, comLine3, comLine2, comLine1;

    public RefreshTimeLine(Primary primary) {
        this.primary = primary;
        getCache();
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(2500), ae -> refresh()));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();

    }

    private void getCache() {
        //        comLine16 = ComLineController.getAPICache(16);
        //        comLine15 = ComLineController.getAPICache(15);
        //        comLine14 = ComLineController.getAPICache(14);
        //        comLine13 = ComLineController.getAPICache(13);
        //        comLine12 = ComLineController.getAPICache(12);
        //        comLine11 = ComLineController.getAPICache(11);
        //        comLine10 = ComLineController.getAPICache(10);
        //        comLine9 = ComLineController.getAPICache(9);
        //        comLine8 = ComLineController.getAPICache(8);
        //        comLine7 = ComLineController.getAPICache(7);
        //        comLine6 = ComLineController.getAPICache(6);
        //        comLine5 = ComLineController.getAPICache(5);
        //        comLine4 = ComLineController.getAPICache(4);
        //        comLine3 = ComLineController.getAPICache(3);
        //        comLine2 = ComLineController.getAPICache(2);
        comLine1 = ComLineController.getAPICache(1);
    }

    public void refresh() {
        getCache();
        primary.refreshRows();
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
}
