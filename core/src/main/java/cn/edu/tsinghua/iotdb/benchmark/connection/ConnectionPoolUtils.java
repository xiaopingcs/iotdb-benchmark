package cn.edu.tsinghua.iotdb.benchmark.connection;


/*连接池工具类，返回唯一的一个数据库连接池对象,单例模式*/
public class ConnectionPoolUtils {
    private ConnectionPoolUtils(){};//私有静态方法
    private static ConnectionPool poolInstance = null;
    public static ConnectionPool getPoolInstance(String url, String username, String password, String driverName){
        if(poolInstance == null) {
            poolInstance = new ConnectionPool(driverName, url, username, password);
            try {
                poolInstance.createPool();
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return poolInstance;
    }
}
