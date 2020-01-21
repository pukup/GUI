package psa.cesa.model;

/**
 * DAO which represents a physical heliostat
 */
public class Heliostat {
    /**
     * @param address Represents the modbus slave address
     * @param state Static and dynamic positions representation
     * @param event Operation, security, communications and such events
     * @param diagnosisAz Axis diagnosis
     * @param diagnosisEl Axis diagnosis
     * @param positionAz Actual azimuth position
     * @param positionEL Actual elevation position
     * @param setPointAZ Azimuth set point
     * @param setPointEL Elevation set point
     */

    private int address;
    private int state;
    private int event;
    private int diagnosysAZ, diagnosysEL;
    private int positionAZ, positionEL;
    private int setPointAZ, setPointEL;

    public int getAddress() {
        return address;
    }

    public void setAddress(int address) {
        this.address = address;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getEvent() {
        return event;
    }

    public void setEvent(int event) {
        this.event = event;
    }

    public int getDiagnosysAZ() {
        return diagnosysAZ;
    }

    public void setDiagnosysAZ(int diagnosysAZ) {
        this.diagnosysAZ = diagnosysAZ;
    }

    public int getDiagnosysEL() {
        return diagnosysEL;
    }

    public void setDiagnosysEL(int diagnosysEL) {
        this.diagnosysEL = diagnosysEL;
    }

    public int getPositionAZ() {
        return positionAZ;
    }

    public void setPositionAZ(int positionAZ) {
        this.positionAZ = positionAZ;
    }

    public int getPositionEL() {
        return positionEL;
    }

    public void setPositionEL(int positionEL) {
        this.positionEL = positionEL;
    }

    public int getSetPointAZ() {
        return setPointAZ;
    }

    public void setSetPointAZ(int setPointAZ) {
        this.setPointAZ = setPointAZ;
    }

    public int getSetPointEL() {
        return setPointEL;
    }

    public void setSetPointEL(int setPointEL) {
        this.setPointEL = setPointEL;
    }
}
