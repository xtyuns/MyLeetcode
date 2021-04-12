package codes.gof;

public class DCL {
    private volatile static DCL INSTANCE = null;

    private DCL() {
    }

    public static DCL getInstance() {
        if (INSTANCE == null) {
            synchronized (DCL.class) {
                if (INSTANCE == null) {
                    INSTANCE = new DCL();
                }
            }
        }

        return INSTANCE;
    }
}
