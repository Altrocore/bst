package com.clover.dto;

import com.clover.model.TreeEntity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TreeDTO {
    private Long id;
    private String name;
    private String species;
    private Integer age;
    private List<Integer> numbers;
    private String treeJson;

    public TreeDTO() {
    }

    public TreeDTO(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public TreeDTO(TreeEntity treeEntity) {
        this.id = treeEntity.getId();
        this.numbers = treeEntity.getNumbers();
        this.treeJson = treeEntity.getTreeJson();
    }

    @Override
    public String toString() {
        return "TreeDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", species='" + species + '\'' +
                ", age=" + age +
                ", numbers=" + numbers +
                ", treeJson='" + treeJson + '\'' +
                '}';
    }
}
