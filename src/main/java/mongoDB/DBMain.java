package mongoDB;

public class DBMain {
    public static void main(String[] args) {
        DBUtils.getInstance().getMongoClient();
        DBUtils.getInstance().getDatabase();
        DBUtils.getInstance().getCollection();
        App.app();
    }
}
