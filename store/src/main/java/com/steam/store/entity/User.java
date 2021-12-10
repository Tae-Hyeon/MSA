package com.steam.store.entity;

import com.steam.store.dto.GameVO;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Builder
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "asset")
    private Integer asset;

    @Column(name = "role")
    private String role;

    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY)
    List<Library> libraries;

    public void pay(List<GameVO> games) {
        for(GameVO game : games)
            this.asset -= game.getPrice();
    }
}
