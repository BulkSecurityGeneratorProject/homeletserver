package com.fantosoft.homeletserver.config;

import io.github.jhipster.config.JHipsterProperties;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;
import org.ehcache.expiry.Duration;
import org.ehcache.expiry.Expirations;
import org.ehcache.jsr107.Eh107Configuration;

import java.util.concurrent.TimeUnit;

import org.springframework.boot.autoconfigure.cache.JCacheManagerCustomizer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.*;

@Configuration
@EnableCaching
public class CacheConfiguration {

    private final javax.cache.configuration.Configuration<Object, Object> jcacheConfiguration;

    public CacheConfiguration(JHipsterProperties jHipsterProperties) {
        JHipsterProperties.Cache.Ehcache ehcache =
            jHipsterProperties.getCache().getEhcache();

        jcacheConfiguration = Eh107Configuration.fromEhcacheCacheConfiguration(
            CacheConfigurationBuilder.newCacheConfigurationBuilder(Object.class, Object.class,
                ResourcePoolsBuilder.heap(ehcache.getMaxEntries()))
                .withExpiry(Expirations.timeToLiveExpiration(Duration.of(ehcache.getTimeToLiveSeconds(), TimeUnit.SECONDS)))
                .build());
    }

    @Bean
    public JCacheManagerCustomizer cacheManagerCustomizer() {
        return cm -> {
            cm.createCache(com.fantosoft.homeletserver.repository.UserRepository.USERS_BY_LOGIN_CACHE, jcacheConfiguration);
            cm.createCache(com.fantosoft.homeletserver.repository.UserRepository.USERS_BY_EMAIL_CACHE, jcacheConfiguration);
            cm.createCache(com.fantosoft.homeletserver.domain.User.class.getName(), jcacheConfiguration);
            cm.createCache(com.fantosoft.homeletserver.domain.Authority.class.getName(), jcacheConfiguration);
            cm.createCache(com.fantosoft.homeletserver.domain.User.class.getName() + ".authorities", jcacheConfiguration);
            cm.createCache(com.fantosoft.homeletserver.domain.Product.class.getName(), jcacheConfiguration);
            cm.createCache(com.fantosoft.homeletserver.domain.ProductCategory.class.getName(), jcacheConfiguration);
            cm.createCache(com.fantosoft.homeletserver.domain.ProductCategory.class.getName() + ".products", jcacheConfiguration);
            cm.createCache(com.fantosoft.homeletserver.domain.Customer.class.getName(), jcacheConfiguration);
            cm.createCache(com.fantosoft.homeletserver.domain.Customer.class.getName() + ".orders", jcacheConfiguration);
            cm.createCache(com.fantosoft.homeletserver.domain.ProductOrder.class.getName(), jcacheConfiguration);
            cm.createCache(com.fantosoft.homeletserver.domain.ProductOrder.class.getName() + ".orderItems", jcacheConfiguration);
            cm.createCache(com.fantosoft.homeletserver.domain.ProductOrder.class.getName() + ".invoices", jcacheConfiguration);
            cm.createCache(com.fantosoft.homeletserver.domain.OrderItem.class.getName(), jcacheConfiguration);
            cm.createCache(com.fantosoft.homeletserver.domain.Invoice.class.getName(), jcacheConfiguration);
            cm.createCache(com.fantosoft.homeletserver.domain.Invoice.class.getName() + ".shipments", jcacheConfiguration);
            cm.createCache(com.fantosoft.homeletserver.domain.Shipment.class.getName(), jcacheConfiguration);
            // jhipster-needle-ehcache-add-entry
        };
    }
}
