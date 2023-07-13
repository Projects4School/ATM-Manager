package Models;

public class Operation {
    static enum EOperationType {
        DEPOSIT,
        WITHDRAW
    };
    private String OperationID;
    private String ClientID;
    private EOperationType Type;
    private Float Mount;
}
