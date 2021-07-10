package xyz.nhatbao.ninetour.model.request;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

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

@EqualsAndHashCode(callSuper = true)
@Data
public class RoleRequestModel extends BaseRequestModel<RoleRequestModel> {
    private String roleKey;
    private String roleName;
    private Byte permissionLevel;

    private List<UserRequestModel> users = new ArrayList<>();

    private List<PermissionRequestModel> permissions = new ArrayList<>();
}
