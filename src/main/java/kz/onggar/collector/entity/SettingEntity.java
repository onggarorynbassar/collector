package kz.onggar.collector.entity;


import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.UUID;


@Entity
@Table(schema = "collector", name = "settings")
@Accessors(fluent = true)
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SettingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String name;
}
