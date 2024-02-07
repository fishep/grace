# grace
Demo project for Spring Boot

- common 公共模块

- 网关
    - shop-gateway       商城网关            port: 10000 - 10009
    - back-gateway       后台网关            port: 10010 - 10019
    - open-gateway       开放网关            port: 10020 - 10029
    - ...

- 聚合服务
    - shop-service       商城服务            port: 10100 - 10199
    - back-service       后台服务            port: 10200 - 10299
    - open-service       开放服务            port: 10300 - 10399
    - ...

- 微服务
    - dms-server         基础数据            port: 11000 - 11999
    - sso-server         统一认证            port: 12000 - 12999
    - isc-server         权限管理            port: 13000 - 13999
    - plm-server         产品管理            port: 14000 - 14999
    - crm-server         客户管理            port: 15000 - 15999
    - oms-server         订单管理            port: 16000 - 16999
    - scm-server         供应链管理           port: 17000 - 17999
    - wms-server         库存管理            port: 18000 - 18999
    - fms-server         财务管理            port: 19000 - 19999
    - ...