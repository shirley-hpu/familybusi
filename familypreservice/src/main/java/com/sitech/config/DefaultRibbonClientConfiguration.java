package com.sitech.config;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.Server;
import com.netflix.loadbalancer.ServerListFilter;
import com.sitech.ijcf.springcloud.common.BaseRibbonClientConfiguration;
import com.sitech.ijcf.springcloud.zookeeper.discovery.filter.ZookeeperZoneTenementPreferenceServerListFilter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cloud.netflix.ribbon.RibbonClientConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

/**
 * Overlay some primordial beans in {@link RibbonClientConfiguration}
 * should be loaded before RibbonClientConfiguration
 *
 * @author shirley
 * @since 1.0
 */
@Configuration
@Order(0)
public class DefaultRibbonClientConfiguration extends BaseRibbonClientConfiguration {

    @Bean
    @ConditionalOnMissingBean
    @SuppressWarnings("unchecked")
    public ServerListFilter<Server> ribbonServerListFilter(IClientConfig config) {
        if (this.propertiesFactory.isSet(ServerListFilter.class, name)) {
            return this.propertiesFactory.get(ServerListFilter.class, config, name);
        }
        ZookeeperZoneTenementPreferenceServerListFilter filter = new ZookeeperZoneTenementPreferenceServerListFilter();
        filter.initWithNiwsConfig(config);
        return filter;
    }

}
