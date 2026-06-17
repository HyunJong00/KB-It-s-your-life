package org.scoula.jdbc_ex.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
// getter, setter, ToString, EqualsAndhasCode 한번에
// setter 유의 필요
@AllArgsConstructor
@NoArgsConstructor
public class UserVO {
    private String id;
    private String password;
    private String name;
    private String role;
}

