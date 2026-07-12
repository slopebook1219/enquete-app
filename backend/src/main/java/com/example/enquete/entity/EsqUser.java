package com.example.enquete.entity;

import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;
import lombok.Data; // これが重要！
import lombok.NoArgsConstructor;

@Entity
@Table(name = "esq_user")
@Data // Getter, Setter, toString, hashCode, equals を全部自動生成
@NoArgsConstructor // 引数なしコンストラクタを自動生成
public class EsqUser {

    @Id
    private String esqId;

    private Integer deptId;

    private String userName;

    private String password;
}
