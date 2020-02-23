package com.leetcode.ds.medium;


import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Host;
import com.datastax.driver.core.Metadata;

public class SimpleClient {

private Cluster cluster;

public void connect(String node){

    cluster = Cluster.builder().addContactPoint(node).build();
    Metadata metadata = cluster.getMetadata();
    System.out.println(metadata.getClusterName());
}   


public void close()
{
cluster.shutdown();
}

public static void main(String args[]) {

SimpleClient client = new SimpleClient();
client.connect("127.0.0.1");
client.close();
}
