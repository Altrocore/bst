package com.clover.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TreeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ElementCollection
    private List<Integer> numbers;

    @Lob
    private String treeJson;

    public TreeEntity(List<Integer> numbers, String treeJson) {
        this.numbers = numbers;
        this.treeJson = treeJson;
    }
}
