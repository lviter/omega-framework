## POJO
vo: 表现对象，体现在前端页面上需要展示的字段
DTO: 数据传输对象
BO: 业务对象，通常存在业务层，包含业务逻辑，封装对DAO、RPC调用，进行PO与VO/DTO之间的转换
PO: 持久对象，PO通常有getter/setter方法，对应数据库中的记录