package com.clover.controller;

import com.clover.dto.TreeDTO;
import com.clover.model.BinarySearchTree;
import com.clover.model.TreeEntity;
import com.clover.repository.TreeRepository;
import com.clover.service.TreeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class TreeController {

    private final TreeService treeService;
    private final TreeRepository treeRepository;


    public TreeController(TreeService treeService, TreeRepository treeRepository) {
        this.treeService = treeService;
        this.treeRepository = treeRepository;
    }

    @PostMapping("/enter-numbers")
    public ResponseEntity<String> createTree(@RequestBody List<Integer> numbers) throws IOException {
        BinarySearchTree bst = treeService.createTree(numbers);
        TreeEntity treeEntity = new TreeEntity(numbers, bst.toJson());
        treeEntity = treeRepository.save(treeEntity);
        ObjectMapper mapper = new ObjectMapper();
        String treeJson = mapper.writeValueAsString(new TreeDTO(treeEntity));
        return ResponseEntity.ok(treeJson);
    }

    @GetMapping("/input")
    public String showInputPage() {
        return "forward:/index.html";
    }

    @PostMapping("/process-numbers")
    public ResponseEntity<String> processNumbers(@RequestBody List<Integer> numbers) {
        BinarySearchTree bst = treeService.createTree(numbers);
        TreeEntity treeEntity = new TreeEntity(numbers, bst.toJson());
        treeRepository.save(treeEntity);
        return ResponseEntity.ok(bst.toJson());
    }

    @GetMapping("/previous-trees")
    public ResponseEntity<?> getPreviousTrees() {
        return ResponseEntity.ok(treeService.getPreviousTrees());
    }

    @GetMapping("/trees")
    public ResponseEntity<List<TreeDTO>> getAllTrees() {
        List<TreeDTO> trees = treeService.getAllTrees();
        return ResponseEntity.ok(trees);
    }

}

