# swagger2.x

## url

```text
http://localhost:8081/swagger-ui.html
```

## pom

```xml
<swagger2.version>2.9.2</swagger2.version>
<dependency>
    <groupId>io.springfox</groupId>
    <artifactId>springfox-swagger-ui</artifactId>
    <version>${swagger2.version}</version>
</dependency>
<dependency>
    <groupId>io.springfox</groupId>
    <artifactId>springfox-swagger2</artifactId>
    <version>${swagger2.version}</version>
</dependency>
```

## config

```java
@Configuration
@EnableSwagger2
public class Swagger2Configuration {
    /**
     * api接口包扫描路径
     */
    public static final String SWAGGER_SCAN_BASE_PACKAGE = "com.cherry";

    public static final String VERSION = "1.0.0";


    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage(SWAGGER_SCAN_BASE_PACKAGE))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                //设置文档的标题
                .title("一叶飘零Cherry")
                // 设置文档的描述
                .description("逝者如斯夫，不舍昼夜！")
                // 设置文档的版本信息-> 1.0.0 Version information
                .version(VERSION)
                // 设置文档的License信息->1.3 License information
                .termsOfServiceUrl("http://www.baidu.com")
                .build();
    }
}
```

## demo

```java
@Api("HelloController")
@RestController
public class HelloController {

    @ApiOperation("test hello")
    @GetMapping("/hello")
    public String hello() {
        return "Hello";
    }

}
```

# swagger3.x

## url

```text
http://localhost:8081/swagger-ui/index.html
```

## pom

```xml
<dependency>
    <groupId>io.springfox</groupId>
    <artifactId>springfox-boot-starter</artifactId>
    <version>${swagger2.version}</version>
</dependency>
```

## config

```java
@Configuration
public class SwaggerWebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.
                addResourceHandler("/swagger-ui/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/springfox-swagger-ui/")
                .resourceChain(false);
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/swagger-ui/")
                .setViewName("forward:/swagger-ui/index.html");
    }
}

@Configuration
public class Swagger3Config {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                //设置文档的标题
                .title("一叶飘零Cherry")
                // 设置文档的描述
                .description("逝者如斯夫，不舍昼夜！")
                .contact(new Contact("Cherry", "#", "180835910@qq.com"))
                .version("1.0")
                .build();
    }
}
```
