package com.spl.hm.messaging;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.spl.hm.model.Simple;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonTypeName("simpleQuery")
public class SimpleQuery extends QueryMessage.Query<Simple> {

    private Simple value;
}
