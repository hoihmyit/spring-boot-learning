package com.spl.hm.springboot_kafka.config.partitioner;

import java.util.Map;

import org.apache.kafka.clients.producer.Partitioner;
import org.apache.kafka.common.Cluster;

public class CustomPartitioner implements Partitioner {

    @Override
    public int partition(
        final String topic,
        final Object keyObj,
        final byte[] keyBytes,
        final Object value,
        final byte[] valueBytes,
        final Cluster cluster
    ) {
        String key = (String) keyObj;
        int numPartitions = cluster.partitionCountForTopic(topic);

        int id = Integer.parseInt(key);
        return id % numPartitions;
    }

    @Override
    public void close() {

    }

    @Override
    public void configure(final Map<String, ?> configs) {

    }
}
