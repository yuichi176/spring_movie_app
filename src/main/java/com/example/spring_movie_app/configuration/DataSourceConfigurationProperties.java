package com.example.spring_movie_app.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

/**
 * application.ymlの設定値を受け取る
 */
@ConstructorBinding
@ConfigurationProperties(prefix = "dbcp2.jdbc")
public class DataSourceConfigurationProperties {
    private final String url;

    private final String driverClassName;

    private final String username;

    private final String password;

    private final int initialSize;

    private final int maxIdle;

    private final int minIdle;

    public DataSourceConfigurationProperties(String url, String driverClassName, String username, String password, int initialSize, int maxIdle, int minIdle) {

        this.url = url;
        this.driverClassName = driverClassName;
        this.username = username;
        this.password = password;
        this.initialSize = initialSize;
        this.maxIdle = maxIdle;
        this.minIdle = minIdle;
    }

    public String getUrl() {
        return url;
    }

    public String getDriverClassName() {
        return driverClassName;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getInitialSize() {
        return initialSize;
    }

    public int getMaxIdle() {
        return maxIdle;
    }

    public int getMinIdle() {
        return minIdle;
    }
}
