package com.flume.logcollector;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import org.apache.flume.Channel;
import org.apache.flume.Context;
import org.apache.flume.Event;
import org.apache.flume.EventDeliveryException;
import org.apache.flume.Transaction;
import org.apache.flume.Transaction.TransactionState;
import org.apache.flume.conf.Configurable;
import org.apache.flume.lifecycle.LifecycleState;
import org.apache.flume.sink.AbstractSink;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONArray;
import com.google.common.base.Preconditions;
import com.google.common.base.Throwables;
 
 
public class LogCollector extends AbstractSink  implements Configurable{

    private Logger LOG = LoggerFactory.getLogger(LogCollector.class);
    private String hostname;
    private String port;
    private int batchSize;
    private String postUrl;
    public LogCollector() {
        LOG.info("LogCollector start...");
    }

    public void configure(Context context) {
        hostname = context.getString("hostname");
        Preconditions.checkNotNull(hostname, "hostname must be set!!");
        port = context.getString("port");
        Preconditions.checkNotNull(port, "port must be set!!");
        batchSize = context.getInteger("batchSize", 100);
        Preconditions.checkNotNull(batchSize > 0, "batchSize must be a positive number!!");
        postUrl = "http://"+hostname+":"+port+"/";
    }
    
    @Override
    public void start() {
        super.start();
    }

    @Override
    public void stop() {
        super.stop();
    }

    public synchronized Status process() throws EventDeliveryException {
        Status result = Status.READY;
        Channel channel = getChannel();
        Transaction transaction = null;
        try {
            transaction = channel.getTransaction();
            transaction.commit();
            transaction.begin();
            Event event = null;
            String content = null;
            List<String> contents=new ArrayList<String>();
            for (int i = 0; i < batchSize; i++) {
                event = channel.take();
                if (event != null) {//对事件进行处理
                    content = new String(event.getBody());
                    contents.add(content);
                } else {
                    result = Status.BACKOFF;
                    break;
                }
            }
            if (contents.size() > 0) {
                Response response= postJson(postUrl, JSONArray.toJSON(contents).toString());
                if(response!=null && response.isSuccessful()){
                    transaction.commit();//通过 commit 机制确保数据不丢失
                }else{
                	transaction.rollback();
                }
            }else{
                transaction.commit();
            }
        } catch (Exception e) {
            try {
                transaction.rollback();
            } catch (Exception e2) {
                LOG.error("Exception in rollback. Rollback might not have been successful.", e2);
            }
            LOG.error("Failed to commit transaction. Transaction rolled back.", e);
            Throwables.propagate(e);
        }finally {
            if (transaction != null) {
            	if(channel.getLifecycleState().compareTo(LifecycleState.START)>0){
            		transaction.commit();
            	}
            	transaction.close();
                LOG.debug("close Transaction");
            }
        }
        return result;
    }

    /**
     * post请求，json数据为body
     *
     * @param url
     * @param json
     */
    public Response postJson(String url, String json) {
        OkHttpClient client = new OkHttpClient();
        RequestBody body = RequestBody.create(MediaType.parse("application/json"), json);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        Response response = null;
        try {
            response = client.newCall(request).execute();
            if (!response.isSuccessful()){
                LOG.info("request was error");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }
}