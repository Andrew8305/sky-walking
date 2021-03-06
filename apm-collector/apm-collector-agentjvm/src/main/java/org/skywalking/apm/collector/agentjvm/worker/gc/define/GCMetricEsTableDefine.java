package org.skywalking.apm.collector.agentjvm.worker.gc.define;

import org.skywalking.apm.collector.storage.elasticsearch.define.ElasticSearchColumnDefine;
import org.skywalking.apm.collector.storage.elasticsearch.define.ElasticSearchTableDefine;
import org.skywalking.apm.collector.storage.define.jvm.GCMetricTable;

/**
 * @author pengys5
 */
public class GCMetricEsTableDefine extends ElasticSearchTableDefine {

    public GCMetricEsTableDefine() {
        super(GCMetricTable.TABLE);
    }

    @Override public int refreshInterval() {
        return 1;
    }

    @Override public int numberOfShards() {
        return 2;
    }

    @Override public int numberOfReplicas() {
        return 0;
    }

    @Override public void initialize() {
        addColumn(new ElasticSearchColumnDefine(GCMetricTable.COLUMN_APPLICATION_INSTANCE_ID, ElasticSearchColumnDefine.Type.Integer.name()));
        addColumn(new ElasticSearchColumnDefine(GCMetricTable.COLUMN_PHRASE, ElasticSearchColumnDefine.Type.Integer.name()));
        addColumn(new ElasticSearchColumnDefine(GCMetricTable.COLUMN_COUNT, ElasticSearchColumnDefine.Type.Long.name()));
        addColumn(new ElasticSearchColumnDefine(GCMetricTable.COLUMN_TIME, ElasticSearchColumnDefine.Type.Long.name()));
        addColumn(new ElasticSearchColumnDefine(GCMetricTable.COLUMN_TIME_BUCKET, ElasticSearchColumnDefine.Type.Long.name()));
    }
}
