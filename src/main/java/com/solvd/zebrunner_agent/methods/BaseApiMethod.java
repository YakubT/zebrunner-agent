package com.solvd.zebrunner_agent.methods;

import com.solvd.zebrunner_agent.services.AuthService;
import com.solvd.zebrunner_agent.utils.PropertiesReader;
import com.solvd.zebrunner_agent.utils.enums.Resources;
import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;

public class BaseApiMethod extends AbstractApiMethodV2 {

    private PropertiesReader agentConfig = new PropertiesReader(Resources.AGENT_CONFIG.getValue());

    public BaseApiMethod(String rq, String rs) {
        super(rq, rs);
    }

    public BaseApiMethod(String rq, String rs, String prop) {
        super(rq, rs, prop);
        replaceUrlPlaceholder("base_url", getAgentConfig().getValue("hostname"));
    }

    public PropertiesReader getAgentConfig() {
        return agentConfig;
    }

    public void setAgentConfig(PropertiesReader agentConfig) {
        this.agentConfig = agentConfig;
    }

    protected void setAuth() {
        setHeaders("Authorization=Bearer " + AuthService.getAuthToken());
    }
}
