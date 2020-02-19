package psa.cesa.view;

import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import psa.cesa.App;
import psa.cesa.controller.TimerCacheTask;
import psa.cesa.model.Heliostat;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 */
public class PrimaryController implements Initializable {

    private TimerCacheTask timerCacheTask;

    @FXML
    private VBox rows_vbox;

    @FXML
    private Slider zoom_slider;

    @FXML
    private HeliostatButton h1609, h1607, h1605, h1603, h1601, h1602, h1604, h1606, h1608, h1610;
    @FXML
    private HeliostatButton h1511, h1509, h1507, h1505, h1503, h1501, h1500, h1502, h1504, h1506, h1508, h1510, h1512;
    @FXML
    private HeliostatButton h1415, h1413, h1411, h1409, h1407, h1405, h1403, h1401, h1400, h1402, h1404, h1406, h1408, h1410, h1412, h1414, h1416;
    @FXML
    private HeliostatButton h1317, h1315, h1313, h1311, h1309, h1307, h1305, h1303, h1301, h1300, h1302, h1304, h1306, h1308, h1310, h1312, h1314, h1316, h1318;
    @FXML
    private HeliostatButton h1219, h1217, h1215, h1213, h1211, h1209, h1207, h1205, h1203, h1201, h1202, h1204, h1206, h1208, h1210, h1212, h1214, h1216, h1218, h1220;
    @FXML
    private HeliostatButton h1121, h1119, h1117, h1115, h1113, h1111, h1109, h1107, h1105, h1103, h1101, h1100, h1102, h1104, h1106, h1108, h1110, h1112, h1114, h1116, h1118, h1120, h1122;
    @FXML
    private HeliostatButton h1031, h1029, h1027, h1025, h1023, h1021, h1019, h1017, h1015, h1013, h1011, h1009, h1007, h1005, h1003, h1001, h1002, h1004, h1006, h1008, h1010, h1012, h1014, h1016, h1018, h1020, h1022, h1024, h1026, h1028, h1030, h1032;
    @FXML
    private HeliostatButton h0929, h0927, h0925, h0923, h0921, h0919, h0917, h0915, h0913, h0911, h0909, h0907, h0905, h0903, h0901, h0900, h0902, h0904, h0906, h0908, h0910, h0912, h0914, h0916, h0918, h0920, h0922, h0924, h0926, h0928, h0930;
    @FXML
    private HeliostatButton h0827, h0825, h0823, h0821, h0819, h0817, h0815, h0813, h0811, h0809, h0807, h0805, h0803, h0801, h0802, h0804, h0806, h0808, h0810, h0812, h0814, h0816, h0818, h0820, h0822, h0824, h0826, h0828;
    @FXML
    private HeliostatButton h0721, h0719, h0717, h0715, h0713, h0711, h0709, h0707, h0705, h0703, h0701, h0700, h0702, h0704, h0706, h0708, h0710, h0712, h0714, h0716, h0718, h0720, h0722;
    @FXML
    private HeliostatButton h0619, h0617, h0615, h0613, h0611, h0609, h0607, h0605, h0603, h0601, h0602, h0604, h0606, h0608, h0610, h0612, h0614, h0616, h0618, h0620;
    @FXML
    private HeliostatButton h0515, h0513, h0511, h0509, h0507, h0505, h0503, h0501, h0500, h0502, h0504, h0506, h0508, h0510, h0512, h0514, h0516;
    @FXML
    private HeliostatButton h0415, h0413, h0411, h0409, h0407, h0405, h0403, h0401, h0402, h0404, h0406, h0408, h0410, h0412, h0414, h0416;
    @FXML
    private HeliostatButton h0311, h0309, h0307, h0305, h0303, h0301, h0300, h0302, h0304, h0306, h0308, h0310, h0312;
    @FXML
    private HeliostatButton h0209, h0207, h0205, h0203, h0201, h0202, h0204, h0206, h0208, h0210;
    @FXML
    private HeliostatButton h0107, h0105, h0103, h0101, h0100, h0102, h0104, h0106, h0108;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        zoom_slider.valueProperty().addListener((o, oldVal, newVal) -> zoom());
        timerCacheTask = new TimerCacheTask(this);
        Timer timer = new Timer("PrimaryController");
        timer.schedule(timerCacheTask, new Date(), 1000);

    }

    @FXML
    private void emergency() {
        // The ones in focus must go to kilter focus throw aisle.
        // or something.
    }

    @FXML
    private void zoom() {
        rows_vbox.styleProperty().bind(Bindings.format("-fx-font-size: %.2fpt;", zoom_slider.getValue()));
    }

    @FXML
    private void zoomIn(ActionEvent event) {
        double sliderVal = zoom_slider.getValue();
        zoom_slider.setValue(sliderVal += 1);
    }

    @FXML
    private void zoomOut(ActionEvent event) {
        double sliderVal = zoom_slider.getValue();
        zoom_slider.setValue(sliderVal -= 1);
    }

    @FXML
    private void openGrouping(ActionEvent event) throws IOException {
        Scene scene = new Scene(loadFXML("groups"));
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    private Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public void setRows() {
        setRow16();
        setRow15();
        setRow14();
        setRow13();
        setRow12();
        setRow11();
        setRow10();
        setRow09();
        setRow08();
        setRow07();
        setRow06();
        setRow05();
        setRow04();
        setRow03();
        setRow02();
        setRow01();
    }

    private void setRow16() {
        h1609.setHeliostat(timerCacheTask.getComLine16().getHeliostats().get(146));
        h1607.setHeliostat(timerCacheTask.getComLine16().getHeliostats().get(145));
        h1605.setHeliostat(timerCacheTask.getComLine16().getHeliostats().get(144));
        h1603.setHeliostat(timerCacheTask.getComLine16().getHeliostats().get(143));
        h1601.setHeliostat(timerCacheTask.getComLine16().getHeliostats().get(142));
        h1602.setHeliostat(timerCacheTask.getComLine8().getHeliostats().get(150));
        h1604.setHeliostat(timerCacheTask.getComLine8().getHeliostats().get(151));
        h1606.setHeliostat(timerCacheTask.getComLine8().getHeliostats().get(152));
        h1608.setHeliostat(timerCacheTask.getComLine8().getHeliostats().get(153));
        h1610.setHeliostat(timerCacheTask.getComLine8().getHeliostats().get(154));
    }

    private void setRow15() {
        h1511.setHeliostat(timerCacheTask.getComLine16().getHeliostats().get(141));
        h1509.setHeliostat(timerCacheTask.getComLine16().getHeliostats().get(140));
        h1507.setHeliostat(timerCacheTask.getComLine16().getHeliostats().get(139));
        h1505.setHeliostat(timerCacheTask.getComLine16().getHeliostats().get(138));
        h1503.setHeliostat(timerCacheTask.getComLine16().getHeliostats().get(137));
        h1501.setHeliostat(timerCacheTask.getComLine16().getHeliostats().get(136));
        h1500.setHeliostat(timerCacheTask.getComLine8().getHeliostats().get(143));
        h1502.setHeliostat(timerCacheTask.getComLine8().getHeliostats().get(144));
        h1504.setHeliostat(timerCacheTask.getComLine8().getHeliostats().get(145));
        h1506.setHeliostat(timerCacheTask.getComLine8().getHeliostats().get(146));
        h1508.setHeliostat(timerCacheTask.getComLine8().getHeliostats().get(147));
        h1510.setHeliostat(timerCacheTask.getComLine8().getHeliostats().get(148));
        h1512.setHeliostat(timerCacheTask.getComLine8().getHeliostats().get(149));
    }

    private void setRow14() {
        h1415.setHeliostat(timerCacheTask.getComLine16().getHeliostats().get(135));
        h1413.setHeliostat(timerCacheTask.getComLine16().getHeliostats().get(134));
        h1411.setHeliostat(timerCacheTask.getComLine16().getHeliostats().get(133));
        h1409.setHeliostat(timerCacheTask.getComLine16().getHeliostats().get(132));
        h1407.setHeliostat(timerCacheTask.getComLine16().getHeliostats().get(131));
        h1405.setHeliostat(timerCacheTask.getComLine16().getHeliostats().get(130));
        h1403.setHeliostat(timerCacheTask.getComLine16().getHeliostats().get(129));
        h1401.setHeliostat(timerCacheTask.getComLine16().getHeliostats().get(128));
        h1402.setHeliostat(timerCacheTask.getComLine8().getHeliostats().get(135));
        h1404.setHeliostat(timerCacheTask.getComLine8().getHeliostats().get(136));
        h1406.setHeliostat(timerCacheTask.getComLine8().getHeliostats().get(137));
        h1408.setHeliostat(timerCacheTask.getComLine8().getHeliostats().get(138));
        h1410.setHeliostat(timerCacheTask.getComLine8().getHeliostats().get(139));
        h1412.setHeliostat(timerCacheTask.getComLine8().getHeliostats().get(140));
        h1414.setHeliostat(timerCacheTask.getComLine8().getHeliostats().get(141));
        h1416.setHeliostat(timerCacheTask.getComLine8().getHeliostats().get(142));
    }

    private void setRow13() {
        h1317.setHeliostat(timerCacheTask.getComLine15().getHeliostats().get(127));
        h1315.setHeliostat(timerCacheTask.getComLine15().getHeliostats().get(126));
        h1313.setHeliostat(timerCacheTask.getComLine15().getHeliostats().get(125));
        h1311.setHeliostat(timerCacheTask.getComLine15().getHeliostats().get(124));
        h1309.setHeliostat(timerCacheTask.getComLine15().getHeliostats().get(123));
        h1307.setHeliostat(timerCacheTask.getComLine15().getHeliostats().get(122));
        h1305.setHeliostat(timerCacheTask.getComLine15().getHeliostats().get(121));
        h1303.setHeliostat(timerCacheTask.getComLine15().getHeliostats().get(120));
        h1301.setHeliostat(timerCacheTask.getComLine15().getHeliostats().get(119));
        h1300.setHeliostat(timerCacheTask.getComLine7().getHeliostats().get(125));
        h1302.setHeliostat(timerCacheTask.getComLine7().getHeliostats().get(126));
        h1304.setHeliostat(timerCacheTask.getComLine7().getHeliostats().get(127));
        h1306.setHeliostat(timerCacheTask.getComLine7().getHeliostats().get(128));
        h1308.setHeliostat(timerCacheTask.getComLine7().getHeliostats().get(129));
        h1310.setHeliostat(timerCacheTask.getComLine7().getHeliostats().get(130));
        h1312.setHeliostat(timerCacheTask.getComLine7().getHeliostats().get(131));
        h1314.setHeliostat(timerCacheTask.getComLine7().getHeliostats().get(132));
        h1316.setHeliostat(timerCacheTask.getComLine7().getHeliostats().get(133));
        h1318.setHeliostat(timerCacheTask.getComLine7().getHeliostats().get(134));
    }

    private void setRow12() {
        h1219.setHeliostat(timerCacheTask.getComLine15().getHeliostats().get(118));
        h1217.setHeliostat(timerCacheTask.getComLine15().getHeliostats().get(117));
        h1215.setHeliostat(timerCacheTask.getComLine15().getHeliostats().get(116));
        h1213.setHeliostat(timerCacheTask.getComLine15().getHeliostats().get(115));
        h1211.setHeliostat(timerCacheTask.getComLine15().getHeliostats().get(114));
        h1209.setHeliostat(timerCacheTask.getComLine15().getHeliostats().get(113));
        h1207.setHeliostat(timerCacheTask.getComLine15().getHeliostats().get(112));
        h1205.setHeliostat(timerCacheTask.getComLine15().getHeliostats().get(111));
        h1203.setHeliostat(timerCacheTask.getComLine15().getHeliostats().get(110));
        h1201.setHeliostat(timerCacheTask.getComLine15().getHeliostats().get(109));
        h1202.setHeliostat(timerCacheTask.getComLine7().getHeliostats().get(115));
        h1204.setHeliostat(timerCacheTask.getComLine7().getHeliostats().get(116));
        h1206.setHeliostat(timerCacheTask.getComLine7().getHeliostats().get(117));
        h1208.setHeliostat(timerCacheTask.getComLine7().getHeliostats().get(118));
        h1210.setHeliostat(timerCacheTask.getComLine7().getHeliostats().get(119));
        h1212.setHeliostat(timerCacheTask.getComLine7().getHeliostats().get(120));
        h1214.setHeliostat(timerCacheTask.getComLine7().getHeliostats().get(121));
        h1216.setHeliostat(timerCacheTask.getComLine7().getHeliostats().get(122));
        h1218.setHeliostat(timerCacheTask.getComLine7().getHeliostats().get(123));
        h1220.setHeliostat(timerCacheTask.getComLine7().getHeliostats().get(124));
    }

    private void setRow11() {
        h1121.setHeliostat(timerCacheTask.getComLine14().getHeliostats().get(108));
        h1119.setHeliostat(timerCacheTask.getComLine14().getHeliostats().get(107));
        h1117.setHeliostat(timerCacheTask.getComLine14().getHeliostats().get(106));
        h1115.setHeliostat(timerCacheTask.getComLine14().getHeliostats().get(105));
        h1113.setHeliostat(timerCacheTask.getComLine14().getHeliostats().get(104));
        h1111.setHeliostat(timerCacheTask.getComLine14().getHeliostats().get(103));
        h1109.setHeliostat(timerCacheTask.getComLine14().getHeliostats().get(102));
        h1107.setHeliostat(timerCacheTask.getComLine14().getHeliostats().get(101));
        h1105.setHeliostat(timerCacheTask.getComLine14().getHeliostats().get(100));
        h1103.setHeliostat(timerCacheTask.getComLine14().getHeliostats().get(99));
        h1101.setHeliostat(timerCacheTask.getComLine14().getHeliostats().get(98));
        h1100.setHeliostat(timerCacheTask.getComLine6().getHeliostats().get(103));
        h1102.setHeliostat(timerCacheTask.getComLine6().getHeliostats().get(104));
        h1104.setHeliostat(timerCacheTask.getComLine6().getHeliostats().get(105));
        h1106.setHeliostat(timerCacheTask.getComLine6().getHeliostats().get(106));
        h1108.setHeliostat(timerCacheTask.getComLine6().getHeliostats().get(107));
        h1110.setHeliostat(timerCacheTask.getComLine6().getHeliostats().get(108));
        h1112.setHeliostat(timerCacheTask.getComLine6().getHeliostats().get(109));
        h1114.setHeliostat(timerCacheTask.getComLine6().getHeliostats().get(110));
        h1116.setHeliostat(timerCacheTask.getComLine6().getHeliostats().get(111));
        h1118.setHeliostat(timerCacheTask.getComLine6().getHeliostats().get(112));
        h1120.setHeliostat(timerCacheTask.getComLine6().getHeliostats().get(113));
        h1122.setHeliostat(timerCacheTask.getComLine6().getHeliostats().get(114));
    }

    private void setRow10() {
        h1031.setHeliostat(timerCacheTask.getComLine14().getHeliostats().get(97));
        h1029.setHeliostat(timerCacheTask.getComLine14().getHeliostats().get(96));
        h1027.setHeliostat(timerCacheTask.getComLine14().getHeliostats().get(95));
        h1025.setHeliostat(timerCacheTask.getComLine14().getHeliostats().get(94));
        h1023.setHeliostat(timerCacheTask.getComLine14().getHeliostats().get(93));
        h1021.setHeliostat(timerCacheTask.getComLine14().getHeliostats().get(92));
        h1019.setHeliostat(timerCacheTask.getComLine14().getHeliostats().get(91));
        h1017.setHeliostat(timerCacheTask.getComLine13().getHeliostats().get(90));
        h1015.setHeliostat(timerCacheTask.getComLine13().getHeliostats().get(89));
        h1013.setHeliostat(timerCacheTask.getComLine13().getHeliostats().get(88));
        h1011.setHeliostat(timerCacheTask.getComLine13().getHeliostats().get(87));
        h1009.setHeliostat(timerCacheTask.getComLine13().getHeliostats().get(86));
        h1007.setHeliostat(timerCacheTask.getComLine13().getHeliostats().get(85));
        h1005.setHeliostat(timerCacheTask.getComLine13().getHeliostats().get(84));
        h1003.setHeliostat(timerCacheTask.getComLine13().getHeliostats().get(83));
        h1001.setHeliostat(timerCacheTask.getComLine13().getHeliostats().get(82));
        h1002.setHeliostat(timerCacheTask.getComLine5().getHeliostats().get(87));
        h1004.setHeliostat(timerCacheTask.getComLine5().getHeliostats().get(88));
        h1006.setHeliostat(timerCacheTask.getComLine5().getHeliostats().get(89));
        h1008.setHeliostat(timerCacheTask.getComLine5().getHeliostats().get(90));
        h1010.setHeliostat(timerCacheTask.getComLine5().getHeliostats().get(91));
        h1012.setHeliostat(timerCacheTask.getComLine5().getHeliostats().get(92));
        h1014.setHeliostat(timerCacheTask.getComLine5().getHeliostats().get(93));
        h1016.setHeliostat(timerCacheTask.getComLine5().getHeliostats().get(94));
        h1018.setHeliostat(timerCacheTask.getComLine5().getHeliostats().get(95));
        h1020.setHeliostat(timerCacheTask.getComLine6().getHeliostats().get(96));
        h1022.setHeliostat(timerCacheTask.getComLine6().getHeliostats().get(97));
        h1024.setHeliostat(timerCacheTask.getComLine6().getHeliostats().get(98));
        h1026.setHeliostat(timerCacheTask.getComLine6().getHeliostats().get(99));
        h1028.setHeliostat(timerCacheTask.getComLine6().getHeliostats().get(100));
        h1030.setHeliostat(timerCacheTask.getComLine6().getHeliostats().get(101));
        h1032.setHeliostat(timerCacheTask.getComLine6().getHeliostats().get(102));
    }

    private void setRow09() {
        h0929.setHeliostat(timerCacheTask.getComLine12().getHeliostats().get(81));
        h0927.setHeliostat(timerCacheTask.getComLine12().getHeliostats().get(80));
        h0925.setHeliostat(timerCacheTask.getComLine12().getHeliostats().get(79));
        h0923.setHeliostat(timerCacheTask.getComLine12().getHeliostats().get(78));
        h0921.setHeliostat(timerCacheTask.getComLine12().getHeliostats().get(77));
        h0919.setHeliostat(timerCacheTask.getComLine12().getHeliostats().get(76));
        h0917.setHeliostat(timerCacheTask.getComLine13().getHeliostats().get(75));
        h0915.setHeliostat(timerCacheTask.getComLine13().getHeliostats().get(74));
        h0913.setHeliostat(timerCacheTask.getComLine13().getHeliostats().get(73));
        h0911.setHeliostat(timerCacheTask.getComLine13().getHeliostats().get(72));
        h0909.setHeliostat(timerCacheTask.getComLine13().getHeliostats().get(71));
        h0907.setHeliostat(timerCacheTask.getComLine13().getHeliostats().get(70));
        h0905.setHeliostat(timerCacheTask.getComLine13().getHeliostats().get(69));
        h0903.setHeliostat(timerCacheTask.getComLine13().getHeliostats().get(68));
        h0901.setHeliostat(timerCacheTask.getComLine13().getHeliostats().get(67));
        h0900.setHeliostat(timerCacheTask.getComLine5().getHeliostats().get(71));
        h0902.setHeliostat(timerCacheTask.getComLine5().getHeliostats().get(72));
        h0904.setHeliostat(timerCacheTask.getComLine5().getHeliostats().get(73));
        h0906.setHeliostat(timerCacheTask.getComLine5().getHeliostats().get(74));
        h0908.setHeliostat(timerCacheTask.getComLine5().getHeliostats().get(75));
        h0910.setHeliostat(timerCacheTask.getComLine5().getHeliostats().get(76));
        h0912.setHeliostat(timerCacheTask.getComLine5().getHeliostats().get(77));
        h0914.setHeliostat(timerCacheTask.getComLine5().getHeliostats().get(78));
        h0916.setHeliostat(timerCacheTask.getComLine5().getHeliostats().get(79));
        h0918.setHeliostat(timerCacheTask.getComLine5().getHeliostats().get(80));
        h0920.setHeliostat(timerCacheTask.getComLine4().getHeliostats().get(81));
        h0922.setHeliostat(timerCacheTask.getComLine4().getHeliostats().get(82));
        h0924.setHeliostat(timerCacheTask.getComLine4().getHeliostats().get(83));
        h0926.setHeliostat(timerCacheTask.getComLine4().getHeliostats().get(84));
        h0928.setHeliostat(timerCacheTask.getComLine4().getHeliostats().get(85));
        h0930.setHeliostat(timerCacheTask.getComLine4().getHeliostats().get(86));
    }

    private void setRow08() {
        h0827.setHeliostat(timerCacheTask.getComLine12().getHeliostats().get(66));
        h0825.setHeliostat(timerCacheTask.getComLine12().getHeliostats().get(65));
        h0823.setHeliostat(timerCacheTask.getComLine12().getHeliostats().get(64));
        h0821.setHeliostat(timerCacheTask.getComLine12().getHeliostats().get(63));
        h0819.setHeliostat(timerCacheTask.getComLine12().getHeliostats().get(62));
        h0817.setHeliostat(timerCacheTask.getComLine12().getHeliostats().get(61));
        h0815.setHeliostat(timerCacheTask.getComLine12().getHeliostats().get(60));
        h0813.setHeliostat(timerCacheTask.getComLine12().getHeliostats().get(59));
        h0811.setHeliostat(timerCacheTask.getComLine12().getHeliostats().get(58));
        h0809.setHeliostat(timerCacheTask.getComLine12().getHeliostats().get(57));
        h0807.setHeliostat(timerCacheTask.getComLine12().getHeliostats().get(56));
        h0805.setHeliostat(timerCacheTask.getComLine12().getHeliostats().get(55));
        h0803.setHeliostat(timerCacheTask.getComLine12().getHeliostats().get(54));
        h0801.setHeliostat(timerCacheTask.getComLine12().getHeliostats().get(53));
        h0802.setHeliostat(timerCacheTask.getComLine4().getHeliostats().get(57));
        h0804.setHeliostat(timerCacheTask.getComLine4().getHeliostats().get(58));
        h0806.setHeliostat(timerCacheTask.getComLine4().getHeliostats().get(59));
        h0808.setHeliostat(timerCacheTask.getComLine4().getHeliostats().get(60));
        h0810.setHeliostat(timerCacheTask.getComLine4().getHeliostats().get(61));
        h0812.setHeliostat(timerCacheTask.getComLine4().getHeliostats().get(62));
        h0814.setHeliostat(timerCacheTask.getComLine4().getHeliostats().get(63));
        h0816.setHeliostat(timerCacheTask.getComLine4().getHeliostats().get(64));
        h0818.setHeliostat(timerCacheTask.getComLine4().getHeliostats().get(65));
        h0820.setHeliostat(timerCacheTask.getComLine4().getHeliostats().get(66));
        h0822.setHeliostat(timerCacheTask.getComLine4().getHeliostats().get(67));
        h0824.setHeliostat(timerCacheTask.getComLine4().getHeliostats().get(68));
        h0826.setHeliostat(timerCacheTask.getComLine4().getHeliostats().get(69));
        h0828.setHeliostat(timerCacheTask.getComLine4().getHeliostats().get(70));
    }

    private void setRow07() {
        h0721.setHeliostat(timerCacheTask.getComLine11().getHeliostats().get(52));
        h0719.setHeliostat(timerCacheTask.getComLine11().getHeliostats().get(51));
        h0717.setHeliostat(timerCacheTask.getComLine11().getHeliostats().get(50));
        h0715.setHeliostat(timerCacheTask.getComLine11().getHeliostats().get(49));
        h0713.setHeliostat(timerCacheTask.getComLine11().getHeliostats().get(48));
        h0711.setHeliostat(timerCacheTask.getComLine11().getHeliostats().get(47));
        h0709.setHeliostat(timerCacheTask.getComLine11().getHeliostats().get(46));
        h0707.setHeliostat(timerCacheTask.getComLine11().getHeliostats().get(45));
        h0705.setHeliostat(timerCacheTask.getComLine11().getHeliostats().get(44));
        h0703.setHeliostat(timerCacheTask.getComLine11().getHeliostats().get(43));
        h0701.setHeliostat(timerCacheTask.getComLine11().getHeliostats().get(42));
        h0700.setHeliostat(timerCacheTask.getComLine3().getHeliostats().get(45));
        h0702.setHeliostat(timerCacheTask.getComLine3().getHeliostats().get(46));
        h0704.setHeliostat(timerCacheTask.getComLine3().getHeliostats().get(47));
        h0706.setHeliostat(timerCacheTask.getComLine3().getHeliostats().get(48));
        h0708.setHeliostat(timerCacheTask.getComLine3().getHeliostats().get(49));
        h0710.setHeliostat(timerCacheTask.getComLine3().getHeliostats().get(50));
        h0712.setHeliostat(timerCacheTask.getComLine3().getHeliostats().get(51));
        h0714.setHeliostat(timerCacheTask.getComLine3().getHeliostats().get(52));
        h0716.setHeliostat(timerCacheTask.getComLine3().getHeliostats().get(53));
        h0718.setHeliostat(timerCacheTask.getComLine3().getHeliostats().get(54));
        h0720.setHeliostat(timerCacheTask.getComLine3().getHeliostats().get(55));
        h0722.setHeliostat(timerCacheTask.getComLine3().getHeliostats().get(56));
    }

    private void setRow06() {
        h0619.setHeliostat(timerCacheTask.getComLine11().getHeliostats().get(41));
        h0617.setHeliostat(timerCacheTask.getComLine11().getHeliostats().get(40));
        h0615.setHeliostat(timerCacheTask.getComLine11().getHeliostats().get(39));
        h0613.setHeliostat(timerCacheTask.getComLine11().getHeliostats().get(38));
        h0611.setHeliostat(timerCacheTask.getComLine11().getHeliostats().get(37));
        h0609.setHeliostat(timerCacheTask.getComLine11().getHeliostats().get(36));
        h0607.setHeliostat(timerCacheTask.getComLine11().getHeliostats().get(35));
        h0605.setHeliostat(timerCacheTask.getComLine11().getHeliostats().get(34));
        h0603.setHeliostat(timerCacheTask.getComLine10().getHeliostats().get(33));
        h0601.setHeliostat(timerCacheTask.getComLine10().getHeliostats().get(32));
        h0602.setHeliostat(timerCacheTask.getComLine2().getHeliostats().get(35));
        h0604.setHeliostat(timerCacheTask.getComLine2().getHeliostats().get(36));
        h0606.setHeliostat(timerCacheTask.getComLine3().getHeliostats().get(37));
        h0608.setHeliostat(timerCacheTask.getComLine3().getHeliostats().get(38));
        h0610.setHeliostat(timerCacheTask.getComLine3().getHeliostats().get(39));
        h0612.setHeliostat(timerCacheTask.getComLine3().getHeliostats().get(40));
        h0614.setHeliostat(timerCacheTask.getComLine3().getHeliostats().get(41));
        h0616.setHeliostat(timerCacheTask.getComLine3().getHeliostats().get(42));
        h0618.setHeliostat(timerCacheTask.getComLine3().getHeliostats().get(43));
        h0620.setHeliostat(timerCacheTask.getComLine3().getHeliostats().get(44));
    }

    private void setRow05() {
        h0515.setHeliostat(timerCacheTask.getComLine10().getHeliostats().get(31));
        h0513.setHeliostat(timerCacheTask.getComLine10().getHeliostats().get(30));
        h0511.setHeliostat(timerCacheTask.getComLine10().getHeliostats().get(29));
        h0509.setHeliostat(timerCacheTask.getComLine10().getHeliostats().get(28));
        h0507.setHeliostat(timerCacheTask.getComLine10().getHeliostats().get(27));
        h0505.setHeliostat(timerCacheTask.getComLine10().getHeliostats().get(26));
        h0503.setHeliostat(timerCacheTask.getComLine10().getHeliostats().get(25));
        h0501.setHeliostat(timerCacheTask.getComLine10().getHeliostats().get(24));
        h0500.setHeliostat(timerCacheTask.getComLine2().getHeliostats().get(26));
        h0502.setHeliostat(timerCacheTask.getComLine2().getHeliostats().get(27));
        h0504.setHeliostat(timerCacheTask.getComLine2().getHeliostats().get(28));
        h0506.setHeliostat(timerCacheTask.getComLine2().getHeliostats().get(29));
        h0508.setHeliostat(timerCacheTask.getComLine2().getHeliostats().get(30));
        h0510.setHeliostat(timerCacheTask.getComLine2().getHeliostats().get(31));
        h0512.setHeliostat(timerCacheTask.getComLine2().getHeliostats().get(32));
        h0514.setHeliostat(timerCacheTask.getComLine2().getHeliostats().get(33));
        h0516.setHeliostat(timerCacheTask.getComLine2().getHeliostats().get(34));
    }

    private void setRow04() {
        h0415.setHeliostat(timerCacheTask.getComLine10().getHeliostats().get(23));
        h0413.setHeliostat(timerCacheTask.getComLine10().getHeliostats().get(22));
        h0411.setHeliostat(timerCacheTask.getComLine10().getHeliostats().get(21));
        h0409.setHeliostat(timerCacheTask.getComLine10().getHeliostats().get(20));
        h0407.setHeliostat(timerCacheTask.getComLine10().getHeliostats().get(19));
        h0405.setHeliostat(timerCacheTask.getComLine10().getHeliostats().get(18));
        h0403.setHeliostat(timerCacheTask.getComLine10().getHeliostats().get(17));
        h0401.setHeliostat(timerCacheTask.getComLine10().getHeliostats().get(16));
        h0402.setHeliostat(timerCacheTask.getComLine2().getHeliostats().get(18));
        h0404.setHeliostat(timerCacheTask.getComLine2().getHeliostats().get(19));
        h0406.setHeliostat(timerCacheTask.getComLine2().getHeliostats().get(20));
        h0408.setHeliostat(timerCacheTask.getComLine2().getHeliostats().get(21));
        h0410.setHeliostat(timerCacheTask.getComLine2().getHeliostats().get(22));
        h0412.setHeliostat(timerCacheTask.getComLine2().getHeliostats().get(23));
        h0414.setHeliostat(timerCacheTask.getComLine2().getHeliostats().get(24));
        h0416.setHeliostat(timerCacheTask.getComLine2().getHeliostats().get(25));
    }

    private void setRow03() {
        h0311.setHeliostat(timerCacheTask.getComLine9().getHeliostats().get(15));
        h0309.setHeliostat(timerCacheTask.getComLine9().getHeliostats().get(14));
        h0307.setHeliostat(timerCacheTask.getComLine9().getHeliostats().get(13));
        h0305.setHeliostat(timerCacheTask.getComLine9().getHeliostats().get(12));
        h0303.setHeliostat(timerCacheTask.getComLine9().getHeliostats().get(11));
        h0301.setHeliostat(timerCacheTask.getComLine9().getHeliostats().get(10));
        h0300.setHeliostat(timerCacheTask.getComLine1().getHeliostats().get(11));
        h0302.setHeliostat(timerCacheTask.getComLine1().getHeliostats().get(12));
        h0304.setHeliostat(timerCacheTask.getComLine1().getHeliostats().get(13));
        h0306.setHeliostat(timerCacheTask.getComLine1().getHeliostats().get(14));
        h0308.setHeliostat(timerCacheTask.getComLine1().getHeliostats().get(15));
        h0310.setHeliostat(timerCacheTask.getComLine1().getHeliostats().get(16));
        h0312.setHeliostat(timerCacheTask.getComLine1().getHeliostats().get(17));
    }

    private void setRow02() {
        h0209.setHeliostat(timerCacheTask.getComLine9().getHeliostats().get(9));
        h0207.setHeliostat(timerCacheTask.getComLine9().getHeliostats().get(8));
        h0205.setHeliostat(timerCacheTask.getComLine9().getHeliostats().get(7));
        h0203.setHeliostat(timerCacheTask.getComLine9().getHeliostats().get(6));
        h0201.setHeliostat(timerCacheTask.getComLine9().getHeliostats().get(5));
        h0202.setHeliostat(timerCacheTask.getComLine1().getHeliostats().get(6));
        h0204.setHeliostat(timerCacheTask.getComLine1().getHeliostats().get(7));
        h0206.setHeliostat(timerCacheTask.getComLine1().getHeliostats().get(8));
        h0208.setHeliostat(timerCacheTask.getComLine1().getHeliostats().get(9));
        h0210.setHeliostat(timerCacheTask.getComLine1().getHeliostats().get(10));
    }

    private void setRow01() {
        h0107.setHeliostat(timerCacheTask.getComLine9().getHeliostats().get(4));
        h0105.setHeliostat(timerCacheTask.getComLine9().getHeliostats().get(3));
        h0103.setHeliostat(timerCacheTask.getComLine9().getHeliostats().get(2));
        h0101.setHeliostat(timerCacheTask.getComLine9().getHeliostats().get(1));
        h0100.setHeliostat(timerCacheTask.getComLine1().getHeliostats().get(1));
        h0102.setHeliostat(timerCacheTask.getComLine1().getHeliostats().get(2));
        h0104.setHeliostat(timerCacheTask.getComLine1().getHeliostats().get(3));
        h0106.setHeliostat(timerCacheTask.getComLine1().getHeliostats().get(4));
        h0108.setHeliostat(timerCacheTask.getComLine1().getHeliostats().get(5));
    }


    //        /**
    //         * It sets the GUI elements to represent the <code>Row</code> objects which are obtained from the server
    //         */
    //        private void addRows() {
    //            ComLine[] Comlines = ComLineController.loadField();
    //            for (ComLine comLine : Comlines) {
    //                rows_vbox.getChildren().add(createGUIHbox(comLine));
    //            }
    //        }
    //
    //        private HBox createGUIHbox(ComLine comLine) {
    //            HBox hBox = new HBox();
    //            hBox.setSpacing(30.0);
    //            hBox.setAlignment(Pos.CENTER);
    //            createRegion(hBox);
    //            createLabel(comLine, hBox);
    //            createButtons(comLine, hBox);
    //            createLabel(comLine, hBox);
    //            createRegion(hBox);
    //            return hBox;
    //        }
    //
    //        private void createRegion(HBox hBox) {
    //            Region region = new Region();
    //            hBox.setHgrow(region, Priority.ALWAYS);
    //            hBox.getChildren().add(region);
    //        }
    //
    //        private void createLabel(ComLine comLine, HBox hBox) {
    //            Label label = new Label(String.valueOf(comLine.getId()));
    //            label.setFont(new Font(18));
    //            label.setTextFill(Color.WHITE);
    //            hBox.getChildren().add(label);
    //        }
    //
    //        private void createButtons(ComLine comLine, HBox hBox) {
    //            for (Heliostat heliostat : comLine.getHeliostats().values()) {
    //                Button button = new Button();
    //                hBox.getChildren().add(button);
    //            }
    //        }
}
