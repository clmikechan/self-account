package tw.clarewinette.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "customerEntityManagerFactory",//對映(2)
        transactionManagerRef = "customerTransactionManager",//對映(3)
        basePackages = {
                "tw.clarewinette.repositories" //Repository所在路徑
        }
)
public class PostgresqlConfig {
    @Primary
    @Bean(name = "customerDataSource") //(1)自訂義定義 DataSource 名稱
    @ConfigurationProperties(prefix = "self.account")//application.properties設定的資料庫連線前綴
    public DataSource customerDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean(name = "customerEntityManagerFactory") //(2)自訂義定義EntityManagerFactory名稱
    public LocalContainerEntityManagerFactoryBean
    entityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("customerDataSource") DataSource dataSource
    ) {
        return builder
                .dataSource(dataSource)
                .packages("tw.clarewinette.models")//Model所在路徑
                .persistenceUnit("db1")
                .build();
    }

    @Primary
    @Bean(name = "customerTransactionManager") //(3)自訂義定義 TransactionManager 名稱
    public PlatformTransactionManager customerTransactionManager(
			@Qualifier("customerEntityManagerFactory") EntityManagerFactory customerEntityManagerFactory //對映(2)
    ) {
        return new JpaTransactionManager(customerEntityManagerFactory);//對映(2)
    }
}
