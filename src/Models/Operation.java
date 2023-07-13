package Models;

public class Operation {
    private String OperationID;
    private String ClientID;
    private Integer Type;
    private Float Mount;
    private Integer Date;

    public Operation(String operationID, String clientID, Integer type, Float mount, Integer date) {
        OperationID = operationID;
        ClientID = clientID;
        Type = type;
        Mount = mount;
        Date = date;
    }

    public String getOperationID() {
        return OperationID;
    }

    public void setOperationID(String operationID) {
        OperationID = operationID;
    }

    public String getClientID() {
        return ClientID;
    }

    public void setClientID(String clientID) {
        ClientID = clientID;
    }

    public Integer getType() {
        return Type;
    }

    public void setType(Integer type) {
        Type = type;
    }

    public Float getMount() {
        return Mount;
    }

    public void setMount(Float mount) {
        Mount = mount;
    }

    public Integer getDate() {
        return Date;
    }

    public void setDate(Integer date) {
        Date = date;
    }

    public Object[] toObject() {
        return new Object[] {getOperationID(), getClientID(), getType(), getMount(), getDate()};
    }
}
