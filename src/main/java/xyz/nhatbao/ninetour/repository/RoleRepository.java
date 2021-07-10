package xyz.nhatbao.ninetour.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.nhatbao.ninetour.entity.Role;

/*******************************************************************************
 <pre>

 Copyright (c) 2021 Nguyen Nhat Bao
 This project is licensed under the terms of the MIT license.

 Author: Nguyen Nhat Bao (Kian Nguyen)
 Website: https://kiandev.xyz
 Contact for work: kiannguyen.work@gmail.com
 Feedback to me: kiannguyen.dev@gmail.com
 Github: https://github.com/kian-nguyen

 Please do not remove.

 </pre>
 ******************************************************************************/

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findAllByRoleKey(String roleKey);
}
