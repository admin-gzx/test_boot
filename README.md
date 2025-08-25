# 图书馆管理系统

## 项目简介
这是一个基于Spring Boot的前后端分离图书馆管理系统，实现了图书和读者的增删改查功能。

## 功能模块
1. 图书管理
2. 读者管理

## 技术栈
- 后端：Spring Boot 2.7.0
  - spring-boot-starter-web: 用于构建Web应用程序
  - spring-boot-starter-data-jpa: 用于数据持久化
  - spring-boot-starter-test: 用于测试
- 前端：Vue.js + Element UI
- 数据库：MySQL 8.0
- 数据库连接：JPA/Hibernate

## 数据库设计

### 表结构

#### 图书表 (book)
| 字段名 | 类型 | 约束 | 描述 |
|--------|------|------|------|
| id | BIGINT | PRIMARY KEY, AUTO_INCREMENT | 图书ID |
| title | VARCHAR(255) | NOT NULL | 图书标题 |
| author | VARCHAR(255) | NOT NULL | 作者 |
| isbn | VARCHAR(255) | UNIQUE | ISBN编号 |
| publish_date | VARCHAR(255) |  | 出版日期 |

#### 读者表 (reader)
| 字段名 | 类型 | 约束 | 描述 |
|--------|------|------|------|
| id | BIGINT | PRIMARY KEY, AUTO_INCREMENT | 读者ID |
| name | VARCHAR(255) | NOT NULL | 读者姓名 |
| email | VARCHAR(255) | UNIQUE | 邮箱 |
| phone | VARCHAR(255) |  | 电话 |
| address | VARCHAR(255) |  | 地址 |

### 实体类设计

#### Book实体类
- `id`: 主键，使用@GeneratedValue(strategy = GenerationType.IDENTITY)生成自增ID
- `title`: 图书标题，映射到title字段
- `author`: 作者，映射到author字段
- `isbn`: ISBN编号，映射到isbn字段
- `publishDate`: 出版日期，映射到publish_date字段

#### Reader实体类
- `id`: 主键，使用@GeneratedValue(strategy = GenerationType.IDENTITY)生成自增ID
- `name`: 读者姓名，映射到name字段
- `email`: 邮箱，映射到email字段
- `phone`: 电话，映射到phone字段
- `address`: 地址，映射到address字段

## 项目结构
```
src/
├── main/
│   ├── java/
│   │   └── com/library/demo/
│   │       ├── LibraryApplication.java
│   │       ├── entity/
│   │       │   ├── Book.java
│   │       │   └── Reader.java
│   │       ├── repository/
│   │       │   ├── BookRepository.java
│   │       │   └── ReaderRepository.java
│   │       ├── service/
│   │       │   ├── BookService.java
│   │       │   ├── ReaderService.java
│   │       │   └── impl/
│   │       │       ├── BookServiceImpl.java
│   │       │       └── ReaderServiceImpl.java
│   │       └── controller/
│   │           ├── BookController.java
│   │           └── ReaderController.java
│   └── resources/
│       └── application.properties
└── test/
    └── java/
        └── com/library/demo/
```

## 运行项目
1. 确保已安装Java 8+和Maven
2. 确保MySQL数据库已安装并运行，默认数据库名为library_boot_test
3. 在application.properties文件中配置数据库连接信息（用户名、密码等）
4. 在项目根目录下执行`mvn clean install`
5. 执行`mvn spring-boot:run`启动项目
6. 访问`http://localhost:8080`

## API设计

### 图书管理API

| 接口描述 | 请求方式 | 请求路径 | 请求参数 | 响应内容 |
|---------|---------|---------|---------|---------|
| 添加图书 | POST | /api/books | Book对象 | 操作结果 |
| 查询所有图书 | GET | /api/books | 无 | 图书列表 |
| 根据ID查询图书 | GET | /api/books/{id} | 图书ID | 图书信息 |
| 更新图书信息 | PUT | /api/books/{id} | 图书ID, Book对象 | 操作结果 |
| 删除图书 | DELETE | /api/books/{id} | 图书ID | 操作结果 |

#### 图书API详情

**添加图书**
- 请求URL: `POST /api/books`
- 请求示例:
```json
{
  "title": "Java编程思想",
  "author": "Bruce Eckel",
  "isbn": "9787111213826",
  "publishDate": "2007-06-01"
}
```
- 响应示例:
```json
{
  "id": 1,
  "title": "Java编程思想",
  "author": "Bruce Eckel",
  "isbn": "9787111213826",
  "publishDate": "2007-06-01"
}
```

**查询所有图书**
- 请求URL: `GET /api/books`
- 响应示例:
```json
[
  {
    "id": 1,
    "title": "Java编程思想",
    "author": "Bruce Eckel",
    "isbn": "9787111213826",
    "publishDate": "2007-06-01"
  }
]
```

**根据ID查询图书**
- 请求URL: `GET /api/books/1`
- 响应示例:
```json
{
  "id": 1,
  "title": "Java编程思想",
  "author": "Bruce Eckel",
  "isbn": "9787111213826",
  "publishDate": "2007-06-01"
}
```

**更新图书信息**
- 请求URL: `PUT /api/books/1`
- 请求示例:
```json
{
  "title": "Java编程思想(第4版)",
  "author": "Bruce Eckel",
  "isbn": "9787111213826",
  "publishDate": "2007-06-01"
}
```
- 响应示例:
```json
{
  "id": 1,
  "title": "Java编程思想(第4版)",
  "author": "Bruce Eckel",
  "isbn": "9787111213826",
  "publishDate": "2007-06-01"
}
```

**删除图书**
- 请求URL: `DELETE /api/books/1`
- 响应: HTTP状态码204

### 读者管理API

| 接口描述 | 请求方式 | 请求路径 | 请求参数 | 响应内容 |
|---------|---------|---------|---------|---------|
| 添加读者 | POST | /api/readers | Reader对象 | 操作结果 |
| 查询所有读者 | GET | /api/readers | 无 | 读者列表 |
| 根据ID查询读者 | GET | /api/readers/{id} | 读者ID | 读者信息 |
| 更新读者信息 | PUT | /api/readers/{id} | 读者ID, Reader对象 | 操作结果 |
| 删除读者 | DELETE | /api/readers/{id} | 读者ID | 操作结果 |

#### 读者API详情

**添加读者**
- 请求URL: `POST /api/readers`
- 请求示例:
```json
{
  "name": "张三",
  "email": "zhangsan@example.com",
  "phone": "13800138000",
  "address": "北京市朝阳区"
}
```
- 响应示例:
```json
{
  "id": 1,
  "name": "张三",
  "email": "zhangsan@example.com",
  "phone": "13800138000",
  "address": "北京市朝阳区"
}
```

**查询所有读者**
- 请求URL: `GET /api/readers`
- 响应示例:
```json
[
  {
    "id": 1,
    "name": "张三",
    "email": "zhangsan@example.com",
    "phone": "13800138000",
    "address": "北京市朝阳区"
  }
]
```

**根据ID查询读者**
- 请求URL: `GET /api/readers/1`
- 响应示例:
```json
{
  "id": 1,
  "name": "张三",
  "email": "zhangsan@example.com",
  "phone": "13800138000",
  "address": "北京市朝阳区"
}
```

**更新读者信息**
- 请求URL: `PUT /api/readers/1`
- 请求示例:
```json
{
  "name": "张三丰",
  "email": "zhangsanfeng@example.com",
  "phone": "13800138000",
  "address": "北京市朝阳区"
}
```
- 响应示例:
```json
{
  "id": 1,
  "name": "张三丰",
  "email": "zhangsanfeng@example.com",
  "phone": "13800138000",
  "address": "北京市朝阳区"
}
```

**删除读者**
- 请求URL: `DELETE /api/readers/1`
- 响应: HTTP状态码204

## 使用Apifox调试接口
1. 下载并安装Apifox
2. 导入项目API文档
3. 直接调用各接口测试功能

## 使用Postman调试接口
1. 下载并安装Postman
2. 创建新请求
3. 设置请求方法和URL
4. 如需要，在Body中添加JSON数据
5. 点击Send按钮发送请求
6. 查看响应结果