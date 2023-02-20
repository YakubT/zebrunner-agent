package com.solvd.zebrunner_agent.methods;

import com.solvd.zebrunner_agent.utils.PropertiesReader;
import com.solvd.zebrunner_agent.utils.enums.Resources;
import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;

import java.util.Properties;

public class BaseApiMethod extends AbstractApiMethodV2 {

    private PropertiesReader agentConfig = new PropertiesReader(Resources.AGENT_CONFIG.getValue());;

    public BaseApiMethod(String rq, String rs) {
        super(rq, rs);
    }

    public BaseApiMethod(String rq, String rs, Properties properties) {
        super(rq, rs, properties);
        this.agentConfig = new PropertiesReader(Resources.AGENT_CONFIG.getValue());

    }

    public PropertiesReader getAgentConfig() {
        return agentConfig;
    }

    public void setAgentConfig(PropertiesReader agentConfig) {
        this.agentConfig = agentConfig;
    }
}
