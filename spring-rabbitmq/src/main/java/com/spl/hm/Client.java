package com.spl.hm;

import com.spl.hm.model.Simple;
import com.spl.hm.model.SimpleRequest;

public interface Client {

    Simple findSimpleById(SimpleRequest simpleRequest, int queryPriority, long waitMillis);
}
