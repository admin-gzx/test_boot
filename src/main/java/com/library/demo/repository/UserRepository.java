package com.library.demo.repository;

// 由于报错提示无法解析 User 类，需要确认 User 类是否存在于 com.library.demo.entity 包下。
// 若 User 类存在，请检查拼写和包路径是否正确；若不存在，需要创建该类。
// 这里假设已正确创建 User 类，保留原导入语句
import com.library.demo.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

}
