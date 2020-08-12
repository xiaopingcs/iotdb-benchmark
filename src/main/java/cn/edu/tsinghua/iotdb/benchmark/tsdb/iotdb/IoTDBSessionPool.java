package cn.edu.tsinghua.iotdb.benchmark.tsdb.iotdb;

import cn.edu.tsinghua.iotdb.benchmark.conf.Constants;
import org.apache.iotdb.rpc.IoTDBConnectionException;
import org.apache.iotdb.rpc.StatementExecutionException;
import org.apache.iotdb.session.pool.SessionPool;
import org.apache.iotdb.tsfile.write.record.Tablet;

public class IoTDBSessionPool extends IoTDBSession {

  private SessionPool pool;

  public IoTDBSessionPool() {
    super(false);
    pool = new SessionPool(config.HOST, Integer.parseInt(config.PORT), Constants.USER, Constants.PASSWD, 1, config.ENABLE_THRIFT_COMPRESSION);
  }

  public void insertTablet(Tablet tablet)
      throws StatementExecutionException, IoTDBConnectionException {
    pool.insertTablet(tablet);
  }

}
