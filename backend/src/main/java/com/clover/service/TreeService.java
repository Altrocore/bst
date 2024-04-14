package com.clover.service;

import com.clover.dto.TreeDTO;
import com.clover.model.BinarySearchTree;
import com.clover.model.TreeEntity;
import com.clover.repository.TreeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TreeService {

    private final TreeRepository treeRepository;

    public TreeService(TreeRepository treeRepository) {
        this.treeRepository = treeRepository;
    }

    public BinarySearchTree createTree(List<Integer> numbers) {
        BinarySearchTree bst = new BinarySearchTree();
        numbers.forEach(bst::insert);
        return bst;
    }


    public List<TreeDTO> getPreviousTrees() {
        List<TreeEntity> treeEntities = treeRepository.findAll();

        return treeEntities.stream().map(treeEntity -> {
            TreeDTO treeDTO = new TreeDTO();
            treeDTO.setNumbers(treeEntity.getNumbers());
            return treeDTO;
        }).collect(Collectors.toList());
    }

    public List<TreeDTO> getAllTrees() {
        return treeRepository.findAll().stream()
                .map(TreeDTO::new)
                .collect(Collectors.toList());
    }
}