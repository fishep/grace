# grace
Demo project for Spring Boot

- 网关
    - grace-gateway      应用网关            port: 10000 - 10099

- 聚合服务
    - shop-service       商城服务            port: 10100 - 10199
    - back-service       后台服务            port: 10200 - 10299
    - open-service       开放服务            port: 10300 - 10399
    - ...

- 微服务
    - bss-server         基础服务            port: 11000 - 11999
    - sso-server         认证服务            port: 12000 - 12999
    - isc-server         鉴权服务            port: 13000 - 13999
    - erp-server         企业管理            port: 14000 - 14999
    - plm-server         产品管理            port: 15000 - 15999
    - crm-server         客户管理            port: 16000 - 16999
    - oms-server         订单管理            port: 17000 - 17999
    - scm-server         供应链管理           port: 18000 - 18999
    - wms-server         库存管理            port: 19000 - 19999
    - fms-server         财务管理            port: 20000 - 20999
    - ...

### 模块依赖关系
```text
                                           starter --------> common <-------- server
                                              ^                ^                ^
                                              |                |                |
                  |                  | xxx-starter ----> xxx-common <---- xxx-server
                  | shop-service --> |        |                |                |
                  |                  |        |                |                |
                  |                  |        |                |                |
grace-gateway --> | back-service --> | yyy-starter ----> yyy-common <---- yyy-server
                  |                  |        |                |                |
                  |                  |        |                |                |
                  | open-service --> |        |                |                |
                  |                  | zzz-starter ----> zzz-common <---- zzz-server
```

### so many O
PO（Persisted Object）  
DO（Domain Object）  
TO（Transfer Object）  
DTO（Data Transfer Object）  
VO（View Object）  
BO（Business Object）  
POJO（Plain Old Java Object）  
DAO（Data Access Object）  